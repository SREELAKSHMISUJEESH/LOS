package com.beaconpro.module.uiobject.acopening;

import java.awt.RenderingHints.Key;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ConversionUtils;

import com.beaconpro.module.uiobject.common.ObjLoanAccountInfoTab;
import com.beaconpro.module.uiobject.common.TransactionModeSelection;

import java.util.Random;

public class ObjOtherLoanOpening 
{


	public WebDriver driver;
	public static String OL_Eligible_Amt;
	//public ObjLoanAccountInfoTab ObjLoAcInfo = new ObjLoanAccountInfoTab(driver);
	
	public String GetBatchId;
	
	@FindBy (id="PopQuick1_txtName")
	public WebElement custname;
		
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_trCustID']/td[2]/table/tbody/tr/td[2]/a/img")
	public WebElement ClickCustomerSearch;
	
	@FindBy (xpath=".//*[@id='close']")
	public WebElement KYC_Not_Completed_PopUp;
	
	@FindBy (xpath=".//*[@id='PopQuick1_txtName']")
	public WebElement OperatorSearch;
	
	@FindBy (xpath=".//*[@id='PopQuick1_btnSearch']")
	public WebElement PopQuickOperatorADDBtn;
	
	@FindBy (xpath=".//*[@id='PopQuick1_lst_ctrl0_linkSelect']")
	public WebElement OperatorLinkSelect;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtRelation_txt']")
	public WebElement OperatorRelation;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_btnAddOperator']")
	public WebElement AddOperator; 
	
	@FindBy (id="PopQuick1_btnSearch")
	public WebElement PopQuick1_btnSearch_Click;
	
	@FindBy (id="PopQuick1_lst_ctrl0_linkSelect")
	public WebElement CustlinkSelect;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer")
	public WebElement CustBtnadd;
	
	
	@FindBy (xpath="/html/body/form/div[12]/div[3]/div/button[1]")
	public WebElement OL_Enter_LOS_Number_Popup_ObBtn;
	
	@FindBy (xpath =".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_ddlSubRegOffice_ddl']")
	public WebElement OL_Sec_SROffice;


	@FindBy (xpath =".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_txtRegYear_txt']")
	public WebElement OL_Sec_RegYear;

	@FindBy (xpath =".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_txtDocNo_txt']")
	public WebElement OL_Sec_DocNo;


	@FindBy (xpath =".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_txtSurveyNo_txt']")
	public WebElement OL_SurveyNo;


	@FindBy (xpath =".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_dtRegDate_txt']")
	public WebElement OL_Sec_RegDate;

	@FindBy (xpath =".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_txtWorth_txt']")
	public WebElement OL_Sec_Worth;
	
	// Security Tab
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_btnAddCustDoc']")
	public WebElement OL_Sec_CustAddBtn;
	
	@FindBy (xpath =".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity']")
	public WebElement OL_Sec_Tab;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_txtMarketVal_txt']")
	public WebElement OL_Sec_MarketVal; 
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_btnDocAdd']")
	public WebElement OL_Sec_Doc_AddBtn;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_dtDueDate_txt']")
	public WebElement EcsMarkEffectfrom;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_txtEligibility_txt']")
	public WebElement Ol_Eligible_AmountField;

	// Other Loan Nominee
	
	@FindBy (xpath=".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee']")
	public WebElement OL_Nom_Tab;
	
	@FindBy(id=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_UPC']/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a/img")
	public WebElement Ol_Nom_PopUp;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_chkNominee']")
	public WebElement OL_Nom_CheckBox;

	//Loan Details Tab
	
	@FindBy(xpath=".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet']")
	public WebElement  OL_LoanDetail_Tab;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtSactAmt_txt']")
	public WebElement OL_LoanDetail_SanctionAmtField;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtDuration_txt']")
	public WebElement  OL_LoanDetail_DurationField;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ddlDurationMode_ddl']")
	public WebElement  OL_LoanDetail_DurationModeField;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_btnGetROI']")
	public WebElement OL_LoanDetail_GetValueBtn;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtInstallmentFrequency_txt']")
	public WebElement OL_LoanDetail_InstallmentFrequency_txt;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ddlDurationMode_ddl']")
	public WebElement OL_LoanDetail_InstallmentDurationMode;
	
	@FindBy(xpath="	.//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtMortPeriod_txt']")
	public WebElement OL_LoanDetail_MortPeriod_txt;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_btnSlab']")
	public WebElement OL_LoanDetail_SlabBtn;
		
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtPayAmount_txt']")
	public WebElement OL_LoanDetail_PayAmount_txt;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txt192']")
	public WebElement OL_LoanDetail_FormFee_txt;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txt194']")
	public WebElement OL_LoanDetail_RiskFund_txt;
	
	
	
	
	
	public void Addcustname(String Strcustname)
	{
		custname.sendKeys(Strcustname);
	}
	
	public void Clicksearch()
	{
		PopQuick1_btnSearch_Click.click();
	}
	
	public void linkselection()
	{
		CustlinkSelect.click();
	}
	
	public void CustAdd()
	{
		CustBtnadd.click();
	}
	
	public void Click_OL_Open_LOS_Popup()
	{
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(OL_Enter_LOS_Number_Popup_ObBtn));*/
		
		OL_Enter_LOS_Number_Popup_ObBtn.click();
	}
	
