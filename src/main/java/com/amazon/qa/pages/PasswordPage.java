package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class PasswordPage extends TestBase{
	
	
	@FindBy(id="ap_password")
	WebElement pswrd;
	
	@FindBy(id="signInSubmit")
	WebElement signInSubmit;
	
	

public PasswordPage() {
	PageFactory.initElements(driver, this);		
}

public String verifyPasswordTitle() {
	return driver.getTitle();
}

public  MainUserPage enterPassword() throws InterruptedException {
	pswrd.sendKeys(prop.getProperty("password"));
	Thread.sleep(3000);
	signInSubmit.click();
	 return new MainUserPage();
}
	
	
 
 
	
}
	
	
	
	
	







