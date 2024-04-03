package com.beaconpro.module.uiobject.transaction;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FdInterestPayment {
	public WebDriver driver;
	
	

	@FindBy(xpath = ".//*[@id='CreateMenu']/li[3]/ul/li[2]/a")
	public WebElement FDLink;
   //Account Info
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlBranch")
	public WebElement BranchNameField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_dtValueDate_dtValueDate_txt")
	public WebElement ValueDateField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup")
	public WebElement ProductGroupField;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl")
	public WebElement ProductNameField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt")
	public WebElement AccountNoPrefixField;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt")
	public WebElement AccountNoField;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo']")
	public WebElement GoButton;
	
	@FindBy(xpath="/html/body/form/div[9]/div[1]/div[4]/div/div[3]/input")
	public WebElement Kycokbutton;
	
	@FindBy(xpath="/html/body/form/div[9]/div[1]/div[2]/div/div[3]/input")
	public WebElement Alreadystandingmessage;
	
	
	@FindBy(xpath = ".//*[@id='tblCustList']/tbody/tr[1]/td[1]")
	public WebElement CustomerIdGrid_custIdField_Heading;
	
	                       //Transaction Details.
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_chkLastN']")
	public WebElement Previoustransactioncheckbox;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_trLastNT']/td")
	public WebElement Previoustransactiongrid;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProductAccIntPayment_ctrl0_ucProductAccIntPayment_txtDuration_txt']")
	public WebElement Duration;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProductAccIntPayment_ctrl0_ucProductAccIntPayment_ddlDurationMode_ddl']")
	public WebElement DurationMode;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProductAccIntPayment_ctrl0_ucProductAccIntPayment_ddlTransactionMode_ddl']")
	public WebElement Transmode;
	
	                
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProductAccIntPayment_ctrl0_ucProductAccIntPayment_txtRemarks_txt']")
	public WebElement Remark;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnInterestLog']")
	public WebElement InterestLog;
	
	@FindBy(xpath=".//*[@id='Close']")
	public WebElement InterestLogclosebutton;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']")
	public WebElement Submitbutton;
	              
	@FindBy(xpath=".//*[@id='tblCustList']/tbody/tr[1]/td[6]")
	public WebElement Summarytransid;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnPrint']")
	public WebElement SummaryprintButton;
	
	
    @FindBy(xpath=".//*[@id='aspnetForm']/div[11]/div[1]/a/span")
	public WebElement Summaryprintclosebutton;
	
	
	
	
	                                      //cust_grid
	
	
	//customer View in Grid
	@FindBy(xpath = ".//*[@id='categories-menu']/ul/li[1]")
	public WebElement CustIdView;
	

	
	@FindBy(xpath = ".//*[@id='btnClose']")
	public WebElement CustIdViewclose;
	
	@FindBy(xpath = ".//*[@id='lnkLoan']")
	public WebElement CustIdLoan;
	
	//Interest Validation
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransProductAccountInfo_ctrl0_ucTransactionProductAccInfo_txtAvailBalance_txt']")
	public WebElement Principalamount;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstTransProductAccountInfo_ctrl0_ucTransactionProductAccInfo_txtROI_txt")
	public WebElement ROI;
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProductAccIntPayment_ctrl0_ucProductAccIntPayment_txtIntPayableDuration_txt']")
	public WebElement PayableDuration;
	
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProductAccIntPayment_ctrl0_ucProductAccIntPayment_txtPayableInt_txt']")
	public WebElement TotalnterestPayable;
	
	
	                               //postcredit Button
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProductAccIntPayment_ctrl0_ucProductAccIntPayment_btnAutoPost']")
	public WebElement PostcreditButton;
	
	
	@FindBy(xpath = ".//*[@id='ddlProductGroup_ddl']")
	public WebElement Productgroup;
	@FindBy(xpath = ".//*[@id='ddlProductName_ddl']")
	public WebElement ProductName;
	@FindBy(xpath = ".//*[@id='ddlBranch_ddl']")
	public WebElement Branch;
	@FindBy(xpath = ".//*[@id='txtChildAcNo_txt']")
	public WebElement AcNo;
	@FindBy(xpath = ".//*[@id='txtDisplayName_txt']")
	public WebElement Displayname;
	@FindBy(xpath = ".//*[@id='txtOutBalance_txt']")
	public WebElement Avaliablebalance;
	@FindBy(xpath = ".//*[@id='txtBalAmount_txt']")
	public WebElement Showingamount;
	
	@FindBy(xpath = ".//*[@id='txtParticulars_txt']")
	public WebElement Particular;
	@FindBy(xpath = ".//*[@id='txtAmount_txt']")
	public WebElement Amount;
	@FindBy(xpath = ".//*[@id='btnAdd']")
	public WebElement Add;
	
	@FindBy(xpath = ".//*[@id='lstContraEntry_ctrl0_lnkRemove']")
	public WebElement Deletelinkgrid;
	@FindBy(xpath = ".//*[@id='btnSubmit']")
	public WebElement Submit;
	
	@FindBy(xpath = "html/body/div[2]/div[11]/div/button[1]")
	public WebElement Batchokbutton;
	
	
	
	
	              //Webelement Inialization
	public  FdInterestPayment(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	              // Open Transaction window

	public  FdInterestPayment() {
		
	}
	public void switch_window() {

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);

		}
	}
	
	public void  fdintbutton()
	{
      //  WebElement element = PlusCa;
		
		//System.out.println(element);

		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", FDLink);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//System.out.println("second");
	}
	
	public void Selection_from_dropdown(WebElement element1, String index) {
		Select Select9 = new Select(element1);
		Select9.selectByVisibleText(index);
	}
	
	                     //Common Wait Method
	public void ExplicitWait_elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	                       //FD Account Info
	public void select_branch(String index) {
		Select drop= new Select(BranchNameField);
		drop.selectByVisibleText(index);
	}
	public void select_product_group(String index) {
		Select drop = new Select(ProductGroupField);
		drop.selectByVisibleText(index);

	}
	public void select_product_name(String Prd_nam) {
		Select drop = new Select(ProductNameField);
		drop.selectByVisibleText(Prd_nam);

	}

	public void enter_account_number(String acno) {
		AccountNoField.sendKeys(acno);

	}
	public void go_button() {
		GoButton.click();
	}
	
  public void Go_button_Wait() {
	  WebDriverWait wait =new WebDriverWait(driver,50);
	  wait.until(ExpectedConditions.textToBePresentInElement(
			  CustomerIdGrid_custIdField_Heading, "Cust ID"));
	  
  }
  

