package org.nadim.base;

import org.nadim.utility.BrowserStartUitility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;
	String url = "http://www.automationpractice.pl/index.php";
	//String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeClass
	public void startUp() {
		driver = BrowserStartUitility.initializeBrowser("chrome", url);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
