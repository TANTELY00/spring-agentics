package com.project.spring_agentics.repositories;

import com.project.spring_agentics.entities.Transaction;
import com.project.spring_agentics.entities.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findByAccountId(long accountId);
    List<Transaction> findByStatus(TransactionStatus transactionStatus);
}
