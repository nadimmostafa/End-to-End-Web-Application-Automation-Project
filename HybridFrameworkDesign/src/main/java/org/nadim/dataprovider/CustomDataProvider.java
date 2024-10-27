package org.nadim.dataprovider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	
	@DataProvider(name="testData")
	public Object[][] getData(){
		return ExcelReader.getDataFromExcel("Login");
	}
}
