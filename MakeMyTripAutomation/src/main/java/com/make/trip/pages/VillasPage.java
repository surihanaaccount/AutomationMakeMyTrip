package com.make.trip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.make.trip.base.TripBase;
import com.make.trip.util.Utilities;

public class VillasPage extends TripBase{
	
	@FindBy(xpath="//a[@href='https://www.makemytrip.com/homestays/']//span[text()='Villas & Apts']")
	WebElement cabTab;
	
	@FindBy(css="input[id='city']")
	WebElement fromCity;
	
	@FindBy(css="input[id='checkin']")
	WebElement checkIn;
	
	@FindBy(css="input[id='checkout']")
	WebElement checkOut;
	
	@FindBy(css="input[id='guest']")
	WebElement guest;
	
	@FindBy(xpath="//button[text()='APPLY']")
	WebElement guestApply;
	
	@FindBy(css="input[id='travelFor']")
	WebElement travelFor;
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement searchBtn;
	
	public VillasPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickVilla()
	{
		Utilities.clickBtn(cabTab);
	}
	
	public void bookVillaDetails()
	{
		Utilities.selectValue(fromCity,"//*[@role='listbox']//*[@role='option']//p[1]","Delhi");
		selectCheckIn(checkIn,"2020","March", "26", driver);
		selectCheckOut(checkOut,"2020","March", "28", driver);
		selectGuests();
		Utilities.selectValue1(travelFor,"//ul[@class='travelForPopup']/li","Work");
		Utilities.clickBtn(searchBtn);
	}
	
	public void selectGuests() {
		
		Utilities.clickBtn1(guest);
		List<WebElement> options=driver.findElements(By.xpath("//li[contains(@data-cy,'adults')]"));
		   
		   for(WebElement option:options)
		   {
			   if("2".equalsIgnoreCase(option.getText()))
			   {
				   option.click();
				   break;
			   }
		   }
		   
		   List<WebElement> options1=driver.findElements(By.xpath("//li[contains(@data-cy,'children')]"));
		   
		   for(WebElement option1:options1)
		   {
			   if("2".equalsIgnoreCase(option1.getText()))
			   {
				   option1.click();
				   break;
			   }
		   }
		
	}

	private void selectCheckOut(WebElement checkOut, String year, String month, String day, WebDriver driver) {
		
		 String monghYear=driver.findElement(By.xpath("//*[@class='DayPicker-Caption']/div")).getText();
			
		 System.out.println("The current Year is "+monghYear);
			

			
			if(!monghYear.contains(month))
			{
				do
				{
				driver.findElement(By.xpath("//*[@aria-label='Next Month']")).click();
				}
				while(!driver.findElement(By.xpath("//*[@class='DayPicker-Caption']/div")).getText().contains(month));
			}
			
			
			List<WebElement> daysRows=driver.findElements(By.xpath("//*[@class='DayPicker-Month'][1]//*[@class='DayPicker-Week']"));
			
			System.out.println(daysRows.size());
			
			for(int i=0;i<daysRows.size();i++)
			{
				List<WebElement> columns=driver.findElements(By.xpath("//*[@class='DayPicker-Month'][1]//*[@class='DayPicker-Week']["+i+"]//*[contains(@class,'DayPicker-Day')]"));
				
				System.out.println("The column size is"+columns.size());
				
			
				for(WebElement column:columns)
				{
					if(column.getText().equals(day))
					{
						column.click();
						break;
					}
				}
			}
		
	}

	public void selectCheckIn(WebElement checkIn, String year, String month, String day, WebDriver driver)
	{
		 String monghYear=driver.findElement(By.xpath("//*[@class='DayPicker-Caption']/div")).getText();
		 
		 System.out.println("The month year is"+monghYear);
			
			
			if(!monghYear.contains(month))
			{
				do
				{
				driver.findElement(By.xpath("//*[@aria-label='Next Month']")).click();
				}
				while(!driver.findElement(By.xpath("//*[@class='DayPicker-Caption']/div")).getText().contains(month));
			}
			
			
			List<WebElement> daysRows=driver.findElements(By.xpath("//*[@class='DayPicker-Month'][1]//*[@class='DayPicker-Week']"));
			
			System.out.println(daysRows.size());
			
			for(int i=0;i<daysRows.size();i++)
			{
				List<WebElement> columns=driver.findElements(By.xpath("//*[@class='DayPicker-Month'][1]//*[@class='DayPicker-Week']["+i+"]//*[contains(@class,'DayPicker-Day')]"));
				
				System.out.println("The columns size"+columns.size());
							
				for(WebElement column:columns)
				{
					if(column.getText().equals(day))
					{
						column.click();
						break;
					}
				}
			}
	}

}
