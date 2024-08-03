package testCase;


import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePage;

public class Home extends Base{
	public HomePage hp;
	@Test
	public void click_Loginbutton() {
		hp=new HomePage(driver);
		hp.click_On_Proile();
		hp.click_On_Login();
	}

}
