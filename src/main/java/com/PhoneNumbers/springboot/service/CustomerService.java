package com.PhoneNumbers.springboot.service;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PhoneNumbers.springboot.model.Customer;
import com.PhoneNumbers.springboot.repository.CustomerRepository;
//the customer Service implementation
@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	private CustomerRepository customerRepository; 
	@Override
	//get all customers
	public List<Customer> findAll() 
	{
		List<Customer> customers = this.customerRepository.findAll();
		getCustomerInfo(customers);
		return customers;
	}
	/* populate the customer info object before sending it to the front end ,
	 * here the country code is extracted first to check to which country this phone number belongs
	 * then a pattern regex is used to check whether or not the number is valid
	 */
	public static void getCustomerInfo(List<Customer> customers){
		for (Customer customer : customers) {
			String phone = customer.getPhone();
		//Country Code	
				String countryCode = phone.substring(1,4);
				switch (countryCode) {
				case "212": customer.setCountry("Morocco");
				customer.setCountryCode(countryCode);
				customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
				break;
				case "237": customer.setCountry("Cameroon");
				customer.setCountryCode(countryCode);
				customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
				break;
				case "251": customer.setCountry("Ethiopia");
				customer.setCountryCode(countryCode);
				customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
				break;
				case "258": customer.setCountry("Mozambique");
				customer.setCountryCode(countryCode);
				customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
				break;
				case "256": customer.setCountry("Uganda");
				customer.setCountryCode(countryCode);
				customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
				break;
				default : customer.setCountry("Unknown");
				customer.setValid("Not Valid");
				customer.setCountryCode(countryCode);
				customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
				break;
			

				}
		//Regex checking
				String regex;
				Pattern pattern;
				Matcher matcher;
				if(customer.getCountry()=="Morocco") {
					
					regex="\\(212\\)\\ ?[5-9]\\d{8}$";
					pattern=Pattern.compile(regex);
					
					matcher= pattern.matcher(customer.getPhone());
					if(matcher.matches()) {
						customer.setValid("Valid");
						
					}
					else {
						customer.setValid("Not Valid");
					}
					
				}
				else if(customer.getCountry()=="Cameroon")
				{
					regex="\\(237\\)\\ ?[2368]\\d{7,8}$";
					pattern=Pattern.compile(regex);
					
					matcher= pattern.matcher(customer.getPhone());
					if(matcher.matches()) {
						customer.setValid("Valid");
					}
					else {
						customer.setValid("Not Valid");
					}
					
				}
				else if(customer.getCountry()=="Ethiopia")
				{
					regex="\\(251\\)\\ ?[1-59]\\d{8}$";
					pattern=Pattern.compile(regex);
					
					matcher= pattern.matcher(customer.getPhone());
					if(matcher.matches()) {
						customer.setValid("Valid");
					}
					else {
						customer.setValid("Not Valid");
					}
					
				}
				else if(customer.getCountry()=="Mozambique")
				{
					regex="\\(258\\)\\ ?[28]\\d{7,8}$";
					pattern=Pattern.compile(regex);
					
					matcher= pattern.matcher(customer.getPhone());
					if(matcher.matches()) {
						customer.setValid("Valid");
					}
					else {
						customer.setValid("Not Valid");
					}
					
				}
				else if(customer.getCountry()=="Uganda")
				{
					regex="\\(256\\)\\ ?\\d{9}$";
					pattern=Pattern.compile(regex);
					
					matcher= pattern.matcher(customer.getPhone());
					if(matcher.matches()) {
						customer.setValid("Valid");
					}
					else {
						customer.setValid("Not Valid");
					}
					
				}
				else
				{
					customer.setValid("Not Valid");
				}
			
			
		}
	}
	//Get customers based on state
	@Override
	public List<Customer> getValidOrInvalidCustomers(String valid) {
		
		List<Customer> customers= this.customerRepository.findAll();
		getCustomerInfo(customers);
		Iterator<Customer> itr = customers.iterator(); 
		while (itr.hasNext()) 
		{ 
			Customer tempCustomer = itr.next(); 
			if (!tempCustomer.getValid().equals(valid)) 
			{
				itr.remove(); 
			} 
		}

		
		return customers;

	
	}
	//get Customers based on Country
	@Override
	public List<Customer> getCountryCustomers(String country) {
		// TODO Auto-generated method stub
		List<Customer> customers= this.customerRepository.findAll();
		getCustomerInfo(customers);
		Iterator<Customer> itr = customers.iterator(); 
		while (itr.hasNext()) 
		{ 
			Customer tempCustomer = itr.next(); 
			if (!tempCustomer.getCountry().equals(country)) 
			{
				itr.remove(); 
			} 
		}

		
		return customers;
	}

}



