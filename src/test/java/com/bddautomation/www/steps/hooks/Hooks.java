package com.bddautomation.www.steps.hooks;

import org.openqa.selenium.WebDriver;

import com.bddautomation.www.core.TestContext;
import com.bddautomation.www.logger.AppLogger;

import io.cucumber.java.Before;
import io.cucumber.java.After;
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
		this.driver = testContext.getWebDriverManager().getDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public Scenario getScenario() {
		return scenario;
	}
	
	@After
	public void tearDown() {
		AppLogger.endTestCase(scenario);
		if(driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
