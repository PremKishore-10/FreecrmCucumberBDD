package stepdef;

import com.pages.CalendarPage;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CalendarStepdef {
	
	private String datetoSelect;
	private LoginPage loginPage;
	private HomePage homePage;
	private CalendarPage calendarPage;
	
	
	@Given("user is already in Calendar Page")
	public void user_is_already_in_calendar_page() throws InterruptedException {
		loginPage = new LoginPage(DriverFactory.driver);
		homePage = loginPage.doLogin(ConfigReader.prop.getProperty("username"), ConfigReader.prop.getProperty("password"));
		Thread.sleep(6000);
		calendarPage = homePage.clickOnCalendarPage();
	}

	@Given("user gets the date to select")
	public void user_gets_the_date_to_select() {
		datetoSelect = ConfigReader.prop.getProperty("date");
		System.out.println("The date to be selected is :" + datetoSelect);
	}

	@Then("user should select the date")
	public void user_should_select_the_date() {
	    calendarPage.selectDate(datetoSelect);
	}

}
