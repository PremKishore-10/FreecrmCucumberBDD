package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By email = By.name("email");
	private By password = By.name("password");
	private By loginbtn = By.xpath("//div[text()='Login']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage doLogin(String un, String pwd) {
		driver.findElement(email).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbtn).click();
		return new HomePage(driver);
		
	}

}
