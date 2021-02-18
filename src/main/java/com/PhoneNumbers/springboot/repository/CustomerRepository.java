package com.PhoneNumbers.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.PhoneNumbers.springboot.model.Customer; 
//Repository to handle the db IOs
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
