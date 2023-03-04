package com.bddautomation.www.pages.base;

import org.openqa.selenium.WebDriver;

public class BasePage {

	public WebDriver browser;
	
	public BasePage(WebDriver browser) {
		this.browser = browser;
	}
	
}
