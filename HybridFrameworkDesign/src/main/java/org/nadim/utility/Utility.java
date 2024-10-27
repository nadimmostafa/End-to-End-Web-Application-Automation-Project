package org.nadim.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Utility {

	// click element
	public static void clickOnElement(WebDriver driver, By locator) {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			try {
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(locator)).click().build().perform();
			} catch (Exception e2) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", driver.findElement(locator));
			}
		}
	}

	// custom wait
	public static Alert waitForAlert(WebDriver driver, int time) {
		Alert alt = null;
		for (int i = 0; i <= time; i++) {
			try {
				alt = driver.switchTo().alert();
			} catch (Exception e) {
				System.out.println("No alert Found! wait for Alert");
				waitforSeconds(1);
			}
		}
		return alt;
	}

	public static void waitforSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// capture screenshot in base64string
	public static String captureScreenshotInBase64String(WebDriver driver) {
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		ts.getScreenshotAs(OutputType.BASE64);
		String screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return screenshotAs;
	}
	
	//generate any file name
	public static String getDateTime() {
		return new SimpleDateFormat("HH_mm_ss_dd_MM_yy").format(new Date());
	}

}
