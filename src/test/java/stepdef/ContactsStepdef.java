package stepdef;

import org.testng.Assert;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.Constants;
import com.qa.utility.Xls_Reader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ContactsStepdef {
	
	private String contactNametoSelect;
	private boolean contactCreated;
	private LoginPage loginPage;
	private HomePage homePage;
	private ContactsPage contactsPage;
	static Xls_Reader reader = new Xls_Reader(Constants.TESTDATA_SHEET_PATH);
	
	
	@Given("user is already in Contacts Page")
	public void user_is_already_in_contacts_page() throws InterruptedException {
		loginPage = new LoginPage(DriverFactory.driver);
		homePage = loginPage.doLogin(ConfigReader.prop.getProperty("username"), ConfigReader.prop.getProperty("password"));
		Thread.sleep(6000);
		contactsPage = homePage.clickOnContactsPage();
	}

	@Given("user gets the contact name to select")
	public void user_gets_the_contact_name_to_select() {
		contactNametoSelect = ConfigReader.prop.getProperty("AccountName");
		System.out.println("The contact to be selected is :" + contactNametoSelect);
	}

	@Then("user should select the contact")
	public void user_should_select_the_contact() {
	    contactsPage.selectContactName(contactNametoSelect);
	}

	@Given("user creates a new contact from given sheetname {string} and  rownumber {int}")
	public void user_creates_a_new_contact_from_given_sheetname_and_rownumber(String sheetName, int rowNumber) throws InterruptedException {
		
		
		String firstName = reader.getCellData(sheetName, "FirstName", rowNumber);
		String lastName = reader.getCellData(sheetName, "LastName", rowNumber); 
		String company = reader.getCellData(sheetName, "Company", rowNumber);
		String description = reader.getCellData(sheetName, "Description", rowNumber);
		String position = reader.getCellData(sheetName, "Position", rowNumber);
		String department = reader.getCellData(sheetName, "Department", rowNumber);
		
		contactCreated = contactsPage.createNewContact(firstName, lastName, company, description, position, department);
		
	}

	@Given("user validates the new contact")
	public void user_validates_the_new_contact() {
	    Assert.assertTrue(contactCreated);
	}
	
}
