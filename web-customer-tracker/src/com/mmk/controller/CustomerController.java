package com.mmk.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(String customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(Model model, HttpServletRequest request, HttpServletResponse response) {
		String customerId = request.getParameter("customerId");

		Customer customer = customerService.getCustomerById(customerId);
		model.addAttribute("customer", customer);
		return "customer-form";
	}
}
