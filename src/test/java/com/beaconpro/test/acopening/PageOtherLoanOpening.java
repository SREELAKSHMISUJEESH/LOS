package com.beaconpro.test.acopening;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.acopening.ObjOtherLoanOpening;
import com.beaconpro.module.uiobject.common.ObjLoanAccountInfoTab;
import com.beaconpro.module.uiobject.common.TransactionModeSelection;
import com.beaconpro.module.uiobject.login.LoginPage;
import com.beaconpro.module.uiobject.common.CustomerOrMemberAdding;
import com.beaconpro.module.uiobject.common.NomineeAdding;

public class PageOtherLoanOpening 
{


public static WebDriver driver;

	String UserName				= "sesame";		 //Enter Login User Name
	String Pword				= "ses@123";	 	 //Enter User Password
	String CustName				= "SINI";	 //ENter Customer Name
	String pur ="Consumption";
	/*String RDOPeningAMount	    = "1000";		 //Enter Account Opening Amount
	String RD_Duration			= "12";			 //Enter RD Duration
	String OperatorName			= "SANDHYA";	 //Enter Operator Name
	String Operator_Relation	= "MOTHER";		 //Enter Operator Relation
	String Repayment_Product	= "ORDINARY SB"; //Enter Account Repayment Product
	String RepaymentAccount		= "29315";		 //Enter Repayment Account
	String RepaymentFrequency	= "1";			 //Enter Repayment frequency
	String FrequnceyDurationMode= "MONTHS";		 //Enter repayment frequency duration mode
	String TrnsferMode			= "CASH";	 	 //Enter Transaction Mode CASH/TRANSFER
	String PostDebitPrdctGrp    = "Savings Bank";//Enter Post Debit Product Group  
	String PostDebitPrdctNme	= "ORDINARY SB"; //Enter Post Debit Prduct Name
	String PostDebitAcNo		= "29329";		 //Enter Post Debit Account Number
	String PostDbtInstrType		= "Advice Slip"; //Enter Post Debit Instrument type
	String PostDebitAmount		= RDOPeningAMount;//Enter Post Debit RD opening amount
	String AuthUsrName			= "MANEESH";	 //Enter Account Opening Authorization User Name
	String AuthPword 			= "san123";	  	 //Enter Account Authorization PassWord
*/	
	
	@BeforeClass
	public  void Open_URL_AND_Login_BEACONPRO() throws Throwable
		{
			try 
				{
					ProfilesIni profile = new ProfilesIni();
					FirefoxProfile ffprofile = profile.getProfile("default");
					driver = new FirefoxDriver(ffprofile);	
					
					LoginPage	objLogin = new LoginPage (driver);
					objLogin.openUrlFor102();
					objLogin.loginToBeaconProValid(UserName,Pword);
				} 
			catch (Exception e) 
				{
					e.printStackTrace();
				}
		}
	
	@Test (priority = 0)
	public void OtherLoan_Account_Opening_Window () 
		{
			
			try 
				{
					ObjOtherLoanOpening objOLOpengBase = new ObjOtherLoanOpening (driver);
					CustomerOrMemberAdding ObjCustAdd  = new CustomerOrMemberAdding(driver);
	
					objOLOpengBase.Open_OL_OpeningWindow();
					objOLOpengBase.OL_Open_LOS_Popup();	
					ObjCustAdd.Add_Customer_OR_Member(CustName);
				} 
			catch (Exception e) 
				{
					e.printStackTrace();
				}
				
		}
	
	@Test(priority=1)
	public void OtherLoanOpening() throws InterruptedException
	{
		ObjOtherLoanOpening objOLOpengBase = new ObjOtherLoanOpening (driver);
		TransactionModeSelection ObjTrnMode = new TransactionModeSelection(driver);
		
		objOLOpengBase.Fill_Loan_AcInfo();
		objOLOpengBase.OL_Sec_Tab();
		objOLOpengBase.OL_Nom_Tab();
		objOLOpengBase.OL_LoanDetails_Tab();
		
		Thread.sleep(5000);
		
		//ObjTrnMode.Account_Opening_Cash("Cash");
		

		ObjTrnMode.Account_Opening_Transfer_Autoposting("transfer","savings","Ordin","25847","advice","12000");
		
	}
}
