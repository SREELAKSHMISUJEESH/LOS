package com.beaconpro.module.uiobject.common;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/*****************************************************************************************************************
 *Created By :	Sanoop.K
 *Created On :	16/04/2016 
 *Purpose	 :	Add Repayment Account details In Account opening page for Deposit only
 *****************************************************************************************************************/


public class RepaymentAccountAdding {

	public WebDriver driver ;
	
	@FindBy (xpath=".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst']")
	public WebElement Click_Repayment_Account;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_chkStandInst']")
	public WebElement Opening_Repayment_CheckBox;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_ddlFromProduct_ddl']")
	public WebElement Repaymen_Product_Selection;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_txtStandAcNoF_txt']")
	public WebElement Enter_Repaymnt_AcNo;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_txtExeFrequency_txt']")
	public WebElement Repaymnt_Frequency;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_ddlMonthDay_ddl']")
	public WebElement Repaymnt_Frequency_DurationMode;
	
	
	public void Click_Repayment_Account_Tab () {

		Click_Repayment_Account.click();

		}
	
	public void Tick_Opening_Repayment_CheckBox() {

		Opening_Repayment_CheckBox.click();

		}
	
	public void  Select_Repaymen_Product(String Repayment_Product) {

		Select RDRepaymentPrdct = new Select (Repaymen_Product_Selection);
		RDRepaymentPrdct.selectByVisibleText(Repayment_Product);

		}
	
	public void  Enter_Repayment_AcNo(String RepaymentAccount) {

		Enter_Repaymnt_AcNo.sendKeys(RepaymentAccount);

		}
	public void  Enter_Repayment_frequency(String RepaymentFrequency) {

		Repaymnt_Frequency.sendKeys(RepaymentFrequency);

		}
	
	public void  Enter_Repayment_frequency_Mode(String FrequnceyDurationMode) {

		
		Select RDRepaymentPrdct = new Select (Repaymnt_Frequency_DurationMode);
		RDRepaymentPrdct.selectByVisibleText(FrequnceyDurationMode);

		}
	
	public RepaymentAccountAdding(WebDriver driver)
	{
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void RD_Opening_Repayment_Tab(String Repayment_Product,String RepaymentAccount,String RepaymentFrequency,String FrequnceyDurationMode) throws InterruptedException {
    	
    	try {
    		
    		this.Click_Repayment_Account_Tab();
    		this.Tick_Opening_Repayment_CheckBox();
    		this.Select_Repaymen_Product(Repayment_Product);
    		this.Enter_Repayment_AcNo (RepaymentAccount);
    		this.Enter_Repaymnt_AcNo.sendKeys(Keys.TAB);
    		Thread.sleep(1000);
     		this.Enter_Repayment_frequency (RepaymentFrequency);
    		//this.RD_Repaymnt_Frequency.sendKeys(Keys.TAB);
     		this.Enter_Repayment_frequency_Mode(FrequnceyDurationMode);
    		Thread.sleep(3000);
    	
    	} catch (Exception e) {
    		
    		e.printStackTrace();
    	}
		
	}
	
	
}
