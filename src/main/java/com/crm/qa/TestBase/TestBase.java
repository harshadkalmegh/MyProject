package com.crm.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.utils.TestUtils;

public class TestBase {

	static WebDriver driver;
	static Properties pros;
	
	public TestBase(){
		
		try {
			pros=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\Kalmegh\\workspace\\FreeCRM\\src\\main\\java"
					+ "\\com\\crm\\qa\\config\\config.properties");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void initialization(){
	
		String Browsername=pros.getProperty("Browser");
		if(Browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Kalmegh\\Desktop\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();

		}else
			if(Browsername.equals("FF")){
				System.setProperty("webdriver.geko.driver","C:\\Users\\Kalmegh\\Desktop\\Selenium\\gekodriver.exe");
				driver = new FirefoxDriver();
	
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITY_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(pros.getProperty("url"));
	}

}
