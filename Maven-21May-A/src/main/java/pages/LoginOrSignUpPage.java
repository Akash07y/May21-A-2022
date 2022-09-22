package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class LoginOrSignUpPage {
	
	private WebDriver driver ;
	
	@FindBy (xpath = "//input[@id='email']") 
	private WebElement userName ;
	
	@FindBy (xpath = "//input[@id='pass']") 
	private WebElement password ;
	
	@FindBy (xpath = "//button[@name='login']") 
	private WebElement loginButton ;
	
	@FindBy (xpath = "//a[text()='Create New Account']") 
	private WebElement creatNewAccount ;
	
	@FindBy (xpath = "//a[text()='Messenger']") 
	private WebElement messengerLink ;
	
	public LoginOrSignUpPage(WebDriver driver123) { //driver123 = driver = new ChromeDriver()
		PageFactory.initElements(driver123, this);
		driver = driver123 ;
	}
	
	public void sendUserName(String user) {
		Actions act = new Actions(driver);
		userName.sendKeys(user);
	}
	
	public void sendPasswordName() {
		
		password.sendKeys("12345678");
	}
	
	public void clickOnLoginButton() {
		//
		loginButton.click();
		
	}
	
	public void clickOnCreatNewAcc() {
		creatNewAccount.click();
	}
	
	public void openMessenger() {
		messengerLink.click();
	}
	
	//OR
	// Complete Functonality
	public void loginToApplication() {
		userName.sendKeys("Velocity@gmail.com");
		password.sendKeys("12345678");
		loginButton.click();
	}
	
}





























