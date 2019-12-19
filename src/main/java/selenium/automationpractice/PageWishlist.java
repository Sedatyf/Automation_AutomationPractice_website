package selenium.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageWishlist extends PageMenu {

	@FindBy(xpath = "//h1")
	WebElement h1_my_wishlists;

	@FindBy(xpath = "//*[@id=\"best-sellers_block_right\"]/div/ul/li[3]/a/img")
	WebElement product_blouse;

	@FindBy(id = "name")
	WebElement input_name;

	@FindBy(id = "submitWishlist")
	WebElement btn_save;

	@FindBy(xpath = "//tr/th[4]")
	WebElement cell_created;

	@FindBy(xpath = "//a[@class='icon']")
	WebElement btn_delete;

	public void putItemList(WebDriver driver) {
		Actions action = new Actions(driver);
		action.dragAndDrop(product_blouse, input_name).build().perform();
	}

}
