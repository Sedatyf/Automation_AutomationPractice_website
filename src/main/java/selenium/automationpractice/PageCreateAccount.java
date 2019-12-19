package selenium.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageCreateAccount {

	@FindBy(xpath = "//div[1]/h3")
	WebElement h3_personal_information;

	@FindBy(id = "customer_firstname")
	WebElement input_customer_firstname;

	@FindBy(id = "customer_lastname")
	WebElement input_customer_lastname;

	@FindBy(id = "passwd")
	WebElement input_password;

	@FindBy(id = "days")
	WebElement select_days;

	@FindBy(id = "months")
	WebElement select_months;

	@FindBy(id = "years")
	WebElement select_years;

	@FindBy(id = "firstname")
	WebElement input_address_firstname;

	@FindBy(id = "lastname")
	WebElement input_address_lastname;

	@FindBy(id = "address1")
	WebElement input_address_1;

	@FindBy(id = "city")
	WebElement input_city;

	@FindBy(id = "id_state")
	WebElement select_state;

	@FindBy(id = "postcode")
	WebElement input_postcode;

	@FindBy(id = "phone_mobile")
	WebElement input_mobile_phone;

	public void chooseGender(WebDriver driver, int gender) {
		driver.findElement(By.id("id_gender" + gender + "")).click();
	}

	public void selectDateBirth(String day, String month, String year) {
		Select select_days = new Select(this.select_days);
		Select select_months = new Select(this.select_months);
		Select select_years = new Select(this.select_years);

		select_days.selectByValue(day);
		select_months.selectByValue(month);
		select_years.selectByValue(year);
	}

	public void selectState(String state_value) {
		Select select_state = new Select(this.select_state);
		select_state.selectByValue(state_value);
	}

}
