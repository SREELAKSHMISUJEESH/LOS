package com.beaconpro.module.uiobject.common;

/********************************************************************************************************************	
 Created By      :  Yadhu 
 Created On	     :	
 Purpose	     :	To handle all types of Authorizations
 Conditions      :  AutoAuthoriseCreditCashierTransaction key in GeneralConfig should be 0  
     
 -------------------------------------------------------------------------------------------------------------------
 Modified By			Modified On			Reason
 Shilpa.U.D				02/06/2016			Added LoginForAuthorization() method

-------------------------------------------------------------------------------------------------------------------
 ********************************************************************************************************************/

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.beaconpro.module.uiobject.login.LoginPage;

public class Authorizations {

	WebDriver driver;
	MenuList objml;

	@FindBy(id = "ctl00_ctl00_lnkSignout")
	public WebElement SignOut_Link;
	
	@FindBy (id="ctl00_ctl00_lblUser")
	public WebElement Logged_UserName;

	/********* Cashier Authorization Page **************/
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt")
	public WebElement Txt_TransID_c;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtBatchID_txt")
	public WebElement Txt_BatchID;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtMakerID_txt")
	public WebElement Txt_MakerID;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtVoucherNo_txt")
	public WebElement Txt_VoucherNo;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucProductID_ddlProductID_ddl")
	public WebElement DDL_ProductID;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_chkIncludeManagerEntry")
	public WebElement Chk_IncludeManagerEntry;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnGo")
	public WebElement Btn_Go;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnRefresh")
	public WebElement Btn_Refresh;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement Btn_Submit;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnClose")
	public WebElement Btn_Close;

	@FindBy(id = "expandImg")
	public WebElement Btn_expand;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect")
	public WebElement Chk_Select;

	@FindBy(xpath = ".//*[@id='AuthTransDetailsContainer']/tr/td[1]")
	public WebElement TransID_in_AuthTransDetailsContainer;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement Btn_Authorize;

	/*********************************************/

	/********* Manager Authorization Page cash tab **************/
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt")
	public WebElement Txt_TransID_m;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtVoucherNo_txt")
	public WebElement Txt_VoucherNo_m;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnGo")
	public WebElement Btn_Go_m;

	@FindBy(id = "expandImg")
	public WebElement Btn_expand_m;

	@FindBy(xpath = ".//*[@id='AuthTransDetailsContainer']/tr/td[1]")
	public WebElement TransID_in_AuthTransDetailsContainer_m;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect")
	public WebElement Chk_Select_m;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnOtherPass")
	public WebElement Btn_Authorize_m;

	/**************************************************/

	/********* Manager Authorization Page Transfer tab **************/
	@FindBy(id = "__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer")
	public WebElement Transfer_tab_m;

	@FindBy(xpath = ".//*[@id='AuthTransDetailsContainer']/tr[1]/td[1]")
	public WebElement TransID_AuthTransDetailsContainer_m;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect")
	public WebElement Chk_Select_m2;
	/**************************************************/

	/********* Manager Authorization Page Other tab **************/
	@FindBy(id = "__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers")
	public WebElement Others_tab_m;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers_ucMAOthers_lvwOtherDetails_ctrl0_expandImg")
	public WebElement Btn_expand_Others;

	@FindBy(id = ".//*[@id='AuthTransDetailsContainer']/tr[1]/td[1]")
	public WebElement TransID_AuthTransDetailsContainer_others;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers_ucMAOthers_lvwOtherDetails_ctrl0_chkSelect")
	public WebElement Chk_Select_others;

	public Authorizations(WebDriver driver) 
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

	public void Cashier_Authorization(String TransID)
	{
		objml = new MenuList(driver);
		objml.Open_window(objml.Cashier_Authorization);
		ExplicitWait_elementToBeClickable(Btn_Go);
		Txt_TransID_c.sendKeys(TransID);
		Btn_Go.click();
		ExplicitWait_elementToBeClickable(Chk_Select);
		Btn_expand.click();
		ExplicitWait_elementToBeClickable(TransID_in_AuthTransDetailsContainer);
		String Expected_TransID = TransID_in_AuthTransDetailsContainer
				.getText();

		if (TransID.equalsIgnoreCase(Expected_TransID))
		{
			System.out.println("\nTransID Verified in cashier authorization\n");
		}
		else
		{
			System.out.println("\nTransID mismatch");
		}

		Chk_Select.click();
		Btn_Authorize.click();
		System.out.print("\nCashier authorization completed\n");
	}

