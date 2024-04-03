package com.beaconpro.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		String fileName = new SimpleDateFormat("yyyy-MM-dd'.html'")
				.format(new Date());
		String Path = "C:\\Test Output\\BeaconPro_run_on_" + fileName;

		if (extent == null) {
			extent = new ExtentReports(Path, false);

		///	extent.config().documentTitle("Test Run Result")
		//			.reportName("Test Automation").reportHeadline("BeaconPro");

			extent.addSystemInfo("Windows 7", "64 bit").addSystemInfo(
					"Environment", "QA");
		}
		return extent;
	}

	/*
	 * 
	 * 
	 * public static String CaptureScreen(WebDriver driver, String ImagesPath) {
	 * TakesScreenshot oScn = (TakesScreenshot) driver; File oScnShot =
	 * oScn.getScreenshotAs(OutputType.FILE); File oDest = new File(ImagesPath +
	 * ".jpg"); try { FileUtils.copyFile(oScnShot, oDest); } catch (IOException
	 * e) { System.out.println(e.getMessage()); } return ImagesPath + ".jpg"; }
	 */
}