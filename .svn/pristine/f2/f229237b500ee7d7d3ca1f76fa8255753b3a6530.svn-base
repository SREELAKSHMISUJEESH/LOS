package com.beaconpro.module.uiobject.clearing;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 20/05/2016
Purpose	        : ECS Marking base page for Object definitions
Note			: 
Conditions      :  
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EcsMarkingPage

{
	
	// SBno: 28272;
	WebDriver driver;
	//@FindBy(xpath=".//*[@id='CreateMenu']/li[9]/ul/li[4]/ul/li[5]/a")
	@FindBy(xpath=".//*[@id='CreateMenu']/li[9]/ul/li[4]/ul/li[5]/a")	
	public WebElement EcsMarkLink;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_ddlBranch_ddl")
	public WebElement EcsMark_AccBranchField;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_ddlProductGroup")
	public WebElement EcsMark_PrdtGroup_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_ddlProductName")
	public WebElement EcsMark_PrdtName_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_txtAcNo_txt")
	public WebElement EcsMark_AccNo_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_txtDisplayName_txt")
	public WebElement EcsMark_AccDisplayName;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_chkActive")
	public WebElement EcsMark_Active_CheckBox;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_txtECSNo_txt")
	public WebElement EcsMark_EcsNo_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_txtUserNo_txt")
	public WebElement EcsMark_UserNo_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_dtEffectFrom_txt")
	public WebElement EcsMark_EffectFrmDate_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_txtDuration_txt")
	public WebElement EcsMark_Durn_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_txtInstPeriod_txt")
	public WebElement EcsMark_InstPeriod_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_dtDueDate_txt")
	public WebElement EcsMark_DueDate;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_ddlBank_ddl")
	public WebElement EcsMark_Bank_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_ddlECSBranch_ddl")
	public WebElement EcsMark_BankBranch_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_ddlAmountMode_ddl")
	public WebElement EcsMark_AmountMode_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_txtAmount_txt")
	public WebElement EcsMark_Amount_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ECSMarkInfo1_txtRemarks_txt")
	public WebElement EcsMark_Remarks_Field;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_btnSave")
	public WebElement EcsMark_Save_Button;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstESCMark_lbl1")
	public WebElement EcsMarking_Details_Grid;
	
	@FindBy(id="FloatingErrorMessageBoxTop")
	public WebElement ECSMarkingSavedMessage;
	
	@FindBy(id="closetop")
	public WebElement CloseMessage;

	
	//**********Authorisation
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_lnkSignout']/strong")
	public WebElement SignOut_Link;
	
	@FindBy (xpath=".//*[@id='CreateMenu']/li[6]/ul/li[2]/a")
	public WebElement MangrAuthorise_Link;
	

	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnRefresh']")
	public WebElement AuthoriseRefresh_Button;
	
	@FindBy(id="__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers")
	public WebElement Manager_OthersTab_Select;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers_ucMAOthers_lvwOtherDetails_ctrl0_chkSelect")
	public WebElement Manager_Others_AuthoriseGrid_CheckBox;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnOtherPass']")
	public WebElement MngrAuthoriseAction_Button;
	
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_lblErrorMessage']")
	public WebElement AuthoriseSuccessUpdation_Msg ;
	
	@FindBy (xpath=".//*[@id='closetop']")
	public WebElement AuthoriseSuccessUpdation_Msg_CloseButton;

	public EcsMarkingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void Select_EcsAcc_Branch(String AccBranch) 
	{
		Select drop = new Select(EcsMark_AccBranchField);
		drop.selectByVisibleText(AccBranch);
	}
	
	public void Select_EcsAcc_PrdtGrp(String pdtgrp) 
	{
		Select drop = new Select(EcsMark_PrdtGroup_Field);
		drop.selectByVisibleText(pdtgrp);
	}
	
	public void Select_EcsAcc_PrdtName(String pdtname) 
	{
		Select drop = new Select(EcsMark_PrdtName_Field);
		drop.selectByVisibleText(pdtname);
	}
	public void Select_Ecs_BankName() 
	{
		Select drop = new Select(EcsMark_Bank_Field);
		drop.selectByIndex(1);
	}
	
	public void Select_Ecs_BankBranch() 
	{
		Select drop = new Select(EcsMark_BankBranch_Field);
		drop.selectByIndex(1);
	}
	
	public void Select_Ecs_AmountMode_As_Equal() 
	{
		String amtmode="=";
		Select drop = new Select(EcsMark_AmountMode_Field);
		drop.selectByVisibleText(amtmode);
	}
	
	public void Open_ECSMarking_Window() throws InterruptedException 
	{
		 
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[9]/ul/li[4]/ul/li[5]/a")));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(60);

	}
	
	public void SetDate(WebElement DateField,String DateValue)
	{
		DateField.click();
		//Fill date as mm/dd/yyyy as 09/25/2013
		//for(int i =0; i<10 ; i++)
		//{
			DateField.sendKeys(DateValue);	
		//}
			
	}
	
	public void dependableClick_for_StaleElement_handling(WebDriver d, WebElement w) throws InterruptedException
    {
        final int MAXIMUM_WAIT_TIME = 100;
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
	
	
	public void EcsMarkingDetailsSubmit (String AccBranch,String pdtgrp,String pdtname,String Accno,String EcsNo,
			String UsrNo,String EfctFrmDate,String durn,String InstPeriod,String EcsAmt,String EcsRemarks) throws InterruptedException
	{
		this.Select_EcsAcc_Branch(AccBranch);
		this.Select_EcsAcc_PrdtGrp(pdtgrp);
		this.Select_EcsAcc_PrdtName(pdtname);
		this.EcsMark_AccNo_Field.sendKeys(Accno);
		WebDriverWait wait1 =new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.visibilityOf(this.EcsMark_AccDisplayName));
		
		if (EcsMark_Active_CheckBox.isSelected())
			{
				System.out.println("\nECS Active field is enabled");
			}
		else
			{
				System.out.println("\nECS Active field is not enabled; Enabling the same");
				EcsMark_Active_CheckBox.click();
			}
		Thread.sleep(30);
		dependableClick_for_StaleElement_handling(driver,EcsMark_EcsNo_Field);
		EcsMark_EcsNo_Field.sendKeys(EcsNo);
		Thread.sleep(3000);
		EcsMark_EcsNo_Field.sendKeys(Keys.TAB);
		dependableClick_for_StaleElement_handling(driver,EcsMark_UserNo_Field);
		EcsMark_UserNo_Field.sendKeys(UsrNo);
		Thread.sleep(30);

		SetDate(EcsMark_EffectFrmDate_Field, EfctFrmDate);
		this.EcsMark_Durn_Field.sendKeys(durn);	
		Thread.sleep(30);
		this.EcsMark_InstPeriod_Field.sendKeys(InstPeriod);
		this.EcsMark_InstPeriod_Field.sendKeys(Keys.TAB);
		Thread.sleep(30);
		Select_Ecs_BankName();
		Thread.sleep(300);
		Select_Ecs_BankBranch();
		Select_Ecs_AmountMode_As_Equal();
		EcsMark_Amount_Field.sendKeys(EcsAmt);
		EcsMark_Remarks_Field.sendKeys(EcsRemarks);

		if(EcsMark_EcsNo_Field.getText()!=EcsNo)
		{
			System.out.println("Re-Entering ECS No");
			EcsMark_EcsNo_Field.sendKeys(EcsNo);
			EcsMark_EcsNo_Field.sendKeys(Keys.TAB);
			
		}
		//Thread.sleep(30);
		dependableClick_for_StaleElement_handling(driver,EcsMark_Save_Button);
		//EcsMark_Save_Button.click();
		Thread.sleep(30);
		if(EcsMarking_Details_Grid.isDisplayed())
			
		{
			System.out.println("ECS Marking details Saved ");
			if(ECSMarkingSavedMessage.isDisplayed())
			{
				CloseMessage.click();
			}
			
		}
		else
		{
			System.out.println("Something Happened;ECS Marking details Not Saved");
		}
	}
	
	

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