	/*public void Loan_AccountIfo()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(OL_Enter_LOS_Number_Popup_ObBtn));
		
		ObjLoAcInfo.Select_Loan_Purpose();
	}
*/
/*
	public void GetValueBtn()
	{
		GetValueBtn.click();
	}
	public void LogBtn(){
		IntLogBtn.click();
	}
	public void NomineeTabClick(){
		NomineeTab.click();
	}
	public void NomCheckBox(){
		NomCheckBox.click();
	}
	public void operatorTabclick(){
		OpeartorTab.click();
	}
	public void Goto_operator_Adding_Window(){
		Click_Operator_Add_Button.click();
	}
	*/
	
	public ObjOtherLoanOpening(WebDriver driver) 
	{
		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);
	}

	public void switchWindow(WebDriver driver) 
	{

		for (String winHandle : driver.getWindowHandles()) 
		{
			driver.switchTo().window(winHandle);
		}
	}
		
	public void Open_OL_OpeningWindow()
	{

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",
		driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[2]/ul/li[2]/ul/li[3]/ul/li[1]/a")));
		//driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[9]/ul/li[4]/ul/li[5]/a"))); // ECS MArk
		
		System.out.println("Other Loan Opening Page Loaded succesfully");
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(this.ClickCustomerSearch));
	}
	
	public void KYC_Not_Completed_Warning_Msg_PopUp_Click()
	{
		
		if (driver.findElements(By.xpath(".//*[@id='close']")).size() > 0) 
		{
			this.KYC_Not_Completed_PopUp.click();
		}
	}
	
	public void OL_Open_LOS_Popup()
	{
		
		
		System.out.println("OL_Open_LOS_Popup Loaded");
		
		if (driver.findElements(By.xpath("/html/body/form/div[12]/div[3]/div/button[2]"))
				.size() > 0) 
		{
			System.out.println("Find The Pop Up message");
			
				OL_Enter_LOS_Number_Popup_ObBtn.click();
				
				System.out.println("succesfully clicked on the LOS Popup message");
		}
	}
	
	public void OL_Sec_Tab() throws InterruptedException
	{
		
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		ObjOtherLoanOpening objOLOpengBase = new ObjOtherLoanOpening (driver);
		
		OL_Sec_Tab.click();
		OL_Sec_CustAddBtn.click();
		
		OL_Sec_SROffice.sendKeys("Calicut");
		OL_Sec_RegYear.sendKeys("2015");
		OL_Sec_DocNo.sendKeys("14");
		
		OL_Sec_DocNo.sendKeys(Keys.TAB);

		//wait.until(ExpectedConditions.elementToBeClickable(objOLOpengBase.OL_Sec_RegDate));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		OL_SurveyNo.sendKeys("14");
		OL_Sec_RegDate.click();
		OL_Sec_RegDate.sendKeys("01012015");
		OL_Sec_Worth.sendKeys("10000000000");
		OL_Sec_MarketVal.sendKeys("10000000000");
		OL_Sec_Doc_AddBtn.click();
		
		Thread.sleep(3000);
		
		OL_Eligible_Amt = Ol_Eligible_AmountField.getAttribute("value");
		
		System.out.println("Security Added Succesfully");
	}
	
	public void OL_Nom_Tab() throws InterruptedException
	{
		String str []= {"a","b","c","d"};
//		Thread.sleep(2000);
		OL_Nom_Tab.click();
		OL_Nom_CheckBox.click();
//		Ol_Nom_PopUp.click();
		
		System.out.println("Nominee Handled Succesfully");
		
	}
	public void OL_LoanDetails_Tab() throws InterruptedException
	{
		
		
		OL_LoanDetail_Tab.click();
		
		float SanctionAmt = Float.parseFloat(OL_LoanDetail_SanctionAmtField.getAttribute("value"));
		System.out.println(SanctionAmt);
		
		OL_LoanDetail_SanctionAmtField.sendKeys("12000");					
		OL_LoanDetail_DurationField.sendKeys("12");				
		OL_LoanDetail_DurationModeField.sendKeys("mon");
		Thread.sleep(3000);
		OL_LoanDetail_GetValueBtn.click();	
		Thread.sleep(3000);
		OL_LoanDetail_InstallmentFrequency_txt.clear();
		Thread.sleep(3000);
		OL_LoanDetail_InstallmentFrequency_txt.sendKeys("1");	
		Thread.sleep(5000);
		OL_LoanDetail_InstallmentDurationMode.sendKeys("Mon");	
		Thread.sleep(5000);
		OL_LoanDetail_MortPeriod_txt.sendKeys("1");	
		Thread.sleep(5000);
		//OL_LoanDetail_SlabBtn.click();						
		//OL_LoanDetail_PayAmount_txt.		
		OL_LoanDetail_FormFee_txt.clear();
		Thread.sleep(5000);
		OL_LoanDetail_FormFee_txt.sendKeys("10");	
		Thread.sleep(5000);
		OL_LoanDetail_RiskFund_txt.clear();
		Thread.sleep(5000);
		OL_LoanDetail_RiskFund_txt.sendKeys("15");	
		Thread.sleep(5000);
	}

	public void Fill_Loan_AcInfo() 
	{
		ObjLoanAccountInfoTab ObjLoAcInfo = new ObjLoanAccountInfoTab(driver);
		
		ObjLoAcInfo.Select_Loan_Purpose("CONSUMPTION");
		ObjLoAcInfo.Select_Borr_Category("Other");
		ObjLoAcInfo.Select_AcInfo_Class("Other");
		ObjLoAcInfo.Select_Spl_Category("OBC");
		
		System.out.println("Account Info Filled Succesfully");
		
	}
}
