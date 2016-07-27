package de.zipjet.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import de.zipjet.framework.BrowserManager;

public class ServiceClassPage extends PageObject {
	
	public ServiceClassPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
//probably the first one
	@FindBy(className = "sc")
	private WebElement randomSC;
	
	public TimeSlotsPage pickRandomSC(){
	
		randomSC.click();   
	
			 return new TimeSlotsPage(driver);
		 }
		

	


}
