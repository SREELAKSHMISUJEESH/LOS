
/********************************************************************************************************************	

Created By   :  Bajith Lal.K
Created On	 :	03/06/2016
Purpose	     :	GL Direct Transaction
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason
Bajith				09/06/2016			Added Data reading from excel file
-------------------------------------------------------------------------------------------------------------------

********************************************************************************************************************/
package com.beaconpro.test.transaction;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.beaconpro.config.ScreenShot;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;
import com.beaconpro.module.uiobject.transaction.GLTransactionPage;


public class GLTransaction {

	WebDriver driver;
	
	//Login Details
	String loginname;
	String password	;
	
	//GL Transaction 
	public String brname;
	public String glcode;
	public String glacname;
	public String trntype; 	 
	public String amt;
	public String trnmode;
	public String partyname	;
	public String particulars;
	
	//Auto Posting
	public String transactionbased; 
	public String trnansferbrname;
	public String trnansferglcode;
	public String trnansferglacname;
	public String autopostingbranch;
	public String autopostingprdgroup;
	public String autopostingprdname;
	public String autopostingacno;
	
	//Screen Shot (Screen shot Path :"\\seqc05\screenshot\")
	
	String FolderName 			="GLTransaction";
	String FileName0			="Transactionpage.jpeg";
	String FileName1			="Transactionsummary.jpeg";
	String FileName2			="GLcodeautoposting.jpeg";
	String FileName3			="Accountautoposting.jpeg";
	
	
	String SheetName = "GLTransaction";
	String FileName = "Transaction/GLinputdata.xls";
	
	GLTransactionPage glt;
	MenuList ml;
	ScreenShot ss;
	ReadExcelFile rdxlfile;
	
	@Test (priority = 0)
	public void menu_click() throws Throwable {
		excelreading();
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("lal");
		driver = new FirefoxDriver(ffprofile);
		LoginPage newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		newloginmaker.loginToBeaconProValid(loginname, password);
		
			
}
	@Test (priority = 1)
	private void excelreading() throws IOException, Exception 
	{
		
		rdxlfile=new ReadExcelFile(driver);
		String array[] = new String[100];
		rdxlfile.ReadFromExcelFile(SheetName,FileName,array);
		brname				=array[0];
		glcode				=array[1];
		glacname			=array[2];
		trntype				=array[3];
		amt					=array[4];
		trnmode				=array[5];
		partyname			=array[6];
		particulars			=array[7];
		transactionbased	=array[8];
		trnansferbrname		=array[9];
		trnansferglcode		=array[10];
		trnansferglacname	=array[11];
		autopostingbranch	=array[12];
		autopostingprdgroup	=array[13];
		autopostingprdname	=array[14];
		autopostingacno		=array[15];
		loginname			=array[16];
		password			=array[17];
		
		}
	
	
	@Test (priority=2)
	
	public void account_info() 
	{
		
		ml=new MenuList(driver);
		ml.Open_window(ml.GLtransaction);
		glt=new GLTransactionPage(driver);
		glt.explicitwait_elementToBeClickable(glt.branch);
		glt.branch.sendKeys(brname);
					
		for (int i = 0; i < 10; i++)
			try {
				glt.dropdown_selection(glt.glacname, glacname);
				break;
			} catch (StaleElementReferenceException e) {
					}
		for (int i = 0; i < 10; i++)
			try {
				glt.transtype.sendKeys(trntype);				
				break;
			} catch (StaleElementReferenceException e) {
					}
			glt.btn_go.click();
		}
		
