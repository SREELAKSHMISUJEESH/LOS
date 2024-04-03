package com.beaconpro.test.acclosure;

/********************************************************************************************************************	
Created By      : Yadhu
Created On	    : 01/12/2015
Purpose	        : SB Closing 
Note			: 
Conditions      :
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason
Yadhu				08/06/2016			TC modified with all transmodes
-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;
import com.beaconpro.module.uiobject.acclosure.DemandDepositsClosurePage;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.common.TransactionModeSelection;
import com.beaconpro.module.uiobject.login.LoginPage;

public class SBClosing {

	//  \\seqc05\TestData\Demand deposit closure\SB Closing\TestData.xls
	String SheetName = "SB closing";
	String FileName = "/Account closure/Demand deposit closure/SB Closing/SB Closing.xls";
	
	String Firefox_profile;
	String User_Name;
	String Password;
	String Branch;
	String Product_Group;		   //product groups Current Account, Savings Bank
	String Product_Name;  		  //Product Names ORDINARY CA, ORDINARY SB
	String Ac_No;

	String Cheques_Returned;
	String Cards_Returned;
	String Reason_For_Closing;
	String Instrument_Type;
	String Operated_By;
	
	String Trans_Mode;     // Trans_Modes are CASH,BATCH,AUTOPOSTING
	
	//Autoposting post credit
	String ProductGroup_PC;
	String ProductName_PC;
	String Branch_PC;
	String AutopostAcno;
	
	String ary[]= new String[40];

	WebDriver driver;
	public String TransID;
	public String amount;
	DemandDepositsClosurePage objsscp;

	@Test(priority = 0)
	public void opening_firefox() throws Exception
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
		
		Cheques_Returned   = ary[7];
		Cards_Returned	   = ary[8];
		Reason_For_Closing = ary[9];
		Instrument_Type	   = ary[10];
		Operated_By		   = ary[11];

		Trans_Mode         = ary[12];
		
		ProductGroup_PC    = ary[13];
		ProductName_PC     = ary[14];
		Branch_PC          = ary[15];
		AutopostAcno       = ary[16];
		
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile(Firefox_profile);
		driver = new FirefoxDriver(ffprofile);	
	}

	@Test(priority = 1)
	public void open_beaconpro_url_and_login() throws Throwable 
	{
		
		
		LoginPage newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		newloginmaker.loginToBeaconProValid(User_Name,Password);
	}

	@Test(priority = 2)
	public void Open_Demand_Deposit_Closure_Window() throws Throwable 
	{
		try 
		{
			objsscp = new DemandDepositsClosurePage(driver);
			objsscp.Open_window(objsscp.Demand_Deposits_closure_Link);
			objsscp.ExplicitWait_elementToBeClickable(objsscp.BtnGo);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void Select_Account_details() 
	{
		try 
		{
			objsscp = new DemandDepositsClosurePage(driver);
			objsscp.Selection_from_dropdown(objsscp.Branch_dropdown, Branch);
			objsscp.Selection_from_dropdown(objsscp.ProductGroup_dropdown,Product_Group);
			objsscp.Selection_from_dropdown(objsscp.ProductName_dropdown,Product_Name);
			objsscp.AcNo_field.sendKeys(Ac_No);
			objsscp.BtnGo.click();
			objsscp.ExplicitWait_elementToBeClickable(objsscp.CardsReturned_dropdown);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void Entering_Cheque_Details() 
	{
		try 
		{
			objsscp.Selection_from_dropdown(objsscp.ChequesReturned_dropdown,
					Cheques_Returned);
			for (int i = 0; i < 10; i++)
				try 
				{
					objsscp.Selection_from_dropdown(
							objsscp.CardsReturned_dropdown, Cards_Returned);
					break;
				} 
				catch (StaleElementReferenceException e) 
				{
					e.getMessage();
				}
			for (int i = 0; i < 10; i++)
				try 
				{
					objsscp.Selection_from_dropdown(
							objsscp.ReasonForClosing_dropdown,
							Reason_For_Closing);
					break;
				} 
				catch (StaleElementReferenceException e) 
				{
					e.getMessage();
				}
			objsscp.Selection_from_dropdown(objsscp.InstrType_dropdown,
					Instrument_Type);
			objsscp.OperatedBy_Field.sendKeys(Operated_By);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void Select_TransMode_And_Submit() 
	{
		String parentHandle = driver.getWindowHandle();
		amount = objsscp.Net_Payable_Amount.getAttribute("value");
		objsscp.Btn_Check_Validity.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for (int i = 0; i < 10; i++)
			try 
			{
				objsscp.Transmode_Dropdown.click();
				objsscp.OperatedBy_Field.sendKeys(" Operator");
				break;
			} 
			catch (StaleElementReferenceException e) 
			{
				e.getMessage();
			}
			objsscp.switch_window();
			objsscp.ExplicitWait_elementToBeClickable(objsscp.Btn_close_link);
			objsscp.Btn_close_link.click();
			driver.switchTo().window(parentHandle);
			objsscp.ExplicitWait_elementToBeClickable(objsscp.Transmode_Dropdown);
			objsscp.remarks.sendKeys("success");	
		if (Trans_Mode.equals("CASH")) 
		{
			objsscp.Selection_from_dropdown(objsscp.Transmode_Dropdown,"CASH");
			objsscp.Submit_Button.click();
			objsscp.ExplicitWait_elementToBeClickable(objsscp.BtnPrint_summary);
			TransID = objsscp.TransID_in_summary.getText();
			System.out.print("\nAmount = " + amount + "\n");
			System.out.print("\nTransID = " + TransID + "\n");
		}
		else if (Trans_Mode.equals("BATCH"))
		{
			objsscp.Selection_from_dropdown(objsscp.Transmode_Dropdown,"TRANSFER");
			objsscp.remarks.sendKeys("Batch");
			objsscp.Submit_Button.click();
			objsscp.Btn_Ok_in_Batch_Opened_popup.click();
			objsscp.ExplicitWait_elementToBeClickable(objsscp.BtnPrint_summary);
			TransID = objsscp.TransID_in_summary.getText();
			System.out.print("\nAmount = " + amount + "\n");
			System.out.print("\nTransID = " + TransID + "\n");
		}
		else if (Trans_Mode.equals("AUTOPOSTING"))
		{
			objsscp.Selection_from_dropdown(objsscp.Transmode_Dropdown,"TRANSFER");
			objsscp.remarks.sendKeys("autoposting");
			objsscp.Btn_postCredit.click();
			objsscp.switch_window();
			TransactionModeSelection objtms = new TransactionModeSelection(driver);
			objtms.Autoposting_PostCredit(ProductGroup_PC, ProductName_PC,Branch_PC, AutopostAcno, amount);
			driver.switchTo().window(parentHandle);
			objsscp.ExplicitWait_elementToBeClickable(objsscp.Submit_Button);
			objsscp.Submit_Button.click();
			objsscp.ExplicitWait_elementToBeClickable(objsscp.BtnPrint_summary);
			TransID = objsscp.TransID_in_summary.getText();
			System.out.print("\nAmount = " + amount + "\n");
			System.out.print("\nTransID = " + TransID + "\n");
		}
	}
}
