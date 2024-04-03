package com.beaconpro.test.clearing;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 20/05/2016
Purpose	        : ECS Marking Test Case [Inward];Authorization also included
Note			: 
Conditions      :  
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/
import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;






import com.beaconpro.module.uiobject.clearing.EcsMarkingPage;
import com.beaconpro.module.uiobject.common.Authorizations;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;

public class ECSMarking
{
	
	WebDriver driver;
		
	String User           = "shilpa";
	String Pass           = "test123";
	
	String Authorizn_User = "shilpaau";
	String Authorizn_Pass = "test123";
	
	
	
	String AccBranch ;     //="MAIN BRANCH";
	String PdtGrp ;        //"Savings Bank";
	String PdtName ;       //"ORDINARY SB";
	String Accno ;         //"2121";
	//String Accno="28272" ;
	String EcsNo ;         //"12344"; 
	String UsrNo ;         //"444";
	String EfctFrmDate ;   //"01062017";
	String Ecs_Durn ;      //"12";
	String InstPeriod ;    //"1";	
	String EcsAmt ;        //"100";
	String EcsRemarks ;    //"ECS Marking Added";	
	
	/***** Excel Input data file details ********/ 
	 
	String SheetName     = "ECSMarking";
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
		
		System.out.println ("Driver :"+driver);
		
		ObjReadExcel.ReadFromExcelFile( SheetName,  FileName, ExcelData);
		
		System.out.println ("Completed ReadFromExcelFile");
		
		 AccBranch     = ExcelData[0];
		 PdtGrp        = ExcelData[1];
		 PdtName       = ExcelData[2];
		 Accno         = ExcelData[3];
		 EcsNo         = ExcelData[4]; 
		 UsrNo         = ExcelData[5];
		 EfctFrmDate   = ExcelData[6];
		 Ecs_Durn      = ExcelData[7];
		 InstPeriod    = ExcelData[8];	
		 EcsAmt        = ExcelData[9];
		 EcsRemarks    = ExcelData[10];
		 
		 System.out.println ("Values are :"+AccBranch+ "\n"+PdtGrp + "\n"+PdtName+ "\n"+Accno+ "\n");
		
	}
	 
	@Test(priority=2)
	public  void EcsmarkingSubmit() throws InterruptedException, BiffException, IOException 
	{
		EcsMarkingPage ObjEcsMark=new EcsMarkingPage(driver);
		Authorizations ObjAuthorise=new Authorizations(driver);
    	
		ObjEcsMark.Open_ECSMarking_Window();
		
		//ECSMarking ObjEcsMarkTC=new ECSMarking();
		//ObjEcsMarkTC.ECSMark_ExcelDataReading();
		
		ObjEcsMark.EcsMarkingDetailsSubmit(AccBranch, PdtGrp, PdtName, Accno, EcsNo, UsrNo, EfctFrmDate, Ecs_Durn, InstPeriod,EcsAmt,EcsRemarks);
		Thread.sleep(2000);
		ObjAuthorise.LoginForAuthorization(Authorizn_User, Authorizn_Pass);
		ObjAuthorise.Manager_authorization_Others();
	}

	
	
}
