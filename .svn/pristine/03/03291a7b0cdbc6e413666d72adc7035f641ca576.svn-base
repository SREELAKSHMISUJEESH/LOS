package com.beaconpro.test.acclosure;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 26/04/2016
Purpose	        : FD Closing as Cash Mode
Note			: Kyc not completed customer, Premature closing,Default A/c Pop up messages handled
Conditions      : A/c Should not be a Leined A/c
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.acopening.FDOpeningPage;
//import com.beaconpro.module.uiobject.closing.TermDepositsClosurePage;
import com.beaconpro.module.uiobject.acclosure.TermDepositClosureAndRenewalPage;
import com.beaconpro.module.uiobject.common.ClosurePageCommon;
import com.beaconpro.module.uiobject.login.LoginPage;

public class FDClosingWithCash
{

	public static WebDriver driver;
	
	String User           = "shilpa";
	String Pass           = "test123";
	String Authorizn_User = "shilpaau";
	String Authorizn_Pass = "test123";
	
	/*String Brch_Name      = "MAIN BRANCH";
	String Prod_Grp       = "Pigmy Deposit";
	String Prd_nam        = "ORDINARY DD";
	String ac_no          = "36217";
	String transmod       = "CASH";
	*/
	
	String Brch_Name      = "MAIN BRANCH";
	String Prod_Grp       = "Fixed Deposit";
	String Prd_nam        = "ORDINARY FD";
	String ac_no          = "182511";
	String transmod       = "CASH";
	
	/*String Brch_Name      = "MAIN BRANCH";
	String Prod_Grp       = "Re-Investments- CC";
	String Prd_nam        = "ORDINARY RID";
	String ac_no          = "18214";
	String transmod       = "CASH";
	
	String Brch_Name      = "MAIN BRANCH";
	String Prod_Grp       = "Recurring Deposit";
	String Prd_nam        = "ORDINARY RD";
	String ac_no          = "3526";
	String transmod       = "CASH";
	
	
*/		
	
	// Mature a/c no= 145910  ; prem a/c no : 129041
	
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
		ObjClosePage.open_termdeposit_closure_window();
		ObjClosePage.sendClosingAccDetails(Brch_Name, Prod_Grp, Prd_nam, ac_no);
		ObjClosePage.GoButton.click();
		Thread.sleep(1000);
			
	}
	
	
	@Test(priority=2)
	
	public void Summary_And_Print() throws InterruptedException
	{   
		ClosurePageCommon ObjCommonClosePage=new ClosurePageCommon(driver);
		TermDepositClosureAndRenewalPage ObjTDClose=new TermDepositClosureAndRenewalPage(driver);
		
		//ObjTDClose.PrematureClosing_Alert_handle();
		//ObjTDClose.PigmyAcc_Defaulted_PopUp_Message_click();
		//ObjTDClose.KYC_Not_Completed_Warning_Msg_PopUp_Click();
		
		
		ObjTDClose.PrematureClosing_Alert_handle();
		Thread.sleep(1000);
		ObjCommonClosePage.KYC_Not_Completed_Warning_Msg_PopUp_Click();
		Thread.sleep(100);
		ObjTDClose.PigmyAcc_Defaulted_PopUp_Message_click();
		
		Thread.sleep(30);
		
		
		
		
		
		
		
		
				
		ObjCommonClosePage.select_transmode_info(transmod);
		ObjCommonClosePage.click_on_submit();
			
		WebDriverWait wait2 =new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOf(ObjTDClose.AccountClosedSummary_Label));
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		ObjTDClose.PrintVoucher(driver);
		
	}
	
	 /*  @Test(priority=3)
	public void ClosingAuthorisation()
	{
		FDOpeningPage ObjFDOpen=new FDOpeningPage(driver);
		try
		{
			ObjFDOpen.LoginForAuthorisation(Authorizn_User, Authorizn_Pass);
		}
		catch (Throwable e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjFDOpen.CashTransactionAuthorisation(driver);
		
		
		
	} **/
	
	
	
}
