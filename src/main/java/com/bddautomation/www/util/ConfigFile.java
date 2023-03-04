package com.bddautomation.www.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFile {

	private Properties properties;
	private final String configFilePath = "configs//Configuration.properties";
	
	public ConfigFile() {
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(configFilePath));
			properties = new Properties();
			try {
				properties.load(bufferedReader);
				bufferedReader.close();
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Configuration.properties file NOT found in configs folder");
		}
	}
	
	public String getWayFairURL() {
		String url = properties.getProperty("wayFairUrl");
		if(url != null)
			return url;
		else
			throw new RuntimeException("wayFairUrl is not specified in Configuration.properties");
	}
	
}
