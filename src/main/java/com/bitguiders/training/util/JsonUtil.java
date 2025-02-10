package com.bitguiders.training.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.bitguiders.training.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

@Component
public class JsonUtil {
	
	@Value("${user.file.path1}")
	String filePath1;

    public List<User> readJsonFile(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);
        if(!file.exists()) {
        	InputStream inputStream = new ClassPathResource(filePath1).getInputStream();	
        	List<User> existingUsers =  mapper.readValue(inputStream, new TypeReference<List<User>>() {});
        	writeJsonFile(filePath,existingUsers);
        }
        
        return mapper.readValue(file, new TypeReference<List<User>>() {});
    }
    
    public void writeJsonFile(String filePath,List<User> dataList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), dataList);
    }

}
