package com.AliS.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.AliS.qa.Util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	

	public TestBase(){

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\abhardwaj\\eclipse-workspace\\ALiSNJDOH_Framework\\src\\main\\java\\com\\AliS\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("System unable to Find file");
		} 
		
		catch (IOException e) {
		e.printStackTrace();
		System.out.println("IOException");
		}
	
	}

	public static void Initialization() {
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhardwaj\\eclipse-workspace\\ALiSNJDOH_Framework\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\abhardwaj\\eclipse-workspace\\ALiSNJDOH_Framework\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhardwaj\\eclipse-workspace\\ALiSNJDOH_Framework\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		else {
			System.out.println("System is not suporting any of the browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
	
		driver.get(prop.getProperty("url"));
		
		}
	
}
