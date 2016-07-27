package de.zipjet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import de.zipjet.framework.BrowserManager;

public class TimeSlotsPage extends PageObject {
	
	public TimeSlotsPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "btn-submit")
	private WebElement submitButton;
	
	public ContactPage submitTimeSlots(){
		submitButton.click();   
		    return new ContactPage(driver);
		}

	


}
