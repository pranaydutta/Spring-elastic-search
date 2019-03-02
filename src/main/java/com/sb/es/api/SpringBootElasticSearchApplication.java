package com.sb.es.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.es.api.model.Customer;
import com.sb.es.api.repository.CustomerRepository;

@SpringBootApplication
@RestController
public class SpringBootElasticSearchApplication {
	
	@Autowired
	private CustomerRepository repository;
	
	@PostMapping("/insert")
	public int saveCustomer(@RequestBody List<Customer> customers)
	{
		repository.save(customers);
		return customers.size();
	}
	
	@GetMapping("/findAll")
	public Iterable<Customer> findAllCustmers()
	{
		return repository.findAll();
	}
	
	@GetMapping("/findByName/{firstName}")
	public List<Customer> findByFirstName(@PathVariable String firstName)
	{
		return repository.findByFirstName(firstName);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticSearchApplication.class, args);
	}

}

