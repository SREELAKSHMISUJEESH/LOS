package com.beaconpro.module.uiobject.transaction;

/********************************************************************************************************************	
Created By   :  Yadhu 
Created On	 :	02/06/2016
Purpose	     :	collection importing page objects repository
-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beaconpro.module.uiobject.common.MenuList;

public class CollectionImportingPage {

	WebDriver driver;

	MenuList objML;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtAgentCode_txt")
	public WebElement txt_AgentCode;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ddlAgentName_ddl")
	public WebElement ddl_AgentName;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnImport")
	public WebElement btn_Import;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_AGV_ddlBranch_ddl")
	public WebElement ddl_Branch;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_AGV_ddlProductGroup_ddl")
	public WebElement ddl_ProductGroup;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_AGV_ddlProduct1_ddl")
	public WebElement ddl_ProductType;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_AGV_txtGPBAcNo_txt")
	public WebElement Br_pro_AcNo;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_AGV_txtAcNo_txt")
	public WebElement txt_AcNo;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_AGV_txtInstAmount_txt")
	public WebElement txt_InstAmount;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_AGV_txtAmount_txt")
	public WebElement txt_Amount;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_AGV_btnAdd")
	public WebElement btn_Add;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_AGV_btnClear")
	public WebElement btn_Clear;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_dtCollection_txt")
	public WebElement CollectionDate;

	@FindBy(xpath = ".//*[@id='tbAgent']/tbody/tr[2]/td[4]")
	public WebElement AcNo_In_Grid;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucAgentInfo_ddlTransactionMode_ddl")
	public WebElement ddl_TransactionMode;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucAgentInfo_btnAutoPost")
	public WebElement btn_AutoPost;

	@FindBy(id = ".//*[@id='linkBatch']/img")
	public WebElement linkBatch;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucAgentInfo_txtRemarks_txt")
	public WebElement txt_Remarks;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement btn_Submit;
	
	@FindBy(xpath = ".//*[@id='aspnetForm']/div[11]/div[3]/div/button[1]")
	public WebElement btn_Ok_BatchOpenedPopup;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID")
	public WebElement Transid_summary;
	
	@FindBy(id = "lblAmounttInFigures")
	public WebElement TransAmount ;
	

	public CollectionImportingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ExplicitWait_elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void ExplicitWait_textToBePresentInElement(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void Selection_from_dropdown(WebElement element, String index) {
		Select Select9 = new Select(element);
		Select9.selectByVisibleText(index);
	}
}
