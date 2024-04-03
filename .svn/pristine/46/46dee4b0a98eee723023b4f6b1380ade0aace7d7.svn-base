package com.beaconpro.test.clearing;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.clearing.BatchAssign;
import com.beaconpro.module.uiobject.clearing.CTSInwardAndOutwardRegistrationPage;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 06/06/2016
Purpose	        : CTS Inward/Outward Registration 
					Step 1: For Inward: Registration , Verification and For Outward : Registration 
					Step 2: Batch Assign For both
Note			: While giving File path as parameters, give double slash instead of single slash, since single slash is treated as escape sequence character
Conditions      :* Set the GeneralConfig Key CTS_File_Vendor_Type=1 for Inward Registration
                 * A/c details in text file of Inward Clearing should be Valid
                 * Should not have any other entries for Inward pending verification in the same date 
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason
 
-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

public class CTSInwardAndOutwardRegistration 
{

	public WebDriver driver;
	
	String User  = "shilpa";    //Login User Credentials
	String Pass  = "test123";
	
	/*****CTS Inward Registration Specific details *****/
	String ClngType ;    // = "CTS OUTWARD";                                            // CTS Clearing Type
	String TextFilePath; // = "F:\\Shilpa QA\\TESTING\\SQL QUERIES\\cts12 - Copy.txt";  // CTS Inwrd Clearing Text File Path ;NB:Replace '\' with '\\'
	String PdfFilePath;  // = "C:\\Users\\shilpa\\Desktop\\Sample Pdf.pdf";			    // CTS Inwrd Clearing PDF File Path ; NB:Replace '\' with '\\'
	
	
	/*****CTS Inward Verification Specific details *****/
	String VerifcnFromDate ; // = "13062017";
	String VerificnToDate;   // = "13062017";
	
	
	/*****Outward Registration Specific details *****/
	String ProductGroup; // = "Savings Bank";
	String Productname ; // = "ORDINARY SB";
	String Productacno;  // = "8700";
	String Instrtype ;   // = "Cheque";
	String Prefix  ;     // = "AB";
	String InstrNo  ;    // = "1234";
	String InstDate ;    // = "13062017";
	String Amount ;      // = "1000";
	
	
	
	/***Batch Assign Details ****/
	String ClearingGroup; // = "CTS";
	String OrgBranch;     // = "MAIN BRANCH";
	String ToBatch   ;    // = "102-CTS-OW-1362017-3";
	
	
	/***** Excel Input data file details ********/ 
	String SheetName     = "CTSInwardAndOutwardRegistration";
	String FileName      = "CTS/InputData.xls";
	String [] ExcelData  =  new String[100];
		
	
	
	
	
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
	private void ECSMark_ExcelDataReading() throws BiffException, IOException 
	{
		ReadExcelFile ObjReadExcel= new ReadExcelFile(driver);
		
		ObjReadExcel.ReadFromExcelFile( SheetName,  FileName, ExcelData);
		
		System.out.println ("Completed ReadFromExcelFile");
		
		 
		 ClngType        = ExcelData[0];
		 TextFilePath	 = ExcelData[1];
		 PdfFilePath     = ExcelData[2];
		 VerifcnFromDate = ExcelData[3];
		 VerificnToDate  = ExcelData[4];

		 ProductGroup    = ExcelData[5];
		 Productname     = ExcelData[6];
		 Productacno     = ExcelData[7];

		 Instrtype       = ExcelData[8];
		 Prefix          = ExcelData[9];
		 InstrNo         = ExcelData[10];
		 InstDate        = ExcelData[11];
		 Amount          = ExcelData[12];
		 
		 ClearingGroup   = ExcelData[13];
		 OrgBranch       = ExcelData[14]; 
		 ToBatch         = ExcelData[15]; 
		 
		 //System.out.println ("Values are :"+ClrngType+ "\n"+AccBranch + "\n"+PdtGrp+ "\n"+PdtName+ "\n"+ECSAccNo+"\n"+SeqnceNo+"\n"+SeqnceNo+"\n"+Crdt_Amt+"\n"+ClearingGroup);
		// System.out.println ("Values are from :"+PdtName+ "\n"+ECSAccNo+"\n"+SeqnceNo+"\n"+Crdt_Usrno+"\n"+Crdt_Amt+"\n"+ClearingGroup);
		 System.out.println(ClngType + ProductGroup+  Productname +Productacno+Amount+Amount+OrgBranch+ToBatch);
		
	}

	@Test(priority=2)
	public void CTSRegistrationProcess() throws Exception
	{
		CTSInwardAndOutwardRegistrationPage ObjCTS=new CTSInwardAndOutwardRegistrationPage(driver);
		if (ClngType.equals("CTS INWARD"))
		{
			
			ObjCTS.CTSRegistrationProcess(ClngType, TextFilePath, PdfFilePath);
			ObjCTS.CTSVerificationProcess(VerifcnFromDate, VerificnToDate);
			Thread.sleep(2000);
		}
		else if (ClngType.equals("CTS OUTWARD"))
		{
			ObjCTS.CTS_Outward_RegistrationProcess(ClngType, ProductGroup, Productname, Productacno, Instrtype, Prefix, InstrNo, InstDate, Amount);
			Thread.sleep(2000);
		}
		
	}
   @Test(priority=3)
	public void BatchAssign() throws InterruptedException, BiffException, IOException
	{
	    // String FromDate =VerifcnFromDate ;
		// String ToDate   =VerificnToDate ;
		String FromDate  = ExcelData[3];
		String ToDate    = ExcelData[4];
		BatchAssign ObjBatch=new BatchAssign(driver);
		
		ObjBatch.Batch_Assign(ClearingGroup, ClngType, OrgBranch, FromDate, ToDate, ToBatch);
	}
	

	
}
