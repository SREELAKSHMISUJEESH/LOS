package com.beaconpro.module.uiobject.clearing;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 02/06/2016
Purpose	        : ECS Presenting Page [Object Definitions] 
Note            :
	Execute this sp to get unbatched list and change its recordstatus into 6 in ClearingRegister table to avoid  Unbatched-
Items popup.
exec spGetUnBatchedList @ClgStatus=1,@TypeCode=2,@TransDate='2016-06-30 00:00:00'

ClgStatus = 1 --> Register

Typecode  = 4 --> ECS OUTWARD
 

Conditions      :  
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

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

import com.beaconpro.module.uiobject.common.Authorizations;
import com.beaconpro.module.uiobject.common.MenuList;

public class EcsPresentingPage
{

	WebDriver driver;
	String Presenting_Transid;

	MenuList objML;
	EcsMarkingPage objEcsMark=new EcsMarkingPage(driver) ;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_ddlClearingType_ddl")
	public WebElement ClearingType_ddl;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_dtClearingDate_txt")
	public WebElement ClearingDate_txt;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_ddlClearingBatch_ddl")
	public WebElement ClearingBatch_ddl;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_ddlRegBranch_ddl")
	public WebElement RegBranch_ddl;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_btnSearch")
	public WebElement btnSearch;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_btnOK")
	public WebElement ClearingSearch_btnOK;

	//@FindBy(id = "chkAll")
	//public WebElement CheckAll_chkbx;
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucSearchList_lstClearingList_ctrl0_chkSelect")
	public WebElement Checkbox_Select;
	

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucSearchList_btnSubmitPresenting")
	public WebElement btnSubmitPresenting;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID")
	public WebElement TransID_in_summary;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnPrint")
	public WebElement btnPrint;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_btnPrintClose")
	public WebElement print_Close_btn;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnPrintClose")		  
	public WebElement btnClose;

	public EcsPresentingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ExplicitWait_elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void Open_window(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void Selection_from_dropdown(WebElement element, String index) {
		Select Select9 = new Select(element);
		Select9.selectByVisibleText(index);
	}
	
	public void Print_Voucher() throws InterruptedException
	{
		btnPrint.click();
		Thread.sleep(3000);
		print_Close_btn.click();
	}
	
	public void Presenting(String ClearingType, String ClearingDate, String ClearingBatch, String RegBranch) throws InterruptedException 
	{
		
		Selection_from_dropdown(ClearingType_ddl, ClearingType);
		for(int i = 0;i<20;i++)
			try {
				ClearingDate_txt.sendKeys(ClearingDate);
				break;
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		for(int i = 0;i<20;i++)
			try {
				Selection_from_dropdown(ClearingBatch_ddl, ClearingBatch);
				break;
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		for(int i = 0;i<20;i++)
			try {
				Selection_from_dropdown(RegBranch_ddl, RegBranch);
				break;
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		btnSearch.click();
		 
		ExplicitWait_elementToBeClickable(Checkbox_Select);
		Checkbox_Select.click();
	
		btnSubmitPresenting.click();
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
