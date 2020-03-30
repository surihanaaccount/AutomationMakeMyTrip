package com.make.trip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.make.trip.base.TripBase;
import com.make.trip.util.Utilities;

public class BusPage extends TripBase{
	
	@FindBy(xpath="//a[@href='https://www.makemytrip.com/bus-tickets/']//span[text()='Buses']")
	WebElement busTab;
	
	@FindBy(css="input[id='fromCity']")
	WebElement fromCity;
	
	@FindBy(css="input[id='toCity']")
	WebElement toCity;
	
	@FindBy(css="input[id='travelDate']")
	WebElement travelDate;
	
	@FindBy(css="button[id='search_button']")
	WebElement submitBusBtn;
	
	public BusPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickBus()
	{
		Utilities.clickBtn(busTab);
	}
	
	public void bookBusDetails()
	{
		Utilities.selectValue(fromCity, "//*[@role='listbox']//*[@role='option']//p", "Mumbai, Maharashtra");
		Utilities.selectValue1(toCity, "//*[@role='listbox']//*[@role='option']//p", "Hyderabad, Telangana");
		selectBusDate(travelDate,"2020","March", "26", driver);
		Utilities.clickBtn1(submitBusBtn);
		
	}

	public void selectBusDate(WebElement travelDate, String year, String month, String day,
			WebDriver driver) {
	
		  Actions actions = new Actions(driver);
		  
		  actions.moveToElement(travelDate).click().perform();
		   
		   String Year=driver.findElement(By.xpath("//*[@class='DayPicker-Caption']/div")).getText();
			
		   String[] split=Year.split(" ");
			
		   String currentYear=split[1];
		   
		   String currentMonth=split[0];
					
			
			System.out.println("The current Year is "+currentYear);
			

			
			if(!currentMonth.equalsIgnoreCase(month))
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
				List<WebElement> rows=driver.findElements(By.xpath("//*[@class='DayPicker-Month'][1]//*[@class='DayPicker-Week']["+i+"]//*[@class='DayPicker-Day DayPicker-Day--disabled']"));
				
				System.out.println(rows.size());
				
				for(int j=0;j<rows.size();j++)
				{
					System.out.println(rows.get(j).getText());
					if(rows.get(j).getText().equals(day))
					{
						rows.get(j).click();
						break;
					}
				}
			}
		
	}

}
