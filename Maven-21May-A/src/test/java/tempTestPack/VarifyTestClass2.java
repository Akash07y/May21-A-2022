package tempTestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginOrSignUpPage;
import pages.MessengerPage;
import pages.RoomsPage;
import setup.Base;
import utils.Utility;

public class VarifyTestClass2 extends Base  {

	private WebDriver driver;
	private RoomsPage roomsPage;
	private MessengerPage messengerpage;
	private LoginOrSignUpPage loginOrSignUpPage;
	
	private SoftAssert soft ;
	int testID ;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		System.out.println(browserName);
		if (browserName.equals("Chrome")) 
		{
			driver = openChromeBrowser();
		}
		
		if (browserName.equals("FireFox")) 
		{
			driver = openFirefoxBrowser();
		}
		
		if (browserName.equals("Opre")) 
		{
			driver = openOperaBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void creatPOMObjects() {
		driver.get("https://www.facebook.com/");
		loginOrSignUpPage = new LoginOrSignUpPage(driver);
		messengerpage  = new MessengerPage(driver); 
		roomsPage  = new RoomsPage(driver);
	}

	@BeforeMethod
	public void openRoomsPage()
	{
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
		loginOrSignUpPage.openMessenger();
		
	//	String data = Utility.getDataFromExcel();
		
		loginOrSignUpPage.openMessenger();
		
		
		messengerpage.openRooms();		
		soft = new SoftAssert();
	}
	
	@Test
	public void verifyGoBackToMessengerButton() {
		testID = 10111;
		System.out.println("Test 1");
		roomsPage.goBackToMessenger();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
				
		soft.assertEquals(url, "https://www.messenger./");
		soft.assertEquals(title, "Messeng", "Messemger Title is not verified");
		
		soft.assertAll();
	}
	
	@Test
	public void verifyContactToHelpCenterButton() {
		testID = 10222;
		System.out.println("Test 2");
		roomsPage.contactToHelpCenter();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
				
		soft.assertEquals(url, "https://www.messenger.cop");
		soft.assertEquals(title, "Messenger Help ntre");
		
		soft.assertAll();
	}
	
	@AfterMethod
	public void logoutFromApplicatoion() {
		System.out.println("after method");
		System.out.println("Logout");
	}
	
	@AfterClass
	public void cleanPOMObject(){
		loginOrSignUpPage = null ;
		messengerpage = null ;
		roomsPage = null ;
	}
	
	@AfterTest
	public void closedBrowser() {
		System.out.println("after class");
		driver.close();
		driver = null ;
		System.gc(); // garbeg collector -  delete the unused object
	}
}
