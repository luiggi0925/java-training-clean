package edu.globant.day4.hibernate.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.Session;

import edu.globant.day4.hibernate.domain.ContactDetailType;

public class ContactDetailTypeDao extends AbstractDao<ContactDetailType> {

	public ContactDetailTypeDao(Session session) {
		super(session);
	}

	public Map<Long, ContactDetailType> getContactDetailTypeSorted() {
		List<ContactDetailType> list = session.createQuery("FROM ContactDetailType ORDER BY id", ContactDetailType.class)
				.getResultList();
		return list.stream()
			.collect(Collectors.toMap(x -> x.getId(), x -> x, (u,v) -> null, LinkedHashMap::new));
	}
}
