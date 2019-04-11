package Tests;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utilities.BrowsersClass;

public class BaseTest {

	public WebDriver driver;
	
	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	
	@BeforeClass
	public void Start() {
	
		driver = BrowsersClass.startBrowser(driver,"Chrome", "https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		reports = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("C:\\Testing\\Extentreport.html");
		reports.attachReporter(htmlReporter);
	}
	
	
	@AfterMethod
	public void setTestResult(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getTestName());
			test.fail(result.getThrowable());
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			test.pass(result.getTestName());
		}else if(result.getStatus() == ITestResult.SKIP) {
			test.skip("Test Case : " + result.getTestName() + "has been skipped");
		}
		
	}
	
	@AfterClass
	public void Close() {
	
		BrowsersClass.quitBrowser(driver);
		reports.flush();
	}
}
