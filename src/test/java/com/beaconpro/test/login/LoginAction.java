package com.beaconpro.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.home.HomePage;
import com.beaconpro.module.uiobject.login.LoginPage;

public class LoginAction {

	public static WebDriver driver;

	@BeforeClass
	public void setup() throws Throwable {

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("orbit lite");
		driver = new FirefoxDriver(ffprofile);

		LoginPage sdf = new LoginPage(driver);
		sdf.openUrlFor102();

	}

	@Test(priority = 0)
	public void login_validation_for_username_and_password_field()
			throws Throwable {
		try {

			LoginPage login = new LoginPage(driver);
			login.setPassword("testqa");
			login.clickLogin();

			String MsgInPopUp1 = login.UsrNmRquirdValidationMsg.getText();
			System.out.println("Text from Ajax Pop-Up Displayed :"
					+ MsgInPopUp1);

			login.ClosBtnInUsrNmRquirdValidationMsg.click();
			driver.navigate().refresh();

			login.setUserName("testqa");
			login.clickLogin();

			String MsgInPopUp2 = login.PwdRquirdValidationMsg.getText();
			String Actual2 = "Password is Required";

			System.out
					.println("Text from Ajax Pop-Up Displayed:" + MsgInPopUp2);
			Assert.assertEquals(MsgInPopUp2, Actual2);

			login.ClosBtnInPwdRquirdValidationMsg.click();
			driver.navigate().refresh();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 1)
	public void login_to_CBS_with_invalid_credentials() {

		try {

			LoginPage invalidLogin = new LoginPage(driver);
			invalidLogin.setUserName("INVALIDUSERNAME");
			invalidLogin.setPassword("INVALIDPASSWORD");
			invalidLogin.clickLogin();

			WebDriverWait wait = new WebDriverWait(driver, 100000);
			wait.until(ExpectedConditions.textToBePresentInElement(
					invalidLogin.InvalidLoginErrorMsg,
					"The username or password you entered is incorrect"));

		} catch (Exception e) {

			e.printStackTrace();
			driver.quit();

		}

	}

	@Test(priority = 2)
	public void login_to_CBS_with_valid_credentials_and_sign_out()
			throws Throwable {

		LoginPage loginvalid = new LoginPage(driver);
		loginvalid.loginToBeaconProValid("testqa", "test123");

	}

	@AfterClass
	public void signout_from_cbs() {

		try {

			HomePage test1 = new HomePage(driver);
			test1.SignOutFromCBS();

			driver.quit();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
