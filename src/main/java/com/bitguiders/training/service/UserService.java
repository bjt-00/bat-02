package com.bitguiders.training.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bitguiders.training.model.User;
import com.bitguiders.training.util.JsonUtil;

@Service
public class UserService {

	@Value("${user.file.path2}")
	String filePath2;

	@Autowired
	JsonUtil jsonUtil;
	
	public List<User> getUserList() {
		List<User> userList = new ArrayList();
		try {
			userList = jsonUtil.readJsonFile(filePath2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public String add(User newUser) {
		
		if(null==newUser.getOrderCode()) {
			return "400 Bad request orderCode is missing";
		}
		
		List<User> existingUsers = getUserList();
		User existingUser = getExistingUser(existingUsers,newUser);
		if(null==existingUser) {
		  existingUsers.add(newUser);
		}else {
			return "Request denied orderCode already registered.";
		}
		
		return save(existingUsers,newUser); 
	}
	
	private User getExistingUser(List<User> existingUsers,User newUser) {
		for(User user:existingUsers) {
			if(user.getOrderCode().equals(newUser.getOrderCode())) {
				return user;
			}
		}
		return null;
	}
	
	private String save(List<User> existingUsers,User newUser) {
		String response=null;
		try {
			jsonUtil.writeJsonFile(filePath2,existingUsers);
			response=newUser.getFirstName()+" saved successfully";
		} catch (IOException e) {
			e.printStackTrace();
			response = e.getMessage();
		}
		return response;
	}
}
