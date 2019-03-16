package com.mmk.service;

import java.util.List;

import com.mmk.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(String customerId);

	public void deleteCustomer(String customerId);
}
