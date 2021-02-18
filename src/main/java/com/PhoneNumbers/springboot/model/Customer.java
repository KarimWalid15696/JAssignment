package com.PhoneNumbers.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 //Customer Class containing the values in the db + new values to ease the extraction and transferring to the FE client 
@Entity
public class Customer {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
 
    private String name;
 
    private String phone;
    
    private String country;
    
    private String valid;
    
    private String countryCode;
    
    private String number ;
 

    public Customer() {
    	
    }
    //constructor for Customer
    public Customer(String name , String phone,String Country,String Valid) {
    	super();
    	this.name=name;
    	this.phone=phone;
    	this.country=Country;
    	this.valid=Valid;
    }
    public Integer getId() {
        return id;
    }
 

    public void setId(Integer id) {
        this.id = id;
    }
 
  
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
   
    public String getPhone() {
        return phone;
    }
 

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getValid() {
		return valid;
	}
	
	public void setValid(String valid) {
		this.valid = valid;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
 
}