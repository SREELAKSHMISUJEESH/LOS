package com.beaconpro.test.acclosure;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.acclosure.TermDepositClosureAndRenewalPage;
import com.beaconpro.module.uiobject.common.ClosurePageCommon;
import com.beaconpro.module.uiobject.common.TransactionPageCommon;
import com.beaconpro.module.uiobject.login.LoginPage;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 26/04/2016
Purpose	        : FD Closing as Transfer Mode : Open Batch 
ote             : Batch Contra Transaction handling also included        
Conditions      : A/c Should not be a Leined A/c
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

public class FDClosingWithTransModeAsOpenBatch 
{

     

	public static WebDriver driver;
	
	String User           = "shilpa";
	String Pass           = "test123";
	String Authorizn_User = "shilpaau";
	String Authorizn_Pass = "test123";
	
	
	
	String Brch_Name      = "MAIN BRANCH";
	String Prod_Grp       = "Pigmy Deposit";
	String Prd_nam        = "ORDINARY DD";
	String ac_no          = "36138";
	
	
	
	/*
	String Brch_Name      = "MAIN BRANCH";
	String Prod_Grp       = "Fixed Deposit";
	String Prd_nam        = "ORDINARY FD";
	String ac_no          = "137801";
	
	
	String Brch_Name      = "MAIN BRANCH";
	String Prod_Grp       = "Re-Investments- CC";
	String Prd_nam        = "ORDINARY RID";
	String ac_no          = "18214";
	
	
	
	String Brch_Name      = "MAIN BRANCH";
	String Prod_Grp       = "Recurring Deposit";
	String Prd_nam        = "ORDINARY RD";
	String ac_no          = "3526";
	*/
	
	
	
	
	
	
	//182513 mat a/c
	String TrnsMode       = "TRANSFER";
	
	//sb a/c no 26100
	
	//Give OpenBatch_ContraEntry Transaction details below
	static String credit_branch          ="MAIN BRANCH";
	static String credit_pdtgrp          = "Savings Bank";
	static String credit_pdtname         = "ORDINARY SB";
	static String credit_accno           = "26100";
	static String credit_transtype       = "Credit";
	static String credit_acc_transmode   = "TRANSFER";
	static String credit_acc_operated_by = "Tester FromSES";
	
	
	
	public static String  AccClosureAmount;
	public static String  AccClosurePayableAmt;
	
	 
	
	
	@Test(priority = 0)
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
	public void FDClosingAccountDetails() throws InterruptedException
	{
		ClosurePageCommon ObjClosePage=new ClosurePageCommon(driver);
		ClosurePageCommon ObjCommonClosePage=new ClosurePageCommon(driver);
		TermDepositClosureAndRenewalPage ObjTDClose=new TermDepositClosureAndRenewalPage(driver);
		ObjClosePage.open_termdeposit_closure_window();
		ObjClosePage.sendClosingAccDetails(Brch_Name, Prod_Grp, Prd_nam, ac_no);
		ObjClosePage.GoButton.click();
		Thread.sleep(1000);
		ObjTDClose.PrematureClosing_Alert_handle();
		Thread.sleep(1000);
		ObjCommonClosePage.KYC_Not_Completed_Warning_Msg_PopUp_Click();
		Thread.sleep(100);
		ObjTDClose.PigmyAcc_Defaulted_PopUp_Message_click();
		
		Thread.sleep(30);
		//AccClosurePayableAmt=ObjTDClose.Acc_Closure_Total_PayableAmount.getAttribute("value");
		//System.out.println("Value of AccClosurePayableAmt: "+ ObjTDClose.getAccClosurePayableAmt());
		
		
		AccClosurePayableAmt = ObjTDClose.Set_AccClosurePayableAmt();
		//String AccClosurePayableAmt=ObjTDClose.Acc_Closure_Total_PayableAmount.getAttribute("value");
		
		//TermDepositClosurePage ObjTDClose=new TermDepositClosurePage(driver);
		//String PayableAmount=ObjTDClose.FD_Total_PayableAmount.getText();
			
	}

	
	@Test(priority=2)
	
	public void ClosingAsOpenBatch() throws InterruptedException
	{   
		ClosurePageCommon ObjCommonClosePage=new ClosurePageCommon(driver);
		TermDepositClosureAndRenewalPage ObjTDClose=new TermDepositClosureAndRenewalPage(driver);
		ObjCommonClosePage.Account_Closing_as_BatchTransfer(TrnsMode);
		WebDriverWait wait2 =new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOf(ObjTDClose.AccountClosedSummary_Label));
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		ObjTDClose.PrintVoucher(driver);
	}
	

	@Test(priority=3)
	public static void generate_contraEntry_for_openBatch() throws InterruptedException
	{
		MenuList ObjMnuList =new MenuList(driver);
		TransactionPageCommon objTransPage=new TransactionPageCommon(driver);
		TermDepositClosureAndRenewalPage ObjTDClose=new TermDepositClosureAndRenewalPage(driver);
		
		//AccClosureAmount=AccClosurePayableAmt;
		System.out.println("Value of AccClosureAmount from contra entry method: "+ AccClosurePayableAmt);
		
		
		JavascriptExecutor executortranspage = (JavascriptExecutor) driver;
		executortranspage.executeScript("arguments[0].click();",driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[3]/ul/li[1]/a")));
		
				
		int length=AccClosurePayableAmt.length()-6; // Method to convert Payable amount eg "2500.00 CR" to "2500"
		int num=0;
		int i=0;
		 while( i < length) {
		        num *= 10;
		        num += AccClosurePayableAmt.charAt(i++) - '0'; //Minus the ASCII code of '0' to get the value of the charAt(i++).
		    }
		
		
		Integer I=num;
		System.out.println("Value of closure amount from contra entry method: "+ I);
		
		String string_closureamount = Integer.toString(I);
		System.out.println("Value of StringClosureamount: "+ string_closureamount);
				
		
		objTransPage.select_branch_name(credit_branch);
		objTransPage.select_product_group(credit_pdtgrp);
		objTransPage.select_product_name(credit_pdtname);
		objTransPage.enter_account_number(credit_accno);
		objTransPage.select_trans_type(credit_transtype);
		objTransPage.click_go_button();
		objTransPage.wait_after_click_go_button();
	    objTransPage.enter_transaction_amount(string_closureamount);
		objTransPage.enter_operated_by(credit_acc_operated_by);
		objTransPage.select_trans_mode(credit_acc_transmode);
		
		String parentHandle = driver.getWindowHandle();
		objTransPage.Click_batch_search_link();
		ObjMnuList.switchWindow(driver);
		objTransPage.Select_batch_from_batchSearch_window();
		driver.switchTo().window(parentHandle);
		
		//objTransPage.enter_remark(debit_trans_remark);
		objTransPage.click_on_submit();
		objTransPage.click_on_print_and_close_preview();
		
		
	}
	
	
	
	
}
	
	

