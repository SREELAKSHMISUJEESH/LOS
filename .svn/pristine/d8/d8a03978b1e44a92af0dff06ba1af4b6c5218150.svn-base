package com.beaconpro.module.uiobject.clearing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MicrCTSReturn {
  
	public WebDriver driver;
	
	@FindBy(xpath=".//*[@id='CreateMenu']/li[9]/ul/li[1]/ul/li[6]/a")
	public WebElement ReturnLink;
	
	@FindBy(xpath=".//*[@id='CreateMenu']/li[9]/ul/li[4]/ul/li[6]/a")
	public WebElement EcsReturnLink;
	               
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingSearchCriteria_ddlClearingType_ddl']")
	public WebElement ClearingType;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingSearchCriteria_dtClearingDate_txt']")
	public WebElement ClearingDate;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucClearingSearchCriteria_ddlClearingBatch_ddl")
	public WebElement ClearingBatch;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingSearchCriteria_btnSearch']")
	public WebElement SearchButton;
	
	@FindBy(xpath=".//*[@id='tdAcNo']")
	public WebElement AcNoGrid;
	
	@FindBy(xpath=".//*[@id='td1RegNo']")
	public WebElement Regnoingrid;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingReturnSearchList_lstReturnList_ctrl0_ddlReason_ddl']")
	public WebElement ReasonGrid;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']")
	public WebElement SubmitButton;
	
	@FindBy(xpath=".//*[@id='tblCustList']/tbody/tr[1]/td[6]")
	public WebElement SummaryTransid;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnPrint']")
	public WebElement Summaryprint;
	
	@FindBy(xpath=".//*[@id='aspnetForm']/div[11]/div[1]/a/span")
	public WebElement PrintcloseButton;
	
	//ECS Details
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_ddlClearingType_ddl']")
	public WebElement EcsClearingtype;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_ddlClearingBatch_ddl']")
	public WebElement EcsClearingbatch;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_btnSearch']")
	public WebElement EcsClearingsearch;
	
	@FindBy(xpath=".//*[@id='tdAcNo']")
	public WebElement EcsClearingacnogrid;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucClearingReturnSearchList_lstReturnList_ctrl0_ddlReason_ddl']")
	public WebElement EcsClearingreason;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']")
	public WebElement EcsClearingsubmit;
	
	
	@FindBy(xpath=".//*[@id='tblCustList']/tbody/tr[1]/td[6]")
	public WebElement EcsClearingsummarytransid;
	
	@FindBy(xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnPrint']")
	public WebElement EcsClearingsummaryprintbutton;
	
	@FindBy(xpath=".//*[@id='aspnetForm']/div[11]/div[1]/a/span")
	public WebElement EcsClearingsummaryprintclosebutton;
	
	
	public  MicrCTSReturn( WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	public void switch_window() {

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);

		}
	}
	public void micrreturnlink() {
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ReturnLink);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		System.out.println("\nMICR RETURN window Launched succsfully\n");
	}
	public void ecsreturnlink() {
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", EcsReturnLink);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("\nECS Return window Launched succsfully\n");
	}
	
	public void clearingtype(String index) {
		Select sel=new Select(ClearingType);
		sel.selectByVisibleText(index);
	}
	//Common Wait Mathod
			public void ExplicitWait_elementToBeClickable(WebElement element) {
				WebDriverWait wait = new WebDriverWait(driver, 120);
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
			public void batchselect(String index1) {
				for(int i = 0;i<30;i++)
					try
				{
				Select sel1=new Select(ClearingBatch);
				sel1.selectByVisibleText(index1);
				//break;
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			public void search() {
				SearchButton.click();
			}
			public void reason(String index2) {
				Select sel2=new Select(ReasonGrid);
				sel2.selectByVisibleText(index2);
			}
			public void regno() {
			
		/*//int rowCount=driver.findElements(By.id("ctl00_ctl00_CPH1_PRDCNT_tdSearchList")).size();	
		//System.out.println("Row count is::"+ rowCount);	
		for(int i=12;i<=20;i++)
		{
		//Integer num = 12;
		String elem = "/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/table/tbody/tr[2]/td/div/div/div/div["+i+"]/div[2]";
				
		//@FindBy(xpath="elem")
		String Actualtext = driver.findElement(By.xpath(elem)).getText();
		
				
		//String regno=Regnoingrid.getText();
		System.out.println("REG NO IS::"+ Actualtext);
		if(Actualtext==null)
		{
		break;
		}
		}*/
				String regno=Regnoingrid.getText();
				System.out.println("REG NO IS::"+ regno);
			}
			public void submit() {
				SubmitButton.click();
			}
			public void print() {
				 Summaryprint.click();
			}
			public void printclose() {
				PrintcloseButton.click();
				
			}
			              //ECS RETURN window
			public void ecsclearingtype(String index) {
				Select sel3=new Select(EcsClearingtype);
				sel3.selectByVisibleText(index);
			}
			public void ecsbatchselect(String index3) {
				Select sel3=new Select(EcsClearingbatch);
				sel3.selectByVisibleText(index3);
			}
			public void ecsserach() {
				EcsClearingsearch.click();
			}
			public void ecsreason(String index4) {
				Select sel4=new Select(EcsClearingreason);
				sel4.selectByVisibleText(index4);
			}
			public void ecssubmit() {
				EcsClearingsubmit.click();
			}
			public void ecsprint() {
				EcsClearingsummaryprintbutton.click();
			}
			public void ecsprintclose() {
				EcsClearingsummaryprintclosebutton.click();
			}
			
		
			
}
