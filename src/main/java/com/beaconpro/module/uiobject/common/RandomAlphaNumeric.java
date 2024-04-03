package com.beaconpro.module.uiobject.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beaconpro.module.uiobject.login.LoginPage;


import java.util.Random;

@Test
public class RandomAlphaNumeric  
{
	public void asd()
	{
		String s1 = new String("mickey");

		String s2 = new String("mickey");

		System.out.println(s1==s2); 
		
		String s3 = s1;
		String s4 = s3;
		
		s3 = s2;
		System.out.println(s1=="mickey"); 

		System.out.println(s3==s1);
		
	}

	
	
	//values = {"a","b","c"};

//	public void RandomNumber(int Count)
//	{
//		Random randomGenerator = new Random();
//		//int randomInt = randomGenerator.nextInt(100);
//	      int randomInt = randomGenerator.nextInt(10*Count);
//	}
//	
//	public void RandomString(int Count)
//	{
//		String CHAR_LIST ="abdfghijklmnoprstv";
//		
//				StringBuffer randStr = new StringBuffer();
//        
//		for(int i=0; i<Count; i++)
//        {
//            //int number = RandomNumber(1);
//            //char ch = CHAR_LIST.charAt(number);
//           // randStr.append(ch);
//        }
//       // return randStr.toString();
//
//	}
	
	//  FILE DOWNLOADING 
	
	/*
	public static String downloadPath = "file:///C:/Users/aneeshpk/Desktop/Automation/";
	
	public void testDownload() throws Exception 
	{
		WebDriver driver = new FirefoxDriver(FirefoxDriverProfile());	
		driver.manage().window().maximize();
	    driver.get("file:///C:/Users/aneeshpk/Desktop/New%20Text%20Document.HTML");
	    driver.findElement(By.xpath("html/body/a/button")).click();
	    
	    System.out.println("First");
	}
	
	public static FirefoxProfile FirefoxDriverProfile() throws Exception 
	{
	    System.out.println("second");
	    
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", downloadPath);
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
		return profile;
	}
	*/
}

