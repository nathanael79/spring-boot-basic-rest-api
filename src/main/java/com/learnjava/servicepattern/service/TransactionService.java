package com.learnjava.servicepattern.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnjava.servicepattern.model.Transaction;
import com.learnjava.servicepattern.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Optional<Transaction> getTransactionById(Long id){
        Optional<Transaction> transaction = transactionRepository.findById(id);

        return transaction;
    }

    public List<Transaction> getAllTransaction(){
        List<Transaction> transaction = new ArrayList<Transaction>();
        transaction = transactionRepository.findAll();
        return transaction;
    }

    public Transaction saveTransaction(Transaction transaction){
        Transaction newTransaction = transactionRepository.save(transaction);

        return newTransaction;
    }

    
}
