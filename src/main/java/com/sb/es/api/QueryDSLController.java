package com.sb.es.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sb.es.api.model.Customer;
import com.sb.es.api.service.QueryDSLService;

@RestController
public class QueryDSLController {
	
	@Autowired
	private QueryDSLService service;
	
	
	@GetMapping("/multiFiled/{firstName}/{age}")
	public List<Customer> searchByMultipleField(@PathVariable String firstName,@PathVariable int age)
	{
		return service.searchMultiField(firstName, age);
	}
	
	@GetMapping("/regex/{input}")
	public List<Customer> getCustomerSearchData(@PathVariable String input)
	{
		return service.getCustomerSearchData(input);
	}
	
	
	@GetMapping("/multiSearch/{text}")
	public List<Customer> multiMatchSearch(@PathVariable String text)
	{
		return service.multiMatchSearch(text);
	}

}
