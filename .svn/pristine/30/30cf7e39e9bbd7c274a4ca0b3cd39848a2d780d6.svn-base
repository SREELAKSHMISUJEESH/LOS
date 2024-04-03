package com.beaconpro.module.uiobject.customer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InstitutionalCustomerPage {

	WebDriver driver;

	// Institutional Tab

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtFirstName_txt")
	public WebElement FirstNameField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtDisplayName_txt")
	public WebElement DisplayNameField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlConstType_ddl")
	public WebElement ConstTypeDropDownField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlBusiness_ddl")
	public WebElement BusinessDropDownField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlRegdTo_ddl")
	public WebElement RegdToDropDownField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_dtDateOfIncOp_txt")
	public WebElement DateOfIncOpField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtRegNo_txt")
	public WebElement RegNoField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtRegPalce_txt")
	public WebElement RegPlaceField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtPan_txt")
	public WebElement PANnoField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtCST_txt")
	public WebElement CSTField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtPin_txt")
	public WebElement PINField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtTIN_txt")
	public WebElement TINField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtTANNo_txt")
	public WebElement TANnoField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtFAXNo_txt")
	public WebElement FAXNoField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtEmail_txt")
	public WebElement EmailField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtCountryCode_txt")
	public WebElement MobileNoCountryCodeField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtMobileNo_txt")
	public WebElement MobileNoField;

	@FindBy(id = "ctl00_CPHFrame_btnSave")
	public WebElement SaveAndProceedBtn;

	@FindBy(xpath = ".//*[@id='FloatingErrorMessageBoxTop']/span[1]")
	public WebElement ErrorMessageBoxAtTop;

	@FindBy(xpath = ".//*[@id='closetop']")
	WebElement CloseButtonInErrorMessageBoxAtTop;

	// Address Tab

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtHouse_txt")
	public WebElement OfficialBuildingNameField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtHouseNo_txt")
	public WebElement OfficialBuildingNoField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtDoorNo_txt")
	public WebElement OfficialDoorNoField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_ddlState_ddl")
	public WebElement OfficialStateDropDownField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_ddlPost_ddl")
	public WebElement OfficialPostDropDownField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtPlace_txt")
	public WebElement OfficialPlaceField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtCity_txt")
	public WebElement OfficialCityField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtStreet_txt")
	public WebElement OfficialStreetField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtResidence_txt")
	public WebElement OfficialResidenceField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtPhoneNo_txt")
	public WebElement OfficialPhoneField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtElectricPostNo_txt")
	public WebElement OfficialElectricPostNoField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_chkMailAddress")
	public WebElement OfficialMailingAdressCheckBox;

	// Introducer Tab

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_cbNotRequired")
	public WebElement IntroducerNotRequiredCheckBox;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtReason_txt")
	public WebElement ReasonField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtIntCust_ID_txt")
	public WebElement CustomerIDField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtIntName_txt")
	public WebElement IntNameField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_btnShowActiveAccount")
	public WebElement ActiveAccountBtn;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_btnCLose")
	public WebElement ClosetBtn;

	@FindBy(xpath = ".//*[@id='tblintroduceActiveAccount']/thead/tr/td[1]")
	public WebElement FirstNameLabelinGrid;

	// Identity and Area

	@FindBy(id = "ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_ddlDocType_ID_ddl")
	public WebElement IdentityTypeDropDownField;

	@FindBy(id = "ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_txtDoc_No_txt")
	public WebElement IdentityNoField;

	@FindBy(id = "ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_ddlDocProofType_ddl")
	public WebElement ProofTypeDropDownField;

	@FindBy(id = "ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_txtIssuedAuthority_txt")
	public WebElement IssueAuthorityField;

	@FindBy(id = "ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_dtIssueDate_txt")
	public WebElement IssueDateField;

	@FindBy(id = "ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_dtValidupTo_txt")
	public WebElement ValidUpToField;

	@FindBy(id = "ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_txtRemarks_txt")
	public WebElement DetailsField;

	@FindBy(id = "ctl00_CPHFrame_btnDocAdd")
	public WebElement AddBtnAtIdentityDetails;

	// External Account

	@FindBy(id = "ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlAccount_ddl")
	public WebElement ExtAcIdDropDownField;

	@FindBy(id = "ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtExtAc_No_txt")
	public WebElement ExtAcNoField;

	@FindBy(id = "ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlBank_ID_ddl")
	public WebElement BankIDDropDownField;

	@FindBy(id = "ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_dtStartDate_txt")
	public WebElement StartDateField;

	@FindBy(id = "ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_dtAsOn_txt")
	public WebElement BalanceAsOnField;

	@FindBy(id = "ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtBalance_txt")
	public WebElement BalanceField;

	@FindBy(id = "ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_chkCreditCard")
	public WebElement CreditCardCheckBox;

	@FindBy(id = "ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtCreditCardNo_txt")
	public WebElement CreditCardNoField;

	@FindBy(id = "ctl00_CPHFrame_btnSave")
	public WebElement AddBtn;

	@FindBy(xpath = ".//*[@id='ctl00_CPHFrame_lstDocumentView_lbl89']")
	public WebElement IssuedAuthorityLabelInIdentityTypeGrid;

	// External A/c details

	@FindBy(xpath = ".//*[@id='middlediv']/div/div/table/tbody/tr/td/div/table/tbody/tr[5]/td/table/tbody/tr[1]/td[3]")
	public WebElement BankLabelInExtAccountGrid;

	@FindBy(id = "ctl00_CPHFrame_btnNext")
	public WebElement ProceedBtn;

	// Risk and Other Details

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_ddlRiskID_ddl")
	public WebElement RiskIdDropDown;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_txtRemarks_txt")
	public WebElement RemarksField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_txtActiveSpecialInstruction_txt")
	public WebElement ActiveSpecialInstructionField;

	@FindBy(id = "ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_chkSusp")
	public WebElement SuspeciousCheckBox;

	// Photo and Sign

	@FindBy(id = "ctl00_CPHFrame_btnFinish")
	public WebElement FinishBtn;

	// Final Summary Page

	@FindBy(id = "ctl00_CPHFrame_btnClose")
	public WebElement OkBtnAfterClickOnFinish;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_CustContent_ucCustProfProg_lbPersonal']")
	public WebElement FocusOnTop;

	public InstitutionalCustomerPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public InstitutionalCustomerPage() {
		// TODO Auto-generated constructor stub
	}

	public void enter_first_name(String frstName) {

		FirstNameField.clear();
		FirstNameField.sendKeys(frstName);
	}

	public void select_const_type_dropdown(int index) {

		Select drop = new Select(ConstTypeDropDownField);
		drop.selectByIndex(index);

	}

	public void select_business_dropdown(int index) {

		Select drop = new Select(BusinessDropDownField);
		drop.selectByIndex(index);

	}

	public void select_regd_to_dropdown(int index) {

		Select drop = new Select(RegdToDropDownField);
		drop.selectByIndex(index);

	}

	public void enter_DateOfIncOp(String setDateofbirth) {

		DateOfIncOpField.click();
		DateOfIncOpField.sendKeys(setDateofbirth);
		DateOfIncOpField.sendKeys(Keys.TAB);
	}

	public void enter_reg_no(String strRegNo) {

		RegNoField.clear();
		RegNoField.sendKeys(strRegNo);
	}

	public void enter_reg_place(String regPlace) {

		RegPlaceField.clear();
		RegPlaceField.sendKeys(regPlace);
	}

	public void enter_pan(String strPAN) {

		PANnoField.clear();
		PANnoField.sendKeys(strPAN);
	}

	public void enter_cst(String strCST) {

		CSTField.clear();
		CSTField.sendKeys(strCST);
	}

	public void enter_pin(String strPIN) {

		PINField.clear();
		PINField.sendKeys(strPIN);
	}

	public void enter_tin(String strTIN) {

		TINField.clear();
		TINField.sendKeys(strTIN);
	}

	public void enter_tan_no(String strTAN) {

		TANnoField.clear();
		TANnoField.sendKeys(strTAN);
	}

	public void enter_fax_no(String strFAX) {

		FAXNoField.clear();
		FAXNoField.sendKeys(strFAX);
	}

	public void enter_email(String strEmail) {

		EmailField.clear();
		EmailField.sendKeys(strEmail);
	}

	public void enter_mob_no_country_code(String ctryCD) {

		MobileNoCountryCodeField.clear();
		MobileNoCountryCodeField.sendKeys(ctryCD);

	}

	public void enter_mob_no(String strMobleNo) {

		MobileNoField.clear();
		MobileNoField.sendKeys(strMobleNo);

	}

	public void click_on_save_and_proceed() throws Throwable {

		SaveAndProceedBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void click_on_close_btn_in_error_msg_at_top() {

		CloseButtonInErrorMessageBoxAtTop.click();
	}

	public void wait_for_warning_msg_displayed() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
				.xpath(".//*[@id='FloatingErrorMessageBoxTop']")));

		Thread.sleep(3000);

		driver.findElement(By.id(".//*[@id='closetop']")).click();

	}

	// Address Tab Action

	public void enter_official_building_name(String strbuild) {

		OfficialBuildingNameField.clear();
		OfficialBuildingNameField.sendKeys(strbuild);
	}

	public void enter_official_building_no(String strBuldNo) {

		OfficialBuildingNoField.clear();
		OfficialBuildingNoField.sendKeys(strBuldNo);

	}

	public void enter_official_door_no(String strDoorNo) {

		OfficialDoorNoField.clear();
		OfficialDoorNoField.sendKeys(strDoorNo);

	}

	public void select_official_post_dropdown(int index) {

		Select drop = new Select(OfficialPostDropDownField);
		drop.selectByIndex(index);

	}

	public void enter_official_place(String strplace) {

		OfficialPlaceField.clear();
		OfficialPlaceField.sendKeys(strplace);

	}

	public void enter_official_city(String strcity) {

		OfficialCityField.clear();
		OfficialCityField.sendKeys(strcity);

	}

	public void enter_official_street(String strstreet) {

		OfficialStreetField.clear();
		OfficialStreetField.sendKeys(strstreet);

	}

	public void enter_official_recidence(String strReside) {

		OfficialResidenceField.clear();
		OfficialResidenceField.sendKeys(strReside);

	}

	public void enter_official_phone(String strPhone) {

		OfficialPhoneField.clear();
		OfficialPhoneField.sendKeys(strPhone);

	}

	public void enter_official_electric_post(String strElectricPst) {

		OfficialElectricPostNoField.clear();
		OfficialElectricPostNoField.sendKeys(strElectricPst);

	}

	public void click_on_official_mailing_address_checkbox() {

		OfficialMailingAdressCheckBox.click();
	}

	// Introducer Tab

	public void click_on_intro_not_req_checkbox() {

		IntroducerNotRequiredCheckBox.click();
	}

	public void enter_intro_not_required_reason(String strReason) {

		ReasonField.clear();
		ReasonField.sendKeys(strReason);

	}

	// Enter identity & Area

	public void select_identity_type(int index) {

		Select drop = new Select(IdentityTypeDropDownField);
		drop.selectByIndex(index);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(IdentityNoField));

	}

	public void enter_identity_no(String idnNoFld) {

		IdentityNoField.clear();
		IdentityNoField.sendKeys(idnNoFld);
	}

	public void enter_issued_identity_authority(String idenAuth) {

		IssueAuthorityField.clear();
		IssueAuthorityField.sendKeys(idenAuth);

	}

	public void click_on_add_btn_to_add_identity_type() {

		AddBtnAtIdentityDetails.click();

	}

	public void wait_for_text_present_in_grid_after_add_identity() {

		// String textToAppear = "Issued Authority";

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(
				IssuedAuthorityLabelInIdentityTypeGrid, "Issued Authority"));
	}

	public void focus_to_down_identity_area() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('ctl00_CPHFrame_btnSave').focus();");

	}

	public void click_on_proceed_btn() {

		ProceedBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void click_on_finish_btn() {

		FinishBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void click_on_ok_btn_after_customer_creation() {

		OkBtnAfterClickOnFinish.click();
	}

	public void focus_on_top_after_inst_cust_creation() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('ctl00_ctl00_CPH1_CustContent_ucCustProfProg_lbUpload').focus();");

	}

}
