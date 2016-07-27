package de.zipjet.tests;

import org.testng.annotations.Test;

public class BasicOrderTest extends TestBase {
	@Test
	public void defaultOrder() throws Exception{
		browser.serviceClassPage = browser.mainPage.fillAddress("Ritterstraße 11, 10969 Berlin, Deutschland").checkAddress().confirmAddress();
		browser.timeSlotsPage = browser.serviceClassPage.pickRandomSC();
		browser.contactPage = browser.timeSlotsPage.submitTimeSlots();
		browser.paymentPage = browser.contactPage.fillRandomUserData().submitContact();
		browser.summaryPage = browser.paymentPage.fillDefaultCC().submitPaymentData();
		browser.confirmationPage = browser.summaryPage.acceptTerms().submitOrder();
		browser.confirmationPage.setupPassword();
		browser.confirmationPage.checkOrderStatus();
		browser.orderListPage = browser.confirmationPage.openOrderList();
		browser.orderListPage.checkOrderIsCreated();
		
		
		//browser.mainPage.fillAddress("Ritterstraße 11, 10969 Berlin, Deutschland").checkAddress().confirmAddress();
		//browser.serviceClassPage.pickRandomSC();
		//browser.timeSlotsPage.submitTimeSlots();
	}
}
