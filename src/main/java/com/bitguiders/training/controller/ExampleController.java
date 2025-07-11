package com.bitguiders.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitguiders.training.model.Example;
import com.bitguiders.training.service.ExampleService;

@RestController
public class ExampleController {
	
	@Autowired
	private ExampleService exampleService;
	
	@RequestMapping(value="/training/bat-01/rest/api/example" , method=RequestMethod.GET)
	public String stringReturnExample() {
		return "calculator service";
	}

	@RequestMapping(value="/training/bat-01/rest/api/example" , method=RequestMethod.POST)
	public String requestParamExample1(@RequestParam(name="userName", required=true) String userName) {
		return "Welcome "+userName;//Added concatenation operator
	}

	@RequestMapping(value="/training/bat-01/rest/api/example" , method=RequestMethod.PUT)
	public String requestParamExample2(@RequestParam(name="orderCode", required=true) int orderCode) {
		return exampleService.validateOrderCode(orderCode);// Make sure this method returns a string 
	}

	@RequestMapping(value="/training/bat-01/rest/api/example" , method=RequestMethod.DELETE)
	public Example objectRturnExample(@RequestParam(name="userName", required=true) String userName) {
		return exampleService.welcome(userName);//Make sure this method returns an Example object
	}
	
}
	
	

