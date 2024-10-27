package org.nadim.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static XSSFWorkbook wb;

	public static Object[][] getDataFromExcel(String sheetName) {

		Object[][] arr = null;

		try {
			wb = new XSSFWorkbook(
					new FileInputStream(new File(System.getProperty("user.dir") + "/testdata/testData.xlsx")));

			// load sheet
			XSSFSheet sheet = wb.getSheet(sheetName);
			// get row
			int rows = sheet.getPhysicalNumberOfRows();
			// get columns
			int columns = sheet.getRow(0).getPhysicalNumberOfCells();

			arr = new Object[rows - 1][columns];

			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					arr[i-1][j]=getData(sheetName,i,j);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return arr;
	}
	
	public static String getData(String sheet,int row, int col) {
		XSSFCell cell = wb.getSheet(sheet).getRow(row).getCell(col);
		String data="";
		
		if(cell.getCellType()==CellType.STRING) {
			data = cell.getStringCellValue();
		}else if(cell.getCellType()==CellType.NUMERIC) {
			double numericCellValue = cell.getNumericCellValue();
			data = String.valueOf(numericCellValue);
		}else if(cell.getCellType()==CellType.BLANK){
			data="";
		}
		
		return data;
	}
}
