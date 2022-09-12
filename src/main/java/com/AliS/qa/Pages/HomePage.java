package com.AliS.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.AliS.qa.Base.TestBase;

public class HomePage extends TestBase{
	

	//Page Factory 
	
	@FindBy(id="ctl00_lblPageTitle")
	WebElement HomePageHeader;
	
	@FindBy(xpath="//span[@id='ctl00_ContentPlaceHolder1_lblHeader']")
	WebElement HomeDialogBox;
	
	

	//Initializing the objects through this constructor 
		public HomePage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:- 
		public String  ValidateHomePageTitle() {
			
			return driver.getTitle();
			
		}
		
		public void ValidateHomePageHeader() {
			HomePageHeader.isDisplayed();
		}
		
		public void ValidateHomePageDialogBox() {
			HomeDialogBox.isDisplayed();
		}
		
		
	
	
}
