package com.beaconpro.module.uiobject.common;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.beaconpro.module.uiobject.transaction.TransactionPage;

/*****************************************************************************************************************
  Created By : Sanoop.K Created On : 20/04/2016 Purpose : Process Transaction
  Mode Cash /Transfer /Batch
  
  Modified By Modified On Remark
  -----------------------------------------------------------------------------
  -------------------------------- Shilpa UD 22/04/2016 Added Wait13 parameter
  in Account_Opening_Transfer_Autoposting() , to make submit button to wait
  till Entry added to Grid
  
  Added Autoposting post debit TC :
  TransactionModeSelection objtms = new TransactionModeSelection(driver);
  objtms.Autoposting_PostDebit(Amount, ProductGroup_AP, ProductName_AP,
  Branch_AP, Acno_AP, InstrType_AP);
  
 TransactionModeSelection objtms = new TransactionModeSelection(driver);
				objtms.Batch_Tallying_Transaction(Branch, Product_Group, Product_Name,Ac_No,
						Trans_Type, amount, Instr_Type, Opertd_By, Trans_Mode2);
  
  
  // Add Thread sleep after Ac No in Autoposting window -09/06/2016
 **************************************************************************************************************/

public class TransactionModeSelection {

	public WebDriver driver;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_ddlTransMode_ddl")
	public WebElement AccountOpeningTransMode;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnSave")
	public WebElement AccountOpeningSaveButton;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_btnAutoPost")
	public WebElement Click_PostDebiitBtn;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_LIF1_btnAutoPost")
	public WebElement Click_PostCrediitBtn;

	@FindBy(xpath = ".//*[@id='ddlProductGroup_ddl']")
	public WebElement Select_PostDebitOrCredit_Product_Group;

	@FindBy(xpath = ".//*[@id='ddlProductName_ddl']")
	public WebElement Select_PostDebitOrCredit_Product_Name;

	@FindBy(xpath = ".//*[@id='txtChildAcNo_txt']")
	public WebElement Enter_PostDebitCredit_AccNo;

	@FindBy(xpath = ".//*[@id='ddlInstrType_ddl']")
	public WebElement Select_PostDebitCrdt_Instrtype;

	@FindBy(id = "txtAmount_txt")
	public WebElement Enter_PostDebitCrdit_Amount;

	@FindBy(id = "btnAdd")
	public WebElement Click_PostDebitCrdit_ADD_Button;

	@FindBy(xpath = ".//*[@id='btnSubmit']")
	public WebElement Click_PostDebitCrdit_Submit_Button;

	@FindBy(xpath = "html/body/div[2]/div[11]/div/button[1]")
	public WebElement UnclosedBatch_PoUp_Ok_Btn;

	/******************* Autoposting_PostDebit_popup ***************************/
	@FindBy(id = "ddlProductGroup_ddl")
	public WebElement DDL_ProductGroup_Autoposting;

	@FindBy(id = "ddlProductName_ddl")
	public WebElement DDL_ProductName_Autoposting;

	@FindBy(id = "ddlBranch_ddl")
	public WebElement DDL_Branch_Autoposting;

	@FindBy(id = "txtChildAcNo_txt")
	public WebElement Txt_AcNo_Autoposting;

	@FindBy(id = "txtDisplayName_txt")
	public WebElement Txt_DisplayName_Autoposting;

	@FindBy(id = "txtOutBalance_txt")
	public WebElement Txt_AvailBalance;

	@FindBy(id = "txtParticulars_txt")
	public WebElement Txt_Particulars_Autoposting;

	@FindBy(id = "ddlInstrType_ddl")
	public WebElement DDL_InstrType;

	@FindBy(id = "txtAmount_txt")
	public WebElement Txt_Amount_Autoposting;

	@FindBy(id = "btnAdd")
	public WebElement Btn_Add_Autoposting;

	@FindBy(xpath = ".//*[@id='lstContraEntry_ctrl0_lnkRemove']/img")
	public WebElement Btn_Close_AcAddingGrid_Autoposting;

	@FindBy(id = "btnSubmit")
	public WebElement Btn_Submit_Autoposting;

	/******************* **************** ***************************/

	public void Select_Account_Opening_Transmode(String OpeningTransmode) {

		Select AcOpenTrnmode = new Select(AccountOpeningTransMode);
		AcOpenTrnmode.selectByVisibleText(OpeningTransmode);

	}

	public void Click_Account_Opening_SaveBtn() {

		AccountOpeningSaveButton.click();

	}