	@Test (priority=2)
	public void trans_block() throws InterruptedException, IOException
	{
		glt.transamount.sendKeys(amt);
		if(trnmode.equalsIgnoreCase("CASH"))
	{
			for (int i = 0; i < 10; i++)
				try {
			glt.dropdown_selection(glt.Transmode, trnmode);
			break;
		} catch (StaleElementReferenceException e) {
		}
	Thread.sleep(2000);
	glt.partyname.sendKeys(partyname);
	glt.particulars.sendKeys(particulars);
	System.out.println("Transaction details Entered Properly");
	}
	else if(trnmode.equalsIgnoreCase("BATCH"))
		
	{
		for (int i = 0; i < 10; i++)
			try {
				glt.dropdown_selection(glt.Transmode, "TRANSFER");
				break;
			} catch (StaleElementReferenceException e) {
				}
		Thread.sleep(2000);
		glt.partyname.sendKeys(partyname);
		glt.particulars.sendKeys(particulars);
		System.out.println("Data Entered Properly");
		
		}
			
else if(trnmode.equalsIgnoreCase("AUTOPOST"))
		
	{
		for (int i = 0; i < 10; i++)
			try {
				glt.dropdown_selection(glt.Transmode, "TRANSFER");
				break;
			} catch (StaleElementReferenceException e) {
					}
		Thread.sleep(2000);
		glt.partyname.sendKeys(partyname);
		glt.particulars.sendKeys(particulars);
		System.out.println("Data Entered Properly");
		String oldwindow=driver.getWindowHandle();
		glt.post_crordrr.click();
		glt.switch_window();
		
		if(transactionbased.equalsIgnoreCase("GL Code"))
		{		
		glt.dropdown_selection(glt.trans_based,transactionbased);
		glt.trans_branch.sendKeys(trnansferbrname);
		glt.trans_glacno.sendKeys(trnansferglcode);
		glt.trans_glacno.sendKeys(Keys.TAB);
		Thread.sleep(2000);
/*		String glname =glt.trans_glacname.getAttribute("value");
		glt.explicitwait_TextToBePresentInElement(glt.trans_glacname, glname);*/
		System.out.println("GL transaction "+trntype+" amount:"+amt);
		glt.trans_glacamt.sendKeys(amt);
		ss=new ScreenShot(driver);
		ss.take_screen_shot(FolderName, FileName2);
		glt.btn_glacadd.click();
		Thread.sleep(2000);
		glt.Btn_Submit_Autoposting.click();
		driver.switchTo().window(oldwindow);
		}
		else if (transactionbased.equalsIgnoreCase("Account"))
				
		{
		glt.dropdown_selection(glt.trans_based, transactionbased);
		
		for (int i = 0; i < 10; i++)
			try {
			
				glt.dropdown_selection(glt.DDL_ProductGroup_Autoposting, autopostingprdgroup);
				break;
			} catch (StaleElementReferenceException e) {
				}
	
		//glt.explicitwait_elementToBeClickable(glt.DDL_ProductName_Autoposting);
		Thread.sleep(2000);
		
		for (int i = 0; i < 10; i++)
			try {
				glt.dropdown_selection(glt.DDL_ProductName_Autoposting,autopostingprdname);
			
				break;
			} catch (StaleElementReferenceException e) {
				}
		//glt.explicitwait_elementToBeClickable(glt.DDL_Branch_Autoposting);
		Thread.sleep(2000);
		
		for (int i = 0; i < 10; i++)
			try {
				glt.DDL_Branch_Autoposting.sendKeys(autopostingbranch);
				break;
			} catch (StaleElementReferenceException e) {
				}
		//glt.explicitwait_elementToBeClickable(glt.Txt_AcNo_Autoposting);
		Thread.sleep(2000);
		for (int i = 0; i < 10; i++)
			try {
				glt.Txt_AcNo_Autoposting.sendKeys(autopostingacno);
				break;
			} catch (StaleElementReferenceException e) {
				}
		glt.Txt_AcNo_Autoposting.sendKeys(Keys.TAB);
		System.out.println("Account transaction");
		if (trntype.equalsIgnoreCase("Credit"))
				{
			System.out.println("Entered "+trntype + " Transaction Block");
			
		for (int i = 0; i < 10; i++)
				try {
					glt.dropdown_selection(glt.DDL_InstrType, "Advice Slip");
					break;
					
				} catch (StaleElementReferenceException e) {
					}
				}

		Thread.sleep(2000);
		glt.Txt_Amount_Autoposting.sendKeys(amt);
		Thread.sleep(2000);
		System.out.println(trntype + " Transaction Amount:"+amt);
		//screen shot
		ss=new ScreenShot(driver);
		ss.take_screen_shot(FolderName, FileName3);
		
		glt.Btn_Add_Autoposting.click();
		Thread.sleep(2000);
		glt.Btn_Submit_Autoposting.click();
		driver.switchTo().window(oldwindow);
			}
		}
		
		//Screenshot
		if(trnmode.equalsIgnoreCase("BATCH"))
		{
			ss=new ScreenShot(driver);
			ss.take_screen_shot(FolderName, FileName0);
			glt.btn_submit.click();
			glt.batch_open_ok.click();
			Thread.sleep(5000);
			ss.take_screen_shot(FolderName, FileName1);
		}
		else
		{
		ss=new ScreenShot(driver);
		ss.take_screen_shot(FolderName, FileName0);
		glt.btn_submit.click();
		Thread.sleep(3000);
		ss.take_screen_shot(FolderName, FileName1);
		}
				
	}

	}


