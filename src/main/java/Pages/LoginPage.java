package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	//public LoginPage(WebDriver ldriver) {
		//this.driver = ldriver;
	//}
	
	@FindBy(id = "identifierId")WebElement emailNext;

	@FindBy(name = "password") WebElement passwordNext;
	
	@FindBy(xpath ="//content[@class='CwaK9']") WebElement Button;
	
	public void LoignToGmail(String user, String pass) {
		
		emailNext.sendKeys(user);
		Button.click();
		passwordNext.sendKeys(pass);
		Button.click();
		
	}
	
}
