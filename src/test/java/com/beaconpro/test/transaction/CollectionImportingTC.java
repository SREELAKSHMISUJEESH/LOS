package com.beaconpro.test.transaction;

/********************************************************************************************************************	
Created By   :  Yadhu 
Created On	 :	03/06/2016
Purpose	     :	Agent collections from collection importing page

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.TransactionModeSelection;
import com.beaconpro.module.uiobject.login.LoginPage;
import com.beaconpro.module.uiobject.transaction.CollectionImportingPage;

public class CollectionImportingTC {

	WebDriver driver;

	String AgentName = "VIJAYAN P K";
	String Branch = "MAIN BRANCH";
	String TransMode = "AUTOPOSTING"; // Trans_Modes are CASH,BATCH,AUTOPOSTING

	// AutoPosting Window
	String ProductGroup_AP = "Savings Bank";
	String ProductName_AP = "ORDINARY SB";
	String Branch_AP = "MAIN BRANCH";
	String Acno_AP = "2303";
	String InstrType_AP = "Advice Slip";

	public String transid;
	public String TransAmount ;

	private static String[] ProductGroups = new String[]

	{ "Pigmy Deposit", "Other Loan", "Recurring Deposit" };

	private String[] ProductNames = new String[] {};

	private static String[] DDAccountNumber = new String[] { "36259" };

	private static String[] OLAccountNumber = new String[] { "23218" };

	private static String[] RDAccountNumber = new String[] { "5042" };

	MenuList objML;
	CollectionImportingPage cip;

	@Test(priority = 0)
	public void opening_firefox() throws Exception {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("default");
		driver = new FirefoxDriver(ffprofile);
	}

	@Test(priority = 1)
	public void open_beaconpro_url_and_login() throws Throwable {
		LoginPage newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		newloginmaker.loginToBeaconProValid("testqc", "test123");
	}

	@Test(priority = 2)
	public void AgentCollections() {
		objML = new MenuList(driver);
		cip = new CollectionImportingPage(driver);

		objML.Open_window(objML.CollectionImporting);
		cip.Selection_from_dropdown(cip.ddl_AgentName, AgentName);

		for (int i = 0; i < ProductGroups.length; i++)

		{

			cip.Selection_from_dropdown(cip.ddl_Branch, Branch);
			String prductgrpName = ProductGroups[i];
			cip.ddl_ProductGroup.sendKeys(prductgrpName);

			// Selecting productGroup
			if (ProductGroups[i] == "Pigmy Deposit") {
				ProductNames = new String[] { "ORDINARY DD" };
			} else if (ProductGroups[i] == "Other Loan") {
				ProductNames = new String[] { "MORTGAGE OL" };
			} else if (ProductGroups[i] == "Recurring Deposit") {
				ProductNames = new String[] { "ORDINARY RD" };
			}

			// Selecting ProductName
			for (int j = 0; j < ProductNames.length; j++) {
				String PrdctName = ProductNames[j];
				cip.ddl_ProductType.sendKeys(PrdctName);

				if (PrdctName == "ORDINARY DD") {
					String AcNo = DDAccountNumber[j];
					cip.txt_AcNo.sendKeys(AcNo);
					cip.txt_AcNo.sendKeys(Keys.TAB);
				} else if (PrdctName == "MORTGAGE OL") {
					String AcNo = OLAccountNumber[j];
					cip.txt_AcNo.sendKeys(AcNo);
					cip.txt_AcNo.sendKeys(Keys.TAB);
				} else if (PrdctName == "ORDINARY RD") {
					String AcNo = RDAccountNumber[j];
					cip.txt_AcNo.sendKeys(AcNo);
					cip.txt_AcNo.sendKeys(Keys.TAB);
				}
			}

			String FrstAcNo = cip.Br_pro_AcNo.getAttribute("value");
			String SecondAcNo = cip.txt_AcNo.getAttribute("value");
			String FullAcNo = FrstAcNo + SecondAcNo;
			String InstAmount = cip.txt_InstAmount.getAttribute("value");
			cip.txt_Amount.sendKeys(InstAmount);
			cip.btn_Add.click();

			for (int numberOfRows = 1; numberOfRows <= 50; numberOfRows += 1)

			{
				try {
					String GridAcNo = driver
							.findElement(By.xpath(".//*[@id='tbAgent']/tbody/tr[" + numberOfRows + "]/td[4]"))
							.getText();
					if (GridAcNo.equalsIgnoreCase(FullAcNo)) {
						Assert.assertEquals(FullAcNo, GridAcNo);
						System.out.println("Equal " + numberOfRows);
						break;
					}
				} catch (Exception e) {
					System.out.println("Not equal " + numberOfRows);
				}
			}
		}
		TransAmount = cip.TransAmount.getAttribute("value");
		System.out.println("Trn amount :"+TransAmount);
	}

	@Test(priority = 3)
	public void Transmodes() {
		// Cash
		if (TransMode.equals("CASH")) {
			cip.Selection_from_dropdown(cip.ddl_TransactionMode, "CASH");
			cip.txt_Remarks.sendKeys("Test Remarks");
			cip.btn_Submit.click();
			cip.ExplicitWait_elementToBeClickable(cip.Transid_summary);
			transid = cip.Transid_summary.getText();
			System.out.println("Agent collection done successfully" + " " + "TransID : " + transid);
			// Batch Transfer
		} else if (TransMode.equals("BATCH")) {
			cip.Selection_from_dropdown(cip.ddl_TransactionMode, "TRANSFER");
			cip.txt_Remarks.sendKeys("Test Remarks_Batch");
			cip.btn_Submit.click();
			for (int i = 0; i < 100; i++)
				try {
					cip.btn_Ok_BatchOpenedPopup.click();
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			cip.ExplicitWait_elementToBeClickable(cip.Transid_summary);
			transid = cip.Transid_summary.getText();
			System.out.println("Agent collection done successfully" + " " + "TransID : " + transid);
			// Autoposting
		} else if (TransMode.equals("AUTOPOSTING")) {
			TransactionModeSelection objtms = new TransactionModeSelection(driver);
			cip.Selection_from_dropdown(cip.ddl_TransactionMode, "TRANSFER");
			String parentHandle = driver.getWindowHandle();
			cip.btn_AutoPost.click();
			objML.switchWindow(driver);
			objtms.Autoposting_PostDebit(TransAmount , ProductGroup_AP, ProductName_AP, Branch_AP, Acno_AP, InstrType_AP);
			driver.switchTo().window(parentHandle);
			cip.txt_Remarks.sendKeys("Test Remarks_Autopost");
			cip.btn_Submit.click();
			cip.ExplicitWait_elementToBeClickable(cip.Transid_summary);
			transid = cip.Transid_summary.getText();
			System.out.println("Agent collection done successfully" + " " + "TransID : " + transid);
		}
	}
}
