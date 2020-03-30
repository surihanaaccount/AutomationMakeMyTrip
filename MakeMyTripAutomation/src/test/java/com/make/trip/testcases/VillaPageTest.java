package com.make.trip.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.make.trip.base.TripBase;
import com.make.trip.pages.VillasPage;

public class VillaPageTest extends TripBase {


	VillasPage villasPage;
	
	@BeforeTest()
	@Parameters("browser")
	public void setUp(String browser)
	{
		initialization(browser);
		villasPage=new VillasPage();
	}
	
	@Test(priority=1)
	public void clickVilla()
	{
		villasPage.clickVilla();
	}
	
	@Test(priority=2,dependsOnMethods = "clickVilla")
	public void fillVillaBookingDetails() throws InterruptedException
	{
		villasPage.bookVillaDetails();
	}
	
	@AfterTest()
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(30000);
		//driver.close();
	}
}
