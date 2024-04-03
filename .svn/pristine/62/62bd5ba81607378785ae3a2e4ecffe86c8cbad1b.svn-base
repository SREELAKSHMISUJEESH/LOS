package com.beaconpro.module.uiobject.acopening;
/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 15/04/2016
Purpose	        : Term Deposits Closure
Note			: Kyc not completed customer, Premature closing,Default A/c Pop up messages handled
Conditions      : A/c Should not be a Leined A/c
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason
Shilpa				26/05/2016			All Transactionmodes integrated 
-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.beaconpro.config.ScreenShot;
import com.beaconpro.module.uiobject.common.CustomerOrMemberAdding;
import com.beaconpro.module.uiobject.common.TransactionPageCommon;
import com.beaconpro.module.uiobject.login.LoginPage;


public class FDOpeningPage 

{

	
	WebDriver driver;
	
	public String User;
	public String Pass;

	
	@FindBy(xpath=".//*[@id='CreateMenu']/li[2]/ul/li[1]/ul/li[3]/ul/li[1]/a")
	public WebElement FDopeningPage;
	
	@FindBy(id="ddlProductGroup_ddl")
	public WebElement Auto_ProductGroup_Field;
	
	@FindBy(id="ddlProductName_ddl")
	public WebElement Auto_ProductName_Field;
	
	//@FindBy(id="txtChildAcNo_txt")
	@FindBy(xpath=".//*[@id='txtChildAcNo_txt']")
	public WebElement Auto_AccNo_Field;
	
	@FindBy(id="ddlInstrType_ddl")
	public WebElement Auto_InstrType_Field;
	
	@FindBy(id="txtAmount_txt")
	public WebElement Auto_PostAmount;
	
	@FindBy(id="btnAdd")
	public WebElement AutoPost_AddToGrid_Button;
	
	@FindBy(id="btnSubmit")
	public WebElement AutoPost_Submit_Button;
	
	
	@FindBy (xpath="html/body/div[2]/div[11]/div/button[1]")
	public WebElement UncloseBatch_PoUp_Ok_Button;

	
	@FindBy (id=("imgbtnSubmit"))
	public static WebElement loginbutton;
	
	@FindBy (xpath=".//*[@id='CreateMenu']/li[2]/ul/li[1]/ul/li[3]/ul/li[1]/a")
	public static WebElement FDOpeningLinkSelect;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer")
	public static WebElement FDOpenCustAddButtonClick;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_txtCustomerId_txt")
	public WebElement CustomerID;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtAcOpeningAmount_txt")
	public static WebElement FDOpenAmountField;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_ddlDurationMode_ddl")
	public  WebElement DurationModeField;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtDuration_txt")
	public  WebElement FDOpenDurationField;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_ddlCategoryID_ddl")
	public static WebElement RoiCategoryField;
	
