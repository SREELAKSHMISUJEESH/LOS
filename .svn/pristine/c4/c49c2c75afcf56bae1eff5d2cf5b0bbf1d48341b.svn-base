package com.beaconpro.module.uiobject.clearing;

/********************************************************************************************************************	
Created By      : Shilpa.U.D 
Created On	    : 06/06/2016
Purpose	        : CTS Registration And Verification base page
Note			: 
Conditions      :  
  
-------------------------------------------------------------------------------------------------------------------
Modified By			Modified On			Reason

-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.beaconpro.module.uiobject.common.MenuList;

public class CTSRegistrationAndVerificationPage 
{
	WebDriver driver;
	@FindBy(xpath=".//*[@id='CreateMenu']/li[9]/ul/li[2]/ul/li[2]/a")
	public WebElement CTS_Regsitration_Link;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucCTSFileImport_ddlClearingType_ddl")
	public WebElement CTS_ClearingType;

	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucCTSFileImport_fileUpload")
	public WebElement Txt_File_Browse_btn;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucCTSFileImport_btnGet")
	public WebElement Txt_File_Get_btn;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_SectionCaption1_lblCaption")
	public WebElement Clearing_Details_Grid_label;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucCTSFileImport_fupPDFUpload")
	public WebElement Pdf_File_Browse_btn;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucCTSFileImport_btnGetPDF")
	public WebElement Pdf_File_Get_btn;
	
	@FindBy(id="toolbarViewerLeft")
	public WebElement PdfPreview_Area;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_btnSubmit")
	public WebElement Registration_Submit_btn;
	
	@FindBy(id="FloatingErrorMessageBoxTop")
	public WebElement ClearingDetailsSavedPopUp;
	
	@FindBy(id="closetop")
	public WebElement ClosePopup;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_lblSummary")
	public WebElement RegistrationSummary;
	
	/*******Verification Page Details **********/
	
	@FindBy(xpath=".//*[@id='CreateMenu']/li[9]/ul/li[2]/ul/li[3]/a")
	public WebElement CTSVerificationLink;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_ucCTSVerficationSearch_dtFrom_txt")
	public WebElement Verificn_FromDate;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_ucCTSVerficationSearch_dtTo_txt'")
	public WebElement Verificn_ToDate;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_ucCTSVerficationSearch_btnGetFileID")
	public WebElement Verificn_Search_Get_Btn;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_ucCTSVerficationSearch_ddlClgFile_ddl")
	public WebElement ClearingFile_dropdown;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_ucCTSVerficationSearch_fileUpload")
	public WebElement Verificn_PDF_File_Browse_btn;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_ucCTSVerficationSearch_btnGet")
	public WebElement Verificn_Pdf_File_Get_btn;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_ucCTSVerficationSearch_txtRegNoFrom_txt")
	public WebElement Verificn_From_RegNo;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_ucCTSVerficationSearch_txtRegNoTo_txt")
	public WebElement Verificn_To_RegNo;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_ucCTSVerficationSearch_btnGo")
	public WebElement Go_Btn;
	
	@FindBy(id="ctl00_ctl00_CPH1_PRDCNT_ucCTSVerifyListInfo_lstClearingList_ctrl0_chkSelect")
	public WebElement VerificationEntry_Select_Chkbox;
	
	@FindBy (id="imgCTSStatus")
	public WebElement ApproveBtn;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_btnVerify")
	public WebElement Verify_Btn;
	
	@FindBy (id="btnSubmit")
	public WebElement Verify_Popup_Submit_Btn;
	
	@FindBy (id="ctl00_ctl00_CPH1_PRDCNT_btnClose")
	public WebElement VerificationClose_Btn;
	
	
	
	
	public CTSRegistrationAndVerificationPage (WebDriver driver)
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void Open_RegistrationWindow()
	{
		
		MenuList ObjMenu=new MenuList(driver);
		ObjMenu.Open_window(CTS_Regsitration_Link);
	}
	public void Select_ClearingType(String ClngType) 
	{
		Select Select1 = new Select(CTS_ClearingType);
		Select1.selectByVisibleText(ClngType);
	}
	
	public void BrowseTextFile_FromPath(String Path)
	{
		Txt_File_Browse_btn.sendKeys(Path);
		System.out.println("\nText file uploaded");
	}
	public void BrowsePDF_File_FromPath(String Path)
	{
		Pdf_File_Browse_btn.sendKeys(Path);
		System.out.println("PDF file uploaded");
	}
	
	public void ClickOnTextFileGetButton()
	{
		Txt_File_Get_btn.click();
	}
	
	public void ClickOnPDF_FileGetButton()
	{
		Pdf_File_Get_btn.click();
	}
	
	public void getScreenshot() throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File("D:\\SeleniumShots\\CTSRegistration.png"));
            System.out.println("Registered Details Screenshot saved in location: " +"D:\\SeleniumShots\\CTSRegistration.png");
    }
	
	public void CTSRegistrationProcess(String ClngType,String TextFilePath,String PdfFilePath) throws Exception
	{
		Open_RegistrationWindow();
		Select_ClearingType(ClngType);
		BrowseTextFile_FromPath(TextFilePath);
		Thread.sleep(30);
		ClickOnTextFileGetButton();
		WebDriverWait Wait1=new WebDriverWait(driver,10);
		Wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_ctl00_CPH1_PRDCNT_SectionCaption1_lblCaption")));
		BrowsePDF_File_FromPath(PdfFilePath);
		Thread.sleep(30);
		ClickOnPDF_FileGetButton();
		Thread.sleep(10);
		getScreenshot();
		//WebDriverWait Wait2=new WebDriverWait(driver,30);
		//Wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("toolbarViewer")));
		Registration_Submit_btn.click();
		WebDriverWait Wait3=new WebDriverWait(driver,10);
		Wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("FloatingErrorMessageBoxTop")));
		Thread.sleep(30);
		ClosePopup.click();
		System.out.println("CTS Registration Done with Details: "+RegistrationSummary.getText());
		
		
	}
	
	/*public void Authorize_CTSRegistration(String Authorizn_User,String Authorizn_Pass)

	{
		Authorizations ObjAuthorise=new Authorizations(driver);
		ObjAuthorise.LoginForAuthorization(Authorizn_User, Authorizn_Pass);
		ObjAuthorise.Manager_authorization_Others();
	}
	*/
	
	/********** Verification window methods *******/
	public void OpenVerificationWindow()
	{
		MenuList ObjMenu=new MenuList(driver);
		ObjMenu.Open_window(CTSVerificationLink);
		
	}
	public void SetFromDate(String fromDate)
	{
		Verificn_FromDate.sendKeys(fromDate);
	}
	public void SetToDate(String toDate)
	{
		Verificn_FromDate.sendKeys(toDate);
	}
	
	public void ClickOnVerificationSearchGetButton()
	{
		Verificn_Search_Get_Btn.click();
	}
	
	public void SelectVerificationClearingFile()
	{
		Select Select1 = new Select(ClearingFile_dropdown);
		Select1.selectByIndex(1);
	}
	
	public void BrowsePDF_File_FromPath_ForVerification(String Path)
	{
		Verificn_PDF_File_Browse_btn.sendKeys(Path);
		System.out.println("Verification Page PDF file uploaded");
	}
	public void ClickOnPDFFileGetButton_ForVerification()
	{
		Verificn_Pdf_File_Get_btn.click();
	}
	
	public void switch_window()
	{
		for (String winHandle : driver.getWindowHandles()) 
		{
			driver.switchTo().window(winHandle);
		}

	}
	
	public void CTSVerificationProcess(String fromDate,String toDate) throws InterruptedException
	{
		OpenVerificationWindow();
		SetFromDate(fromDate);
		SetToDate(toDate);
		ClickOnVerificationSearchGetButton();
		Thread.sleep(3000);
		SelectVerificationClearingFile();
		//BrowsePDF_File_FromPath_ForVerification(Path);
		//Thread.sleep(10);
		//ClickOnPDFFileGetButton_ForVerification();
		//if(Verificn_From_RegNo.getText().length()>0)
		
		
		String FromRegNo=Verificn_From_RegNo.getAttribute("value").trim();
		String ToRegNo=Verificn_To_RegNo.getAttribute("value").trim();
		int n=Integer.parseInt(ToRegNo)-Integer.parseInt(FromRegNo) +1;
		System.out.println("Value of N is: " + n);
		 
			
		Go_Btn.click();
		Thread.sleep(300);
		for(int i=0;i<n;i++)
		{
			System.out.println("Value of i is: " + i);
			driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucCTSVerifyListInfo_lstClearingList_ctrl0_chkTd']"));
			VerificationEntry_Select_Chkbox.click();
			ApproveBtn.click();
			String parentHandle = driver.getWindowHandle();
			Verify_Btn.click();
			switch_window();
			if(Verify_Popup_Submit_Btn.isEnabled())
			{
				Verify_Popup_Submit_Btn.click();
				
			}
			else
			{
				System.out.println("Please Select Any Entry for Verification and Approve the same");
			}
			 
		driver.switchTo().window(parentHandle);
					
		}
		System.out.println("Verification Process Completed");
			 
	}
		 

	}

