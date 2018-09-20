package com.crm.qa.pages;

import javax.management.MXBean;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.TestBase.TestBase;

public class LoginPage extends TestBase{
	
	//page web-element or OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitbutton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logo;
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateTitle(){
		
		return driver.getTitle();
	}
	
	public boolean ValidateLogo(){
		return logo.isDisplayed();
	}
	
	public HomePage login(String un,String pw){
		
		username.sendKeys(un);
		password.sendKeys(pw);
		submitbutton.click();
		
		return new HomePage();
	} 

}