	@FindBy( id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_btnGetROI")
	public static WebElement GetValues_ButtonClick;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtRemark_txt")
	public WebElement FDOpenRemarksField;
	
	@FindBy(id="__tab_ctl00_ctl00_CPH1_PRDCNT_TC1_tpNomineed")
	public  WebElement NomineeTab;

	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_btnNext")
	public WebElement NextButton;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_chkNominee")
	public WebElement Nominee_NotRequired_Checkbox;

	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtCust_ID_txt")
	public WebElement Operator_CustomerId_Field;

	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtRelation_txt")
	public WebElement Operator_Relation_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtRemark_txt")
	public WebElement Operator_Remark_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_btnAddOperator")
	public WebElement Operator_Add_Button;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_chkStandInst")
	public WebElement InterestTransfer_Required_Checkbox;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_ddlFromProduct_ddl")
	public WebElement SI_Product_Select_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_txtStandAcNoF_txt")
	public WebElement SI_AccNo_Field;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_txtExeFrequency_txt']")
	public WebElement SI_Frequency_Field;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_ddlMonthDay_ddl")
	public WebElement SI_FrequencyMode;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_txtStandRemarks_txt']")
	public WebElement SI_Remarks_Field;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_ddlTransMode_ddl']")
    public WebElement TransMode_Field;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSave']")
	public WebElement Save_Button;

	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID")
	public WebElement SummaryTransId;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnPrint']")
	public WebElement PrintVoucher_Button;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnPrintClose']")
	public WebElement PrintClose_Button;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnPrintCertificate']")
	public WebElement PrintCertificate_Button;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_btnPrintNomineeAcknowledgment")
	public WebElement Print_NomAckndlgment_Button;
	
	@FindBy(xpath="html/body/div[3]/div[11]/div/button")
	public WebElement FDExist_OKButton;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucSectionCaption1_topdiv']/div[1]")
	public WebElement AccOpenedSummary_Label;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_btnAutoPost']")
	public WebElement PostDebit_Button;

	//Authorise Section Details below
	@FindBy(xpath=".//*[@id='ctl00_ctl00_lnkSignout']/strong")
	public WebElement SignOut_Link;
	
	@FindBy (xpath=".//*[@id='CreateMenu']/li[6]/ul/li[3]/a")
	public WebElement CashAuthorise_Link;
		
	@FindBy (xpath=".//*[@id='CreateMenu']/li[6]/ul/li[2]/a")
	public WebElement MangrAuthorise_Link;

	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnRefresh']")
	public WebElement AuthoriseRefresh_Button;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_lblBatchID']")
	public WebElement AuthoriseGrid_BatchId;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect")
	public WebElement Cashier_CashTrans_AuthoriseGrid_CheckBox;
	
		
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']")
	public WebElement CashierAuthoriseAction_Button;
	
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect")
	public WebElement Mngr_CashTrans_AuthoriseGrid_CheckBox;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect")
	public WebElement Mngr_TransferTab_AuthoriseGrid_CheckBox;
			
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnOtherPass']")
	public WebElement MngrAuthoriseAction_Button;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_lblErrorMessage']")
	public WebElement AuthoriseSuccessUpdation_Msg ;
	
	@FindBy (xpath=".//*[@id='closetop']")
	public WebElement AuthoriseSuccessUpdation_Msg_CloseButton;
	
	@FindBy(xpath=".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer']")
	public WebElement Mngr_TransferTab_Select;
	
	
	
	public FDOpeningPage(WebDriver driver)
	{
		this.driver = driver;
		
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, SBOpeningPage.class);
	}
	
	
	
	
	public FDOpeningPage() {
		// TODO Auto-generated constructor stub
	}
	
 
   
	public void DurationMode_MonthSelect(String DurationModeTextMonths)
	{		
	    Select durationselect = new Select(DurationModeField);
		durationselect.selectByVisibleText(DurationModeTextMonths);
			
	}

	public void Roicategory_Select(WebElement RoiCategoryField)
	{		
		Select RoiSelect=Select (new Select(RoiCategoryField));
		RoiSelect.selectByIndex(1);
			
	}
    private org.openqa.selenium.support.ui.Select Select(
			org.openqa.selenium.support.ui.Select select) {
		// TODO Auto-generated method stub
		return null;
	}
    public void AutoPost_PdtGroupSelect(String Debit_PdtGroup)
	{		
    	System.out.println("test hhhhh");
	    Select pdtgrp_select = new Select(Auto_ProductGroup_Field);
	    pdtgrp_select.selectByVisibleText(Debit_PdtGroup);
			
	}
    
    public void AutoPost_PdtNameSelect(String Debit_PdtName)
   	{		
    	System.out.println("test mmmm");
   	    Select pdtname_select = new Select(Auto_ProductName_Field);
   	 System.out.println("test oooo");
   	 pdtname_select.selectByVisibleText(Debit_PdtName);
   			
   	}
    public void AutoPost_InstrType_Select(String InstrType_Text)
   	{		
   	    Select InstrType_select = new Select(Auto_InstrType_Field);
   	 InstrType_select.selectByVisibleText(InstrType_Text);
   			
   	}
    public void ClickOnNextButton()
    {
    	NextButton.click();
    }
    public void Send_CustomerDetails(String CustName)
    {
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].click();",driver.findElement(By
		//					.xpath(".//*[@id='CreateMenu']/li[2]/ul/li[1]/ul/li[3]/ul/li[1]/a")));
		executor.executeScript("arguments[0].click();",FDopeningPage);
		System.out.println("FDOpeningPageSelect executed"); 
		CustomerOrMemberAdding ObjCustmerAdd=new CustomerOrMemberAdding(driver);
		ObjCustmerAdd.Add_Customer_OR_Member(CustName);
					 
