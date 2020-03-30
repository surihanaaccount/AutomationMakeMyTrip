package com.make.trip.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.make.trip.base.TripBase;
import com.make.trip.pages.FlightBookingPage;
import com.make.trip.pages.FlightPage;

public class FlightPageTest extends TripBase{
	
	FlightPage flightPage;
	FlightBookingPage flightbookingPage;
	
	@BeforeTest()
	@Parameters("browser")
	public void setUp(String browser)
	{
		initialization(browser);
		flightPage=new FlightPage();
		flightbookingPage=new FlightBookingPage();
	}
	
	@Test(priority=1)
	public void clickFlight()
	{
		flightPage.clickFlight();
	}
	
	@Test(priority=2,dependsOnMethods = "clickFlight")
	public void fillFlightBookingDetails() throws InterruptedException
	{
		flightPage.bookFlightDetails();
	}
	
	@Test(priority=3)
	public void bookFlightDetails()
	{
		flightbookingPage.selectBookingDetails();
	}
	
	@AfterTest()
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(60000);
		driver.close();
	}

}
