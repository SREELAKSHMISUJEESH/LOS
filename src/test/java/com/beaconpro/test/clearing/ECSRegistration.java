package com.beaconpro.test.clearing;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 20/05/2016
Purpose	        : ECS Registration [Inward/Outward both handled] & Batch Assign Page; Included Authorization
Note			: 
Conditions      : For Inward Clearing, the Personal A/c should have valid ECS Marking details
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.clearing.BatchAssign;
import com.beaconpro.module.uiobject.clearing.ECSRegistrationPage;
import com.beaconpro.module.uiobject.clearing.EcsMarkingPage;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;

public class ECSRegistration 
{

	WebDriver driver;
	
	String User      = "shilpa";
	String Pass      = "test123";
		
	//String ClrngType="ECS DEBIT";
	String ClrngType ; //= "ECS CREDIT";             // Set the ECS Clearing Type - "ECS DEBIT" for Inward; "ECS CREDIT" for Outward
	
	String AccBranch;	//= "MAIN BRANCH"; 	         // Clearing A/c Branch
	String PdtGrp	;	//= "Savings Bank";          // Clearing A/c ProductGroup
	String PdtName	;	//= "ORDINARY SB";           // Clearing A/c Product Name
	String ECSAccNo	;	//= "29100";			     // Clearing A/c number
	// to delete String ECSAccNo		= "2121";
	
	//String ECSAccNo		= "29600";
	String SeqnceNo;		//= "45456";			 // ECS Sequence Number for Outward Clearing	
	String Crdt_Usrno;	//= "2323"; 		    	 // ECS User Number for Outward Clearing
	String Crdt_Amt	;	//= "1000"; 			     // ECS amount for Outward Clearing
	
	
	//Batch Assign Window  Specific Details 
	
	String ClearingGroup;  //= "ECS";			       // ClearingGroup 
	String OrgBranch ;     //= AccBranch;			   // Branch
	String FromDate ;      //="13/06/2017";			   // From Date
	String ToDate;         //="13/06/2017";			   // To Date
	String ToBatch ;       //="102-ECS-OW-1362017-3";  // Clearing Batch To which the Clearing Register No is to be assigned
	
	
	/***** Excel Input data file details ********/ 
	String SheetName     = "ECSRegistration";
	String FileName      = "ECS/InputData.xls";
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
		
		 
		 ClrngType    = ExcelData[0];
		 AccBranch	  = ExcelData[1];
		 PdtGrp       = ExcelData[2];
		 PdtName      = ExcelData[3];
		 ECSAccNo     = ExcelData[4];

		 SeqnceNo     = ExcelData[5];
		 Crdt_Usrno   = ExcelData[6];
		 Crdt_Amt     = ExcelData[7];

		 ClearingGroup = ExcelData[8];
		 OrgBranch     = ExcelData[9];
		 FromDate      = ExcelData[10];
		 ToDate        = ExcelData[11];
		 ToBatch       = ExcelData[12];
		 
		 //System.out.println ("Values are :"+ClrngType+ "\n"+AccBranch + "\n"+PdtGrp+ "\n"+PdtName+ "\n"+ECSAccNo+"\n"+SeqnceNo+"\n"+SeqnceNo+"\n"+Crdt_Amt+"\n"+ClearingGroup);
		// System.out.println ("Values are from :"+PdtName+ "\n"+ECSAccNo+"\n"+SeqnceNo+"\n"+Crdt_Usrno+"\n"+Crdt_Amt+"\n"+ClearingGroup);
		 System.out.println(ClrngType + AccBranch+  PdtGrp +PdtName+ECSAccNo+SeqnceNo+Crdt_Usrno+Crdt_Amt+ClearingGroup+OrgBranch+FromDate+ToDate+ToBatch);
		
	}
	

	 
	
	@Test(priority=2)
	public  void ECSRegistrationProcess() throws Throwable
	
	{
		ECSRegistrationPage ObjECSReg=new ECSRegistrationPage(driver);
		
		ObjECSReg.Open_ECSRegistration_Window();
		ObjECSReg.Select_Ecs_ClrngType(ClrngType);
		ObjECSReg.Select_ECSRegBranch(AccBranch);
		ObjECSReg.Select_ECSRegPdtGrp(PdtGrp);
		Thread.sleep(300);
		//ObjeEcsMark.dependableClick_for_StaleElement_handling(driver,ObjECSReg.ECSReg_PdtName);
		ObjECSReg.Select_ECSRegPdtName(PdtName);
		Thread.sleep(30);
		ObjECSReg.ECSReg_AccNo.sendKeys(ECSAccNo);
		ObjECSReg.ECSReg_AccNo.sendKeys(Keys.TAB);
		WebDriverWait wait1=new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOf(ObjECSReg.ECSReg_Acc_Details_Grid));
//		if (ClrngType=="ECS DEBIT")
		if (ClrngType.equals("ECS DEBIT"))
		{
			ObjECSReg.ECSReg_ECS_Details_ChkBox.click();
			WebDriverWait wait2=new WebDriverWait(driver,300);
			wait2.until(ExpectedConditions.visibilityOf(ObjECSReg.ECSReg_ECS_DetailsGrid));
			String ECSNoFromGrid=ObjECSReg.ECSReg_ECS_DetailsGrid.getText();
			ObjECSReg.Select_Ecs_No(ECSNoFromGrid);
		}
		ObjECSReg.ECSReg_SeqncNo.clear();
		ObjECSReg.ECSReg_SeqncNo.sendKeys(SeqnceNo);
		Thread.sleep(30);
		if(ClrngType.equals("ECS CREDIT"))
		{
			ObjECSReg.Send_EcsCrdtRegstrDetails(Crdt_Usrno,Crdt_Amt);
			ObjECSReg.Select_ECSCrdtBank();
			Thread.sleep(30);
			ObjECSReg.Select_ECSCrdt_BankBranch();
			Thread.sleep(30);
			
		}
		ObjECSReg.EcsReg_Submit_Button.click();
		
		if(ObjECSReg.ECSRegistrationSuccess_Message.isDisplayed())
		{
			Thread.sleep(300);
			ObjECSReg.CloseMessage.click();
		}
		 
		Thread.sleep(2000);
		String ECSRegistrationDetails=ObjECSReg.ECS_RegistrationSummary.getText();
		System.out.println("\n*****ECS Registering Details is : "+ECSRegistrationDetails +"****");
		
		ObjECSReg.Split_String(ECSRegistrationDetails);;
		Thread.sleep(300);
	}
	
	@Test(priority=3)
	public  void ECSBatchAssignProcess() throws InterruptedException
	{
		BatchAssign ObjBatch=new BatchAssign(driver);
		ClrngType=ExcelData[0];
		
		ObjBatch.Batch_Assign(ClearingGroup, ClrngType, OrgBranch, FromDate, ToDate, ToBatch);
		
		
	}
	
	
	
}
