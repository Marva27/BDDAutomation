package com.bddautomation.www.steps;

import org.openqa.selenium.WebDriver;

import com.bddautomation.www.core.TestContext;
import com.bddautomation.www.logger.AppLogger;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private WebDriver driver;
	private TestContext testContext;
	private Scenario scenario;
	
	public Hooks(TestContext testContext) {
		this.testContext = testContext;
	}
	
	@Before
	public void setUp(Scenario currentScenario) {
		AppLogger.info("Entered setUp");
		AppLogger.startTestCase(currentScenario);
		this.scenario = currentScenario;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver() {
		this.driver = testContext.getWebDriverManager().getDriver();
	}
	
	public Scenario getScenario() {
		return scenario;
	}
	
	@Before
	public void tearDown() {
		AppLogger.endTestCase(scenario);
		if(driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
