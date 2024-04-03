package com.beaconpro.module.uiobject.customer;

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

public class QuickCustomerPage {

	WebDriver driver;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlSalutation_ddl")
	WebElement SalutationDropDownField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtFirstName_txt")
	WebElement FirstNameField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtMiddleName_txt")
	WebElement MiddleNameField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtLastName_txt")
	WebElement LastNameField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtAliasName_txt")
	WebElement AliaseNameField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtDisplayName_txt")
	WebElement DisplayNameField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtDateOfBirth_txt")
	WebElement DOBField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtAge_txt")
	WebElement AgeField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_dtAgeAsOnDate_txt")
	WebElement AgeasOnField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlGender_ddl")
	WebElement GenderField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlQual_ID_ddl")
	WebElement QualificationField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlReligion_ID_ddl")
	WebElement ReligionField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlCaste_ID_ddl")
	WebElement CategoryField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlFamilyStatus_ID")
	WebElement MaritalStatusField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlOccup_ID_ddl")
	WebElement OccupationGroupField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtOccupation_txt")
	WebElement OccupationField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtOccupationOrganisation_txt")
	WebElement OccupationOrganizationField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtMonthlyIncome_txt")
	WebElement MonthlyincomeField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtUniversal_ID_txt")
	WebElement AdharNoField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtPAN_txt")
	WebElement PANField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtStdCode_txt")
	WebElement PhoneNoSTDField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtPhoneNo_txt")
	WebElement PhoneNoField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtMobileNo_txt")
	WebElement MobileNoField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtEMail_txt")
	WebElement EmailField;

	// Present Address

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtHouse_txt")
	WebElement PresentHouseNameField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtHouseNo_txt")
	WebElement PresentHouseNoField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtDoorNo_txt")
	WebElement PresentDoorNoField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_ddlPost_ddl")
	WebElement PresentPostField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtPlace_txt")
	WebElement PresentPlaceField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtCity_txt")
	WebElement PresentCityField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtStreet_txt")
	WebElement PresentStreetField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtResidence_txt")
	WebElement PresentResidence;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtPhoneNo_txt")
	WebElement PresentPhoneNoField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtElectricPostNo_txt")
	WebElement PresentElectricPostNoField;

	// Permanent address

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_txtHouse_txt")
	WebElement PermanentHouseNameField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_txtHouseNo_txt")
	WebElement PermanentHouseNoField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_txtDoorNo_txt")
	WebElement PermanentDoorNoField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_ddlPost_ddl")
	WebElement PermanentPostField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_txtPlace_txt")
	WebElement PermanentPlaceField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_txtCity_txt")
	WebElement PermanentCityField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_txtStreet_txt")
	WebElement PermanentStreetField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_txtResidence_txt")
	WebElement PermanentResidenceField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_txtPhoneNo_txt")
	WebElement PermanentPhoneNoField;

	@FindBy(id = "ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_txtElectricPostNo_txt")
	WebElement PermanentElectricPostNoField;

	// Buttons

	@FindBy(id = "btnCheckAvailability")
	WebElement CheckAvailabilityBtn;

	@FindBy(id = "ctl00_CPH1_btnSave")
	WebElement SaveBtn;

	@FindBy(id = "ctl00_CPH1_btnNew")
	WebElement NewBtn;

	@FindBy(id = "btnBannedCustList")
	WebElement CheckBannedBtn;

	@FindBy(xpath = "//*[@id='closetop']")
	WebElement WarngMsg;

	public QuickCustomerPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public void select_qck_cst_sal_dropdown(int index) {
		Select drop = new Select(SalutationDropDownField);
		drop.selectByIndex(index);
		// Good code :)
	}

	public void enter_first_name(String strFirstName) {

		FirstNameField.sendKeys(strFirstName);

	}

	public void enter_middle_name(String strMiddleName) {

		MiddleNameField.sendKeys(strMiddleName);

	}

	public void enter_last_name(String strLastName) {

		LastNameField.sendKeys(strLastName);
	}

	public void enter_aliase_name(String strAliaseName) {

		AliaseNameField.sendKeys(strAliaseName);

	}

	public void select_date_of_birth(String setDateofbirth) {

		DOBField.click();
		DOBField.sendKeys(setDateofbirth);
		DOBField.sendKeys(Keys.TAB);
	}

	public void select_gender(int index) {
		Select drop = new Select(GenderField);
		drop.selectByIndex(index);

	}

	public void select_qualification(int index) {
		Select drop = new Select(QualificationField);
		drop.selectByIndex(index);

	}

	public void select_religion(int index) {
		Select drop = new Select(ReligionField);
		drop.selectByIndex(index);

	}

