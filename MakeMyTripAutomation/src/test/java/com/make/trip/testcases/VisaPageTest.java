package com.make.trip.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.make.trip.base.TripBase;
import com.make.trip.pages.VisaPage;

public class VisaPageTest extends TripBase{
	
	VisaPage visaPage;
	
	@BeforeTest()
	@Parameters("browser")
	public void setUp(String browser)
	{
		initialization(browser);
		visaPage=new VisaPage();
	}
	
	@Test(priority=1)
	public void clickVisa()
	{
		visaPage.clickVisa();
	}
	
	@Test(priority=2,dependsOnMethods = "clickVisa")
	public void fillVisaBookingDetails() throws InterruptedException
	{
		visaPage.bookVisaDetails();
	}
	
	@AfterTest()
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(30000);
		//driver.close();
	}

}
