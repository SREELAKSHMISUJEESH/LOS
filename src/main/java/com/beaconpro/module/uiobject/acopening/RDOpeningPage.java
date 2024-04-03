package com.beaconpro.module.uiobject.acopening;

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

import com.beaconpro.module.uiobject.login.LoginPage;
import com.beaconpro.module.uiobject.transaction.TransactionPage;

//import BeaconPro.RD.accountopening.RDAccountOpening;


public class RDOpeningPage { 
	

	WebDriver driver;
	public String GetBatchId;
	
	
	@FindBy (id = "PopQuick1_txtName")
	public WebElement CustomerName;
	//RD opening
	
	@FindBy (xpath=".//*[@id='CreateMenu']/li[2]/ul/li[1]/ul/li[5]/ul/li/a")
	public WebElement RDopening;
		
	//General Tab
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtAcOpeningAmount_txt")
	public WebElement OpeningAmount;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtInstallmentAmount_txt")
	public WebElement InstAmount;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtDuration_txt")
	public WebElement RDDuration;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_btnGetROI")
	public WebElement GetValueBtn;
	
	@FindBy (xpath=".//*[@id='closewarning']")
	private
	static WebElement Senior_Citizen_ROI_PopUp;
	
	//Nominee Tab
	@FindBy (xpath = ".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee']")
	public WebElement NomineeTab;
	
	/*@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_btnIntLog']")
	public WebElement IntLogBtn;*/
	
	@FindBy (xpath=".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer']")
	public WebElement Authorization_Transfer;
	
	@FindBy (xpath="//.//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect']")
	public WebElement AuthorizationManagerCheckBox;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSave']")
	public WebElement RDOpeningSaveButton;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_btnPrint")
	public WebElement RDOpeningPrint;
	
	@FindBy (xpath="html/body/form/div[6]/div[3]/div/div/div[2]/div/div[3]/table[1]/tbody/tr/td/table/tbody/tr[2]/td[8]")
	public WebElement GetTransType;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_lnkSignout']/strong")
	public WebElement SignOut;

	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnRefresh']")
	public WebElement AthorizeRefreshButton;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect']")
	public WebElement authorizationCashierCheckBox;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnOtherPass']")		
	public WebElement ClickAuthorizeButton;
	
	@FindBy (xpath ="html/body/div[3]/div[11]/div/button")
	public WebElement test;
	
	
	
	public void EnterAmount(String RDopengAmount){
		OpeningAmount.sendKeys(RDopengAmount);
	}
	public void installment_amount(String RDInstAmount){
		InstAmount.sendKeys(RDInstAmount);
	}
	public void EnterDuration(String EnterRDDuration){
		RDDuration.sendKeys(EnterRDDuration);
	}
	public void GetValueBtn(){
		GetValueBtn.click();
	}
	
	/*public void LogBtn(){
		IntLogBtn.click();
	}*/
	
	public RDOpeningPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	
	public static void switchWindow(WebDriver driver) {

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);

		}
	}
		
	
	public void RD_General_Tab(String RDOPeningAMount,String RD_Duration) throws InterruptedException{
		
		try {
			
			this.EnterAmount(RDOPeningAMount);
			this.installment_amount(RDOPeningAMount);
			this.EnterDuration(RD_Duration);
			this.GetValueBtn();
			/*WebDriverWait wait3 = new WebDriverWait(driver, 10);
			wait3.until(ExpectedConditions.elementToBeClickable(this.IntLogBtn));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
    public void SeniorCitizen_ROI_PopUp(){
		
		if (driver.findElements(By.xpath(".//*[@id='closewarning']"))
				.size() > 0) {
			this.getSenior_Citizen_ROI_PopUp().click();
			
		}
	}
	
    
    //Signout and Authorize cash transaction
	public void SignOut_Authorize_CashTransaction(String AuthUsrName,String AuthPword) throws Throwable {
    	
    	try {
    		
    		LoginPage	objLogin = new LoginPage (driver);
    		this.SignOut.click();
    		Thread.sleep(1000);
    		objLogin.loginToBeaconProValid(AuthUsrName, AuthPword);
    		JavascriptExecutor executor = (JavascriptExecutor) driver;
    		executor.executeScript("arguments[0].click();",
    		driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[5]/ul/li[2]/a")));
    		WebDriverWait wait12 = new WebDriverWait(driver, 10);
    		wait12.until(ExpectedConditions.elementToBeClickable(this.AthorizeRefreshButton));
    		this.AthorizeRefreshButton.click();
    		WebDriverWait wait13 = new WebDriverWait(driver, 10);
    		wait13.until(ExpectedConditions.elementToBeClickable(this.authorizationCashierCheckBox));
    	    this.authorizationCashierCheckBox.click();	
        	this.ClickAuthorizeButton.click();
    		
    		
    	} catch (Exception e) {
    		
    		e.printStackTrace();
    	}	
		
	}


	public static WebElement getSenior_Citizen_ROI_PopUp() {
		return Senior_Citizen_ROI_PopUp;
	}


	public static void setSenior_Citizen_ROI_PopUp(
			WebElement senior_Citizen_ROI_PopUp) {
		Senior_Citizen_ROI_PopUp = senior_Citizen_ROI_PopUp;
	}
		
	

}

