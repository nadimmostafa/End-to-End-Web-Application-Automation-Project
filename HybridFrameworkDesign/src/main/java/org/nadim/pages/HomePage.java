package org.nadim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// page objects
	By signInBtn = By.partialLinkText("Sign in");

	// methods
	public LoginPage clickOnSignInBtn() {
		driver.findElement(signInBtn).click();
		return new LoginPage(driver);
	}
}
