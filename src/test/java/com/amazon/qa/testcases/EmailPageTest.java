package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.EmailPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.PasswordPage;


public class EmailPageTest extends TestBase{
EmailPage emailpage;
HomePage homepage;
PasswordPage passwordpage;


	public EmailPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		homepage = new HomePage();
		emailpage = homepage.signInButton();
	}
	
	
	@Test (priority=1)
		public void verifyEmailTitleTest() throws InterruptedException {
		
		String expected= "Amazon Sign In";
		String actual= emailpage.verifyEmailTitle();
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test (priority=2 ,dependsOnMethods= "verifyEmailTitleTest",groups= "smoke")
	public void clickContinueTest() throws InterruptedException {
		passwordpage = emailpage.clickContinue();
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
}
