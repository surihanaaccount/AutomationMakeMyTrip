package com.make.trip.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.make.trip.base.TripBase;
import com.make.trip.pages.HolidaysPage;


public class HolidaysPageTest extends TripBase{

    HolidaysPage holidayPage;
	
	@BeforeTest()
	@Parameters("browser")
	public void setUp(String browser)
	{
		initialization(browser);
		holidayPage=new HolidaysPage();
	}
	
	@Test(priority=1)
	public void clickHoliday()
	{
		holidayPage.clickHoliday();;
	}
	
	@Test(priority=2,dependsOnMethods = "clickHoliday")
	public void fillHotelBookingDetails() throws InterruptedException
	{
		holidayPage.bookHolidayDetails();
	}
	
	@AfterTest()
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(30000);
		driver.close();
	}
}
