package com.bddautomation.www.steps.google;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.bddautomation.www.core.TestContext;
import com.bddautomation.www.logger.AppLogger;
import com.bddautomation.www.pages.google.GooglePage;
import com.bddautomation.www.steps.hooks.Hooks;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSteps {

	WebDriver driver;
	
	TestContext testContext;

	GooglePage googlePage;
	
	Scenario currentScenario;
	
	public GoogleSteps(TestContext testContext, Hooks hooks) {
		AppLogger.info("Entered GoogleSteps Constructor!!!");
		this.testContext = testContext;
		driver = testContext.getWebDriverManager().getDriver();
		googlePage = testContext.getPageObjectManager().getGooglePage();
		currentScenario = hooks.getScenario();
		AppLogger.info("Exited GoogleSteps Constructor!!!");
	}

	@Given("I connect to https:\\/\\/www.google.com")
	public void i_connect_to_https_www_google_com() throws InterruptedException {
		AppLogger.info("Connecting to " + testContext.getFileReaderManager().getConfigFile().getGoogleURL());
		driver.get(testContext.getConfigFileReadManager().getGoogleURL());
	}

	@Then("I should see Google Home page")
	public void i_should_see_google_home_page() throws IOException {
		AppLogger.info("Calling isGooglePageDisplayed");
		googlePage.isGooglePageDisplayed(currentScenario);
	}

	@When("I search for {string}")
	public void i_search_for(String searchText) throws IOException {
		AppLogger.info("Calling googleSearch");
		googlePage.googleSearch(searchText, currentScenario);
	}

	@Then("I should see the search results for {string}")
	public void i_should_see_the_search_results_for(String searchResults) throws IOException {
		AppLogger.info("Calling ");
		googlePage.areGoogleSearchResultsDisplayed(searchResults, currentScenario);
	}
}
