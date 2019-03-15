package com.mmk.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mmk.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Need to inject session Factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
//	@Transactional(value=TxType.MANDATORY)						- move to Service layer
//	@Transactional 												- move to Service layer
	public List<Customer> getCustomers() {

		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Create a query
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);

		// get result
		List<Customer> customers = query.getResultList();

		return customers;
	}
}
