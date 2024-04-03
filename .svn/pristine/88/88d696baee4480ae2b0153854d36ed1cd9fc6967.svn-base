package com.beaconpro.test.transaction;

import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.WaitFor.Unit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.PrintAndDuplicate;
import com.beaconpro.module.uiobject.common.TransactionModeSelection;
import com.beaconpro.module.uiobject.common.TransactionPageCommon;
import com.beaconpro.module.uiobject.login.LoginPage;

public class Transactions {

	
	String UserName				= "Sanoop";
	String Pword 				= "san123";
	String Branch				= "MAIN BRANCH";
	String InstallmentNo		= "1";
	String TransAmount			= "100";
	String OperatedBy			= "SANOOP";
	String TransactionMode 		= "CASH";
	String AuthUsrName			= "MANEESH";
	String AuthPword			= "san123";
	String PostDebitcrdt_ProGrp = "Savings Bank";
	String PostDebitCrdt_ProName= "ORDINARY SB";
	String PostDebitCrdt_AcNo	= "29328";
	String PostDbtcrdt_InstrType= "Advice Slip";
	
	private static String[] ProductGroups = new String[] 
			
			{"Savings Bank"};/*,"Current Account","Recurring Deposit","Pigmy Deposit","Jewel Loan",
			"Deposit Loan","Other Loan","Over Draft/KCC Loan"};*/
	
	private String[] ProductGroupDebitTransaction = new String[] {"Savings Bank","Current Account","Over Draft/KCC Loan"};
	
	private String[] ProductNames = new String[] {};
		
	private static String[] SBAccountNumber = new String[]{"29339"};
	
	private static String[] CAAccountNumber = new String[]{"1760"};
	
	private static String[] RDAccountNumber = new String[]{"5185"};
	
	private static String[] DDAccountNumber = new String[]{"36265"};
	
	private static String[] JewelLoanAccountNumber = new String[]{"17076"};
	
	private static String[] DepositLoanAccountNumber = new String[]{"10829"};
	
	private static String[] OtherLoanAccountNumber = new String[]{"23307"};
	
	private static String[] MortgageLoanAccountNumber = new String[]{"2540"};
	
	public WebDriver driver ;
	
	public String Trans_Amount_Value ;

	@BeforeClass
	public  void Open_URL_AND_Login_BEACONPRO() throws Throwable
	
