package com.beaconpro.test.acopening;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beaconpro.config.ScreenShot;
import com.beaconpro.module.uiobject.acopening.RDOpeningPage;
import com.beaconpro.module.uiobject.common.Authorizations;
import com.beaconpro.module.uiobject.common.CustomerOrMemberAdding;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.NomineeAdding;
import com.beaconpro.module.uiobject.common.OperatorAdding;
import com.beaconpro.module.uiobject.common.PrintAndDuplicate;
import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.common.RepaymentAccountAdding;
import com.beaconpro.module.uiobject.common.TransactionModeSelection;
import com.beaconpro.module.uiobject.login.LoginPage;



public class RDOpeningWithCashorTransfer {
	
public static WebDriver driver;



	
	public String UserName				;		 //Enter Login User Name
	public String Pword					;	 	 //Enter User Password
	public String CustName				;	 //ENter Customer Name
	public String RDOPeningAMount	    ;		 //Enter Account Opening Amount
	public String RD_Duration			;			 //Enter RD Duration
	public String OperatorName			;	 //Enter Operator Name
	public String Operator_Relation		;		 //Enter Operator Relation
	public String NomineeCustName		;		 //Enter Nominee Name
	public String NomineeId				;			 //Enter Nominee ID
	public String NomineeRelation		;		 //Enter Nominee Relation
	public String Repayment_Product		; //Enter Account Repayment Product
	public String RepaymentAccount		;		 //Enter Repayment Account
	public String RepaymentFrequency	;			 //Enter Repayment frequency
	public String FrequnceyDurationMode	;		 //Enter repayment frequency duration mode
	public String TrnsferMode			;	 	 //Enter Transaction Mode CASH/TRANSFER/BATCH
	public String PostDebitCrdtPrdctGrp	;//Enter Post Debit or credit Product Group  
	public String PostDebitCrdtPrdctNme	; //Enter Post Debit or credit Name
	public String PostDebitCrdtAcNo		;		 //Enter Post Debit or credit Number
	public String Instrtype				;  //Enter Post Debit instrument Number
	public String PostDebitCrdtAmount	;//Enter Post Debit or credit opening amount
	public String AuthUsrName			;	 //Enter Account Opening Authorization User Name
	public String AuthPword 			;	  	 //Enter Account Authorization PassWord
	public String TransType				;

	
	String SheetName = "RDOpening";
	String FileName = "Reccuring Deposit/RDinputdata.xls";
	String array[] = new String[100];
	
	String FolderName 				= "RDOpening";
	String GeneralTabScreenshot		= "RDOPeningGeneralTab.jpeg";
	String NomineeTabScreenshot		= "RDOpeningNomineeTab.jpeg";
	String OperatorTabScreenshot	= "RDOpeningOperatorTab.jpeg";
	String RepaymentTabScreenshot	= "RDOpeningRepayment.jpeg";
	String SummaryPageScreenShot	= "RDOpeningSummary.jpeg";
	
	ReadExcelFile rdxlfile;
	
	
	@Test (priority = 0)
	public void excelreading() throws IOException, Exception 
	{
		
		rdxlfile=new ReadExcelFile(driver);
		
		rdxlfile.ReadFromExcelFile(SheetName,FileName,array);
		UserName				=array[0];
		Pword					=array[1];
		AuthUsrName				=array[2];
		AuthPword				=array[3];
		CustName				=array[4];
		RDOPeningAMount			=array[5];
		RD_Duration				=array[6];
		OperatorName			=array[7];
		Operator_Relation		=array[8];
		NomineeCustName			=array[9];
		NomineeId				=array[10];
		NomineeRelation			=array[11];
		Repayment_Product		=array[12];
		RepaymentAccount		=array[13];
		RepaymentFrequency		=array[14];
		FrequnceyDurationMode	=array[15];
		TrnsferMode				=array[16];
		PostDebitCrdtPrdctGrp	=array[17];
		PostDebitCrdtPrdctNme	=array[18];
		PostDebitCrdtAcNo		=array[19];
		Instrtype				=array[20];
		
		
		PostDebitCrdtAmount	= RDOPeningAMount;
		
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
			objMenuList.Open_window(objMenuList.RD_Opening_Link);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}
	
	@Test(priority = 3)
	public void Add_Customer_Customer_SearchWindow () {
		
		CustomerOrMemberAdding objCustmrMembrAddng = new CustomerOrMemberAdding (driver);
		
		try {
			
			objCustmrMembrAddng.Add_Customer_OR_Member (CustName);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}	
	}
	

