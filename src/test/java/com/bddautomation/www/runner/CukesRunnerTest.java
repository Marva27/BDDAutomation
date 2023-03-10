package com.bddautomation.www.runner;

import org.junit.runner.RunWith;

import com.bddautomation.www.logger.AppLogger;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features", 
		glue = "com.bddautomation.www.steps", 
		dryRun = false,
		tags = "@Google",
		plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				})
public class CukesRunnerTest {
	
	public CukesRunnerTest() {
		AppLogger.info("I was called!!");
	}

}
