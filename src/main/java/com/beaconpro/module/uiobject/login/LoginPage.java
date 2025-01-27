package com.beaconpro.module.uiobject.login;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

	public WebDriver driver;

	@FindBy(id = "txtUserName_txt")
	public WebElement BeaconproUserNameField;

	@FindBy(id = "txtPassword_txt")
	public WebElement BeaconproPasswordField;

	@FindBy(id = "txtBranch_txt")
	public WebElement BeaconproBranchNameField;

	@FindBy(className = "LoginButton")
	public WebElement loginBtn;

	@FindBy(id = "lblErrorMessage")
	public WebElement InvalidLoginErrorMsg;

	@FindBy(xpath = ".//*[@id='txtUserName_OReq_popupTable']/tbody/tr[1]/td[3]")
	public WebElement UsrNmRquirdValidationMsg;

	@FindBy(xpath = ".//*[@id='txtPassword_OReq_popupTable']/tbody/tr[1]/td[3]")
	public WebElement PwdRquirdValidationMsg;

	@FindBy(xpath = ".//*[@id='txtUserName_OReq_popupTable']/tbody/tr[1]/td[4]/div/img")
	public WebElement ClosBtnInUsrNmRquirdValidationMsg;

	@FindBy(xpath = ".//*[@id='txtPassword_OReq_popupTable']/tbody/tr[1]/td[4]/div/img")
	public WebElement ClosBtnInPwdRquirdValidationMsg;

	@FindBy(xpath = ".//*[@id='form1']/div[4]")
	public WebElement AlreadyLoggedUserWarningPopUp;

	@FindBy(xpath = ".//*[@id='form1']/div[4]/div[3]/div/button[1]")
	public WebElement OKbuttoninAlreadyLoggedPopup;

	@FindBy(id = "logMessage")
	public WebElement LoggedUserWarningPopUpMessage;

	@FindBy(className = "ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable")
	public WebElement PopUpAfterSuccessfullLogin;

	@FindBy(id = "ctl00_CPH1_lblLoginUsername")
	public WebElement MsgInSuccessfullLogin_UsrNme;

	@FindBy(id = "ctl00_CPH1_lblLoginDateAndTime")
	public WebElement MsgInSuccessfullLogin_LoggedTime;

	@FindBy(id = "ctl00_CPH1_lblLoginBranch")
	public WebElement MsgInSuccessfullLogin_LoggedBranch;

	@FindBy(id = "ctl00_CPH1_lblLoginSystemName")
	public WebElement MsgInSuccessfullLogin_LoggedSystmName;

	@FindBy(id = "ctl00_CPH1_lblLoginLastActivity")
	public WebElement MsgInSuccessfullLogin_LastActivity;

	@FindBy(xpath = "html/body/div[1]/div[3]/div/button")
	public WebElement ContinueBtnOfSuccessfullLogin;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public LoginPage() {
		// TODO Auto-generated constructor stub
	}

	// Set user name in text box

	public void setUserName(String strUserName) {

		BeaconproUserNameField.clear();
		BeaconproUserNameField.sendKeys(strUserName);

	}

	// Set password in password text box

	public void setPassword(String strPassword) {

		BeaconproPasswordField.clear();
		BeaconproPasswordField.sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		loginBtn.click();

	}

	String Url = "http://192.168.0.27/yadhu/Login.aspx";

	public void openUrlFor102() throws IOException {

		try {

			driver.manage().window().maximize();

			driver.get(Url);
			Assert.assertEquals(true, loginBtn.isDisplayed());
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
					/*textToBePresentInElementValue(
					BeaconproBranchNameField, "MAIN BRANCH"));*/

			//System.out.println("Url launched successfully");

			// return;
		}

		catch (Exception e) {

			// ScreenShot validScreen = new ScreenShot(driver);
			// validScreen.take_screen_shot("E:\\BeaconProTestAutomation_Output\\openUrl\\Urlfailure.png");

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils
					.copyFile(
							scrFile,
							new File(
									"E:\\BeaconProTestAutomation\\Test_Output\\Screen Shot\\openUrl\\Urlfailure.png"));

			e.printStackTrace();
			driver.close();

		}

	}

	public void clickOkBtnOfAlreadyLoggedPop_up() {

		OKbuttoninAlreadyLoggedPopup.click();

		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(ExpectedConditions.visibilityOf(BeaconproBranchNameField));

	}

	public void loginToBeaconProValid(String strValidUserName,
			String strValidPasword) throws Throwable {

		try {

			String parentHandle = driver.getWindowHandle();
			this.setUserName(strValidUserName);
			this.setPassword(strValidPasword);
			this.clickLogin();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			if (driver.findElements(
					By.xpath(".//*[@id='form1']/div[4]/div[3]/div/button[1]"))
					.size() > 0) {

				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);

				}

				OKbuttoninAlreadyLoggedPopup.click();
				driver.switchTo().window(parentHandle);
				this.setUserName(strValidUserName);
				this.setPassword(strValidPasword);
				this.clickLogin();
				// driver.manage().timeouts().implicitlyWait(5,
				// TimeUnit.SECONDS);

				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions
						.visibilityOf(ContinueBtnOfSuccessfullLogin));

				ContinueBtnOfSuccessfullLogin.click();
				//System.out.print("success");

			} else {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				this.ContinueBtnOfSuccessfullLogin.click();
				System.out.print("entered in else part");
			}

		} catch (Error e) {
			e.printStackTrace();
		}

		//

	}

}
