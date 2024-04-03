package com.beaconpro.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.login.LoginPage;

public class InitializationSettings {

	public static WebDriver driver;

	@Test
	public void FFProfileSelection(String profileffsds) throws Throwable {

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile(profileffsds);
		WebDriver driver = new FirefoxDriver(ffprofile);
		driver.manage().window().maximize();

		LoginPage loginTest = new LoginPage(driver);

		loginTest.loginToBeaconProValid("dinoop", "djfhjhjh");

	}

}