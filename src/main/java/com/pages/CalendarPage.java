package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarPage {
	
	private WebDriver driver;
	String monthVal;
	String monthName;
	String dateyear;
	int monthYear;
	boolean flag = false;
	final int totalWeekDays = 7;
	
	private By currentMonthOnPage = By.xpath("//*[@id='main-content']/div/div[2]/div/div[2]/div/div[1]/span[2]");
	private By rightside = By.xpath("//i[@class='chevron right icon']");
	private By leftside = By.xpath("//i[@class='chevron left icon']");
	

	public CalendarPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectDate(String Date) {
		String date = Date;
		String dateArr[] = date.split("/");
		String day = dateArr[0];
		String month = dateArr[1];
		String DateYear = dateArr[1] + ' ' + dateArr[2];
		System.out.println(DateYear);
		int year = Integer.parseInt(dateArr[2]);
		
		monthVal = driver.findElement(currentMonthOnPage).getText();
		
		String monthArr[] = monthVal.split(" ");
		monthName = monthArr[0];
		monthYear = Integer.parseInt(monthArr[1]);
		dateyear = monthArr[0] + ' ' + monthArr[1];
		
		if(monthYear < year) {
			while(flag == false) {
				while (DateYear != dateyear) {
					driver.findElement(rightside).click();
				
				monthVal = driver.findElement(currentMonthOnPage).getText();
				
				String montharr[] = monthVal.split(" ");
				monthName = montharr[0];
				monthYear = Integer.parseInt(montharr[1]);
				dateyear = montharr[0] + ' ' + montharr[1];
				
				if(DateYear.equalsIgnoreCase(dateyear)) {
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}}
		}
		else {
			while (flag = false) {
				while(DateYear != dateyear) {
					driver.findElement(rightside).click();
					
					monthVal = driver.findElement(currentMonthOnPage).getText();
					
					String montharr[] = monthVal.split(" ");
					monthName = montharr[0];
					monthYear = Integer.parseInt(montharr[1]);
					dateyear = montharr[0] + ' ' + montharr[1];
					
					if(DateYear.equalsIgnoreCase(dateyear)) {
						flag = true;
						break;
					}
				}
				if(flag) {
					break;
				}
			}
		}
		
		String beforeXpath = "//*[@id=\"main-content\"]/div/div[2]/div/div[2]/div/div[2]/div[";
		String afterXpath = "]/div[2]/div/div[";
		String endXpath = "]/a";
		flag = false;
		
		for (int rowNum = 2; rowNum <= 7; rowNum++) {
			for (int colNum = 1; colNum <= totalWeekDays; colNum++) {
				String dayVal = driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + endXpath))
						.getText();
				System.out.println(dayVal);
				if (dayVal.equalsIgnoreCase(day)) {
					driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + endXpath)).click();
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
	}

}
