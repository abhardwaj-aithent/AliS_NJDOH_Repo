package com.AliS.qa.TestCase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AliS.qa.Base.TestBase;
import com.AliS.qa.Pages.LoginPage;
import com.AliS.qa.Util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	CharSequence LoginName;
	CharSequence Password;
	TestUtil testutil;
	
	String sheetName="Login Testcase";
	
	/*
	LoginPageTest() throws FileNotFoundException, IOException{
		super();   //Here super function will used to call TestBase class Constructor First then execute further program 
	}

	

	public void setup() {
		Initialization();
	  loginpage=new LoginPage();
		}
	
	*/
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhardwaj\\eclipse-workspace\\ALiSNJDOH_Framework\\Drivers\\chromedriver.exe");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
	
		driver.get(prop.getProperty("http://172.16.1.32/ALiSDPBHTESTING11.2.2/login.aspx?BusinessUnit=HCQC"));
	}

	
	@DataProvider
	public Object[][] getLoginData() {
		Object data[][] =TestUtil.getTestData("LoginAlis");
		//Object data[][]=testutil.getTestData("LoginAlis");
		return data;
	}
	
	@Test(dataProvider="getLoginData")
	public void LoginAlis(String LoginName , String Password)
	{
		System.out.println("Now enter in Login/alis method");
		loginpage.LoginToAlis(LoginName, Password);
		
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
		}
	
}




