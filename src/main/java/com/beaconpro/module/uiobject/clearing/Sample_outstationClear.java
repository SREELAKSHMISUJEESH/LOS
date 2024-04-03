package com.beaconpro.module.uiobject.clearing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;
import com.beaconpro.module.uiobject.login.LoginPage;

public class Sample_outstationClear {

	WebDriver driver;
	
	String branch = "MAIN BRANCH";
	String AgentBank = "All";
	String ClearingType = "OUTSTATION OUTWARD";
	String RegBranch = "ALL";
	String ClearReturnThrough = "Clear Directly";
	String TrnMode = "CASH";
	
	@Test(priority = 0)
	public void opening_firefox() throws Exception 
	{
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("default");
		driver = new FirefoxDriver(ffprofile);
	}

	@Test(priority = 1)
	public void open_beaconpro_url_and_login() throws Throwable 
	{
		LoginPage newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		newloginmaker.loginToBeaconProValid("testqc", "test123");
	}
	@Test(priority = 2)
	public void OutstationClear()
	{
		OutstationClearingPage ocp = new OutstationClearingPage(driver);
		ocp.Presenting(branch, AgentBank, ClearingType, RegBranch, ClearReturnThrough, TrnMode);
	}
}
