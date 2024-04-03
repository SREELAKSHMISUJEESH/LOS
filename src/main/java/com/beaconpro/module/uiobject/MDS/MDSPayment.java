package com.beaconpro.module.uiobject.MDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MDSPayment 

{
	public WebDriver driver;
	
	//MDS info	**************************************************************
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_txtChittyNo_txt")
	public WebElement Enter_MDSNo_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_btnChittyNoGo")
	public WebElement Click_GetBtn_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_btnGo")
	public WebElement Click_GOBtn_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_chkPreviousBid")
	public WebElement Click_PrevousbIddetails_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_chkPendingPayment")
	public WebElement Click_PendingPaymntLIst_MDSpayment;
	
	//Subscriber info *********************************************************
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_txtSubscriberNo_txt")
	public WebElement Enter_SubscriberNo_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_btGetSubscriber")
	public WebElement Click_SubscriberGoBtn_MDSpyament;
	
	//Security info*************************************************************
	
	// jewel Securiy Block ******************************************************
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpJewels_JSF_ddlItems_ddl")
	public WebElement Select_itemname_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpJewels_JSF_txtItemQty_txt")
	public WebElement Enter_ItemQuantity_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpJewels_JSF_txtItemWeight_txt")
	public WebElement Enter_item_weight_MDSpayment;

	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpJewels_JSF_btnGoldAdd")
	public WebElement Click_AddBtn_goldsecurity_MDSpayment;
	
	//Document Security Block********************************************************
	
	@FindBy (xpath = ".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments']")
	public WebElement Click_DocumentSecuirty_tab;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments_ucDoc_ddlDocType_ddl")
	public WebElement Select_RegType_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments_ucDoc_txtRegNo_txt")
	public WebElement Enter_RgNo_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments_ucDoc_dtDocDueDate_txt")
	public WebElement Enter_DocDueDate_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments_ucDoc_btnGet")
	public WebElement click_DocGetBtn_MDSpayment;
	
	@FindBy (id = "closeDocxis")
	public WebElement Click_DocExist_OkBtn_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments_ucDoc_ddlSubRegOffice_ddl")
	public WebElement Select_SRoffice_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments_ucDoc_txtRegYear_txt")
	public WebElement EnterDocRegYear_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments_ucDoc_txtDocNo_txt")
	public WebElement EnterDocNo_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments_ucDoc_txtSurveyNo_txt")
	public WebElement EnterSurveyNo_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments_ucDoc_dtRegDate_txt")
	public WebElement EnterRagDate_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments_ucDoc_txtWorth_txt")
	public WebElement EnterWorthAmount_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments_ucDoc_txtMarketVal_txt")
	public WebElement EnterMarketValue_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpDocuments_ucDoc_btnDocAdd")
	public WebElement AddDocDetails_MDSpayment;
	
	//Security Deposit block ****************************************************************
	
	@FindBy (xpath = ".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpSecDeposit']")
	public WebElement ClickSecurityDepositTab_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpSecDeposit_SDF_ddlBranch")
	public WebElement Select_SecurityDepositBranch_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpSecDeposit_SDF_ddlProduct_ddl")
	public WebElement Select_SecurityDepositPrdctName_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpSecDeposit_SDF_txtAcNo_txt")
	public WebElement EnterDepsitsecurtyAcNo_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpSecDeposit_SDF_btnSDADD")
	public WebElement Click_DepstSecurtyAddBtn_MDSpayment;
	
	//Personal Surety Block **************************************************************
	@FindBy (xpath = ".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpPersonel']")
	public WebElement ClickSecurityPersonalTab_MDSpayment;
	
	@FindBy (xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpPersonel']/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a/img")
	public WebElement PersonalSuretyCustAdd_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpPersonel_ucPersonal_chkSalaryCert")
	public WebElement clickSalrycertfcteChckbox_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpPersonel_ucPersonal_chkPayRecovery")
	public WebElement clickpayrecvryChckbox_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpPersonel_ucPersonal_chkSelfCertificate")
	public WebElement clickSelfcrtfceChckbox_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpPersonel_ucPersonal_txtOffice_txt")
	public WebElement EnterPersnlOffcename_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpPersonel_ucPersonal_ddlState_ddl")
	public WebElement SelectPersnlState_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpPersonel_ucPersonal_ddlDistrict_ddl")
	public WebElement SelectPersnlDistrict_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpPersonel_ucPersonal_ddlPost_ddl")
	public WebElement SelectPersnlPost_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpPersonel_ucPersonal_txtBasicPay_txt")
	public WebElement EnterBasicPay_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpPersonel_ucPersonal_txtNetSalary_txt")
	public WebElement EnterNetSalry_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpPersonel_ucPersonal_btnSPAdd")
	public WebElement ClickAddpersnlsrtyBtn_MDSpayment;
	
	//MDS Security Block ***************************************************************
	@FindBy (xpath = ".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpChitty']")
	public WebElement ClickMDSSecurityTab_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpChitty_CS_txtChittyNo_txt")
	public WebElement EnterMDSNoMDSSecurity_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpChitty_CS_btnChittyNoGo")
	public WebElement ClickGetBtnMDSSecurity_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpChitty_CS_txtSubscription_txt")
	public WebElement EnterSubNoMDSSecrty_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_tbSecurity_tpChitty_CS_btnCSGo")
	public WebElement ClickGBtnMDSSecrty_MDSpayment;
	
	//Transaction Mode Block ***************************************************************
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionApprovingInfo_txtTrnAmount_txt")
	public WebElement MDSPaymentAmount;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionApprovingInfo_ddlTransactionMode_ddl")
	public WebElement SelecrTranMode_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionApprovingInfo_btnAutoPost")
	public WebElement ClickAutopostingBtn_MDSpayment;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement ClickSubmit_MDSpayment;
	
	public void MDSNo_MDSpayment (String MDSNo)
	
	{
		Enter_MDSNo_MDSpayment.sendKeys(MDSNo);
	}
	
	public void GetBtn_MDSpayment()
	
	{
		Click_GetBtn_MDSpayment.click();
	}
	
	public void GOBtn_MDSpayment()
	
	{
		Click_GOBtn_MDSpayment.click();
	}

	public void PrevousbIddetails_MDSpayment()
	
	{
		Click_PrevousbIddetails_MDSpayment.click();
	}
	
	public void PendingPaymntLIst_MDSpayment()
	
	{
		Click_PendingPaymntLIst_MDSpayment.click();
	}
	
	public void  SubscriberNo_MDSpayment(String SubscriberNo)
	
	{
		 Enter_SubscriberNo_MDSpayment.sendKeys(SubscriberNo);
	}
	
	public void  SubscriberGoBtn_MDSpyament()
	
	{
		Click_SubscriberGoBtn_MDSpyament.click();
	}
	
	public void  Itemname_MDSpayment()
	
	{
		WebDriverWait wait = new WebDriverWait (driver ,60);
		wait.until(ExpectedConditions.elementToBeClickable(Click_AddBtn_goldsecurity_MDSpayment));
		
		Select Itmename = new Select (Select_itemname_MDSpayment);
		Itmename.selectByVisibleText("CHAIN");
	}
	
	public void  ItemQuantity_MDSpayment()
	
	{
		Enter_ItemQuantity_MDSpayment.sendKeys("5");
	}
	
	public void  item_weight_MDSpayment()
	
	{
		Enter_item_weight_MDSpayment.sendKeys("100");
	}
	
	public void  AddBtn_goldsecurity_MDSpayment()
	
	{
		Click_AddBtn_goldsecurity_MDSpayment.click();
	}
	
	public void  DocumentSecuirty_tab()
	
	{
		WebDriverWait wait1 = new WebDriverWait (driver ,60);
		wait1.until(ExpectedConditions.elementToBeClickable(Click_DocumentSecuirty_tab));
		
		Click_DocumentSecuirty_tab.click();
	}
	
	public void  RegType_MDSpayment()
	
	{
		Select Regtype = new Select (Select_RegType_MDSpayment);
		Regtype.selectByVisibleText("Document");
	}
	
	public void  RgNo_MDSpayment()
	
	{
		Enter_RgNo_MDSpayment.sendKeys("15");
	}
	
	public void  DocDueDate_MDSpayment()
	
	{
		Enter_DocDueDate_MDSpayment.click();
		Enter_DocDueDate_MDSpayment.sendKeys("15102050");
		Enter_DocDueDate_MDSpayment.sendKeys(Keys.TAB);
	}
	
	public void  DocGetBtn_MDSpayment()
	
	{
		click_DocGetBtn_MDSpayment.click();
		
	}
	
	public void  DocExist_OkBtn_MDSpayment() throws InterruptedException
	
	{	Thread.sleep(5000);
		Click_DocExist_OkBtn_MDSpayment.click();
	}
	
	public void  SRoffice_MDSpayment()
	
	{
		Select Sroffice = new Select (Select_SRoffice_MDSpayment);
		Sroffice.selectByVisibleText("Calicut");
	}
	
	public void  DocRegYear_MDSpayment()
	
	{
		EnterDocRegYear_MDSpayment.sendKeys("10102010");
	}
	
	public void  DocNo_MDSpayment()
	
	{
		EnterDocNo_MDSpayment.sendKeys("10");
		EnterDocNo_MDSpayment.sendKeys(Keys.TAB);
	}
	
	public void  SurveyNo_MDSpayment() throws InterruptedException
	
	{

		Thread.sleep(5000);
		EnterSurveyNo_MDSpayment.sendKeys("3526");
	}
	
	public void  RagDate_MDSpayment()
	
	{
		EnterRagDate_MDSpayment.click();
		EnterRagDate_MDSpayment.sendKeys("10072015");
		EnterRagDate_MDSpayment.sendKeys(Keys.TAB);
	}
	
	public void  WorthAmount_MDSpayment(String WorthAmount)
	
	{
		EnterWorthAmount_MDSpayment.sendKeys(WorthAmount);
	}
	
	public void  MarketValue_MDSpayment(String MaketValue)
	
	{
		EnterMarketValue_MDSpayment.sendKeys(MaketValue);
	}
	
	public void  DocDetails_MDSpayment ()
	
	{
		for (int i =0 ; i<10 ; i++)
		{
			AddDocDetails_MDSpayment.click();
			break;
		}
		
	}
	
	public void  SecurityDepositTab_MDSpayment ()
	
	{
		ClickSecurityDepositTab_MDSpayment.click();
	}
	
	public void  SecurityDepositBranch_MDSpayment ()
	
	{
		Select secBrName = new Select (Select_SecurityDepositBranch_MDSpayment) ;
		secBrName.selectByVisibleText("MAIN BRANCH");
	
	}
	
	public void  SecurityDepositPrdctName_MDSpayment ()
	
	{
		Select secBrName = new Select (Select_SecurityDepositPrdctName_MDSpayment) ;
		secBrName.selectByVisibleText("ORDINARY FD");
	}
	
	public void  DepsitsecurtyAcNo_MDSpayment (String SecAcno)
	
	{
		EnterDepsitsecurtyAcNo_MDSpayment.sendKeys(SecAcno);
	}
	
	public void  DepstSecurtyAddBtn_MDSpayment()
	
	{
		Click_DepstSecurtyAddBtn_MDSpayment.click();
	}
	
	public void  SecurityPersonalTab_MDSpayment()
	
	{
		ClickSecurityPersonalTab_MDSpayment.click();
	}
	
	public void  PersonalSuretyCustAdd_MDSpayment()
	
	{
		PersonalSuretyCustAdd_MDSpayment.click();
	}
	
	public void  SalrycertfcteChckbox_MDSpayment()
	
	{
		clickSalrycertfcteChckbox_MDSpayment.click();
	}
	
	public void  payrecvryChckbox_MDSpayment()
	
	{
		clickpayrecvryChckbox_MDSpayment.click();
	}
	
	public void  SelfcrtfceChckbox_MDSpayment()
	
	{
		clickSelfcrtfceChckbox_MDSpayment.click();
	}
	
	public void  PersnlOffcename_MDSpayment()
	
	{
		EnterPersnlOffcename_MDSpayment.sendKeys("Sesame");
	}
	
	public void  PersnlState_MDSpayment()
	
	{
		Select State = new Select (SelectPersnlState_MDSpayment);
		State.selectByVisibleText("KERALA");
		
	}
	
	public void  PersnlDistrict_MDSpayment()
	
	{
		Select District = new Select (SelectPersnlDistrict_MDSpayment);
		District.selectByVisibleText("MALAPPURAM");
		
	}
	
	public void  PersnlPost_MDSpayment()
	
	{
		Select post = new Select (SelectPersnlPost_MDSpayment);
		post.selectByVisibleText("Kodinhi");
		
	}
	
	public void  BasicPay_MDSpayment()
	
	{
		EnterBasicPay_MDSpayment.sendKeys("10000");
	}
	
	public void  NetSalry_MDSpayment()
	
	{
		EnterNetSalry_MDSpayment.sendKeys("10000");
	}
	
	public void  AddpersnlsrtyBtn_MDSpayment()
	
	{
		ClickAddpersnlsrtyBtn_MDSpayment.click();
	}
	
	public void  MDSSecurityTab_MDSpayment()
	
	{
		ClickMDSSecurityTab_MDSpayment.click();
	}
	
	public void  MDSNoMDSSecurity_MDSpayment(String MDSNo)
	
	{
		EnterMDSNoMDSSecurity_MDSpayment.sendKeys(MDSNo);
	}
	
	public void  GetBtnMDSSecurity_MDSpayment()
	
	{
		ClickGetBtnMDSSecurity_MDSpayment.click();
	}
	
	public void  SubNoMDSSecrty_MDSpayment(String SubNo)
	
	{
		EnterSubNoMDSSecrty_MDSpayment.sendKeys(SubNo);
	}
	
	public void  GOBtnMDSSecrty_MDSpayment()
	
	{
		ClickGBtnMDSSecrty_MDSpayment.click();
	}
	
	public void  TranMode_MDSpayment(String TrnMode)
	
	{
		Select trnmode = new Select (SelecrTranMode_MDSpayment);
		trnmode.selectByVisibleText(TrnMode);
	}
	
	public void  AutopostingBtn_MDSpayment()
	
	{
		ClickAutopostingBtn_MDSpayment.click();
	}
	
	public void  ClickSubmit_MDSpayment()
	
	{
		ClickSubmit_MDSpayment.click();
	}
	
	public MDSPayment (WebDriver driver)
	
	{
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	
	
}





