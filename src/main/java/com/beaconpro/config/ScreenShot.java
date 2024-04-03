package com.beaconpro.config;

/********************************************************************************************************************	
Created By      : 
Created On	    : 

ScreenShot s_shot = new ScreenShot(driver);
s_shot.take_screen_shot(FolderName, FileName);

Modified Date : 07/06/2016
-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ScreenShot {

	WebDriver driver;
	
	private static String fileSeperator = System.getProperty("file.separator");
	String Path = "//seqc05/screenshot/";

	public ScreenShot(WebDriver driver) 
	{
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void take_screen_shot(String FolderName, String FileName) throws IOException 
	{	
		File file = new File(Path + FolderName);
		//System.out.println("File outside " + file);
		if (!file.exists()) 
		{
		file.mkdir();
		System.out.println("File created " + file);
		}
		file = new File(Path + FolderName + fileSeperator + FileName);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, file);
	}
	
}
