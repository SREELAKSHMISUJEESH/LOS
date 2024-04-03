package com.beaconpro.test.clearing;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.clearing.BatchAssign;
import com.beaconpro.module.uiobject.clearing.MicrOutstationRegistration;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;

public class MicrOutstationRegisterTestcase {
	
	WebDriver driver;
	LoginPage newloginmaker;
	MicrOutstationRegistration mic;
	BatchAssign bat;
	ReadExcelFile exe;
	
	//Excel Data Sheet
		String SheetName="MICROUTSTATION REGISTER";
		String FileName="Data.xls";
		String ary[]= new String[40];
		
	   //SELECT GROUP,TYPE,PRODUCT,BATCH DETAILS
	String Uname;           //="anitha";
	String pwd;          //="vava*116";
	
	String clearinggroup;    //="MICR";
	//String clearinggroup="OUTSTATION";
	//String clearinggroup="CTS";
	
	
	
	String ClearingType;   //="MICR INWARD";
	//String ClearingType="MICR OUTWARD";
	//String ClearingType="OUTSTATION INWARD";
	//String ClearingType="OUTSTATION OUTWARD";
	//String ClearingType="CTS OUTWARD";
	
	
	String ProductGroup;      //="Savings Bank";
	String Productname;       //="ORDINARY SB";
	//String Productacno="26850";
	String Productacno;          //="14260";
	
	
	String Instrtype;        //="Cheque";
	String Prefix;//="AA";
	String InstrNo;//="365994";           //No Should be Valid
	String InstDate;//="11052019";        //Date Should Be Valid
	String Amount;//="200.00";
	String Bank;//="AXIS BANK";
	String Bankbranch;//="CALICUT MAIN";
	//Outstation Register details
	String AgentBank;//="AXIS BANK";
	String Agentbankbranch;//="CALICUT MAIN";
	String Remark;//="Haii";
	
	        //AFTER REGISTER ENTER BATCH ASSIGN DETAILS
	String clearinggroupp;//="MICR";
	//String clearingtypebatch="MICR OUTWARD";
	String clearingtypebatch;//="MICR INWARD";
	String orgbranchid;//="MAIN BRANCH";
	String Startdate;//="11052019" ;   //TRANSACTIONDAT
	String Todate;//="11052019";       //TRANSACTIONDATE
	String ToBatchid;//="102-MICR-INW-1152019-1";
	
	
			
	@Test(priority = 0)
	public void opening_firefox() throws Exception {

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("default");
		driver = new FirefoxDriver(ffprofile);
	}

	
	
	@Test(priority = 1)
	 public void datafromexcel() throws Exception {
	 exe=new ReadExcelFile(driver);
	 exe.ReadFromExcelFile(SheetName,FileName,ary);
	 Uname=ary[0];
	 pwd=ary[1];
	 clearinggroup=ary[2];
	 ClearingType=ary[3];
	 ProductGroup=ary[4];
	 Productname=ary[5];
	 Productacno=ary[6];
	 Instrtype=ary[7];
	 Prefix=ary[8];
	 InstrNo=ary[9];
	 InstDate=ary[10];
	 Amount=ary[11];
	 Bank=ary[12];
	 Bankbranch=ary[13];
	 AgentBank=ary[14];
	 Agentbankbranch=ary[15];
	 Remark=ary[16];
	 clearinggroupp=ary[17];
	 clearingtypebatch=ary[18];
	 orgbranchid=ary[19];
	 Startdate=ary[20];
	 Todate=ary[21];
	 ToBatchid=ary[22];
	 
	 
	}
	
	@Test(priority = 2)
	public void open_beaconpro_url_and_login() throws Throwable {

		newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		newloginmaker.loginToBeaconProValid(Uname, pwd);

	}
	@Test(priority = 3)
	public void open_linkk_and_log_into_cbs() throws Throwable {
		mic = new  MicrOutstationRegistration(driver);
		   //Check Wheather MICR or Outstation Link
		if((clearinggroup.equalsIgnoreCase("MICR"))||(clearinggroup.equalsIgnoreCase("CTS")))
		{
		 mic.micrregisterlink();
		}
		else
		{
		 mic.outstationregisterlink();
		}
		 Thread.sleep(1000);
	      
	      }
	
