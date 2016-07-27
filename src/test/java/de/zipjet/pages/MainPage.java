package de.zipjet.pages;

import static org.testng.AssertJUnit.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage extends PageObject {


	@FindBy(id = "addressLine")
	private WebElement addressLine;
	
	@FindBy(id = "header")
	private WebElement header;
	
	@FindBy(linkText = "Login") 
	private WebElement loginLink;
	
	@FindBy(className = "entry lang")
	private WebElement languageControl;
	
	@FindBy(className = "logo")
	private WebElement logo;
	
	@FindBy(className = "address-field-popup-confirm")
	private WebElement confirmButton;
	
	//Ritterstraße 11, 10969 Berlin, Germany
	@FindBy(xpath = ".//*[@id='visual']/div/div/div[1]/form/fieldset/div/input[7]")
	private WebElement checkAvilablityButton;
	

	public MainPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public MainPage setLanguage(String language){
	   // languageControl.sendKeys(email);
	    return this;
	}
	
	public MainPage intentionToClose() throws AWTException, InterruptedException{

		 Actions actions = new Actions(driver);
		 Action mouseOverHome = actions.moveToElement(header, -100,  -50).build();
		 mouseOverHome.perform(); 
		 Thread.sleep(3000);
		return this;
		
	}

	public ServiceClassPage confirmAddress(){
			    confirmButton.click();	    
			    return new ServiceClassPage(driver);	    
	}
	
	public MainPage fillAddress(String address){
		   addressLine.sendKeys(address);
		    return this;
		}
	
	public MainPage checkAddress(){
		checkAvilablityButton.click();   
		    return this;
		}
	
	public LoginPage startLogin(){
		checkAvilablityButton.click();   
		 return new LoginPage();
		}
	public MainPage checkPopUpAppears() {
		//check that pop-up exists and has button
		assertTrue(isElementPresent(By.className("modal")));
		assertTrue(isElementPresent(By.className("modal-btn")));
		//assertTrue(driver.findElement(By.className("modal-btn")).getText().matches("^[\\s\\S]*Los[\\s\\S]*$"));
		//check that pop-up is visible
		Assert.assertEquals(driver.findElement(By.id("ouibounce-modal")).getAttribute("style"), "display: block;");
		return this;
		
	}
	
	public MainPage checkPopUpDontAppear() {
		//Assert.assertEquals(driver.findElements(By.className("modal-btn")).size(),0);
		Assert.assertEquals(driver.findElement(By.id("ouibounce-modal")).getAttribute("style"), "");
		return this;
		
	}
	
	
}
