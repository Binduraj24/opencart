package Testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Annotationstestng {
	@Test
	void testaptitle() {
		
		String exp_title="opencart";
		String actual_title="opencart";
		//Assert.assertEquals(exp_title, actual_title);
	SoftAssert sa=new SoftAssert();
	sa.assertEquals(exp_title, actual_title);
		sa.assertAll();
		
	}
	@Test(priority=1)
	 void openapp() {
		 Assert.assertTrue(true);
	 }

	@Test(priority=2,dependsOnMethods={"openapp"})
	 void login() {
		 Assert.assertTrue(false);
	 }
	@Test(priority=3,dependsOnMethods={"login"})
	 void search() {
		 Assert.assertTrue(false);
	 }
	@Test(priority=4,dependsOnMethods={"login"})
	 void logout() {
		 Assert.assertTrue(true);
	 }

}
