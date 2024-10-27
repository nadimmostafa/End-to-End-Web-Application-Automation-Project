package org.nadim.testscripts;

import org.nadim.base.BaseClass;
import org.nadim.dataprovider.CustomDataProvider;
import org.nadim.pages.HomePage;
import org.nadim.pages.LoginPage;
import org.testng.annotations.Test;

public class TC001_VerifyLogin extends BaseClass{
	
	@Test(dataProvider = "testData", dataProviderClass = CustomDataProvider.class)
	public void verifyLoginFunctionality(String userName, String pwd) {
		HomePage homePage = new HomePage(driver);
		LoginPage lp = homePage.clickOnSignInBtn();
		lp.login(userName, pwd);
	}
}
