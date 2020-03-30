package com.make.trip.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.make.trip.base.TripBase;
import com.make.trip.pages.CabPage;


public class CabPageTest extends TripBase{


	 CabPage cabpage;
		
		@BeforeTest()
		@Parameters("browser")
		public void setUp(String browser)
		{
			initialization(browser);
			cabpage=new CabPage();
		}
		
		@Test(priority=1)
		public void clickCab()
		{
			cabpage.clickCab();
		}
		
		@Test(priority=2,dependsOnMethods = "clickCab")
		public void fillCabBookingDetails() throws InterruptedException
		{
			cabpage.bookCabDetails();
		}
		
		@AfterTest()
		public void tearDown() throws InterruptedException
		{
			Thread.sleep(30000);
			driver.close();
		}
}
