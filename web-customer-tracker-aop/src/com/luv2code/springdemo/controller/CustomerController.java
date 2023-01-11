package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.util.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject the DAO into the controller
	// @Autowired
	// private CustomerDAO customerDAO;
	
	@Autowired
	// spring handles the injection of customerService
	private CustomerService customerService;
	
	// we did refactoring of RequestMethod
	// @RequestMapping("/list")
	@GetMapping("/list")
	// This method should only respond to get request via the browser...
	public String listCustomers(Model theModel, @RequestParam(required=false) String sort) {
		
		// get the customers from the service
		List<Customer> theCustomers = null;
		
		// check for sort field
		if(sort != null) {
			int theSortField = Integer.parseInt(sort);
			theCustomers = customerService.getCustomers(theSortField);
		}else {
			// no sort filed provided... default to sorting...by last name
			theCustomers = customerService.getCustomers(SortUtils.LAST_NAME);
			
		}
		
		// add the customer to spring MVC model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		// view configuration, view handler...
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using the service layer
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
		
		// get the customer from the service and which delegates to DAO and then to Hibernate DB...
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set the customer as a model attribute and pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String showFormForDelete(@RequestParam("customerId") int theId, Model theModel) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		
		// search customer from the service
		List<Customer> theCustomer = customerService.searchCustomers(theSearchName);
		
		// add the customers to the model...
		theModel.addAttribute("customers", theCustomer);
		
		return "list-customers";
	}
}
