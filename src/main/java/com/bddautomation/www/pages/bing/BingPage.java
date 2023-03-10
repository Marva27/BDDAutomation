package com.bddautomation.www.pages.bing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bddautomation.www.logger.AppLogger;
import com.bddautomation.www.pages.base.BasePage;

public class BingPage extends BasePage {
	
	public BingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isBingPageDisplayed() {
		AppLogger.info("Entered isBingPageDisplayed");
		if(driver.getTitle().contains("Bing"))
			return true;
		else
			return false;
	}

}
