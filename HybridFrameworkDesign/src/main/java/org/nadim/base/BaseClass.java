package org.nadim.base;

import org.nadim.browserfactory.BrowserFactory;
import org.nadim.dataprovider.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass
	public void startUp() {
		driver = BrowserFactory
				.initializeBrowser(ConfigReader
						.getPropertyData("browser"), ConfigReader.getPropertyData("application-url"));
	}
	
	@AfterClass
	public void tearUp() {
		driver.close();
	}
}
