package mmpProjectGithub.testScripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mmpProjectGithub.pages.AdminSignin;
import mmpProjectGithub.pages.Adminregistration;


public class AdminModuleTestscripts extends mmpProjectGithub.utils.BaseClass {
// made changes here too
	@Parameters({"browser","url"})
	@BeforeClass(alwaysRun =true ,description="set up the browser andlaunch the website")
	public void setup (String browser ,String url){

		try{
			driver= mmpProjectGithub.utils.BaseClass.invokeBrowser(browser);
			getUrl(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	/*@Parameters ({"username", "password", "screenShots"})
	@Test(priority= 1, description ="Admin signin with valid username and password")
	public void AdminLogin(String username, String password , String screenShots){

		// defect here ..cannt see the login and office login buttons so direct url
		try {
			driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
			//this is to click on office login and login on homepage
			//Homepage h=new Homepage(driver);
			//h.navigateToAdminLoginPage();

			//after clicking on login enter user and password for admin and signin
			AdminSignin sPage=new AdminSignin (driver);
			sPage.adminLoginAs(username, password);
			boolean result = sPage.verifyHeadingText();
			Assert.assertEquals( true, result);
			Liabrary.takeScreenShots( driver,screenShots);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	@Parameters ({"firstname","lastname","usrname", "pasword" , "confirmpword", "email"})
	@Test(priority= 0, description ="Admin registeration with username, password and emailid")
	public void adminRegister(String fname, String lname ,String uname ,String paswrd, String cpword , String email,String screenShots){	
		//defect..so the direct url
		try {
			driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
			//click on register button on the sigin page
			AdminSignin sPage=new AdminSignin (driver);
			sPage.clickRegister();
			Adminregistration rPage= new Adminregistration(driver);
			rPage.register(fname, lname,uname, paswrd, cpword, email);
			boolean result =rPage.verifyTextisDisplayed();
			Assert.assertEquals( true,result);
			//Liabrary.takeScreenShots( driver,screenShots);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} {

}
}