package com.beaconpro.test.acopening;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.acopening.CAOpeningPage;
import com.beaconpro.module.uiobject.authorization.ManagerAuthorisationPage;
import com.beaconpro.module.uiobject.common.NomineeAdding;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.common.TransactionModeSelection;
import com.beaconpro.module.uiobject.login.LoginPage;

public class CAOpeningWithCash  {

	WebDriver driver;
	CAOpeningPage objca;
	LoginPage newloginmaker;
	NomineeAdding   objnom;
	ManagerAuthorisationPage manage;
	ReadExcelFile exe;
	
	String SheetName="CA OPENING";
	String FileName="Data.xls";
	String ary[]= new String[30];
	
			
	
	//String Firefox_profile = "testing";
	String UserName;   // = "anitha";  			 // User Credentials
	String Pword ;     //= "vava*116";
	String sname ; //= "VIJAYARAGHAVAN EDAVALATH";
	String custid ; //= "101000091280";  
	String Amount; //="5000";
	String Remark; //="CA Reamark Succesfully Entered";
	String id;  //="101000091352";
	String OperatorrRelation;   //="Father";
	
	
	String NomCustName; // = "SAIMON"; // Nominee name
	String NomCustID;  // = "102";// Nominee CustID
	String NomRelation;; // = "FRIEND";// Relation with Nominee

	
	 //String TrnsferMode="CASH";
	String TrnsferMode;   //="TRANSFER";
	 String PostDebitCrdtPrdctGrp; //="Savings Bank";
	 String PostDebitCrdtPrdctNme; //="ORDINARY SB";
	 String Branchautoposting;// ="MAIN BRANCH";
	 String PostDebitCrdtAcNo; //="29140";
	 String InstrType;    //       = "Advice Slip";
	 String fieldValue;  
	 String Branch ;
	
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
	 sname=ary[2];
	 custid=ary[3];
	 Amount=ary[4];
	 Remark=ary[5];
	 id=ary[6];
	 OperatorrRelation=ary[7];
	 NomCustName=ary[8];
	 NomCustID=ary[9];
	 NomRelation=ary[10];
	 TrnsferMode=ary[11];
	 PostDebitCrdtPrdctGrp=ary[12];
	 PostDebitCrdtPrdctNme=ary[13];
	 Branchautoposting=ary[14];
	 PostDebitCrdtAcNo=ary[15];
	 InstrType=ary[16];
	 Branch=ary[17];
	 
	}
	
	
	@Test(priority = 2)
	public void open_beaconpro_url_and_login() throws Throwable {

		newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		newloginmaker.loginToBeaconProValid(UserName,Pword);

	}
	
	@Test(priority = 3)
	public void open_linkk_and_log_into_cbs() throws Throwable {
		objca = new CAOpeningPage(driver);
	      
	       //driver.findElement(By.name("imgbtnSubmit")).click();
	       //driver.findElement(By.xpath("html/body/div[1]/div[3]/div/button")).click();
	      // objca = new CAOpeningPage(driver);
	   	   objca.Cabutton();
	   	   Thread.sleep(1000);
	   	 
	}

	
	
	@Test(priority = 4)
	public void cust_search()throws Exception {
		
	try
		{
		objca = new CAOpeningPage(driver);
		objca.Enter_cust_id(custid);
		objca.Cust_Add();
		//objca.Wait_for_customer_grid();
		if (driver.findElements(
				By.xpath("html/body/div[3]/div[11]/div/button")).size() > 0)
		{
			//objca.AleadyCaClose();
			objca.AlreadyCaWarning.click();
		}
		
		else 
		{
			 //System.out.println("Cust added succesfuly");
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
}
	
   @Test(priority = 5)
	public void cust_general_tab() throws Exception {
		objca.Enter_DepositAmount(Amount);
		objca.DepositRoi();
		objca.Enter_DepositRemark(Remark);
		Thread.sleep(1000);
	}
   
   @Test(priority = 6)
   public void nominee() throws Exception {
	   objca = new CAOpeningPage(driver);
	   objca.NomineeNext();
	   objca.NomineeCheckBox();
	  
   }
   /*@Test(priority = 5)
   public void nomineeadding() throws Exception {
	   objnom = new NomineeAdding(driver);
	   objca.NomineeNext();
	   objnom.Nominee_Adding(NomCustName,NomCustID,NomRelation);
   }*/
   
  @Test(priority = 7)
   public void operator() throws Exception {
	   objca. OperatorNext();
	   objca.Operatorid(id);
	   objca.OperatorSearch();
	   objca.OperatorRelation(OperatorrRelation);
	   objca.OperatorAdd();
	   Thread.sleep(6000);
	   
   }
    
   
   @Test(priority = 8)
   public void transmode() throws Exception {
	objca = new CAOpeningPage(driver); 
	   
	 TransactionModeSelection objTransMode= new TransactionModeSelection(driver);
	   
	  if((TrnsferMode.equalsIgnoreCase("CASH")))
	  {
		 objTransMode.Selection_from_dropdown(objca.Transmode, "CASH");
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 objca.submit();
		 Thread.sleep(1000);
		 objca.PrintButton();
		 Thread.sleep(5000);
	  }
	  
	  else if((TrnsferMode.equalsIgnoreCase("BATCH")))
	  {
		objTransMode.Selection_from_dropdown(objca.Transmode, "TRANSFER");  
		 objca.submit();
		  objca.batchok();
		  WebDriverWait wait = new WebDriverWait(driver, 120);
         wait.until(ExpectedConditions.elementToBeClickable(objca.Print));

		  //Thread.sleep(1000);
		  objca.PrintButton();

		 // objca.ExplicitWait_elementToBeClickable(objca.Printclosebutton);
		  Thread.sleep(6000);
	  }
	  
	  else if((TrnsferMode.equalsIgnoreCase("AUTOPOSTING")))
	  {
		  
	 
	   objTransMode.Selection_from_dropdown(objca.Transmode, "TRANSFER");
	   String PostDebtPopUp = driver.getWindowHandle();
	   objca.Click_PostDebiitBtn.click();
	   objca.switch_window();	
		 objTransMode.Autoposting_PostDebit(Amount, PostDebitCrdtPrdctGrp, PostDebitCrdtPrdctNme, Branch, PostDebitCrdtAcNo, InstrType);
		 driver.switchTo().window(PostDebtPopUp);
		 
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  objca.submit();
		  Thread.sleep(1000);
		  objca.PrintButton();
		  Thread.sleep(5000);
	   
	  }
	   
	   
	   
	}
   }
   
	/*@Test(priority = 7)
	public void cust_viewDetailsGrid()throws Exception{
		objca. CustView();
		 Thread.sleep(2000);
		//objca.CustLoan();
		 Thread.sleep(2000);
		objca. CustATM();
		 Thread.sleep(2000);
		objca.CustCasa();
		 Thread.sleep(2000);
		objca. CustRating();
		 Thread.sleep(2000);
		objca.CustAlert();
	}*/
	/*@Test(priority = 9)
	public void openauth_beaconpro_url_and_login() throws Throwable {

		newloginmaker = new LoginPage(driver);
		newloginmaker.openUrlFor102();
		newloginmaker.loginToBeaconProValid("anjana", "sad3635");

	}
	@Test(priority = 10)
	public void manager_autharastion() throws Throwable {
		manage=new ManagerAuthorisationPage(driver);
		manage.open_manager_autho_window(driver);
		manage.click_refresh_button();
		
	}*/

