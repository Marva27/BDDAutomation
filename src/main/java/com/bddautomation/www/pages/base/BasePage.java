package com.bddautomation.www.pages.base;

import java.io.IOException;
import java.nio.file.Files;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.bddautomation.www.logger.AppLogger;
import com.bddautomation.www.util.Utility;

import io.cucumber.java.Scenario;

public class BasePage {

	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Function Name: mouseHoverElement Objective: To mouse over a web element Date
	 * Created: 03/05/2023 Date Modified: 03/05/2023 Changes Made: Initial Version
	 */
	public void mouseHoverElement(WebElement webElement, Scenario currentScenario) throws IOException {
		AppLogger.info("Entered mouseHoverElement");
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(webElement).build().perform();
		} catch (Exception e) {
			captureElementInteractionError(currentScenario, e);
		}
		AppLogger.info("Exited mouseHoverElement");
	}

	public void clickElement(WebElement webElement, Scenario currentScenario) throws IOException {
		AppLogger.info("Entered clickElement");
		try {
			webElement.click();
		} catch (Exception e) {
			captureElementInteractionError(currentScenario, e);
		}
		AppLogger.info("Exited clickElement");
	}

	/*
	 * Function Name: captureElementInteractionError Objective: To capture exception
	 * while interacting with an element Date Created: 03/05/2023 Date Modified:
	 * 03/05/2023 Changes Made: Initial Version
	 */

	private void captureElementInteractionError(Scenario currentScenario, Exception e) throws IOException {
		AppLogger.info("Entered captureElementInteractionError");
		AppLogger.error("Error in interacting with element. Please contact automation engineer. " + e.getMessage());
		currentScenario.attach(Files.readAllBytes(Utility.captureScreenshot(driver, false).toPath()), "image/png",
				"element_interaction_error");
		Assert.fail("Error in interacting with element. Please contact automation engineer. " + e.getMessage());
		AppLogger.info("Exited captureElementInteractionError");
	}

	/*
	 * Function Name: isElementDisplayed Objective: To verify if an element is
	 * displayed Date Created: 03/05/2023 Date Modified: 03/05/2023 Changes Made:
	 * Initial Version
	 */

	public boolean isElementDisplayed(WebElement webElement, Scenario currentScenario) throws IOException {
		AppLogger.info("Entered isElementDisplayed");
		try {
			AppLogger.info("Exited isElementDisplayed");
			return webElement.isDisplayed();
		} catch (Exception e) {
			captureElementInteractionError(currentScenario, e);
			AppLogger.info("Exited isElementDisplayed");
			return false;
		}
	}
	
	/*
	 * Function Name: enterValue
	 * Objective: To enter value in a text field
	 * Date Created: 03/05/2023
	 * Date Modified: 03/05/2023
	 * Changes Made: Initial Version
	 */

	public void enterValue(WebElement webElement, String textToEnter, Scenario currentScenario) throws IOException {
		AppLogger.info("Entered enterValue");
		try {
			webElement.sendKeys(textToEnter);
		} catch (Exception e) {
			captureElementInteractionError(currentScenario, e);
		}

	}

}
