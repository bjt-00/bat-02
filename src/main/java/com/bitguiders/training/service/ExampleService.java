package com.bitguiders.training.service;

import org.springframework.stereotype.Service;

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
}
