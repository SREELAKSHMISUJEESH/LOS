package com.beaconpro.test.acclosure;

/********************************************************************************************************************	
Created By      : Yadhu
Created On	    : 
Purpose	        : Loan Closure
Note			: 
Conditions      :
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.beaconpro.config.ScreenShot;
import com.beaconpro.module.uiobject.acclosure.LoanClosurePage;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.common.TransactionModeSelection;
import com.beaconpro.module.uiobject.login.LoginPage;

import jxl.read.biff.BiffException;

public class LoanClosure 
{
	String SheetName = "Loan Closure";
	String FileName = "/Account closure/Loan Closure/Loan Closure.xls";
	
	String Firefox_profile;
	String User_Name;
	String Password;
	String Branch;
	String Product_Group; //Other Loan, Jewel Loan, Deposit Loan, Over Draft/KCC Loan
	String Product_Name;
	String Ac_No;

	String Trans_Mode; // Trans_Modes are CASH,BATCH,AUTOPOSTING
	
	// Batch_tallying_trans
	String Branch2;
	String Product_Group2;
	String Product_Name2;
	String Ac_No2;
	String Trans_Type;
	String Instr_Type;
	String Opertd_By;
	String Trans_Mode2;

	// AutoPosting Window
	String ProductGroup_AP;
	String ProductName_AP;
	String Branch_AP;
	String Acno_AP;
	String InstrType_AP;
	
	//For screenshot
	String FolderName = "LoanClosure/OL closure";
	String FileName3 = "Before summary.jpeg";
	String FileName2 = "After Summary.jpeg";
	
	String ary[]= new String[40];

	WebDriver driver;
	public String Amount;
	public String transid;

	MenuList objML;
	LoanClosurePage objLc;
	
	@Test(priority = 0)
	public void ReadFromExcel() throws BiffException, IOException 
	{
		ReadExcelFile ref = new ReadExcelFile(driver);
		ref.ReadFromExcelFile(SheetName,FileName,ary);
		
		Firefox_profile    = ary[0];
		User_Name          = ary[1];
		Password           = ary[2];
		Branch			   = ary[3];
		Product_Group	   = ary[4];
		Product_Name	   = ary[5];
		Ac_No			   = ary[6];

		Trans_Mode         = ary[7];
		
		Branch2   		   = ary[8];
		Product_Group2	   = ary[9];
		Product_Name2	   = ary[10];
		Ac_No2			   = ary[11];
		Trans_Type		   = ary[12];
		Instr_Type 		   = ary[13];
		Opertd_By		   = ary[14];
		Trans_Mode2		   = ary[15];
		
		ProductGroup_AP    = ary[16];
		ProductName_AP     = ary[17];
		Branch_AP          = ary[18];
		Acno_AP       	   = ary[19];
		InstrType_AP	   = ary[20];
	}

	@Test(priority = 1)
	public void opening_firefox() throws Exception 
	{
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile(Firefox_profile);
		driver = new FirefoxDriver(ffprofile);
	}

	@Test(priority = 2)
	public void open_beaconpro_url_and_login() throws Throwable 
	{
		LoginPage newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		newloginmaker.loginToBeaconProValid(User_Name, Password);
	}

	@Test(priority = 3)
	public void Open_LoanClosureWindow() throws Throwable 
	{
		try 
		{
			objML = new MenuList(driver);
			objLc = new LoanClosurePage(driver);
			objML.Open_window(objML.Loan_Closure);
			objLc.ExplicitWait_elementToBeClickable(objLc.Btn_Go);
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
	}

	@Test(priority = 4)
	public void Select_Account_details() 
	{
		try 
		{
			objLc.Selection_from_dropdown(objLc.DDL_branch, Branch);
			objLc.Selection_from_dropdown(objLc.DDL_ProductGroup, Product_Group);
			objLc.Selection_from_dropdown(objLc.DDL_Product, Product_Name);
			objLc.Txt_AcNo.sendKeys(Ac_No);
			objLc.Btn_Go.click();
			try 
			{
				objLc.ExplicitWait_elementToBeClickable(objLc.Btn_Ok_In_KYC_Not_Completed_Customer_popup);
				objLc.Btn_Ok_In_KYC_Not_Completed_Customer_popup.click();
			} 
			catch (Exception e) 
			{
				objLc.ExplicitWait_elementToBeClickable(objLc.Btn_Submit);
			}
			Amount = objLc.Txt_TrnAmount.getAttribute("value");
			ScreenShot s_shot = new ScreenShot(driver);
			s_shot.take_screen_shot(FolderName, FileName);
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
	}

	@Test(priority = 5)
	public void Select_TransMode_And_Submit() 
	{
		try 
		{
			if (Trans_Mode.equals("CASH")) 
			{
				objLc.Selection_from_dropdown(objLc.DDL_TransactionMode, "CASH");
			} 
			else if (Trans_Mode.equals("BATCH")) 
			{
				objLc.Selection_from_dropdown(objLc.DDL_TransactionMode, "TRANSFER");
				objLc.Btn_Submit.click();
			for (int i = 0; i < 100; i++)
				try 
					{
						objLc.Btn_Ok_BatchOpenedPopup.click();
						break;
					} 
				catch (Exception e) 
					{
						e.printStackTrace();
					}
			objLc.ExplicitWait_elementToBeClickable(objLc.Transid_summary);
			transid = objLc.Transid_summary.getText();
			System.out.println("Loan closed successfully"+" "+"TransID : "+transid);
			
			//Batch tallying transaction
			TransactionModeSelection objtms = new TransactionModeSelection(driver);
			objtms.Batch_Tallying_Transaction(Branch2, Product_Group2, Product_Name2,Ac_No2,
					Trans_Type, Amount, Instr_Type, Opertd_By, Trans_Mode2);
			} 
			else if (Trans_Mode.equals("AUTOPOSTING")) 
			{
				TransactionModeSelection objtms = new TransactionModeSelection(driver);
				objLc.Selection_from_dropdown(objLc.DDL_TransactionMode, "TRANSFER");
				String parentHandle = driver.getWindowHandle();
				objLc.Btn_AutoPost.click();
				objLc.switch_window();
				objtms.Autoposting_PostDebit(Amount, ProductGroup_AP, ProductName_AP,
						Branch_AP, Acno_AP, InstrType_AP);
				driver.switchTo().window(parentHandle);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				objLc.Txt_Remarks.sendKeys("testQA");
			}
			objLc.Btn_Submit.click();
			objLc.ExplicitWait_elementToBeClickable(objLc.Transid_summary);
			transid = objLc.Transid_summary.getText();
			System.out.println("Loan closed successfully"+" "+"TransID : "+transid);
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@AfterTest()
	public void Screenshot2() throws IOException 
	{
		ScreenShot s_shot = new ScreenShot(driver);
		s_shot.take_screen_shot(FolderName, FileName2);
	}

}
