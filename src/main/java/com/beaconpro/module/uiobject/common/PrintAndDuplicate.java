package com.beaconpro.module.uiobject.common;

/********************************************************************************************************************	
Created By      :  Yadhu 
Created On	     :	22/04/2016
Purpose	     :	Summary print and Duplicate print operations

Important Note  :    	           
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrintAndDuplicate {

	WebDriver driver;
	public String transid;
	public String BatchID;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID")
	public WebElement save_transid;
	
	@FindBy(xpath = ".//*[@id='tblCustList']/tbody/tr[2]/td[5]")
	public WebElement Save_BatchID;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnPrint")
	public WebElement print_button;
	
	@FindBy(id = "ctl00_ctl00_lnkSignout")
	public WebElement Signout;

	/********* PrintAndDuplicatePage *******************/
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_btnPrintClose") 
	public WebElement close_button_in_print_preview;

	@FindBy(xpath = ".//*[@id='CreateMenu']/li[5]/ul/li[8]/a")
	public WebElement Duplicate_window_link;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnGo']")
	public WebElement duplicate_go_button;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt']")
	public WebElement Transid_field_in_Duplicate_window;
					
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_txtBatchID_txt")
	public WebElement BatchID_field_in_Duplicate_window;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_CancelTrans1_lvwTransDetails_ctrl0_chkSelect")
	public WebElement duplicate_tick;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnDuplicate']")
	public WebElement dupli_submit;
	/*****************************************/

	public PrintAndDuplicate(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public PrintAndDuplicate() {
		// TODO Auto-generated constructor stub
	}

	public void ExplicitWait_elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void open_window(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void print_and_duplicate() throws Exception {
		try {
			transid = save_transid.getText();
			print_button.click();
			ExplicitWait_elementToBeClickable(close_button_in_print_preview);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			close_button_in_print_preview.click();
			open_window(Duplicate_window_link);
			ExplicitWait_elementToBeClickable(duplicate_go_button);
			Transid_field_in_Duplicate_window.clear();
			Transid_field_in_Duplicate_window.sendKeys(transid);
			duplicate_go_button.click();
			ExplicitWait_elementToBeClickable(duplicate_tick);
			duplicate_tick.click();
			dupli_submit.click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			print_button.click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			close_button_in_print_preview.click();
			Signout.click();
			System.out.println("\nTransID : " + transid + "\n");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
