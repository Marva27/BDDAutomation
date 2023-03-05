package com.bddautomation.www.core;

import com.bddautomation.www.manager.ConfigFileReadManager;
import com.bddautomation.www.manager.FileReaderManager;
import com.bddautomation.www.manager.PageObjectManager;
import com.bddautomation.www.manager.WebDriverManager;

public class TestContext {
	
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private ConfigFileReadManager configFileReadManager;
	
	public TestContext() {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		configFileReadManager = new ConfigFileReadManager();
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ConfigFileReadManager getConfigFileReadManager() {
		return configFileReadManager;
	}
	
	public FileReaderManager getFileReaderManager() {
		return FileReaderManager.getInstance();
	}

}
