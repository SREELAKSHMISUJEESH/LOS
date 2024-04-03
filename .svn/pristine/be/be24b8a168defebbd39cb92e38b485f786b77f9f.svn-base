package com.beaconpro.module.uiobject.common;

/********************************************************************************************************************	
Created By      : Yadhu
Created On	    : 07/06/2016

ReadExcelFile ref = new ReadExcelFile(driver);
ref.ReadFromExcelFile(SheetName,FileName);
-------------------------------------------------------------------------------------------------------------------
********************************************************************************************************************/

import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelFile {
	
	WebDriver driver;
	
	String FilePath = "//seqc05/TestData/";
	 int abc = 0;
	
	public ReadExcelFile(WebDriver driver)
	{
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public String[] ReadFromExcelFile(String SheetName, String FileName,String array[]) throws BiffException, IOException 
	{
		FilePath = FilePath + FileName;
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet(SheetName);

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();

		for (int row = 1; row < totalNoOfRows; row++)
		{
			for (int col = 1; col < totalNoOfCols; col++)
			{
				array[abc]=sh.getCell(col, row).getContents();
				abc = abc + 1;
			}
		}
		return array;
	}

}