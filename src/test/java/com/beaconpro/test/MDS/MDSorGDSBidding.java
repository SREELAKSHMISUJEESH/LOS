package com.beaconpro.test.MDS;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.MDS.MDSBidding;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.PrintAndDuplicate;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;

public class MDSorGDSBidding {

	public WebDriver driver;
	
	String UserName 			; //Enter User Name
	String Pword				; //Enter User Pwrd
	String MDSNO				;	//Enter MDS Number
	String BiddingAmount		;	//Enter Bidding Amount
	String SubscriberNo			;		//Enter Bidding Subscriber No
	String DiscAndCommISadjust	;		//Enter YES or NO for discount adjust or not			
	
	String SheetName = "MDSBidding";
	String FileName = "MDS/MDSBiddingdata.xls";
	String array[] = new String[100];
	
	
	ReadExcelFile rdxlfile;
	
	
	@Test (priority = 0)
	public void excelreading() throws IOException, Exception 
	{
		
		rdxlfile=new ReadExcelFile(driver);
		
		rdxlfile.ReadFromExcelFile(SheetName,FileName,array);
		UserName			=array[0];
		Pword				=array[1];
		MDSNO				=array[2];
		BiddingAmount		=array[3];
		SubscriberNo		=array[4];
		DiscAndCommISadjust	=array[5];
			
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
		}
	
	//@Test (priority = 1)
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
	
	//@Test (priority = 2)
	public void Open_Bidding_Window () {
		
		try {
			//Create an object for class MenuList from common package
			MenuList objMenuList = new MenuList (driver);
			objMenuList.Open_window(objMenuList.MDS_Bidding_Link);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}
	
	//@Test (priority = 3)
	public void GDS_MDS_Bidding () throws Exception
	
	{
		try
		
		{
			PrintAndDuplicate objprnt = new PrintAndDuplicate (driver);
			
			MDSBidding objMDSBidding = new MDSBidding (driver);
			objMDSBidding.Enter_MDS_NUMBER_Bidding(MDSNO);
			objMDSBidding.Click_get_btn_Bidding();
			objMDSBidding.Enter_Bidding_Amount(BiddingAmount);
			objMDSBidding.Click_GO_Button_Bidding();
			WebDriverWait wait1 = new WebDriverWait (driver ,10);
			wait1.until(ExpectedConditions.elementToBeClickable(objMDSBidding.Enter_Subscriber_No_MDSBidding));
			objMDSBidding.Enter_Subscriber_No(SubscriberNo);
			objMDSBidding.Click_Subscriber_goBtn();
			objMDSBidding.Click_PrevoiusBiddetails_chkbx();
			objMDSBidding.MDS_Bidding_Submit();
			
			if (DiscAndCommISadjust == "YES")
			
			{
				objMDSBidding.Click_Adjustdiscnt_YES ();
				WebDriverWait wait2 = new WebDriverWait (driver ,10);
				wait2.until(ExpectedConditions.elementToBeClickable(objprnt.print_button));
				objprnt.print_and_duplicate();
			}
			
			else
				
			{
				objMDSBidding.Click_Adjustdiscnt_NO ();

			}
		
		} catch (Exception e)
		
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
