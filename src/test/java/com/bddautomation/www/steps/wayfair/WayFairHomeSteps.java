package com.bddautomation.www.steps.wayfair;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.bddautomation.www.core.TestContext;
import com.bddautomation.www.logger.AppLogger;
import com.bddautomation.www.pages.wayfair.WayFairHomePage;
import com.bddautomation.www.pages.wayfair.WayFairLoginPage;
import com.bddautomation.www.steps.hooks.Hooks;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class WayFairHomeSteps {

	WebDriver driver;
	
	TestContext testContext;
	
	WayFairHomePage wayFairHomePage;
	WayFairLoginPage wayFairLoginPage;
	
	Scenario currentScenario;
	
	public WayFairHomeSteps(TestContext testContext, Hooks hooks) {
		AppLogger.info("Entered WayFairHomeSteps Constructor!!!");
		this.testContext = testContext;
		driver = testContext.getWebDriverManager().getDriver();
		wayFairHomePage = testContext.getPageObjectManager().getWayFairHomePage();
		currentScenario = hooks.getScenario();
		AppLogger.info("Exited WayFairHomeSteps Constructor!!!");
	}
	
	@Given("I connect to {string}")
	public void i_connect_to(String url) {
	    AppLogger.info("Connecting to " + url);
	    driver.get(url);
	}
	
	@When("I click Sign In")
	public void i_click_sign_in() throws IOException {
		AppLogger.info("Calling clickSignIn");
	    wayFairHomePage.clickSignIn(currentScenario);
	}
}
