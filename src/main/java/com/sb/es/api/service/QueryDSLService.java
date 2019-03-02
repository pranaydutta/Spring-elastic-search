package com.sb.es.api.service;

import java.util.List;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.sb.es.api.model.Customer;

@Service
public class QueryDSLService {
	
	@Autowired
	private ElasticsearchTemplate template;
	
	
	public List<Customer> searchMultiField(String firstName,int age)
	{
		QueryBuilder query=QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("firstName", firstName)).must(QueryBuilders.matchQuery("age", age));
		NativeSearchQuery nativeSearchQuery=new NativeSearchQueryBuilder().withQuery(query).build();
		List<Customer> customers=template.queryForList(nativeSearchQuery, Customer.class);
		return customers;
	}
	
	
	public List<Customer> getCustomerSearchData(String input)
	{
		String search=".*"+input+".*";
		SearchQuery searchQuery=new NativeSearchQueryBuilder().withFilter(QueryBuilders.regexpQuery("firstName", search)).build();
		List<Customer> customers=template.queryForList(searchQuery, Customer.class);
		return customers;
	}
	
	public List<Customer> multiMatchSearch(String input)
	{
		SearchQuery searchQuery=new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(input).field("firstName").field("lastName").type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).build();
		List<Customer> customers=template.queryForList(searchQuery, Customer.class);
		return customers;
	}
	
	
	

}
