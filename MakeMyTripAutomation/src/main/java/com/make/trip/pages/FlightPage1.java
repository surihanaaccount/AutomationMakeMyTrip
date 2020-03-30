package com.make.trip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.make.trip.base.TripBase;
import com.make.trip.util.Utilities;

public class FlightPage1 extends TripBase{
	
	@FindBy(css=".menu_Flights")
	WebElement flightTab;
	
	@FindBy(css="#fromCity")
	WebElement fromLocation;
	
	@FindBy(css="#toCity")
	WebElement toLocation;
	
	@FindBy(css="#departure")
	WebElement departure;
	
	@FindBy(css="#travellers")
	WebElement travelFor;
	
	@FindBy(css="button[data-cy='travellerApplyBtn']")
	WebElement applyBtn;
	
	@FindBy(css="p[data-cy='submit']>a")
	WebElement searchBtn;
	
	
	
	public FlightPage1()
	{
		PageFactory.initElements(driver, this);
	}
	public void clickFlight()
	{
		Utilities.clickBtn(flightTab);
	}
	public void bookFlightDetails()
	{
		selectFromCity();
		selectToCity();
		selectDeparture(departure,"2020","April", "20", driver);
		selectTravelClass();
		Utilities.clickBtn(searchBtn);
	}
	public void selectTravelClass() {
		
		  Utilities.clickBtn1(travelFor);
		    
		  List<WebElement> options=driver.findElements(By.cssSelector("li[data-cy^='adults']"));
		   
		   for(WebElement option:options)
		   {
			   if("2".equalsIgnoreCase(option.getText()))
			   {
				   option.click();
				   break;
			   }
		   }
		   
		   List<WebElement> options1=driver.findElements(By.cssSelector("li[data-cy^='children']"));
		   
		   for(WebElement option1:options1)
		   {
			   if("2".equalsIgnoreCase(option1.getText()))
			   {
				   option1.click();
				   break;
			   }
		   }
		   
	     List<WebElement> options2=driver.findElements(By.cssSelector("li[data-cy^='infants']"));
		   
		   for(WebElement option2:options2)
		   {
			   if("2".equalsIgnoreCase(option2.getText()))
			   {
				   option2.click();
				   break;
			   }
		   }
		   
		   List<WebElement> options3=driver.findElements(By.cssSelector("li[data-cy^='travelClass']"));
		   
		   for(WebElement option3:options3)
		   {
			   if("First Class".equalsIgnoreCase(option3.getText()))
			   {
				   option3.click();
				   break;
			   }
		   }
		   
		   applyBtn.click();
	}
	private void selectDeparture(WebElement departure, String yearName, String monthName, String day, WebDriver driver) {
		
		Utilities.clickBtn1(departure);
		   
		   String Year=driver.findElement(By.cssSelector("div[class='DayPicker-Caption']>div")).getText();
		   
		   System.out.println("The Year is "+Year);
			
		   String[] split=Year.split(" ");
			
		   String currentYear=split[1];
		   
		   String currentMonth=split[0];
					
			
			System.out.println("The current Year is "+currentYear);
			

			
			if(!currentMonth.equalsIgnoreCase(monthName))
			{
				do
				{
				driver.findElement(By.cssSelector("span[aria-label='Next Month']")).click();
				}
				while(!driver.findElement(By.cssSelector("div[class='DayPicker-Caption']>div")).getText().contains(monthName));
			}
			
			
			List<WebElement> rows=driver.findElements(By.cssSelector("div.DayPicker-Months > div:nth-child(1) > div.DayPicker-Body > div"));
			
			System.out.println("The Count of the rows "+rows.size());
			
			for(int i=1;i<=rows.size();i++)
			{
				List<WebElement> columns=driver.findElements(By.cssSelector("div.DayPicker-Months > div:nth-child(1) > div.DayPicker-Body > div:nth-child("+i+") > div.DayPicker-Day>div>p:nth-child(1)"));
				
				System.out.println(columns.size());
				
				for(int j=0;j<columns.size();j++)
				{
					
					if(columns.get(j).getText().equals(day))
					{
						columns.get(j).click();
						break;
					}
				}
			}
			
			
		
		
	}
	public void selectToCity() {
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", toLocation);
			 
		      List<WebElement> options =driver.findElements(By.cssSelector("p[class='font14 appendBottom5 blackText']"));
				 
				 for(WebElement option: options)
				 {
					 
					 System.out.println(option.getText());
					 
					 if("Mumbai, India".equalsIgnoreCase(option.getText()))
					 {
						 js.executeScript("arguments[0].click();", option);
						 break;
					 }
				 }
			
		
	}
	public void selectFromCity() { 
		
       Utilities.clickBtn1(fromLocation);
			 
		      List<WebElement> options =driver.findElements(By.cssSelector("p[class='font14 appendBottom5 blackText']"));
				 
				 for(WebElement option: options)
				 {
					 if("Delhi, India".equalsIgnoreCase(option.getText()))
					 {
						 option.click();
						 break;
					 }
				 }
		
	}

}
