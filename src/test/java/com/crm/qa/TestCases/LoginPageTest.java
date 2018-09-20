package com.crm.qa.TestCases;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest(){
		super();
	}

	@BeforeMethod
	public void setup(){
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void VerificationCRMLogoTest(){
		boolean flag=loginpage.ValidateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void VerificationCRMTitleTest(){
		String title =loginpage.ValidateTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");;
	}
	
	@Test(priority=3)
	public void loginTest(){
		homepage=loginpage.login(pros.getProperty("username"), pros.getProperty("password"));
	}
	
	@AfterMethod
	public void exit(){
		driver.quit();
	}
}
