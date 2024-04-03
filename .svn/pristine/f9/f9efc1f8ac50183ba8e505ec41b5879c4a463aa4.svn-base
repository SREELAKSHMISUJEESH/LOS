package com.beaconpro.test.clearing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.clearing.MicrCTSReturn;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;
import org.apache.log4j.Logger;
public class MicrCTSReturnTestcase {

	public WebDriver driver;
	MicrCTSReturn ret;
	LoginPage newloginmaker;
	ReadExcelFile exe;
	
	   //Excel Data Sheet
	String SheetName="MICRCTSECS RETURN";
	String FileName="Data.xls";
	String ary[]= new String[10];
	
	                    //MICR-CTS-ECS RETURN POSSBLE HERE.
	          
	
	String UserName;   // = "anitha";  			 // User Credentials
	String Pword ;     //= "vava*116";
                    // SELECT GROUP,TYPE,BATCH CATEGORY
	
	    String clearinggroup;       //="MICR";
	              // String clearinggroup;       //="CTS";
	              // String clearinggroup="ECS";
		
		
		//String ClearingType="MICR INWARD";
		String ClearingType; //=  "MICR OUTWARD";
		//String ClearingType="CTS INWARD";
		//String ClearingType="CTS OUTWARD";
		 // String ClearingType="ECS CREDIT";
	    //String ClearingType="ECS DEBIT";
		
	
	
	   String ClearingBatch; //  = "102-MICR-OW-1152019-2";
	 //  String ClearingBatch  = "102-MICR-INW-1152019-1";
	   //String ClearingBatch  = "102-CTS-OW-1152019-1";
		 //String ClearingBatch  = "102-ECS-OW-1152019-1";
		// String ClearingBatch  = "102-ECS-INW-1152019-1";
	 
	   //String ClrngRegBranch = "MAIN BRANCH";
	 String Reason ; //="NOTEINLIST";
	 
	 
	
	
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
	 clearinggroup=ary[2];
	 System.out.println(clearinggroup);
	 ClearingType=ary[3];
	 System.out.println(ClearingType);
	 ClearingBatch=ary[4];
	 System.out.println(ClearingBatch);
	 Reason=ary[5];
	 System.out.println(Reason);
	 }
	
	@Test(priority = 2)
	public void open_beaconpro_url_and_login() throws Throwable {

		newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		newloginmaker.loginToBeaconProValid(UserName,Pword);

	}
	
	
	@Test(priority = 3)
	public void returnwindow() throws Throwable 
	{
		
		
		ret = new MicrCTSReturn(driver);
		           //CHECK MICR OR CTS

	  if((clearinggroup.equalsIgnoreCase("MICR")) ||(clearinggroup.equalsIgnoreCase("CTS")))
		
		 {
		                //System.out.println("returnwindow()    :"+clearinggroup);
			
		ret.micrreturnlink();
		
		Thread.sleep(1000);
		ret.clearingtype(ClearingType);
		              //ret.ExplicitWait_elementToBeClickable(ret.ClearingBatch);
		Thread.sleep(1000);
		ret.batchselect(ClearingBatch);
		ret.search();
		ret.ExplicitWait_elementToBeClickable(ret.AcNoGrid);
		           //CHECK  OUTWARD
		if((ClearingType.equalsIgnoreCase("MICR OUTWARD")) || (ClearingType.equalsIgnoreCase("CTS OUTWARD")))
		{
	    ret.regno();
		ret.reason(Reason);
		ret.ExplicitWait_elementToBeClickable(ret.SubmitButton);
		Thread.sleep(3000);
		ret.submit();
		ret.ExplicitWait_elementToBeClickable(ret.SummaryTransid);
		ret.print();
		Thread.sleep(3000);
		ret.printclose();
		System.out.println("\nOUTWARD RETURN SAVED SUCCSFULLY\n");
		
		}
		                     //CHECK INWARD
		else {
			ret.regno();
			ret.submit();
			ret.ExplicitWait_elementToBeClickable(ret.SummaryTransid);
			ret.print();
			Thread.sleep(3000);
			ret.printclose();
			System.out.println("\nINWARD RETURN SAVED SUCCSFUULY\n");
		    }
		 }
	                        //CHECK ECS
	   else if(clearinggroup.equalsIgnoreCase("ECS") ) 
	   {
		  ret.ecsreturnlink();
		  Thread.sleep(1000);
		  ret.ecsclearingtype(ClearingType); 
	      ret.ExplicitWait_elementToBeClickable(ret.EcsClearingbatch);
	      ret.ecsbatchselect(ClearingBatch);
	      ret.ecsserach();
		  ret.ExplicitWait_elementToBeClickable(ret.EcsClearingacnogrid);
                         //CHECK ECS CREDIT
		 if(ClearingType.equalsIgnoreCase("ECS CREDIT"))
		 {
			 ret.ecsreason(Reason);
			 ret.ExplicitWait_elementToBeClickable(ret.EcsClearingsubmit);
			 Thread.sleep(3000);
			 ret.ecssubmit();
			 ret.ExplicitWait_elementToBeClickable(ret.EcsClearingsummarytransid);
			 ret.ecsprint();
			 Thread.sleep(3000);
			 ret.ecsprintclose();
			 System.out.println("\nECS CREDIT RETURN SAVED SUCCSFULLY\n");
		 }
		            //CHECK ECS DEBIT
		 else 
		 {
			 ret.ecssubmit();
			 ret.ExplicitWait_elementToBeClickable(ret.EcsClearingsummarytransid);
			 ret.ecsprint();
			 Thread.sleep(3000);
			 ret.ecsprintclose(); 
			 System.out.println("ECS DEBIT RETURN SAVED SUCCSFULLY");
		 }
	    }
	}
}
