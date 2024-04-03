package com.beaconpro.test.acclosure;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 28/04/2016
Purpose	        : Term Deposits Closure
Note			: Kyc not completed customer, Premature closing,Default A/c Pop up messages handled
Conditions      : A/c Should not be a Leined A/c
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.read.biff.BiffException;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.beaconpro.module.uiobject.acclosure.TermDepositClosureAndRenewalPage;
import com.beaconpro.module.uiobject.acopening.FDOpeningPage;
import com.beaconpro.module.uiobject.common.ClosurePageCommon;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.common.RenewalPageCommon;
import com.beaconpro.module.uiobject.common.TransactionModeSelection_TermDeposits;
import com.beaconpro.module.uiobject.login.LoginPage;



public class TermDepositsClosureAndRenewal
{
	
	public WebDriver driver;
	String Prod_Grp;
	String Prod_Name;
	String Accno;
	String AccClosurePayableAmt;
	String TransferTransMode;
	
//################################	Main parameters ###################################################################
	
	/*** Login and Authorization Credentials****/
	
	String User           = "shilpa";
	String Pass           = "test123";
	String Authorizn_User = "shilpaau";
	String Authorizn_Pass = "test123";
	
	/***** Excel Input data file details ********/ 
	String SheetName     = "CTSInwardAndOutwardRegistration";
	String FileName      = "Account closure/Term Deposit Closure & Renewal/TermDepost Closure_Renewal.xls";
	String [] ExcelData  =  new String[100];
		
	
	/*** Give Closure/Renewal A/c details below****/
		
	String Brch_Name = "MAIN BRANCH"; //Closing/Renewing A/c Branch name
	
	//String[] ProductGroup = new String[] { "Re-Investments- CC" ,"Recurring Deposit","Pigmy Deposit"};
	
	
	/****** If Only FD Closure is need , remove/comment remaining product groups from the ProductGroup array parameters****/
	String[] ProductGroup = new String[]{"Fixed Deposit" ,"Re-Investments- CC"};//, {"Fixed Deposit","Re-Investments- CC" ,"Recurring Deposit","Pigmy Deposit"};
	String[] ProductName  = new String[] {};
		
		
	String FD_AccNo      = "228128";
	String RID_AccNo     = "28650";
	String RD_AccNo      = "3526";
	String Pigmy_AccNo   = "36217";
	//Prem Ren String FD_AccNo        = "228128";  
	//Maturity Ren String FD_AccNo    = "236596";
	//Shilpa  FD_AccNo                = "182511";
	// String RID_AccNo               = "18214";
		
 
	String TransMode         = "TRANSFER_BATCH"; //Give Closure Transaction mode as CASH , TRANSFER_AUTOPOST , TRANSFER_BATCH ; For Renewal- TRANSFER By default, no need to set here
	
	String ClosureOrRenewal  = "RENEWAL"; //*** Select Operation ; CLOSURE or RENEWAL 
	
//################################ END OF Main parameters############################################################
	
	
	/*** Give the Renewal details;if ClosureOrRenewal="RENEWAL"..****/
	
		String Renewal_durn        = "12";
		String Renewal_durn_mode   = "MONTHS";
		String NomineeCustName     = " SARATH LAL";
		String NomineeCustID       = "";
		String NomineeRelation     = "BROTHER";
		
		String Renewal_SI_Prdt      = "ORDINARY SB";
		String Renewal_SI_Accno     = "29760";
		String Renewal_SI_Freqency  = "1";
		
		
	
	/***** Give Post Credit Transaction Account details, for CLOSURE ;Only For TrandMode=TRANSFER_AUTOPOST ; ****/
	  
	    String pstcrdt_prdtgrp    = "Savings Bank";
	    String pstcrdt_prdtname   = "ORDINARY SB";
	    String pstcrdt_accno      = "14375";
	 
	/*****Give OpenBatch_ContraEntry Transaction details below for CLOSURE; Only For TrandMode=TRANSFER_BATCH****/
		  
		static String credit_branch          = "	";
		static String credit_pdtgrp          = "Savings Bank";
		static String credit_pdtname         = "ORDINARY SB";
		static String credit_accno           = "26100";
		static String credit_transtype       = "Credit";
		static String credit_acc_transmode   = "TRANSFER";
		static String credit_acc_operated_by = "Tester From SES";
	
//------------------------------------- END OF PARAMETERS  -------------------------------------------	
	
	

	
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
		
	
	
