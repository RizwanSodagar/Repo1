package com.amazon.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.EmailPage;
import com.amazon.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage homepage;
	EmailPage emailpage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		homepage = new HomePage();
	}
	
	
	@Test (priority=1)
	public void logoTest() throws InterruptedException{
		
	boolean flag = homepage.verifyLogo();
	System.out.println(flag);
	Assert.assertTrue(flag, "Logo is not displayed");
	Thread.sleep(3000);
	}
	
	@Test (priority=2)
	public void verfiyTitleTest() throws InterruptedException
	{
		String title= homepage.verifyTitle();
		Assert.assertEquals(title, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
		System.out.println(title);
		
	}
	@Test (priority=3 )
	public void allDepartmentTest() throws InterruptedException{
		homepage.allDepartment();
		Thread.sleep(3000);
	}
	
	@Test (priority=4 ,groups= "smoke")
	public void signInButtonTest() throws InterruptedException{
		emailpage = homepage.signInButton();
		Thread.sleep(3000);
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

		
	
	
}
