package com.github.automationframework.endpoint.users;

import java.net.ResponseCache;
import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import org.apache.log4j.Logger;

import com.github.automationframework.ApiClient;
import com.github.automationframework.endpoint.users.entities.User;
import com.github.automationframework.util.ParsingUtil;
import com.github.automationframework.util.PropertyReader;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserClient {

	private String BASE_ENDPOINT = PropertyReader.USER_HOST;
	Logger log = Logger.getLogger(getClass());
	ApiClient apiClient = new ApiClient();
	
	public UserClient() {
		//BASE_ENDPOINT = PropertyReader.USER_HOST;
	}
	
	private static Map<String, String> headers(){
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return headers;
	}
	
	public void getUser(int user) {
		System.out.println("host is:" + BASE_ENDPOINT);
		log.info("HOSST:" + BASE_ENDPOINT);
		
		
		//Response response = apiClient.Call("https://reqres.in/api/users?page=2", headers(), "GET", "");
		Response response = apiClient.getCall("https://reqres.in/api/users?page=2", headers());
		System.out.println("response code::" + response.statusCode());
		System.out.println("Body::" + response.body().asString());
		
	}
	
	public void createUser() {
		String body = "{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}";
		Response response = apiClient.postCall("https://reqres.in/api/users", headers(), body);
		System.out.println("response code::" + response.statusCode());
		System.out.println("Body::" + response.body().asString());
		//User user = ParsingUtil.jsonStringToObject(response.body().asString(), User.class);
		//System.out.println("User name is:" + user.getName());
	}
	
	public void createUser2() {
		//String body = "{\r\n" + 
			//	"    \"name\": \"morpheus\",\r\n" + 
				//"    \"job\": \"leader\"\r\n" + 
				//"}";
		
		User request = new User();
		request.setName("Nambi");
		request.setJob("leader");
		Response response = apiClient.postCall2("https://reqres.in/api/users", headers(), request);
		System.out.println("response data:" + response.asString());
		System.out.println("response data2:" + response.asPrettyString());
		System.out.println("response code::" + response.statusCode());
		System.out.println("Body::" + response.body().asString());
		User user = ParsingUtil.jsonStringToObject(response.body().asString(), User.class);
		System.out.println("User name is:" + user.getName());
		String stringBody = ParsingUtil.objectToJsonString(user);
		System.out.println("body in string:" + stringBody);
	}
}
