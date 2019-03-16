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

		// Create a query - ssort by last name
		Query<Customer> query = currentSession.createQuery("from Customer c order by c.lastName", Customer.class);

		// get result
		List<Customer> customers = query.getResultList();

		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
//		currentSession.save(customer);
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Customer.class, customerId);
	}

	@Override
	public void deleteCustomer(int custId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer cutomer = currentSession.get(Customer.class, custId);
		currentSession.delete(cutomer);
	}
}
