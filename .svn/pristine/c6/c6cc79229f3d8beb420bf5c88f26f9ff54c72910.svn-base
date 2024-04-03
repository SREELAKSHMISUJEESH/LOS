package com.beaconpro.test.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beaconpro.config.ExtentManager;
import com.beaconpro.module.uiobject.common.OpenPageDirectly;
import com.beaconpro.module.uiobject.customer.InstitutionalCustomerPage;
import com.beaconpro.module.uiobject.home.HomePage;
import com.beaconpro.module.uiobject.login.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class InstitutionalCustomerCreation {

	ExtentReports extent;
	ExtentTest test;
	public static WebDriver driver;

	// static ProfilesIni profile = new ProfilesIni();
	// static FirefoxProfile ffprofile = profile.getProfile("jss");
	// static WebDriver driver = new FirefoxDriver(ffprofile);

	@BeforeClass
	public void open_link_and_log_into_cbs() throws Throwable {

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("jss");
		driver = new FirefoxDriver(ffprofile);

		LoginPage objlogin = new LoginPage(driver);
		objlogin.openUrlFor102();
		objlogin.loginToBeaconProValid("testqc", "test123");

	}

	@Test
	public void institutional_customer_creation_with_all_parameters()
			throws Throwable {
		extent = ExtentManager.getInstance();
		test = extent.startTest("Institutional Customer Creation",
				"Create Institutional Customer With all possible inputs");

		test.assignCategory("Customer Module");

		OpenPageDirectly directopen = new OpenPageDirectly(driver);
		directopen.open_institutional_customer_window();
		// Good Code
		// Reason: To work with any element within a frame, you need to first
		// switch the context of the driver from the main page to that frame:
		driver.switchTo().frame("ctl00_ctl00_CPH1_CustContent_Cust");

		// Enter Institutional customer details

		InstitutionalCustomerPage instiCust = new InstitutionalCustomerPage(
				driver);
		instiCust.enter_first_name("INSTITUTIOn");
		instiCust.select_const_type_dropdown(3);
		instiCust.select_business_dropdown(3);
		instiCust.select_regd_to_dropdown(3);
		instiCust.enter_DateOfIncOp("11122012");
		instiCust.enter_reg_no("KO-89");
		instiCust.enter_reg_place("Calicut Cyber Park");
		instiCust.enter_pan("AAAPL1234C");
		instiCust.enter_cst("BHC-I-789");
		instiCust.enter_pin("670704");
		instiCust.enter_tin("12459514114");
		instiCust.enter_tan_no("AAAA99999A");
		instiCust.enter_fax_no("+9156224545");
		instiCust.enter_email("testmailformat@gmail.com");
		instiCust.enter_mob_no_country_code("+65");
		instiCust.enter_mob_no("9495121245");
		instiCust.click_on_save_and_proceed();

		// Enter official Address

		instiCust.enter_official_building_name("Test Building");
		instiCust.enter_official_building_no("KO-89r09");
		instiCust.enter_official_door_no("12554");
		instiCust.select_official_post_dropdown(5);
		instiCust.enter_official_place("CALICUT");
		instiCust.enter_official_city("MUMBAI");
		instiCust.enter_official_street("LASVEG STREEt");
		instiCust.enter_official_recidence("RAJA recidency");
		instiCust.enter_official_phone("9487444222");
		instiCust.enter_official_electric_post("ED/09");
		instiCust.click_on_official_mailing_address_checkbox();
		instiCust.click_on_save_and_proceed();

		// Enter Regional Address

		// Enter introducer

		instiCust.click_on_intro_not_req_checkbox();
		instiCust.enter_intro_not_required_reason("Direct Relation to Bank");
		instiCust.click_on_save_and_proceed();

		// Enter identity&Area details

		instiCust.select_identity_type(2);
		instiCust.enter_identity_no("45/76G74S6");
		instiCust.enter_issued_identity_authority("GOvmt of Kerala");
		instiCust.click_on_add_btn_to_add_identity_type();
		instiCust.wait_for_text_present_in_grid_after_add_identity();
		instiCust.focus_to_down_identity_area();
		instiCust.click_on_save_and_proceed();

		// Enter External A/C details

		instiCust.click_on_proceed_btn();

		// Enter Risk & Other Details

		instiCust.click_on_save_and_proceed();

		// Enter Photo/Sign

		instiCust.click_on_finish_btn();
		instiCust.click_on_ok_btn_after_customer_creation();

		driver.navigate().refresh();
		test.log(LogStatus.PASS,
				"Institutional Customer creation is successful");
		extent.endTest(test);

	}

	@Test
	public void tearDowm() throws Throwable {

		try {

			OpenPageDirectly jss1 = new OpenPageDirectly(driver);
			jss1.open_quick_customer_window();

			HomePage test2 = new HomePage(driver);
			// test2.HomeBtn.click();
			test2.SignOutFromCBS();

			// test.log(LogStatus.PASS, "User sign out from the CBS ");

			extent.flush();
			// extent.close();
			driver.quit();

		} catch (Exception e) {
			test.log(LogStatus.ERROR, e.getMessage());
			e.printStackTrace();
		}
	}

}
