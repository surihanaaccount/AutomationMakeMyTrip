package com.make.trip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.make.trip.base.TripBase;
import com.make.trip.util.Utilities;

public class HotelPage extends TripBase{
	
	@FindBy(xpath="//a[@href='https://www.makemytrip.com/hotels/']//span[text()='Hotels']")
	WebElement hotelTab;
	
	@FindBy(css="input[id='city']")
    WebElement location;
	
	@FindBy(css="input[id='checkin']")
	WebElement checkIn;
	
	@FindBy(css="input[id='checkout']")
	WebElement checkOut;
	
	@FindBy(css="input[id='guest']")
	WebElement roomsguests;
	
	@FindBy(css="button[data-cy='submitGuest']")
	WebElement submitGuest;
	
	@FindBy(css="input[id='travelFor']")
	WebElement travelFor;
	
	public HotelPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickHotel()
	{
		Utilities.clickBtn(hotelTab);
	}
	
	public void bookHotelDetails() throws InterruptedException
	{
		
		//WebDriverWait wait = new WebDriverWait(driver,60);
		//WebElement location=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter city/ Hotel/ Area/ Building']")));
		visiblity(location);
		Utilities.selectValue(location,"//*[@role='listbox']//*[@role='option']//p","Hyderabad");
		selectCheckIn(checkIn,"2020","March", "26", driver);
		selectCheckOut(checkOut,"2020","March", "28", driver);
		selectRooms();
		Utilities.selectValue1(travelFor,"//ul[@class='travelForPopup']/li","Work");
		
		
	}
	
	

	public void selectRooms() {
		
		     WebElement travelToClick=driver.findElement(By.xpath("//*[@id=\"guest\"]"));
		  
			//  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", travelToClick);
			   
			//  travelToClick.click();
			  
			  Actions actions = new Actions(driver);
			  
			  actions.moveToElement(travelToClick).click().perform();
			   
			 
			   
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
			   
		     List<WebElement> options2=driver.findElements(By.xpath("//select[contains(@data-cy,'childAge-0')]//option[contains(@data-cy,'childAgeValue')]"));
			   
			   for(WebElement option2:options2)
			   {
				   if("2".equalsIgnoreCase(option2.getText()))
				   {
					   option2.click();
					   break;
				   }
			   }
			   
			   List<WebElement> options3=driver.findElements(By.xpath("//select[contains(@data-cy,'childAge-1')]//option[contains(@data-cy,'childAgeValue')]"));
			   
			   for(WebElement option3:options3)
			   {
				   if("2".equalsIgnoreCase(option3.getText()))
				   {
					   option3.click();
					   break;
				   }
			   }
			   
			   submitGuest.click();
			   
		
	}

	public void visiblity(WebElement location) throws InterruptedException {
		
		while (!isDisplayed(location)) 
	    {
	        Thread.sleep(30000);
	        System.out.println("Element is not visible yet");
	    }
		
	}

	 public static boolean isDisplayed(WebElement element) {
	        try {
	            if(element.isDisplayed())
	                return element.isDisplayed();
	            }catch (NoSuchElementException ex) {
	            return false;
	        }
	        return false;
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
				List<WebElement> columns=driver.findElements(By.xpath("//*[@class='DayPicker-Month'][1]//*[@class='DayPicker-Week']["+i+"]//*[@class='DayPicker-Day DayPicker-Day--disabled']"));
				
				System.out.println("The column size is"+columns.size());
				
			
				for(WebElement column:columns)
				{
					if(column.getText().equals(day))
					{
						column.click();
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
				List<WebElement> columns=driver.findElements(By.xpath("//*[@class='DayPicker-Month'][1]//*[@class='DayPicker-Week']["+i+"]//*[@class='DayPicker-Day DayPicker-Day--disabled']"));
				
				System.out.println("The columns size"+columns.size());
							
				for(WebElement column:columns)
				{
					if(column.getText().equals(day))
					{
						column.click();
					}
				}
			}
	}

	
	

}