	             //OUTSTATION REGISTER
	@Test(priority = 4)
	public void instrumentdetails() throws Throwable {
		mic=new MicrOutstationRegistration(driver);
		if(clearinggroup.equalsIgnoreCase("OUTSTATION"))
		{
			mic.clearingtype(ClearingType);
			Thread.sleep(1000);
			//mic.ExplicitWait_elementToBeClickable(mic.AccountBranch);
			mic.productgroup(ProductGroup);
			mic.ExplicitWait_elementToBeClickable(mic.Product);
			mic.product(Productname);
			mic.ExplicitWait_elementToBeClickable(mic.AcNo);
			mic.acno(Productacno);
			mic.AcNo.sendKeys(Keys.TAB);
			mic. custgridloading();
		    mic.Maskcode.sendKeys(Keys.TAB);
		    mic.ExplicitWait_elementToBeClickable(mic.AgentBank);
			mic.agentbank(AgentBank);
			Thread.sleep(2000);
			//mic.ExplicitWait_elementToBeClickable(mic.AgentBranch);
			mic.agentbankbranch(Agentbankbranch);
			Thread.sleep(2000);
			mic.instrumenttype(Instrtype);
			
			if(ClearingType.equalsIgnoreCase("OUTSTATION INWARD"))
			{
		   mic.instrumentprefix(Prefix);
		   mic.ExplicitWait_elementToBeClickable(mic.InstrumentNo);
		   Thread.sleep(1000);
		
		   mic.instrumentno(InstrNo);
		   mic.ExplicitWait_elementToBeClickable(mic.InstrumentDate);
		   Thread.sleep(1000);
		   mic.selectdate(InstDate);
		   mic.ExplicitWait_elementToBeClickable(mic.Amount);
		   mic.InstrumentDate.sendKeys(Keys.TAB);
		   mic.amount(Amount);
		   mic.instrumentno(InstrNo);
		
		   mic.ExplicitWait_elementToBeClickable(mic.Remark);
		  //Thread.sleep(2000);
		   mic.remark(Remark);
		  Thread.sleep(2000);
		  mic.submit();
		  mic.ExplicitWait_elementToBeClickable(mic.Printclosebutton);
		  Thread.sleep(1000);
		  mic.printclose();
		  Thread.sleep(7000);
			}
			                 //OUTSTATION OUTWARD
			else
			{
				    mic.instrumentno(InstrNo);
					mic.ExplicitWait_elementToBeClickable(mic.InstrumentDate);
					Thread.sleep(2000);
					mic.selectdate(InstDate);
					mic.InstrumentDate.sendKeys(Keys.TAB);
					mic.ExplicitWait_elementToBeClickable(mic.Amount);
					
					mic.amount(Amount);	
					Thread.sleep(2000);
					mic.submit();
					mic.ExplicitWait_elementToBeClickable(mic.Printclosebutton);
					Thread.sleep(1000);
					mic.printclose();
					Thread.sleep(5000);
			}
		
		}
		                   //MICR REGISTRATION
	else if((clearinggroup.equalsIgnoreCase("MICR"))||(clearinggroup.equalsIgnoreCase("CTS")))  
		
	{
		mic.clearingtype(ClearingType);
		Thread.sleep(1000);
		//mic.ExplicitWait_elementToBeClickable(mic.AccountBranch);
		mic.productgroup(ProductGroup);
		mic.ExplicitWait_elementToBeClickable(mic.Product);
		mic.product(Productname);
		mic.ExplicitWait_elementToBeClickable(mic.AcNo);
		mic.acno(Productacno);
		mic.AcNo.sendKeys(Keys.TAB);
		mic. custgridloading();
		mic.instrumenttype(Instrtype);
		                                  //MICR INWARD
		 if(ClearingType.equalsIgnoreCase("MICR INWARD"))  
		 {
			
			mic.instrumentprefix(Prefix);
			mic.ExplicitWait_elementToBeClickable(mic.InstrumentNo);
			Thread.sleep(1000);
			
			mic.instrumentno(InstrNo);
			//mic.InstrumentNo.sendKeys(Keys.TAB);
			
		
			mic.ExplicitWait_elementToBeClickable(mic.InstrumentDate);
			//mic.ExplicitWait_elementToBeClickable(mic.Amount);
			Thread.sleep(5000);
			mic.selectdate(InstDate);
			mic.InstrumentDate.sendKeys(Keys.TAB);
			mic.ExplicitWait_elementToBeClickable(mic.Amount);
			mic.amount(Amount);
			mic.bank(Bank);
			mic.instrumentno(InstrNo);
			mic.ExplicitWait_elementToBeClickable(mic.MicrRemark);
			 //Thread.sleep(2000);
			mic.micrremark(Remark);
			 Thread.sleep(2000);
			// mic.selectdate("InstDate");
			mic.submit();
			//mic.ExplicitWait_elementToBeClickable(mic.Printclosebutton);
			 Thread.sleep(1000);
			// mic.printclose();
			// Thread.sleep(7000);
			 System.out.println("MICR INWARD SAVED SUCCSFULLY");
		 }
		                        //MICR OUTWARD
		 else 
		 {
			    mic.instrumentprefix(Prefix);
			    mic.ExplicitWait_elementToBeClickable(mic.InstrumentNo);
				Thread.sleep(1000);
				
				mic.instrumentno(InstrNo);
				//mic.InstrumentNo.sendKeys(Keys.TAB);
			
				
				mic.ExplicitWait_elementToBeClickable(mic.InstrumentDate);
				//mic.ExplicitWait_elementToBeClickable(mic.Amount);
				Thread.sleep(2000);
				mic.selectdate(InstDate);
				mic.InstrumentDate.sendKeys(Keys.TAB);
				mic.ExplicitWait_elementToBeClickable(mic.Amount);
				mic.amount(Amount);
				mic.bank(Bank);
				//mic.instrumentno(InstrNo); 
				mic.ExplicitWait_elementToBeClickable(mic.Bankbranch);
				Thread.sleep(1000);
				mic.bankbranch(Bankbranch);
				Thread.sleep(2000);
				mic.submit();
				mic.ExplicitWait_elementToBeClickable(mic.Printclosebutton);
				Thread.sleep(1000);
				mic.printclose();
				Thread.sleep(5000);
				System.out.println("MICR OUTWARD SAVED SUCCSFULLY");
		 }
			
			
	 }
 }
	                     //BATCH ASSIGN  [Only For MICR-CTS]
	@Test(priority = 5)
	public void Batchassigncall() throws Throwable {
		bat=new BatchAssign(driver);
		
	    if(clearinggroup.equalsIgnoreCase("MICR"))
	     {
  bat.Batch_Assign(clearinggroupp,clearingtypebatch,orgbranchid,Startdate,Todate,ToBatchid);
	      }
	}
}
