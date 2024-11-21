package Testcases;

import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;

import PageObjectClass.AccountPage;
import PageObjectClass.Homepage;
import PageObjectClass.LoginPage;
import TestBase.BaseTest;
import utilities.DataProviders;

public class LoginDDTest extends BaseTest {
@Test(dataProvider= "LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void datadriventest(String email,String pwd,String exp) {
		logger.info("starting the login process");
		//homepage validation
	
		Homepage hm=new Homepage(driver);
		hm.account_usr();
		hm.login();
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.user_email(email);
		lp.usr_password(pwd);
		lp.login();
		System.out.println("Testing with Username: " + email + " and Password: " + pwd);
		//accountpage
		AccountPage ap=new AccountPage(driver);
		boolean usr_account_display=ap.usr_account();
		Assert.assertTrue(usr_account_display);
		if(exp.equalsIgnoreCase("Valid")) {
			if(usr_account_display) 
			{
				ap.clicklogout();
				Assert.assertTrue(true,"valid credentionals,sucessfullogin");
			}
			
			else {
				Assert.fail("valid crenditionals:login failed,incorrect details");
			}
			if(exp.equalsIgnoreCase("Invalid")) 
			{
				if(!usr_account_display) {
					
					Assert.assertTrue(true,"invalid credition,login failed");
				}
				
			
			else {
				 logger.error("Invalid credentials: Login succeeded.");
				ap.clicklogout();
				Assert.fail("invalid credentional:login successed which is incorect");
			}
		}
	
		}
		logger.info("finished the logindatadriven process");
		
		
	}

	}

