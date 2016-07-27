package de.zipjet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import de.zipjet.framework.BrowserManager;

public class PaymentPage extends PageObject {
	
	public PaymentPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "btn-submit")
	private WebElement submitButton;

	@FindBy(id = "adyen-encrypted-form-holder-name")
	private WebElement cardHolder;
	
	@FindBy(id = "adyen-encrypted-form-number")
	private WebElement cardNumber;
	
	@FindBy(id = "adyen-card-expiry")
	private WebElement cardExpiryDate;
	
	@FindBy(id = "adyen-encrypted-form-cvc")
	private WebElement cardCVC;
	
	public PaymentPage fillDefaultCC() {
		cardHolder.sendKeys("Default Holder");
		cardNumber.sendKeys("4111");
		cardNumber.click();
		cardNumber.sendKeys("1111");
		cardNumber.click();
		cardNumber.sendKeys("1111");
		cardNumber.click();
		cardNumber.sendKeys("1111");
		cardExpiryDate.sendKeys("08");
		cardNumber.click();
		cardExpiryDate.sendKeys("18");
		cardCVC.sendKeys("737");
		return this;
	}
	public SummaryPage submitPaymentData(){
		submitButton.click();   
		    return new SummaryPage(driver);
		}

	


}
