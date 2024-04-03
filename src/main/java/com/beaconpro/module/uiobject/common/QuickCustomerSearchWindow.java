package com.beaconpro.module.uiobject.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickCustomerSearchWindow {

	WebDriver driver;

	@FindBy(id = "PopQuick1_txtName")
	public WebElement NameFieldInQckSearchPopUp;

	@FindBy(id = "PopQuick1_txtCustID")
	public WebElement CustIDFieldInQckSearchPopUp;

	@FindBy(id = "PopQuick1_txtMobileNo")
	public WebElement MobileNoFieldInQckSearchPopUp;

	@FindBy(id = "PopQuick1_txtPanNo")
	public WebElement PanNoFieldInQckSearchPopUp;

	@FindBy(id = "PopQuick1_txtHouseName")
	public WebElement HouseNameFieldInQckSearchPopUp;

	@FindBy(id = "PopQuick1_IsKYCComplaint")
	public WebElement IsKYCcomplaintOnlyCheckBoxInQckSearchPopUp;

	@FindBy(id = "PopQuick1_chkadvancedSearch")
	public WebElement AdvncdMemberSearchCheckBoxInQckSearchPopUp;

	@FindBy(id = "PopQuick1_btnSearch")
	public WebElement SearchBtnInQckSearchPopUp;

	@FindBy(xpath = ".//*[@id='tblCustList']/thead/tr/th[2]")
	public WebElement CustIDLabelInQckSearchPopUp;

	public QuickCustomerSearchWindow(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public QuickCustomerSearchWindow() {
		// TODO Auto-generated constructor stub
	}

	public void enter_data_in_name_field(String InptName) {

		NameFieldInQckSearchPopUp.sendKeys(InptName);

	}

	public void enter_data_in_custid_field(String InptCstID) {

		CustIDFieldInQckSearchPopUp.sendKeys(InptCstID);
	}

	public void enter_data_in_mobileno_field(String InptMbNo) {

		MobileNoFieldInQckSearchPopUp.sendKeys(InptMbNo);
	}

	public void enter_data_in_pan_no_field(String InptPAN) {

		PanNoFieldInQckSearchPopUp.sendKeys(InptPAN);
	}

	public void enter_data_in_house_name_field(String InptPAN) {

		HouseNameFieldInQckSearchPopUp.sendKeys(InptPAN);
	}

	public void click_on_search_btn() {

		SearchBtnInQckSearchPopUp.click();
	}

	public void click_on_kyccomplaint_checkbox() {

		IsKYCcomplaintOnlyCheckBoxInQckSearchPopUp.click();
	}

	public void click_on_advanced_search_checkbox() {

		AdvncdMemberSearchCheckBoxInQckSearchPopUp.click();
	}

}
