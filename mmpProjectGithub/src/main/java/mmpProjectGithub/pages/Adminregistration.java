package mmpProjectGithub.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mmpProjectGithub.utils.BaseClass;



public class Adminregistration {

	WebDriver driver;

	By firstname= By.name("Name");
	By lastname= By.id("lastname");
	By username= By.id("username");
	By password= By.id("password");
	By cpassword= By.id("cpassword");
	By officecode= By.id("officecode");
	By save= By.name("save");
	By verifyText= By.cssSelector(".breadcrumb>li");

	public Adminregistration(WebDriver driver) {
		this.driver=driver;
	}

public Adminregistration  setFirstname(String fname){
	driver.findElement(firstname).sendKeys(fname);
	return this;
}
public Adminregistration setLastname(String lname){
	driver.findElement(lastname).sendKeys(lname);
	return this;
}
public Adminregistration setUsername(String lname){
	driver.findElement(username).sendKeys(lname);
	return this;
}
public Adminregistration setPassword(String paswrd){
	driver.findElement(password).sendKeys(paswrd);
	return this;
}
public Adminregistration confirmPassword(String cpword){
	driver.findElement(cpassword).sendKeys(cpword);
	return this;
}
public Adminregistration setEmail(String email){
	driver.findElement(officecode).sendKeys(email);
	return this;
}
//click on save accept the Alert and print the alert text
public String clickSave(){
	driver.findElement(save).click();
    Alert alert = driver.switchTo().alert();
	String alertMessage= driver.switchTo().alert().getText();
	System.out.println(alertMessage);
	alert.accept();
	return alertMessage;
}

public AdminHompage register(String fname ,String lname,String uname ,String paswrd ,String cpword , String email){
	 setFirstname( fname);
	 setLastname(lname);
	 setUsername(uname);
	 setPassword( paswrd);
	 confirmPassword(cpword);
	 setEmail(email);
	 clickSave();
	 return new AdminHompage(driver);
}


public boolean verifyTextisDisplayed(){
		try {
				WebElement text=driver.findElement(verifyText);
///	System.out.println(); can i print the text that i am verifying here it gives the code for the element
	//will wait for element to be displayed from the baseclass we can extend theBClass or make the method static
			BaseClass.waitforElement( 300 , text);
				text.isDisplayed();
              return true;
			} catch (Exception e) {
				return false;
			}
}
}

