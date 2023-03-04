package com.bddautomation.www.pages.wayfair;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bddautomation.www.pages.base.BasePage;

public class WayFairLoginPage extends BasePage {

	public WayFairLoginPage(WebDriver browser) {
		super(browser);
		PageFactory.initElements(browser, this);
	}

}
