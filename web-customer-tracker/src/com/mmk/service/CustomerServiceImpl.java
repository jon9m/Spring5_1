package com.mmk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmk.dao.CustomerDAO;
import com.mmk.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//Inject Customer DAO
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

}
