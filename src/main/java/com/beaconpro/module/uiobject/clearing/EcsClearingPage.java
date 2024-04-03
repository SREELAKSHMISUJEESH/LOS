package com.beaconpro.module.uiobject.clearing;
/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 02/06/2016
Purpose	        : ECS Clearing Page [Object Definitions] [Both Inward,Outward Clearing handled]
Note			: 
Conditions      :  
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beaconpro.module.uiobject.common.MenuList;

public class EcsClearingPage 

{

	WebDriver driver;
		
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_ddlClearingType_ddl")
	public WebElement Select_Clearing_type;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_dtClearingDate_txt")
	public WebElement ClearingDate_Text;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_ddlClearingBatch_ddl")
	public WebElement Select_Clearing_Batch ;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_ddlRegBranch_ddl")
	public WebElement Reg_BranchName;
	
	@FindBy (id ="ctl00_ctl00_CPH1_PRDCNT_ucECSSearch_btnSearch")
	public WebElement Search_Btn;
	
	@FindBy (id="chkAll")
	public WebElement Grid_SelectAll_Chkbox;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_ucSearchList_lstReturnList_ctrl0_chkSelect")
	public WebElement Grid_Select_Chkbox;

	@FindBy (id  ="ctl00_ctl00_CPH1_PRDCNT_btnSubmitClearing")
	public WebElement Clear_Btn;
	
	@FindBy(id="ctl00_ctl00_lblErrorMessage")
	public WebElement ClearingSavedMsg;
	
	@FindBy(xpath=".//*[@id='closetop']")
	public WebElement ClosePopUp;
	
	@FindBy(id = "ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID")
	public WebElement TransID_in_summary;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_btnPrint")
	public WebElement Print_btn;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_btnPrintClose")
	public WebElement Print_Close_btn;
	
	
	public EcsClearingPage (WebDriver driver)
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void Open_ClearingWindow()
	{
		MenuList ObjMenu=new MenuList(driver);
		ObjMenu.Open_window(ObjMenu.ECS_Clearing);
	}
	public void Clearing_type (String ClearingType)
	
	{
		Select_Clearing_type.sendKeys(ClearingType);
	}
	
	public void SetClearingDate (String ClgDate)
	{
		ClearingDate_Text.sendKeys(ClgDate);
	}

	public void Clearing_Batch (String ClearingBatch)
	
	{
		Select ClearingBatch1 = new Select(Select_Clearing_Batch);
		ClearingBatch1.selectByVisibleText(ClearingBatch);
		
	}
	
	public void Selection_from_dropdown(WebElement element, String index) {
		Select Select9 = new Select(element);
		Select9.selectByVisibleText(index);
	}
	public void ExplicitWait_Till_elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public  void Select_Reg_BranchName (String RegBranchName)
	
	{
		Reg_BranchName.sendKeys(RegBranchName);
	}
	
	public void Select_From_ClrngDetails_Grid()
	{
		ExplicitWait_Till_elementToBeClickable(Grid_SelectAll_Chkbox);
		if(Grid_Select_Chkbox.isSelected())
		{
			System.out.println("\nEntry Selected Automatically");
		}
		else
		{
			Grid_Select_Chkbox.click();
			System.out.println("\nEntry Selected Manually");
		}
			 
	}
	
	public void Click_Search_Btn ()
	
	{
		Search_Btn.click();
	}
	
	public void Click_Clear_Btn ()
	
	{
		Clear_Btn.click();
	}
	
	public void Close_ClearOrReturn_Saved_PopUp() throws InterruptedException
	{
		if(driver.findElements(By.xpath(".//*[@id='ctl00_ctl00_lblErrorMessage']")).size()>0)
		{
			Thread.sleep(2000);
			ClosePopUp.click();
		}
		
	}
	public void Print_Voucher()
	{
		Print_btn.click();
		try 
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		Print_Close_btn.click();
	}
	
	
	
}
	