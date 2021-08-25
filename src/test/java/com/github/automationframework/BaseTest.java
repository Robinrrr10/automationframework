package com.github.automationframework;

import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.BeforeSuite;

import com.github.automationframework.util.PropertyReader;

public class BaseTest {
	
	@BeforeSuite
	public void setUp() {
		PropertyReader propertyReader = new PropertyReader();
		
	}

}
