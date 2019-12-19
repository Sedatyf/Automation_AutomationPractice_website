package selenium.automationpractice;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Test_Wishlist {

	WebDriver driver;

	// JDD
	String email_address = "test@shopping.com";
	String password = "azerty";

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
		assertEquals("ALREADY REGISTERED?", page_login.h3_already_registered.getText());
		TechnicalTools.fillInput(page_login.input_email_already, email_address);
		TechnicalTools.fillInput(page_login.input_password_already, password);
		
		PageMyAccount page_account = page_login.clickLogIn(driver);
		assertEquals("MY ACCOUNT", page_account.h1_myaccount.getText());
		
		PageWishlist page_wishlist = page_account.clickWishlist(driver);
		assertEquals("MY WISHLISTS", page_wishlist.h1_my_wishlists.getText());
		TechnicalTools.fillInput(page_wishlist.input_name, "Printed");
		page_wishlist.btn_save.click();
		assertEquals("Created", page_wishlist.cell_created.getText());
		page_wishlist.btn_delete.click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
	}

}
