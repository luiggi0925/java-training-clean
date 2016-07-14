package edu.globant.day4.hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import edu.globant.day4.hibernate.domain.BaseEntity;

public class AbstractDao<T extends BaseEntity> {

	protected Session session;
	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractDao(Session session) {
		this.session = session;
		Type type = getClass().getGenericSuperclass();
		while (!(type instanceof ParameterizedType) || ((ParameterizedType) type).getRawType() != AbstractDao.class) {
			if (type instanceof ParameterizedType) {
				type = ((Class<?>) ((ParameterizedType) type).getRawType()).getGenericSuperclass();
			} else {
				type = ((Class<?>) type).getGenericSuperclass();
			}
		}
		entityClass = (Class<T>)((ParameterizedType) type).getActualTypeArguments()[0];
	}

	public void save(T entity) {
		session.save(entity);
	}

	public T findById(Long id) {
		return session.find(entityClass, id);
	}

	public void update(T entity) {
		session.update(entity);
	}

	public void delete(T entity) {
		session.delete(entity);
	}

	public List<T> findAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(entityClass);
		Root<T> root = criteria.from(entityClass);
		criteria.select(root);
		return session.createQuery(criteria).getResultList();
	}

	public final void evict(BaseEntity object) {
		session.evict(object);
	}

	public final T merge(T object) {
		return entityClass.cast(session.merge(object));
	}
}
