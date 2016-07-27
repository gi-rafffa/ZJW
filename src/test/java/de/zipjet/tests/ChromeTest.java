package de.zipjet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ChromeTest {
	//@Test
	public void testGoogleSearch() throws InterruptedException {
	  // Optional, if not specified, WebDriver will search your path for chromedriver.
	  System.setProperty("webdriver.chrome.driver", "/Users/Anna/Documents/Chromedriver/chromedriver");

	  
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.zipjet.de");
	  Thread.sleep(5000);  // Let the user actually see something!
	  WebElement element = driver.findElement(By.className("language-switcher"));
	 // WebElement element  = browser.driver.findElement(By.id("nav"));;
	  Actions actions = new Actions(driver);
	  		//WebElement mainMenu = driver.findElement(By.id("header"));
	  		actions.moveToElement(element).build().perform();
	  		
	  		Thread.sleep(10000);
	  //searchBox.sendKeys("ChromeDriver");
	 // searchBox.submit();
	  Thread.sleep(5000);  // Let the user actually see something!
	  driver.quit();
	}

}
