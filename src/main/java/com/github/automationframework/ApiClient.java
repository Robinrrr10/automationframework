package com.github.automationframework;

import java.util.Map;

import com.github.dzieciou.testing.curl.CurlLoggingRestAssuredConfigFactory;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

	public Response Call(String uri, Map<String, String> headers, String method, String body) {
		
		RequestSpecBuilder request = new RequestSpecBuilder();
		//RequestSpecification request = new RequestSpecBuilder();
		request.setBaseUri(uri);
		System.out.println("RequestSpec:" + request);
		//request.headers(headers);
		RequestSpecification req = request.build();
		//request.body(body);	
		
		Response response = req.get();
		
		return response;
	}
	
	public Response getCall(String uri,  Map<String, String> headers) {
		Response response = RestAssured.with().headers(headers).get(uri);
		return response;
	}
	
	public Response getCall(String uri,  Map<String, String> headers, Map<String, String> pathParams) {
		Response response = RestAssured.with().headers(headers).get(uri, pathParams);
		return response;
	}
	
	public Response postCall(String uri,  Map<String, String> headers, String body) {
		Response response = RestAssured.with().headers(headers).body(body).post(uri);
		return response;
	}
	
	public Response postCall2(String uri,  Map<String, String> headers, Object body) {
		Response response = RestAssured.given().with().headers(headers).body(body).post(uri);
		return response;
	}
	
	public enum Method {
		GET,
		POST,
		PUT,
		DELETE
	}
	
}
