package de.zipjet.tests;

import java.io.File;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.TakesScreenshot;

import org.testng.annotations.BeforeTest;

import de.zipjet.framework.BrowserManager;
import de.zipjet.pages.MainPage;
import de.zipjet.pages.PageObject;


public class TestBase {
	public BrowserManager browser;

	@BeforeTest(alwaysRun = true)
	public void setUp() throws Exception {
		browser = new BrowserManager();
//		 mainPage = new MainPage(driver);
		//System.out.println("Test was started");
	  }
	
	//@BeforeTest(alwaysRun = true)
	public void cleanAllCookies() {	
		browser.driver.manage().deleteAllCookies();
	}
	 
	public void cleanSessionCookies() {
		browser.driver.manage().deleteCookieNamed("PHPSESSID");
	//	browser.driver.manage().deleteCookieNamed("staging");	
	}
	
	public void refreshPage() {
		   browser.driver.navigate().refresh();
		   //browser.driver.navigate().to(browser.baseUrl);
		
	}
	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {
		browser.stop();	   
		//System.out.println("Test was finished");
	  }


}
