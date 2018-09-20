package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.TestBase.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'User: Naveen K']")
	WebElement verifyusername;
	
	@FindBy(xpath="//a[contains(text(),'Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'Calls']")
	WebElement callsLink;
	
	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyhomepagetitle(){
		return driver.getTitle();
	}
	
	public boolean verifycrmusername(){
		return verifyusername.isDisplayed();
	}
	
	public ContactsPage Contactpagelink(){
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage Dealspagelink(){
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage Taskpagelink(){
		tasksLink.click();
		return new TasksPage();
	}

	public CallsPage Callspagelink(){
		callsLink.click();
		return new CallsPage();
	}
}
