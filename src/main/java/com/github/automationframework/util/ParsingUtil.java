package com.github.automationframework.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParsingUtil {
	public static <T> T jsonStringToObject(String body,Class<T> t) {
		ObjectMapper objectMapper = new ObjectMapper();
		T object = null;
		try {
			object = objectMapper.readValue(body, t);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	
	public static String objectToJsonString(Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = null;
		try {
			 jsonString = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}
	
}
