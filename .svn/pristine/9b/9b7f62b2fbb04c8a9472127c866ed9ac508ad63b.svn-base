package com.beaconpro.module.uiobject.MDS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MDSApplicationTransfer 

{
	
	public WebDriver driver ;
	
	@FindBy (id = "ctl00_CPH1_txtChittyNo_txt")
	public WebElement Enter_MDSNo_APPlctnTrnfr;
	
	@FindBy (id = "ctl00_CPH1_btnChittyNoGet")
	public WebElement Click_GetBtn_APPlctnTrnfr;
	
	@FindBy (id = "ctl00_CPH1_btnGet")
	public WebElement Click_GoBtn_APPlctnTrnfr;
	
	@FindBy (id = "ctl00_CPH1_btnProcess")
	public WebElement Click_MDS_TransferButton;
	
	@FindBy (id = "ctl00_CPH1_txtSummaryChittyNo_txt")
	public WebElement Enter_MDS_No_TrnfrSummary;
	
	@FindBy (id = "ctl00_CPH1_btnSummary")
	public WebElement Click_Summary_Btn;
	
	@FindBy(xpath = ".//*[@id='tblChittyApplication']/tbody/tr[2]/td[3]")
	public WebElement progressValue;
	
	@FindBy (id = "ctl00_CPH1_btnPrint")
	public WebElement MDS_application_Print;
	
	
	public void MDS_No_applcation_Transfer (String MDSNo)
	
	{
		Enter_MDSNo_APPlctnTrnfr.sendKeys(MDSNo);
	}
	
	public void Click_MDS_App_Transfer_GoBtn ()
	
	{
		Click_GoBtn_APPlctnTrnfr.click();
	}
	
	public void Click_GetBtn_ApplctnTrnsfer ()
	
	{
		Click_GetBtn_APPlctnTrnfr.click();
	}
		
	public void Click_MDS_TranferBtn ()
	
	{
		Click_MDS_TransferButton.click();
	}
	
	public void MDS_No_Summary (String MDSNo)
	
	{
		Enter_MDS_No_TrnfrSummary.sendKeys(MDSNo);
	}
	
	public void MDS_Summary_Button ()
	
	{
		Click_Summary_Btn.click();
	}
	
	public void Click_PrintBtn_MDSAppTrndfr ()
	
	{
		MDS_application_Print.click();
	}
	
	public MDSApplicationTransfer (WebDriver driver)
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
