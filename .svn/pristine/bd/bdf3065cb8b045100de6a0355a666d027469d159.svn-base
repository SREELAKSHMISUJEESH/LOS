package com.beaconpro.module.uiobject.acopening;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;

public class CAOpeningPage {
	public WebDriver driver;

	@FindBy(xpath = ".//*[@id='CreateMenu']/li[2]/ul/li[1]/ul/li[2]/ul/li[1]/a")
	public WebElement PlusCa;
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_txtCustomerId_txt']")
	public WebElement CustEnter;
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer']")
	public WebElement CustAddbutton;
	
	@FindBy(xpath = ".//*[@id='btnDeleteItem']/img")
	public WebElement CustDeletebutton;
	
	@FindBy(xpath = ".//*[@id='close']")
	public WebElement CustOKbutton;  //Expired cust_OK Button
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_lblHeaderDate']")
	public WebElement BeaconProdate;
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_UP4']/div/table/tbody/tr/td")
	public WebElement cust_grid;

	
	
	@FindBy(xpath="html/body/div[3]/div[11]/div/button")
	public WebElement AlreadyCaWarning;
	
	//In Popup window
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_trCustID']/td[2]/table/tbody/tr/td[2]/a/img")
	public WebElement CustIdsearchbutton;
	
	
	
	@FindBy(xpath = ".//*[@id='PopQuick1_txtCustID']")
	public WebElement CustIdenter;
	
	@FindBy(xpath = ".//*[@id='PopQuick1_btnSearch']")
	public WebElement CustIdSearch;
	
	@FindBy(xpath = ".//*[@id='PopQuick1_lst_ctrl0_linkSelect']")
	public WebElement CustIdSearchselect;
	
	//customer View in Grid
	@FindBy(xpath = ".//*[@id='lnkView']")
	public WebElement CustIdView;
	
	@FindBy(xpath = ".//*[@id='lnkLoan']")
	public WebElement CustIdLoan;
	
	
	@FindBy(xpath = ".//*[@id='lnkATM']")
	public WebElement CustIdATM;
	
	@FindBy(xpath = ".//*[@id='lnkCASA']")
	public WebElement CustIdCasca;
	
	@FindBy(xpath = ".//*[@id='lnkRating']")
	public WebElement CustIdRating;
	
	@FindBy(xpath = ".//*[@id='lnkSMS']")
	public WebElement CustIdAlert;
	
	
	//General tab
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_dtOpenDate_txt']")
	public WebElement Depositopeningdate;
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtAcOpeningAmount_txt']")
	public WebElement DepositAmount;
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_btnGetROI']")
	public WebElement DepositROIsubmit;
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtRemark_txt']")
	public WebElement DepositRemark;
	
	
	
	//Nominee
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnNext']")
	public WebElement NomineeNextButton;
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_chkNominee']")
	public WebElement Nomineecheckbox;
	
	//Operator
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtCust_ID_txt']")
	public WebElement Operatorid;
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtName_txt']")
	public WebElement OperatorName;
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_tdCustAdd']/a/img")
	public WebElement Operatorsearchbutton;
	
	
	
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtRelation_txt']")
	public WebElement OperatorRelation;
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_btnAddOperator']")
	public WebElement OperatorAdd;
	
	//other Info
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_txtSpInstruction_txt']")
	public WebElement SpecialInstrction;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_ddlTransMode_ddl']")
	public WebElement Transmode;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_btnScroll']")
	public WebElement ScrollButton;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSave']")
	public WebElement Submit;
	
	//Summary
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnPrint']")
	public WebElement Print;
	
	@FindBy(xpath=".//*[@id='aspnetForm']/div[11]/div[1]/a/span")
	public WebElement Printclosebutton;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnClose']")
	public WebElement close;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_lnkSignout']/strong")
	public WebElement Signout;
	
	@FindBy(xpath=".//*[@id='tblCustList']/tbody/tr[2]/td[5]")
	public WebElement Batchid;
	
	//Autoposting -Post Debit
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_btnAutoPost']")
	public WebElement AutopostButton;
	
	@FindBy(xpath=".//*[@id='ddlProductGroup_ddl']")
	public WebElement ProductGroup;
	
	@FindBy(xpath=".//*[@id='ddlProductName_ddl']")
	public WebElement ProductName;
	
	@FindBy(xpath=".//*[@id='ddlBranch_ddl']")
	public WebElement Branch;
	
	@FindBy(xpath=".//*[@id='txtChildAcNo_txt']")
	public WebElement AcNo;
	
