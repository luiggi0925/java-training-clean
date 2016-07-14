package edu.globant.day4.jpa.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import edu.globant.day4.jpa.domain.ContactDetailTypeJpa;

public class ContactDetailTypeDaoImpl extends AbstractDao<ContactDetailTypeJpa>
	implements ContactDetailTypeDao {

	public ContactDetailTypeDaoImpl(EntityManager em) {
		super(em);
	}

	public Map<Long, ContactDetailTypeJpa> getContactDetailTypeSorted() {
		List<ContactDetailTypeJpa> list = em.createQuery("SELECT cdt FROM contactDetailType cdt ORDER BY id", ContactDetailTypeJpa.class)
				.getResultList();
		return list.stream()
			.collect(Collectors.toMap(x -> x.getId(), x -> x, (u,v) -> null, LinkedHashMap::new));
	}
}
