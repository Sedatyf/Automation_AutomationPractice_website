package selenium.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TechnicalTools {

	static WebDriver driver;

	static WebDriver chooseBrowser(EBrowsers e) {
		switch (e) {
		case Chrome:
			System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Le navigateur choisis est Chrome");
			return driver;
		case Firefox:
			System.out.println("Le navigateur choisis est Firefox");
			return driver;
		default:
			System.out.println("Veuillez choisir un navigateur");
			return null;
		}
	}
	
	static void fillInput(WebElement e, String s) {
		e.clear();
		e.sendKeys(s);
	}
}
