package edu.globant.day4.jpa;

import static java.util.Arrays.asList;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.globant.day4.jpa.dao.ContactDao;
import edu.globant.day4.jpa.dao.ContactDaoImpl;
import edu.globant.day4.jpa.dao.ContactDetailTypeDao;
import edu.globant.day4.jpa.dao.ContactDetailTypeDaoImpl;
import edu.globant.day4.jpa.domain.ContactJpa;
import edu.globant.day4.jpa.domain.ContactDetailJpa;
import edu.globant.day4.jpa.domain.ContactDetailTypeJpa;
import edu.globant.utils.DateUtils;
import edu.globant.utils.MySQLDataSourceProvider;

public class ContactDemoJpa {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactDemoJpa.class);

	private static final String configurationPath = "/edu/globant/day4/config/database.properties";
	private static final String persistenceUnitName = "jpa-demo";

	public static void main(String[] args) {
		MySQLDataSourceProvider dsProvider = new MySQLDataSourceProvider();
		EntityManagerFactory emf = null;
		try {
			emf = JpaUtils.getEntityManagerFactory(persistenceUnitName, dsProvider.getDataSource(configurationPath));
			try (Scanner scanner = new Scanner(System.in)) {
				ContactDemoJpa contactDemo = new ContactDemoJpa(scanner, emf);
				while (contactDemo.isLive()) {
					int option = contactDemo.showMenuAndGetOption();
					contactDemo.evaluateOption(option);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Something terrible happened.", e);
		} finally {
			if (emf != null) {
				emf.close();
			}
		}
	}

	private Scanner scanner;
	private EntityManagerFactory emf;
	private boolean live = true;

	public ContactDemoJpa(Scanner scanner, EntityManagerFactory emf) {
		this.scanner = scanner;
		this.emf = emf;
	}

	public boolean isLive() {
		return live;
	}

	public int showMenuAndGetOption() {
		System.out.println("***********************************");
		System.out.println("Option list:");
		System.out.println("1. Show contacts");
		System.out.println("2. Create new contact");
		System.out.println("3. Exit");
		System.out.print("Choose your option: ");
		int result = scanner.nextInt();
		scanner.nextLine();
		return result;
	}

	public void evaluateOption(int option) {
		switch (option) {
		case 1:
			showContacts();
			break;
		case 2:
			createNewContact();
			break;
		case 3:
			exit();
			break;
		}
	}

	public void showContacts() {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			ContactDao contactDao = new ContactDaoImpl(em);
			List<ContactJpa> contactList = contactDao.findAll();
			if (contactList.isEmpty()) {
				System.out.println("No contacts registered.");
			} else {
				for (ContactJpa contact : contactList) {
					System.out.println("First Name: " + contact.getFirstName());
					System.out.println("Last Name: " + contact.getLastName());
					System.out.println("Birthday: " + DateUtils.formatDate(contact.getBirthday()));
					System.out.println("Contact info:");
					for (ContactDetailJpa contactDetail : contact.getContactDetailList()) {
						System.out.println(String.format("%s: %s.",
								contactDetail.getContactDetailType().getDescription(),
								contactDetail.getDetails()));
					}
					System.out.println("-------------------------------------------");
				}
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public Optional<ContactDetailJpa> generateContactDetailType(EntityManager em) {
		ContactDetailJpa result = new ContactDetailJpa();
		System.out.println("List of contact detail type: ");
		ContactDetailTypeDao contactDetailTypeDao = new ContactDetailTypeDaoImpl(em);
		Map<Long, ContactDetailTypeJpa> contactDetailTypeMap = contactDetailTypeDao.getContactDetailTypeSorted();
		for (ContactDetailTypeJpa contactDetailType : contactDetailTypeMap.values()) {
			System.out.println(String.format("%d. %s.", contactDetailType.getId(), contactDetailType.getDescription()));
		}
		System.out.print("Choose one: ");
		long choice = scanner.nextLong();
		scanner.nextLine();
		if (contactDetailTypeMap.containsKey(choice)) {
			result.setContactDetailType(contactDetailTypeMap.get(choice));
			System.out.print("Enter details: ");
			result.setDetails(scanner.nextLine());
		}
		return Optional.of(result);
	}

	public void createNewContact() {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			try {
				ContactDao contactDao = new ContactDaoImpl(em);
				ContactJpa contact = new ContactJpa();

				System.out.print("Provide first name: ");
				contact.setFirstName(scanner.nextLine());
				System.out.print("Provide last name: ");
				contact.setLastName(scanner.nextLine());
				System.out.print("Provide birthday: ");
				contact.setBirthday(DateUtils.parseDate(scanner.nextLine())); //yyyy-MM-dd
				contact.setCreationDate(new Date());

				Optional<ContactDetailJpa> contactDetail = generateContactDetailType(em);
				contactDetail.ifPresent(x -> {
					contact.setContactDetailList(asList(x));
					x.setContact(contact);
				});

				contactDao.save(contact);
				em.getTransaction().commit();
			} catch (Exception e) {
				LOGGER.error("Error when creating new contact.", e);
				if (em != null) {
					em.getTransaction().rollback();
				}
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void exit() {
		live = false;
		System.out.println("Thanks for using this application.");
	}
}
