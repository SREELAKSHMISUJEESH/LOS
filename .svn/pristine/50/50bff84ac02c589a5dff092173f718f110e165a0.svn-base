package com.beaconpro.test.clearing;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 06/06/2016
Purpose	        : CTS Registration And Verification Test Case for Inward Clearing
Note			: While giving File path as paramters, give double slash instead of single slash, since single slash is treated as escape sequence character
Conditions      : A/c details in text file should be Valid
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason
 
-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.clearing.CTSRegistrationAndVerificationPage;
import com.beaconpro.module.uiobject.login.LoginPage;

public class CTSRegistrationAndVerifications 
{

	public WebDriver driver;
	
	String User  = "shilpa";    //Login User Credentials
	String Pass  = "test123";
	
	String ClngType     = "CTS INWARD";                                            // CTS Clearing Type
	String TextFilePath = "F:\\Shilpa QA\\TESTING\\SQL QUERIES\\cts12 - Copy.txt"; // CTS Inwrd Clearing Text File Path ;NB:Replace '\' with '\\'
	String PdfFilePath  = "C:\\Users\\shilpa\\Desktop\\Sample Pdf.pdf";			   // CTS Inwrd Clearing PDF File Path ; NB:Replace '\' with '\\'
	
	
	String VerifcnFromDate = "13062017";
	String VerificnToDate  = "13062017";
	
	
	
	@Test(priority=0)
	public  void Open_FireFox_and_LoginToBeaconPro() throws Throwable
	
	{
		try 
		{																																
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile("default");
			driver = new FirefoxDriver(ffprofile);	
			
			LoginPage	objLogin = new LoginPage (driver);
			objLogin.openUrlFor102();
			objLogin.loginToBeaconProValid(User,Pass);
			
		 }
		catch (Exception e) 
		{			
			e.printStackTrace();
				
		}
	}
	
	@Test(priority=1)
	public void RegistrationProcess() throws Exception
	{
		CTSRegistrationAndVerificationPage ObjCTS=new CTSRegistrationAndVerificationPage(driver);
		ObjCTS.CTSRegistrationProcess(ClngType, TextFilePath, PdfFilePath);
			
	}
	
	@Test(priority=2)
	public void VerificationProcess() throws Exception
	{
		CTSRegistrationAndVerificationPage ObjCTS=new CTSRegistrationAndVerificationPage(driver);
		ObjCTS.CTSVerificationProcess(VerifcnFromDate, VerificnToDate);
	}
	
}

