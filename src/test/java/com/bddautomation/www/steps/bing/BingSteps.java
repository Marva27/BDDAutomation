package com.bddautomation.www.steps.bing;

import java.io.IOException;
import java.nio.file.Files;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.bddautomation.www.core.TestContext;
import com.bddautomation.www.logger.AppLogger;
import com.bddautomation.www.manager.ConfigFileReadManager;
import com.bddautomation.www.manager.FileReaderManager;
import com.bddautomation.www.pages.bing.BingPage;
import com.bddautomation.www.steps.hooks.Hooks;
import com.bddautomation.www.util.Utility;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BingSteps {
	
	TestContext testContext;
	
	Scenario currentScenario;
	
	WebDriver driver;
	
	BingPage bingPage;
	
	public BingSteps(TestContext testContext, Hooks hooks) {
		AppLogger.info("Entered GoogleSteps Constructor!!!");
		this.testContext = testContext;
		driver = testContext.getWebDriverManager().getDriver();
		bingPage = testContext.getPageObjectManager().getBingPage();
		currentScenario = hooks.getScenario();
		AppLogger.info("Exited GoogleSteps Constructor!!!");
	}
	
	@Given("I connect to https:\\/\\/www.bing.com")
	public void i_connect_to_https_www_bing_com() {
		AppLogger.info("Connecting " + testContext.getConfigFileReadManager().getBingURL());
		driver.get(testContext.getConfigFileReadManager().getBingURL());
	}
	
	@Then("I should see Bing website")
	public void i_should_see_bing_website() throws IOException {
		AppLogger.info("Calling isBingPageDisplayed");
	    currentScenario.attach(Files.readAllBytes(Utility.captureScreenshot(driver, false).toPath()), "image/png", "bing_website");
	    Assert.assertTrue("Is Bing HomePage displayed?", bingPage.isBingPageDisplayed());
	}
}
