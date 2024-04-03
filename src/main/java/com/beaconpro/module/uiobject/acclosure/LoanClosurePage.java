package com.beaconpro.module.uiobject.acclosure;

/********************************************************************************************************************	
Created By      : Yadhu
Created On	    : 
Purpose	        : Loan Closure page objects repository
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class LoanClosurePage {

	WebDriver driver;

	/**************** Loan_Closure_Page ***************************/
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlBranch")
	public WebElement DDL_branch;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup")
	public WebElement DDL_ProductGroup;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl")
	public WebElement DDL_Product;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt")
	public WebElement Txt_AcNo;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo")
	public WebElement Btn_Go;

	@FindBy(id = "closewarning")
	public WebElement Btn_Ok_In_KYC_Not_Completed_Customer_popup;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucLoanClosure_txtTrnAmount_txt")
	public WebElement Txt_TrnAmount;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_ddlTransactionMode_ddl")
	public WebElement DDL_TransactionMode;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_txtRemarks_txt")
	public WebElement Txt_Remarks;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnPrincipalLog")
	public WebElement Btn_PrincipalLog;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnInterestLog")
	public WebElement Btn_InterestLog;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_btnAutoPost")
	public WebElement Btn_AutoPost;

	@FindBy(xpath = ".//*[@id='linkBatch']/img")
	public WebElement Btn_BatchSearch;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement Btn_Submit;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnClose")
	public WebElement Btn_Close;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID")
	public WebElement Transid_summary;
	/****************************************************************/

	/******************* Autoposting_popup ***************************/
	@FindBy(id = "ddlProductGroup_ddl")
	public WebElement DDL_ProductGroup_Autoposting;

	@FindBy(id = "ddlProductName_ddl")
	public WebElement DDL_ProductName_Autoposting;

	@FindBy(id = "ddlBranch_ddl")
	public WebElement DDL_Branch_Autoposting;

	@FindBy(id = "txtChildAcNo_txt")
	public WebElement Txt_AcNo_Autoposting;

	@FindBy(id = "txtDisplayName_txt")
	public WebElement Txt_DisplayName_Autoposting;

	@FindBy(id = "txtParticulars_txt")
	public WebElement Txt_Particulars_Autoposting;

	@FindBy(id = "ddlInstrType_ddl")
	public WebElement DDL_InstrType;

	@FindBy(id = "txtAmount_txt")
	public WebElement Txt_Amount_Autoposting;

	@FindBy(id = "btnAdd")
	public WebElement Btn_Add_Autoposting;

	@FindBy(xpath = ".//*[@id='lstContraEntry_ctrl0_lnkRemove']/img")
	public WebElement Btn_Close_AcAddingGrid_Autoposting;

	@FindBy(id = "btnSubmit")
	public WebElement Btn_Submit_Autoposting;
	/******************* **************** ***************************/

	/******************* BatchOpeningPopup ***************************/
	@FindBy(xpath = "html/body/div[2]/div[11]/div/button[1]")
	public WebElement Btn_Ok_BatchOpenedPopup;

	/******************* **************** ***************************/

	public LoanClosurePage(WebDriver driver) {
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

	public void Selection_from_dropdown(WebElement element, String index) {
		Select Select9 = new Select(element);
		Select9.selectByVisibleText(index);
	}

	public void Open_window(WebElement element2) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}
	/*******************************************************/

}
