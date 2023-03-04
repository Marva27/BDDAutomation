package com.bddautomation.www.pages.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bddautomation.www.pages.base.BasePage;

public class AmazonHomePage extends BasePage {

	public AmazonHomePage(WebDriver browser) {
		super(browser);
		PageFactory.initElements(browser, this);
	}

}
