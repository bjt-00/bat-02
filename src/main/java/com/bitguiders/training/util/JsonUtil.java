package com.bitguiders.training.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.bitguiders.training.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

@Component
public class JsonUtil {
	
    public List<User> readJsonFile(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource(filePath).getInputStream();
        return mapper.readValue(inputStream, new TypeReference<List<User>>() {});
    }
    
    public void writeJsonFile(String filePath,List<User> dataList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), dataList);
    }

}
