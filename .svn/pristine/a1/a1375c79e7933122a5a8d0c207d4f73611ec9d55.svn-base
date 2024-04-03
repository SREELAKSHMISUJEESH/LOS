package com.beaconpro.module.uiobject.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransactionPageCommon {

	WebDriver driver;

	// Account Info Block
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlBranch")
	public WebElement BranchNameField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_dtValueDate_dtValueDate_txt")
	public WebElement ValueDateField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup")
	public WebElement ProductGroupField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl")
	public WebElement ProductNameField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt")
	public WebElement AccountNoPrefixField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt")
	public WebElement AccountNoField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlTrnType_ddl")
	public WebElement TransactionTypeDropDownField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo")
	public WebElement GoBtn;

	//Transaction info
	@FindBy(xpath = ".//*[@id='tblCustList']/tbody/tr[1]/td[1]")
	public WebElement CustomerIdGrid_custIdField_Heading;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt")
	public WebElement TransactionAmountField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtPayeeName_txt")
	public WebElement OperatedByField;

	//TransactionMode Selection Block
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_ddlTransactionMode_ddl")
	public WebElement TransactionModeField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtRemarks_txt")
	public WebElement RemarkField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement SubmitBtn;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnPrint")
	public WebElement PrintBtn;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_ddlInstrType_ddl")
	public WebElement Instr_Type_dropdown;
	
	@FindBy(xpath = ".//*[@id='linkBatch']/img")
	public WebElement Batch_search_btn;
	
	@FindBy(id = "lstBatch_ctrl0_linkSelect")
	public WebElement Batch_select;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_chkLastN']")
	public WebElement Click_Prevoius_Trnsctn_CheckBox;
	
	@FindBy (id="closewarning")
	public WebElement KYC_NOT_Completed_PopUP;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtRemittingInstallment_txt")
	public WebElement Installment_No;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_ddlInstrType_ddl")
	public WebElement TransDebitIntrumentType;
	
	//Transaction PostDebit or Credit Button
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_btnAutoPost']")
	public WebElement Click_Trans_Post_DebitBtn_or_CreditBtn;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_btnAutoPost")
	public WebElement TrnPostDebitBtn;

	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnPrintClose']")
	public WebElement PrintClose_Button;
	
	public TransactionPageCommon(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// Open Transaction window

	public TransactionPageCommon() {
		// TODO Auto-generated constructor stub
	}
	

	// methods
	public void select_branch_name(String index) {
		Select drop = new Select(BranchNameField);
		drop.selectByVisibleText(index);

	}

	public void select_product_group(String index) {
		Select drop = new Select(ProductGroupField);
		drop.selectByVisibleText(index);

	}

	public void select_product_name(String Prd_nam) {
		Select drop = new Select(ProductNameField);
		drop.selectByVisibleText(Prd_nam);

	}

	public void enter_account_number(String acno) {
		AccountNoField.sendKeys(acno);

	}

	public void select_trans_type(String intex) {
		Select drop = new Select(TransactionTypeDropDownField);
		drop.selectByVisibleText(intex);

	}

	public void click_go_button() {
		GoBtn.click();
	}

	public void wait_after_click_go_button() {

		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.textToBePresentInElement(
				CustomerIdGrid_custIdField_Heading, "Cust ID"));

	}
	
	public void KYC_Not_Completed_PopUp ()
	
	{
		KYC_NOT_Completed_PopUP.click();
	}
	
	public void Select_Instr_Type(String index) {

		Select Branch_dropdown = new Select(Instr_Type_dropdown);
		Branch_dropdown.selectByVisibleText(index);
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(OperatedByField));

	}
	
	public void Enter_Installment_Number (String InstallmentNo) {
		
		
		Installment_No.sendKeys(InstallmentNo);
		
	}

	public void enter_transaction_amount(String t_amount) {

		TransactionAmountField.sendKeys(t_amount);

	}

	
	public void enter_operated_by(String op_by) {

		OperatedByField.sendKeys(op_by);

	}
	
	public void Click_Trans_Post_DebitBtn_or_CreditBtn ()
	
	{
		Click_Trans_Post_DebitBtn_or_CreditBtn.click();
	}
	
	public void Click_PostDbt_Btn ()
	
	{
		TrnPostDebitBtn.click();
	}

	public void SelectDebitTransInstrumentType ()
	
	{
		for (int i =0 ;i<100 ;i++)
		{
			Select DbtInstrType = new Select (TransDebitIntrumentType);
			DbtInstrType.selectByVisibleText("Advice Slip");
		}
		
	}
	
	public void select_trans_mode(String mode) {
		Select drop = new Select(TransactionModeField);
		drop.selectByVisibleText(mode);
	}
	
	public void Click_batch_search_link()  {

		//this.switch_window();
		this.Batch_search_btn.click();
		
		
	}

	public void Select_batch_from_batchSearch_window() throws InterruptedException {

		//this.switch_window();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Batch_select));
		this.Batch_select.click();
		Thread.sleep(1000);
		
	}
	
	public void enter_remark(String remark) {

		RemarkField.sendKeys(remark);
	}
	
	public void click_on_submit() {

		SubmitBtn.click();

	}

	public void click_on_print() throws InterruptedException {

		PrintBtn.click();
		
	}
	public void click_on_print_and_close_preview() throws InterruptedException
	
	{
		PrintBtn.click();
        Thread.sleep(3000);
		WebDriverWait wait_Voucher_ToLoad =new WebDriverWait(driver, 50);
		wait_Voucher_ToLoad.until(ExpectedConditions.elementToBeClickable(PrintClose_Button));
		this.PrintClose_Button.click();
	}
	
	
		
}
