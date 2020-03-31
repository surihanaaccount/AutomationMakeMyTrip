package com.make.trip.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.make.trip.base.TripBase;

public class Utilities extends TripBase {
	

   

	public static void clickBtn(WebElement element)
	{
		element.click();
	}
	
	public static void clickBtn1(WebElement element)
	{
		 Actions actions = new Actions(driver);
		  
		 actions.moveToElement(element).click().perform();
	}
	 public static void selectValue(WebElement element,String FindBy, String comparisionVal)
	 {
		 
		 element.click();
		 
		 List<WebElement> options =driver.findElements(By.xpath(FindBy));
		 
		 for(WebElement option: options)
		 {
			 if(comparisionVal.equals(option.getText()))
			 {
				 option.click();
				 break;
			 }
		 }
		 
	 }
	 
	 public static void selectValue1(WebElement element,String FindBy, String comparisionVal)
	 {
		 
		 
		  Actions actions = new Actions(driver);
		  
		  actions.moveToElement(element).click().perform();
		  
		 
		 List<WebElement> options =driver.findElements(By.xpath(FindBy));
		 
		 for(WebElement option: options)
		 {
			 if(comparisionVal.equals(option.getText()))
			 {
				 option.click();
				 break;
			 }
		 }
		 
	 }
	 
	 public static boolean isClickable(WebElement webe)      
		{
		    try
		    {
		        WebDriverWait wait = new WebDriverWait(driver, 30);
		        wait.until(ExpectedConditions.elementToBeClickable(webe));
		        System.out.println("The webElement is clickable");
		        return true;
		    }
		    catch (Exception e)
		    {
		        return false;
		    }
		}
	 
     public static String getCurrentTimeStamp() {
		 
		 SimpleDateFormat sdfDate=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss.SSS");
		 Date now=new Date();
		 String strDate=sdfDate.format(now);
		 return strDate;
		 
			
	 }
     
    
	
}
