package com.bddautomation.www.pages.google;

import java.io.IOException;
import java.nio.file.Files;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bddautomation.www.logger.AppLogger;
import com.bddautomation.www.pages.base.BasePage;
import com.bddautomation.www.util.Utility;

import io.cucumber.java.Scenario;

public class GooglePage extends BasePage {
	
	public GooglePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void isGooglePaeDisplayed(Scenario currentScenario) throws IOException {
		AppLogger.info("Entered isGooglePaeDisplayed");
		currentScenario.attach(Files.readAllBytes(Utility.captureScreenshot(driver, false).toPath()), "image/png", "google_page");
		Assert.assertTrue("Was Google Page displayed?", driver.getTitle().contains("Google"));
		AppLogger.info("Entered isGooglePaeDisplayed");
	}
	
	@FindBy(css="input[name='q']")
	WebElement txtSearchBox;
	
	@FindBy(css="input[value='Google Search']")
	WebElement btnGoogleSearch;
	
	public void googleSearch(String searchText, Scenario currentScenario) throws IOException {
		AppLogger.info("Entered googleSearch");
		enterValue(txtSearchBox, searchText, currentScenario);
		currentScenario.attach(Files.readAllBytes(Utility.captureScreenshot(driver, false).toPath()), "image/png", searchText);
		clickElement(btnGoogleSearch, currentScenario);
		AppLogger.info("Exited googleSearch");
	}
	
	public boolean areGoogleSearchResultsDisplayed(String searchResults, Scenario currentScenario) {
		AppLogger.info("Entered areGoogleSearchResultsDisplayed");
		if(driver.getTitle().contains(searchResults))
			return true;
		else
			return false;
	}
}