	@FindBy(xpath=".//*[@id='txtParticulars_txt']")
	public WebElement Particular;
	
	@FindBy(xpath=".//*[@id='ddlInstrType_ddl']")
	public WebElement InstrumentType;
	
	@FindBy(xpath=".//*[@id='dtInstrDate_txt']")
	public WebElement InstrumentDate;
	
	
	@FindBy(xpath=".//*[@id='txtAmount_txt']")
	public WebElement Amount;
	
	@FindBy(xpath=".//*[@id='btnAdd']")
	public WebElement Add;
	
	@FindBy(xpath=".//*[@id='btnSubmit']")
	public WebElement Submitlat;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_btnAutoPost")
	public WebElement Click_PostDebiitBtn;
	
	//Transfer -Open Batch
	
	@FindBy(xpath = "html/body/div[2]/div[11]/div/button[1]")
	public WebElement BatchpopupOKbutton;
	
	
	
	
	// This is a constructor, as every page need a base driver to find web
		// elements
	public  CAOpeningPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	public void switch_window() {

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);

		}
	}
	public void  Cabutton()
	{
      //  WebElement element = PlusCa;
		
		//System.out.println(element);

		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", PlusCa);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//System.out.println("second");
	}

	/*public void Custid_Search()
	{
		CustIdsearchbutton.click();	
		
		CustIdenter.sendKeys(scustid);
	}*/
	
	public void ExplicitWait_elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void Enter_cust_id(String custid)
	{
		CustEnter.sendKeys(custid);
	}
	public void Cust_Add() throws IOException
	{
		try 
		{
			CustAddbutton.click();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        //The below method will save the screen shot in d drive with name "screenshot.png"
			FileUtils.copyFile(scrFile, new File("D:Screens\\screenshot.png"));
		}
		catch (Exception e){
			System.out.println("I'm in exception.Take Screenshot in D Folder");
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        //The below method will save the screen shot in d drive with name "screenshot.png"
			FileUtils.copyFile(scrFile, new File("D:Screens\\screenshotAddbutton.png"));
		}
		
	}
	public void  CustView() throws InterruptedException
	{
	 String OrgWindowHan = driver.getWindowHandle();
     WebElement element = CustIdView;
		
		
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 //WebDriverWait wait = new WebDriverWait(driver, 1000000000);
		
	 //String OrgWindowHan = driver.getWindowHandle();
	  //CustIdView.click();
	 for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	WebDriverWait wait = new WebDriverWait(driver, 10000000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By
			.xpath(".//*[@id='lstMaster_ctrl0_ctl00_CPP_lblCustSal']")));

	  Thread.sleep(3000);
	
	
	 driver.close();
	 driver.switchTo().window(OrgWindowHan);
	}
 
	public void  CustLoan() throws InterruptedException
	{
	 String OrgWindowHan = driver.getWindowHandle();
     WebElement element = CustIdLoan;
		
		

		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//String OrgWindowHan = driver.getWindowHandle();
		 //CustIdView.click();
		 for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		 WebDriverWait wait = new WebDriverWait(driver, 10000000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(".//*[@id='tblCustList']/tbody/tr[1]/td[2]")));
		 Thread.sleep(3000);
		 driver.close();
		 driver.switchTo().window(OrgWindowHan);
		
		//System.out.println("second");
	}
 public void  CustATM() throws InterruptedException
	{
	 String OrgWindowHan = driver.getWindowHandle();
  WebElement element = CustIdATM;
		
		

		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//String OrgWindowHan = driver.getWindowHandle();
		 //CustIdView.click();
		 for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		 WebDriverWait wait = new WebDriverWait(driver, 10000000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(".//*[@id='form1']/div[2]/table/tbody/tr[2]/td")));
		 Thread.sleep(3000);
		 driver.close();
		 driver.switchTo().window(OrgWindowHan);
		
		//System.out.println("second");
	}
 public void CustCasa() throws InterruptedException
 {
	 String OrgWindowHan = driver.getWindowHandle();
	 WebElement element=CustIdCasca;
	 JavascriptExecutor executor=(JavascriptExecutor) driver;
	 executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	 WebDriverWait wait = new WebDriverWait(driver, 10000000);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='btnClose']")));
	 Thread.sleep(3000);
	 driver.close();
	 driver.switchTo().window(OrgWindowHan);
			 
 }
 public void CustRating() throws InterruptedException
 {
	 String OrgWindowHan = driver.getWindowHandle();
	 WebElement element=CustIdRating;
	 JavascriptExecutor executor=(JavascriptExecutor) driver;
	 executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	// WebDriverWait wait = new WebDriverWait(driver, 10000000);
	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='lstViewDiv']/table/tbody/tr[1]/td[1]")));
	 Thread.sleep(3000);
	 driver.close();
	 driver.switchTo().window(OrgWindowHan);
			 
 }
 public void CustAlert() throws InterruptedException
 {
	 String OrgWindowHan = driver.getWindowHandle();
	 WebElement element=CustIdAlert;
	 JavascriptExecutor executor=(JavascriptExecutor) driver;
	 executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	// WebDriverWait wait = new WebDriverWait(driver, 10000000);
	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='btnClose']")));
	 Thread.sleep(3000);
	 driver.close();
	 driver.switchTo().window(OrgWindowHan);
			 
 }
 public void AleadyCaClose()
 {
 	AlreadyCaWarning.click();	
 }
 public void Wait_for_customer_grid() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(cust_grid));

	}
 
 //General TAB
 public void Enter_DepositAmount(String Amount)
 {
	 DepositAmount.sendKeys(Amount);
	 System.out.println("Open CA Account With Amount 5000 RS");
 }
 public void DepositRoi()
 {
	 DepositROIsubmit.click();
	 System.out.println("Minium Balance Amount="+ 1000);
 }
 public void Enter_DepositRemark(String Remark)
 {
	 DepositRemark.sendKeys(Remark);
 }
 
