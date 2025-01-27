package com.beaconpro.module.uiobject.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuList {

	WebDriver Driver;
	
	@FindBy(xpath = ".//*[@id='CreateMenu']/li[2]/ul/li[1]/ul/li[1]/ul/li[1]/a")
	public WebElement SB_opening_link;
	
	@FindBy(xpath = ".//*[@id='CreateMenu']/li[4]/ul/li[5]/a")
	public WebElement Demand_Deposits_closure_Link;
	
	@FindBy(xpath = ".//*[@id='CreateMenu']/li[2]/ul/li[1]/ul/li[5]/ul/li/a")
	public WebElement RD_Opening_Link;
	
	@FindBy(xpath = ".//*[@id='CreateMenu']/li[3]/ul/li[1]/a")
	public WebElement Transaction_Link;
	
	@FindBy (xpath =".//*[@id='CreateMenu']/li[8]/ul/li[3]/ul/li[1]/a")
	public WebElement MDS_Application;
	
	@FindBy (xpath =".//*[@id='CreateMenu']/li[8]/ul/li[3]/ul/li[2]/a")
	public WebElement MDS_Application_Transfer;
	
	@FindBy (xpath = ".//*[@id='CreateMenu']/li[14]/ul/li[2]/a")
	public WebElement MDS_Bidding_Link;
	
	@FindBy (xpath = ".//*[@id='CreateMenu']/li[14]/ul/li[1]/a")
	public WebElement MDS_Collection_Link;
	
	@FindBy (xpath = ".//*[@id='CreateMenu']/li[14]/ul/li[3]/a")
	public WebElement MDS_Payment;
	
	@FindBy (xpath = ".//*[@id='CreateMenu']/li[14]/ul/li[5]/a")
	public WebElement MDS_Settlement;
	
	@FindBy(xpath = ".//*[@id='CreateMenu']/li[5]/ul/li[3]/a")
	public WebElement Cashier_Authorization;
	
	@FindBy(xpath = ".//*[@id='CreateMenu']/li[5]/ul/li[2]/a")
	public WebElement Manager_Authorization;
	
	@FindBy (xpath = ".//*[@id='CreateMenu']/li[4]/ul/li[7]/a")
	public WebElement Loan_Closure;
	
	@FindBy (xpath = ".//*[@id='CreateMenu']/li[9]/ul/li[1]/ul/li[8]/a")
	public WebElement MICR_Clearing;
	
	@FindBy (xpath = ".//*[@id='CreateMenu']/li[9]/ul/li[1]/ul/li[4]/a")
	public WebElement MICR_CTS_Presenting;
	
	@FindBy(xpath = ".//*[@id='CreateMenu']/li[9]/ul/li[4]/ul/li[3]/a")
	public WebElement ECS_Presenting;
	
	@FindBy (xpath=".//*[@id='CreateMenu']/li[9]/ul/li[4]/ul/li[4]/a")
	public WebElement ECS_Clearing;
	
	@FindBy (xpath=".//*[@id='CreateMenu']/li[9]/ul/li[1]/ul/li[10]/a")
	public WebElement BatchAssign;
	
	@FindBy (xpath=".//*[@id='CreateMenu']/li[18]/ul/li[4]/ul/li[4]/a")
	public WebElement CollectionImporting;
	
	@FindBy(xpath=".//*[@id='CreateMenu']/li[3]/ul/li[8]/a")
	public WebElement GLtransaction;
	
	@FindBy(xpath=".//*[@id='CreateMenu']/li[9]/ul/li[3]/ul/li[5]/a")
	public WebElement OutstationClearing;

	public MenuList(WebDriver driver)
	{
		this.Driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public MenuList()
	{
	}
	
	public void switchWindow(WebDriver driver) 
	{
		for (String winHandle : driver.getWindowHandles()) 
		{
			driver.switchTo().window(winHandle);
		}
	}
	
	public void Open_window(WebElement element2) 
	{
		JavascriptExecutor executor = (JavascriptExecutor) Driver;
		executor.executeScript("arguments[0].click();", element2);
	}
	
}
