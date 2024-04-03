package com.beaconpro.module.uiobject.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = ".//*[@id='ctl00_lnkSignout']/strong")
	public WebElement SignoutLink;

	@FindBy(id = "txtBranch_txt")
	public WebElement BeaconproBranchName;

	@FindBy(xpath = "html/body/form/div[2]/div[2]/a[1]/strong")
	public WebElement HomeBtn;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void AssertPageTitle() {

		String PageTitle = driver.getTitle();
		Assert.assertEquals("Beacon CBS", PageTitle);

	}

	public void click_home_btn() {

		HomeBtn.isDisplayed();

		System.out.println("clicked on Home");

	}

	public void SignOutFromCBS() {

		SignoutLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(
				BeaconproBranchName, "MAIN BRANCH"));

	}

}
