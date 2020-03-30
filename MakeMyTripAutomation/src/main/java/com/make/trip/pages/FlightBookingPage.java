package com.make.trip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.make.trip.base.TripBase;
import com.make.trip.util.Utilities;

public class FlightBookingPage extends TripBase {
	
	@FindBy(css="a[id='more_filters']")
	WebElement clickMoreFilters;
	
	@FindBy(xpath="//a[text()='Apply']")
	WebElement applyBtn;
	
	
	public FlightBookingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectBookingDetails()
	{
		if(Utilities.isClickable(clickMoreFilters))
		{
		clickMoreFilters.click();
		}
		selectNonstopDetails();
		selectAirLines();
		selectAmountRange();
		Utilities.clickBtn(applyBtn);
		viewAirlineDetails();
	
		
	}
  
	public void selectAmountRange() {
		
		WebElement slider = driver.findElement(By.xpath("//*[@class='rc-slider-handle rc-slider-handle-1']"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 640, 450).release().build().perform();
		slider.click();
	}


	public void viewAirlineDetails() {
		
		int m=0,r=0;
		
		
		
		List<WebElement> airlines=driver.findElements(By.xpath("//*[contains(@id,'fli_list_item')]"));
		System.out.println("The size is "+airlines.size());
		for(int i=2;i<airlines.size();i++)
		{
			
		     WebElement btn=driver.findElement(By.xpath("//*[contains(@id,'fli_list_item')]["+i+"]//*[@class='dept-options-section clearfix']/div[4]/button"));
			 Utilities.clickBtn1(btn);
			 break;
			
		}
		
		
	}

	public void selectAirLines() {
		
      
    	
    	List<WebElement> airlines=driver.findElements(By.xpath("//*[@id='airline_group']//ul/li//label"));
    	
    	for(int i=0;i<airlines.size();i++)
    	{
    		System.out.println("The airlines details"+airlines.get(i).getText());
    		if(airlines.get(i).getText().contains("IndiGo"))
    		{
    			
    			airlines.get(i).click();
    			break;
    		}
    	}
    	
    	
    	
		
	}

	//*[@id="airline_group"]//label/span[2]
	public void selectNonstopDetails() {
		
	
		
		List<WebElement> nonstops=driver.findElements(By.xpath("//*[@id='stop_group']//ul/li//label"));
		
		for(int i=0;i<nonstops.size();i++)
		{
			System.out.println("The Nonstop details "+nonstops.get(i).getText());
			if(nonstops.get(i).getText().contains("Non Stop"))
			{
				nonstops.get(i).click();
				break;
			}
		}
		
		
		
	}
	
	

}
