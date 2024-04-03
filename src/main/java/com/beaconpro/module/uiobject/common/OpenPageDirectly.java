package com.beaconpro.module.uiobject.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenPageDirectly {

	WebDriver driver;

	@FindBy(xpath = "//li[3]/a")
	public WebElement QuickCustomerLink;

	@FindBy(xpath = ".//*[@id='CreateMenu']/li[1]/ul/li[2]/a")
	public WebElement CustomerSearchLink;

	@FindBy(xpath = ".//*[@id='CreateMenu']/li[1]/ul/li[5]/a")
	public WebElement InstitutionalCustomerLink;

	public OpenPageDirectly(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public void open_quick_customer_window() {

		WebElement element = QuickCustomerLink;
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	public void open_customer_search_window() {

		WebElement element = CustomerSearchLink;
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	public void open_institutional_customer_window() {

		WebElement element = InstitutionalCustomerLink;
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

	}
}
