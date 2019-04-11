package Tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.LoginPage;
import Utilities.BrowsersClass;



public class LoginTest extends BaseTest {
	
	
	Properties prop = new Properties();
	
	public LoginTest() throws IOException{
	FileInputStream fs = new FileInputStream("C:\\Testing\\mavenFramework.properties");
	prop.load(fs);
	}

	@Test
	public void login() {
		test=reports.createTest("login");
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.LoignToGmail(prop.getProperty("emailid"), prop.getProperty("password"));
	}
	
	@Test ()
	public void homeTest() {
		test=reports.createTest("homeTest");
		System.out.println("I am in home Test");
		System.out.println("Before Assertion");
		Assert.assertTrue(4>3, "Verifying Element");
		System.out.println("After assertion");
		test.log(Status.INFO, "First Home test");
		
	}

}
