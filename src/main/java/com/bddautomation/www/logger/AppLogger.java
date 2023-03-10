package com.bddautomation.www.logger;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.Scenario;

public class AppLogger {

	private static Logger logger = LoggerFactory.getLogger(AppLogger.class);
	
	public static synchronized void startTestCase(Scenario scenario) {
		Collection<String> scenarioName = scenario.getSourceTagNames();
		String fileName = scenarioName.toArray()[0].toString() + "_" + scenarioName.toArray()[1].toString() + "_" + scenario.getLine();
		fileName = fileName.replaceAll("_+","_").replaceAll("@", "");
		startLog(System.getProperty("user.dir"), fileName);
		info("\n\n******** Execution Started : " + fileName + "************\n");
	}
	
	public static synchronized void endTestCase(Scenario scenario) {
		Collection<String> scenarioName = scenario.getSourceTagNames();
		String fileName = scenarioName.toArray()[0].toString() + "_" + scenarioName.toArray()[1].toString() + "_" + scenario.getLine();
		fileName = fileName.replaceAll("_+","_").replaceAll("@", "");
		info("\n\n******** Execution Ended : " + fileName + "************\n");
	}

	public static void startLog(String property, String fileName) {
		// TODO Auto-generated method stub
		
	}
	
	public static Logger getCurrentLog() {
		return logger;
	}
	
	public static String getCallInfo() {
		String callInfo;
		String className = Thread.currentThread().getStackTrace()[3].getClassName();
		String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
		int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();		
		callInfo = className + ":" + methodName + ":" + lineNumber + " ==> ";
		return callInfo;
	}
	
	public static void info(String message) {
		getCurrentLog().info(getCallInfo() + message);
	}
	
	public static void trace(Object message) {
		getCurrentLog().trace(message.toString());
	}
	
	public static void trace(Object message, Throwable t) {
		getCurrentLog().trace(message.toString(), t);
	}
	
	public static void debug(Object message) {
		getCurrentLog().debug(message.toString());
	}
	
	public static void debug(Object message, Throwable t) {
		getCurrentLog().debug(message.toString(), t);
	}
	
	public static void error(Object message) {
		getCurrentLog().error(message.toString());
	}
	
	public static void error(Object message, Throwable t) {
		getCurrentLog().error(message.toString(), t);
	}
	
	public static void warn(Object message) {
		getCurrentLog().warn(message.toString());
	}
	
	public static void warn(Object message, Throwable t) {
		getCurrentLog().warn(message.toString(), t);
	}
	
}
