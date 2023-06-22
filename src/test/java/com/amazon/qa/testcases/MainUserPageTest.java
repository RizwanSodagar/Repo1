package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.EmailPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.MainUserPage;
import com.amazon.qa.pages.PasswordPage;
import com.amazon.qa.util.TestUtil;

public class MainUserPageTest extends TestBase {

	MainUserPage mainuserpage;
	EmailPage emailpage;
	PasswordPage passwordpage;
	HomePage homepage;
	
	String sheetName="Amazon";

	MainUserPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {

		initialization();

		homepage = new HomePage();
		emailpage = homepage.signInButton();
		passwordpage = emailpage.clickContinue();
		mainuserpage = passwordpage.enterPassword();
        //mainuserpage = new MainUserPage();

	}
	

	@Test(priority = 1)
	public void searchIteamTest() throws InterruptedException {
		mainuserpage.searchIteam();
		//Thread.sleep(2000);


	}
	
	@Test(priority = 2)
	public void scrollUpDownTest() throws InterruptedException {
		mainuserpage.scrollUpDown();
		
		
	}
	
	@DataProvider
	public Object[][] getPostalData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=3, dataProvider = "getPostalData")
	public void addingPostalCode(String code0, String code1) throws InterruptedException {
		mainuserpage.enterPostalCode(code0,code1);
	}
	
	@Test(priority = 4)
	public void signOutTest() throws InterruptedException {
		mainuserpage.hoverOnAccountList();
		boolean signoutbutton = mainuserpage.verfiySignoutElement();
		Assert.assertTrue(signoutbutton, "SignOut button is not displyed.");
		mainuserpage.signOutTest();

	}


	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
