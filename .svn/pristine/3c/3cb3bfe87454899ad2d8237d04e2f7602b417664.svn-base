package com.beaconpro.module.uiobject.MDS;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class MDSApplication {

	public WebDriver driver;
	
	@FindBy (id = "ctl00_CPH1_txtChittyNo_txt")
	public WebElement Enter_MDS_No_MDSApplctn;
	
	@FindBy (id = "ctl00_CPH1_btnChittyNoGet")
	public WebElement Get_Btn_MDSApplicatn;
	
	@FindBy (xpath = ".//*[@id='ctl00_CPH1_uppnltot']/div[1]/table/tbody/tr[5]/td[2]/table/tbody/tr/td[2]/a/img")
	public WebElement Customr_Search_MDSApplictn;
	
	@FindBy (id = "ctl00_CPH1_btnAddCustomer1")
	public WebElement Customer_AddBtn_MDSApplication;
	
	@FindBy (id ="ctl00_CPH1_tbLoan_tpNominee_chkNominee")
	public WebElement NomineeNotRequiredChkBox;
	
	@FindBy (xpath = ".//*[@id='__tab_ctl00_CPH1_tbLoan_tpStandInst']")
	public WebElement RepaymentTab_MDSApplicatn;
	
	@FindBy (id = "ctl00_CPH1_tbLoan_tpStandInst_chkStandInst")
	public WebElement Click_RepymntChckBox_MDSApplictn;
	
	@FindBy (id ="ctl00_CPH1_tbLoan_tpStandInst_ucStandInst_ddlBranch")
	public WebElement RepayMntAc_Branch;
	
	@FindBy (id = "ctl00_CPH1_tbLoan_tpStandInst_ucStandInst_ddlFromProduct_ddl")
	public WebElement Repay_Prduct_Selectin_MDSApplictn;
	
	@FindBy (id = "ctl00_CPH1_tbLoan_tpStandInst_ucStandInst_txtStandAcNoF_txt")
	public WebElement Repay_AccNo_MDSApplicatn;
	
	@FindBy (id ="ctl00_CPH1_txtInstallmentAmount_txt")
	public WebElement MDS_Installment_Amount;
	
	@FindBy (id = "ctl00_CPH1_LIF1_ddlTransactionMode_ddl")
	public WebElement TransaMode_MDSApplicatn;
	
	@FindBy (id = "ctl00_CPH1_LIF1_btnAutoPost")
	public WebElement Click_MDS_application_postdebit;
	
	@FindBy (id = "ctl00_CPH1_btnSubmit")
	public WebElement Submit_MDSApplicatn;
	
	
	public void Enter_MDS_No (String MDSNo)
	
	{
		Enter_MDS_No_MDSApplctn.sendKeys(MDSNo);
	}
	
	public void Click_GetBtn_MDSApp ()
	
	{
		Get_Btn_MDSApplicatn.click();
	}
	
	public void Click_customer_Search_MDSApp ()
	
	{	
		Customr_Search_MDSApplictn.click();
	}
	
	public void Click_Add_New_Subscriber_MDSApp ()
	
	{
		Customer_AddBtn_MDSApplication.click();
	}
	
	public void Click_NomineeNotRequired_CheckBox ()
	
	{
		NomineeNotRequiredChkBox.click();
	}
	
	public void Click_RepaymentTab_MDSApplicatn ()
	
	{
		RepaymentTab_MDSApplicatn.click();
	}
	
	public void Click_RepaymentCheckBox_MDSApplicatn ()
	
	{
		Click_RepymntChckBox_MDSApplictn.click();
	}
	
	public void Select_RepaymentproductBranch_MDSApplicatn (String RepyProductNameBranch)
	
	{
		RepayMntAc_Branch.sendKeys(RepyProductNameBranch);
	}
	
	public void Select_Repaymentproduct_MDSApplicatn (String RepyProductName)
	
	{
		Repay_Prduct_Selectin_MDSApplictn.sendKeys(RepyProductName);
	}
	
	public void Enter_RepaymentAc_MDSApplicatn (String RepyAccount)
	
	{
		Repay_AccNo_MDSApplicatn.sendKeys(RepyAccount);
	}
	
	public void Select_TransMode_MDSApplicatn (String MDSApplctnTrnMode) throws InterruptedException
	
	{
		Thread.sleep(8000);
		Select MDSapplctnTrnmode = new Select (TransaMode_MDSApplicatn);
		MDSapplctnTrnmode.selectByVisibleText(MDSApplctnTrnMode);
	
			
	}
	
	public void Click_MDS_Aplication_Postdebit ()
	
	{
		Click_MDS_application_postdebit.click();
	}
	
	public void Click_Submit_MDSApplicatn ()
	
	{
		Submit_MDSApplicatn.click();
		
	}
	
	public MDSApplication (WebDriver driver)
	
	{
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	
}
