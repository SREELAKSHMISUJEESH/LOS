package com.beaconpro.module.uiobject.customer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerRegisterPage {

	WebDriver driver;

	// -----Customer Register Objects

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_txtCustomerId_txt")
	public WebElement CustomerIDField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_txtMemberShip_txt")
	public WebElement MemberNoField;

	@FindBy(xpath = "//*[@id='closePleail']")
	public WebElement OkBtnInValidationWarngWithNoInput;

	@FindBy(xpath = ".//*[@id='closeThexis']")
	public WebElement OkBtnInValidationWarngWithInvalidInput;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_lblErrorMessage']")
	public WebElement TextInWarngMsgWithNoInput;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_lblErrorMessage']")
	public WebElement TextInWarngMsgWithInvalidInput;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_btnAddCustomer1")
	public WebElement ViewButton;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_btnCancel")
	public WebElement CancelButton;

	// -----Customer Grid Objects

	@FindBy(xpath = "//*[@id='tblCustList']/tbody/tr[1]/td[1]")
	public WebElement CustomerIDLabelinGrid;

	public CustomerRegisterPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public CustomerRegisterPage() {
		// TODO Auto-generated constructor stub
	}

	public void open_liability_register_window() {

		WebElement element = driver.findElement(By.xpath("//li[4]/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	public void enter_data_in_custmer_id_field(String CuID) {

		CustomerIDField.clear();
		CustomerIDField.sendKeys(CuID);

	}

	public void enter_data_in_member_no_field(String membNo) {

		MemberNoField.sendKeys(membNo);

	}

	public void click_on_view_btn() {

		ViewButton.click();

	}

	public void click_on_cancel_btn() {

		CancelButton.click();

		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(ExpectedConditions.elementToBeClickable(ViewButton));

	}

	public void click_on_ok_btn_with_no_input_data() {

		OkBtnInValidationWarngWithNoInput.click();

	}

	public void click_on_ok_btn_with_invalid_input_data() {

		OkBtnInValidationWarngWithInvalidInput.click();
	}

	public void click_on_share_checkbox() {

	}

	// public void click_on_viewBtn_with_invalid_input() {

	// ViewButton.click();
	//
	// WebDriverWait wait = new WebDriverWait(driver, 100000);
	// wait.until(ExpectedConditions
	// .elementToBeClickable(OkBtnInValidationWarngWithInvalidInput));
	// OkBtnInValidationWarngWithInvalidInput.click();

	// }

	// public void click_on_viewBtn_with_valid_custID_input() {

	// ViewButton.click();

	// WebDriverWait wait = new WebDriverWait(driver, 100000);
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By
	// .xpath("CustomerIDGrid")));
	//
	// }

}
