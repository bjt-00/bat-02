package com.bitguiders.training.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	
	@RequestMapping(value="/training/bat-01/rest/api/example1" , method=RequestMethod.GET)
	public String stringReturnExample() {
		return "String return exampe";
	}

}
