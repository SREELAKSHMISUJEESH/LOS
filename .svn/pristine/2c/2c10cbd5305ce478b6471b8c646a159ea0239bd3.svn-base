package com.beaconpro.module.uiobject.clearing;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 20/05/2016
Purpose	        : ECS Registration base page for Object definitions
Note			: 
Conditions      :  
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ECSRegistrationPage

{
	WebDriver driver;
	public String crdt_usrno;
	public String crdt_amt;
	//EcsMarkingAndRegistrationPage ObjECSMark=new EcsMarkingAndRegistrationPage(driver);
	
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucEcsInfo_ddlClearingType_ddl")
	public WebElement ECSReg_ClrngType_drpdwn;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucEcsAcInfo_ddlBranch_ddl")
	public WebElement ECCReg_Branch;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucEcsAcInfo_ddlProductGroup")
	public WebElement ECSReg_PdtGrp;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucEcsAcInfo_ddlProductName")
	public WebElement ECSReg_PdtName;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucEcsAcInfo_txtAcNo_txt")
	public WebElement ECSReg_AccNo;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucEcsAcInfo_usrCustInfo_lstCustView_ctrl0_lblCust_ID']")
	public WebElement ECSReg_Acc_Details_Grid;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucEcsAcInfo_chkECSDetails")
	public WebElement ECSReg_ECS_Details_ChkBox;
	
	@FindBy(xpath=".//*[@id='ECSInfoContainer']/tr/td[1]")
	public WebElement ECSReg_ECS_DetailsGrid;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucEcsAcInfo_ddlECSNo_ddl")
	public WebElement ECSReg_ECSNo_drpdwn;
	
	@FindBy(id= "ctl00_ctl00_CPH1_PRDCNT_ucEcsDetails_txtSeqNo_txt")
	public WebElement ECSReg_SeqncNo;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement EcsReg_Submit_Button;
	
	@FindBy(id="FloatingErrorMessageBoxTop")
	public WebElement ECSRegistrationSuccess_Message;
	
	@FindBy(id="closetop")
	public WebElement CloseMessage;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lblSummary")
	public WebElement ECS_RegistrationSummary;
	
	
	//----- ECS Credit specific Registration details 
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucEcsDetails_txtUserNo_txt")
	public WebElement ECSCrdt_UserNo;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucEcsDetails_ddlAmountBased")
	public WebElement ECSCrdt_AmountMode;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucEcsDetails_txtAmount_txt")
	public WebElement ECSCrdt_Amount;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucEcsDetails_ddlBank_ddl")
	public WebElement ECSCrdt_Bank;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucEcsDetails_ddlBranch_ddl")
	public WebElement ECSCrdt_Bank_Branch;
	
	public ECSRegistrationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void Open_ECSRegistration_Window() throws InterruptedException 
	{
		 
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[9]/ul/li[4]/ul/li[1]/a")));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(60);

	}
	
	public void Select_Ecs_ClrngType(String ClrngType) 
	{
		Select drop = new Select(ECSReg_ClrngType_drpdwn);
		drop.selectByVisibleText(ClrngType);
	}
	
	public void Select_Ecs_No(String EcsNo) 
	{
		Select drop = new Select(ECSReg_ECSNo_drpdwn);
		drop.selectByVisibleText(EcsNo);
	}
	
/*	public void Select_from_dropdown_with_visibleTxt(WebElement element,String Data) 
	{
		Select drop = new Select(element);
		drop.selectByVisibleText(Data);
	}
	
	public void Select_from_dropdown_with_index(WebElement element) 
	{
		Select drop = new Select(element);
		drop.selectByIndex(1);
	}
	*/
	
	public void Select_ECSRegBranch(String AccBranch) 
	{
		Select drop = new Select(ECCReg_Branch);
		drop.selectByVisibleText(AccBranch);

	}
	

	public void Select_ECSRegPdtGrp(String pdtgrp) 
	{
		Select drop = new Select(ECSReg_PdtGrp);
		drop.selectByVisibleText(pdtgrp);
	

	}
	public void Select_ECSRegPdtName(String pdtname) 
	{
		Select drop = new Select(ECSReg_PdtName);
		drop.selectByVisibleText(pdtname);
	

	}
	public void Select_ECSCrdtBank() 
	{
		Select drop = new Select(ECSCrdt_Bank);
		drop.selectByIndex(1);
	}
	public void Select_ECSCrdt_BankBranch() 
	{
		Select drop = new Select(ECSCrdt_Bank_Branch);
		drop.selectByIndex(1);
	}
	
	
	public void Select_EcsCrdt_AmountMode() 
	{
		String amtmode="=";
		Select drop = new Select(ECSCrdt_AmountMode);
		drop.selectByVisibleText(amtmode);
	}
	
	public void Send_EcsCrdtRegstrDetails(String crdt_usrno,String crdt_amt) throws InterruptedException
	
	{
		
		ECSCrdt_UserNo.sendKeys(crdt_usrno);
		Thread.sleep(30);
		Select_EcsCrdt_AmountMode();
		ECSCrdt_Amount.sendKeys(crdt_amt);
		Thread.sleep(30);
		
	}
	
	public void Split_String(String To_Split_String)
	{
		
		String Result_String[]=To_Split_String.split("/");
		String Return_Result1=Result_String[Result_String.length-2];
		String Return_Result2=Result_String[Result_String.length-1];
		System.out.println("ECS Register Type: "+Return_Result1);
		System.out.println("ECS Register No : "+Return_Result2);
		/* Another Method : String s = "/abc/def/ghfj.doc";
			s.substring(s.lastIndexOf("/") + 1)
		*/
	}
	
 
	
}
