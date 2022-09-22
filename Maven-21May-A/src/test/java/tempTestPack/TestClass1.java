package tempTestPack;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass1 {

	
	
	public void test4() {
		System.out.println("Test 4 TestClass 1");	
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method TestClass 1");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class TestClass 1");
	}
	
	@AfterTest 
	public void afterTest() {
		System.out.println("After Test TestClass 1 ");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite TestClass 1 ");
	}
	
		
}
