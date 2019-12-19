package selenium.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends PageMenu {

	@FindBy(xpath = "//h1")
	WebElement h1_authentication;

	@FindBy(xpath = "//*[@id=\"create-account_form\"]/h3")
	WebElement h3_create_account;

	@FindBy(xpath = "//*[@id=\"login_form\"]/h3")
	WebElement h3_already_registered;

	@FindBy(id = "email_create")
	WebElement input_email_create;

	@FindBy(id = "email")
	WebElement input_email_already;

	@FindBy(id = "passwd")
	WebElement input_password_already;

	@FindBy(id = "SubmitLogin")
	WebElement btn_signin;

	@FindBy(name = "SubmitCreate")
	WebElement btn_create_account;

	public PageCreateAccount clickCreateAccount(WebDriver driver) {
		btn_create_account.click();
		return PageFactory.initElements(driver, PageCreateAccount.class);
	}
	
	public PageMyAccount clickLogIn(WebDriver driver) {
		btn_signin.click();
		return PageFactory.initElements(driver, PageMyAccount.class);
	}
}
