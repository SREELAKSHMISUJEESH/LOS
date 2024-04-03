package com.beaconpro.test.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beaconpro.config.ExtentManager;
import com.beaconpro.module.uiobject.common.OpenPageDirectly;
import com.beaconpro.module.uiobject.customer.CustomerRegisterPage;
import com.beaconpro.module.uiobject.home.HomePage;
import com.beaconpro.module.uiobject.login.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomerRegisterValidations extends CustomerRegisterPage {

	ExtentReports extent;
	ExtentTest test;
	String ScreenShotDirectory = "E:\\BeaconProTestAutomation\\Test_Output\\Screen Shot";
	public static WebDriver driver;

	@BeforeClass
	public void setup() throws Throwable {

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("default");
		driver = new FirefoxDriver(ffprofile);

		LoginPage jss = new LoginPage(driver);
		jss.openUrlFor102();
		jss.loginToBeaconProValid("testqa", "test123");

	}

	@Test(priority = 0)
	public void view_details_without_enter_cust_id_details() throws Throwable {

		extent = ExtentManager.getInstance();
		test = extent.startTest("Customer Register Validation with No input",
				"Do some validations in customer register page");
		test.assignCategory("Customer Module");

		CustomerRegisterPage jss = new CustomerRegisterPage(driver);
		jss.open_liability_register_window();
		jss.click_on_view_btn();

		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(ExpectedConditions
				.elementToBeClickable(jss.OkBtnInValidationWarngWithNoInput));

		String Actualmsg3 = "Please Fill the Required Details";
		String MsgInPopUp3 = jss.TextInWarngMsgWithNoInput.getText();

		AssertJUnit.assertEquals(MsgInPopUp3, Actualmsg3);

		jss.click_on_ok_btn_with_no_input_data();

		test.log(LogStatus.PASS, "The warning pop-up showing without an error");

		driver.navigate().refresh();

		System.out.println("Test passed");
		extent.endTest(test);

	}

	@Test(priority = 1)
	public void view_details_with_invalid_data_in_customer_id_field() {

		test = extent
				.startTest("Customer Register Validation with Invalid input",
						"Checking for the validation message with invalid data as input");

		CustomerRegisterPage jss = new CustomerRegisterPage(driver);
		jss.enter_data_in_custmer_id_field("INVALID1234");
		jss.click_on_view_btn();

		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(ExpectedConditions
				.elementToBeClickable(jss.OkBtnInValidationWarngWithInvalidInput));

		String Actualmsg4 = "The customer id does not exist";
		String MsgInPopUp4 = jss.TextInWarngMsgWithNoInput.getText();

		AssertJUnit.assertEquals(MsgInPopUp4, Actualmsg4);

		jss.click_on_ok_btn_with_invalid_input_data();

		test.log(LogStatus.PASS, "The warning pop-up showing without an error");

		driver.navigate().refresh();
		extent.endTest(test);

	}

	@Test(priority = 2)
	public void view_details_with_valid_data_in_customer_id_field() {

		test = extent.startTest("Customer Register with Proper INput",
				"Enter a valid data in the input field");

		CustomerRegisterPage jss = new CustomerRegisterPage(driver);
		jss.enter_data_in_custmer_id_field("101000092318");
		jss.click_on_view_btn();

		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(ExpectedConditions.visibilityOf(jss.CustomerIDLabelinGrid));

		test.log(LogStatus.PASS, "Customer details showing without an error");

		extent.endTest(test);

	}

	@AfterClass
	public void afterTest() throws Throwable {

		try {

			OpenPageDirectly jss1 = new OpenPageDirectly(driver);
			jss1.open_quick_customer_window();

			HomePage test2 = new HomePage(driver);
			test2.HomeBtn.click();
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
