package Testcases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectClass.Homepage;
import PageObjectClass.RegistrationPage;
import TestBase.BaseTest;
public class RegistrationTestPage extends BaseTest {
@Test(groups={"Register","Master"})
    public void account_register() {
        logger.info("Starting the application for account registration");

        Homepage hm = new Homepage(driver);
        logger.info("Navigating to the homepage and initializing the Homepage object");

        hm.account_usr();
        logger.info("User clicked on the account dropdown");

        hm.register_user();
        logger.info("User clicked on the register option");
      

        RegistrationPage rs = new RegistrationPage(driver);
        logger.info("Initialized the RegistrationPage object");

        String firstName = randomString().toUpperCase();
        rs.userfname(firstName);
        logger.info("Entered first name: " + firstName);

        String lastName = randomString().toUpperCase();
        rs.userlname(lastName);
        logger.info("Entered last name: " + lastName);

        String email = randomString() + "@gmail.com";
        rs.useremal(email);
        logger.info("Entered email: " + email);

        String phone = randomNumber();
        rs.userphone(phone);
        logger.info("Entered phone number: " + phone);

        String pass = randomAlphanumeric();
        rs.userpassword(pass);
        logger.info("Entered password");

        rs.userpasswordconfirm(pass);
        logger.info("Confirmed the password");

        rs.userradiobtn();
        logger.info("Selected the radio button");

        rs.usercheckbox();
        logger.info("Checked the terms and conditions checkbox");

        rs.usersubmit();
        logger.info("Submitted the registration form");

        String msg = rs.getconfirmationmsg();
        logger.info("Retrieved confirmation message: " + msg);

        logger.info("Account registration process completed");
    }


}
