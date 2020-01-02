package com.springboot.thymeleafdemo.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.thymeleafdemo.entity.Employee;

@Repository
public class MojaKlasaZaDAOMetodeImpl implements MojInterfejsZaDAOMetode {

	//define field for entityManager
	private EntityManager entityManager;
		
	//set up constructor injection
	@Autowired
	public MojaKlasaZaDAOMetodeImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public void saveOrUpdateEmployee(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);	
	}

}
