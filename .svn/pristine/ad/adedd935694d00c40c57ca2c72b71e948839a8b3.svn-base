package com.beaconpro.test.MDS;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.MDS.MDSApplication;
import com.beaconpro.module.uiobject.common.CustomerOrMemberAdding;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.PrintAndDuplicate;
import com.beaconpro.module.uiobject.common.TransactionModeSelection;
//import com.beaconpro.module.uiobject.common.TransactionPageCommon;
import com.beaconpro.module.uiobject.login.LoginPage;

public class MDSorGDSApplication {

	public WebDriver driver;
	
	public String[] MDS_Subscribers = new  String[] {"Sanoop","Sneha","Vikas","Sanoop","Maneesh"};
	
	String UserName				= "Sanoop";
	String Pword				= "san123";
	String MDSNo				= "1025";
	String RepyProductNameBranch= "MAIN BRANCH";
	String RepyProductName		= "ORDINARY SB";
	String RepyAccount 			= "29339";
	String TransactionMode		= "CASH";
	String PostDebitcrdt_ProGrp = "Savings Bank";
	String PostDebitCrdt_ProName= "ORDINARY SB";
	String PostDebitCrdt_AcNo	= "29339";
	String PostDbtcrdt_InstrType="Advice Slip";
	
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
	public void MDSAppication_loop_For_Adding_Subscriber () throws Exception
	
	{
		CustomerOrMemberAdding objcustmradd = new CustomerOrMemberAdding (driver);
		
		MDSApplication objMDSAppBase = new MDSApplication (driver);
		
		PrintAndDuplicate objprintDuplicate = new PrintAndDuplicate (driver);
		
		for (int i =0 ;i< MDS_Subscribers.length ; i++)
			
		{
			String Subscriber_Name = MDS_Subscribers [i];
			
			//Create an object for class MenuList from common package
			MenuList objMenuList = new MenuList (driver);
			
			System.out.println("test");
			objMenuList.Open_window(objMenuList.MDS_Application);
		
			//Add new Subscribers block

			MenuList objMnlist = new MenuList (driver);
			
			String parentWindow = driver.getWindowHandle();
			
			objMDSAppBase.Enter_MDS_No(MDSNo);
			objMDSAppBase.Click_GetBtn_MDSApp();
			Thread.sleep(5000);
			objMDSAppBase.Click_customer_Search_MDSApp();
			objMnlist.switchWindow(driver);
			objcustmradd.Addcustname(Subscriber_Name);
			objcustmradd.Clicksearch();
			objcustmradd.linkselection();
			driver.switchTo().window(parentWindow);
			objMDSAppBase.Click_Add_New_Subscriber_MDSApp();
		
			//Nominee not required
		
			objMDSAppBase.Click_NomineeNotRequired_CheckBox ();
			
			//Add Repayment account details
			
			/*objMDSAppBase.Click_RepaymentTab_MDSApplicatn();
			objMDSAppBase.Click_RepaymentCheckBox_MDSApplicatn();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			objMDSAppBase.Select_RepaymentproductBranch_MDSApplicatn(RepyProductNameBranch);
			objMDSAppBase.Select_Repaymentproduct_MDSApplicatn(RepyProductName);
			objMDSAppBase.Enter_RepaymentAc_MDSApplicatn(RepyAccount);
			objMDSAppBase.Repay_AccNo_MDSApplicatn.sendKeys(Keys.TAB);*/
			
			//save MDS installment amount into a variable
			
			String MDS_Install_Amount = objMDSAppBase.MDS_Installment_Amount.getAttribute("value");
		
			//Transaction Mode Selection block
			
			//CASH transaction block
			String transferMode = "CASH";
			
			if (TransactionMode.equals(transferMode))
				
			{
				Thread.sleep(5000);
				objMDSAppBase.Select_TransMode_MDSApplicatn(TransactionMode);
				objMDSAppBase.Click_Submit_MDSApplicatn();
				Thread.sleep(3000);
				//objprintDuplicate.print_and_duplicate();
				
			}
			else
			{
				
				String TransferMode = "TRANSFER" ; 
				
				MenuList objMnList = new MenuList (driver);
				
				//TransactionPageCommon objTrnpage = new TransactionPageCommon (driver);
				
				TransactionModeSelection objTrnmodCommn = new TransactionModeSelection (driver);
				
				String PostDebtPopUp = driver.getWindowHandle();
				
				if (TransactionMode.equals(TransferMode))
					
				{
					objMDSAppBase.Select_TransMode_MDSApplicatn(TransactionMode);
					
					objMDSAppBase.Click_MDS_Aplication_Postdebit ();
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
					
					objTrnmodCommn.Enter_PostDebitCrdit_Amount(MDS_Install_Amount);
					
					objTrnmodCommn.Click_PostDebitCrdit_ADD();
					
					Thread.sleep(1000);
					
					objTrnmodCommn.Click_PostDebitCrdit_Submit_Button();
	    			
					driver.switchTo().window(PostDebtPopUp);
					
					objMDSAppBase.Click_Submit_MDSApplicatn();
					
					Thread.sleep(3000);
					
					objprintDuplicate.print_and_duplicate();
				}
				
				else
					
				{
					objMDSAppBase.Select_TransMode_MDSApplicatn(TransferMode);
					objMDSAppBase.Click_Submit_MDSApplicatn();
					objTrnmodCommn.Click_UnclosedBatch_PoUp_Ok_Btn ();
	
					Thread.sleep(3000);
					objprintDuplicate.print_and_duplicate();
				}
				
			}
			
		}
			
	}	
	
}
