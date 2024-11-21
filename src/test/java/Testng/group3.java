package Testng;

import org.testng.annotations.Test;

public class group3 {
	 @Test(priority=1,groups= {"sanity","regression","functional"})
		void test1() {
			System.out.println("hello");
		}
	 @Test(priority=2,groups= {"sanity","regression","functional"})
		void test2() {
			System.out.println("hi");
		}
	 @Test(priority=3,groups= {"sanity","regresson","functional"})
		void test3() {
			System.out.println("how are you");
		}
}
