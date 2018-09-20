package com.crm.qa.utils;

import com.crm.qa.TestBase.TestBase;

public class TestUtils extends TestBase {
	
	public static long PAGE_LOAD_TIME_OUT=20;
	public static long IMPLICITY_TIME_OUT=10;
	
	public void swtichToFrame(){
		driver.switchTo().frame("Mainframe");
	}

}
