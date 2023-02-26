package com.learnjava.servicepattern.dto;

import java.util.List;

import com.learnjava.servicepattern.model.TransactionDetail;

import lombok.Data;

@Data
public class TransactionDto {
    private long id;
	private String type;
	private String email;
	private String date;
	private List<TransactionDetail> transactionDetails;

}