	public TransactionModeSelection(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public void Click_PostDebiitBtn() {

		Click_PostDebiitBtn.click();

	}

	public void Click_PostCrediitBtn() {

		Click_PostCrediitBtn.click();

	}

	public void Select_PostDebitOrCredit_Product_Group(String pstcrdtordbtprdtgrp) {

		Select pstdbtcrdtprdctgrp = new Select(Select_PostDebitOrCredit_Product_Group);
		pstdbtcrdtprdctgrp.selectByVisibleText(pstcrdtordbtprdtgrp);

	}

	public void Select_PostDebitOrCredit_Product_Name(String pstcrdtordbtprdtName) {

		Select pstdbtcrdtprdctgrp = new Select(Select_PostDebitOrCredit_Product_Name);
		pstdbtcrdtprdctgrp.selectByVisibleText(pstcrdtordbtprdtName);

	}

	public void Enter_PostDebitCredit_AcNo(String PstdbtcrdtAcNo) {

		Enter_PostDebitCredit_AccNo.sendKeys(PstdbtcrdtAcNo);

	}

	public void Select_PostDebitCrdt_Instrtype(String InstMntType) {

		Select instrtype = new Select(Select_PostDebitCrdt_Instrtype);
		instrtype.selectByVisibleText(InstMntType);

	}

	public void Enter_PostDebitCrdit_Amount(String PstCrdtDbtAmount) {

		Enter_PostDebitCrdit_Amount.sendKeys(PstCrdtDbtAmount);

	}

	public void Click_PostDebitCrdit_ADD() {

		Click_PostDebitCrdit_ADD_Button.click();

	}

	public void Click_PostDebitCrdit_Submit_Button() {

		Click_PostDebitCrdit_Submit_Button.click();

	}

	public void Click_UnclosedBatch_PoUp_Ok_Btn() {

		UnclosedBatch_PoUp_Ok_Btn.click();
	}

	// Cash Transaction
	public void Account_Opening_Cash(String TransactionMode) {

		try {

			this.Select_Account_Opening_Transmode(TransactionMode);
			this.Click_Account_Opening_SaveBtn();

		} catch (Exception e) {

			e.getMessage();
		}

	}

	// Autoposting Transction both postcredit and postdebit
	public void Account_Opening_Transfer_Autoposting(String TrnsferMode, String PostDebitCrdtPrdctGrp,
			String PostDebitCrdtPrdctNme, String PostDebitCrdtAcNo, String Instrtype, String PostDebitCrdtAmount) {

		try {

			MenuList objMnLst = new MenuList(driver);

			this.Select_Account_Opening_Transmode(TrnsferMode);
			WebDriverWait wait9 = new WebDriverWait(driver, 10);
			wait9.until(ExpectedConditions.elementToBeClickable(Click_PostDebiitBtn));
			String PostDebtPopUp = driver.getWindowHandle();

			if (driver.findElements(By.id("ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_btnAutoPost")).size() > 0) {

				this.Click_PostDebiitBtn();
				objMnLst.switchWindow(driver);
				this.Select_PostDebitOrCredit_Product_Group(PostDebitCrdtPrdctGrp);
				/*
				 * WebDriverWait wait10 = new WebDriverWait(driver, 30);
				 * wait10.until(ExpectedConditions.elementToBeClickable(
				 * Select_PostDebitOrCredit_Product_Name));
				 */
				/*
				 * this.Select_PostDebitOrCredit_Product_Name(
				 * PostDebitCrdtPrdctNme);
				 * 
				 * driver.manage().timeouts().implicitlyWait(20,
				 * TimeUnit.SECONDS);
				 * this.Enter_PostDebitCredit_AcNo(PostDebitCrdtAcNo);
				 * driver.manage().timeouts().implicitlyWait(20,
				 * TimeUnit.SECONDS);
				 * 
				 * this.Select_PostDebitCrdt_Instrtype(Instrtype);
				 * 
				 * this.Click_PostDebitCrdit_ADD();
				 */
				Thread.sleep(300);
				Select_PostDebitOrCredit_Product_Name(PostDebitCrdtPrdctNme);
				ClosurePageCommon ObjClose = new ClosurePageCommon(driver);
				ObjClose.dependableClick_for_StaleElement_handling(driver, Enter_PostDebitCredit_AccNo);
				Enter_PostDebitCredit_AcNo(PostDebitCrdtAcNo);
				ObjClose.dependableClick_for_StaleElement_handling(driver, Select_PostDebitCrdt_Instrtype);
				System.out.println("Value of Instrtype" + Instrtype);
				Select_PostDebitCrdt_Instrtype(Instrtype);
				Thread.sleep(300);
				for (int i = 0; i < 100; i++) {
					try {
						this.Enter_PostDebitCrdit_Amount(PostDebitCrdtAmount);
						break;
					} catch (StaleElementReferenceException e) {
						e.getMessage();
					}
				}

				/*
				 * WebDriverWait wait14 = new WebDriverWait(driver, 10);
				 * wait14.until(ExpectedConditions.elementToBeClickable(
				 * Click_PostDebitCrdit_ADD_Button));
				 */
				Click_PostDebitCrdit_ADD();
				WebDriverWait wait13 = new WebDriverWait(driver, 10);
				wait13.until(ExpectedConditions.elementToBeClickable(Click_PostDebitCrdit_Submit_Button));
				Click_PostDebitCrdit_Submit_Button();

			} else {

				this.Click_PostCrediitBtn();
				objMnLst.switchWindow(driver);
				this.Select_PostDebitOrCredit_Product_Group(PostDebitCrdtPrdctGrp);
				WebDriverWait wait10 = new WebDriverWait(driver, 10);
				wait10.until(ExpectedConditions.elementToBeClickable(Select_PostDebitOrCredit_Product_Name));
				this.Select_PostDebitOrCredit_Product_Name(PostDebitCrdtPrdctNme);
				WebDriverWait wait11 = new WebDriverWait(driver, 10);
				wait11.until(ExpectedConditions.elementToBeClickable(Enter_PostDebitCredit_AccNo));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				this.Enter_PostDebitCredit_AcNo(PostDebitCrdtAcNo);
				this.Enter_PostDebitCrdit_Amount(PostDebitCrdtAmount);
				this.Click_PostDebitCrdit_ADD();
				this.Click_PostDebitCrdit_Submit_Button();

			}

			driver.switchTo().window(PostDebtPopUp);
			this.Click_Account_Opening_SaveBtn();

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void Account_Opening_BatchTransfer(String BatchTransfer) {

		try {

			this.Select_Account_Opening_Transmode(BatchTransfer);
			this.Click_Account_Opening_SaveBtn();
			this.Click_UnclosedBatch_PoUp_Ok_Btn();

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void Selection_from_dropdown(WebElement element, String index) {
		Select Select9 = new Select(element);
		Select9.selectByVisibleText(index);
	}

	public void ExplicitWait_elementToBeClickable(WebElement element) {
		WebDriverWait wait10 = new WebDriverWait(driver, 30);
		wait10.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void ExplicitWait_textToBePresentInElement(WebElement element, String index) {
		WebDriverWait wait10 = new WebDriverWait(driver, 30);
		wait10.until(ExpectedConditions.textToBePresentInElement(element, index));
	}

	public void Autoposting_PostDebit(String Amount, String ProductGroup, String ProductName, String Branch,
			String Autopost_Acno, String InstrType) 
	{
		try 
		{
			ExplicitWait_elementToBeClickable(DDL_ProductGroup_Autoposting);
			Selection_from_dropdown(DDL_ProductGroup_Autoposting, ProductGroup);
			// ProductName selection
			for (int i = 0; i < 100; i++)
				try 
				{
					Selection_from_dropdown(DDL_ProductName_Autoposting, ProductName);
					// System.out.println("\nProduct name : " + i + "\n");
					break;
				} 
				catch (StaleElementReferenceException e) 
				{
					e.getMessage();
				}
			// Branch selection
			for (int i = 0; i < 100; i++)
				try 
				{
					// Actions actions = new Actions(driver);
					// actions.moveToElement(DDL_Branch_Autoposting);
					ExplicitWait_elementToBeClickable(DDL_Branch_Autoposting);
					Selection_from_dropdown(DDL_Branch_Autoposting, Branch);
					// System.out.println("\nBranch : " + i + "\n");
					break;
				} 
				catch (StaleElementReferenceException e) 
				{
					e.getMessage();
				}

			// Ac no
			for (int i = 0; i < 100; i++)
				try 
				{
					Actions actions = new Actions(driver);
					actions.moveToElement(Txt_AcNo_Autoposting);
					// ExplicitWait_elementToBeClickable(Txt_AcNo_Autoposting);
					Txt_AcNo_Autoposting.sendKeys(Autopost_Acno);
					// System.out.println("\nAc no : " + i + "\n");
					DDL_ProductName_Autoposting.sendKeys(Keys.TAB);
					break;
				} 
				catch (StaleElementReferenceException e) 
				{
					e.getMessage();
				}

			/*String DisplayName = Txt_DisplayName_Autoposting.getAttribute("value");
			System.out.println(DisplayName);
			ExplicitWait_textToBePresentInElement(Txt_DisplayName_Autoposting, DisplayName);*/
			
			//ExplicitWait_elementToBeClickable(DDL_InstrType);
			Thread.sleep(1000);

			// Display name
			/*for (int i = 0; i < 10; i++)
				try 
				{
					Txt_DisplayName_Autoposting.click();
					// System.out.println("\nDisplay field click : " + i +
					// "\n");
					break;
				} 
				catch (StaleElementReferenceException e) 
				{
					e.getMessage();
				}
*/
			// Instrument type
			for (int i = 0; i < 20; i++)
				try 
				{
					Actions actions = new Actions(driver);
					actions.moveToElement(DDL_InstrType);
					// ExplicitWait_elementToBeClickable(DDL_InstrType);
					Selection_from_dropdown(DDL_InstrType, InstrType);
					// System.out.print("\ninstr type :" + i + "\n");
					break;
				} 
				catch (StaleElementReferenceException e) 
				{
					e.getMessage();
				}

			Txt_Amount_Autoposting.sendKeys(Amount);
			// System.out.print("\nAmount\n");
			Btn_Add_Autoposting.click();
			ExplicitWait_elementToBeClickable(Btn_Close_AcAddingGrid_Autoposting);
			Btn_Submit_Autoposting.click();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void Batch_Tallying_Transaction(String Branch, String Product_Group, String Product_Name,
			String Ac_No, String Trans_Type, String amount,String Instr_Type, String Opertd_By,
				String Trans_Mode2) 
	{
		TransactionPage objtrn = new TransactionPage(driver);
		MenuList objml = new MenuList(driver);
		objtrn.open_transaction_window();
		objtrn.select_branch_name(Branch);
		objtrn.select_product_group(Product_Group);
		objtrn.select_product_name(Product_Name);
		objtrn.enter_account_number(Ac_No);
		objtrn.select_trans_type(Trans_Type);
		objtrn.click_go_button();
		objtrn.wait_after_click_go_button();
		objtrn.TransactionAmountField.sendKeys(amount);
		objtrn.Select_Instr_Type(Instr_Type);
		objtrn.OperatedByField.sendKeys(Opertd_By);
		objtrn.select_trans_mode(Trans_Mode2);
		String parentHandle = driver.getWindowHandle();
		objtrn.Batch_search_btn.click();
		objml.switchWindow(driver);
		objtrn.Select_batch_from_batchSearch_window();
		driver.switchTo().window(parentHandle);
		objtrn.SubmitBtn.click();
	}
	
	public void Autoposting_PostCredit(String ProductGroup_PC, String ProductName_PC, String Branch_PC, 
			String AutopostAcno, String Amount) 
	{
		/****** Autoposting popup window actions *******/
		Selection_from_dropdown(DDL_ProductGroup_Autoposting, ProductGroup_PC);
		for (int i = 0; i < 10; i++)
			try 
			{
				Selection_from_dropdown(DDL_ProductName_Autoposting,ProductName_PC);
				break;
			}
			catch (StaleElementReferenceException e) 
			{
				e.getMessage();
			}
		for (int i = 0; i < 10; i++)
			try {
				Selection_from_dropdown(DDL_Branch_Autoposting,Branch_PC);
				break;
			} catch (StaleElementReferenceException e) {
				e.getMessage();
			}
		ExplicitWait_elementToBeClickable(Txt_AcNo_Autoposting);
		Txt_AcNo_Autoposting.sendKeys(AutopostAcno);
		Txt_DisplayName_Autoposting.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ExplicitWait_elementToBeClickable(Txt_Amount_Autoposting);
		for (int i = 0; i < 10; i++)
			try
			{
				Txt_Particulars_Autoposting.sendKeys("particulars");
				Txt_Amount_Autoposting.sendKeys(Amount);
				break;
			} catch (StaleElementReferenceException e) 
			{
				e.getMessage();
			}
		Btn_Add_Autoposting.click();
		ExplicitWait_elementToBeClickable(Btn_Close_AcAddingGrid_Autoposting);
		Btn_Submit_Autoposting.click();
		/***********************************************/
	}
}
