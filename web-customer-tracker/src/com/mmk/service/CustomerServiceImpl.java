package com.mmk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmk.dao.CustomerDAO;
import com.mmk.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// Inject Customer DAO

	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	@Override
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Transactional
	@Override
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Transactional
	@Override
	public Customer getCustomerById(String customerId) {
		int custId = Integer.parseInt(customerId);
		return customerDAO.getCustomerById(custId);
	}

	@Transactional
	@Override
	public void deleteCustomer(String customerId) {
		int custId = Integer.parseInt(customerId);
		customerDAO.deleteCustomer(custId);		
	}

}
