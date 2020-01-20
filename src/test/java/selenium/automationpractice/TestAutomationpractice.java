package selenium.automationpractice;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestAutomationpractice {
	
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
	public void testAutomationPractice() throws Exception {
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[contains(@title, 'Log in')]")).click();
		assertEquals("AUTHENTICATION", driver.findElement(By.xpath("//h1")).getText());
		
		driver.findElement(By.id("email_create")).sendKeys("test@shopping.com");
		driver.findElement(By.id("SubmitCreate")).click();
		assertEquals("YOUR PERSONAL INFORMATION", driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/h3")).getText());
		
		driver.findElement(By.id("uniform-id_gender1")).click();
		WebElement input_cu_firstname = driver.findElement(By.id("customer_firstname"));
		WebElement input_cu_lastname = driver.findElement(By.id("customer_lastname"));
		TechnicalTools.fillInput(input_cu_firstname, "Jean-Michel");
		TechnicalTools.fillInput(input_cu_lastname, "Testeur");
		WebElement input_password = driver.findElement(By.id("passwd"));
		TechnicalTools.fillInput(input_password, "azerty");
		

		Select select_days = new Select(driver.findElement(By.id("days")));
		select_days.selectByValue("10");
		
		Select select_months = new Select(driver.findElement(By.id("months")));
		select_months.selectByValue("2");
		
		Select select_years = new Select(driver.findElement(By.id("years")));
		select_years.selectByValue("1995");
		
		WebElement input_addr_firstname = driver.findElement(By.id("firstname"));
		WebElement input_addr_lastname = driver.findElement(By.id("lastname"));
		TechnicalTools.fillInput(input_addr_firstname, "Jean-Michel");
		TechnicalTools.fillInput(input_addr_lastname, "Testeur");
		WebElement input_addr_address1 = driver.findElement(By.id("address1"));
		TechnicalTools.fillInput(input_addr_address1, "2 Avenue Dany Brillant");
		WebElement input_addr_city = driver.findElement(By.id("city"));
		TechnicalTools.fillInput(input_addr_city, "Paris");
		
		Select select_state = new Select(driver.findElement(By.id("id_state")));
		select_state.selectByValue("43");
		
		WebElement input_zip = driver.findElement(By.id("postcode"));
		TechnicalTools.fillInput(input_zip, "75460");
		
		WebElement input_mobile = driver.findElement(By.id("phone_mobile"));
		TechnicalTools.fillInput(input_mobile, "0606060606");
		
		driver.findElement(By.id("submitAccount")).click();
		assertEquals("MY ACCOUNT", driver.findElement(By.xpath("//h1")).getText());
		
		WebElement clickLogo = driver.findElement(By.xpath("//img[contains(@src, 'logo.jpg')]"));
		clickLogo.click();
		
		Actions action = new Actions(driver);
	}

}
