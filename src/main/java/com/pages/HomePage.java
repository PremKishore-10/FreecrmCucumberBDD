package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.util.ElementUtil;

public class HomePage {
	
	private WebDriver driver;
	Actions action;
	
	private By accname = By.xpath("//span[text()='Prem Kishore']");
	private By calendaricon = By.xpath("//a[@class='item']/following::i[@class='calendar icon']");
	private By contactsicon = By.xpath("//a[@class='item']/following::i[@class='users icon']");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String validateAccounttitle() {
		return driver.getTitle();
	}
	
	
	public String validateAccName() {
		return driver.findElement(accname).getText();
	}
	
	public CalendarPage clickOnCalendarPage() {
		
		action = new Actions(driver);
		action.moveToElement(driver.findElement(calendaricon)).click().build().perform();
		
		
		//ElementUtil.actionmovement(driver.findElement(calendaricon));
		return new CalendarPage(driver);
	}
	
	public ContactsPage clickOnContactsPage() {
		
		action = new Actions(driver);
		action.moveToElement(driver.findElement(contactsicon)).click().build().perform();
		
		//ElementUtil.actionmovement(driver.findElement(contactsicon));
		driver.findElement(contactsicon).click();
		return new ContactsPage(driver);
	}

}
