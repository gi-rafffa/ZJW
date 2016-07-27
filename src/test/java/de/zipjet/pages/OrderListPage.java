package de.zipjet.pages;

import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderListPage extends PageObject {
	
	@FindBy(className = "current-order-0")
	private WebElement currentOrder;
	
	public OrderListPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public OrderListPage checkOrderIsCreated()
	{
		assertTrue(isElementPresent(By.id("current-order-0")));
		return this;
	}

	
}
