package com.github.automationframework.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static String USER_HOST = "";
	public static String ACCOUNT_HOST = "";
	private final String configPath = "config/config.properties";
	static Properties properties = new Properties();
	
	public PropertyReader() {
		try {
			loadFromPropertyFile();
			loadAllProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void loadFromPropertyFile() throws IOException {
		
		FileReader file = new FileReader(configPath);
		properties.load(file);
	
	}
	
	private String loadValue(String key, String def) {
		String value = null;
		if(System.getenv(key) != null && !System.getenv(key).equals("")) {
			value = System.getenv(key);
		}else {
			value = properties.getProperty(key, def);
		}
		return value;
	}
	
	public void loadAllProperties() {
		USER_HOST = loadValue("user.host", "https://reqres.isn/");
		ACCOUNT_HOST = loadValue("account.host", "https://account.in/");
	}
	
}
