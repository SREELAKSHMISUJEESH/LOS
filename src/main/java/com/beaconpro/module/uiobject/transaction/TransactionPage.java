package com.beaconpro.module.uiobject.transaction;

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

public class TransactionPage {

	WebDriver driver;
	//ss

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

	// Account Info Block
	@FindBy(xpath = ".//*[@id='tblCustList']/tbody/tr[1]/td[1]")
	public WebElement CustomerIdGrid_custIdField_Heading;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt")
	public WebElement TransactionAmountField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtPayeeName_txt")
	public WebElement OperatedByField;

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
	
	@FindBy (xpath=".//*[@id='closewarning']")
	public WebElement KYC_NOT_Completed_PopUP;

	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_btnAutoPost']")
	public WebElement Click_Trans_Post_DebitBtn_or_CreditBtn;
	
	@FindBy (xpath=".//*[@id='ddlProductGroup_ddl']")
	public WebElement Select_PostDebitOrCredit_PopUP_Product_Group;
	
	@FindBy (xpath=".//*[@id='ddlProductName_ddl']")
	public WebElement Select_PostDebitOrCredit_Product_Name;
	
	@FindBy (xpath=".//*[@id='txtChildAcNo_txt']")
	public WebElement Enter_PostDebitOrCredit_AccNo;
	
	@FindBy (xpath=".//*[@id='ddlInstrType_ddl']")
	public WebElement Select_PostDebit_Instrtype;
	
	@FindBy (xpath=".//*[@id='txtAmount_txt']")
	public WebElement Enter_PostDebit_Amount;
	
	@FindBy (xpath=".//*[@id='btnAdd']")
	public WebElement Click_PostDebit_ADD_Button;
	
	@FindBy (xpath=".//*[@id='btnSubmit']")
	public WebElement  Click_PostDebit_Submit_Button;
	
	// @FindBy(id ="")
	// public WebElement element_name;

	public TransactionPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// Open Transaction window

	public TransactionPage() {
		// TODO Auto-generated constructor stub
	}
	
	public void open_transaction_window() {

		WebElement element = driver.findElement(By
				.xpath(".//*[@id='CreateMenu']/li[3]/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

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
	
	
	public void Select_Instr_Type(String index) {

		Select Branch_dropdown = new Select(Instr_Type_dropdown);
		Branch_dropdown.selectByVisibleText(index);
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(OperatedByField));

	}

	public void enter_transaction_amount(String t_amount) {

		TransactionAmountField.sendKeys(t_amount);

	}

	public void enter_operated_by(String op_by) {

		OperatedByField.sendKeys(op_by);

	}

	public void select_trans_mode(String mode) {
		Select drop = new Select(TransactionModeField);
		drop.selectByVisibleText(mode);
	}

	public void Select_batch_from_batchSearch_window() {

		//this.switch_window();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Batch_select));
		this.Batch_select.click();
		
	}
	
	public void enter_remark(String remark) {

		RemarkField.sendKeys(remark);
	}

	//Post Debit/Credit popUp WIndow
	
	public void Click_On_PostDebitOrCreditBtn () {
		
		Click_Trans_Post_DebitBtn_or_CreditBtn.click();
	}
	
	public void Select_PostDebitOrCredit_Product_Group (String PostDebitOrCredit_PrductGroup) {
		
		
		Select PostDebitPrdctGroup = new Select (Select_PostDebitOrCredit_PopUP_Product_Group);
		PostDebitPrdctGroup.selectByVisibleText(PostDebitOrCredit_PrductGroup);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.elementToBeClickable(Select_PostDebitOrCredit_Product_Name));
		
	}
	
	public void Select_PostDebitOrCredit_Product_Name (String PostDebitOrCredit_PrductName) {
		
		
		Select PostDebitPrdctGroup = new Select (Select_PostDebitOrCredit_Product_Name);
		PostDebitPrdctGroup.selectByVisibleText(PostDebitOrCredit_PrductName);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.elementToBeClickable(Enter_PostDebitOrCredit_AccNo));
		
	}
	
	public void Enter_PostDebitOrCredit_AccNo (String PostDebitOrCredit_AcNo) {
		
	
		Select PostDebitPrdctGroup = new Select (Enter_PostDebitOrCredit_AccNo);
		PostDebitPrdctGroup.selectByVisibleText(PostDebitOrCredit_AcNo);
		this.Enter_PostDebitOrCredit_AccNo.sendKeys(Keys.TAB);
		
		for(int i=0; i<1000;i++) 
			 
			 try {
				 
				 this.Enter_PostDebitOrCredit_AccNo.sendKeys("29328");
				 //driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtPayeeName_txt']")).sendKeys("MANU");
				 break; 
				 
			 } catch(StaleElementReferenceException e) {
					
				 e.toString();
				 System.out.println("Trying to recover from a stale element :" + e.getMessage());
				 
			 }
		
	}
	
	public void Select_PostDebit_Instrtype (String PostDebit_Instrtype) {
		
	Select PostDebitIntrumntType = new Select (Select_PostDebit_Instrtype);
	PostDebitIntrumntType.selectByVisibleText(PostDebit_Instrtype);
	
	}
	
	public void Enter_PostDebit_Amount (String PostDebit_Amount) {
		
		Select PostDebitIntrumntType = new Select (Enter_PostDebit_Amount);
		PostDebitIntrumntType.selectByVisibleText(PostDebit_Amount);
		
	}
		
	public void Click_PostDbt_ADD_Button () {
		
		Click_PostDebit_ADD_Button.click();
		
		}
	
	public void Click_PostDbt_Submit_Button () {
		
		Click_PostDebit_Submit_Button.click();
		
		}
	
	public void click_on_submit() {

		SubmitBtn.click();

	}

	public void click_on_print() {

		PrintBtn.click();

	}
	
	public void sb_credit_trans_ord_sb_by_cash_enter(String Brch,
			String acno) {

		this.open_transaction_window();
		this.select_branch_name(Brch);
		this.select_product_group("Savings Bank");
		this.select_product_name("ORDINARY SB");
		this.enter_account_number(acno);
		this.select_trans_type("Credit");
		this.click_go_button();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(this.SubmitBtn));

	}

}
