package com.beaconpro.test.MDS;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.MDS.MDSSettlement;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.PrintAndDuplicate;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;

public class MDSorGDSSettlement 

{
	public WebDriver driver;
	
	String UserName			;
	String Pword			;
	String MDSNo			;
	
	String SheetName = "MDSSettlement";
	String FileName = "MDS/MDSSettlementdata.xls";
	String array[] = new String[100];
	
	
	ReadExcelFile rdxlfile;
	
	
	@Test (priority = 0)
	public void excelreading() throws IOException, Exception 
	{
		
		rdxlfile=new ReadExcelFile(driver);
		
		rdxlfile.ReadFromExcelFile(SheetName,FileName,array);
		UserName			=array[0];
		Pword				=array[1];
		MDSNo				=array[2];
		
		
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
		}
	

	
	
	@Test (priority = 1)
	public  void Open_URL_AND_Login_BEACONPRO() throws Throwable
	
	{
		try 
		
		{
			
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
	public void Open_MDSpayment_Window () {
		
		try {
			//Create an object for class MenuList from common package
			MenuList objMenuList = new MenuList (driver);
			objMenuList.Open_window(objMenuList.MDS_Settlement);
			
		} catch (Exception e) 
		
		{
			
			e.printStackTrace();
		}
			
	}
	
	@Test (priority = 3)
	public void MDS_Settlement () 
	
	{
		MDSSettlement objSttlmnt = new MDSSettlement (driver);
		
		PrintAndDuplicate objprint = new PrintAndDuplicate (driver);
		
		
		try
		
		{
			
			objSttlmnt.MDSNo_MDSSettlement(MDSNo);
			objSttlmnt.GetBtn_MDSSettlement();
			objSttlmnt.ShowList_MDSSettlement();
			objSttlmnt.SettlmentSummaryBtn();
			objSttlmnt.CloseBtn_MDSSettlement();
			objSttlmnt.SubmitBtn_MDSSettlment();
			Thread.sleep(8000);
			objprint.print_and_duplicate();
			
		}
		
		catch (Exception e)
		
		{
			e.printStackTrace();
		}
		
	}
}
