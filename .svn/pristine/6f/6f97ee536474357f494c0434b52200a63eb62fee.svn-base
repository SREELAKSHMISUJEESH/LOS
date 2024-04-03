package com.beaconpro.module.uiobject.authorization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerAuthorisationPage {

	WebDriver driver;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucDebitCredit_ddlCrorDr")
	public WebElement Credit_DebitDropdownField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucProductID_ddlProductID_ddl")
	public WebElement ProductIDDropdownField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtVoucherNo_txt")
	public WebElement Voucher_ChallanNoField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtMakerID_txt")
	public WebElement MakerIDField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtBatchID_txt")
	public WebElement BatchIDField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt")
	public WebElement TransactionIDField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_chkSelf")
	public WebElement SelfCheckbox;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_chkIncludeManagerEntry")
	public WebElement SuperAuthorisationField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnGo")
	public WebElement GoBtn;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnRefresh")
	public WebElement RefreshBtn;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnOtherPass")
	public WebElement AuthorizeBtn;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnOthersClose")
	public WebElement CloseBtn;

	@FindBy(xpath = ".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash']")
	public WebElement CashTab;

	@FindBy(xpath = ".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer']")
	public WebElement TransferTab;

	@FindBy(xpath = ".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers']")
	public WebElement OthersTab;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect")
	public WebElement AuthorisationEntryCheckBoxFirst;

	@FindBy(xpath = ".//*[@id='tblCustList']/tbody/tr[1]/td[5]")
	public WebElement AuthorisationDescriptionHeading;

	@FindBy(xpath = ".//*[@id='FloatingErrorMessageBoxTop']")
	public WebElement TopFloatingMessage;

	@FindBy(xpath = ".//*[@id='closetop']")
	public WebElement ClosebtnInFloatingMessage;

	// @FindBy(id = "")
	// public WebElement ;

	public ManagerAuthorisationPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public ManagerAuthorisationPage() {
		// TODO Auto-generated constructor stub
	}

	public void open_manager_autho_window(WebDriver driver) {

		WebElement element = driver.findElement(By
				.xpath(".//*[@id='CreateMenu']/li[5]/ul/li[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	public void click_refresh_button() {

		RefreshBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions
				.visibilityOf(AuthorisationEntryCheckBoxFirst));

	}

	public void authorization_operation() {

		AuthorisationEntryCheckBoxFirst.click();
		AuthorizeBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(ClosebtnInFloatingMessage));

	}

	public void close_floating_msg_pop_up() {

		ClosebtnInFloatingMessage.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	public void click_close_button() {

		CloseBtn.click();

	}

}
