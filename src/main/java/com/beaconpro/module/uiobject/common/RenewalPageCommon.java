package com.beaconpro.module.uiobject.common;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 29/04/2016
Purpose	        : Common controls in A/c closure page
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RenewalPageCommon {
	
	WebDriver driver;
	ClosurePageCommon ObjCloseComn=new ClosurePageCommon(driver);
	MenuList ObjMenuList=new MenuList(driver);
	String 	CustID;
	String NcustID;
	public String Renewal_SI_Prdt;
	public String Renewal_SI_Accno;
	public String Renewal_SI_Freqency;

	// give note as give standing a/c as loginned branch a/c
	
		@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_chkRenew")
		public WebElement Renewal_CheckBox_Field;
		
		@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_txtDuration_txt")
		public WebElement RenewalDuration_Field;
		
		@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_ddlDurationMode_ddl")
		public WebElement RenewalDurationMode_Field;
		
		@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_chkStandingInstruction")
		public WebElement Renewal_Intrst_transfr_Required_CheckBox;
		
		@FindBy(id="btnInterestTransfer")
		public WebElement Renewal_IntrstTransfer_Button;
		
		@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_chkNomineeDetails")
		public WebElement Renewal_Nominee_Required_CheckBox;
		
		@FindBy(id="btnNomineeDetails")
		public WebElement Renewal_NomineeDetails_Button;
		
		@FindBy(xpath=".//*[@id='UpdatePanel1']/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a/img")
		public WebElement Btn_cust_Nominee_Search;
		
		@FindBy(id="PopQuick1_txtName")
		public WebElement NomineeName_TextBox;
		
		@FindBy(id="PopQuick1_txtCustID")
		public WebElement NomineeCustID_TextBox;
		
		@FindBy(id="PopQuick1_btnSearch")
		public WebElement NomineeSearch_Button;
		
		@FindBy(id="PopQuick1_lst_ctrl0_lblCust_ID")
		public WebElement NomResultGrid_CustID_Field;
		
		@FindBy(id="PopQuick1_lst_ctrl0_linkSelect")
		public WebElement NomResultGrid_Select_Field;
		
		@FindBy(id="ucNomineeForm_ddlNomWit1Post_ddl")
		public WebElement DDL_NomWitnessPost;
		
		@FindBy(id="ucNomineeForm_ddlNomRelation_ddl")
		public WebElement Renewl_NomineeRelation_Field;
		
		@FindBy(id="ucNomineeForm_btnAddNominee")
		public WebElement NomineeAdd_Button;
		
		@FindBy(id="NomCustID")
		public WebElement NomineeAddGrid_CustID;

		
		@FindBy(id="ucStndInstrAccInfo_ddlFromProduct_ddl")
		public WebElement Renewal_SI_Product_Field;
		
		@FindBy (id="ucStndInstrAccInfo_txtStandAcNoF_txt")
		public WebElement Renewal_SI_Accno_Field;
		
		@FindBy(id="ucStndInstrAccInfo_txtExeFrequency_txt")
		public WebElement Renewal_SI_Frequency_Field;
					
		@FindBy(id="ucStndInstrAccInfo_dtEndDate_txt")
		public WebElement Renewal_SI_EndDate_Field;
		
		@FindBy(id="btnSubmit")
		public WebElement Renewal_PopUp_Submit_Button;
		
	
		@FindBy(id="FloatingwarningMessageBoxCustomerIsEligibleforSeniorCitizenROIbenefit")
		public WebElement SeniorCitizen_PopUp_Mesg;
		
		@FindBy (id="closewarning")
		public WebElement SeniorCitizen_PopUp_Mesg_OK_Button;
		
		
		public RenewalPageCommon(WebDriver driver)
		{
			this.driver = driver;
			
			// This initElements method will create all WebElements
			PageFactory.initElements(driver, this);
			//PageFactory.initElements(driver, SBOpeningPage.class);
		}
		 
 

		public void ClickOnRenewalCheckBox() throws InterruptedException
		{
			this.Renewal_CheckBox_Field.click();
			Thread.sleep(120);
		}

		public void Select_RenewalDuration_mode(String renew_durn_mode)
		{
			Select drop = new Select(RenewalDurationMode_Field);
			drop.selectByVisibleText(renew_durn_mode);

		}
		public void Select_Renewal_NomRelation(String renew_nom_relation)
		{
			Select drop = new Select(Renewl_NomineeRelation_Field);
			drop.selectByVisibleText(renew_nom_relation);

		}
		public void  Select_Renewal_SI_Product(String Renew_SI_Prdt) {

			Select RDRepaymentPrdct = new Select (Renewal_SI_Product_Field);
			RDRepaymentPrdct.selectByVisibleText(Renew_SI_Prdt);

			}
	/*	public void ClickOn_Renewal_InterestTransfr_Required() throws InterruptedException
		{
			this.Renewal_Intrst_transfr_Required_CheckBox.click();
		}
		/*public void ClickOn_Renewal_Nominee_Required() throws InterruptedException
		{
			this.Renewal_Nominee_Required_CheckBox.click();
		}*/
		public void Nominee_Adding(String NomineeCustName, String NomineeCustID,
				String NomineeRelation) 
		{
			String parenthandle = driver.getWindowHandle();
			Btn_cust_Nominee_Search.click();
			ObjMenuList.switchWindow(driver); 
			WebDriverWait wait1 = new WebDriverWait(driver, 50);
			wait1.until(ExpectedConditions.elementToBeClickable(NomineeName_TextBox));
			//ExplicitWait_elementToBeClickable(Btn_Search);
			NomineeName_TextBox.sendKeys(NomineeCustName);
			
			wait1.until(ExpectedConditions.elementToBeClickable(NomineeCustID_TextBox));
			NomineeName_TextBox.sendKeys(NomineeCustID);
			NomineeSearch_Button.click();
			//ExplicitWait_elementToBeClickable(NomResultGrid_Select_Field);
			
			WebDriverWait wait2 = new WebDriverWait(driver, 30);
			wait2.until(ExpectedConditions.elementToBeClickable(NomResultGrid_Select_Field));
			CustID = NomResultGrid_CustID_Field.getText();
			NomResultGrid_Select_Field.click();
			driver.switchTo().window(parenthandle);
			
		/*	for (int i = 0; i < 10; i++)
				try {
					DDL_NomWitnessPost.
				} catch (StaleElementReferenceException e) {
					e.printStackTrace();
				}
				*/
			
			this.Select_Renewal_NomRelation(NomineeRelation);
			NomineeAdd_Button.click();
			WebDriverWait wait3 = new WebDriverWait(driver, 20);
			wait3.until(ExpectedConditions.visibilityOf(NomineeAddGrid_CustID));
			NcustID = NomineeAddGrid_CustID.getText();
			// Assert.assertEquals(CustID, NcustID);
			
			if (CustID.equals(NcustID)) {
				System.out
						.println("\nSelected Nominee and added Nominee are same(Verified)\n");
			} else {
				System.out
						.println("\nSelected Nominee and added Nominee aren't same\n");
			}
			this.Renewal_PopUp_Submit_Button.click();
		}
		
		public void Renewal_NomineeDetails_Submit(String NomineeCustName, String NomineeCustID, String NomineeRelation)
		{
			
			NomineeAdding ObjNomAdd=new NomineeAdding(driver);
			
			if (!Renewal_Nominee_Required_CheckBox.isSelected())
			{
				System.out.println("Nominee details not present;Need to Enter\n");
				this.Renewal_Nominee_Required_CheckBox.click();
				String parentHandle=driver.getWindowHandle();
				ObjCloseComn.dependableClick_for_StaleElement_handling(driver, Renewal_NomineeDetails_Button);
				this.Renewal_NomineeDetails_Button.click();
				
				ObjMenuList.switchWindow(driver);
				this.Nominee_Adding(NomineeCustName, NomineeCustID, NomineeRelation);
				driver.switchTo().window(parentHandle);
			}
			else
			{
				System.out.println("Nominee details already present\n");
			}
		}
		
		public void Send_Renewal_StandingDetails(String Renewal_SI_Prdt,String Renewal_SI_Accno,String Renewal_SI_Freqency) throws InterruptedException
		{
				
				this.Select_Renewal_SI_Product(Renewal_SI_Prdt);
				String AccNo=this.Renewal_SI_Accno_Field.getText();
				if(AccNo!="")
				{
				this.Renewal_SI_Accno_Field.clear();
				Thread.sleep(10);
				}
				this.Renewal_SI_Accno_Field.sendKeys(Keys.TAB);
				this.Renewal_SI_Accno_Field.sendKeys(Renewal_SI_Accno);
				
				this.Renewal_SI_Frequency_Field.sendKeys(Renewal_SI_Freqency);
				Thread.sleep(30);
				this.Renewal_SI_Frequency_Field.sendKeys(Keys.TAB);
			
				ObjCloseComn.dependableClick_for_StaleElement_handling(driver, Renewal_PopUp_Submit_Button);
				Thread.sleep(40);
				
			}
		public void Renewal_StandingDetails_Submit(String Renewal_SI_Prdt,String Renewal_SI_Accno,String Renewal_SI_Freqency) throws InterruptedException
		{
			MenuList ObjMenuList=new MenuList(driver);		
			if (!Renewal_Intrst_transfr_Required_CheckBox.isSelected())
			{		 
				
				System.out.println("Standing details not present;Need to Enter\n");
				this.Renewal_Intrst_transfr_Required_CheckBox.click();
				String parentHandle=driver.getWindowHandle();
				this.Renewal_IntrstTransfer_Button.click();
				ObjMenuList.switchWindow(driver);
				this.Send_Renewal_StandingDetails(Renewal_SI_Prdt,Renewal_SI_Accno, Renewal_SI_Freqency);
				driver.switchTo().window(parentHandle);
			}
			
			else
			{
				System.out.println("Standing details already present;Correcting the A/c details\n");
				String parentHandle=driver.getWindowHandle();
				this.Renewal_IntrstTransfer_Button.click();
				ObjMenuList.switchWindow(driver);
				this.Send_Renewal_StandingDetails(Renewal_SI_Prdt,Renewal_SI_Accno, Renewal_SI_Freqency);
				driver.switchTo().window(parentHandle);
			}
			System.out.println("Renewal_StandingDetails_Submit Executed\n");
		}
		
		
		public void SeniorCitizen_PopUp_Handle() throws InterruptedException
		{
			ClosurePageCommon ObjCloseComn=new ClosurePageCommon(driver);
			//if(this.SeniorCitizen_PopUp_Mesg.isDisplayed())
			if (driver.findElement(By.id("closewarning")).isDisplayed())
			{
				Thread.sleep(30);
				System.out.println("Senior Citizen Customer Popup present \n");
				this.SeniorCitizen_PopUp_Mesg_OK_Button.click();
				ObjCloseComn.click_on_submit();
			}
						
			else
			{
				System.out.println("Senior Citizen Customer Popup is not present \n");
			}
		}
		
		
	
}
