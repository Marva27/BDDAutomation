package com.bddautomation.www.manager;

import org.openqa.selenium.WebDriver;

import com.bddautomation.www.pages.bing.BingPage;
import com.bddautomation.www.pages.google.GooglePage;
import com.bddautomation.www.pages.wayfair.WayFairHomePage;

public class PageObjectManager {
	
	private WebDriver driver;
	
	//WayFair Page  Objects
	private WayFairHomePage wayFairHomePage;
	
	//Google Page Objects
	private GooglePage googlePage;
	
	//Bing Page Objects
	private BingPage bingPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public WayFairHomePage getWayFairHomePage() {
		return (wayFairHomePage == null) ? wayFairHomePage = new WayFairHomePage(driver) : wayFairHomePage;
	}

	public GooglePage getGooglePage() {
		return (googlePage == null) ? googlePage = new GooglePage(driver) : googlePage;
	}

	public BingPage getBingPage() {
		return (bingPage == null) ? bingPage = new BingPage(driver) : bingPage;
	}

}
