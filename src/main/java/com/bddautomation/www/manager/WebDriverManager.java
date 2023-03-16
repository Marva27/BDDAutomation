package com.bddautomation.www.manager;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bddautomation.www.logger.AppLogger;

public class WebDriverManager {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		AppLogger.info("Entered getDriver");
		if(driver == null)
			driver = createDriver();
		driver.manage().window().maximize();
		AppLogger.info("Exited getDriver");
		return driver;
	}

	private WebDriver createDriver() {
		AppLogger.info("Entered createDriver");
		try {
			switch(System.getProperty("execution")) {
			case "local":
				driver = createLocalDriver();
				break;
			case "remote":
				driver = createRemoteDriver();
				break;
			}
			AppLogger.info("Exited createDriver");
			return driver;
		}catch(Exception e) {
			Assert.fail("Environment variable [execution] is missing");
			throw new RuntimeException("Environment variable [execution] is missing");
		}
	}

	private WebDriver createRemoteDriver() {
		AppLogger.info("Entered createRemoteDriver");
		String ipAddress = "IP Address of machine where Selenium Hub is Running";
		RemoteWebDriver driver = null;
		String urlFormat = "http://" + ipAddress + ":" + 4444 + "/wd/hub";
		AppLogger.info("Selenium grid url: " + urlFormat);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new RemoteWebDriver(convertToURLFormat(urlFormat), options);
		driver.manage().window().maximize();
		AppLogger.info("Exited createRemoteDriver");
		return driver;
	}

	private URL convertToURLFormat(String urlFormat) {
		AppLogger.info("Entered convertToURLFormat");
		URL url = null;
		try {
			url = new URL(urlFormat);
		}catch(MalformedURLException e) {
			AppLogger.error(e.getMessage());
		}
		AppLogger.info("Exited convertToURLFormat");
		return url;
	}

	private WebDriver createLocalDriver() {
		AppLogger.info("Entered createLocalDriver");
		try {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
			return driver;
		}catch(Exception e) {
			AppLogger.error(e.getMessage());
			Assert.fail("Error opening browser due to " + e.getMessage());
		}
		AppLogger.info("Exited createLocalDriver");
		return null;
	}
	
	public void closeDriver() {
		AppLogger.info("Entered closeDriver");
		driver.close();
		driver.quit();
		AppLogger.info("Exited closeDriver");
	}

}
