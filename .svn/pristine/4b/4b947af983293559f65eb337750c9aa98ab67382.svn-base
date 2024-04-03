package com.beaconpro.test.MDS;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.MDS.MDSPayment;
import com.beaconpro.module.uiobject.common.CustomerOrMemberAdding;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;

public class MDSorGDSPayment 

{
	public WebDriver driver;

	String UserName  			; //Enter User Name
	String Pword				; //Enter Pword
	String MDSNo				; 	//Enter MDS Number
	String TrnmodeMDSColelction ;	//Enter Transaction mode CASH/TRANSFER/BATCH
	String SubscriberNo			;		//Enter MDS subscriber number
	String SecurityType			; //Enter Security Type Jewel/Document/Deposit/Personal/MDS
	String WorthAmount			;
	String DepositSecurtyAcNo	;
	String SecuritySubscriberNo	;
	String TransactionMode		;
	
	public String PaymntAmount; 
	

	String SheetName = "MDSPayment";
	String FileName = "MDS/MDSPaymentdata.xls";
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
		TrnmodeMDSColelction=array[3];
		SubscriberNo		=array[4];
		SecurityType		=array[5];
		WorthAmount			=array[6];
		DepositSecurtyAcNo	=array[7];
		SecuritySubscriberNo=array[8];
		TransactionMode		=array[9];
		
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
	public void Open_MDSpayment_Window () {
		
		try {
			//Create an object for class MenuList from common package
			MenuList objMenuList = new MenuList (driver);
			objMenuList.Open_window(objMenuList.MDS_Payment);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}
	
	@Test (priority = 3)
	public void MDS_info ()
	
	{
		MDSPayment objMDSpaymnt = new MDSPayment (driver);
		objMDSpaymnt.MDSNo_MDSpayment(MDSNo);
		objMDSpaymnt.GetBtn_MDSpayment();
		objMDSpaymnt.GOBtn_MDSpayment();
		objMDSpaymnt.PrevousbIddetails_MDSpayment();
		objMDSpaymnt.PendingPaymntLIst_MDSpayment();
		objMDSpaymnt.SubscriberNo_MDSpayment(SubscriberNo);
		objMDSpaymnt.SubscriberGoBtn_MDSpyament();
		
	}
	
	@Test (priority = 4)
	public void MDS_Security_info () throws InterruptedException
	
	{
		MDSPayment objMDSpaymnt = new MDSPayment (driver);
		
		MenuList Mnlist = new MenuList (driver);
		
		CustomerOrMemberAdding objCustAdd = new CustomerOrMemberAdding (driver);
		
		if (SecurityType == "Jewel")
			
		{
			objMDSpaymnt.Itemname_MDSpayment();
			objMDSpaymnt.ItemQuantity_MDSpayment();
			objMDSpaymnt.item_weight_MDSpayment();
			objMDSpaymnt.AddBtn_goldsecurity_MDSpayment();	
		}
		
		else if (SecurityType == "Document")
			
		{
			
			objMDSpaymnt.DocumentSecuirty_tab();
			objMDSpaymnt.RegType_MDSpayment();
			objMDSpaymnt.RgNo_MDSpayment();
			objMDSpaymnt.DocDueDate_MDSpayment();
			objMDSpaymnt.DocGetBtn_MDSpayment();
			objMDSpaymnt.DocExist_OkBtn_MDSpayment();
			objMDSpaymnt.SRoffice_MDSpayment();
			objMDSpaymnt.DocRegYear_MDSpayment();
			objMDSpaymnt.DocNo_MDSpayment();
			objMDSpaymnt.SurveyNo_MDSpayment();
			objMDSpaymnt.RagDate_MDSpayment();
			objMDSpaymnt.WorthAmount_MDSpayment(WorthAmount);
			objMDSpaymnt.MarketValue_MDSpayment(WorthAmount);
			objMDSpaymnt.DocDetails_MDSpayment();
			
		}
		
		else if (SecurityType == "Deposit")
		
		{
			objMDSpaymnt.SecurityDepositTab_MDSpayment();
			objMDSpaymnt.SecurityDepositBranch_MDSpayment();
			objMDSpaymnt.SecurityDepositPrdctName_MDSpayment();
			objMDSpaymnt.DepsitsecurtyAcNo_MDSpayment(DepositSecurtyAcNo);
			objMDSpaymnt.DepstSecurtyAddBtn_MDSpayment();
		}
		
		else if (SecurityType == "Personal")
			
		{
			objMDSpaymnt.SecurityPersonalTab_MDSpayment();
			String Main_Window = driver.getWindowHandle();
			objMDSpaymnt.PersonalSuretyCustAdd_MDSpayment();
			Mnlist.switchWindow(driver);
			objCustAdd.Addcustname("Sanoop");
			objCustAdd.Clicksearch();
			objCustAdd.linkselection();
			driver.switchTo().window(Main_Window);
			objMDSpaymnt.SalrycertfcteChckbox_MDSpayment();
			objMDSpaymnt.payrecvryChckbox_MDSpayment();
			objMDSpaymnt.SelfcrtfceChckbox_MDSpayment();
			objMDSpaymnt.PersnlOffcename_MDSpayment();
			objMDSpaymnt.PersnlState_MDSpayment();
			objMDSpaymnt.PersnlDistrict_MDSpayment();
			objMDSpaymnt.PersnlPost_MDSpayment();
			objMDSpaymnt.BasicPay_MDSpayment();
			objMDSpaymnt.NetSalry_MDSpayment();
			objMDSpaymnt.AddpersnlsrtyBtn_MDSpayment();
		}
		
		else if (SecurityType == "MDS")
			
		{
			objMDSpaymnt.MDSNoMDSSecurity_MDSpayment(MDSNo);
			objMDSpaymnt.GetBtnMDSSecurity_MDSpayment();
			objMDSpaymnt.SubNoMDSSecrty_MDSpayment(SecuritySubscriberNo);
			objMDSpaymnt.GOBtnMDSSecrty_MDSpayment();
		}
		
		
		PaymntAmount = objMDSpaymnt.MDSPaymentAmount.getAttribute("value");
			
	}
	
	@Test (priority = 5)
	public void MDS_Payment_TransactionMode ()
	
	{
		MDSPayment objMDSpaymnt = new MDSPayment (driver);
		
		if (TransactionMode == "CASH")
			
		{
			objMDSpaymnt.TranMode_MDSpayment(TransactionMode);
			objMDSpaymnt.ClickSubmit_MDSpayment();
		}
		
		
		
	}
	
	
	
}
