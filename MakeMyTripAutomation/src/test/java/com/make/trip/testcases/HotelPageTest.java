package com.make.trip.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.make.trip.base.TripBase;
import com.make.trip.pages.HotelPage;

public class HotelPageTest extends TripBase{
	
	HotelPage hotelPage;
	
	@BeforeTest()
	@Parameters("browser")
	public void setUp(String browser)
	{
		initialization(browser);
		hotelPage=new HotelPage();
	}
	
	@Test(priority=1)
	public void clickHotel()
	{
		hotelPage.clickHotel();
	}
	
	@Test(priority=2,dependsOnMethods = "clickHotel")
	public void fillFlightBookingDetails() throws InterruptedException
	{
		hotelPage.bookHotelDetails();
	}
	
	@AfterTest()
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(30000);
		driver.close();
	}
	
	

}
