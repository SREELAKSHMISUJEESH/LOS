package com.beaconpro.module.uiobject.clearing;
/********************************************************************************************************************	
Created By      : Dinoop
Created On	    :  
Purpose	        :  
Note			: 
Conditions      :  
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason
Shilpa				06/06/2016          Added selectAnyBank(),selectAnyBranch() 

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MicrOutstationRegistration {
	public WebDriver driver;
	
	@FindBy(xpath=".//*[@id='CreateMenu']/li[9]/ul/li[1]/ul/li[1]/a")
	public WebElement MicrRegisterLink;
	
	
	@FindBy(xpath=".//*[@id='CreateMenu']/li[9]/ul/li[3]/ul/li[1]/a")
	public WebElement OutstationRegisterLink;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInfo_ddlClearingType_ddl']")
	public WebElement Clearingtype;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInfo_chkpayOrder']")
	public WebElement PayorderCheckbox;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInfo_chkMask']")
	public WebElement MaskCheckbox;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInfo_dtValueDate_txt']")
	public WebElement valuedate;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingAccountInfo_ddlBranch_ddl']")
	public WebElement AccountBranch;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingAccountInfo_ddlProductGroup']")
	public WebElement Productgroup;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingAccountInfo_ddlProductName']")
	public WebElement Product;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingAccountInfo_txtAcNo_txt']")
	public WebElement AcNo;
	
	@FindBy(xpath=".//*[@id='closeThioun']")
	public WebElement AcNoValidation;
	
	@FindBy(xpath=".//*[@id='tblCustList']/tbody/tr[1]/td[1]")
	public WebElement Custidingrid;
	
	           //Instrument Details
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInstrInfo_ddlInstrType_ddl']")
	public WebElement InstrumentType;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInstrInfo_txtPrefix_txt']")
	public WebElement Instrumentpre;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInstrInfo_txtInstrumentNo_txt']")
	public WebElement InstrumentNo;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInstrInfo_dtInstrDate_txt']")
	public WebElement InstrumentDate;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInstrInfo_txtInstrAmount_txt']")
	public WebElement Amount;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInstrInfo_ddlBank_ddl']")
	public WebElement Bank;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInstrInfo_ddlBranch_ddl']")
	public WebElement Bankbranch;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']")
	public WebElement Submit;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInstrInfo_txtRemark_txt']")
	public WebElement MicrRemark;
	
	//Outstation Register
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_txtBankCode_txt']")
	public WebElement Maskcode;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ddlPresented_ddl']")
	public WebElement AgentBank;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ddlPresentedBranch_ddl']")
	public WebElement AgentBranch;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingInstrInfo_txtRemark_txt']")
	public WebElement Remark;
	
	
	//Summary outs
	
	@FindBy(xpath=".//*[@id='aspnetForm']/div[12]/div[1]/a/span")
	public WebElement Printclosebutton ;
	
	@FindBy(xpath=".//*[@id='closetop']")
	public WebElement Messageclosebutton;
	
	public  MicrOutstationRegistration( WebDriver driver) 
	{

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	public void switch_window() {

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);

		}
	}
	public void micrregisterlink() {
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", MicrRegisterLink);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("MICR Register window Launched succsfully");
	}
	public void outstationregisterlink() {
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", OutstationRegisterLink);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Outstation Register window Launched succsfully");
	}
	
	public void clearingtype(String index) {
		Select sel=new Select(Clearingtype);
		sel.selectByVisibleText(index);
	}
	           //Common Wait Mathod
		public void ExplicitWait_elementToBeClickable(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		/*public void valuedateattribute() {
		String date=valuedate.getText();
			System.out.println(date);
		}*/
		public void productgroup(String index1) {
			Select sel1=new Select(Productgroup);
			sel1.selectByVisibleText(index1);
		}
		public void product(String index2) {
			for (int i = 0; i < 10; i++)
				try {
			Select sel2=new Select(Product);
			sel2.selectByVisibleText(index2);
		}
			catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
			}
		public void acno(String acno) {
			AcNo.sendKeys(acno);
			
		}
		public void custgridloading() {
			  WebDriverWait wait =new WebDriverWait(driver,150);
			  wait.until(ExpectedConditions.textToBePresentInElement(
					  Custidingrid, "Cust ID"));
			  
		  }
		public void instrumenttype(String index3) {
			Select sel3=new Select(InstrumentType);
			sel3.selectByVisibleText(index3);
		}
		public void instrumentprefix(String pre) {
			Instrumentpre.sendKeys(pre);
			
		}
		public void instrumentno(String instno) {
			for (int i = 0; i < 100; i++)
				try {
			InstrumentNo.sendKeys(instno);
			break;
				}
			catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		}
		public void selectdate(String setDateofbirth) {
			
			for (int i = 0; i < 20; i++)
				try {
			InstrumentDate.click();
			InstrumentDate.sendKeys(setDateofbirth);
			break;
				}
			catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
			 // driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			//InstrumentDate.sendKeys(Keys.TAB);
		}
		public void amount(String amount ) {
			Amount.sendKeys(amount);
		}
		public void bank(String index4) {
			Select sel4=new Select(Bank);
			sel4.selectByVisibleText(index4);
		}
		public void bankbranch(String index5) {
			Select sel5=new Select(Bankbranch);
			sel5.selectByVisibleText(index5);
		}
		public void submit() {
			Submit.click();
		}
		public void micrremark(String hai){
			MicrRemark.sendKeys(hai);
		}
		//Outstation Agent Bank
		public void agentbank(String index6) {
			Select sel6=new Select(AgentBank);
			sel6.selectByVisibleText(index6);
		}
		public void agentbankbranch(String index7) {
			Select sel7=new Select(AgentBranch);
			sel7.selectByVisibleText(index7);
		}
		public void remark(String Rem ) {
			Remark.sendKeys(Rem);
		}
		public void printclose() {
			Printclosebutton.click();
		}
		public void selectAnyBank()
		{
			Select sel8=new Select(Bank);
			sel8.selectByIndex(1);
		}
		public void selectAnyBranch()
		{
			Select sel9=new Select(Bankbranch);
			sel9.selectByIndex(1);
		}
}
