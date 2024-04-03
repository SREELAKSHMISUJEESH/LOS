package com.beaconpro.test.clearing;
/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 02/06/2016
Purpose	        : ECS Presenting And Clearing  [Both Inward,Outward Clearing Handled] ; Included Authorization
Note			: 
Conditions      :  
  
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

import com.beaconpro.module.uiobject.clearing.EcsClearingPage;
import com.beaconpro.module.uiobject.clearing.EcsPresentingPage;
import com.beaconpro.module.uiobject.common.Authorizations;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;

public class ECSPresentingAndClearing
{
	WebDriver driver;
	String Clrng_Transid;
	
	
	String User           = "shilpa";
	String Pass           = "test123";
	
	String Authorizn_User = "shilpaau";
	String Authorizn_Pass = "test123";
	
	String ClearingType ;        // = "ECS CREDIT";
	//String ClearingType="ECS DEBIT";
	String ClearingDate ;        // = "13/06/2017";
	String ClearingBatch;        // = "102-ECS-OW-1362017-3";
	//String ClearingBatch       // = "102-ECS-INW-1362017-1";
	String ClearingRegBranch ;   // = "MAIN BRANCH";
	
	
	/***** Excel Input data file details ********/ 
	String SheetName     = "ECSPresentingAndClearing";
	String FileName      = "ECS/InputData.xls";
	String [] ExcelData  =  new String[100];
	
	
	@Test(priority=0)
	public  void Open_FireFox_and_LoginToBeaconPro() throws Throwable
	
	{
		
		try {																																																							
			
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
		
		 
		 //System.out.println ("Values are :"+ClrngType+ "\n"+AccBranch + "\n"+PdtGrp+ "\n"+PdtName+ "\n"+ECSAccNo+"\n"+SeqnceNo+"\n"+SeqnceNo+"\n"+Crdt_Amt+"\n"+ClearingGroup);
		// System.out.println ("Values are from :"+PdtName+ "\n"+ECSAccNo+"\n"+SeqnceNo+"\n"+Crdt_Usrno+"\n"+Crdt_Amt+"\n"+ClearingGroup);
		 System.out.println(ClearingType+"\n" + ClearingDate+"\n"+  ClearingBatch+"\n" +ClearingRegBranch+"\n");
		
	}
	
	@Test(priority = 2)
	public void Presenting() throws InterruptedException 
	
	{
		EcsPresentingPage objEcsPresent = new EcsPresentingPage(driver);
		Authorizations ObjAuthorise=new Authorizations(driver);
		MenuList objML= new MenuList(driver);
		if(ClearingType.equals("ECS CREDIT"))
		{
			objEcsPresent.Open_window(objML.ECS_Presenting);
			
			objEcsPresent.Presenting(ClearingType, ClearingDate, ClearingBatch, ClearingRegBranch);
			String TransID=objEcsPresent.GetTransId();
			System.out.println("Transid is "+TransID);
			ObjAuthorise.LoginForAuthorization(Authorizn_User, Authorizn_Pass);
						
			ObjAuthorise.Manager_authorization_Transfer(TransID);
		}
	}
	 
	@Test(priority=3)
	
	public void Clearing() throws InterruptedException
	{
		EcsClearingPage ObjEcsClrng=new EcsClearingPage(driver);
		Authorizations ObjAuthorise=new Authorizations(driver);
		ObjEcsClrng.Open_ClearingWindow();
		ObjEcsClrng.Clearing_type(ClearingType);
		ObjEcsClrng.SetClearingDate(ClearingDate);
		for(int i=0;i<5;i++)
		{
			ObjEcsClrng.Clearing_Batch(ClearingBatch);
		}
		
		ObjEcsClrng.Select_Reg_BranchName(ClearingRegBranch);
		ObjEcsClrng.Click_Search_Btn();
		ObjEcsClrng.Select_From_ClrngDetails_Grid();
		ObjEcsClrng.Click_Clear_Btn();
		try 
		{
			ObjEcsClrng.Close_ClearOrReturn_Saved_PopUp();
			Thread.sleep(100);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		
		if(ClearingType.equals("ECS CREDIT"))
		{
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ObjAuthorise.Logged_UserName); // To Make gettext() to return correct value
			if(ObjAuthorise.Logged_UserName.getText()==User)
			{
				ObjAuthorise.LoginForAuthorization(Authorizn_User, Authorizn_Pass);
			}
			else
			{
				ObjAuthorise.LoginForAuthorization(User, Pass);
			}
			
			ObjAuthorise.Manager_authorization_Others();
		}
		
		else if(ClearingType.equals("ECS DEBIT"))
		{
			ObjEcsClrng.Print_Voucher();
			Clrng_Transid=ObjEcsClrng.TransID_in_summary.getText();
			System.out.println("\n"+ClearingType +" Clearing Done with Trans Id: "+Clrng_Transid +"\n");	 
			
			ObjAuthorise.LoginForAuthorization(Authorizn_User, Authorizn_Pass);	
			ObjAuthorise.Manager_authorization_Transfer(Clrng_Transid);
		}
		
		
	}


}
