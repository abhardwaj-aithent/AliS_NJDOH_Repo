package com.AliS.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AliS.qa.Base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory or Object Repositories
	@FindBy(name="m_LoginControl$UserName")
	WebElement LoginName;
	
	@FindBy(name="m_LoginControl$Password")
	WebElement Password;
	
	@FindBy(xpath="//a[@id='m_LoginControl_lnkTest']")
	WebElement LoginButton;
	
	
	
	//Initializing the objects through this constructor 
		public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions :- 
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage LoginToAlis(String lname, String pwd) {
		// TODO Auto-generated method stub
		LoginName.sendKeys(lname);
		Password.sendKeys(pwd);
		LoginButton.click();
		
		return new HomePage();
	}
}
