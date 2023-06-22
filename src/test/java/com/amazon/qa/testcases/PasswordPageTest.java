package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.EmailPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.MainUserPage;
import com.amazon.qa.pages.PasswordPage;

public class PasswordPageTest extends TestBase{
    HomePage homepage;
	EmailPage emailpage;
	PasswordPage passwordpage;	
	MainUserPage mainuserpage;
	
	public PasswordPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		initialization();
		homepage= new HomePage();
		emailpage = homepage.signInButton();
		passwordpage= emailpage.clickContinue();
		
	}

	
@Test (priority=1 ,groups= "smoke")
public void enterPasswordTest() throws InterruptedException {
	String expected= "Amazon Sign In";
	String actual= passwordpage.verifyPasswordTitle();
	System.out.println(actual);
	Assert.assertEquals(expected, actual);
	mainuserpage = passwordpage.enterPassword();
	
}

@AfterMethod
public void tearDown() {
	
	driver.quit();
}

	
	
	
}


