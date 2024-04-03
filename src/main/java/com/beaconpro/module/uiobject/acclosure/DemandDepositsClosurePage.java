package com.beaconpro.module.uiobject.acclosure;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemandDepositsClosurePage {

	WebDriver driver;

	/**************** Demand_Deposits_closure_Page ***************************/
	@FindBy(xpath = ".//*[@id='CreateMenu']/li[4]/ul/li[5]/a")
	public WebElement Demand_Deposits_closure_Link;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlBranch")
	public WebElement Branch_dropdown;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup")
	public WebElement ProductGroup_dropdown;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl")
	public WebElement ProductName_dropdown;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt")
	public WebElement AcNo_field;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo")
	public WebElement BtnGo;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstTransProductAccountInfo_ctrl0_ucTransactionProductAccInfo_usrCustInfo_lstCustView_ctrl0_lblCust_ID")
	public WebElement CustID_in_Grid;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_DemandDepositClosureInstruments1_ddlChequesReturned_ddl")
	public WebElement ChequesReturned_dropdown;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_DemandDepositClosureInstruments1_ddlCardsReturned_ddl")
	public WebElement CardsReturned_dropdown;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_DemandDepositClosureInstruments1_ddlReasonForClosing_ddl")
	public WebElement ReasonForClosing_dropdown;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstDemandDeposit_ctrl0_ucDemanDepositClosure_ddlInstrType_ddl")
	public WebElement InstrType_dropdown;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstDemandDeposit_ctrl0_ucDemanDepositClosure_txtPayeeName_txt")
	public WebElement OperatedBy_Field;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstDemandDeposit_ctrl0_ucDemanDepositClosure_txtTrnAmount_txt")
	public WebElement Net_Payable_Amount;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_ddlTransactionMode_ddl")
	public WebElement Transmode_Dropdown;
	
	@FindBy(xpath = "html/body/div[2]/div[11]/div/button[1]")
	public WebElement Btn_Ok_in_Batch_Opened_popup;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_txtRemarks_txt")
	public WebElement remarks;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnCheckValidity")
	public WebElement Btn_Check_Validity;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement Submit_Button;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID")
	public WebElement TransID_in_summary;

	@FindBy(xpath = ".//*[@id='tblCustList']/tbody/tr[2]/td[5]/text()")
	public WebElement BatchID_in_summary;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnPrint")
	public WebElement BtnPrint_summary;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnPrintClose")
	public WebElement BtnClose_in_PrintPreview;
	/****************************************/

	/********* Autoposting *******************/
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_btnAutoPost")
	public WebElement Btn_postCredit;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_btnAutoPost")
	public WebElement Btn_postDebit;

	@FindBy(id = "ddlProductGroup_ddl")
	public WebElement DDL_ProductGroup;

	@FindBy(id = "ddlProductName_ddl")
	public WebElement DDL_ProductName;

	@FindBy(id = "ddlBranch_ddl")
	public WebElement DDL_Branch;

	@FindBy(id = "txtChildAcNo_txt")
	public WebElement AcNo;

	@FindBy(id = "txtDisplayName_txt")
	public WebElement Display_Name;

	@FindBy(id = "txtAmount_txt")
	public WebElement Amount;

	@FindBy(id = "btnClose")
	public WebElement Btn_Close;

	@FindBy(id = "txtBalAmount_txt")
	public WebElement Balance_Amount;

	@FindBy(id = "btnAdd")
	public WebElement Btn_Add;

	@FindBy(xpath = ".//*[@id='lstContraEntry_ctrl0_lnkRemove']/img")
	public WebElement Btn_Cross;

	@FindBy(id = "btnSubmit")
	public WebElement Btn_submit;
	/*************************************/

	/***************** Linked_Account_Details_Popup **********************/
	@FindBy(xpath = ".//*[@id='btnClose']")
	public WebElement Btn_close_link;

	@FindBy(xpath = "ucSC_lblCaption")
	public WebElement Linked_Account_Details_Caption;
	/*************************************/

	public DemandDepositsClosurePage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	/************** Important codes *********************/
	public void switch_window() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void ExplicitWait_elementToBeClickable(WebElement element) {
		WebDriverWait wait10 = new WebDriverWait(driver, 30);
		wait10.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void Selection_from_dropdown(WebElement element1, String index) {
		Select Select9 = new Select(element1);
		Select9.selectByVisibleText(index);
	}

	public void Open_window(WebElement element2) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}
	/*******************************************************/
}
