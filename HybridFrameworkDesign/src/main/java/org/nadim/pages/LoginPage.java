package org.nadim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	// create constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// page objects
	private By emailAddress = By.id("email");
	private By password = By.id("passw");
	private By forgotPwd = By.partialLinkText("Forgot your password?");
	private By signIn = By.id("SubmitLogin");

	// methods
	public void login(String uname, String pwd) {
		driver.findElement(emailAddress).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signIn).click();
	}

	public void forgotPwd() {
		driver.findElement(forgotPwd).click();
	}
}
