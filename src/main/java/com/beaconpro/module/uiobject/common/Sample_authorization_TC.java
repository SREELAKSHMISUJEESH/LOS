package com.beaconpro.module.uiobject.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.login.LoginPage;

public class Sample_authorization_TC {
	
	WebDriver driver;
	public String TransID = "3612388";
	public String TransType = "Credit";
	public String TransMode = "TRANSFER";

	@Test(priority = 0)
	public void opening_firefox() throws Exception {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("default");
		driver = new FirefoxDriver(ffprofile);
	}

	@Test(priority = 1)
	public void open_beaconpro_url_and_login() throws Throwable {
		LoginPage newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		newloginmaker.loginToBeaconProValid("testqc", "test123");
	}
	
	@Test(priority = 2)
	public void SB_Credit() throws Exception {
		Authorizations obja = new Authorizations(driver);
		//obja.Cashier_Authorization(TransID);
		//obja.Manager_Authorization_cash(TransID);
		//obja.Manger_authorization_Others(TransID);
		obja.Authorization(TransID, TransType, TransMode);
	}
	
}
