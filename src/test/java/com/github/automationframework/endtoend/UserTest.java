package com.github.automationframework.endtoend;

import org.testng.annotations.Test;

import com.github.automationframework.BaseTest;
import com.github.automationframework.endpoint.users.UserClient;

public class UserTest extends BaseTest {

	@Test
	public void test() {
		UserClient userClient = new UserClient();
		userClient.getUser(2);
	}
	
	@Test
	public void test2() {
		UserClient userClient = new UserClient();
		userClient.createUser();
	}
	
	@Test
	public void test3() {
		UserClient userClient = new UserClient();
		userClient.createUser2();
	}
}
