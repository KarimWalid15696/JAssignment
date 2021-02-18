package com.PhoneNumbers.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.PhoneNumbers.springboot.model.Customer;
import com.PhoneNumbers.springboot.service.CustomerService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController
{
    //Service object 
	@Autowired
	private CustomerService customerService;
	@GetMapping("customers")
	//api to get all customers in DB
	public List<Customer> getCustomers()
	{
		return customerService.findAll();
	}
	@GetMapping("customers/hello")
	public String getHelloWorld() {
		return "Hello world";
	}
	@GetMapping("customers/country")
	@ResponseBody
	//api to get all customers in DB for a certain Country or Country Code
	public List<Customer> getCountryCustomers(@RequestParam String country)
	{
		
		return this.customerService.getCountryCustomers(country);
		
	}
	//api to get all customers in DB with a certain state
	@GetMapping("customers/valid")
	@ResponseBody
	public List<Customer> getValidCustomers(@RequestParam String valid)
	{
		return this.customerService.getValidOrInvalidCustomers(valid);
	}
	
}
	