		if (driver.findElements(By.xpath("html/body/div[3]/div[11]/div/button")).size()>0)
		{  
			this.FDExist_OKButton.click();
		}
			
    }
 

   
    public void General_Tab(String FDOpenAmount,String FDOpenDuration ,String DurationModeInMonths,String FDOpenRemarks) throws IOException
    {
    	this.FDOpenAmountField.sendKeys(FDOpenAmount);
		this.FDOpenAmountField.sendKeys(Keys.TAB);
		this.FDOpenDurationField.sendKeys(FDOpenDuration);
		this.DurationMode_MonthSelect(DurationModeInMonths);
		FDOpeningPage.GetValues_ButtonClick.click();
		this.FDOpenRemarksField.sendKeys(FDOpenRemarks);
		
//		String FileName="FDOpen_GeneralTab_Data.jpeg";
//		scnshot.take_screen_shot(FolderName, FileName);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//this.NextButton.click();
    }
   
       
    public void Nominee_Tab(WebDriver driver) throws InterruptedException, IOException
    {
    	this.Nominee_NotRequired_Checkbox.click();
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	this.NextButton.click();
    }

   /* public void Operator_Tab(WebDriver driver) throws InterruptedException
    {
    	this.Operator_CustomerId_Field.sendKeys(Operator_CustomerId_Value);
    	WebDriverWait wait =new WebDriverWait(driver, 10);
    	WebElement wait_OperatorName_ToLoad=wait.until(ExpectedConditions.elementToBeClickable(Operator_Relation_Field));
    	
    	this.Operator_Relation_Field.sendKeys(Operator_Relation_Value);
    	this.Operator_Remark_Field.sendKeys(Operator_Remark_Text);
    	this.Operator_Add_Button.click();
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	this.NextButton.click();
    }*/
    
    public void SI_ProductSelect(String SI_ProductName)
	{		
	    Select SI_Product_Select = new Select(SI_Product_Select_Field);
	    SI_Product_Select.selectByVisibleText(SI_ProductName);
			
	}
    public void StandingAccDetails_Tab(String SI_ProductName,String SI_AccNo,String SI_Frequency,String SI_Remarks) throws InterruptedException, IOException
    
    	
    {
    	ScreenShot scnshot=new ScreenShot(driver);
    	this.InterestTransfer_Required_Checkbox.click();
    	this.SI_ProductSelect(SI_ProductName);
    	this.SI_AccNo_Field.sendKeys(SI_AccNo);
    	this.SI_AccNo_Field.sendKeys(Keys.TAB);
    	Thread.sleep(2000);
    	this.SI_Frequency_Field.sendKeys(SI_Frequency);	
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	WebDriverWait wait =new WebDriverWait(driver, 10);
    	WebElement wait_SI_Acc_ToLoad=wait.until(ExpectedConditions.elementToBeClickable(SI_Remarks_Field));
    	this.SI_Remarks_Field.sendKeys(SI_Remarks);
    	driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);

    }
    
    public void OnMaturity_Tab(WebDriver driver) throws InterruptedException, IOException
    {
    	
    	ClickOnNextButton();
		
	}
	public void TransMode_Select(String TransMode_Text_Cash)
	{		
	    Select TransModeSelect = new Select(TransMode_Field);
		TransModeSelect.selectByVisibleText(TransMode_Text_Cash);
			
	}
	public void switch_window()
	{
		for (String winHandle : driver.getWindowHandles()) 
		{
			driver.switchTo().window(winHandle);
		}

	}
	public void TransMode_TransMode_Transfer_AutoPost(String TransMode_Text_Transfer)
	{		
	    Select TransModeSelect = new Select(TransMode_Field);
		TransModeSelect.selectByVisibleText(TransMode_Text_Transfer);
			
	}
	
	
	public void PrintVoucherAndCertificate( ) throws InterruptedException
	{
		System.out.println("PrintVoucherAndCertificate executed"); 
		this.PrintVoucher_Button.click();
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebDriverWait wait_Voucher_ToLoad =new WebDriverWait(driver, 50);
    	wait_Voucher_ToLoad.until(ExpectedConditions.elementToBeClickable(PrintClose_Button));
		this.PrintClose_Button.click();
		Thread.sleep(1000);
		this.PrintCertificate_Button.click();
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebDriverWait wait_Certificate_ToLoad =new WebDriverWait(driver, 50);
		wait_Certificate_ToLoad.until(ExpectedConditions.elementToBeClickable(PrintClose_Button));
    	this.PrintClose_Button.click();
		
	}
	
	public void Click_on_print_and_close_preview() throws InterruptedException
	
	{
		PrintVoucher_Button.click();
        Thread.sleep(3000);
		WebDriverWait wait_Voucher_ToLoad =new WebDriverWait(driver, 50);
		wait_Voucher_ToLoad.until(ExpectedConditions.elementToBeClickable(PrintClose_Button));
		PrintClose_Button.click();
	}
	
	public void PrintNomineeAcknowldgmnt( ) throws InterruptedException
	{
		System.out.println("PrintNomineeAcknowldgmnt executed"); 
		this.Print_NomAckndlgment_Button.click();
		Thread.sleep(3000);
		WebDriverWait waitAck_ToLoad =new WebDriverWait(driver, 50);
		waitAck_ToLoad.until(ExpectedConditions.elementToBeClickable(PrintClose_Button));
		//this.PrintClose_Button.click();
	}
	
	
	public void LoginForAuthorisation(String Authorizn_User,String Authorizn_Pass) throws Throwable
	{
		this.SignOut_Link.click();
		LoginPage	objLogin = new LoginPage (driver);
		objLogin.loginToBeaconProValid(Authorizn_User,Authorizn_Pass);
	}
	
	
	public void CashTransactionAuthorisation(WebDriver driver)
	{
		
		//String AuthoriseGrid_BatchId_Text=AuthoriseGrid_BatchId.getText();
		//Cashier authorisation part
		JavascriptExecutor executorcash = (JavascriptExecutor) driver;
		executorcash.executeScript("arguments[0].click();",driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[6]/ul/li[3]/a")));
		
		this.AuthoriseRefresh_Button.click();
		this.Cashier_CashTrans_AuthoriseGrid_CheckBox.click();
		this.CashierAuthoriseAction_Button.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 0);
			
		wait.until(ExpectedConditions.
				elementToBeClickable(this.AuthoriseSuccessUpdation_Msg));
		this.AuthoriseSuccessUpdation_Msg_CloseButton.click();
					
		//Manager authorisation part
		JavascriptExecutor executorMgr = (JavascriptExecutor) driver;
		executorMgr.executeScript("arguments[0].click();",driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[6]/ul/li[2]/a")));
		this.AuthoriseRefresh_Button.click();
		
		this.Mngr_CashTrans_AuthoriseGrid_CheckBox.click();
		this.MngrAuthoriseAction_Button.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.
				elementToBeClickable(this.AuthoriseSuccessUpdation_Msg));
		this.AuthoriseSuccessUpdation_Msg_CloseButton.click();
					
		System.out.println(" CashTransactionAuthorisation executed"); 
		
	}
	
	
	public void Transfer_TransactionAuthorisation(WebDriver driver)
	{						
		//Manager authorisation part
		JavascriptExecutor executorMgr = (JavascriptExecutor) driver;
		executorMgr.executeScript("arguments[0].click();",driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[6]/ul/li[2]/a")));
		
		this.Mngr_TransferTab_Select.click();
		this.AuthoriseRefresh_Button.click();
		this.Mngr_TransferTab_AuthoriseGrid_CheckBox.click();
		this.MngrAuthoriseAction_Button.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 0);
		wait.until(ExpectedConditions.
				elementToBeClickable(this.AuthoriseSuccessUpdation_Msg));
		this.AuthoriseSuccessUpdation_Msg_CloseButton.click();
		System.out.println(" Transfer TransactionAuthorisation executed"); 
		
	}
	
	public void generate_contraEntry_for_openBatch(String debit_branch,String debit_pdtgrp,String debit_pdtname,String debit_accno,String debit_transtype,String FDOpenAmount,String instr_type,String debit_acc_operated_by,String debit_acc_transmode) throws InterruptedException
	{
		FDOpeningPage ObjFDOpen =new FDOpeningPage(driver);
		TransactionPageCommon objTransPage=new TransactionPageCommon(driver);
		JavascriptExecutor executorcash = (JavascriptExecutor) driver;
		executorcash.executeScript("arguments[0].click();",driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[3]/ul/li[1]/a")));
		objTransPage.select_branch_name(debit_branch);
		objTransPage.select_product_group(debit_pdtgrp);
		objTransPage.select_product_name(debit_pdtname);
		objTransPage.enter_account_number(debit_accno);
		objTransPage.select_trans_type(debit_transtype);
		objTransPage.click_go_button();
		objTransPage.wait_after_click_go_button();
		objTransPage.enter_transaction_amount(FDOpenAmount);
		objTransPage.Select_Instr_Type(instr_type);
		objTransPage.enter_operated_by(debit_acc_operated_by);
		objTransPage.select_trans_mode(debit_acc_transmode);
		
		String parentHandle = driver.getWindowHandle();
		objTransPage.Click_batch_search_link();
		ObjFDOpen.switch_window();
		objTransPage.Select_batch_from_batchSearch_window();
		driver.switchTo().window(parentHandle);
		
		//objTransPage.enter_remark(debit_trans_remark);
		objTransPage.click_on_submit();
		//objTransPage.click_on_print_and_close_preview();
		
		
	}
	
	
	
	
}
