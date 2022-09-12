package com.AliS.qa.TestCase;

import javax.smartcardio.CommandAPDU;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AliS.qa.Base.TestBase;
import com.AliS.qa.Pages.HomePage;
import com.AliS.qa.Pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;

	HomePageTest(){
		super();//Here super function will used to call TestBase class Constructor First then execute further program 
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		Initialization();
		loginpage=new LoginPage();
		homepage=loginpage.LoginToAlis(prop.getProperty("LoginName"), prop.getProperty("Password"));
		Thread.sleep(2000);
		
		}
	
	@Test(priority=1)
	public void HomePageTitle() {
		String Title= homepage.ValidateHomePageTitle();
		Assert.assertEquals(Title, "Home");
	}
	
	@Test(priority=2)
	public void HomePageHeader() {
		homepage.ValidateHomePageHeader();
	}
	
	@Test(priority=3)
	public void HomePageDialogBox() {
		homepage.ValidateHomePageDialogBox();
	}

	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
