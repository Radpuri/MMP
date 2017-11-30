package mmpProjectGithub.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class DataProperties {

	WebDriver driver;
	public static	Properties prop;
	public static	File f;
	
	public DataProperties(WebDriver driver) {
		this.driver=driver;
	}

	public static void loadData(  ){

		//	C:\Users\radpuri\Desktop\eclipse\workspace\mmp == user.dir
		// \src\main\java\com\mmp\config
		prop= new Properties();
		try {
			f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mmp\\config\\data.properties");
			FileInputStream fis=new FileInputStream(f);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	public String getBrowser(){
		loadData();
	 return prop.getProperty("browser");
	}
	
	public String getUrl(){
		loadData();
		String data= prop.getProperty("url");
		return data;
}
	
}