	public void Manager_Authorization_cash(String TransID) 
	{
		objml = new MenuList(driver);
		objml.Open_window(objml.Manager_Authorization);
		ExplicitWait_elementToBeClickable(Btn_Go_m);
		Txt_TransID_m.sendKeys(TransID);
		Btn_Go_m.click();
		Btn_expand_m.click();
		ExplicitWait_elementToBeClickable(TransID_in_AuthTransDetailsContainer_m);
		String Expected_TransID = TransID_in_AuthTransDetailsContainer_m
				.getText();

		if (TransID.equalsIgnoreCase(Expected_TransID)) 
		{
			System.out
					.println("\nTransID Verified in cash tab of manager authorization\n");
		} 
		else 
		{
			System.out.println("\nTransID mismatch");
		}

		Chk_Select_m.click();
		Btn_Authorize_m.click();
		System.out.print("\nManager authorization completed\n");
	}

	public void Manager_authorization_Transfer(String TransID)
	{
		objml = new MenuList(driver);
		objml.Open_window(objml.Manager_Authorization);
		ExplicitWait_elementToBeClickable(Btn_Go_m);
		Transfer_tab_m.click();
		Txt_TransID_m.sendKeys(TransID);
		Btn_Go_m.click();
		Btn_expand_m.click();
		ExplicitWait_elementToBeClickable(TransID_AuthTransDetailsContainer_m);
		String Expected_TransID = TransID_AuthTransDetailsContainer_m.getText();

		if (TransID.equalsIgnoreCase(Expected_TransID)) {
			System.out
					.println("\nTransID Verified in cash tab of manager authorization\n");
		} else {
			System.out.println("\nTransID mismatch");
		}

		Chk_Select_m2.click();
		Btn_Authorize_m.click();
		System.out.print("\nManager transfer authorization completed\n");
	}

	public void Manager_authorization_Others()
	{
		objml = new MenuList(driver);
		objml.Open_window(objml.Manager_Authorization);
		ExplicitWait_elementToBeClickable(Btn_Go_m);
		Others_tab_m.click();
		//Txt_TransID_m.sendKeys(TransID);
		Btn_Go_m.click();
		//Btn_expand_Others.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Btn_expand_Others.click();
		Chk_Select_others.click();
		Btn_Authorize_m.click();
		System.out.print("\nManager others authorization completed\n");
	}

	public void Authorization(String TransID, String TransType, String TransMode) 
	{
		if (TransMode.equalsIgnoreCase("CASH"))
		{
			if (TransType.equalsIgnoreCase("Credit")) 
			{
				Cashier_Authorization(TransID);
				Manager_Authorization_cash(TransID);
			}
			else if (TransType.equalsIgnoreCase("Debit"))
			{
				Manager_Authorization_cash(TransID);
				Cashier_Authorization(TransID);
			}
		}
		if (TransMode.equalsIgnoreCase("TRANSFER"))
		{
			if (TransType.equalsIgnoreCase("Credit") || TransType.equalsIgnoreCase("Debit"))
			{
				Manager_authorization_Transfer(TransID);
			}
		}
	}
	public void LoginForAuthorization(String Authorizn_User,String Authorizn_Pass) throws InterruptedException
	{		
		Thread.sleep(300);
		//((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+SignOut_Link.getLocation().y+")");
		/*JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebDriverWait wait = new WebDriverWait(driver, 300);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_ctl00_lnkSignout")));
		  
		js.executeScript("arguments[0].scrollIntoView(true);", SignOut_Link);
		wait.until(ExpectedConditions.elementToBeClickable(SignOut_Link));
		*/
		
		Actions actions = new Actions (driver);
		actions.moveToElement(SignOut_Link).click().perform();
		//SignOut_Link.click();
		LoginPage	objLogin = new LoginPage (driver);
		try 
		{
			objLogin.loginToBeaconProValid(Authorizn_User,Authorizn_Pass);
		} 
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

	 
}
