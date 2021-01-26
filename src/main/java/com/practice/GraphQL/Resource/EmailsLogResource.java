package com.practice.GraphQL.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface EmailsLogResource {
	
	@PostMapping("/api/data")
	ResponseEntity<Object> fetchData(String data);

}
