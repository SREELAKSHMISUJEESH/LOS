package com.beaconpro.module.uiobject.acclosure;
/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 26/04/2016
Purpose	        : Term deposits closure page controls
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.acopening.FDOpeningPage;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.NomineeAdding;
import com.beaconpro.module.uiobject.common.TransactionPageCommon;


public class TermDepositClosureAndRenewalPage {
static WebDriver driver;
	
	
	@FindBy(id="closewarning")
	public WebElement KYC_Not_Completed_PopUp;
	
	
	@FindBy (id="ctl00_ctl00_lblErrorMessage")
	public WebElement LeinMakedAccount_PopUpMsg;
	
	@FindBy(id="closeAccLie")
	public WebElement LeinMakedAccount_PopUp_OK_button;

	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_SectionCaption2_lblCaption")
	public WebElement AccountClosedSummary_Label;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_btnPrint")
	public WebElement Print_Button;
	                 
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_btnPrintClose")
	public WebElement PrintClose_Button;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_txtTrnAmount_txt")
	public WebElement Acc_Closure_Total_PayableAmount;
	
	@FindBy (xpath="html/body/div[3]/div[3]/div/button")
	public WebElement DD_DefaultAcc_PopUpMesg_OK_button ;
	

	
	public TermDepositClosureAndRenewalPage(WebDriver driver)
	{
		this.driver = driver;
		
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, SBOpeningPage.class);
	}
	
	public TermDepositClosureAndRenewalPage() {
		// TODO Auto-generated constructor stub
	}
	
   public void KYC_Not_Completed_Warning_Msg_PopUp_Click()
   {
		
		if (driver.findElements(By.id("closewarning"))
				.size() > 0)
		{
			this.KYC_Not_Completed_PopUp.click();
			
		}
	
	}
   public void LeinMarkedAccountChecking ()
   {
	   if (driver.findElements(By.id("LeinMakedAccount_PopUpMsg"))
				.size() > 0) 
	   {
		   this.LeinMakedAccount_PopUp_OK_button.click();
		   this.KYC_Not_Completed_Warning_Msg_PopUp_Click();
	   }
   }
	
	
	
	public void PrematureClosing_Alert_handle() throws InterruptedException
	{
		try
		{  
			Thread.sleep(100);
			driver.switchTo().alert().accept();;
			Thread.sleep(1000);
		    
		}
		catch(Exception e)
		{ 
			System.out.println("Prematureclosing Alert not present"); 
		}
	}
	
	public void PrintVoucher(WebDriver driver) throws InterruptedException
	{
		System.out.println("Print Voucher  executed\n"); 
		this.Print_Button.click();
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebDriverWait wait =new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(PrintClose_Button));
		this.PrintClose_Button.click();
		Thread.sleep(1000);
	}
	
	public String Set_AccClosurePayableAmt()
	
	{
	
	    String AccClosurePayableAmt;
	    AccClosurePayableAmt=this.Acc_Closure_Total_PayableAmount.getAttribute("value");
		return AccClosurePayableAmt;
	}
	
	
	public void PigmyAcc_Defaulted_PopUp_Message_click()
	{
		try
		{if(driver.findElement(By.id("divARCPopup")).isDisplayed())
		{
			DD_DefaultAcc_PopUpMesg_OK_button.click();
		}
		}
		catch(Exception e)
		{
			System.out.println("A/c Defaulted message not present"); 
		}
	
		
	}
	
	public void generate_contraEntry_for_openBatch(String AccClosurePayableAmt,String credit_branch,String credit_pdtgrp,String credit_pdtname,String credit_accno,String credit_transtype,String credit_acc_operated_by,String credit_acc_transmode) throws InterruptedException
	{
		MenuList ObjMnuList =new MenuList(driver);
		TransactionPageCommon objTransPage=new TransactionPageCommon(driver);
		//TermDepositClosurePage ObjTDClose=new TermDepositClosurePage(driver);
		
		//AccClosureAmount=AccClosurePayableAmt;
		System.out.println("Value of AccClosureAmount from contra entry method: "+ AccClosurePayableAmt);
		
		
		JavascriptExecutor executortranspage = (JavascriptExecutor) driver;
		executortranspage.executeScript("arguments[0].click();",driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[3]/ul/li[1]/a")));
		
				
		int length=AccClosurePayableAmt.length()-6; // Method to convert Payable amount eg "2500.00 CR" to "2500"
		int num=0;
		int i=0;
		 while( i < length)
		 {
		        num *= 10;
		        num += AccClosurePayableAmt.charAt(i++) - '0'; //Minus the ASCII code of '0' to get the value of the charAt(i++).
		 }
		
		
		Integer I=num;
		System.out.println("Value of closure amount from contra entry method: "+ I);
		
		String string_closureamount = Integer.toString(I);
		System.out.println("Value of StringClosureamount: "+ string_closureamount);
				
		
		objTransPage.select_branch_name(credit_branch);
		objTransPage.select_product_group(credit_pdtgrp);
		objTransPage.select_product_name(credit_pdtname);
		objTransPage.enter_account_number(credit_accno);
		objTransPage.select_trans_type(credit_transtype);
		objTransPage.click_go_button();
		objTransPage.wait_after_click_go_button();
	    objTransPage.enter_transaction_amount(string_closureamount);
		objTransPage.enter_operated_by(credit_acc_operated_by);
		objTransPage.select_trans_mode(credit_acc_transmode);
		
		String parentHandle = driver.getWindowHandle();
		objTransPage.Click_batch_search_link();
		ObjMnuList.switchWindow(driver);
		objTransPage.Select_batch_from_batchSearch_window();
		driver.switchTo().window(parentHandle);
		
		//objTransPage.enter_remark(debit_trans_remark);
		objTransPage.click_on_submit();
		objTransPage.click_on_print_and_close_preview();
		
		
	}
}
		
		
 