public void KYC_Not_Completed_Warning_Msg_PopUp_Click()
{
		//System.out.println("Haiiiii");
		if (driver.findElements(By.xpath("/html/body/form/div[9]/div[1]/div[4]/div/div[3]/input"))
				.size() > 0) 
		{
			this.Kycokbutton.click();
			
		}
		
		
	}

public void already_standing_Warning_Msg_PopUp_Click()
{
		//System.out.println("Haiiiii");
		if (driver.findElements(By.xpath("/html/body/form/div[9]/div[1]/div[2]/div/div[3]/input"))
				.size() > 0) 
		{
			this.Alreadystandingmessage.click();
			
		}
		
		
	}
  
                                // Transaction Details
  public void previous_transaction() {
	  Previoustransactioncheckbox.click();
	  WebDriverWait wait =new WebDriverWait(driver,100);
	  wait.until(ExpectedConditions.textToBePresentInElement(
			  Previoustransactiongrid, "Date"));
  }
  public void enter_duration(String duration){
	  Duration.sendKeys(duration);
	  
  }
  public void enter_durationmode(String durationmode) {
	 Select drop=new Select(DurationMode);
	 drop.selectByVisibleText(durationmode);
	
	 
  }
  public void transmode(String transmode) {
		 Select drop=new Select(Transmode);
		 drop.selectByVisibleText(transmode);
		
}
                //Interest Log Button
  public void interestlog() throws InterruptedException {

		String OrgWindowHan = driver.getWindowHandle();

		InterestLog.click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		 WebDriverWait wait = new WebDriverWait(driver, 80);
			wait.until(ExpectedConditions.elementToBeClickable(InterestLogclosebutton));

		Thread.sleep(1000);

		driver.close();

		driver.switchTo().window(OrgWindowHan);

	}
  public void cust_grid(WebElement element2,WebElement element) {
      String OrgWindowHan = driver.getWindowHandle();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
			//Thread.sleep(3000);
			 driver.close();
			 driver.switchTo().window(OrgWindowHan);
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
				.xpath(".//*[@id='lstMaster_ctrl0_ctl00_CPP_lblDispName']")));

		  Thread.sleep(3000);
		
		
		 driver.close();
		 driver.switchTo().window(OrgWindowHan);
		}
  
  public void submitbutton() throws IOException {
	  Submitbutton.click();
	  System.out.println("SUBMIT WORKING SUSSFULLY");
  }
                //FD Interest Validation
  public void interestvalidation() throws IOException {
	
	 String pri = Principalamount.getAttribute("value");
	 float prinew =Float.parseFloat(pri.substring(0,pri.length()-2));
	
	float Roi= Float.parseFloat(ROI.getAttribute("value"));
	String payableDuration=PayableDuration.getAttribute("value");
	float pd=Float.parseFloat(payableDuration.substring(0,payableDuration.length()-6));
	
	
	float Totalinterest=prinew*Roi*pd/1200;
    float Totalinterestnew=(float) (Math.round(Totalinterest *100.0)/100.0);
	
    String Pay= TotalnterestPayable.getAttribute("value");
	float Paynew= Float.parseFloat(Pay.substring(0,Pay.length()-2));
	
	 System.out.println("FD Principal Is  :"+ prinew);
	 System.out.println("FD ROI is"+ Roi);
	 System.out.println("FD Payable Duration is  :"+ pd);
	 System.out.println("Total interest After Calculation   :"+ Totalinterestnew);
	 System.out.println("TotalInterestpayable in InterFace   :"+Paynew);
	// if(Totalinterestnew.equals(Paynew))
	 if(Totalinterestnew==(Paynew)){
		 System.out.println("Interest showing Correct");
	 }
	 else {
		 System.out.println("Interest showing Not Correct");
	 }
		
  }
                          //Transfer-Postcredit Button
  public void Select_Transmode(WebElement element,String TransMode) {

		Select Trans_Mode = new Select(Transmode);
		Trans_Mode.selectByVisibleText(TransMode);

	}
  
  public void postcreditbutton_transfer(String index,String index1,String acnoo,String par) throws InterruptedException {
	  String OrgWindowHan = driver.getWindowHandle();
	  PostcreditButton.click();
	  for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	    String pstcrdtAmount=Showingamount.getAttribute("value");
	    Select drop1= new Select(Productgroup);
		drop1.selectByVisibleText(index);
		
		
		for (int i = 0; i < 10; i++)
			try {
				Select drop2= new Select(ProductName);
				drop2.selectByVisibleText(index1);
				//System.out.println("selected Product Name: "+i);
				//break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		
		
		
		WebDriverWait wait2 = new WebDriverWait(driver, 100);
		wait2.until(ExpectedConditions.elementToBeClickable(AcNo));
		//Thread.sleep(100);
		
		AcNo.sendKeys(acnoo);
		//AcNo.sendKeys(Keys.TAB);
		Displayname.click();
		
		for (int i = 0; i < 10; i++)
			try {
				 Amount.sendKeys(pstcrdtAmount);
				 //System.out.println("Amount : "+i);
					//break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		//Particular.sendKeys(par);

		System.out.print("amount : " + pstcrdtAmount);
		Add.click();
		WebDriverWait wait3 = new WebDriverWait(driver, 100);
		wait3.until(ExpectedConditions.elementToBeClickable(Deletelinkgrid));
		Submit.click();
		Thread.sleep(2000);
        driver.switchTo().window(OrgWindowHan);
        
        System.out.print("Autoposting Detaild added Sussfully.");
  }
                //Submit Details
  public void submit_button_Wait() {
	  WebDriverWait wait =new WebDriverWait(driver,05);
	  wait.until(ExpectedConditions.textToBePresentInElement(
			  Summarytransid, "TransID "));
  }
  public void PrintButton()throws IOException, InterruptedException
  {
	  SummaryprintButton.click();
  	  //driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
  	  //Thread.sleep(2000);
  	 
  	System.out.print("Print Details Showing  Sussfully.");
  }
  public void printclose() {
	  
	  Summaryprintclosebutton.click();  
  }
  public void batchok() {
	  Batchokbutton.click();
  }
}