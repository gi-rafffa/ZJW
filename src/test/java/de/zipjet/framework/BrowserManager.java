package de.zipjet.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.zipjet.pages.ContactPage;
import de.zipjet.pages.MainPage;
import de.zipjet.pages.OrderListPage;
import de.zipjet.pages.PaymentPage;
import de.zipjet.pages.ServiceClassPage;
import de.zipjet.pages.SummaryPage;
import de.zipjet.pages.TimeSlotsPage;
import de.zipjet.pages.ConfirmationPage;

public class BrowserManager {
	public  WebDriver driver;
	public  String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	public MainPage mainPage;
	public ServiceClassPage serviceClassPage;
	public TimeSlotsPage timeSlotsPage;
	public ContactPage contactPage;
	public PaymentPage paymentPage;
	public SummaryPage summaryPage;
	public ConfirmationPage confirmationPage;
	public OrderListPage orderListPage;
	


	public BrowserManager() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setEnableNativeEvents(true);
		   driver = new FirefoxDriver(profile);
		//driver = new ChromeDriver();
		    //baseUrl = "https://staging.zipjet.de/";
		  //  http://UserName:Password@Example.com
		    baseUrl = "  http://intwash:cleanmeup@www-qa-8.qa.zipjet.de";  
		    WebDriverWait wait = new WebDriverWait(driver, 15); 
		    driver.get(baseUrl);
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    mainPage = new MainPage(driver); 
	}
	
	public void stop() {
		 driver.quit();
		    
	}}

