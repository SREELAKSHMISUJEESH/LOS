package com.beaconpro.test.transaction;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beaconpro.module.uiobject.common.ReadExcelFile;
import com.beaconpro.module.uiobject.login.LoginPage;
import com.beaconpro.module.uiobject.transaction.TransactionPage;

public class Concurrent {

	public static WebDriver driver;
	String username;
	String password;
	String Br_Name ;
	String Pro_Group ;
	String Pro_Name ;
	String Ac_No ;
	String Tra_Type ;
	String Tra_Amount ;
	String Tra_Mode ;
	String Opertd_By ;

	String SheetName = "Concurrent";
	String FileName = "Transaction/Concurrentdata.xls";
	String array[] = new String[100];
	
	ReadExcelFile rdxlfile;
	
	
	@Test (priority = 0)
	public void excelreading() throws IOException, Exception 
	{
		
		rdxlfile=new ReadExcelFile(driver);
		rdxlfile.ReadFromExcelFile(SheetName,FileName,array);
		username	=array[0];
		password	=array[1];
		Br_Name		=array[2];
		Pro_Group	=array[3];
		Pro_Name	=array[4];
		Ac_No		=array[5];
		Tra_Type	=array[6];
		Tra_Amount	=array[7];
		Tra_Mode	=array[8];
		Opertd_By	=array[9];
	
		
		}
	
	@Test (priority=1)
	public void setup() throws Throwable {

		

			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile
					.getProfile("lal");
			driver = new FirefoxDriver(ffprofile);

			// Login of maker
			LoginPage newloginmaker = new LoginPage(driver);
			newloginmaker.openUrlFor102();
			newloginmaker.loginToBeaconProValid(username,password);

			for (int i = 0; i <10; i++) {
			
			TransactionPage ObjTra = new TransactionPage(driver);
			ObjTra.open_transaction_window();
			ObjTra.select_branch_name(Br_Name);
			ObjTra.select_product_group(Pro_Group);
			ObjTra.select_product_name(Pro_Name);
			ObjTra.enter_account_number(Ac_No);
			ObjTra.select_trans_type(Tra_Type);
			ObjTra.click_go_button();

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.elementToBeClickable(ObjTra.SubmitBtn));

			ObjTra.enter_transaction_amount(Tra_Amount);
			ObjTra.enter_operated_by(Opertd_By);
			ObjTra.select_trans_mode(Tra_Mode);
			ObjTra.click_on_submit();

			wait.until(ExpectedConditions.elementToBeClickable(ObjTra.PrintBtn));

			// log-out operation
		//	HomePage Objsignout = new HomePage(driver);
			//Objsignout.click_home_btn();
			//Objsignout.SignOutFromCBS();
			//driver.quit();
		}

	}

}
