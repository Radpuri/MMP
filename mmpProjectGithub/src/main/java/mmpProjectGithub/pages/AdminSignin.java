package mmpProjectGithub.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AdminSignin {

	WebDriver driver;

	By usrname = By.id("username");
	By paswrd= By.id("password");
	By registerbutton= By.xpath("//input [@value='Register']");
	//By registerbutton= By.linkText("REGISTER");
	By signin= By.name("admin");
	By headingText= By.xpath(".//*[@id='login1']/h1");
	By verifyText= By.cssSelector(".breadcrumb>li");


	public AdminSignin(WebDriver driver) {
		this.driver=driver;
	}

	public AdminSignin typeUsername(String  username){
		driver.findElement(usrname).clear();
		driver.findElement(usrname).sendKeys(username);
		return this;
	}

	public AdminSignin typepassword(String  password){
		driver.findElement(paswrd).clear();
		driver.findElement(paswrd).sendKeys(password);
		return this;

	}
	public Adminregistration clickRegister(){
		driver.findElement(registerbutton).click();
		return new Adminregistration(driver);
	}
	public AdminSignin clickSignin(){
		driver.findElement(signin).click();
		return this;
	}

	public AdminHompage adminLoginAs(String username,String password){
		typeUsername(username);
		typepassword(password);
		clickSignin();
		return new AdminHompage(driver);
	}
	public boolean verifyHeadingText(){
		WebElement text= driver.findElement(headingText);
		//BaseClass.waitforElement(300,text);
		System.out.println( "text is:::"+text.getText());
	    return text.isDisplayed();


		
	}
	/*public boolean verifyTextontheadminPortal(){
		WebElement text=driver.findElement(verifyText);
		System.out.println( "text is:::"+text.getText()); //i can print the text that i am verifying here
		return text.isDisplayed();
	} */
	//more asserstion incase same text not coming ..boolean isdisplayed true false video5-2.0bhanu
	//for invalid user name password asseration
	
	public String invadminLoginText(){
		Alert alert=driver.switchTo().alert();
		String alertMessage= driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		alert.accept();
		return alertMessage;
	}

	public Adminregistration adminRegisterAs(){
		clickRegister();
		return new Adminregistration(driver);
	}
}


