package com.amazon.qa.pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.base.TestBase;

public class MainUserPage extends TestBase {
	
	@FindBy(id="nav-global-location-slot")
	WebElement locationLabel;
	
	@FindBy(id="GLUXZipUpdateInput_0")
	WebElement Input_0;
	
	@FindBy(id="GLUXZipUpdateInput_1")
	WebElement Input_1;
	
	@FindBy(xpath="//span[@id='GLUXZipUpdate-announce']/..")
	WebElement apply;
	
	@FindBy (xpath="//span[@class='nav-line-2 ']/..")
	WebElement accountList;
	
	@FindBy(id = "twotabsearchtextbox")
	public WebElement inputBox;
	
	@FindBy(id = "icp-nav-flyout")
	public WebElement language;

	
	//@FindBy(xpath = "(//div[@class='nav-left'])[2]")
	//public WebElement link;
	
	@FindBy(xpath = "//div[@id='nav-flyout-searchAjax']//div")
	public List<WebElement> list;

	
	@FindBy(xpath="//div[starts-with(@id,'CardInstance')]//div/a[2]")
	public WebElement rightNext;
	
	@FindBy(className = "navFooterBackToTop")
	public WebElement top;
	
	@FindBy (xpath= "//span[contains(text(),'Sign Out')]")
	WebElement signout;

	public MainUserPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public String verifyUserPageTitle() {
		return driver.getTitle();
	}
	
	
	
	public void hoverOnAccountList() throws InterruptedException{
		Actions builder = new Actions(driver);
		builder.moveToElement(accountList).build().perform();
		Thread.sleep(4000);
		
	}
	public boolean verfiySignoutElement() {
		boolean present =signout.isDisplayed();
		return present;
	}
	
	public void searchIteam() throws InterruptedException {
		//driver.navigate().refresh();
		inputBox.sendKeys("The Secret book");

		//Thread.sleep(2000);

		System.out.println("Total departments: " + list.size());

		for (int i = 0; i < (list.size()); i++) {
			System.out.println(list.get(i).getText());
		}

	}
		
	
	public void scrollUpDown() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(1177, 1347)");
		System.out.println(rightNext.getLocation());
		Thread.sleep(3000);
        rightNext.click();
		//rightNext.click();
		Thread.sleep(2000);
		
		
		jse.executeScript("arguments[0].scrollIntoView(true);", top);
		Thread.sleep(2000);
		top.click();
		Thread.sleep(2000);
	}
	
	
	public void enterPostalCode(String pos1, String pos2) throws InterruptedException {		
		Thread.sleep(5000);
		locationLabel.click();
		Input_0.click();
	
		Input_0.clear();
		Input_0.sendKeys(pos1);
		Input_1.clear();
		Input_1.sendKeys(pos2);
		
		apply.click();
		Thread.sleep(5000);
	}
	
	public void signOutTest() {	
		signout.click();

	}
	
}
