package com.beaconpro.test.MDS;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.beaconpro.module.uiobject.MDS.MDSApplicationTransfer;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;

public class MDSorGDSApplicationTransfer

{

	public WebDriver driver;
	
	String UserName 	;
	String Pword		;
	String MDSNo		;
	
	String SheetName = "MDSApplicationTransfer";
	String FileName = "MDS/MDSApplicationTransferdata.xls";
	
	String array[] = new String[100];
	
	
	ReadExcelFile rdxlfile;
	
	
	@Test (priority = 0)
	public void excelreading() throws IOException, Exception 
	{
		
		rdxlfile=new ReadExcelFile(driver);
		rdxlfile.ReadFromExcelFile(SheetName,FileName,array);
		UserName		=array[0];
		Pword			=array[1];
		MDSNo			=array[2];
		
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
		
		}
	
	@Test (priority = 1)
	public  void Open_URL_AND_Login_BEACONPRO() throws Throwable
	
	{
		try {
			
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile("default");
			driver = new FirefoxDriver(ffprofile);	
			
			LoginPage	objLogin = new LoginPage (driver);
			objLogin.openUrlFor102();
			objLogin.loginToBeaconProValid(UserName,Pword);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	@Test (priority = 2)
	public void RD_Account_Opening_Window () {
		
		try {
			//Create an object for class MenuList from common package
			MenuList objMenuList = new MenuList (driver);
			objMenuList.Open_window(objMenuList.MDS_Application_Transfer);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}
	
	@Test (priority = 3)
	public void MDS_Application_Transfer () throws InterruptedException 
	
	{
		MDSApplicationTransfer objMDSappTrnferBase = new MDSApplicationTransfer (driver);
		objMDSappTrnferBase.MDS_No_applcation_Transfer (MDSNo);
		objMDSappTrnferBase.Click_GetBtn_ApplctnTrnsfer();
		objMDSappTrnferBase.Click_MDS_App_Transfer_GoBtn ();
		
		
		objMDSappTrnferBase.Click_MDS_TranferBtn();

		Thread.sleep (20000);
		objMDSappTrnferBase.MDS_No_Summary(MDSNo);
		objMDSappTrnferBase.MDS_Summary_Button();
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(objMDSappTrnferBase.MDS_application_Print));
		objMDSappTrnferBase.Click_PrintBtn_MDSAppTrndfr();
		
	}
	
	
}
