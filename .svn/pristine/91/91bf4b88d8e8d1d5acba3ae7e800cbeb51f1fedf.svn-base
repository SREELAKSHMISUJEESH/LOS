package com.beaconpro.test.acopening;
/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 15/04/2016
Purpose	        : Term Deposits Closure
Note			: Kyc not completed customer, Premature closing,Default A/c Pop up messages handled
Conditions      : A/c Should not be a Leined A/c
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason
Shilpa				26/05/2016			All Transactionmodes integrated 
Bajith				09/06/2016			Added Data reading from excel file
Shilpa				17/06/2016			Authorisation,Screenshots integrated
-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beaconpro.config.ScreenShot;
import com.beaconpro.module.uiobject.acopening.FDOpeningPage;
import com.beaconpro.module.uiobject.common.Authorizations;
import com.beaconpro.module.uiobject.common.NomineeAdding;
import com.beaconpro.module.uiobject.common.OperatorAdding;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.common.TransactionModeSelection;
import com.beaconpro.module.uiobject.login.LoginPage;

public class FDOpening 

{		
		public static WebDriver driver;
		String TransID;
		String ContraTransID;
			  
		
		public  String User   	;
		public  String Pass    	;
		public  String Authorizn_User ;
		public  String Authorizn_Pass ;
		
		// Screenshot Folder and File details		
		static String ScrnShotFolderName                  = "FDAccOpening_Screens";
		static String GenTab_FileName                     = "FDOpen_GeneralTab_Data.jpeg";
		static String NomineeTab_FileName                 = "FDOpen_NomineeTab_Data.jpeg";
		static String OperatrTab_FileName                 = "FDOpen_OperatorTab_Data.jpeg";
		static String StandingTab_FileName                = "FDOpen_StandingTab_Data.jpeg";
		static String MaturityTab_FileName                = "FDOpen_MaturityTab_Data.jpeg";
		static String SummaryDetails_FileName             = "FDOpen_Summary_Data.jpeg";
		static String ContraEntry_SummaryDetails_FileName = "FDOpen_ContraEntrySummary_Data.jpeg";
		
		
		static String CustName 					;
		static String FDOpenAmount				;	//FD Opening amount
		static String FDOpenDuration			;	//FD Opening duration
		static String FD_DurationModeInMonths	;	//FD Opening duration mode
		static String FDOpenRemarks				;	//FD Opening Remarks

		public String TransMode					;	// Give the Transaction Mode as "CASH" / "TRANSFER_AUTOPOST" For Autopost /"TRANSFER_BATCH" For Open Batch
		
		//Give Operator Details details below
		public static String OperatorName		;
		public static String Operator_Relation  ;
		
		//Give Nominee Details details below
		public static String NomineeCustName	; 
		public static String NomineeCustID		;
		public static String NomineeRelation	;
		
		//Give Standing Details details below
		public static String SI_ProductName		;
		public static String SI_AccNo			;
		public static String SI_Frequency		;
		public static String SI_Remarks			;
		

		//Give Autopost details below
		public  String PostDebitCrdtPrdctGrp	;
		public  String PostDebitCrdtPrdctNme	;
		public  String PostDebitCrdtAcNo		;
		public  String InstrType     		  	;
		
		
		//Give OpenBatch_ContraEntry Transaction details below
		 
		public static String ContraEntry_Branch     		;		//Debit a/c existing branchname
		public static String ContraEntry_PdtGrp			    ;		//Debit a/c product group
		public static String ContraEntry_PdtName	   		;		//Debit a/c productname
		public static String ContraEntry_AccNo			    ;		//Debit a/c number
		public static String ContraEntry_TransType		    ;		//Contra Entry transaction type for debit a/c ;credit/debit
		public static String ContraEntry_InstrType			;		//Debit a/c transaction instrument type
		public static String ContraEntry_Acc_operated_by    ; 		//Debit a/c operated by
		public static String ContraEntry_Acc_Transmode	    ;       //Debit a/c transaction mode 
		public static String ContraEntry_Trans_Remark		; 		//Debit a/c transaction remarks

		
		
