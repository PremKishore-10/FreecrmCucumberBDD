package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContactsPage {
	
	private WebDriver driver;
	Actions action;
	
	private By contactsicon = By.xpath("//a[@class='item']/following::i[@class='users icon']");
	private By accName = By.xpath("//span[text()='Prem Kishore']");
	private By FirstName = By.name("first_name");
	private By LastName = By.name("last_name");
	private By Company = By.xpath("//label[text()='Company']/parent::div//child::div//input");
	private By Description = By.name("description");
	private By Position = By.name("position");
	private By Department = By.name("department");
	private By Category = By.xpath("//label[text()='Category']//following::div[@name='category']");
	private By Lead = By.xpath("//span[text()='Lead']");
	private By Save = By.xpath("//button[text()='Save']");
	private By Create = By.xpath("//button[text()='Create']");
	private By createdContact = By.xpath("//tbody//tr//td[2]//a");
	

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectContactName(String ContactName) {
		
		action = new Actions(driver);
		
		action.moveToElement(driver.findElement(accName)).click().build().perform();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='"+ContactName+"']/parent::td//preceding-sibling::td//input[@name='id']"))).click().build().perform();
		
		//ElementUtil.actionmovement(driver.findElement(accName));
		//ElementUtil.actionmovement(driver.findElement(By.xpath("//a[text()='"+ContactName+"']/parent::td//preceding-sibling::td//input[@name='id']")));
		//driver.findElement(By.xpath("//a[text()='"+ContactName+"']/parent::td//preceding-sibling::td//input[@name='id']")).click();
	}
	
public boolean createNewContact(String firstName, String lastName, String company, String description, String position,String department) throws InterruptedException {
		
		action = new Actions(driver);
		
	
	
	    driver.findElement(Create).click();
		driver.findElement(FirstName).sendKeys(firstName);
		driver.findElement(LastName).sendKeys(lastName);
		driver.findElement(Company).sendKeys(company);
		driver.findElement(Description).sendKeys(description);
		driver.findElement(Position).sendKeys(position);
		driver.findElement(Department).sendKeys(department);
		driver.findElement(Category).click();
		driver.findElement(Lead).click();
		driver.findElement(Save).click();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(contactsicon)).click().build().perform();
		action.moveToElement(driver.findElement(accName)).click().build().perform();
		//ElementUtil.actionmovement(driver.findElement(contactsicon));
		//ElementUtil.actionmovement(driver.findElement(accName));
		String contactCreatedNow =  driver.findElement(createdContact).getText();
		boolean contactIsCreated = contactCreatedNow.equalsIgnoreCase(firstName+' '+lastName);
		return contactIsCreated;
		
	}

}
