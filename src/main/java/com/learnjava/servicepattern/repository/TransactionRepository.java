package com.learnjava.servicepattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnjava.servicepattern.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
}
