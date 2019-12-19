package selenium.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageMyAccount extends PageMenu {
	
	@FindBy(xpath ="//h1")
	WebElement h1_myaccount;
	
	@FindBy(xpath = "//div[2]/ul/li/a/span")
	WebElement btn_wishlists;
	
	public PageWishlist clickWishlist(WebDriver driver) {
		btn_wishlists.click();
		return PageFactory.initElements(driver, PageWishlist.class);
	}
}
