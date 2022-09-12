package com.AliS.qa.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AliS.qa.Base.TestBase;
import com.AliS.qa.Pages.ChangeName_Application;
import com.AliS.qa.Pages.HomePage;
import com.AliS.qa.Pages.LoginPage;

public class ChangeName_Applicationtest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ChangeName_Application CAP;
	
	
	ChangeName_Applicationtest(){
		super();//Here super function will used to call TestBase class Constructor First then execute further program 
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		Initialization();
		loginpage=new LoginPage();
		homepage=loginpage.LoginToAlis(prop.getProperty("LoginName"), prop.getProperty("Password"));
		Thread.sleep(5000);
		
		}
	
	@Test(priority=1)
	public void ChangeNameLink() {	
		System.out.println("CAP");
		CAP.ValidateChangeNameLink();
		}

	
	@Test(priority=2)
	public void ChangeName_ApplicationTitle() {
		//driver.navigate().to("http://172.16.1.32/ALiSNJDOH3TESTING11.1.123.05/ALiSApplicationPreliminaryStep?NavigationMode=NameChange&sessionid=zkk1wx0qcaeyr13eizsncb5q&ApplicationType=CLLNCA&LicenseeType=B&BusinessUnitType=CLL&CategoryCode=NCH");
		String Title=CAP.ChangeNameApplicationTitle();
		Assert.assertEquals(Title, "Change Name - Preliminary Step");
	}
	
	
	@Test(priority=3)
	public void ChangeNameHeader() {
		CAP.ValidateChangeNameHeader();
	}
	
	
	@Test(priority=3)
	public void NextButton() {
		CAP.ValidateNextButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
