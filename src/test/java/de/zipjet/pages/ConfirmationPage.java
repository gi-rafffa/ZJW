package de.zipjet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import de.zipjet.framework.BrowserManager;

public class ConfirmationPage extends PageObject {
	
	public ConfirmationPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ".//*[@id='set-password-form']/div[2]/input")
	private WebElement submitPasswordButton;
	
	
	@FindBy(xpath = ".//div[1]/div/div[1]/div/div/div/div[3]/div[1]/ol/li[2]/a")
	private WebElement orderList;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(className = "content-header")
	private WebElement orderResult;
	
	
	public WebElement getOrderResult() {
		return orderResult;
	}
	
	public ConfirmationPage setupPassword()
	{
		passwordField.sendKeys("123123123");
		submitPasswordButton.click();
		return this;
	}
	public ConfirmationPage submitTimeSlots(){
		//submitButton.click();   
		    return this;
		}

	public void checkOrderStatus() {
		Assert.assertTrue(driver.findElement(By.className("content-header")).getText().matches("^[\\s\\S]*Vielen Dank für Deine Bestellung![\\s\\S]*$"));
		
	}

	public OrderListPage openOrderList() {
		orderList.click();
		return new OrderListPage(driver);
	}

	


}
