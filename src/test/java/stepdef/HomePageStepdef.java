package stepdef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.CalendarPage;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepdef{
	
	private String accountName;
	
	private LoginPage loginPage;
	private HomePage homePage;
	private ContactsPage contactsPage;
	private CalendarPage calendarPage;
	
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application() throws InterruptedException {
		loginPage = new LoginPage(DriverFactory.driver);
		homePage = loginPage.doLogin(ConfigReader.prop.getProperty("username"), ConfigReader.prop.getProperty("password"));
		Thread.sleep(6000);
	}

	@Given("user is on Home Page")
	public void user_is_on_home_page() throws InterruptedException {
	    System.out.println(homePage.validateAccounttitle());
	}

	@When("user gets the account name")
	public void user_gets_the_account_name() {
		accountName = homePage.validateAccName();
		System.out.println("Account Name is : "+accountName);
	}

	@Then("account name should be valid")
	public void account_name_should_be_valid() {
	    Assert.assertEquals(accountName, ConfigReader.prop.getProperty("AccountName"));
	}

	@Then("user should click on Contacts icon")
	public void user_should_click_on_contacts_icon() {
	    contactsPage = homePage.clickOnContactsPage();
	}

	@Then("user should click on Calendar icon")
	public void user_should_click_on_calendar_icon() {
	    calendarPage = homePage.clickOnCalendarPage();
	}

}
