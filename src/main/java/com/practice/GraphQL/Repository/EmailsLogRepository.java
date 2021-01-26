package com.practice.GraphQL.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.GraphQL.Entities.EmailsLog;

@Repository
public interface EmailsLogRepository extends JpaRepository<EmailsLog, Integer> {

}
