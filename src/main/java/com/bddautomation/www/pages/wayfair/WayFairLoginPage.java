package com.bddautomation.www.pages.wayfair;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bddautomation.www.logger.AppLogger;
import com.bddautomation.www.pages.base.BasePage;

import io.cucumber.java.Scenario;

public class WayFairLoginPage extends BasePage {

	public WayFairLoginPage(WebDriver browser) {
		super(browser);
		PageFactory.initElements(browser, this);
	}

	@FindBy(css="input[name='email']")
	WebElement txtEmail;
	
	public void isEmailAddressBoxDisplayed(Scenario currentScenario) throws IOException {
		AppLogger.info("Entered isEmailAddressBoxDisplayed");
		Assert.assertTrue("Was Email Address Box Displayed?", isElementDisplayed(txtEmail, currentScenario));
		AppLogger.info("Exited isEmailAddressBoxDisplayed");
	}
	
}
