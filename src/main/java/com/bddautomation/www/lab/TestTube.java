package com.bddautomation.www.lab;

import com.bddautomation.www.logger.AppLogger;
import com.bddautomation.www.manager.WebDriverManager;

public class TestTube {

	public static void main(String[] args) {
		AppLogger.info("I am a main method");
		WebDriverManager webDriverManager = new WebDriverManager();
		webDriverManager.getDriver();
		webDriverManager.closeDriver();
	}

}
