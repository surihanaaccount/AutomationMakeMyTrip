package com.make.trip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.make.trip.base.TripBase;
import com.make.trip.util.Utilities;

public class HolidaysPage extends TripBase{
	
	@FindBy(xpath="//a[@href='https://www.makemytrip.com/holidays-india/']//span[text()='Holidays']")
	WebElement holidayTab;
	
	@FindBy(css="input[id='fromCity']")
	WebElement fromCity;
	
	@FindBy(css="input[id='toCity']")
	WebElement toCity;
	
	@FindBy(css="button[id='search_button']")
	WebElement searchHBtn;
	
	public HolidaysPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickHoliday()
	{
		Utilities.clickBtn(holidayTab);
	}
	
	public void bookHolidayDetails()
	{
		Utilities.selectValue(fromCity, "//*[@role='listbox']//*[@role='option']//p", "Vijaywada");
		Utilities.selectValue1(toCity, "//*[@role='listbox']//*[@role='option']//p", "Kerala");
		Utilities.clickBtn(searchHBtn);
		
	}
	
	

}
