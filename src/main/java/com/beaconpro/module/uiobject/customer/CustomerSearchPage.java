package com.beaconpro.module.uiobject.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerSearchPage {

	WebDriver driver;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtCust_Id_txt")
	public WebElement CustomrerIDField;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtMobileNo")
	public WebElement MobileNoField;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtPAN")
	public WebElement PanNoField;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtFirstName")
	public WebElement NameField;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtHouseName")
	public WebElement HouseNameField;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtGuardian1_txt")
	public WebElement ParentSpouseNameField;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtResidence")
	public WebElement ResidenceField;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_ddlDocType_ID")
	public WebElement DocTypeField;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtDoc_No")
	public WebElement DocNoField;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtUniversal_ID")
	public WebElement AdharNoField;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_ddlBranch_ddl")
	public WebElement BranchField;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_chkIsInstitutional")
	public WebElement IsInstitutionalCheckBox;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_chkIsCustomerComplaint")
	public WebElement IsKYCComplaintCheckBox;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_chkIsActive")
	public WebElement IsActiveCheckBox;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_btnSearch")
	public WebElement SearchBtn;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_Button1")
	public WebElement ClearBtn;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_UCCustView_UCCustCommToolBar_btnView")
	public WebElement ViewBtn;

	@FindBy(id = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_Button1")
	public WebElement CustIdLabelInCustomerGrid;

	@FindBy(xpath = ".//*[@id='tblCustList']/tbody/tr/td[3]")
	public WebElement CustIdInCustomerGrid;

	public CustomerSearchPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public CustomerSearchPage() {
		// TODO Auto-generated constructor stub
	}

	public void enter_details_in_customer_id_field(String custID) {

		CustomrerIDField.sendKeys(custID);
	}

	public void click_on_search_btn() {

		SearchBtn.click();
	}

}
