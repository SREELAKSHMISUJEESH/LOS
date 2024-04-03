package com.beaconpro.module.uiobject.clearing;
/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 07/06/2016
Purpose	        : CTS Outward - File Generation base Page
Note			: 
Conditions      :  
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.beaconpro.module.uiobject.common.MenuList;

public class CTSOutwardFileGenerationPage 
{

	@FindBy(xpath=".//*[@id='CreateMenu']/li[9]/ul/li[2]/ul/li[1]/a")
	public WebElement CTSFileGeneratonLink;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ddlClearingType_ddl")
	public WebElement ClearingType;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_btnGo")
	public WebElement GoButton;
	
	@FindBy(id="tblCTSDetails")
	public WebElement CTSPresentedDetailsGrid;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement SubmitButton;
		
	
	WebDriver driver;
	
	
	public  CTSOutwardFileGenerationPage( WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void OpenFileGenerationWindow()
	{
		MenuList ObjMenu=new MenuList(driver);
		ObjMenu.Open_window(CTSFileGeneratonLink);
	}
	
	public void SelectClearingType(String ClrngType)
	{
		Select select1=new Select(ClearingType);
		select1.selectByVisibleText(ClrngType);
	}
	
	public void ClickOnGoButton()
	{
		GoButton.click();
	}
	
	public void ClickOnSubmitButton()
	{
		SubmitButton.click();
	}
	
	public void CTS_FileDownload_usingRobot() throws InterruptedException, AWTException
	{
		Thread.sleep(1000L);
        //create robot object
        Robot robot = new Robot();
        Thread.sleep(1000L);
        //Click Down Arrow Key to select "Save File" Radio Button
        //robot.keyPress(KeyEvent.VK_DOWN);
        //Thread.sleep(1000L);
        // Click 3 times Tab to take focus on "OK" Button
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000L);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000L);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000L);
        //Click "Enter" Button to download file
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(5000L);
        System.out.println("\nFile Download Complete");
        
	}
		
	public void FileGenerationProcess (String ClrngType) throws Exception
	{
		OpenFileGenerationWindow();
		SelectClearingType(ClrngType);
		ClickOnGoButton();
		WebDriverWait wait1=new WebDriverWait (driver,30);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("tblCTSDetails")));
		Thread.sleep(300);
		ClickOnSubmitButton();
		CTS_FileDownload_usingRobot();
	
		//CTS_FileDowload(ffprofile);
		 //driver.findElement(By.id("ctl00_ctl00_CPH1_PRDCNT_btnSubmit")).click();
		System.out.println("File Generation Completed");
		
	}

}
