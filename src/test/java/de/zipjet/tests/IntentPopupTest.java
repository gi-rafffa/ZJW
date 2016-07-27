package de.zipjet.tests;
import org.testng.annotations.Test;
//https://jira.rocket-internet.de/browse/INTWASH-3279


public class IntentPopupTest extends TestBase {
	
	@Test
	public void popUpForNewCustomerSecondTime() throws Exception{
		cleanSessionCookies();
		refreshPage();
	    browser.mainPage.intentionToClose().checkPopUpAppears();
		Thread.sleep(1000);		
	}
	
	@Test
	public void refreshSessionNotExpiredNoPopup() throws Exception{
		refreshPage();	
	    browser.mainPage.intentionToClose().checkPopUpDontAppear();
		Thread.sleep(1000);		
	}
	
	@Test
	public void firstVisitNoPopup() throws Exception{
	    browser.mainPage.intentionToClose().checkPopUpDontAppear();
		Thread.sleep(1000);		
	}
	
	@Test
	public void thirdVisitNoPopup() throws Exception{
		cleanSessionCookies();
		refreshPage();
		cleanSessionCookies();
		refreshPage();
		browser.mainPage.intentionToClose().checkPopUpDontAppear();
		Thread.sleep(1000);		
}}
