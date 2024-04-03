package com.beaconpro.module.uiobject.clearing;

/********************************************************************************************************************	
Created By   :  Yadhu 
Created On	 :	
Purpose	     :	MICR / CTS presenting

Execute this sp to get unbatched list and change its recordstatus into 6 in ClearingRegister table to avoid  Unbatched-
Items popup.
exec spGetUnBatchedList @ClgStatus=1,@TypeCode=2,@TransDate='2016-06-30 00:00:00'

ClgStatus = 1 --> Register

Typecode = 2 --> MICR OUTWARD
Typecode = 9 --> CTS OUTWARD

Use below code to call this TC

	@Test(priority = 2)
	public void presenting() {
		MICR_CTS_PresentingPage obja = new MICR_CTS_PresentingPage(driver);
		obja.presenting(ClearingType,ClearingDate, ClearingBatch, RegBranch);
	}
-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beaconpro.module.uiobject.common.MenuList;

public class MICR_CTS_PresentingPage 
{

	WebDriver driver;

	MenuList objML;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucClearingSearch_ddlClearingType_ddl")
	public WebElement ClearingType_ddl;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucClearingSearch_dtClearingDate_txt")
	public WebElement ClearingDate_txt;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucClearingSearch_ddlClearingBatch_ddl")
	public WebElement ClearingBatch_ddl;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucClearingSearch_ddlRegBranch_ddl")
	public WebElement RegBranch_ddl;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucClearingSearch_btnSearch")
	public WebElement btnSearch;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucClearingSearch_btnOK")
	public WebElement ClearingSearch_btnOK;

	@FindBy(id = "chkAll")
	public WebElement CheckAll_chkbx;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucSearchList_btnSubmitPresenting")
	public WebElement btnSubmitPresenting;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID")
	public WebElement TransID_in_summary;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnPrint")
	public WebElement btnPrint;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_btnPrintClose")
	public WebElement print_Close_btn;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnClose")
	public WebElement btnClose;
	
	String Presenting_Transid;

	public MICR_CTS_PresentingPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ExplicitWait_elementToBeClickable(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void open_window(WebElement element) 
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void Selection_from_dropdown(WebElement element, String index)
	{
		Select Select9 = new Select(element);
		Select9.selectByVisibleText(index);
	}
	
	public void Print_Voucher() throws InterruptedException
	{
		btnPrint.click();
		Thread.sleep(3000);
		print_Close_btn.click();
	}
	/*public void presenting(String ClearingType, String ClearingDate, String ClearingBatch, String RegBranch) {
		objML = new MenuList(driver);
		open_window(objML.MICR_CTS_Presenting);
		Selection_from_dropdown(ClearingType_ddl, ClearingType);
		for(int i = 0;i<20;i++)
			try {
				ClearingDate_txt.sendKeys(ClearingDate);
				break;
			}catch(Exception e) {
				e.printStackTrace();
			}
		//ClearingDate_txt.sendKeys("01012018");
		for(int i = 0;i<20;i++)
			try {
				Selection_from_dropdown(ClearingBatch_ddl, ClearingBatch);
				break;
			}catch(Exception e) {
				e.printStackTrace();
			}
		//Selection_from_dropdown(ClearingBatch_ddl, ClearingBatch);
		for(int i = 0;i<20;i++)
			try {
				Selection_from_dropdown(RegBranch_ddl, RegBranch);
				break;
			}catch(Exception e) {
				e.printStackTrace();
			}
		//Selection_from_dropdown(RegBranch_ddl, RegBranch);
		btnSearch.click();
		ExplicitWait_elementToBeClickable(CheckAll_chkbx);
		CheckAll_chkbx.click();
		//System.out.println("ok");
		btnSubmitPresenting.click();
	}
	*/
	
	public void Presenting(String ClearingType, String ClearingDate, String ClearingBatch, String RegBranch) throws InterruptedException 
	{
		objML = new MenuList(driver);
		objML.Open_window(objML.MICR_CTS_Presenting);
		Selection_from_dropdown(ClearingType_ddl, ClearingType);
		for(int i = 0;i<20;i++)
			try 
		     {
			ClearingDate_txt.sendKeys(ClearingDate);
			break;
		     }
		catch(Exception e) 
		     {
			e.printStackTrace();
		     }
		//ClearingDate_txt.sendKeys("01012018");
		for(int i = 0;i<20;i++)
			try 
		      {
			Selection_from_dropdown(ClearingBatch_ddl, ClearingBatch);
			break;
			
		      }
		catch(Exception e) 
		      {
			e.printStackTrace();
		      }
		//Selection_from_dropdown(ClearingBatch_ddl, ClearingBatch);
		for(int i = 0;i<20;i++)
			try 
		      {
				Selection_from_dropdown(RegBranch_ddl, RegBranch);
				break;
		       }
		catch(Exception e)
		      {
				e.printStackTrace();
		      }
		//Selection_from_dropdown(RegBranch_ddl, RegBranch);
		btnSearch.click();
		ExplicitWait_elementToBeClickable(CheckAll_chkbx);
		CheckAll_chkbx.click();
		//System.out.println("ok");
		btnSubmitPresenting.click();
		Thread.sleep(2000);
		Presenting_Transid=TransID_in_summary.getText();
		System.out.println("\n"+ClearingType +" Presenting Done with Trans Id: "+Presenting_Transid);
		Print_Voucher();
	}
	
	public String GetTransId()
	 {
		 String TransId=Presenting_Transid;
		 return TransId;
	 }
}
