package com.beaconpro.test.clearing;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 02/06/2016
Purpose	        : MICR Clearing Test Case 
Note			: 
Conditions      :  
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.clearing.MICRClearingPage;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.login.LoginPage;

public class MICRClearing 
{
	public WebDriver driver;
	
	String UserName = "shilpa";  			 // User Credentials
	String Pword 	= "test123";
	
	String ClearingType   = "MICR OUTWARD";  // Clearing Details
	String ClearingDate   = "12/06/2017";
	String ClearingBatch  = "102-MICR-OW-1262017-1";
	String ClrngRegBranch = "MAIN BRANCH";



	@Test(priority = 0)
	public void login_User () throws Throwable
	
	{
		try 
		
		{
			ProfilesIni Profile = new ProfilesIni ();
			FirefoxProfile ffprofile = Profile.getProfile("default");
			driver = new FirefoxDriver (ffprofile);
			
			LoginPage objlog	= new LoginPage (driver);
			objlog.openUrlFor102();
			objlog.loginToBeaconProValid(UserName, Pword);
			
		}
		
		catch (Exception e)
		
		{
			e.printStackTrace();
		}
		
	}
	
	@Test(priority = 1)
	public void Open_Clearing_Window()
	
	{
		try 
		{
			MenuList objMenulist = new MenuList (driver);
			objMenulist.Open_window(objMenulist.MICR_Clearing);
		}

		catch (Exception e)	
		{
			e.printStackTrace();
		}
	}
	
	@Test (priority = 2)
	public void MICR_Clearing_Process ()
	
	{
		try 
		{
			MICRClearingPage objClrng= new MICRClearingPage (driver);
			objClrng.Clearing_type(ClearingType);
			objClrng.SetClearingDate(ClearingDate);
			objClrng.Clearing_Batch(ClearingBatch);
			objClrng.Select_Reg_BranchName(ClrngRegBranch);
			objClrng.Click_Search_Btn();
			objClrng.Select_From_ClrngDetails_Grid();
			objClrng.Click_Clear_Btn();
			objClrng.Close_ClearOrReturn_Saved_PopUp();
		}
		
		catch (Exception e)
		
		{
			e.printStackTrace();
		}
		
	}


}
