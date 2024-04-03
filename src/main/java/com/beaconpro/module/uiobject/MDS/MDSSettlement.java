package com.beaconpro.module.uiobject.MDS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MDSSettlement 

{

	public WebDriver driver;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_txtChittyNo_txt")
	public WebElement Enter_MDS_No_MDSSettlement;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_btnChittyNoGo")
	public WebElement Click_getBtn_MDSSettlement;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_btnShowList")
	public WebElement Click_ShowlistBtn_MDSSettlement;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_lstSubscriberDetails_btnSettlementSummary")
	public WebElement Click_SettlmentSummryBtn;
	
	@FindBy (xpath = ".//*[@id='aspnetForm']/div[11]/div[3]/div/button")
	public WebElement Click_SettlmntSummaryClseBtn;
	
	@FindBy (id = "ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement SubmitBtn_MDSSettlement;
	
	public void MDSNo_MDSSettlement (String MDSNo)
	
	{
		Enter_MDS_No_MDSSettlement.sendKeys(MDSNo);
		
	}
	
	public void GetBtn_MDSSettlement ()
	
	{
		Click_getBtn_MDSSettlement.click();
	}
	
	public void ShowList_MDSSettlement ()
	
	{
		Click_ShowlistBtn_MDSSettlement.click();
	}
	
	public void SettlmentSummaryBtn ()
	
	{
		Click_SettlmentSummryBtn.click();
	}
	
	public void CloseBtn_MDSSettlement ()
	
	{
		Click_SettlmntSummaryClseBtn.click();
	}
	
	public void SubmitBtn_MDSSettlment ()
	
	{
		SubmitBtn_MDSSettlement.click();
	}
	
	
	public MDSSettlement (WebDriver driver)
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