	public void select_category(int index) {
		Select drop = new Select(CategoryField);
		drop.selectByIndex(index);

	}

	public void select_marital_status(int index) {
		Select drop = new Select(MaritalStatusField);
		drop.selectByIndex(index);

	}

	public void select_occupational_group(int index) {
		Select drop = new Select(OccupationGroupField);
		drop.selectByIndex(index);
	}

	public void enter_occupation(String stroccupation) {

		OccupationField.sendKeys(stroccupation);

	}

	public void enter_occu_organisation(String stroccuorganization) {

		OccupationOrganizationField.sendKeys(stroccuorganization);

	}

	public void enter_monthly_income(String strmonthlyincome) {

		MonthlyincomeField.sendKeys(strmonthlyincome);

	}

	public void enter_adhar(String stradhar) {

		AdharNoField.sendKeys(stradhar);

	}

	public void enter_STD_code(String strSTD) {

		PhoneNoSTDField.sendKeys(strSTD);

	}

	public void enter_phone_number(String strphoneNumber) {

		PhoneNoField.sendKeys(strphoneNumber);

	}

	public void enter_mobile_no(String strmobileno) {

		MobileNoField.sendKeys(strmobileno);

	}

	public void enter_email_id(String stremailid) {

		EmailField.sendKeys(stremailid);

	}

	public void focus_to_down() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('ctl00_CPH1_btnNew').focus();");
	}

	// Present Address section

	public void enter_present_house_name(String strprehouse) {

		PresentHouseNameField.sendKeys(strprehouse);
	}

	public void enter_present_house_no(String strprehouseno) {

		PresentHouseNoField.sendKeys(strprehouseno);
	}

	public void enter_present_door_no(String strpredoorno) {

		PresentDoorNoField.sendKeys(strpredoorno);
	}

	public void select_present_post(int index) {
		Select drop = new Select(PresentPostField);
		drop.selectByIndex(index);
	}

	public void enter_present_place(String strpreplace) {

		PresentPlaceField.sendKeys(strpreplace);
	}

	public void enter_present_city(String strpreplace) {

		PresentCityField.sendKeys(strpreplace);
	}

	public void enter_present_street(String strprestreet) {

		PresentStreetField.sendKeys(strprestreet);
	}

	public void enter_present_residence(String strpreresidence) {

		PresentResidence.sendKeys(strpreresidence);
	}

	public void enter_present_phone_no(String strprephoneno) {

		PresentPhoneNoField.sendKeys(strprephoneno);
	}

	public void enter_present_electric_post(String strpreelectricpost) {

		PresentElectricPostNoField.sendKeys(strpreelectricpost);
	}

	// Permanent Address section

	public void enter_permanent_house_name(String strpermhouse) {

		PermanentHouseNameField.sendKeys(strpermhouse);
	}

	public void enter_permanent_house_no(String strpermhouseno) {

		PermanentHouseNoField.sendKeys(strpermhouseno);
	}

	public void enter_permanent_door_no(String strpermdoorno) {

		PermanentDoorNoField.sendKeys(strpermdoorno);
	}

	public void select_permanent_post(int index) {
		Select drop = new Select(PermanentPostField);
		drop.selectByIndex(index);
	}

	public void enter_permanent_place(String strpermplace) {

		PermanentPlaceField.sendKeys(strpermplace);
	}

	public void enter_permanent_city(String strpermplace) {

		PermanentCityField.sendKeys(strpermplace);
	}

	public void enter_permanent_street(String strpermstreet) {

		PermanentStreetField.sendKeys(strpermstreet);
	}

	public void enter_permanent_residence(String strpermresidence) {

		PermanentResidenceField.sendKeys(strpermresidence);
	}

	public void enter_permanent_phone_no(String strpermphoneno) {

		PermanentPhoneNoField.sendKeys(strpermphoneno);
	}

	public void enter_permanent_electric_post_no(String strpermelectricpost) {

		PermanentElectricPostNoField.sendKeys(strpermelectricpost);
	}

	public void click_warningPopUp_after_creation() {

		WarngMsg.click();
	}

	// click on check availability

	public void click_on_check_availability_btn() throws Throwable {

		String OrgWindowHan = driver.getWindowHandle();

		CheckAvailabilityBtn.click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='form1']/div[2]/table/tbody/tr/td")));

		Thread.sleep(3000);

		driver.close();

		driver.switchTo().window(OrgWindowHan);

	}

	public void click_on_save_btn() throws InterruptedException {

		SaveBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='ctl00_CPH1_ppDiv']")));

		Thread.sleep(4000);

		driver.findElement(By.id("ctl00_CPH1_btnClosechange")).click();

	}

}