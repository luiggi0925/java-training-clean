package edu.globant.day4.jpa.dao;

import java.util.List;

import edu.globant.day4.jpa.domain.BaseEntity;

public interface GenericDao<T extends BaseEntity> {

	void save(T entity);

	T findById(Long id);

	void update(T entity);

	void delete(T entity);

	List<T> findAll();

}