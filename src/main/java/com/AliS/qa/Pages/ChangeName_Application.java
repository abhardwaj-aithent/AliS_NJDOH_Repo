package com.AliS.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AliS.qa.Base.TestBase;

public class ChangeName_Application extends TestBase{

	//Page Factory 
	@FindBy(xpath="//a[@id='ctl00_ContentPlaceHolder1_ucMenu_10__aMenuLink']")
	WebElement ChangeNameLink;
	
	@FindBy(xpath="//span[contains(text(),'Change Name - Preliminary Step')]")
	WebElement ChangeNameHeader;
	
	@FindBy(xpath="//button[contains(text(),'Next')]")
	WebElement NextButton;
	
	
	//Initializing the objects through this constructor 
	public ChangeName_Application(){
	PageFactory.initElements(driver, this);
	}
	
    //Actions or Methods:- 

	public void ValidateChangeNameLink() {
		System.out.println("change name link");
		ChangeNameLink.click();
	}
	
	public String  ChangeNameApplicationTitle() {
		return driver.getTitle();
		
	}
	
	public void ValidateChangeNameHeader() {
		// TODO Auto-generated method stub
		
	}
	
	public void ValidateNextButton() {
		NextButton.click();
	}

	
	
}
