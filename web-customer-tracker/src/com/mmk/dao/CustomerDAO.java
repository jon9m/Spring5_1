package com.mmk.dao;

import java.util.List;

import com.mmk.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int customerId);

	public void deleteCustomer(int custId);
}
