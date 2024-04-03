package com.beaconpro.module.uiobject.MDS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MDSCollection {

	public WebDriver driver;
	
	@FindBy (id = "ctl00_CPH1_txtChittyNo_txt")
	public WebElement Enter_MDS_NO_Collection;
	
	@FindBy (id = "ctl00_CPH1_btnChittyNoGo")
	public WebElement Click_GetBtn_MDSCollection;
	
	@FindBy (id = "ctl00_CPH1_chkPreviousBid")
	public WebElement Click_Previous_biddetails_MDSColleciton;
	
	@FindBy (id = "ctl00_CPH1_txtSubscriptionNo_txt")
	public WebElement Enter_Subscription_Number_MDSColleciton;
	
	@FindBy (id = "ctl00_CPH1_btnGetSubscriberInfo")
	public WebElement Click_MDS_Collection_GoBtn;
	
	@FindBy (id ="ctl00_CPH1_ChkMulSub")
	public WebElement MulpileCollection; 
	
	@FindBy (id = "ctl00_CPH1_chkLastN")
	public WebElement Click_Previous_Colelction_details;
	
	@FindBy (id = "ctl00_CPH1_ucTransactionApprovingInfo_txtInstallmentNo_txt")
	public WebElement Enter_MDS_Installemnt_No_Collection;
	
	@FindBy (id = "ctl00_CPH1_ucTransactionApprovingInfo_txtTrnAmount_txt")
	public WebElement MDS_Collecton_Amount;
	
	@FindBy (id ="ctl00_CPH1_ucTransactionApprovingInfo_btnAutoPost")
	public WebElement MDS_Collection_PostDbtBtn;
	
	@FindBy (id = "ctl00_CPH1_ucTransactionApprovingInfo_ddlTransactionMode_ddl")
	public WebElement Transmode_MDS_Collection;
	
	@FindBy (id = "ctl00_CPH1_btnSubmit")
	public WebElement MDS_Collection_SubmitBtn;
	
	public void MDS_No_MDSCollection (String MDSNO)
	
	{
		Enter_MDS_NO_Collection.sendKeys(MDSNO);
	}
	
	public void Get_Btn_MDSCollection ()
	
	{
		Click_GetBtn_MDSCollection.click();
		WebDriverWait wait = new WebDriverWait (driver ,10);
		wait.until(ExpectedConditions.elementToBeClickable(Click_MDS_Collection_GoBtn));
	}
	
	public void Previous_biddetails_MDSCollection ()
	
	{
		Click_Previous_biddetails_MDSColleciton.click();
	}
	
	public void SubscriberNo_MDSCollection (String SubscriberNo)
	
	{
		Enter_Subscription_Number_MDSColleciton.sendKeys(SubscriberNo);
	}

	public void MDS_Collection_GoBtn ()
	
	{
		Click_MDS_Collection_GoBtn.click();
	}
	
	public void Previous_Colelction_details ()
	
	{
		Click_Previous_Colelction_details.click();
	}
	
	public void MDS_Installemnt_No_Collection (String InstallmentNo)
	
	{
		Enter_MDS_Installemnt_No_Collection.sendKeys(InstallmentNo);		
	}
	
	public void Transmode_MDS_Collection (String TrnmodeMDSColelction)
	
	{
		Select SelctTrnMod = new Select (Transmode_MDS_Collection);
		SelctTrnMod.selectByVisibleText(TrnmodeMDSColelction);
		
	}
	
	public void Muliple_Colleciton ()
	
	{
		MulpileCollection.click();
	}
	
	public void MDS_Collection_AutoPstngBtn ()
	
	{
		MDS_Collection_PostDbtBtn.click();
	}
	
	public void MDS_Collection_SubmitBtn ()
	
	{
		MDS_Collection_SubmitBtn.click();
	}
	
	
	public MDSCollection (WebDriver driver)
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
