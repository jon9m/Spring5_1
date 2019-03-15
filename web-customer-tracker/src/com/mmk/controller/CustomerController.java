package com.mmk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmk.dao.CustomerDAO;
import com.mmk.entity.Customer;
import com.mmk.service.CustomerService;

@Controller
@RequestMapping("/customer")
//@RequestMapping(path = "/customer", method = RequestMethod.GET)
public class CustomerController {

	// Inject DAO to controller
	@Autowired
//	private CustomerDAO customerDAO;
	private CustomerService customerService;

//	@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model model) {
//		List<Customer> customers = customerDAO.getCustomers();
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);

		return "list-customers";
	}
}