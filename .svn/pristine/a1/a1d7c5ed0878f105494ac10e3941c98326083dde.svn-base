package com.beaconpro.module.uiobject.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beaconpro.module.uiobject.acopening.RDOpeningPage;


/*****************************************************************************************************************
 *Created By :	Sanoop.K
 *Created On :	20/04/2016 
 *Purpose	 :	Add Customer or Member at the time Account Opening /Transaction ..Etc
 *****************************************************************************************************************/


public class CustomerOrMemberAdding {

	public WebDriver driver;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_trCustID']/td[2]/table/tbody/tr/td[2]/a/img")
	public WebElement ClickCustomerSearch;
	
	@FindBy (id="PopQuick1_txtName")
	public WebElement custname;
	
	@FindBy (id="PopQuick1_btnSearch")
	public WebElement PopQuick1_btnSearch_Click;
	
	@FindBy (id="PopQuick1_lst_ctrl0_linkSelect")
	public WebElement CustlinkSelect;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer")
	public WebElement CustBtnadd;
	
	@FindBy (xpath="html/body/div[3]/div[11]/div/button")
	public WebElement OK_Btn_For_RD_AC_Exist;
	
	@FindBy (xpath=".//*[@id='close']")
	public WebElement KYC_Not_Completed_PopUp;
	
	
	public CustomerOrMemberAdding(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public void Addcustname(String Strcustname){
		custname.sendKeys(Strcustname);
	}
	
	public void Clicksearch(){
		PopQuick1_btnSearch_Click.click();
	}
	
	public void linkselection(){
		CustlinkSelect.click();
	}
	
	public void CustAdd(){
		CustBtnadd.click();
	}
	
	
	public void KYC_Not_Completed_Warning_Msg_PopUp_Click(){
		
		if (driver.findElements(By.xpath(".//*[@id='close']"))
				.size() > 0) {
			this.KYC_Not_Completed_PopUp.click();
			
		}
	}
	
	
	
	public void Add_Customer_OR_Member (String CustName) {
		
		try {
			
			
			
			String Main_Window = driver.getWindowHandle();
			this.ClickCustomerSearch.click();
			RDOpeningPage.switchWindow(driver);
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.elementToBeClickable(custname));
			this.Addcustname(CustName);
			this.Clicksearch();
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			wait2.until(ExpectedConditions.elementToBeClickable(CustlinkSelect));
			this.linkselection();
			driver.switchTo().window(Main_Window);
			this.CustAdd();
			this.KYC_Not_Completed_Warning_Msg_PopUp_Click ();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}
