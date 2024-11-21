package Testng;

import org.testng.annotations.Test;

public class Grouping {
 @Test(priority=1,groups= {"sanity"})
	void test1() {
		System.out.println("hello");
	}
 @Test(priority=2,groups= {"sanity"})
	void test2() {
		System.out.println("hi");
	}
 @Test(priority=3,groups= {"sanity"})
	void test3() {
		System.out.println("how are you");
	}
}
