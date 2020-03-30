package com.make.trip.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.make.trip.base.TripBase;
import com.make.trip.pages.BusPage;


public class BusPageTest extends TripBase{
	
    BusPage busPage;
	
	@BeforeTest()
	@Parameters("browser")
	public void setUp(String browser)
	{
		initialization(browser);
		busPage=new BusPage();
	}
	
	@Test(priority=1)
	public void clickBus()
	{
		busPage.clickBus();;
	}
	
	@Test(priority=2,dependsOnMethods = "clickBus")
	public void fillBusBookingDetails() throws InterruptedException
	{
		busPage.bookBusDetails();
	}
	
	@AfterTest()
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(30000);
		driver.close();
	}

}
