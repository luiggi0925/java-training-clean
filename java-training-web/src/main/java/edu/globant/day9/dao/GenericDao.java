package edu.globant.day9.dao;

import java.util.List;

import edu.globant.day9.domain.BaseEntity;

public interface GenericDao<T extends BaseEntity> {

	void save(T entity);
	T findById(Long id);
	void update(T entity);
	void delete(T entity);
	List<T> findAll();

}
