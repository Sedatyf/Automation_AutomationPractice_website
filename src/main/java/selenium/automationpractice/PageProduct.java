package selenium.automationpractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageProduct extends PageMenu {

	@FindBy(xpath = "//h1/span[1]")
	WebElement span_evening_dresses;

	@FindBy(xpath = "//img[@title='Printed Dress']")
	WebElement img_printed_dress;

}
