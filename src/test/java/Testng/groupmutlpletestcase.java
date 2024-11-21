package Testng;

import org.testng.annotations.Test;

public class groupmutlpletestcase {
	@Test(priority=1,groups= {"regression"})
	void facebookapp1() {
		System.out.println("facebbok");
	}
	@Test(priority=2,groups= {"regression"})
	void facebookapp2() {
		System.out.println("whatsapp");
	}
	@Test(priority=3,groups= {"regression"})
	void facebookapp3() {
		System.out.println("instagram");
	}

}
