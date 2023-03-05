package com.bddautomation.www.pages.wayfair;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bddautomation.www.logger.AppLogger;
import com.bddautomation.www.pages.base.BasePage;

import io.cucumber.java.Scenario;

public class WayFairHomePage extends BasePage {

	public WayFairHomePage(WebDriver browser) {
		super(browser);
		PageFactory.initElements(browser, this);
	}

	@FindBy(css="a[data-target-id='header-my-account-item']")
	WebElement iconAccount;
	
	@FindBy(css="a[data-cy-id='my_account_menu_sign_in_button']")
	WebElement btnSignIn;
	
	public void clickSignIn(Scenario currentScenario) throws IOException {
		AppLogger.info("Entered clickSignIn");
		mouseHoverElement(iconAccount, currentScenario);
		clickElement(btnSignIn, currentScenario);
		AppLogger.info("Exited clickSignIn");
	}

}