	@Test(priority = 4)
	public void RD_General_Tab_NomineeTab_OperatorTab_RepaymentTab () throws InterruptedException {
		
		try {
			
			CustomerOrMemberAdding objCustmrMembrAddng = new CustomerOrMemberAdding (driver);
			
			RDOpeningPage objRDOpengBase = new RDOpeningPage (driver);
			
			OperatorAdding objOperatorAdd = new OperatorAdding (driver);
			
			RepaymentAccountAdding objrepymnt = new RepaymentAccountAdding (driver);
			
			NomineeAdding objNominee = new NomineeAdding (driver);
			
			ScreenShot objScreenshot = new ScreenShot (driver);
			
			if (driver
					.findElements(By.xpath("html/body/div[3]/div[11]/div/button"))
					.size() > 0) {
				
				objCustmrMembrAddng.OK_Btn_For_RD_AC_Exist.click();
				
			}
				objRDOpengBase.RD_General_Tab(RDOPeningAMount,RD_Duration);
				objRDOpengBase.SeniorCitizen_ROI_PopUp();
				objScreenshot.take_screen_shot(FolderName, GeneralTabScreenshot);
				
				objRDOpengBase.NomineeTab.click();
				//driver.findElement(By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_chkNominee")).click();
				objNominee.Nominee_Adding(NomineeCustName,NomineeId,NomineeRelation);
				objScreenshot.take_screen_shot(FolderName, NomineeTabScreenshot);
				
				objOperatorAdd.OperatorTab(OperatorName,Operator_Relation);
				objScreenshot.take_screen_shot(FolderName, OperatorTabScreenshot);
				Thread.sleep(3000);
				objrepymnt.RD_Opening_Repayment_Tab(Repayment_Product,RepaymentAccount,
										RepaymentFrequency,FrequnceyDurationMode);
				objScreenshot.take_screen_shot(FolderName, RepaymentTabScreenshot);
	
		
			} catch (Exception e)
		
		{
				e.printStackTrace();	
		}
			
			
	}
			
	
	@Test(priority = 5)
	//Transaction Mode CASH/TRANSFER(AutoPosting)/Open Batch
 	public void TransferModeSelection() throws Throwable {
 		
		try {
    		
 			RDOpeningPage objRDOpengBase = new RDOpeningPage (driver);
 			
 			LoginPage	objLogin = new LoginPage (driver);
 			
 			TransactionModeSelection objtrnmode = new TransactionModeSelection (driver);
 			
 			PrintAndDuplicate objopengPrint = new PrintAndDuplicate (driver);
 			
 			ScreenShot objScreenshot = new ScreenShot (driver);
 			
 			Authorizations objAuth = new Authorizations (driver);
 			
    		//String TransactionMode = "CASH";
    		
 			
 			System.out.println("transfermode is " +TrnsferMode);
    		if (TrnsferMode.equalsIgnoreCase("CASH"))
    		
    		{
    			//objtrnmode.Select_Account_Opening_Transmode (TrnsferMode);
    			//objtrnmode.Click_Account_Opening_SaveBtn();
    			
    			objtrnmode.Account_Opening_Cash (TrnsferMode);
    			if(objRDOpengBase.GetTransType.getText().equalsIgnoreCase("Cr"))
    			{
    				TransType ="Credit";
    			}
    			else
    				
    			{
    				TransType="Debit";
    			}
    			//Thread.sleep(5000);
    			WebDriverWait wait8 = new WebDriverWait(driver, 100);
        		wait8.until(ExpectedConditions.elementToBeClickable(objRDOpengBase.RDOpeningPrint));
        		objScreenshot.take_screen_shot(FolderName, SummaryPageScreenShot);
        		objopengPrint.print_and_duplicate();
        		System.out.println("USERNAME "+AuthUsrName);
        		objAuth.LoginForAuthorization(AuthUsrName, AuthPword);
        		objAuth.Authorization(objopengPrint.transid, TransType, TrnsferMode);
        		//objRDOpengBase.SignOut_Authorize_CashTransaction (AuthUsrName,AuthPword);
        		
    		}
   
    		else {
    			
    			//String TrasnferMode = "TRANSFER";
    			
    			if (TrnsferMode.equalsIgnoreCase("TRANSFER")) {
    				
    				String TransTypeTransfer = "Credit";
    				
    				System.out.println("Amount is " + PostDebitCrdtAmount);
        			objtrnmode.Account_Opening_Transfer_Autoposting(TrnsferMode, PostDebitCrdtPrdctGrp,
        															PostDebitCrdtPrdctNme, PostDebitCrdtAcNo,
        															Instrtype,PostDebitCrdtAmount);
        			objScreenshot.take_screen_shot(FolderName, SummaryPageScreenShot);
        			objopengPrint.print_and_duplicate();
        			System.out.println("USERNAME "+AuthUsrName);
            		objAuth.LoginForAuthorization(AuthUsrName, AuthPword);
            		objAuth.Authorization(objopengPrint.transid, TransTypeTransfer, TrnsferMode);
    					
    			} else {
    				
    				
    				String BatchMode = "TRANSFER";
    				
    				objtrnmode.Account_Opening_BatchTransfer (BatchMode);
    				objScreenshot.take_screen_shot(FolderName, SummaryPageScreenShot);
    				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    				objopengPrint.print_and_duplicate();
    				
    			}
    			
    			
    		} } catch (Exception e) {
    		
    			e.printStackTrace();
    		}
    		
	} }
    		
 	 
	    	   	
	    	
		