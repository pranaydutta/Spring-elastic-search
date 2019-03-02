package com.sb.es.api.config;

import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages="com.sb.es.api.repository")
public class ESConfig {
	
	
	@Bean
	public NodeBuilder build()
	{
		return new NodeBuilder();
	}
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate()
	{
		return new ElasticsearchTemplate(build().local(true).node().client());
	}

}