	{
		try {
			
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile("default");
			driver = new FirefoxDriver(ffprofile);	
			
			LoginPage	objLogin = new LoginPage (driver);
			objLogin.openUrlFor102();
			objLogin.loginToBeaconProValid(UserName,Pword);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	@Test (priority = 0)
	public void CreditTransactions () throws Exception
	
	{
		TransactionPageCommon objTrnpage = new TransactionPageCommon (driver);
		
		TransactionModeSelection objTrnmodCommn = new TransactionModeSelection (driver);
		
		
		for(int i=0; i< ProductGroups.length; i++)
			
		{
		  
			
			MenuList objMnList = new MenuList (driver);
			
			TransactionPageCommon objTrn = new TransactionPageCommon (driver);
			
			PrintAndDuplicate objprintDuplicate = new PrintAndDuplicate (driver);
			
			objMnList.Open_window (objMnList.Transaction_Link);
			
			WebDriverWait wait0 = new WebDriverWait(driver,10);
			wait0.until(ExpectedConditions.elementToBeClickable(objTrn.BranchNameField));
			
			
			String prductgrpName = ProductGroups [i];
			
			objTrnpage.select_product_group(prductgrpName);
			
			Thread.sleep(1000);
			
			if (ProductGroups [i]== "Savings Bank")
				
			{
				 ProductNames = new String[]{"ORDINARY SB"};
				 
			}
			
			else if (ProductGroups [i] == "Current Account")
				
			{
				ProductNames = new String [] {"ORDINARY CA"} ; 
				
			}
			
			else if (ProductGroups [i]== "Recurring Deposit")
				
			{
				 ProductNames = new String[]{"ORDINARY RD"};
				 
			}
			
			else if (ProductGroups [i] == "Pigmy Deposit")
			
			{
				ProductNames = new String []  {"ORDINARY DD"};
				
			}
			
			else if (ProductGroups [i] == "Jewel Loan")
				
			{
				ProductNames = new String [] {"12 Month GL"};
				
			}
			
			else if (ProductGroups [i] == "Deposit Loan")
			
			{
				ProductNames = new String [] {"DEPOSIT LOAN"};
			}
			
			else if (ProductGroups [i] == "Other Loan")
				
			{
				
				ProductNames = new String [] {"MORTGAGE OL"};
			}
			
			else if (ProductGroups [i] == "Over Draft/KCC Loan")
			
			{
				
				ProductNames = new String [] {"MORTGAGE OD"};
			}
			
			for (int j=0; j< ProductNames.length ; j++)
				
			{
				 
				String PrdctName = ProductNames [j];
				
				objTrnpage.select_product_name(PrdctName);

				Thread.sleep(1000);
					
				if (PrdctName == "ORDINARY SB")	
					
				{
					String AcNo = SBAccountNumber [j];
					
					objTrnpage.enter_account_number(AcNo);
					
				}
				
				else if (PrdctName == "ORDINARY CA")
					
				{
					
					String AcNo = CAAccountNumber [j];
					
					objTrnpage.enter_account_number(AcNo);
				
				}
				
				else if (PrdctName == "ORDINARY RD")
				
				{
					
					
					String AcNo = RDAccountNumber [j];
					
					objTrnpage.enter_account_number(AcNo);
					
				}
				
				else if (PrdctName == "ORDINARY DD")
					
				{
					String AcNo = DDAccountNumber [j];
					
					objTrnpage.enter_account_number(AcNo);
					
				}
					
				else if (PrdctName == "12 Month GL")
					
				{
					String AcNo = JewelLoanAccountNumber [j];
					
					objTrnpage.enter_account_number(AcNo);
					
				}
				
				else if (PrdctName == "DEPOSIT LOAN" )
					
				{
					String AcNo = DepositLoanAccountNumber [j];
					
					objTrnpage.enter_account_number(AcNo);
					
				}
				
				else if (PrdctName == "MORTGAGE OL")
					
				{
					String AcNo = OtherLoanAccountNumber [j];
					
					objTrnpage.enter_account_number(AcNo);
					
				}
				
				else if (PrdctName == "MORTGAGE OD")
					
				{
					String AcNo = MortgageLoanAccountNumber [j];
					
					objTrnpage.enter_account_number(AcNo);
					
				}
				
				objTrnpage.select_trans_type ("Credit");
			
				objTrnpage.click_go_button();
				
			
				objTrnpage.wait_after_click_go_button();
		
			
				if (driver.findElements(
					By.xpath(".//*[@id='closewarning']")).size() > 0) {
				
				objTrnpage.KYC_Not_Completed_PopUp();
				
				}
			
				
				objTrnpage.Click_Prevoius_Trnsctn_CheckBox.click();
			
			
				try {
				
					if (driver.findElements(By.id("ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtRemittingInstallment_txt")).size() > 0 ) {
					
					objTrnpage.Enter_Installment_Number(InstallmentNo);
					
					objTrnpage.Installment_No.sendKeys(Keys.TAB);
					}
				
					else 
					
					{
						objTrnpage.enter_transaction_amount(TransAmount);
					
						Trans_Amount_Value =objTrnpage.TransactionAmountField.getAttribute("value");
					}
				
				
				} catch (Exception e) 
			
				{
				
					e.printStackTrace();
				}
				
			/*	//instrument type selection For Debit Transaction
				if (driver.findElements(By.id("ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_ddlInstrType_ddl")).size() > 0) 
					
				{		
					objTrnpage.SelectDebitTransInstrumentType ();
				
				}*/
			
				String TrnMode = "CASH";
			
				if (TransactionMode .equals(TrnMode))
				
				{
					for(int l=0; l<10000;l++) 
					 
					 try
					{
						 objTrnpage.select_trans_mode(TransactionMode);
						 break; 
						 	 
					}
					
					catch(StaleElementReferenceException e) 
				
					{
						e.toString();
						System.out.println("Trying to recover from a stale element :" + e.getMessage());
					 
					}
				
				
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
					for(int l=0; l<10000;l++) 
					 
						try
					{	
							objTrnpage.enter_operated_by(OperatedBy);
							break; 
						 	 
					}
				
					catch(StaleElementReferenceException e) 
				
					{
						e.toString();
						System.out.println("Trying to recover from a stale element :" + e.getMessage());
					 
					}
					objTrnpage.click_on_submit();
					Thread.sleep(3000);
					objprintDuplicate.print_and_duplicate();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				}
			
				else 
				
				{	
					String TransferMode = "TRANSFER";
				
					if (TransactionMode.equals(TransferMode))
					
					{
						String PostDebtPopUp = driver.getWindowHandle();
					
						for(int l=0; l<10000;l++) 
						 
							try
						{
								objTrnpage.select_trans_mode(TransactionMode);
								break; 
							 	 
						}
					
						catch(StaleElementReferenceException e) 
					
						{
							e.toString();
							System.out.println("Trying to recover from a stale element :" + e.getMessage());
							
						}
					
					
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
						objTrnpage.Click_PostDbt_Btn();
						objMnList.switchWindow(driver);
				
						objTrnmodCommn.Select_PostDebitOrCredit_Product_Group(PostDebitcrdt_ProGrp);
						/*WebDriverWait wait10 = new WebDriverWait(driver, 10);
		    			wait10.until(ExpectedConditions.elementToBeClickable(objTrnmodCommn.Select_PostDebitOrCredit_Product_Name));*/
						for(int l=0; l<10000;l++) 
						 
							try
						{
								objTrnmodCommn.Select_PostDebitOrCredit_Product_Name (PostDebitCrdt_ProName);
								break; 
							 	 
						}
					
						catch(StaleElementReferenceException e) 
					
						{
							e.toString();
							System.out.println("Trying to recover from a stale element :" + e.getMessage());
						 
						}
						//objTrnmodCommn.Select_PostDebitOrCredit_Product_Name (PostDebitCrdt_ProName);
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						objTrnmodCommn.Enter_PostDebitCredit_AcNo(PostDebitCrdt_AcNo);
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						objTrnmodCommn.Select_PostDebitCrdt_Instrtype (PostDbtcrdt_InstrType);
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    		
						Thread.sleep(1000);
						
						objTrnmodCommn.Click_PostDebitCrdit_ADD();
						
						objTrnmodCommn.Enter_PostDebitCrdit_Amount(Trans_Amount_Value);
						
						objTrnmodCommn.Click_PostDebitCrdit_ADD();
						
						Thread.sleep(1000);
						
						objTrnmodCommn.Click_PostDebitCrdit_Submit_Button();
		    			
						driver.switchTo().window(PostDebtPopUp);
		    		
						objprintDuplicate.print_and_duplicate();
						
						for(int l=0; l<100000;l++) 
						 
							try
						{
								objTrnpage.enter_operated_by(OperatedBy);
								break; 
							 	 
						}
					
						catch(StaleElementReferenceException e) 
					
						{
						e.toString();
						 System.out.println("Trying to recover from a stale element :" + e.getMessage());
						 
					}
		    		
						objTrnpage.click_on_submit();
						
					}
				
					else
					
					{
					
						objTrnpage.select_trans_mode(TransferMode);
					
						for(int l=0; l<1000;l++) 
						 
							try
						{
								objTrnpage.enter_operated_by(OperatedBy);
								break; 
							 	 
						}
					
						catch(StaleElementReferenceException e) 
					
						{
							e.toString();
							System.out.println("Trying to recover from a stale element :" + e.getMessage());
						 
						}
						objTrnpage.click_on_submit();
						objTrnmodCommn.Click_UnclosedBatch_PoUp_Ok_Btn ();
						
						objprintDuplicate.print_and_duplicate();
					
					}
							
							
						
					}
					
				}
		
		
			}
	
		}
	
	@Test (priority = 1)
	public void DebitTransactions () throws Exception
	
	{
		TransactionPageCommon objTrnpage = new TransactionPageCommon (driver);
		
		TransactionModeSelection objTrnmodCommn = new TransactionModeSelection (driver);
		
		PrintAndDuplicate objprintDuplicate = new PrintAndDuplicate (driver);
		
		for(int i=0; i< ProductGroupDebitTransaction.length; i++)
			
		{
		  
			
			MenuList objMnList = new MenuList (driver);
			
			TransactionPageCommon objTrn = new TransactionPageCommon (driver);
			
			objMnList.Open_window (objMnList.Transaction_Link);
					
			WebDriverWait wait0 = new WebDriverWait(driver,10);
			wait0.until(ExpectedConditions.elementToBeClickable(objTrn.BranchNameField));
			
			
			String prductgrpNameDebit = ProductGroupDebitTransaction [i];
			
			objTrnpage.select_product_group(prductgrpNameDebit);
			
			Thread.sleep(1000);
			
			if (ProductGroupDebitTransaction [i]== "Savings Bank")
				
			{
				 ProductNames = new String[]{"ORDINARY SB"};
				 
			}
			
			else if (ProductGroupDebitTransaction [i] == "Current Account")
				
			{
				ProductNames = new String [] {"ORDINARY CA"} ; 
				
			}
			
			else if (ProductGroupDebitTransaction [i]== "Over Draft/KCC Loan")
				
			{
				 ProductNames = new String[]{"MORTGAGE OD"};
				 
			}
			
			for (int j=0; j< ProductNames.length ; j++)
			
			{
				 
				String PrdctName = ProductNames [j];
				
				objTrnpage.select_product_name(PrdctName);

				Thread.sleep(1000);
					
				if (PrdctName == "ORDINARY SB")	
					
				{
					String AcNo = SBAccountNumber [j];
					
					objTrnpage.enter_account_number(AcNo);
					
				}
				
				else if (PrdctName == "ORDINARY CA")
					
				{
					
					String AcNo = CAAccountNumber [j];
					
					objTrnpage.enter_account_number(AcNo);
				
				}
				
				else if (PrdctName == "MORTGAGE OD")
				
				{
					
					
					String AcNo = MortgageLoanAccountNumber [j];
					
					objTrnpage.enter_account_number(AcNo);
					
				}
				
				objTrnpage.select_trans_type ("Debit");
				
				objTrnpage.click_go_button();
				
			
				objTrnpage.wait_after_click_go_button();
		
			
				if (driver.findElements(
					By.xpath(".//*[@id='closewarning']")).size() > 0) {
				
				objTrnpage.KYC_Not_Completed_PopUp();
				
				}
			
				
				objTrnpage.Click_Prevoius_Trnsctn_CheckBox.click();
				
				objTrnpage.enter_transaction_amount(TransAmount);
				
				Trans_Amount_Value =objTrnpage.TransactionAmountField.getAttribute("value");
				
				//instrument type selection For Debit Transaction
				if (driver.findElements(By.id("ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_ddlInstrType_ddl")).size() > 0) 
					
				{		
					objTrnpage.SelectDebitTransInstrumentType ();
				
				}
				
				String TrnMode = "CASH";
				
				if (TransactionMode .equals(TrnMode))
				
				{
					for(int l=0; l<10000;l++) 
					 
					 try
					{
						 objTrnpage.select_trans_mode(TransactionMode);
						 break; 
						 	 
					}
					
					catch(StaleElementReferenceException e) 
				
					{
						e.toString();
						System.out.println("Trying to recover from a stale element :" + e.getMessage());
					 
					}
				
				
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
					for(int l=0; l<10000;l++) 
					 
						try
					{	
							objTrnpage.enter_operated_by(OperatedBy);
							break; 
						 	 
					}
				
					catch(StaleElementReferenceException e) 
				
					{
						e.toString();
						System.out.println("Trying to recover from a stale element :" + e.getMessage());
					 
					}
					objTrnpage.click_on_submit();
				
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
					objprintDuplicate.print_and_duplicate();
					
				}
			
				else 
				
				{	
					String TransferMode = "TRANSFER";
				
					if (TransactionMode.equals(TransferMode))
					
					{
						String PostDebtPopUp = driver.getWindowHandle();
					
						for(int l=0; l<10000;l++) 
						 
							try
						{
								objTrnpage.select_trans_mode(TransactionMode);
								break; 
							 	 
						}
					
						catch(StaleElementReferenceException e) 
					
						{
							e.toString();
							System.out.println("Trying to recover from a stale element :" + e.getMessage());
							
						}
					
					
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
						objTrnpage.Click_PostDbt_Btn();
						objMnList.switchWindow(driver);
				
						objTrnmodCommn.Select_PostDebitOrCredit_Product_Group(PostDebitcrdt_ProGrp);
						/*WebDriverWait wait10 = new WebDriverWait(driver, 10);
		    			wait10.until(ExpectedConditions.elementToBeClickable(objTrnmodCommn.Select_PostDebitOrCredit_Product_Name));*/
						for(int l=0; l<10000;l++) 
						 
							try
						{
								objTrnmodCommn.Select_PostDebitOrCredit_Product_Name (PostDebitCrdt_ProName);
								break; 
							 	 
						}
					
						catch(StaleElementReferenceException e) 
					
						{
							e.toString();
							System.out.println("Trying to recover from a stale element :" + e.getMessage());
						 
						}
						//objTrnmodCommn.Select_PostDebitOrCredit_Product_Name (PostDebitCrdt_ProName);
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						objTrnmodCommn.Enter_PostDebitCredit_AcNo(PostDebitCrdt_AcNo);
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    		
						
						objTrnmodCommn.Click_PostDebitCrdit_ADD();
						
						for(int l=0; l<100;l++) 
							 
							try
						{
								objTrnmodCommn.Enter_PostDebitCrdit_Amount(Trans_Amount_Value);
								break; 
							 	 
						}
					
						catch(StaleElementReferenceException e) 
					
						{
							e.toString();
							System.out.println("Trying to recover from a stale element :" + e.getMessage());
							
						}
						
						objTrnmodCommn.Click_PostDebitCrdit_ADD();
						
						Thread.sleep(1000);
		    		
						objTrnmodCommn.Click_PostDebitCrdit_Submit_Button();
		    			
						driver.switchTo().window(PostDebtPopUp);
		    		
						for(int l=0; l<10000;l++) 
						 
							try
						{
								objTrnpage.enter_operated_by(OperatedBy);
								break; 
							 	 
						}
					
						catch(StaleElementReferenceException e) 
					
						{
						e.toString();
						 System.out.println("Trying to recover from a stale element :" + e.getMessage());
						 
					}
		    		
						objTrnpage.click_on_submit();
						
						objprintDuplicate.print_and_duplicate();
						
					}
				
					else
					
					{
					
						objTrnpage.select_trans_mode(TransferMode);
					
						for(int l=0; l<1000;l++) 
						 
							try
						{
								objTrnpage.enter_operated_by(OperatedBy);
								break; 
							 	 
						}
					
						catch(StaleElementReferenceException e) 
					
						{
							e.toString();
							System.out.println("Trying to recover from a stale element :" + e.getMessage());
						 
						}
						objTrnpage.click_on_submit();
						objTrnmodCommn.Click_UnclosedBatch_PoUp_Ok_Btn ();
						
						objprintDuplicate.print_and_duplicate();
					}
			
			
				}
			}
			
		}
		
	}
}
