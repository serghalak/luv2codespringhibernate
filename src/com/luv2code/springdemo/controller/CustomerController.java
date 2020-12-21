package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerDao customerDao;	
	
	public CustomerController(CustomerDao customerDao) {		
		this.customerDao = customerDao;
	}


	@RequestMapping("/list")
	public String listCustomers(Model theModel) {		
		List<Customer>listCustomer=customerDao.getCustomers();
		
		theModel.addAttribute("customers",listCustomer);
		System.out.println(listCustomer);
		return "list-customers";
	}

}
