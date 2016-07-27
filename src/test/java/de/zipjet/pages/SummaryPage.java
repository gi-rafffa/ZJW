package de.zipjet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import de.zipjet.framework.BrowserManager;

public class SummaryPage extends PageObject {
	
	public SummaryPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ".//*[@id='formConfirm']/div[4]/input")
	private WebElement submitButton;
	
	@FindBy(id = "acceptedTerms")
	private WebElement acceptTerms;
	
	public SummaryPage acceptTerms()
	{
		acceptTerms.click();
		return this;
	}
	
	public ConfirmationPage submitOrder(){
		submitButton.click();   
		    return new ConfirmationPage(driver);
		}

	


}
