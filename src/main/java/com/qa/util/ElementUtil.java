package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtil {
	
	public static WebDriver driver;
	static Workbook book;
	static Sheet sheet;
	
	public static void actionmovement(WebElement locator) {
		Actions action = new Actions(driver);
		action.moveToElement(locator).click().build().perform();
	}
	
//public static Object[][] getDataFromExcel(String sheetName){
//		
//		FileInputStream file = null;
//		try {
//			file = new FileInputStream(Constants.TESTDATA_SHEET_PATH);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			book = WorkbookFactory.create(file);
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//		sheet = book.getSheet(sheetName);
//		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		
//		for (int i=0; i < sheet.getLastRowNum(); i++) {
//			for (int j= 0; j < sheet.getRow(0).getLastCellNum(); j++) {
//				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
//			}
//		}
//		return data;
//	}

}
