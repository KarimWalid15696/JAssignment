package com.PhoneNumbers.springboot.test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import  org.junit.Assert;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.PhoneNumbers.springboot.model.Customer;
import com.PhoneNumbers.springboot.repository.CustomerRepository;
import com.PhoneNumbers.springboot.service.CustomerService;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CustomerService.class})
class PhoneNumbersApplicationTests {
	
	
	@MockBean
	CustomerRepository customerRepository;
	@Autowired
	CustomerService customerService;
	
	 

	@Test
	void findAllTest() throws Exception
	{
		
		//testing empty list for a findAll
		Mockito.when(customerRepository.findAll()).thenReturn(Collections.emptyList());	
		List<Customer> customers=customerService.findAll();
		assertEquals(0, customers.size());	
		
		//testing findAll customers when it includes data
		Customer customer1 = new Customer("Karim","02584",null,null);
		Customer customer2 = new Customer("Karim","025484",null,null);
		Customer customer3 = new Customer("Karim","0258344",null,null);
		List<Customer> list = new ArrayList<Customer>();
		list.add(customer1);
		list.add(customer2);
		list.add(customer3);
		Mockito.when(customerRepository.findAll()).thenReturn(list);
		customers=customerService.findAll();
		//testing size
		assertEquals(3, customers.size());
		//testing the returned list
		assertEquals(list,customers);
		//testing the customers
		assertEquals(customer1,customers.get(0));
		assertEquals(customer2,customers.get(1));
		assertEquals(customer3,customers.get(2));
		
		////////////////////////////////////////////
		
		
	}
	@Test
	void getCountryCustomersTest() throws Exception
	{
		//Morocco starts with (212) testing is done for Morocco
		//Mozambique Number
		
		Customer customer1 = new Customer("Karim","(258)53331131",null,null);
		//Unknown Number
		Customer customer2 = new Customer("Karim","(234)53331131",null,null);
		//Mozambique Number
		Customer customer3 = new Customer("Karim","(258)53331131",null,null);
		//Morocco Number
		Customer customer4 = new Customer("Karim","(212)66173444",null,null);
		//Morocco Number
		Customer customer5 = new Customer("Karim","(212)54687422",null,null);
		//Adding Customers to a list
		
		List<Customer> list = new ArrayList<Customer>();
		list.add(customer1);
		list.add(customer2);
		list.add(customer3);
		list.add(customer4);
		list.add(customer5);
		
		Mockito.when(customerRepository.findAll()).thenReturn(list);
	
		//testing that it gets customers from Morocco,Phone Number starts with (212)
		List<Customer> customers=customerService.getCountryCustomers("Morocco");
		//test size
		assertEquals(2, customers.size());
		//test name
		assertEquals("Karim", customers.get(1).getName());
		//test country
		assertEquals("Morocco", customers.get(1).getCountry());
		//test phone number
		assertEquals("(212)54687422", customers.get(1).getPhone());
		
		////////////////////////////////////////////
		
		
	}
	@Test
	void getValidCustomers() throws Exception
	{

		//Valid Number
		Customer customer1 = new Customer("Karim","(212)633963130",null,null);
		//Valid Number
		Customer customer2 = new Customer("Yosaf Karrouch","(212)698054317",null,null);
		//Invalid Number
		Customer customer3 = new Customer("Tanvi Sachdeva","(258)84330678235",null,null);
		//Adding customers to list
		List<Customer> list = new ArrayList<Customer>();
		list.add(customer1);
		list.add(customer2);
		list.add(customer3);
		//
		Mockito.when(customerRepository.findAll()).thenReturn(list);
		//testing that it gets Valid Customers
		List<Customer> customers=customerService.getValidOrInvalidCustomers("Valid");
		//test size
		assertEquals(2, customers.size());
		//test name
		assertEquals("Karim", customers.get(0).getName());
		//test country
		assertEquals("Morocco", customers.get(0).getCountry());
		//test phone number
		assertEquals("(212)633963130", customers.get(0).getPhone());
		//test validity
		assertEquals("Valid", customers.get(0).getValid());

		
		
	}
	

}
