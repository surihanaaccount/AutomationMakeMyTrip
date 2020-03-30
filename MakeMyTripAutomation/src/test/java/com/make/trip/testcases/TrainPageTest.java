package com.make.trip.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.make.trip.base.TripBase;
import com.make.trip.pages.TrainPage;

public class TrainPageTest extends TripBase{

	 TrainPage trainPage;
		
		@BeforeTest()
		@Parameters("browser")
		public void setUp(String browser)
		{
			initialization(browser);
			trainPage=new TrainPage();
		}
		
		@Test(priority=1)
		public void clickTrain()
		{
			trainPage.clickTrain();
		}
		
		@Test(priority=2,dependsOnMethods = "clickTrain")
		public void fillTrainBookingDetails() throws InterruptedException
		{
			trainPage.bookTrainDetails();
		}
		
		@AfterTest()
		public void tearDown() throws InterruptedException
		{
			Thread.sleep(30000);
			driver.close();
		}
}
