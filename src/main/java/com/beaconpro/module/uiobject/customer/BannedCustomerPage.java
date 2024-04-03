package com.beaconpro.module.uiobject.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BannedCustomerPage {

	WebDriver driver;

	@FindBy(id = "ctl00_CPH1_ddlSalution_ddl")
	public WebElement SalutationDropDownField;

	@FindBy(id = "ctl00_CPH1_txtName_txt")
	public WebElement BannedCustomerNameField;

	@FindBy(id = "ctl00_CPH1_dtDOB_txt")
	public WebElement DOBField;

	@FindBy(id = "ctl00_CPH1_txtHouse_txt")
	public WebElement HouseNameField;

	@FindBy(id = "ctl00_CPH1_ddlDistID_ddl")
	public WebElement DistrictDropDownField;

	@FindBy(id = "ctl00_CPH1_ddlPost_ddl")
	public WebElement PostDropDownField;

	@FindBy(id = "ctl00_CPH1_txtPin_txt")
	public WebElement PINnoField;

	@FindBy(id = "ctl00_CPH1_ddlGender_ddl")
	public WebElement GenderDropDownField;

	@FindBy(id = "ctl00_CPH1_ddlIncomeSource_TextControl")
	public WebElement IncomeSourceField;

	@FindBy(id = "ctl00_CPH1_txtPAN_txt")
	public WebElement PANnoField;

	@FindBy(id = "ctl00_CPH1_txtAuthorizedMobileNo_txt")
	public WebElement MobileNoField;

	@FindBy(id = "ctl00_CPH1_txtStdCode_txt")
	public WebElement PhoneNumberSTDCodeField;

	@FindBy(id = "ctl00_CPH1_txtPhoneNo_txt")
	public WebElement PhoneNumberField;

	// @FindBy(id = "")
	// public WebElement ;

	// @FindBy(id = "")
	// public WebElement ;

	// @FindBy(id = "")
	// public WebElement ;

	// @FindBy(id = "")
	// public WebElement ;

	public BannedCustomerPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

}
