package com.beaconpro.module.uiobject.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;
import com.beaconpro.module.uiobject.login.LoginPage;

public class SampleReadExcel {
	
	static WebDriver driver;
	
	String SheetName = "Login";
	String FileName = "Input Data.xls";
	String User_Name;
	String Password;
	String FFP = "default";
	int abc = 0;
	
	String ary[]= new String[10];
	
	@Test(priority = 0)
	public void opening_firefox() throws Exception {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile(FFP);
		driver = new FirefoxDriver(ffprofile);
	}

	@Test(priority = 1)
	public void open_beaconpro_url_and_login() throws Throwable {
		LoginPage newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		ReadExcelFile ref = new ReadExcelFile(driver);
		ref.ReadFromExcelFile(SheetName,FileName,ary);
		
			User_Name = ary[0];
			Password = ary[1];
		//System.out.print(User_Name + "\n" + Password);
		newloginmaker.loginToBeaconProValid(User_Name, Password);
	}
		
	/*@Test(priority = 2)
	public void TestExcel() throws Throwable 
	{
	
		ReadExcelFile ref = new ReadExcelFile(driver);
		ref.ReadFromExcelFile(SheetName,FileName,ary);
		
		System.out.println(ary[0]);
		
	}*/

}
