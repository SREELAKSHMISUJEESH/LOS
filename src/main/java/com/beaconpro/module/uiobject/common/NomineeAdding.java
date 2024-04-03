package com.beaconpro.module.uiobject.common;

/********************************************************************************************************************	
Created By      :  Yadhu 
Created On	     :	21/04/2016
Purpose	     :	Nominee adding operations

Important Note  :    	           
-------------------------------------------------------------------------------------------------------------------
Modified By		Modified On			Reason
 Shilpa UD      22/04/2016          Added Wait1 parameter in Nominee_Adding() ;StaleElemetExceptionhandling
-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NomineeAdding {

	WebDriver driver;
	public String CustID;
	public String NcustID;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_chkNominee")
	public WebElement ChkBox_Nominee_Not_Required;

	@FindBy(xpath = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_UPC']/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a/img")
	public WebElement Btn_cust_Nominee_Search;

	/******** Nominee Search Popup ********/
	@FindBy(id = "PopQuick1_txtName")
	public WebElement Txt_Nominee_name;

	@FindBy(id = "PopQuick1_txtCustID")
	public WebElement Txt_Nominee_CustID;

	@FindBy(id = "PopQuick1_btnSearch")
	public WebElement Btn_Search;

	@FindBy(id = "PopQuick1_lst_ctrl0_lblCust_ID")
	public WebElement Cust_ID;

	@FindBy(id = "PopQuick1_lst_ctrl0_linkSelect")
	public WebElement Btn_Select;
	/**********************************/

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_ddlNomRelation_ddl")
	public WebElement DDL_NomRelation;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_btnAddNominee")
	public WebElement Btn_AddNominee;

	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_ddlNomWit2Post_ddl")
	public WebElement DDL_NomWit2Post;

	@FindBy(id = "NomCustID")
	public WebElement NomCustID;

	public NomineeAdding(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public NomineeAdding() {
		// TODO Auto-generated constructor stub
	}

	public void ExplicitWait_elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void ExplicitWait_visibilityOf(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switch_window(WebDriver driver) {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void Selection_from_dropdown(WebElement element1, String index) {
		Select Select9 = new Select(element1);
		Select9.selectByVisibleText(index);
	}

	public void Nominee_Adding(String NomineeCustName, String NomineeCustID,
			String NomineeRelation) {
		String parenthandle = driver.getWindowHandle();
		Btn_cust_Nominee_Search.click();
		switch_window(driver);
		/*WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.elementToBeClickable(Txt_Nominee_name));*/
		ExplicitWait_elementToBeClickable(Btn_Search);
		Txt_Nominee_name.sendKeys(NomineeCustName);
		//ExplicitWait_elementToBeClickable(Txt_Nominee_CustID);
		//wait1.until(ExpectedConditions.elementToBeClickable(Txt_Nominee_CustID));
		Txt_Nominee_CustID.sendKeys(CustID);
		Btn_Search.click();
		ExplicitWait_elementToBeClickable(Btn_Select);
		CustID = Cust_ID.getText();
		Btn_Select.click();
		driver.switchTo().window(parenthandle);
		
		for (int i = 0; i < 100; i++)
			try {
				DDL_NomWit2Post.click();
				//System.out.print("\nnominee witness click :" + i + "\n");
				Selection_from_dropdown(DDL_NomRelation, NomineeRelation);
				//System.out.print("\nselected nominee relation :" + i + "\n");
				//DDL_NomRelation.click();
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		
		//Selection_from_dropdown(DDL_NomRelation, NomineeRelation);
		Btn_AddNominee.click();
		ExplicitWait_visibilityOf(NomCustID);
		NcustID = NomCustID.getText();
		// Assert.assertEquals(CustID, NcustID);
		
		if (CustID.equals(NcustID)) {
			System.out
					.println("\nSelected Nominee and added Nominee are same(Verified)\n");
		} else {
			System.out
					.println("\nSelected Nominee and added Nominee aren't same\n");
		}
	}
}