//Nominee Managment
 
public void NomineeNext()
{
	 NomineeNextButton.click();
	 System.out.println("Entered To Nomne=");
}
public void NomineeCheckBox()
{

	WebDriverWait element2 = new WebDriverWait(driver, 20);
	element2.until(ExpectedConditions
			.elementToBeClickable(Nomineecheckbox));
	 Nomineecheckbox.click();
	 System.out.println("Entered To Nominee CheckBox=");
}
//Operator Tab
public void OperatorNext()
{
	 NomineeNextButton.click();
	 System.out.println("Entered To Operator Tab");
}
public void Operatorid(String id) throws InterruptedException
{
	 Operatorid.sendKeys(id);
	 //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 System.out.println("Operator Id Added Succesfully=");
	 //Thread.sleep(5000);
	 //driver.refresh();
}
public void OperatorSearch()
{
	 
	 String OrgWindowHan = driver.getWindowHandle();
	 Operatorsearchbutton.click();
	 
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	// WebDriverWait wait = new WebDriverWait(driver, 10000000);
	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='btnClose']")));
	 //Thread.sleep(3000);
	 driver.close();
	 driver.switchTo().window(OrgWindowHan);
	 System.out.println("Operator Added Succesfully");
}
public void OperatorRelation(String OperatorrRelation) throws InterruptedException
{
	
	 //WebDriverWait wait = new WebDriverWait(driver, 10000000);
	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtName_txt']")));
	 OperatorRelation.sendKeys(OperatorrRelation);
	 System.out.println("Operator Relation added SuccesFully");
}
public void OperatorAdd()
{
	 OperatorAdd.click();
	 System.out.println("Operator Added Succesfully");
}
public void Select_Transmode(String TransMode) {

	Select Trans_Mode = new Select(Transmode);
	Trans_Mode.selectByVisibleText(TransMode);

}
public void submit() throws IOException
{
	 try
	 {
	 Submit.click();
	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    //The below method will save the screen shot in d drive with name "screenshot.png"
		FileUtils.copyFile(scrFile, new File("D:Screens\\screenshotsubmitt.png"));
		System.out.println("SUBMIT CA Succesfully");
	 }
	 catch(Exception e)
	 {
		 System.out.println("I'm in exception.Take Screenshot in D Folder");
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        //The below method will save the screen shot in d drive with name "screenshot.png"
			FileUtils.copyFile(scrFile, new File("D:Screens\\screenshotsubmit.png"));
	 }
}

public  void batchok() throws IOException {
	BatchpopupOKbutton.click();
	System.out.println("CA SAVED WITH OPEN BATCH SUCCESFULLY");
}
public void storebatch()  throws IOException
{
	String fieldValue;  
	//fieldValue =Batchid.getAttribute("id") ;
	fieldValue=Batchid.getText();
	System.out.println("BatchID is"+fieldValue);
}
public void PrintButton()
{
	 Print.click();
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 Printclosebutton.click();
}
}
