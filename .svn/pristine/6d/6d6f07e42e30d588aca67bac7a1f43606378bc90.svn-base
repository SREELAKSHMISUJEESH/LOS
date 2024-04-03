package com.beaconpro.module.uiobject.transaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GLTransactionPage {
	
	WebDriver driver;
	
	// GL Account Info selection Part
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_ddlBranch_ddl")
	public WebElement branch;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_txtGLCode_txt")
	public WebElement glaccode;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_ddlGLName_ddl")
	public WebElement glacname;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_ddlTrnType")
	public WebElement transtype;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_btnGo")
	public WebElement btn_go;
	
	//Data Enter Part
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtTrnAmount_txt")
	public WebElement transamount;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_ddlTransactionMode_ddl")
	public WebElement Transmode;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtPartyName_txt")
	

	public WebElement partyname;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtRemarks_txt")
	public WebElement particulars;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_btnSubmit")
	public WebElement btn_submit;
	
	
	//Transfer selection
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_btnAutoPost")
	public WebElement post_crordrr;
	
	@FindBy(xpath=".//*[@id='linkBatch']")
	public WebElement batchsearch;
	

	
	
	/******************* Autoposting_PostDebit_popup ***************************/
	
	//GL Code
	
	@FindBy(id="ddlTrnsBased_ddl")
	public WebElement trans_based;
	
	@FindBy(id="txtRemarks_txt")
	public WebElement ap_remarks;
	
	@FindBy(id="txtParticulars_txt")
	public WebElement ap_particulars;
	
	@FindBy(id="ddlBranchForGLHead_ddl")
	public WebElement trans_branch;
		
	@FindBy(id="txtGLAcCode_txt")
	public WebElement trans_glacno;
	
	@FindBy(id="txtAmountForGLHead_txt")
	public WebElement trans_glacamt;
	
	@FindBy(id="btnAddGLAcHead")
	public WebElement btn_glacadd;
	
	@FindBy(id="ddlGLName_ddl")
	public WebElement trans_glacname;
		
	
	//Account
	
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

	@FindBy(id = "txtOutBalance_txt")
	public WebElement Txt_AvailBalance;

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
	
	@FindBy(xpath=".//*[@id='aspnetForm']/div[12]/div[3]/div/button[1]")
	public WebElement batch_open_ok;
	
	
	public void switch_window() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	
	public GLTransactionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void dropdown_selection(WebElement element,String str)
	{
			Select dropdown=new Select(element);
			dropdown.selectByVisibleText(str);
	 
	}
	
	public void explicitwait_elementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void explicitwait_elementToBeVisible(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void explicitwait_TextToBePresent(WebElement element,String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, str));
	}
	

	
	
	
}
