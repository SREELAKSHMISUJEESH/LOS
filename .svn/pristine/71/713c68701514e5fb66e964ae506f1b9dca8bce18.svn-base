package com.beaconpro.module.uiobject.clearing;

import java.util.concurrent.TimeUnit;
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
import com.beaconpro.module.uiobject.common.MenuList;

public class OutstationClearingPage 
{
	
	WebDriver driver;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucSearchInfo_ddlBranch_ddl")
	public WebElement ddl_Branch;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucSearchInfo_ddlBank_ddl")
	public WebElement ddl_Bank;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucSearchInfo_ddlClearingType_ddl")
	public WebElement ddl_ClearingType;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucSearchInfo_txtRegNo_txt")
	public WebElement txt_RegNo;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucSearchInfo_dtClearingDate_txt")
	public WebElement txt_ClearingDate;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucSearchInfo_ddlRegBranch_ddl")
	public WebElement ddl_RegBranch;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucSearchInfo_btnSearch")
	public WebElement btn_Search;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucSearchInfo_btnClose")
	public WebElement btn_Close;
	
	@FindBy(id = "expandImg")
	public WebElement btn_ExpandCollapse;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstClearing_ctrl0_chkSelect")
	public WebElement chk_Select;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ddlClearReturn_ddl")
	public WebElement ddl_ClearReturn;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnGo")
	public WebElement btn_Go;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtdrctlyRemrks_txt")
	public WebElement txt_drctlyRemarks;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucNonProductTransactionRecovery_txtRecovery32")
	public WebElement AgentBankCommission;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucNonProductTransactionRecovery_txtRecovery110")
	public WebElement HandlingCharge;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTrnApprovingInfo_txtTrnAmount_txt")
	public WebElement txt_TrnAmount;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTrnApprovingInfo_ddlTransactionMode_ddl")
	public WebElement ddl_TransactionMode;
	
	@FindBy(xpath = ".//*[@id='aspnetForm']/div[12]/div[3]/div/button[1]")
	public WebElement ok_btn_in_batch_opening_popup;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTrnApprovingInfo_txtRemarks_txt")
	public WebElement txt_Remarks;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement btn_Submit;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnClear")
	public WebElement btn_Clear;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lblTransID")
	public WebElement TransID;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnPrint")
	public WebElement btn_Print;
	
	public OutstationClearingPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ExplicitWait_elementToBeClickable(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void ExplicitWait_visibilityOf(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void open_window(WebElement element) 
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void Selection_from_dropdown(WebElement element, String index)
	{
		Select Select9 = new Select(element);
		Select9.selectByVisibleText(index);
	}
	
	public void Presenting(String branch, String AgentBank, String ClearingType, String RegBranch,String ClearReturnThrough,
					String TrnMode)
	{
		MenuList objML = new MenuList(driver);
		open_window(objML.OutstationClearing);
		Selection_from_dropdown(ddl_Branch, branch);
		Selection_from_dropdown(ddl_Bank, AgentBank);  
		Selection_from_dropdown(ddl_ClearingType, ClearingType);
		//txt_RegNo.sendKeys("123");
		for (int i = 0; i < 10; i++)
			try 
			{
				txt_ClearingDate.sendKeys("30062016");
				break;
			}
			catch (StaleElementReferenceException e) 
			{
				e.getMessage();
			}
		//txt_ClearingDate.sendKeys("30062016");
		Selection_from_dropdown(ddl_RegBranch, RegBranch);
		btn_Search.click();
		btn_ExpandCollapse.click();
		chk_Select.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Selection_from_dropdown(ddl_ClearReturn, ClearReturnThrough);
		btn_Go.click();
		txt_drctlyRemarks.sendKeys("remarks");
		String TrnAmount = txt_TrnAmount.getAttribute("value");
		System.out.println("TrnAmount :"+TrnAmount);
		
		if (TrnMode.equalsIgnoreCase("CASH"))
		{
			Selection_from_dropdown(ddl_TransactionMode, "CASH");
			ddl_TransactionMode.sendKeys(Keys.TAB);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.attributeToBe(txt_Remarks, "value", "BY CASH: "));
			txt_Remarks.sendKeys("done");
			btn_Submit.click();
		} 
		else if (TrnMode.equalsIgnoreCase("BATCH"))
		{
			Selection_from_dropdown(ddl_TransactionMode, "TRANSFER");
			ddl_TransactionMode.sendKeys(Keys.TAB);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.attributeToBe(txt_Remarks, "value", "BY TRANSFER : "));
			txt_Remarks.sendKeys("done");
			btn_Submit.click();
			ok_btn_in_batch_opening_popup.click();
		}
		
		ExplicitWait_elementToBeClickable(btn_Print);
		String transID = TransID.getText();
		System.out.println("TransID : "+ transID);
	}
	
}
