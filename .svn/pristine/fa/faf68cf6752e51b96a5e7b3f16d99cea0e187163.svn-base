package com.beaconpro.test.clearing;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 06/06/2016
Purpose	        : MICR & CTS Presenting & Clearing Test Case 
Note            : Cases Included
 				  Case 1 :For Micr Outward ;Presenting And Clearing
				  Case 2 :For CTS Outward ;Presenting , File Generation And Clearing
				  Case 3: Micr/CTS Inward ; clearing
				  
				  And corresponding Authorizations
				  
				  Execute this sp to get unbatched list and change its recordstatus into 6 in ClearingRegister table to avoid  Unbatched-
                      Items popup.
                  exec spGetUnBatchedList @ClgStatus=1,@TypeCode=2,@TransDate='2016-06-30 00:00:00'
    

Conditions      : Set the General Config Key "CTS_File_Vendor_Type" to 4.[For CTS Outward File Generation]

  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.clearing.CTSOutwardFileGenerationPage;
import com.beaconpro.module.uiobject.clearing.MICR_CTS_ClearingPage;
import com.beaconpro.module.uiobject.clearing.MICR_CTS_PresentingPage;
import com.beaconpro.module.uiobject.common.Authorizations;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;

public class MICR_CTS_PresentingAndClearing 
{

	public WebDriver driver;
	String Clrng_Transid;
	 
	String User     = "shilpa";  			    // User Credentials
	String Pass 	= "test123";
	
	String Authorizn_User = "shilpaau";		    // Authorization Credentials
	String Authorizn_Pass = "test123";
	
	String ClearingType ;     // = "MICR OUTWARD";  // Clearing Details
	String ClearingDate ;	  // = "13/06/2017";
	String ClearingBatch;     // = "102-MICR-OW-1362017-2";
	String ClearingRegBranch; // = "MAIN BRANCH";
	
	
	//String AutoITScriptPath="\\192.168.0.27\\e\\Shilpa-AutoIT-DONT DELETE\\AutoIT\\Script To Download File.exe";
	
	/***** Excel Input data file details ********/ 
	String SheetName     = "MICR_CTS_PresentingAndClearing";
	String FileName      = "CTS/InputData.xls";
	String [] ExcelData  =  new String[100];
	
	@Test(priority = 0)
	public void login_User () throws Throwable
	
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
	private void ECSMark_ExcelDataReading() throws BiffException, IOException 
	{
		ReadExcelFile ObjReadExcel= new ReadExcelFile(driver);
		
		ObjReadExcel.ReadFromExcelFile( SheetName,  FileName, ExcelData);
		
		System.out.println ("Completed ReadFromExcelFile");
				 
		 ClearingType      = ExcelData[0];
		 ClearingDate	   = ExcelData[1];
		 ClearingBatch     = ExcelData[2];
		 ClearingRegBranch = ExcelData[3];
		 
		 System.out.println(ClearingType + ClearingDate+  ClearingBatch +ClearingRegBranch);
		
	}
	
	
	@Test(priority = 2)
	public void MICR_CTS_Presenting() throws InterruptedException 
	
	{
		MICR_CTS_PresentingPage objMicrCTS = new MICR_CTS_PresentingPage(driver);
		Authorizations ObjAuthorise=new Authorizations(driver);
		
		if(ClearingType.equals("MICR OUTWARD") ||ClearingType.equals("CTS OUTWARD" ))
		{
			objMicrCTS.Presenting(ClearingType, ClearingDate, ClearingBatch, ClearingRegBranch);
			String TransID=objMicrCTS.GetTransId();
			System.out.println("Transid is "+TransID);
			ObjAuthorise.LoginForAuthorization(Authorizn_User, Authorizn_Pass);
			ObjAuthorise.Manager_authorization_Transfer(TransID);
		}
	}
	
	
	@Test(priority=3)
	public void CTSFileGenerationProcess() throws Exception
	{
		CTSOutwardFileGenerationPage ObjGenFile=new CTSOutwardFileGenerationPage(driver);
		if(ClearingType.equals("CTS OUTWARD"))
		{				
			ObjGenFile.FileGenerationProcess(ClearingType);
			//Runtime.getRuntime().exec("cmd /c\\192.168.0.27\\e\\Shilpa-AutoIT-DONT DELETE\\AutoIT\\Script To Download File.exe");
			//"E:\\AutoIT\\Script To Download File.exe");
			//Runtime.getRuntime().exec(AutoITScriptPath);
			Thread.sleep(2000);
		}
	}
			

	@Test(priority =4)
	public void MICR_CTS_Clearing_Process() throws InterruptedException
	{
		MICR_CTS_ClearingPage objMicrCTS= new MICR_CTS_ClearingPage (driver);
		Authorizations ObjAuthorise=new Authorizations(driver);
		MenuList objMenulist = new MenuList (driver);
		objMenulist.Open_window(objMenulist.MICR_Clearing);
		objMicrCTS.Clearing_type(ClearingType);
		objMicrCTS.SetClearingDate(ClearingDate);
		for(int i=0;i<5;i++)
		{
			objMicrCTS.Clearing_Batch(ClearingBatch);
		}
		
		objMicrCTS.Select_Reg_BranchName(ClearingRegBranch);
		objMicrCTS.Click_Search_Btn();
		objMicrCTS.Select_From_ClrngDetails_Grid();
		objMicrCTS.Click_Clear_Btn();
		try 
		{
			objMicrCTS.Close_ClearOrReturn_Saved_PopUp();
			Thread.sleep(100);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		
		if(ClearingType.equals("MICR OUTWARD") ||ClearingType.equals("CTS OUTWARD" ))
		{
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ObjAuthorise.Logged_UserName);
			if(ObjAuthorise.Logged_UserName.getText()==User)
			{
				System.out.println("Logged User is "+ ObjAuthorise.Logged_UserName.getText());
				ObjAuthorise.LoginForAuthorization(Authorizn_User, Authorizn_Pass);
			}
			else
			{
				ObjAuthorise.LoginForAuthorization(User, Pass);
			}
			
			ObjAuthorise.Manager_authorization_Others();
		}
		
		else if(ClearingType.equals("MICR INWARD") ||ClearingType.equals("CTS INWARD"))
		{
			Thread.sleep(2000);
			objMicrCTS.Print_Voucher();
			Clrng_Transid=objMicrCTS.TransID_in_summary.getText();
			System.out.println("\n"+ClearingType +" Clearing Done with Trans Id: "+Clrng_Transid +"\n");	 
			
			ObjAuthorise.LoginForAuthorization(Authorizn_User, Authorizn_Pass);	
			ObjAuthorise.Manager_authorization_Transfer(Clrng_Transid);
		}
			
	}
	 
	
}
