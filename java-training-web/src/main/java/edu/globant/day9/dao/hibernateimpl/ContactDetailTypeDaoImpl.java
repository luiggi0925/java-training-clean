package edu.globant.day9.dao.hibernateimpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.Session;

import edu.globant.day9.dao.ContactDetailTypeDao;
import edu.globant.day9.domain.ContactDetailType;

public class ContactDetailTypeDaoImpl extends AbstractDao<ContactDetailType> implements ContactDetailTypeDao {

	public ContactDetailTypeDaoImpl(Session session) {
		super(session);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.globant.day9.dao.ContactDetailTypeDao#getContactDetailTypeSorted()
	 */
	@Override
	public Map<Long, ContactDetailType> getContactDetailTypeSorted() {
		List<ContactDetailType> list = session
				.createQuery("FROM ContactDetailType ORDER BY id", ContactDetailType.class).getResultList();
		return list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x, (u, v) -> null, LinkedHashMap::new));
	}
}
