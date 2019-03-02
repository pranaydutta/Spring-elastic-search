package com.sb.es.api.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.sb.es.api.model.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer,String>{
	
	public List<Customer> findByFirstName(String firstName);

}
