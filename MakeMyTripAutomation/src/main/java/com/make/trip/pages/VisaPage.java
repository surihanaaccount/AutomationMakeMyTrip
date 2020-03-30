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

public class VisaPage extends TripBase{

	@FindBy(xpath="//a[@href='https://www.makemytrip.com/visa/']//span[text()='Visa']")
	WebElement cabTab;
	
	@FindBy(css="input[id='fromCountryCode']")
	WebElement fromCity;
	
	@FindBy(css="input[id='departure']")
	WebElement departureDate;
	
	@FindBy(css="input[id='return']")
	WebElement returnDate;
	
	@FindBy(css="input[id='travellers']")
    WebElement travellerCount;
	
	@FindBy(css="span[class='btnPlus']")
	WebElement plusBtn;
	
	@FindBy(css="span[class='btnMinus ']")
	WebElement minusBtn;
	
	@FindBy(xpath="//button[text()='APPLY']")
	WebElement travellerApply;
	
	@FindBy(css="button[id='search_button']")
	WebElement searchVisaBtn;
	
	
	public VisaPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickVisa()
	{
		Utilities.clickBtn(cabTab);
	}
	
	public void bookVisaDetails()
	{
		Utilities.selectValue(fromCity, "//*[@role='listbox']//*[@role='option']//p", "Australia");
		selectDepartureDate(departureDate,"2020","May", "26", driver);
		selectReturnDate(returnDate,"2020","May", "28", driver);
		selectTravelCount(travellerCount);
		Utilities.clickBtn1(searchVisaBtn);
		
	}
	
	public void selectReturnDate(WebElement checkIn, String year, String month, String day, WebDriver driver)
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

	public void selectDepartureDate(WebElement checkIn, String year, String month, String day, WebDriver driver)
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

	public void selectTravelCount(WebElement travellerCount) {
		// TODO Auto-generated method stub
		//Utilities.clickBtn1(travellerCount);
		Actions actions = new Actions(driver);
		  
		 actions.moveToElement(travellerCount).click().perform();
		 
		WebElement count=driver.findElement(By.cssSelector("span[class='latoBold font22 darkGreyText']"));
		System.out.println("Count is "+count.getText());
		if(!count.getText().equals("3"))
		{
		do{
			plusBtn.click();
		 }
		while(!count.getText().equals("3"));
			}
		Utilities.clickBtn(travellerApply);
		}
		
		
	
}
