package com.bddautomation.www.steps.wayfair;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.bddautomation.www.core.TestContext;
import com.bddautomation.www.logger.AppLogger;
import com.bddautomation.www.pages.wayfair.WayFairHomePage;
import com.bddautomation.www.pages.wayfair.WayFairLoginPage;
import com.bddautomation.www.steps.hooks.Hooks;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

public class WayFairLoginSteps {

	WebDriver driver;

	TestContext testContext;

	WayFairHomePage wayFairHomePage;
	WayFairLoginPage wayFairLoginPage;

	Scenario currentScenario;

	public WayFairLoginSteps(TestContext testContext, Hooks hooks) {
		AppLogger.info("Entered WayFairLoginSteps Constructor!!!");
		this.testContext = testContext;
		driver = testContext.getWebDriverManager().getDriver();
		wayFairHomePage = testContext.getPageObjectManager().getWayFairHomePage();
		currentScenario = hooks.getScenario();
		AppLogger.info("Exited WayFairLoginSteps Constructor!!!");
	}
	
	@Then("I should see Enter Your Email Address page")
	public void i_should_see_enter_your_email_address_page() throws IOException {
	    AppLogger.info("Calling isEmailAddressBoxDisplayed");
	    wayFairLoginPage.isEmailAddressBoxDisplayed(currentScenario);
	}

}