		String SheetName = "FDOpening";
		String FileName = "Fixed Deposit/FDinputdata.xls";
		
		ReadExcelFile rdxlfile;
		
		@Test (priority = 0)
		private void excelreading() throws IOException, Exception 
		{
			
			rdxlfile=new ReadExcelFile(driver);
			String array[] = new String[100];
			rdxlfile.ReadFromExcelFile(SheetName,FileName,array);
			User					=array[0];
			Pass					=array[1];
			Authorizn_User			=array[2];
			Authorizn_Pass			=array[3];
			CustName				=array[4];
			FDOpenAmount			=array[5];
			FDOpenDuration			=array[6];
			FD_DurationModeInMonths	=array[7];
			FDOpenRemarks			=array[8];
			TransMode				=array[9];
			OperatorName			=array[10];
			Operator_Relation		=array[11];
			NomineeCustName			=array[12];
			NomineeCustID			=array[13];
			NomineeRelation			=array[14];
			SI_ProductName			=array[15];
			SI_AccNo				=array[16];
			SI_Frequency			=array[17];
			SI_Remarks				=array[18];
			PostDebitCrdtPrdctGrp	=array[19];
			PostDebitCrdtPrdctNme	=array[20];
			PostDebitCrdtAcNo		=array[21];
			InstrType				=array[22];
			
			ContraEntry_Branch			  = array[23];
			ContraEntry_PdtGrp			  = array[24];
			ContraEntry_PdtName			  = array[25];
			ContraEntry_AccNo			  = array[26];
			ContraEntry_TransType		  = array[27];
			ContraEntry_InstrType		  = array[28];
			ContraEntry_Acc_operated_by	  = array[29];
			ContraEntry_Acc_Transmode	  = array[30];
			ContraEntry_Trans_Remark	  = array[31];
			
			}
		
		
		@Test(priority = 1)
		
		public  void Open_FireFox_and_LoginToBeaconPro() throws Throwable
		
