package de.zipjet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import de.zipjet.framework.BrowserManager;

public class ContactPage extends PageObject {
	
	public ContactPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "btn-submit")
	private WebElement submitButton;
	
	
	@FindBy(id = "firstName")
	private WebElement fieldName;
	
	@FindBy(id = "lastName")
	private WebElement fieldSurname;
	
	@FindBy(id = "email")
	private WebElement fieldEmail;
	
	@FindBy(id = "phoneNumber")
	private WebElement fieldPhone;
	
	@FindBy(id = "addressLine2")
	private WebElement fieldAdditionalAddress;
	
	@FindBy(id = "labelType")
	private WebElement fieldAddressType;
	
	public PaymentPage submitContact(){
		submitButton.click();   
		    return new PaymentPage(driver);
		}

	public ContactPage fillRandomUserData()
	{
		Faker faker = new Faker();
		String firstName = faker.name().firstName(); // Emory
		String lastName = faker.name().lastName(); // Barton
		String additionalAddressCompany = faker.company().toString();
		String phoneNumber = faker.phoneNumber().cellPhone().replaceAll("[\\.\\-\\)\\(]*","");
		String emailAddress = faker.internet().emailAddress();
		fieldName.sendKeys(firstName);
		fieldSurname.sendKeys(lastName);
		fieldAdditionalAddress.sendKeys(additionalAddressCompany.toString());
		fieldPhone.sendKeys((String) phoneNumber);
		fieldEmail.sendKeys(emailAddress);
		
		return this;
	}

	


}
