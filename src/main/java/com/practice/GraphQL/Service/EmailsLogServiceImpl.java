package com.practice.GraphQL.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.GraphQL.Entities.EmailsLog;
import com.practice.GraphQL.Repository.EmailsLogRepository;

@Service
public class EmailsLogServiceImpl implements EmailsLogService {
	
	@Autowired
	EmailsLogRepository emailsLogRepository;

	@Override
	public List<EmailsLog> findAll() {
		return emailsLogRepository.findAll();
	}

	@Override
	public EmailsLog findOne(Integer id) {
		return emailsLogRepository.findOne(id);
	}

}