	//@Test(priority=1)
	private void TDCloseAndRenew_ExcelDataReading() throws BiffException, IOException 
	{
		ReadExcelFile ObjReadExcel= new ReadExcelFile(driver);
		
		ObjReadExcel.ReadFromExcelFile( SheetName,  FileName, ExcelData);
		
		System.out.println ("Completed ReadFromExcelFile");
		
		 
		Brch_Name              = ExcelData[0];
		
		FD_AccNo			   = ExcelData[1];
		RID_AccNo		       = ExcelData[2];
		RD_AccNo		       = ExcelData[3];
		Pigmy_AccNo		       = ExcelData[4];
		 
		TransMode		       = ExcelData[5];
		ClosureOrRenewal       = ExcelData[6];
		
		Renewal_durn	       = ExcelData[7];
		Renewal_durn_mode      = ExcelData[8];
		
		NomineeCustName 	   = ExcelData[9];
		NomineeCustID	       = ExcelData[10];
		NomineeRelation        = ExcelData[11];
		
		Renewal_SI_Prdt        = ExcelData[12];
		Renewal_SI_Accno       = ExcelData[13];
		Renewal_SI_Freqency    = ExcelData[14];
		
		pstcrdt_prdtgrp		   = ExcelData[15];
		pstcrdt_prdtname	   = ExcelData[16];
		pstcrdt_accno		   = ExcelData[17];
		
		credit_branch	 	   = ExcelData[18];
		credit_pdtgrp          = ExcelData[19];
		credit_pdtname         = ExcelData[20];
		credit_accno           = ExcelData[21];
		credit_transtype       = ExcelData[22];
		credit_acc_transmode   = ExcelData[23];
		credit_acc_operated_by = ExcelData[24];

		
		System.out.println(TransMode + ClosureOrRenewal);
		
	}
	
	
	@Test(priority=2)
	public void TermDepositClosing() throws InterruptedException 
	
