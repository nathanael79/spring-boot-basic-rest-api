package com.learnjava.servicepattern.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnjava.servicepattern.dto.TransactionDto;
import com.learnjava.servicepattern.model.Transaction;
import com.learnjava.servicepattern.response.ResponseHandler;
import com.learnjava.servicepattern.service.TransactionService;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/api/v1/transactions/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> show(@PathVariable Long id){
        try{
            Optional<Transaction> transaction = transactionService.getTransactionById(id);
            return ResponseHandler.generateResponse("data is found!", HttpStatus.OK, modelMapper.map(transaction, TransactionDto.class));
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @RequestMapping("/api/v1/transactions")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Object> index(){
        try{
            List<Transaction> transactions = transactionService.getAllTransaction();
            return ResponseHandler.generateResponse("success", HttpStatus.OK, transactions);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @RequestMapping(value = "/api/v1/transaction", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Transaction transaction){
        try{
            Transaction newTransaction = transactionService.saveTransaction(transaction);
            return ResponseHandler.generateResponse("created", HttpStatus.CREATED, newTransaction);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    
}
