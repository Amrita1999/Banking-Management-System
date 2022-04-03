package com.amrita.Banking.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.amrita.Banking.Repository.CustomerRepository;
import com.amrita.Banking.entity.Customer;
import com.amrita.Banking.entity.Login;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerrepository;
	
	public Customer save(Customer cust)
	{
		Random random = new Random();
		String accountNumber = String.valueOf(random.nextInt(10000000));
		cust.setAccountNo(accountNumber);
		
		Customer customer = customerrepository.save(cust);
		return customer;
	}
	
	public Customer update(Customer cust1)
	{
		return  customerrepository.save(cust1);		
	}
	
	public void delete(@PathVariable Long id) {
		customerrepository.deleteById(id);
	}

	public Optional<Customer> getOne(@PathVariable Long id) {
		return customerrepository.findById(id);
	}

	public List<Customer> getAll() {
		return customerrepository.findAll();
	}

	public Customer authenticate(Login login) {

		return customerrepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
	}

}

