package com.practice.GraphQL.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.GraphQL.Service.GraphQLConfig;

import graphql.ExecutionResult;

@RestController
public class EmailsLogResourceImpl implements EmailsLogResource {
	
	@Autowired
	private GraphQLConfig graphQLConfig;
	
	@Override
	public ResponseEntity<Object> fetchData(@RequestBody String data) {
		ExecutionResult result=graphQLConfig.getGraphQL().execute(data);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

}
