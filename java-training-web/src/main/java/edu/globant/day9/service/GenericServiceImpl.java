package edu.globant.day9.service;

import java.util.List;

import edu.globant.day9.dao.GenericDao;
import edu.globant.day9.domain.BaseEntity;

public abstract class GenericServiceImpl<T extends BaseEntity> implements GenericService<T> {

	public abstract GenericDao<T> getDao();

	@Override
	public void save(T entity) {
		getDao().save(entity);
	}

	@Override
	public T findById(Long id) {
		return getDao().findById(id);
	}

	@Override
	public void update(T entity) {
		getDao().update(entity);
	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}
}
