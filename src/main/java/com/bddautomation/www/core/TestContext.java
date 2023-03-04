package com.bddautomation.www.core;

import com.bddautomation.www.manager.PageObjectManager;
import com.bddautomation.www.manager.WebDriverManager;

public class TestContext {
	
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	
	public TestContext() {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}
