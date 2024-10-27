package org.nadim.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserStartUitility {
	private static WebDriver driver;

	public static WebDriver initializeBrowser(String browserName, String url) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Sorry! " + browserName + " not supported and Test run with default browser");
			driver = new ChromeDriver();
		}
		
		//maximize window
		driver.manage().window().maximize();
		//pageLoading timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		//script timeout
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		
		driver.get(url);
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
}
