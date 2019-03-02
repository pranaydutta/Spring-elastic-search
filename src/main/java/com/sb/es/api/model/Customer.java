package com.sb.es.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName="dutta",type="customer",shards=2)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private int age;

}
