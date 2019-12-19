package selenium.automationpractice;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Test_ShopDresses {

	WebDriver driver;
	
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
		PageProduct page_evening_dresses = page_index.clickHoverEveningDresses(driver);
		assertEquals("EVENING DRESSES", page_evening_dresses.span_evening_dresses.getText().trim());
		TechnicalTools.addToCart(driver, page_evening_dresses.img_printed_dress);
		Thread.sleep(3000);
		page_evening_dresses.btn_continue_shopping.click();
		Thread.sleep(3000);
	}

}
