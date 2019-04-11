package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowsersClass {

	public static WebDriver startBrowser(WebDriver driver, String browser, String url) {

		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\SeleniumJars/geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\SeleniumJars/chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver","C:\\SeleniumJars/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;

	}

	public static void quitBrowser(WebDriver driver) {

		driver.quit();
	}

}
