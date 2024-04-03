package com.beaconpro.test.MDS;

import java.util.concurrent.TimeUnit;

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

import com.beaconpro.module.uiobject.MDS.MDSCollection;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.PrintAndDuplicate;
import com.beaconpro.module.uiobject.common.TransactionModeSelection;
import com.beaconpro.module.uiobject.login.LoginPage;

public class MDSorGDSCollection {

	public WebDriver driver;
	
	String UserName  			= "sanoop"; //Enter User Name
	String Pword				= "san123"; //Enter Pword
	String MDSNO				= "1024"; 	//Enter MDS Number
	String TrnmodeMDSColelction = "CASH";//Enter Transaction mode CASH/TRANSFER/BATCH
	String InstallmentNo		= "1";		//Enter Installment number
	String PostDebitcrdt_ProGrp = "Savings Bank"; //Enter PostDebit Group
	String PostDebitCrdt_ProName= "ORDINARY SB"; //Enter PostCredt Prdcut Name
	String PostDebitCrdt_AcNo	= "29339";		 //Post Debit Ac Number
	String PostDbtcrdt_InstrType= "Advice Slip"; //Enter Instrument type
	
	String[] SubscriberNumber = new  String [] {"2","3"};
	
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
	public void MDS_Collection () throws Exception 
	
	{
	
		for (int i = 0 ; i< SubscriberNumber.length; i++) 
		
		{
			String SubNo = SubscriberNumber [i];
			MDSCollection objMDSCollection = new MDSCollection (driver);
			PrintAndDuplicate objprintDuplicate = new PrintAndDuplicate (driver);
			
			MenuList objMenuList = new MenuList (driver);
			TransactionModeSelection objTrnmodCommn = new TransactionModeSelection (driver);
			
			objMenuList.Open_window(objMenuList.MDS_Collection_Link);
			
			objMDSCollection.MDS_No_MDSCollection(MDSNO);
			objMDSCollection.Get_Btn_MDSCollection();
			objMDSCollection.Previous_biddetails_MDSCollection();
			objMDSCollection.SubscriberNo_MDSCollection(SubNo);
			objMDSCollection.MDS_Collection_GoBtn();
			WebDriverWait wait1 = new WebDriverWait (driver ,60);
			wait1.until(ExpectedConditions.elementToBeClickable(objMDSCollection.MDS_Collection_SubmitBtn));
			objMDSCollection.Previous_Colelction_details();
			objMDSCollection.Enter_MDS_Installemnt_No_Collection.sendKeys(Keys.chord(Keys.CONTROL,"a"),InstallmentNo);
			//objMDSCollection.MDS_Installemnt_No_Collection(InstallmentNo);
			
			String MDS_collection_Amount = objMDSCollection.MDS_Collecton_Amount.getAttribute("value");
			
			if (TrnmodeMDSColelction == "CASH")
				
			{
				objMDSCollection.Transmode_MDS_Collection (TrnmodeMDSColelction);
				WebDriverWait wait3 = new WebDriverWait (driver ,20);
				wait3.until(ExpectedConditions.elementToBeClickable(objMDSCollection.MDS_Collection_SubmitBtn));
				objMDSCollection.MDS_Collection_SubmitBtn ();
				Thread.sleep(10000);
				objprintDuplicate.print_and_duplicate();
			}
			else if (TrnmodeMDSColelction == "TRANSFER")
			
			{
				
				String PostDebtPopUp = driver.getWindowHandle();
				
				objMDSCollection.Transmode_MDS_Collection (TrnmodeMDSColelction);
				WebDriverWait wait3 = new WebDriverWait (driver ,20);
				wait3.until(ExpectedConditions.elementToBeClickable(objMDSCollection.MDS_Collection_SubmitBtn));
				
				objMDSCollection.MDS_Collection_AutoPstngBtn ();
				
				objMenuList.switchWindow(driver);
				
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
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				objTrnmodCommn.Enter_PostDebitCredit_AcNo(PostDebitCrdt_AcNo);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				objTrnmodCommn.Select_PostDebitCrdt_Instrtype (PostDbtcrdt_InstrType);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		
				Thread.sleep(1000);
				
				objTrnmodCommn.Click_PostDebitCrdit_ADD();
				
				objTrnmodCommn.Enter_PostDebitCrdit_Amount(MDS_collection_Amount);
				
				objTrnmodCommn.Click_PostDebitCrdit_ADD();
				
				Thread.sleep(1000);
				
				objTrnmodCommn.Click_PostDebitCrdit_Submit_Button();
    			
				driver.switchTo().window(PostDebtPopUp);
				
				objMDSCollection.MDS_Collection_SubmitBtn ();
				Thread.sleep(10000);
				objprintDuplicate.print_and_duplicate();
			}
			
			else
			{
				objMDSCollection.Transmode_MDS_Collection(TrnmodeMDSColelction);
				objMDSCollection.MDS_Collection_SubmitBtn();
				objTrnmodCommn.Click_UnclosedBatch_PoUp_Ok_Btn ();

				Thread.sleep(3000);
				objprintDuplicate.print_and_duplicate();
			
			}
			
		}
		
	}
	/*@Test (priority = 2)
	public void TransactionMode_MDS ()
	
	{
		
		
	}*/
	
	
	
}
