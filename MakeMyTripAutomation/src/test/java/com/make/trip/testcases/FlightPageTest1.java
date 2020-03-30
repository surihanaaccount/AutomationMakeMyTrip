package com.make.trip.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.make.trip.base.TripBase;
import com.make.trip.pages.FlightPage1;

public class FlightPageTest1 extends TripBase{
	FlightPage1 flightPage1;
	//FlightBookingPage flightbookingPage;
	
	@BeforeTest()
	@Parameters("browser")
	public void setUp(String browser)
	{
		initialization(browser);
		flightPage1=new FlightPage1();
		//flightbookingPage=new FlightBookingPage();
	}
	
	@Test
	public void clickFlight()
	{
		flightPage1.clickFlight();
		
	}
	
	@Test(dependsOnMethods = "clickFlight")
	public void fillFlightBookingDetails() throws InterruptedException
	{
		flightPage1.bookFlightDetails();
	}
	
	@Test(enabled=false)
	public void bookFlightDetails()
	{
		//flightbookingPage.selectBookingDetails();
	}
	
	@AfterTest()
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(60000);
		driver.close();
	}

}
