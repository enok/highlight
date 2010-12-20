package br.com.highligth.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

public abstract class Repository<T, I extends Serializable> {
	
	protected final EntityManager entityManager;
	
	public Repository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Session session() {
		return (Session) this.entityManager.getDelegate();
	}
	
	public void create(T entity) {
		entityManager.persist(entity);
	}
	
	public void update(T entity) {
		entityManager.merge(entity);
	}
	
	public void destroy(T entity) {
		entityManager.remove(entity);
	}
	
	public T find(I id) {
		return entityManager.find(getParameterizedClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("From " + getParameterizedClass().getName()).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Criteria criteria){
		return criteria.list();
	}
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T extends Serializable> T uniqueResult(Criteria criteria) {
		return (T) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getParameterizedClass() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

}
