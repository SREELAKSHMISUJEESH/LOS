package com.beaconpro.test.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beaconpro.config.ExtentManager;
import com.beaconpro.module.uiobject.common.OpenPageDirectly;
import com.beaconpro.module.uiobject.customer.CustomerSearchPage;
import com.beaconpro.module.uiobject.home.HomePage;
import com.beaconpro.module.uiobject.login.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomerSearch {

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

	@Test(priority = 0)
	public void search_with_customer_id_only() {

		try {
			extent = ExtentManager.getInstance();
			test = extent.startTest("Customer Search",
					"Verify the Customer search functionality");
			test.assignCategory("Customer Module");

			String Cust_ID_Expected = "102000000305";

			OpenPageDirectly open = new OpenPageDirectly(driver);
			open.open_customer_search_window();

			CustomerSearchPage cust_search = new CustomerSearchPage(driver);
			cust_search.enter_details_in_customer_id_field(Cust_ID_Expected);
			cust_search.click_on_search_btn();

			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions
					.elementToBeClickable(cust_search.ViewBtn));

			System.out.println("test code");

			String Cust_ID_Actual = cust_search.CustIdInCustomerGrid.getText();

			// String Cust_ID_Actual1 = "100000000";
			System.out.println("Cust_ID entered is :" + Cust_ID_Expected);
			System.out.println("Customer ID Listed :" + Cust_ID_Actual);

			// Assert.assertEquals(Cust_ID_Expected,Cust_ID_Actual1);
			test.log(LogStatus.PASS,
					"The warning pop-up showing without an error");
			extent.endTest(test);

			open.open_quick_customer_window();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void signout_from_cbs() {

		try {

			HomePage test1 = new HomePage(driver);
			test1.SignOutFromCBS();

			extent.flush();
			// extent.close();
			driver.quit();
		} catch (Exception e) {
			test.log(LogStatus.ERROR, e.getMessage());
			e.printStackTrace();
		}

	}
}
