package com.beaconpro.module.uiobject.clearing;

/********************************************************************************************************************	
Created By   :  Yadhu 
Created On	 :	
Purpose	     :	BatchAssign
Use below code to call this TC

@Test(priority = 2)
	public void BatchAssign() {
		BatchAssign ba = new BatchAssign(driver);
		ba.Batch_Assign(ClearingGroup, ClearingType, OrgBranch, FromDate, ToDate, ToBatch);
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

public class BatchAssign {

	WebDriver driver;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucbatchAssignSearch_ddlClearingGroup_ddl")
	public WebElement ddl_ClearingGroup;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucbatchAssignSearch_ddlClearingType_ddl")
	public WebElement ddl_ClearingType;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucbatchAssignSearch_ddlOrgBranch_ddl")
	public WebElement ddl_OrgBranch;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucbatchAssignSearch_ddlClearingBatch")
	public WebElement ddl_ClearingBatch;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucbatchAssignSearch_dtClearingDate_txt")
	public WebElement txt_dtClearingDate;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucbatchAssignSearch_dtToClearingDate_txt")
	public WebElement txt_dtToClearingDate;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucbatchAssignSearch_btnSearch")
	public WebElement btnSearch;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucBatchAssignList_lstBatchAssignList_ctrl0_chkSelect")
	public WebElement chkSelect;

	@FindBy(xpath = ".//*[@id='rowdiv']/div[2]")
	public WebElement Reg_No;

	@FindBy(id = "chkAll")
	public WebElement chkAll;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnNew")
	public WebElement btnNew;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnOK")
	public WebElement btnOK_NewBatch;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ddlClearingBatch_ddl")
	public WebElement ddl_ToBatch;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnAssign")
	public WebElement btnAssign;

	public BatchAssign(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ExplicitWait_elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void open_window(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void Selection_from_dropdown(WebElement element, String index) {
		Select Select9 = new Select(element);
		Select9.selectByVisibleText(index);
	}

	public void Batch_Assign(String ClearingGroup, String ClearingType, String OrgBranch, String FromDate,
			String ToDate, String ToBatch) throws InterruptedException 
	{

		MenuList objML = new MenuList(driver);
		open_window(objML.BatchAssign);
		Selection_from_dropdown(ddl_ClearingGroup, ClearingGroup);
		for (int i = 0; i < 10; i++)
			try 
			{
				Selection_from_dropdown(ddl_ClearingType, ClearingType);
				break;
			} catch (Throwable e) {
				System.err.println("Error came : " + e.getMessage());
			}
		for (int i = 0; i < 10; i++)
			try {
				Selection_from_dropdown(ddl_OrgBranch, OrgBranch);
				break;
			} catch (Throwable e) {
				System.err.println("Error came : " + e.getMessage());
			}
		/*for (int i = 0; i < 10; i++)
			try {
				Selection_from_dropdown(ddl_ClearingBatch, ClearingBatch);
				break;
			} catch (Throwable e) {
				System.err.println("Error came : " + e.getMessage());
			}*/
		txt_dtClearingDate.sendKeys(FromDate);
		txt_dtToClearingDate.sendKeys(ToDate);
		for (int i = 0; i < 10; i++)
			
			try 
			{
				btnSearch.click();
				break;
			} 
			catch (Throwable e)
			{
				System.err.println("Error came : " + e.getMessage());
			}
		
		ExplicitWait_elementToBeClickable(chkSelect);
		String regno = Reg_No.getText();
		System.out.println("RegNo :" + regno);
		chkAll.click();
		Selection_from_dropdown(ddl_ToBatch, ToBatch);
		System.out.println("To Batch : " + ToBatch);
		btnAssign.click();
	}

}
