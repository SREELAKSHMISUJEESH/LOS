package com.beaconpro.module.uiobject.common;
/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 26/04/2016
Purpose	        : Common controls in A/c closure page
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClosurePageCommon {
	
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='CreateMenu']/li[4]/ul/li[6]/a")
	public WebElement TermDepositClosure_Link_Select;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlBranch")
	public WebElement Branch_dropdown;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup")
	public WebElement ProductGroup_dropdown;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl")
	public WebElement ProductName_dropdown;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt")
	public WebElement AcNo_field;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo")
	public WebElement GoButton;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_ddlTransactionMode_ddl")          
	public WebElement TransactionModeDropDownField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement Trans_SubmitButtn;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_SectionCaption2_lblCaption")
	public WebElement ClosingSummaryLabel;

	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_btnClose")
	public WebElement SummaryPageCloseButton;
	@FindBy(id="closewarning")
	public WebElement NonKyc_Popup_OK_button;
	
	@FindBy(xpath="html/body/div[2]/div[11]/div/button[1]")
	public WebElement UncloseBatchMesgOKButton;

	public ClosurePageCommon(WebDriver driver)
	{
		this.driver = driver;
		
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, SBOpeningPage.class);
	}
	
	public void KYC_Not_Completed_Warning_Msg_PopUp_Click()
	{
		
		try
		{		 
			if (driver.findElement(By.id("closewarning")).isDisplayed())						
				{			
				  this.NonKyc_Popup_OK_button.click();
				}
		}
			
		catch(Exception  e)
		{e.printStackTrace();
		}
	 
	}
	
	 
	public void open_termdeposit_closure_window() throws InterruptedException 
	{
		 
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[4]/ul/li[6]/a")));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(60);

	}

	public void select_branch_name(String Brch_Name) {
		Select drop = new Select(Branch_dropdown);
		drop.selectByVisibleText(Brch_Name);

	}

	public void select_product_group(String Prod_Grp) {
		Select drop = new Select(ProductGroup_dropdown);
		drop.selectByVisibleText(Prod_Grp);

	}

	public void select_product_name(String Prd_nam) {
		Select drop = new Select(ProductName_dropdown);
		drop.selectByVisibleText(Prd_nam);

	}

	public void enter_account_number(String ac_no) {
		AcNo_field.sendKeys(ac_no);

	}

	public void click_on_go_button() {

		GoButton.click();

	}
	public void sendClosingAccDetails(String Brch_Name,String Prod_Grp,String Prd_nam,String ac_no)
	{
		this.select_branch_name(Brch_Name);
		this.select_product_group(Prod_Grp);
		this.select_product_name(Prd_nam);
		this.enter_account_number(ac_no);
	}

	public void select_transmode_info(String transmod) 
	{
		
		Select drop = new Select(TransactionModeDropDownField);
		drop.selectByVisibleText(transmod);

	}

	public void click_on_submit()
	{

		Trans_SubmitButtn.click();

	}
	
	public void click_UncloseBatch_PopUp_OK_button()
	{
		this.UncloseBatchMesgOKButton.click();
	}
	
	public void Account_Closing_as_BatchTransfer (String transmode) 
	{
		
		try 
		{			
			this.select_transmode_info (transmode);
			this.click_on_submit();
			this.click_UncloseBatch_PopUp_OK_button ();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void  CloseSummaryPage()
	{
		this.SummaryPageCloseButton.click();
	}
	
	public void dependableClick_for_StaleElement_handling(WebDriver d, WebElement w)
	    {
	        final int MAXIMUM_WAIT_TIME = 20;
	        final int MAX_STALE_ELEMENT_RETRIES = 5;

	        WebDriverWait wait = new WebDriverWait(d, MAXIMUM_WAIT_TIME);
	        int retries = 0;
	        while (true)
	        {
	            try
	            {
	                wait.until(ExpectedConditions.elementToBeClickable(w)).click();

	                return;
	            }
	            catch (StaleElementReferenceException e)
	            {
	                if (retries < MAX_STALE_ELEMENT_RETRIES)
	                {
	                    retries++;
	                    continue;
	                }
	                else
	                {
	                    throw e;
	                }
	            }
	        }
	    }
    
	
}
