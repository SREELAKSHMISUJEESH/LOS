package com.beaconpro.test.transaction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.acopening.CAOpeningPage;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;
import com.beaconpro.module.uiobject.transaction.FdInterestPayment;

public class FdInterestPaymentwithCash {

	WebDriver driver;
	LoginPage newloginmaker;
	FdInterestPayment ip;
	ReadExcelFile exe;
	//String branch="CHELANNUR";
	//String Ac_No = "1200";                   //CHELANUR FD ACNO
	
	String SheetName="FD INTEREST PAYMENT";
	String FileName="Data.xls";
	String ary[]= new String[30];
	
	String UserName;   // = "anitha";  			 // User Credentials
	String Pword ;     //= "vava*116";
	String branch; //  ="MAIN BRANCH";
	String Ac_No;  // = "236656";                   //MAIN BRANCH ACNO
	String Pro_Group;  // = "Fixed Deposit";
	String Pro_Name;  // = "ORDINARY FD";
	
	 
	
	String duration;  //="1";
	String durationmode;//="MONTHS";
	String pri;
	String Roi;
	String Totalinterest;
	String Pay;
	              //Transfer Auto Posting Details
	//String Trans_Mode = "TRANSFER";
	String Trans_Mode;  // = "CASH";
	String Pro_Groupp;  //="Savings Bank";
	String Pro_namee;  //="ORDINARY SB";
	String Acountno;  //="26851";                //SB ACNO
	String particular; //="Hai";
		

	
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
	 UserName=ary[0];
	 Pword=ary[1];
	 branch=ary[2];
	 Ac_No=ary[3];
	 Pro_Group=ary[4];
	 Pro_Name=ary[5];
	 duration=ary[6];
	 durationmode=ary[7];
	 Trans_Mode=ary[8];
	 Pro_Groupp=ary[9];
	 Pro_namee=ary[10];
	 Acountno=ary[11];
	 particular=ary[12];
	 
	 
	}
	
	@Test(priority = 2)
	public void open_beaconpro_url_and_login() throws Throwable {

		newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		newloginmaker.loginToBeaconProValid(UserName,Pword);

	}
	@Test(priority = 3)
	public void open_linkk_and_log_into_cbs() throws Throwable {
		ip = new FdInterestPayment(driver);
	      
	      
	   	   ip.fdintbutton();
	   	   Thread.sleep(1000);
	   	 
	}
   @Test(priority=4)
   public void account_info()throws Throwable {
	ip = new FdInterestPayment(driver);
	ip.select_branch(branch);
	ip.select_product_group(Pro_Group);
	ip.select_product_name(Pro_Name);
	ip.enter_account_number(Ac_No);
	ip.go_button();
	ip.Go_button_Wait();
	//Thread.sleep(3000);
	ip.KYC_Not_Completed_Warning_Msg_PopUp_Click();
	ip.already_standing_Warning_Msg_PopUp_Click();
	
	}
 @Test(priority=5)
   public void transaction_details() throws Exception {
	   ip = new FdInterestPayment(driver);
	   ip.previous_transaction();
	   ip.enter_duration(duration);
	   ip. ExplicitWait_elementToBeClickable(ip.DurationMode);
	   ip.enter_durationmode(durationmode);
	   ip.ExplicitWait_elementToBeClickable(ip.Transmode);
	   Thread.sleep(1000);
	 	ip.interestlog();
	  // ip.submitbutton();
	   ip.interestvalidation();      //Verify Interest Showing Correct.
	   
   }
 @Test(priority=6)
 public void transmode() throws Exception {
	 ip = new FdInterestPayment(driver);
	 
	 if(Trans_Mode.equalsIgnoreCase("CASH"))                //Check CASH Or Transfer
	   {
	  ip.Select_Transmode(ip.Transmode,"CASH");
	  ip.ExplicitWait_elementToBeClickable(ip.Remark);
	  Thread.sleep(1000);
	  ip.submitbutton();
	  //ip.submit_button_Wait();
	  
	  ip.PrintButton();
	  Thread.sleep(4000);
	  
	  ip. printclose();
	  
	  }
	   else if(Trans_Mode.equalsIgnoreCase("AUTOPOSTING")) 
	   {
		   ip.Select_Transmode(ip.Transmode,"TRANSFER");
		  
		  ip.ExplicitWait_elementToBeClickable(ip.Remark);
		  ip.postcreditbutton_transfer(Pro_Groupp,Pro_namee,Acountno,particular);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  ip.submitbutton();
		  ip.PrintButton();
		  Thread.sleep(4000);
		  ip. printclose();
		  
		 
	   }
	   else if(Trans_Mode.equalsIgnoreCase("BATCH")) 
	   {
		   
		      ip.Select_Transmode(ip.Transmode,"TRANSFER");
			  ip.ExplicitWait_elementToBeClickable(ip.Remark);
			  Thread.sleep(1000);
			  ip.submitbutton();
			  ip.batchok();
			  ip.PrintButton();
			  Thread.sleep(2000);
			  ip. printclose();
			 
	   }
 }
   
}
