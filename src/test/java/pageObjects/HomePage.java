package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static  WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@class='cursor-pointer']")
	WebElement profile;
	@FindBy(xpath="//*[text()='Login']")
	WebElement login;
	@FindBy(xpath="//*[text()='Register']")
	WebElement register;
	public void click_On_Proile() {
		profile.click();
	}
	public void click_On_Login() {
		login.click();
	}
	public void click_On_Register() {
		register.click();
	}
}
