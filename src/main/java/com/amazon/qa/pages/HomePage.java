package com.amazon.qa.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(id="nav-logo")
	WebElement AmazonLogo;
	
	@FindBy(xpath = "(//div[@class='nav-left'])[2]")
     WebElement link;
	
	@FindBy(xpath = "//select[@id='searchDropdownBox']/option")
    List<WebElement> list;

	
	@FindBy(id="nav-link-accountList")
	WebElement SignInButton;
//Initializing the page Objects
	public HomePage() {	//constructor
		PageFactory.initElements(driver, this);		
	}
	
	//Actions
	public boolean verifyLogo() {
		return	AmazonLogo.isDisplayed();
		
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public void allDepartment() {
		link.click();
		System.out.println("Total departments: " + list.size());

		for (int i = 0; i < (list.size()); i++) {
			System.out.println(list.get(i).getText());
		}

		
	}
	
	public EmailPage signInButton() {
		SignInButton.click();
		return new EmailPage();
	}
	
	
}
