package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait waitElement;
	public static WebElement hoverElement;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {

		try {

			FileInputStream f = new FileInputStream(
					"C:/QA/SeleniumWorkSpace/AmazonWebsite/src/main/java/com/amazon/qa/config/config.properties");

			prop = new Properties();
			prop.load(f);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else {
			driver = new SafariDriver();
		}
         
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
//		waitElement = new WebDriverWait(driver,Duration.ofSeconds(20));
//		waitElement.until(ExpectedConditions.elementToBeClickable(By.id("nav-tools")));
		driver.navigate().refresh();

	}

	public static void hoverToElement(WebElement hoverElement) {

		Actions builder = new Actions(driver);
		builder.moveToElement(hoverElement).build().perform();
	}

	public static void explicitWait() {
		waitElement = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
}
