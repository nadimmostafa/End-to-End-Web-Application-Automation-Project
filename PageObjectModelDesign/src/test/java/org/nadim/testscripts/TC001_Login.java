package org.nadim.testscripts;

import org.nadim.base.BaseClass;
import org.nadim.pages.HomePage;
import org.nadim.pages.LoginPage;
import org.testng.annotations.Test;

public class TC001_Login extends BaseClass{
	
	@Test
	public void verifyLogin() {
		HomePage homePage = new HomePage(driver);
		LoginPage lp = homePage.clickOnSignInBtn();
		lp.login("Admin", "1234");
	}
}
