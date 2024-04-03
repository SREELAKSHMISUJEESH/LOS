package com.beaconpro.module.uiobject.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*****************************************************************************************************************
 *Created By :	Sanoop.K
 *Created On :	15/04/2016 
 *Purpose	 :	Operator Adding Functionalities
 *****************************************************************************************************************/
/********************************************************************************************************************	
 Modified By	Modified On			Remarks
 Shilpa UD      22/04/2016        Next button wait 
-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

public class OperatorAdding {

	public WebDriver driver;
	
	@FindBy (xpath=".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_TC1_tp3']")
	public WebElement OpeartorTab;
	
	@FindBy (xpath=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_tdCustAdd']/a/img")
	public WebElement Click_Operator_Search_Button;
	
	@FindBy (id="PopQuick1_txtName")
	public WebElement Enter_OperatorName_for_Searching;
	
	@FindBy (id="PopQuick1_btnSearch")
	public WebElement Click_OperatorSearch_Btn;
	
	@FindBy (id="PopQuick1_lst_ctrl0_linkSelect")
	public WebElement Select_Operator_Name;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtRelation_txt")
	public WebElement Add_Operator_Relation;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_btnAddOperator")
	public WebElement Click_Operator_Btn; 
	
	
	public void operatorTabclick() {
	
		OpeartorTab.click();
	
	}
	
	public void Goto_operator_Adding_Window() {
		
		Click_Operator_Search_Button.click();
	
	}
	
	public void Enter_Operator_Name(String OperatorName) {
		
		Enter_OperatorName_for_Searching.sendKeys(OperatorName);
	
	}
	
	public void Click_Operator_Search () {
		
		Click_OperatorSearch_Btn.click();
	
	}
	
	
	public void Select_Operator () {
		
		Select_Operator_Name.click();
	
	}
	
	public void Enter_Operator_Relation (String Operator_Relation) {
		
		Add_Operator_Relation.sendKeys(Operator_Relation);
	
	}
	
	public void Add_Operator () {
		
		Click_Operator_Btn.click();
	
	}
	
	public OperatorAdding(WebDriver driver)
	{
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
	public void OperatorTab(String OperatorName,String Operator_Relation) throws InterruptedException{
    	
    	try {
    		String parentHandle = driver.getWindowHandle();
    		MenuList objMnList = new MenuList (driver);
    		
    		this.operatorTabclick();
    		String Parent =driver.getWindowHandle();
    		this.Goto_operator_Adding_Window();
    		objMnList.switchWindow(driver);
    		this.Enter_Operator_Name(OperatorName);
    		this.Click_Operator_Search();
    		WebDriverWait wait5 = new WebDriverWait(driver, 30);
    		wait5.until(ExpectedConditions.elementToBeClickable(this.Select_Operator_Name));
    		this.Select_Operator();
    		driver.switchTo().window(Parent);
    		Thread.sleep(1000);
    		this.Enter_Operator_Relation(Operator_Relation);
    		this.Add_Operator ();
    		wait5.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ctl00_ctl00_CPH1_PRDCNT_btnNext"))));
    		
    	} catch (Exception e) {
    		
    		e.printStackTrace();
    	}
    			
		}
	
}