	{
		TermDepositClosureAndRenewalPage ObjTDClose=new TermDepositClosureAndRenewalPage(driver);
		TransactionModeSelection_TermDeposits ObjTransmodeTD=new TransactionModeSelection_TermDeposits(driver);
		ClosurePageCommon ObjCloseComn=new ClosurePageCommon(driver);
		System.out.println("test 123 ");
		
		for (int i=0; i<ProductGroup.length;i++)
		{
			ObjCloseComn.open_termdeposit_closure_window();
			ObjCloseComn.select_branch_name(Brch_Name);
			Thread.sleep(100);
			
			System.out.println("Value of ProductGrpLength  : " +ProductGroup.length);
			System.out.println("Value of ProductNameLength : " +ProductName.length);
			
			System.out.println("Value of i : " +i);
			
			
			Prod_Grp =ProductGroup[i] ;
			ObjCloseComn.select_product_group(Prod_Grp);
			
			
				if(Prod_Grp=="Fixed Deposit")
				{
					ProductName=new String [] {"ORDINARY FD"};
				//	ObjCloseComn.select_product_name(Prod_Name);
				}
				
				else if (Prod_Grp=="Re-Investments- CC")
				{
					ProductName=new String [] {"ORDINARY RID"};
					//ObjCloseComn.select_product_name(Prod_Name);
				}
				
				else if (Prod_Grp=="Recurring Deposit")
				{
					ProductName=new String [] {"ORDINARY RD"};
					//ObjCloseComn.select_product_name(Prod_Name);
				}
				else if (Prod_Grp=="Pigmy Deposit")
				{
					ProductName=new String [] {"ORDINARY DD"};
					
				}
				
				Thread.sleep(1000);	
		{
			
			for (int j=0; j<ProductName.length;j++)
				{
					System.out.println("Value of j : " +j);
					Prod_Name =ProductName[j] ;
					ObjCloseComn.select_product_name(Prod_Name);
					//ObjCloseComn.select_product_name(Prod_Name);
					
					
				
					if(Prod_Name=="ORDINARY FD")
					{
						ObjCloseComn.enter_account_number(FD_AccNo);
					}
					
					else if (Prod_Name=="ORDINARY RID")
					{
						ObjCloseComn.enter_account_number(RID_AccNo);
					}
					else if (Prod_Name=="ORDINARY RD")
					{
						ObjCloseComn.enter_account_number(RD_AccNo);
					}
					else if (Prod_Name=="ORDINARY DD")
					{
						ObjCloseComn.enter_account_number(Pigmy_AccNo);
					}
					
				
					ObjCloseComn.GoButton.click();
					Thread.sleep(1000);
					ObjTDClose.PrematureClosing_Alert_handle();
					Thread.sleep(100);
					ObjCloseComn.KYC_Not_Completed_Warning_Msg_PopUp_Click();
					Thread.sleep(30);
					ObjTDClose.PigmyAcc_Defaulted_PopUp_Message_click();
					AccClosurePayableAmt = ObjTDClose.Set_AccClosurePayableAmt();
					
					System.out.println("Value of AccClosurePayableAmt ["+Prod_Name+"] : " +AccClosurePayableAmt );
					
					if(ClosureOrRenewal=="CLOSURE")
					{
						
			
					
						if(TransMode=="CASH")
						{
							WebDriverWait wait2 =new WebDriverWait(driver, 10);
							wait2.until(ExpectedConditions.elementToBeClickable(ObjCloseComn.TransactionModeDropDownField));
							ObjCloseComn.select_transmode_info(TransMode);
							ObjCloseComn.click_on_submit();
								
							WebDriverWait wait3 =new WebDriverWait(driver, 10);
							wait3.until(ExpectedConditions.visibilityOf(ObjTDClose.AccountClosedSummary_Label));
							
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							
							ObjTDClose.PrintVoucher(driver);
							ObjCloseComn.CloseSummaryPage();
						}
						
						else if (TransMode=="TRANSFER_AUTOPOST")
							
						{					 
							
							//WebDriverWait wait4 =new WebDriverWait(driver, 10);
							//wait4.until(ExpectedConditions.elementToBeClickable(ObjCloseComn.TransactionModeDropDownField));
							
							WebDriverWait wait5 =new WebDriverWait(driver, 10);
							wait5.until(ExpectedConditions.elementToBeClickable(ObjCloseComn.TransactionModeDropDownField));
							TransferTransMode="TRANSFER";
							ObjTransmodeTD.post_credit_transation(TransferTransMode, pstcrdt_prdtgrp, pstcrdt_prdtname, pstcrdt_accno);
							ObjCloseComn.click_on_submit();
							
							WebDriverWait wait6 =new WebDriverWait(driver, 10);
							wait6.until(ExpectedConditions.visibilityOf(ObjTDClose.AccountClosedSummary_Label));
							
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							
							ObjTDClose.PrintVoucher(driver);
							ObjCloseComn.CloseSummaryPage();  
						}
						else if (TransMode=="TRANSFER_BATCH")
						
						{
							TransferTransMode="TRANSFER";
							System.out.println("Value of AccClosurePayableAmt from Open Batch part : " +AccClosurePayableAmt);
							ObjCloseComn.Account_Closing_as_BatchTransfer(TransferTransMode);
							WebDriverWait wait2 =new WebDriverWait(driver, 10);
							wait2.until(ExpectedConditions.visibilityOf(ObjTDClose.AccountClosedSummary_Label));
							
							driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							ObjTDClose.PrintVoucher(driver);
							ObjCloseComn.CloseSummaryPage();
							ObjTDClose.generate_contraEntry_for_openBatch(AccClosurePayableAmt, credit_branch, credit_pdtgrp, credit_pdtname, credit_accno, credit_transtype, credit_acc_operated_by, credit_acc_transmode);
							ObjCloseComn.CloseSummaryPage();
						}
					}
						
						
					else if (ClosureOrRenewal=="RENEWAL")
					{
						String Renewl_TransMode="TRANSFER";
						FDOpeningPage ObjFDOpen=new FDOpeningPage(driver);
						RenewalPageCommon ObjRenwComn=new RenewalPageCommon(driver);
						ObjRenwComn.ClickOnRenewalCheckBox();
						Thread.sleep(30); 
						ObjRenwComn.RenewalDuration_Field.sendKeys(Renewal_durn);
						ObjRenwComn.RenewalDuration_Field.sendKeys(Keys.TAB);
						//WebDriverWait waitfor_durn_mode=new WebDriverWait(driver,30);
						//waitfor_durn_mode.until(ExpectedConditions.elementToBeClickable(ObjRenwComn.RenewalDurationMode_Field));
						ObjCloseComn.dependableClick_for_StaleElement_handling(driver, ObjRenwComn.RenewalDurationMode_Field);
						ObjRenwComn.Select_RenewalDuration_mode(Renewal_durn_mode);
						
						ObjRenwComn.Renewal_NomineeDetails_Submit(NomineeCustName, NomineeCustID, NomineeRelation);
						if (Prod_Grp=="Fixed Deposit")
						{
							ObjRenwComn.Renewal_StandingDetails_Submit(Renewal_SI_Prdt, Renewal_SI_Accno, Renewal_SI_Freqency);
						}
						//Thread.sleep(30); 
						ObjCloseComn.select_transmode_info(Renewl_TransMode);
								
						ObjCloseComn.click_on_submit();
						ObjRenwComn.SeniorCitizen_PopUp_Handle();
						
						WebDriverWait wait3 =new WebDriverWait(driver, 10);
						wait3.until(ExpectedConditions.visibilityOf(ObjTDClose.AccountClosedSummary_Label));
						
						driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
						
						ObjFDOpen.PrintVoucherAndCertificate();
						////ObjFDOpen.PrintNomineeAcknowldgmnt();
						ObjCloseComn.CloseSummaryPage();		
					}
				}
		   }
		}
	
	}
}
			
		
		
						
						
				 