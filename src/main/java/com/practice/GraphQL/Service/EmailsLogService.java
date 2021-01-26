package com.practice.GraphQL.Service;

import java.util.List;

import com.practice.GraphQL.Entities.EmailsLog;

public interface EmailsLogService {
	
	List<EmailsLog> findAll();
	
	EmailsLog findOne(Integer id);

}
