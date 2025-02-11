package com.bitguiders.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitguiders.training.model.User;
import com.bitguiders.training.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/training/bat-01/rest/api/user" ,method=RequestMethod.GET)
	public List<User> getUserList() {
		return userService.getUserList();
	}

	@RequestMapping(value="/training/bat-01/rest/api/user" ,method=RequestMethod.POST)
	public String add(@RequestBody User newUser) {
		return userService.add(newUser);
	}

	@RequestMapping(value="/training/bat-01/rest/api/user" ,method=RequestMethod.PUT)
	public String update(@RequestBody User newUser) {
		return userService.update(newUser);
	}

	@RequestMapping(value="/training/bat-01/rest/api/user" ,method=RequestMethod.DELETE)
	public String delete(@RequestBody User newUser) {
		return userService.delete(newUser);
	}
}
