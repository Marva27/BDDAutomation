package com.bddautomation.www.manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReadManager {

	private Properties properties = null;
	private final String configFilePath = "configs//Configuration.properties";

	public ConfigFileReadManager() {
		BufferedReader bufferedReader;
		try {
			if (properties == null) {
				bufferedReader = new BufferedReader(new FileReader(configFilePath));
				properties = new Properties();
				try {
					properties.load(bufferedReader);
					bufferedReader.close();
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Configuration.properties file NOT found in configs folder");
		}
	}

	public String getWayFairURL() {
		String url = properties.getProperty("wayFairUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("wayFairUrl is not specified in Configuration.properties");
	}

	public String getGoogleURL() {
		String url = properties.getProperty("googleUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("googleUrl is not specified in Configuration.properties");
	}

	public String getBingURL() {
		String url = properties.getProperty("bingUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("bingUrl is not specified in Configuration.properties");
	}

}
