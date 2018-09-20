package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtils testutils;

	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){		
		initialization();
		loginpage =new LoginPage();
		testutils=new TestUtils();
		homepage=loginpage.login(pros.getProperty("username"), pros.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyhometitleTest(){
		String homeusername=homepage.verifyhomepagetitle();
		Assert.assertEquals(homeusername, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyhomeusernameTest(){
		testutils.swtichToFrame();
		boolean flaguser=homepage.verifycrmusername();
		Assert.assertTrue(flaguser);
	}
	
	@Test(priority=3)
	public ContactsPage contactlink(){
		testutils.swtichToFrame();
		homepage.Contactpagelink();
		
		return new ContactsPage();
	}

	@AfterMethod
	public void exit(){
		driver.quit();
	}
}
