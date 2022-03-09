package com.qa.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.ConfigReader;
import com.qa.util.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver driver;
	//public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	//this is to initialize the thread local driver on the basis of given browser
	public WebDriver init_driver(String browser) throws InterruptedException {
		System.out.println(browser);
		if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			tlDriver.set(new ChromeDriver());
			System.setProperty("webdriver.chrome.driver", "D:/eclipse/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			tlDriver.set(new FirefoxDriver());
			System.setProperty("webdriver.gecko.driver", "D:/eclipse/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("Please pass the valid browser name");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		return driver;
		
		
	}
	
//	public static synchronized WebDriver getDriver() {
//		return tlDriver.get();
//	}
	
}
