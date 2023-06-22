package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class EmailPage extends TestBase{
	
	
	@FindBy(id="ap_email")
	WebElement email;
	
	

	@FindBy(id="continue")
	WebElement Continue;
	


public EmailPage() {
	PageFactory.initElements(driver, this);		
}

public String verifyEmailTitle() {
	return driver.getTitle();
}

public PasswordPage clickContinue() throws InterruptedException {
	email.sendKeys(prop.getProperty("username"));
	Thread.sleep(3000);
	Continue.click();
	return new PasswordPage();
}
}