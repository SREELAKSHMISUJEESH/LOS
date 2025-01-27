package com.beaconpro.module.uiobject.acopening;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SBOpeningPage {

	WebDriver driver;
	
	@FindBy(id = ".//*[@id='ctl00_lnkSignout']/strong")
	public WebElement SignOut;

	/************** SB Opening Page *****************/
	@FindBy(xpath = ".//*[@id='CreateMenu']/li[2]/ul/li[1]/ul/li[1]/ul/li[1]/a")
	public WebElement SB_opening_link;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID")
	public WebElement save_transid;

	@FindBy(xpath = ".//*[@id='tblCustList']/tbody/tr[2]/td[5]")
	public WebElement Save_BatchID;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt']")
	public WebElement edit_transid;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_trCustID']/td[2]/table/tbody/tr/td[2]/a/img")
	public WebElement click_cust_search;

	// customer search edits
	@FindBy(id = "PopQuick1_txtName")
	public WebElement customer_name;

	@FindBy(id = "PopQuick1_txtCustID")
	public WebElement customer_id;

	@FindBy(xpath = ".//*[@id='PopQuick1_btnSearch']")
	public WebElement click_on_search_button;

	@FindBy(xpath = ".//*[@id='PopQuick1_lst_ctrl0_linkSelect']")
	public WebElement wait_for_customer_grid;

	@FindBy(id = "PopQuick1_lst_ctrl0_linkSelect")
	public WebElement select_cust_from_grid;
	// customer search edits

	@FindBy(xpath = "html/body/div[3]/div[2]/b")
	public WebElement ORDINARY_SB_Account_Exists_gettext;

	@FindBy(xpath = "html/body/div[3]/div[11]/div/button")
	public By exists_popup_ok_btn;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer']")
	public WebElement cust_add;

	@FindBy(xpath = ".//*[@id='tblCustList']/tbody/tr[1]/td[1]")
	public WebElement cust_grid;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtAcOpeningAmount_txt']")
	public WebElement Amount_field;

	@FindBy(xpath = "html/body/div[3]/div[11]/div/button")
	public WebElement SB_ac_exists_popup_ok_btn;

	@FindBy(xpath = ".//*[@id='tab1']/tbody/tr[2]/td[3]")
	public WebElement Body;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_btnGetROI']")
	public WebElement Get_values_btn;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtMinimumBalance_txt']")
	public WebElement Min_balance_field;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtRemark_txt")
	public WebElement Txt_Remark;

	@FindBy(id = "__tab_ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee")
	public WebElement Nominee_tab;
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_chkNominee']")
	public WebElement Nominee_checkbox;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnNext")
	public WebElement Next_button;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_ddlTransMode_ddl']")
	public WebElement Trans_mode_dropdown;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_txtSpInstruction_txt")
	public WebElement Txt_SpInstruction;	

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSave']")
	public WebElement Save_button;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnPrint")
	public WebElement print_button;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_btnAutoPost']")
	public WebElement post_debit_btn;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_tdAcNo")
	public WebElement Ac_No;
	
	/********************************************************/

	/******************* Autoposting *************************/

	@FindBy(xpath = ".//*[@id='txtChildAcNo_txt']")
	public WebElement AcNo_field_in_autoposting_window;

	@FindBy(id = "ddlProductGroup_ddl")
	public WebElement productgroup_field_in_Autoposting_window;

	@FindBy(id = "ddlProductName_ddl")
	public WebElement productname_field_in_Autoposting_window;

	@FindBy(id = "txtDisplayName_txt")
	public WebElement Displayname_field_in_Autoposting_window;

	@FindBy(id = "ddlInstrType_ddl")
	public WebElement InstrType_field_in_Autoposting_window;

	@FindBy(id = "txtOutBalance_txt")
	public WebElement Avail_bal_field_in_Autoposting_window;

	@FindBy(id = "txtAmount_txt")
	public WebElement Amount_field_in_Autoposting_window;

	@FindBy(xpath = ".//*[@id='UpdatePanel1']/table/tbody/tr[3]/td[5]")
	public WebElement Frame_in_autoposting_window;

	@FindBy(id = "btnAdd")
	public WebElement Add_Button_in_Autoposting_window;

	@FindBy(id = "btnSubmit")
	public WebElement Submit_Button_in_Autoposting_window;

	@FindBy(xpath = "html/body/div[2]/div[11]/div/button[1]")
	public WebElement ok_btn_in_batch_opening_popup;

	@FindBy(id = "ddlBranch_ddl")
	public WebElement Branch_dropdown_in_autoposting_window;

	@FindBy(xpath = ".//*[@id='lstContraEntry_ctrl0_lnkRemove']/img")
	public WebElement Close_btn_in_Autoposting_window_cust_grid;

	/***********************************/
	
	@FindBy(id = "lstBatch_ctrl0_linkSelect")
	public WebElement Batch_select;

	// This is a constructor, as every page need a base driver to find web
	// elements
	public SBOpeningPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	/******************* Important code *****************/
	public void ExplicitWait_elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void ExplicitWait_visibilityOf(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void open_window(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void Selection_from_dropdown(WebElement element, String index) {
		Select Select9 = new Select(element);
		Select9.selectByVisibleText(index);
	}
	
	/*****************************************************/

}
