package com.beaconpro.test.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beaconpro.config.ExtentManager;
import com.beaconpro.module.uiobject.common.OpenPageDirectly;
import com.beaconpro.module.uiobject.customer.QuickCustomerPage;
import com.beaconpro.module.uiobject.home.HomePage;
import com.beaconpro.module.uiobject.login.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QuickCustomerCreation {

	// **Code for Extend report
	ExtentReports extent;
	ExtentTest test;
	String ScreenShotDirectory = "E:\\BeaconProTestAutomation\\Test_Output\\Screen Shot";
	public static WebDriver driver;

	@BeforeClass
	public void open_link_and_log_into_cbs() throws Throwable {

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("jss");
		driver = new FirefoxDriver(ffprofile);

		LoginPage objlogin = new LoginPage(driver);
		objlogin.openUrlFor102();
		objlogin.loginToBeaconProValid("testqc", "test123");

	}

	@Test(priority = 0)
	public void quick_customer_creation_with_all_parameters() throws Throwable {

		try {

			extent = ExtentManager.getInstance();
			// **Code for Extend report
			test = extent.startTest("Quick customer Creation",
					"Create Quick Customer With all possible inputs");
			test.assignCategory("Customer Module");

			// opening quick customer window by java executer

			OpenPageDirectly open = new OpenPageDirectly(driver);
			open.open_quick_customer_window();

			System.out.println("Quick customer window launched successfully");

			QuickCustomerPage enter_details = new QuickCustomerPage(driver);
			enter_details.select_qck_cst_sal_dropdown(4);
			enter_details.enter_first_name("YOGEQQNDER");
			enter_details.enter_middle_name("RAMA");
			enter_details.enter_last_name("KOSHI");
			enter_details.select_date_of_birth("11111990");
			enter_details.select_gender(2);
			enter_details.select_qualification(2);
			enter_details.select_religion(1);
			enter_details.select_category(1);
			enter_details.select_marital_status(1);
			enter_details.select_occupational_group(1);
			enter_details.enter_occupation("MAK");
			enter_details.enter_occu_organisation("LOKASH PVT LTD");
			enter_details.enter_adhar("254444547844");
			enter_details.enter_STD_code("0495");
			enter_details.enter_phone_number("2458454");
			enter_details.enter_mobile_no("949512544");
			enter_details.enter_email_id("jasim@gmail.com");

			// Take screen shot
			String CompletePath1 = ScreenShotDirectory
					+ "QuickCustomerPart1.PNG";
			//ScreenShot record = new ScreenShot(driver);
			//record.take_screen_shot(CompletePath1);

			// **Code for Extend report
			test.log(
					LogStatus.PASS,
					"Quick Customer INFO entred successfully. Refer below screen shot",
					test.addScreenCapture(CompletePath1));
			// test.assignCategory("Regression");

			enter_details.focus_to_down();
			System.out.println("Enter present address details");

			enter_details.enter_present_house_name("CHAOS");
			enter_details.enter_present_house_no("24/NO");
			enter_details.enter_present_door_no("4AS");
			enter_details.select_present_post(5);
			enter_details.enter_present_place("KANUR");
			enter_details.enter_present_city("KOLASH");
			enter_details.enter_present_street("MADIKOSH");
			enter_details.enter_present_residence("MASHING");
			enter_details.enter_present_phone_no("9425444111");
			enter_details.enter_present_electric_post("kj-0/78");
			System.out.println("Present address details entered successfully");

			System.out.println("Enter permenant address details");
			enter_details.enter_permanent_house_name("KOSHIN");
			enter_details.enter_permanent_house_no("lk/09");
			enter_details.enter_permanent_door_no("9HAS");
			enter_details.select_permanent_post(5);
			enter_details.enter_permanent_place("calicut");
			enter_details.enter_permanent_city("MUMBAI");
			enter_details.enter_permanent_street("POSINUASH");
			enter_details.enter_permanent_residence("madhavan residency");
			enter_details.enter_permanent_phone_no("9454788774");
			enter_details.enter_permanent_electric_post_no("45");

			// Take Screen shot
			String CompletePath2 = ScreenShotDirectory
					+ "QuickCustomerPart2.PNG";
			//record.take_screen_shot(CompletePath2);

			// **Code for Extend report - Screen Shot
			test.log(
					LogStatus.PASS,
					"Customer Address Details Entered Successfully. Refer below screen shot",
					test.addScreenCapture(CompletePath2));

			System.out.println("click on check availability");

			enter_details.click_on_check_availability_btn();
			test.log(LogStatus.PASS, "Check Availabity Functionality Verified");
			enter_details.click_on_save_btn();
			test.log(LogStatus.PASS, "The customer details saved");
			enter_details.click_warningPopUp_after_creation();
			test.log(LogStatus.PASS,
					"Warning Pop-up showing customer Details Correctly");
			extent.endTest(test);

		}

		catch (Exception e) {
			test.log(LogStatus.ERROR, e.getMessage());
			e.printStackTrace();

		}

	}

	@AfterClass
	public void signout_from_cbs() {

		try {

			HomePage test1 = new HomePage(driver);
			test1.SignOutFromCBS();

			// **Extend report
			// test.log(LogStatus.PASS, "User sign out from the CBS ");

			extent.flush();
			extent.close();
			driver.quit();
		} catch (Exception e) {
			test.log(LogStatus.ERROR, e.getMessage());
			e.printStackTrace();
		}

	}
}
