package com.amrita.Banking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amrita.Banking.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByEmailAndPassword(String email, String password);
	
	Customer findByAccountNo(String accountNum);

}
