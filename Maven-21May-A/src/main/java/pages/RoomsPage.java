package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RoomsPage {

	private WebDriver driver ;
	private WebDriverWait wait ;
	
	@FindBy (xpath = "//a[text()=' Return to messenger.com ']") 
	private WebElement returnToMessange ;
	
	// repleacement of findElements
	
	@FindBy (xpath = "//a[text()=' Visit our help center ']") 
	private WebElement helpCenter ;	
	
	public RoomsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	// BEST approch
	// when timming for webElement are diffrent
	public void goBackToMessenger() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(returnToMessange));
		returnToMessange.click();
	}
	
	public void contactToHelpCenter() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(helpCenter));
		helpCenter.click();
	}
	
	// POM Class 
	
	// Mouse Action 
	// Explicite Wait 
	// Scroll Into View 
}




