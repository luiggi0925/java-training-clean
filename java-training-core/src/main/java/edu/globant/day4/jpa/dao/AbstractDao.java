package edu.globant.day4.jpa.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import edu.globant.day4.jpa.domain.BaseEntity;

public abstract class AbstractDao<T extends BaseEntity> implements GenericDao<T> {

	protected EntityManager em;
	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractDao(EntityManager em) {
		this.em = em;
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

	/* (non-Javadoc)
	 * @see edu.globant.day4.jpa.dao.GenericDao2#save(T)
	 */
	@Override
	public void save(T entity) {
		em.persist(entity);
	}

	/* (non-Javadoc)
	 * @see edu.globant.day4.jpa.dao.GenericDao2#findById(java.lang.Long)
	 */
	@Override
	public T findById(Long id) {
		return em.find(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see edu.globant.day4.jpa.dao.GenericDao2#update(T)
	 */
	@Override
	public void update(T entity) {
		em.refresh(entity);
	}

	/* (non-Javadoc)
	 * @see edu.globant.day4.jpa.dao.GenericDao2#delete(T)
	 */
	@Override
	public void delete(T entity) {
		em.remove(entity);
	}

	/* (non-Javadoc)
	 * @see edu.globant.day4.jpa.dao.GenericDao2#findAll()
	 */
	@Override
	public List<T> findAll() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(entityClass);
		Root<T> root = criteria.from(entityClass);
		criteria.select(root);
		return em.createQuery(criteria).getResultList();
	}

	public final void evict(BaseEntity object) {
		em.detach(object);
	}

	public final T merge(T object) {
		return entityClass.cast(em.merge(object));
	}
}