		{	
			excelreading();
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
		@Test(priority = 2)
		public static void FDOpening_SendDetails() throws InterruptedException, IOException
		{   			
			FDOpeningPage ObjFDOpen =new FDOpeningPage(driver);
			NomineeAdding ObjNomAdd=new NomineeAdding(driver);
			ScreenShot scnshot=new ScreenShot(driver);
			ObjFDOpen.Send_CustomerDetails(CustName);
			
			ObjFDOpen.General_Tab(FDOpenAmount, FDOpenDuration, FD_DurationModeInMonths, FDOpenRemarks);
			
			scnshot.take_screen_shot(ScrnShotFolderName, GenTab_FileName);
			ObjFDOpen.ClickOnNextButton();
			Thread.sleep(60);
			ObjNomAdd.Nominee_Adding(NomineeCustName, NomineeCustID, NomineeRelation);
			
			scnshot.take_screen_shot(ScrnShotFolderName, NomineeTab_FileName);
			//ObjFDOpen.NextButton.click();
			ObjFDOpen.ClickOnNextButton();
			OperatorAdding ObjOprtrAdd=new OperatorAdding(driver);
			ObjOprtrAdd.OperatorTab(OperatorName, Operator_Relation);
			Thread.sleep(30);
			
			scnshot.take_screen_shot(ScrnShotFolderName, OperatrTab_FileName);
			Thread.sleep(60);
			//ObjFDOpen.NextButton.click();
			ObjFDOpen.ClickOnNextButton();
			ObjFDOpen.StandingAccDetails_Tab(SI_ProductName, SI_AccNo, SI_Frequency, SI_Remarks);
			Thread.sleep(200);
			scnshot.take_screen_shot(ScrnShotFolderName, StandingTab_FileName);
			
			ObjFDOpen.OnMaturity_Tab(driver);

			scnshot.take_screen_shot(ScrnShotFolderName, MaturityTab_FileName);
			
		}
		@Test(priority =3 )
		public void FDOpening_Submit() throws InterruptedException, IOException 
		{
			FDOpeningPage ObjFDOpen =new FDOpeningPage(driver);
			ScreenShot scnshot=new ScreenShot(driver);
			Thread.sleep(30);
			if(TransMode.equalsIgnoreCase("CASH"))
			{
				ObjFDOpen.TransMode_Select(TransMode);
				ObjFDOpen.Save_Button.click();
				WebDriverWait wait =new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(ObjFDOpen.AccOpenedSummary_Label));
				
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				TransID=ObjFDOpen.SummaryTransId.getText();
				
				scnshot.take_screen_shot(ScrnShotFolderName, SummaryDetails_FileName);
				//String BatchID=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[5]")).getText();
				ObjFDOpen.PrintVoucherAndCertificate();
				//ObjFDOpen.PrintNomineeAcknowldgmnt();
			}
			else if(TransMode.equalsIgnoreCase("TRANSFER_AUTOPOST"))
			{
				String TransferTransMode="TRANSFER";
				TransactionModeSelection objTransMode= new TransactionModeSelection(driver);
				objTransMode.Account_Opening_Transfer_Autoposting(TransferTransMode, PostDebitCrdtPrdctGrp, PostDebitCrdtPrdctNme, PostDebitCrdtAcNo,InstrType, FDOpenAmount);
				WebDriverWait wait =new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(ObjFDOpen.AccOpenedSummary_Label));
				
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				//String BatchID=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[5]")).getText();
				scnshot.take_screen_shot(ScrnShotFolderName, SummaryDetails_FileName);
				TransID=ObjFDOpen.SummaryTransId.getText();
				ObjFDOpen.PrintVoucherAndCertificate();
				//ObjFDOpen.PrintNomineeAcknowldgmnt();
				
			}
			else if (TransMode.equalsIgnoreCase("TRANSFER_BATCH"))
			{
				String TransferTransMode="TRANSFER";
				TransactionModeSelection objTransMode= new TransactionModeSelection(driver);
				objTransMode.Account_Opening_BatchTransfer(TransferTransMode);
				WebDriverWait wait =new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(ObjFDOpen.AccOpenedSummary_Label));
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				TransID=ObjFDOpen.SummaryTransId.getText();
				scnshot.take_screen_shot(ScrnShotFolderName, SummaryDetails_FileName);
				//String BatchID=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[5]")).getText();
				ObjFDOpen.PrintVoucherAndCertificate();
				//ObjFDOpen.PrintNomineeAcknowldgmnt();
				ObjFDOpen.generate_contraEntry_for_openBatch(ContraEntry_Branch, ContraEntry_PdtGrp, ContraEntry_PdtName, 
						ContraEntry_AccNo, ContraEntry_TransType, FDOpenAmount,ContraEntry_InstrType,
						ContraEntry_Acc_operated_by, ContraEntry_Acc_Transmode);
				ContraTransID=ObjFDOpen.SummaryTransId.getText();
				Thread.sleep(60);				
				scnshot.take_screen_shot(ScrnShotFolderName, ContraEntry_SummaryDetails_FileName);
				
				ObjFDOpen.Click_on_print_and_close_preview();
				
			}
			//driver.quit();
		}
		
		@Test(priority =4)
		public void AuthorisationProcess() throws InterruptedException
		{
			Authorizations ObjAuthorise=new Authorizations(driver);
			FDOpeningPage ObjFDOpen =new FDOpeningPage(driver);
			ObjAuthorise.LoginForAuthorization(Authorizn_User, Authorizn_Pass);
			
			if (TransMode.equals("CASH"))
			{
				ObjAuthorise.Cashier_Authorization(TransID);
			}
			else if(TransMode.equals("TRANSFER_AUTOPOST")) 
			{
				ObjAuthorise.Manager_authorization_Transfer(TransID);
			}
			else if(TransMode.equals("TRANSFER_BATCH" ))
			{
				ObjAuthorise.Manager_authorization_Transfer(TransID);
				//ObjAuthorise.Manager_authorization_Transfer(ContraTransID);
			}
									
			
		}
		
		
}

