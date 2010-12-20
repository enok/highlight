package br.com.highligth.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.highligth.models.Codeshare;

public interface CodeshareRepository {
	/*
	 * Delete the methods you don't want to expose
	 */
	
	Session session();
	
	void create(Codeshare entity);
	
	void update(Codeshare entity);
	
	void destroy(Codeshare entity);
	
	Codeshare find(Long id);
	
	List<Codeshare> findAll();

	List<Codeshare> findByCriteria(Criteria criteria);
	
	@SuppressWarnings("hiding")
	<Codeshare extends Serializable> Codeshare uniqueResult(Criteria criteria);
	
}
