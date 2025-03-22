package com.bitguiders.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitguiders.training.service.ExampleService;

@RestController
public class ExampleController {
	
	@Autowired
	ExampleService exampleService;
	
	@RequestMapping(value="/training/bat-01/rest/api/example1" , method=RequestMethod.GET)
	public String stringReturnExample() {
		return "String return exampe";
	}

	@RequestMapping(value="/training/bat-01/rest/api/example2" , method=RequestMethod.GET)
	public String requestParamExample1(@RequestParam(name="userName", required=true) String userName) {
		return "Welcome "+userName;
	}

	@RequestMapping(value="/training/bat-01/rest/api/example3" , method=RequestMethod.GET)
	public String requestParamExample2(@RequestParam(name="orderCode", required=true) int orderCode) {
		return exampleService.validateOrderCode(orderCode);
	}
}
