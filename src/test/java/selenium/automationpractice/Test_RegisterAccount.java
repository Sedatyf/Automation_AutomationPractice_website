package selenium.automationpractice;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Test_RegisterAccount {

	WebDriver driver;

	// JDD
	String email_create = "test@shop.com";
	int gender = 1;
	String firstname = "Michel";
	String lastname = "Testeur";
	String password = "azerty";
	String day = "10";
	String month = "2";
	String year = "1995";
	String address = "5 rue Jean-Michel Blanquer";
	String city = "Paris";
	String state_value = "43";
	String postcode = "75462";
	String phone_number = "555-555-555";

	@Before
	public void launchBrowser() {
		driver = TechnicalTools.chooseBrowser(EBrowsers.Chrome);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");

		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
		PageLogin page_login = page_index.clickSignIn(driver);
		assertEquals("AUTHENTICATION", page_login.h1_authentication.getText());
		assertEquals("CREATE AN ACCOUNT", page_login.h3_create_account.getText());

		TechnicalTools.fillInput(page_login.input_email_create, email_create);
		PageCreateAccount page_create_account = page_login.clickCreateAccount(driver);
		assertEquals("YOUR PERSONAL INFORMATION", page_create_account.h3_personal_information.getText());
		page_create_account.chooseGender(driver, gender);
		TechnicalTools.fillInput(page_create_account.input_customer_firstname, firstname);
		TechnicalTools.fillInput(page_create_account.input_customer_lastname, lastname);
		TechnicalTools.fillInput(page_create_account.input_password, password);
		page_create_account.selectDateBirth(day, month, year);
		TechnicalTools.fillInput(page_create_account.input_address_firstname, firstname);
		TechnicalTools.fillInput(page_create_account.input_address_lastname, lastname);
		TechnicalTools.fillInput(page_create_account.input_address_1, address);
		TechnicalTools.fillInput(page_create_account.input_city, city);
		page_create_account.selectState(state_value);
		TechnicalTools.fillInput(page_create_account.input_postcode, postcode);
		TechnicalTools.fillInput(page_create_account.input_mobile_phone, phone_number);

		Thread.sleep(5000);
	}

}
