package com.bitguiders.training.service;

import org.springframework.stereotype.Service;

import com.bitguiders.training.model.Example;

@Service
public class ExampleService {

	public String validateOrderCode(int orderCode) {
		String message=null;
		if(orderCode<=0) {
			message="Not a valid orderCode:"+orderCode;
		}else {
			message="Valid orderCode:"+orderCode;
		}
		return message;
	}
	public Example welcome(String userName) {
		Example example = new Example();
		example.setMessage("Welcome "+userName);
		return example;
	}
}
