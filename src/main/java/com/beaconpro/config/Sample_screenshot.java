package com.beaconpro.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;
import com.beaconpro.module.uiobject.login.LoginPage;

public class Sample_screenshot {
	
	WebDriver    	   driver;
	String FolderName = "SBopening";
	String FileName   = "summary.jpeg";
	
	@Test(priority = 1)
	public void opening_firefox() throws Exception 
	{
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("default");
		driver = new FirefoxDriver(ffprofile);
	}

	@Test(priority = 2)
	public void open_beaconpro_url_and_login() throws Throwable 
	{
		LoginPage newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		newloginmaker.loginToBeaconProValid("testqa", "test123");
		ScreenShot s_shot = new ScreenShot(driver);
		s_shot.take_screen_shot(FolderName,FileName);
	}

}
