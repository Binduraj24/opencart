package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectClass.AccountPage;
import PageObjectClass.Homepage;
import PageObjectClass.LoginPage;
import TestBase.BaseTest;

public class LoginTest extends BaseTest {
	@Test(groups={"login","Master"})
	public void user_login() {
		
		logger.info("starting the login process");
		//homepage validation
		try {
		Homepage hm=new Homepage(driver);
		hm.account_usr();
		hm.login();
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.user_email(p.getProperty("email"));
		lp.usr_password(p.getProperty("password"));
		lp.login();
		//accountpage
		AccountPage ap=new AccountPage(driver);
		boolean usr_account_display=ap.usr_account();
		Assert.assertTrue(usr_account_display);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("finished the login process");
		
		
	}

}
