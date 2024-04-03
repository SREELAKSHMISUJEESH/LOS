package com.beaconpro.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FireFoxManager {
	private static WebDriver driver;

	public static WebDriver getDriverInstance() {
		return driver;
	}

	public static WebDriver startDriverTest(String profile_name) {

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile(profile_name);
		driver = new FirefoxDriver(ffprofile);

		return driver;
	}

	public static void stopDriverTest() {
		driver.close();
	}
}
