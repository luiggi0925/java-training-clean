package edu.globant.day4.hibernate;

import static java.util.Arrays.asList;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.globant.day4.hibernate.dao.ContactDao;
import edu.globant.day4.hibernate.dao.ContactDetailTypeDao;
import edu.globant.day4.hibernate.domain.Contact;
import edu.globant.day4.hibernate.domain.ContactDetail;
import edu.globant.day4.hibernate.domain.ContactDetailType;
import edu.globant.utils.DataSourceProvider;
import edu.globant.utils.DateUtils;
import edu.globant.utils.MySQLDataSourceProvider;

public class ContactDemo {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactDemo.class);

	private static final String configurationPath = "/edu/globant/day4/config/database.properties";
	private static final String hibernateConfigXml = "/edu/globant/day4/config/hibernate.cfg.xml";

	public static void main(String[] args) {
		DataSourceProvider dsProvider = new MySQLDataSourceProvider();
		try (SessionFactory sessionFactory = HibernateUtils.buildSessionFactory(hibernateConfigXml,
				dsProvider.getDataSource(configurationPath))) {
			try (Scanner scanner = new Scanner(System.in)) {
				ContactDemo contactDemo = new ContactDemo(scanner, sessionFactory);
				while (contactDemo.isLive()) {
					int option = contactDemo.showMenuAndGetOption();
					contactDemo.evaluateOption(option);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Something terrible happened.", e);
		}
	}

	private Scanner scanner;
	private SessionFactory sessionFactory;
	private boolean live = true;

	public ContactDemo(Scanner scanner, SessionFactory sessionFactory) {
		this.scanner = scanner;
		this.sessionFactory = sessionFactory;
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
		try (Session session = sessionFactory.openSession()) {
			ContactDao contactDao = new ContactDao(session);
			List<Contact> contactList = contactDao.findAll();
			if (contactList.isEmpty()) {
				System.out.println("No contacts registered.");
			} else {
				for (Contact contact : contactList) {
					System.out.println("First Name: " + contact.getFirstName());
					System.out.println("Last Name: " + contact.getLastName());
					System.out.println("Birthday: " + DateUtils.formatDate(contact.getBirthday()));
					System.out.println("Contact info:");
					for (ContactDetail contactDetail : contact.getContactDetailList()) {
						System.out.println(String.format("%s: %s.",
								contactDetail.getContactDetailType().getDescription(),
								contactDetail.getDetails()));
					}
					System.out.println("-------------------------------------------");
				}
			}
		}
	}

	public Optional<ContactDetail> generateContactDetailType(Session session) {
		ContactDetail result = new ContactDetail();
		System.out.println("List of contact detail type: ");
		ContactDetailTypeDao contactDetailTypeDao = new ContactDetailTypeDao(session);
		Map<Long, ContactDetailType> contactDetailTypeMap = contactDetailTypeDao.getContactDetailTypeSorted();
		for (ContactDetailType contactDetailType : contactDetailTypeMap.values()) {
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
		try (Session session = sessionFactory.openSession()) {
			Transaction t = session.beginTransaction();
			try {
				ContactDao contactDao = new ContactDao(session);
				Contact contact = new Contact();

				System.out.print("Provide first name: ");
				contact.setFirstName(scanner.nextLine());
				System.out.print("Provide last name: ");
				contact.setLastName(scanner.nextLine());
				System.out.print("Provide birthday: ");
				contact.setBirthday(DateUtils.parseDate(scanner.nextLine())); //yyyy-MM-dd
				contact.setCreationDate(new Date());

				Optional<ContactDetail> contactDetail = generateContactDetailType(session);
				contactDetail.ifPresent(conDet -> {
					contact.setContactDetailList(asList(conDet));
					conDet.setContact(contact);
				});

				contactDao.save(contact);
				t.commit();
			} catch (Exception e) {
				LOGGER.error("Error when creating new contact.", e);
				t.rollback();
			}
		}
	}

	public void exit() {
		live = false;
		System.out.println("Thanks for using this application.");
	}
}
