package stepdef;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepdef{
	
	private String title;
	LoginPage loginPage;
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		loginPage = new LoginPage(DriverFactory.driver);
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is : "+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String ExpectedTitle) {
	    Assert.assertTrue(title.contains(ExpectedTitle));
	}

	@When("user enters username password and clicks on Login button")
	public void user_enters_username_password_and_clicks_on_Login_button() {
		loginPage.doLogin(ConfigReader.prop.getProperty("username"), ConfigReader.prop.getProperty("password"));
	    
	}

	

}
