package mmpProjectGithub.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static	WebDriver driver;


	public static WebDriver invokeBrowser(String browser){
		//DataProperties obj= new DataProperties(driver);
	     //driver.get( obj.getBrowser());

	      if (browser.equalsIgnoreCase("CH")){

			System.setProperty("webdriver.chrome.driver","chromedriver.exe" );
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("FF")){

			System.setProperty("webdriver.gecko.driver","geckodriver.exe" );
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("IE")){

			System.setProperty("webdriver.IEDriverServer.driver","IEDriver.exe" );
			driver= new InternetExplorerDriver();
		}

		return driver;
	}
	public  void getUrl( String url){
		//DataProperties obj= new DataProperties(driver);
	 //    driver.get( obj.getUrl());
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	}
	
	public  static void waitforElement(int timeOutInSeconds ,WebElement element ){
		WebDriverWait  wait= new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public  void closeBrowser(){
		driver.quit();
	}
}