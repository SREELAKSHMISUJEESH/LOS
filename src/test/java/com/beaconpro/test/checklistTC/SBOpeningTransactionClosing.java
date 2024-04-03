package com.beaconpro.test.checklistTC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.beaconpro.module.uiobject.acopening.SBOpeningPage;
import com.beaconpro.module.uiobject.common.Authorizations;
import com.beaconpro.module.uiobject.common.MenuList;
import com.beaconpro.module.uiobject.common.NomineeAdding;
import com.beaconpro.module.uiobject.common.PrintAndDuplicate;
import com.beaconpro.test.acopening.SBOpening;

public class SBOpeningTransactionClosing
{
	
	WebDriver    	   driver;
	SBOpening     	   sbopening;
	NomineeAdding 	   objnom;
	MenuList           objml;
	PrintAndDuplicate  objpd;
	SBOpeningPage 	   objsb;
	Authorizations      auth;
	
	public String acno;
	public String transid;
	public String TransType = "Credit";
	String FolderName_o = "SBopening";
	String FileName_1 = "openingsummary.jpeg";	
	
	@Test(priority = 0)
	public void opening_firefox_and_login_into_beaconpro() throws Throwable
	{
		//sbopening = new SBOpening(driver);
		sbopening.ReadFromExcel();
		sbopening.opening_firefox();
		sbopening.open_beaconpro_url_and_login();
	}
	
	@Test(priority = 1)
	public void SB_opening() throws Exception 
	{
		objsb = new SBOpeningPage(driver);
		sbopening.SB_opening_window();
		sbopening.customer_search_window();
		sbopening.customer_adding_and_general_tab_edits();
		sbopening.transmode();
		//acno = objsb.Ac_No.getText();
		//transid = objsb.save_transid.getText();
		System.out.print("\nTransID : "+sbopening.transid+"\n");
		System.out.print("\nAc No : "+sbopening.AcNo+"\n");
	}
	
	@Test(priority = 2)
	public void authorization() throws Throwable
	{
		Actions actions = new Actions (driver);
		actions.moveToElement(objsb.SignOut).click().perform();
		//objsb.SignOut.click();
		/*LoginPage newloginmaker = new LoginPage(driver);
		auth = new Authorizations(driver);
		newloginmaker.loginToBeaconProValid(sbopening.User_Name, sbopening.Password);
		auth.Authorization(transid, TransType, sbopening.Trans_Mode);	*/
	}

}