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

	@Value("${user.file.path}")
	String filePath;
	
	@Autowired
	JsonUtil jsonUtil;
	
	public List<User> getUserList() {
		List<User> userList = new ArrayList();
		try {
			userList = jsonUtil.readJsonFile(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}
}
