package com.beaconpro.module.uiobject.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ObjLoanAccountInfoTab 
{
	public WebDriver driver;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_ddlPurposeCode_ddl")
	public WebElement Loan_AcInfo_Loan_Purpose;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_ddlBrrCategory_ddl")
	public WebElement Loan_AcInfo_Borr_Category;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_ddlClassCode_ddl")
	public WebElement Loan_AcInfo_Class;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_ddlCategoryID_ddl")
	public WebElement Loan_AcInfo_Spl_Category;
	
	
	public ObjLoanAccountInfoTab(WebDriver driver) 
	{
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void Select_Loan_Purpose(String Loan_Purpose)
	{
		Loan_AcInfo_Loan_Purpose.sendKeys(Loan_Purpose);
		/*Select objselect = new Select(Loan_AcInfo_Loan_Purpose);
		objselect.selectByVisibleText(Loan_Purpose);*/
	}
	
	public void Select_Borr_Category(String Borr_Category)
	{
		Loan_AcInfo_Borr_Category.sendKeys(Borr_Category);
	}
	
	public void Select_AcInfo_Class(String Class)
	{
		Loan_AcInfo_Class.sendKeys(Class);
	}
	
	public void Select_Spl_Category(String Spl_Category)
	{
		Loan_AcInfo_Spl_Category.sendKeys(Spl_Category);
	}



}