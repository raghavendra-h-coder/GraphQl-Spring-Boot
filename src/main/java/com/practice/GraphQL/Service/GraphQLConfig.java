package com.practice.GraphQL.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.practice.GraphQL.Entities.EmailsLog;

import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class GraphQLConfig {
	
	@Value("classpath:emailslog.graphql")
	Resource resource;
	
	private GraphQL graphQL;
	
	@Autowired
	private EmailsLogService emailsLogService;
	
	@PostConstruct
	public void loadSchema() throws IOException{
		File schemaFile=resource.getFile();
		TypeDefinitionRegistry typeDefinitionRegistry=new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring=buildRunTimeWiring();
		GraphQLSchema schema=new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);
		graphQL=GraphQL.newGraphQL(schema).build();
	}
	
	private RuntimeWiring buildRunTimeWiring() {
		DataFetcher<List<EmailsLog>> emailsLogListDataFetcher=data->emailsLogService.findAll();
		DataFetcher<EmailsLog> emailsLogDataFetcher=data->emailsLogService.findOne(data.getArgument("id"));
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring->
					typeWiring.
					dataFetcher("allEmailsLog", emailsLogListDataFetcher)
					.dataFetcher("emailsLog", emailsLogDataFetcher)
				)
				.build();
	}
	
	public GraphQL getGraphQL()
	{
		return graphQL;
	}
	
	

}
