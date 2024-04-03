package com.beaconpro.test.acopening;

/********************************************************************************************************************	
Created By      : Yadhu
Created On	    : 01/12/2015
Purpose	        : SB opening 
Note			: 
Conditions      :
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason
Yadhu				08/06/2016			TC modified with all transmodes
-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;
import com.beaconpro.module.uiobject.acopening.SBOpeningPage;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.NomineeAdding;
import com.beaconpro.module.uiobject.common.PrintAndDuplicate;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.common.TransactionModeSelection;
import com.beaconpro.module.uiobject.login.LoginPage;
import jxl.read.biff.BiffException;

public class SBOpening 
{
	String SheetName = "SB Opening";
	String FileName = "/Account Opening/Demand Deposit Opening/SB Opening/SB Opening.xls";
	
	public String Firefox_profile;
	public String User_Name;		  
	public String Password;		  
	String CustName;  
	String CustID; 			  
	String Amount; 			   
	String NomCustName;        
	String NomCustID;             
	String NomRelation;        

	public String Trans_Mode;     // Trans_Modes are CASH,BATCH,AUTOPOSTING

	// Batch_tallying_trans
	String Branch;
	String Product_Group;
	String Product_Name;
	String Ac_No;
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
	
	String ary[]= new String[40];

	WebDriver driver;

	public String transid;
	public String BatchID;
	public String AcNo;

	SBOpeningPage objsb;
	NomineeAdding objnom;
	MenuList objml;
	PrintAndDuplicate objpd;
	
	@Test(priority = 0)
	public void ReadFromExcel() throws BiffException, IOException 
	{
		ReadExcelFile ref = new ReadExcelFile(driver);
		ref.ReadFromExcelFile(SheetName,FileName,ary);
		
		Firefox_profile    = ary[0];
		User_Name          = ary[1];
		Password           = ary[2];
		CustName  	 	   = ary[3];
		CustID			   = ary[4];
		Amount			   = ary[5];
		NomCustName		   = ary[6];
		NomCustID		   = ary[7];
		NomRelation		   = ary[8];
		
		Trans_Mode		   = ary[9];
		
		Branch			   = ary[10];
		Product_Group	   = ary[11];
		Product_Name	   = ary[12];
		Ac_No			   = ary[13];
		Trans_Type		   = ary[14];
		Instr_Type		   = ary[15];
		Opertd_By		   = ary[16];
		Trans_Mode2		   = ary[17];
		
		ProductGroup_AP    = ary[18];
		ProductName_AP	   = ary[19];
		Branch_AP 		   = ary[20];
		Acno_AP	   		   = ary[21];
		InstrType_AP	   = ary[22];
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
	public void SB_opening_window() throws Exception 
	{
		try 
		{
			objml = new MenuList(driver);
			objsb = new SBOpeningPage(driver);
			objml.Open_window(objml.SB_opening_link);
			objsb.ExplicitWait_elementToBeClickable(objsb.cust_add);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	@Test(priority = 4)
	public void customer_search_window()
	{
		try 
		{
			objml = new MenuList(driver);
			objsb = new SBOpeningPage(driver);
			String parentHandle = driver.getWindowHandle();
			objsb.click_cust_search.click();
			objml.switchWindow(driver);
			objsb.ExplicitWait_elementToBeClickable(objsb.customer_name);
			objsb.customer_name.sendKeys(CustName);
			objsb.customer_id.sendKeys(CustID);
			objsb.click_on_search_button.click();
			objsb.ExplicitWait_elementToBeClickable(objsb.select_cust_from_grid);
			objsb.select_cust_from_grid.click();
			driver.switchTo().window(parentHandle);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	@Test(priority = 5)
	public void customer_adding_and_general_tab_edits() throws Exception 
	{
		try 
		{
			objsb.cust_add.click();
			objsb.ExplicitWait_visibilityOf(objsb.cust_grid);
			try 
			{
				objsb.SB_ac_exists_popup_ok_btn.click();
			} 
			catch (Exception e) 
			{
				e.getMessage();
			}
			objnom = new NomineeAdding(driver);
			objsb.Amount_field.sendKeys(Amount);
			objsb.Body.click();
			objsb.Get_values_btn.click();
			objsb.Txt_Remark.sendKeys("test");
			objsb.ExplicitWait_elementToBeClickable(objsb.Next_button);
			for (int i = 0; i < 100; i++)
				try 
				{
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", objsb.Next_button);
					break;
				} 
				catch (StaleElementReferenceException e) 
				{
					e.getMessage();
				}

			objsb.ExplicitWait_elementToBeClickable(objsb.Nominee_checkbox);
			objnom.Nominee_Adding(NomCustName, NomCustID, NomRelation);

		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	@Test(priority = 6)
	public void transmode()
	{
		try 
		{
			if (Trans_Mode.equals("CASH")) 
			{
				objsb.Selection_from_dropdown(objsb.Trans_mode_dropdown, "CASH");
				objsb.Txt_SpInstruction.sendKeys("Cash");
				objsb.Save_button.click();
				objsb.ExplicitWait_elementToBeClickable(objsb.print_button);
				transid = objsb.save_transid.getText();
				AcNo = objsb.Ac_No.getText();
				System.out.print("\nAc No: " + AcNo + "\n");
				objpd = new PrintAndDuplicate(driver);
				objpd.print_and_duplicate();
			} 
			else if (Trans_Mode.equals("BATCH")) 
			{
				objsb.Selection_from_dropdown(objsb.Trans_mode_dropdown, "TRANSFER");
				objsb.Txt_SpInstruction.sendKeys("Batch");
				objsb.Save_button.click();
				objsb.ok_btn_in_batch_opening_popup.click();
				objsb.ExplicitWait_elementToBeClickable(objsb.print_button);
				transid = objsb.save_transid.getText();
				AcNo = objsb.Ac_No.getText();
				System.out.print("\nTransID : "+transid+"\n");
				System.out.print("\nAc No : "+AcNo+"\n");
				objpd = new PrintAndDuplicate(driver);
				objpd.print_and_duplicate();
				//Batch tallying transaction
				TransactionModeSelection objtms = new TransactionModeSelection(driver);
				objtms.Batch_Tallying_Transaction(Branch, Product_Group, Product_Name,Ac_No,
						Trans_Type, Amount, Instr_Type, Opertd_By, Trans_Mode2);
				objpd = new PrintAndDuplicate(driver);
				objpd.print_and_duplicate();
				//-------------------------------------------//
			} 
			else if (Trans_Mode.equals("AUTOPOSTING")) 
			{
				objsb.Selection_from_dropdown(objsb.Trans_mode_dropdown, "TRANSFER");
				objsb.Txt_SpInstruction.sendKeys("autoposting");
				objsb.post_debit_btn.click();
				String parentHandle = driver.getWindowHandle();
				objml.switchWindow(driver);
				TransactionModeSelection objtms = new TransactionModeSelection(driver);
				objtms.Autoposting_PostDebit(Amount, ProductGroup_AP, ProductName_AP,
				Branch_AP, Acno_AP, InstrType_AP);
				driver.switchTo().window(parentHandle);
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				objsb.Save_button.click();
				objpd = new PrintAndDuplicate(driver);
				objpd.print_and_duplicate();
			}
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
	}

}