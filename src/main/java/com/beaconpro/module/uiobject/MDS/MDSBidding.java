package com.beaconpro.module.uiobject.MDS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MDSBidding {

	public WebDriver driver;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_txtChittyNo_txt")
	public WebElement Enter_MDSNo_MDSBidding;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_btnChittyNoGo")
	public WebElement Click_Get_Btn_MDSBidding;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_ucBidDetails_txtBidAmount_txt")
	public WebElement Enter_MDS_Bidding_Amount;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_ucBidDetails_txtDiscount_txt")
	public WebElement Enter_MDS_Discount_Amount;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_ucBidDetails_btGo")
	public WebElement Click_Go_Btn_MDSBidding;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_ucSubscriberDetails_txtSubscriberNo_txt")
	public WebElement Enter_Subscriber_No_MDSBidding;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_chkPreviousBid")
	public WebElement Click_Prevous_Biddetails_CheckBox;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_ucSubscriberDetails_btGetSubscriber")
	public WebElement Subscriber_Go_Btn;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement Click_MDS_SubmitBtn;
	
	@FindBy (xpath =".//*[@id='aspnetForm']/div[11]/div[3]/div/button[1]")
	public WebElement Click_YES_Discount_Adjust_Btn;
	
	@FindBy (xpath =".//*[@id='aspnetForm']/div[11]/div[3]/div/button[2]")
	public WebElement Click_NO_Discount_Adjust_Btn;
	
	public void Enter_MDS_NUMBER_Bidding (String MDSNO)
	
	{
		Enter_MDSNo_MDSBidding.sendKeys(MDSNO);
	}
	
	public void Click_get_btn_Bidding ()
	
	{
		Click_Get_Btn_MDSBidding.click();
		WebDriverWait wait = new WebDriverWait (driver ,10);
		wait.until(ExpectedConditions.elementToBeClickable(Click_Go_Btn_MDSBidding));
		
	}
	
	public void Enter_Bidding_Amount (String BiddingAmount)
	
	{
		Enter_MDS_Bidding_Amount.sendKeys(BiddingAmount);
	}
	
	public void Enter_Discount_Amount (String DiscountAmount)
	
	{
		Enter_MDS_Discount_Amount.sendKeys(DiscountAmount);
	}
	
	public void Click_GO_Button_Bidding ()
	
	{
		Click_Go_Btn_MDSBidding.click();
		
		
	}
	
	public void Enter_Subscriber_No (String SubscriberNo)
	
	{
		for (int i =0 ; i <1 ; i++)
		{
			Enter_Subscriber_No_MDSBidding.sendKeys(SubscriberNo);
		}
	}
	
	public void Click_Subscriber_goBtn ()
	
	{
		Subscriber_Go_Btn.click();
	}

	public void Click_PrevoiusBiddetails_chkbx ()
	
	{
		Click_Prevous_Biddetails_CheckBox.click();
	}
	
	public void MDS_Bidding_Submit ()
	
	{
		Click_MDS_SubmitBtn.click();
	}
	
	public void Click_Adjustdiscnt_YES ()
	
	{
		Click_YES_Discount_Adjust_Btn.click();
	}
	
	public void Click_Adjustdiscnt_NO ()
	
	{
		Click_NO_Discount_Adjust_Btn.click();
	}
	
	public MDSBidding (WebDriver driver)
	
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
}
