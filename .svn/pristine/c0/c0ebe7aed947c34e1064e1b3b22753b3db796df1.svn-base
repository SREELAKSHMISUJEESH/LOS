package com.beaconpro.module.uiobject.common;
/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 26/04/2016
Purpose	        : Term deposits Specific Common controls 
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransactionModeSelection_TermDeposits

{
	
	WebDriver driver;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_ddlTransactionMode_ddl")
	public WebElement TransactionModeDropDownField;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_btnAutoPost")
	public WebElement post_crdt_button;
	
	@FindBy(id="ddlProductGroup_ddl")
	public WebElement pstcrdt_prdtgrp_field;
	
	@FindBy(id="ddlProductName_ddl")
	public WebElement pstcrdt_prdtname_field;
	
	@FindBy(id="txtChildAcNo_txt")
	public WebElement PostCredit_AccNo_Field;
	
	//public WebElement pstcrdt_instrtype;
	//@FindBy(id="txtAmount_txt")
	@FindBy(xpath=".//*[@id='txtAmount_txt']")
	public WebElement pstcrdtAmountField;  
	
	@FindBy(id="btnAdd")
	public WebElement PostCredit_Add_Button;
	
	@FindBy(id="btnSubmit")
	public WebElement PostCredit_Submit_Button;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_txtTrnAmount_txt")
	public WebElement AccClosure_TotPayableField;
	
	@FindBy(id="txtTotalCrDr_txt")
	public WebElement TotalCrdtDbtAmtField_in_autopost_window;
	
	@FindBy(id="txtParticulars_txt")
	public WebElement PostCreditParticularsField;
	
	
	//String AccClosure_PayableAmt=AccClosure_TotPayableField.getText();
	
	public TransactionModeSelection_TermDeposits(WebDriver driver)
	{

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	
	public void select_transmode(String transmod)
	{
		Select drop = new Select(TransactionModeDropDownField);
		drop.selectByVisibleText(transmod);

	}
	
	public void PostCreditButtonClick()
	{
		this.post_crdt_button.click();

	}
	
	public void Select_PostCredit_Product_Group(String pstcrdt_prdtgrp )
	{		
		Select pstdbtcrdtprdctgrp = new Select (pstcrdt_prdtgrp_field);
		pstdbtcrdtprdctgrp.selectByVisibleText(pstcrdt_prdtgrp);
		
	}
	
	public void Select_PostCredit_Product_Name(String pstcrdt_prdtname )
	{		
		Select pstdbtcrdtprdctgrp = new Select (pstcrdt_prdtname_field);
		pstdbtcrdtprdctgrp.selectByVisibleText(pstcrdt_prdtname);
		
	}
	
	public void Enter_PostCredit_AcNo(String pstcrdt_accno) 
	{
		PostCredit_AccNo_Field.sendKeys(pstcrdt_accno);
		
	}
	
	
	public void Enter_PostCrdit_Amount(String pstcrdtAmount) {
		
		pstcrdtAmountField.sendKeys(pstcrdtAmount);
		
	}
	
	public void Click_PostCrdit_Add_button() {
		
		PostCredit_Add_Button.click();
		
	}
	
	public void Click_PostCrdit_Submit_Button() 
	{
		
		PostCredit_Submit_Button.click();
		
	}
	public void AccClosing_as_PostCredit(String transmod,String pstcrdt_prdtgrp,String pstcrdt_prdtname,String pstcrdt_accno) throws InterruptedException
	{
		
		this.select_transmode(transmod);
		
		
		//String pstcrdtAmount=AccClosure_TotPayableField.getAttribute("value");
		
		this.post_crdt_button.click();
		
		String parentHandle = driver.getWindowHandle();
		MenuList ObjMnuList=new MenuList();
		ObjMnuList.switchWindow(driver);
		String pstcrdtAmount=TotalCrdtDbtAmtField_in_autopost_window.getAttribute("value");
		System.out.println("Value of pstcrdtAmount: " + pstcrdtAmount);
		this.Select_PostCredit_Product_Group(pstcrdt_prdtgrp);
		System.out.println("ProductGroup");
		Thread.sleep(100);
		WebDriverWait wait1 = new WebDriverWait(driver, 100);
		wait1.until(ExpectedConditions.elementToBeClickable(pstcrdt_prdtname_field));
		Thread.sleep(100);
		this.Select_PostCredit_Product_Name(pstcrdt_prdtname);
		
		
		/*WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(pstcrdt_prdtname_field));
		this.Select_PostCredit_Product_Name(pstcrdt_prdtname);
		*/

		/*WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.stalenessOf(pstcrdt_prdtname_field));
		WebDriverWait wait11 = new WebDriverWait(driver, 30);
		wait11.until(ExpectedConditions.presenceOfElementLocated(By.id("ddlProductName_ddl")));
		 */
		
		
		/*
		
		for(int i=1 ;i<=4; i++)
		{
			try 
			{
				this.Select_PostCredit_Product_Name(pstcrdt_prdtname);
				break;
				
			}
			catch(StaleElementReferenceException e)
			{
				e.printStackTrace();
			}*/
		System.out.println("ProductName");
			//WebDriverWait wait2 = new WebDriverWait(driver, 100);
			//wait2.until(ExpectedConditions.elementToBeClickable(PostCredit_AccNo_Field));
		Thread.sleep(100);
			
		ClosurePageCommon ObjClose=new ClosurePageCommon(driver);
		ObjClose.dependableClick_for_StaleElement_handling(driver, PostCredit_AccNo_Field);
		this.Enter_PostCredit_AcNo(pstcrdt_accno);
			
			
		this.PostCreditParticularsField.sendKeys(Keys.TAB);
		//this.pstcrdtAmountField.sendKeys(AccClosure_PayableAmt);
			
		WebDriverWait wait3 = new WebDriverWait(driver, 180);
		wait3.until(ExpectedConditions.stalenessOf(pstcrdtAmountField));
		WebDriverWait wait4 = new WebDriverWait(driver, 100);
		wait4.until(ExpectedConditions.presenceOfElementLocated(By.id("txtAmount_txt")));
		
		this.pstcrdtAmountField.sendKeys(pstcrdtAmount);		 
		this.Click_PostCrdit_Add_button();
			

		
		WebDriverWait wait7 = new WebDriverWait(driver, 30);
		wait7.until(ExpectedConditions.elementToBeClickable(PostCredit_Submit_Button));
		
		this.Click_PostCrdit_Submit_Button();
		
		driver.switchTo().window(parentHandle);
		
	}
	
	
	public void post_credit_transation(String transmode,String pstcrdt_prdtgrp,String pstcrdt_prdtname,String pstcrdt_accno) throws InterruptedException
	{
		this.select_transmode(transmode);
		this.PostCreditButtonClick();
		
		String parentHandle = driver.getWindowHandle();
		MenuList ObjMnuList=new MenuList();
		ObjMnuList.switchWindow(driver);
		String pstcrdtAmount=TotalCrdtDbtAmtField_in_autopost_window.getAttribute("value");
		System.out.println("Value of pstcrdtAmount: " + pstcrdtAmount);
		this.Select_PostCredit_Product_Group(pstcrdt_prdtgrp);
		System.out.println("ProductGroup");
		Thread.sleep(100);
		WebDriverWait wait1 = new WebDriverWait(driver, 100);
		wait1.until(ExpectedConditions.elementToBeClickable(pstcrdt_prdtname_field));
		Thread.sleep(100);
		this.Select_PostCredit_Product_Name(pstcrdt_prdtname);
		System.out.println("ProductName");
		//WebDriverWait wait2 = new WebDriverWait(driver, 100);
		//wait2.until(ExpectedConditions.elementToBeClickable(PostCredit_AccNo_Field));
		Thread.sleep(100);
			
		ClosurePageCommon ObjClose=new ClosurePageCommon(driver);
		ObjClose.dependableClick_for_StaleElement_handling(driver, PostCredit_AccNo_Field);
		this.Enter_PostCredit_AcNo(pstcrdt_accno);
			
			
		this.PostCreditParticularsField.sendKeys(Keys.TAB);
		//this.pstcrdtAmountField.sendKeys(AccClosure_PayableAmt);
			
		//WebDriverWait wait3 = new WebDriverWait(driver, 180);
		//wait3.until(ExpectedConditions.stalenessOf(pstcrdtAmountField));
		//WebDriverWait wait4 = new WebDriverWait(driver, 100);
		//wait4.until(ExpectedConditions.presenceOfElementLocated(By.id("txtAmount_txt")));
		
	/*	for (int i=0;i<1000;i++)
		
		{
		
			try {
			WebDriverWait wait3 = new WebDriverWait(driver, 100);
			wait3.until(ExpectedConditions.stalenessOf(pstcrdtAmountField));
			WebDriverWait wait4 = new WebDriverWait(driver, 100);
			wait4.until(ExpectedConditions.presenceOfElementLocated(By.id("txtAmount_txt")));
			this.pstcrdtAmountField.sendKeys(pstcrdtAmount);	
		
			break;
			}
		catch(Exception e)
		{
			
		}
		}*/
		ObjClose.dependableClick_for_StaleElement_handling(driver, pstcrdtAmountField);
		this.pstcrdtAmountField.sendKeys(pstcrdtAmount);
		Thread.sleep(100);
		WebDriverWait wait3 = new WebDriverWait(driver, 100);
		wait3.until(ExpectedConditions.elementToBeClickable(PostCredit_Add_Button));
		this.Click_PostCrdit_Add_button();
			

		
		WebDriverWait wait7 = new WebDriverWait(driver, 30);
		wait7.until(ExpectedConditions.elementToBeClickable(PostCredit_Submit_Button));
		
		this.Click_PostCrdit_Submit_Button();
		
		driver.switchTo().window(parentHandle);
	}
 

}
