package com.make.trip.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.make.trip.base.TripBase;
import com.make.trip.util.Utilities;

public class FlightPage extends TripBase {
	
	@FindBy(xpath="//*[@id=\"SW\"]/div[2]/div[2]/div/div/nav/ul/li[1]/a/span[1]")
	WebElement flightTab;
	
	@FindBy(xpath="//*[text()='From']")
	WebElement fromLocation;
	
	@FindBy(xpath="//*[text()='To']")
	WebElement toLocation;
	
	@FindBy(xpath="//label[@for='departure']/span")
	WebElement departure;
	
	@FindBy(css="input[data-cy='travellers']")
	WebElement guests;
	
	
	@FindBy(css="input[id='travellers']")
	WebElement travelFor;
	
	@FindBy(xpath="//button[text()='APPLY']")
	WebElement applyBtn;
	
	@FindBy(xpath="//*[text()='Search']")
	WebElement searchBtn;
	
	
	
	public FlightPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlight()
	{
		flightTab.click();
	}
	
	public void bookFlightDetails() throws InterruptedException
	{
		selectTrip();
		selectFromLocation();
		selectToLocation();
		selectCheckIn(departure,"2020","April", "20", driver);
		//selectGuestsAndRoom(guests);
		selectTravelFor();
		selectFare();
		//searchSpecialOffers();
		//checkMakeMyTripLinks();
	    Utilities.clickBtn1(searchBtn);
		
		
	}
	


	
   public void checkMakeMyTripLinks() {
		// TODO Auto-generated method stub
	   boolean flag = false;
	   List<String> actMyLinks=new ArrayList<String>();
	   List<String> expmylink=new ArrayList<String>();
	   expmylink.add("About Us");
	   expmylink.add("Investor Relations");
	   expmylink.add("Testimonial");
	   expmylink.add("Reviews");
	   expmylink.add("Careers");
	   expmylink.add("Corporate Travel");
	   expmylink.add("Travel Guide");
	   expmylink.add("Travel Blog");
	   expmylink.add("Offers");
	   expmylink.add("Gift Vouchers");
	   expmylink.add("MakeMyTrip Coupons");
	   expmylink.add("My Trip Essentials");
	   expmylink.add("Deals");
	   expmylink.add("Stories");
	   expmylink.add("Trip Planner");
	   expmylink.add("MMT Foundation");
	   expmylink.add("CSR Policy");
	   expmylink.add("Travel Community");
	   
	   List<WebElement> actLinks=driver.findElements(By.xpath("//ul[2]/li//a[@class='darkGreyText']"));
	   for(WebElement actLink:actLinks)
	   {
		   actMyLinks.add(actLink.getText());
	   }
	   
	   for(String expectlink:expmylink)
		{
			if(actMyLinks.contains(expectlink))
			{
				flag=true;
				break;
			}
			else
			{
				flag=false;
				break;
			}
		}
	   
	   if(flag)
	   {
		   for(WebElement actLink:actLinks)
		   {
			   Actions action=new Actions(driver);
			   action.contextClick(actLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		   }
	   }
	   
	   
	   
		
	}

public void searchSpecialOffers() {
	
	   List<WebElement> offers=driver.findElements(By.xpath("//ul[@data-cy='SuperOffers']/li"));
	   for(WebElement offer:offers)
	   {
		   if(!offer.getText().equals("MORE"))
		   {
			   System.out.println("The offer is "+offer.getText());
		       offer.click();
		   }
		   else if(offer.getText().contains("MORE"))
		   {
			   offer.click();
			   
			   List<WebElement> moreOffers=driver.findElements(By.xpath("//*[@id='moreOpt']/p"));
			   for(WebElement moreOffer:moreOffers)
			   {
				   if(moreOffer.getText().equals("Bus"))
				   {
					   System.out.println("The more offer is "+moreOffer.getText());
					   Utilities.clickBtn1(moreOffer);
					   break;
				   }
			   }
			   
		   }
	   }
		
	}

public void selectFare() {
		// TODO Auto-generated method stub
	   
	   List<WebElement> fares=driver.findElements(By.xpath("//*[@class='specialFare']/li"));
	   
	   for(WebElement fare:fares)
	   {
		   if("Regular Fare".equalsIgnoreCase(fare.getText()))
		   {
			   fare.click();
		   }
	   }
	   
	   
		
	}

public void selectTrip() {
		// TODO Auto-generated method stub
	   
	   List<WebElement> trips=driver.findElements(By.xpath("//*[@class='makeFlex']/ul/li/span"));
	   
	   for(WebElement trip:trips)
	   {
		   if("Oneway".equalsIgnoreCase(trip.getText()))
		   {
			   trip.click();
		   }
	   }
		
	}

public void selectTravelFor() throws InterruptedException {
	   
	  WebElement travelToClick=driver.findElement(By.xpath("//*[@id=\"travellers\"]"));
	  
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
	   
     List<WebElement> options2=driver.findElements(By.xpath("//li[contains(@data-cy,'infants')]"));
	   
	   for(WebElement option2:options2)
	   {
		   if("2".equalsIgnoreCase(option2.getText()))
		   {
			   option2.click();
			   break;
		   }
	   }
	   
	   List<WebElement> options3=driver.findElements(By.xpath("//*[contains(@data-cy,'travelClass')]"));
	   
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
	   
	  
		
	

public boolean isClickable(WebElement webe) {
	 try
	    {
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.elementToBeClickable(webe));
	        return true;
	    }
	    catch (Exception e)
	    {
	        return false;
	    }
	
}

public void selectGuestsAndRoom(WebElement guests) {
		
	guests.click();
	   
	   List<WebElement> options=driver.findElements(By.xpath("//*[@class='travelForPopup']//li"));
	   
	   for(WebElement option:options)
	   {
		   if("Work".equalsIgnoreCase(option.getText()))
		   {
			   option.click();
			   break;
		   }
	   }
   }

public void selectCheckIn(WebElement departure2, String yearName, String monthName, String day,
			WebDriver driver) {
	   
	   departure.click();
	   
	   String Year=driver.findElement(By.xpath("//*[@class='DayPicker-Caption']/div")).getText();
		
	   String[] split=Year.split(" ");
		
	   String currentYear=split[1];
	   
	   String currentMonth=split[0];
				
		
		System.out.println("The current Year is "+currentYear);
		

		
		if(!currentMonth.equalsIgnoreCase(monthName))
		{
			do
			{
			driver.findElement(By.xpath("//*[@aria-label='Next Month']")).click();
			}
			while(!driver.findElement(By.xpath("//*[@class='DayPicker-Caption']/div")).getText().contains(monthName));
		}
		
		
		List<WebElement> daysRows=driver.findElements(By.xpath("//*[@class='DayPicker-Month'][1]//*[@class='DayPicker-Week']"));
		
		System.out.println(daysRows.size());
		
		for(int i=0;i<daysRows.size();i++)
		{
			List<WebElement> rows=driver.findElements(By.xpath("//*[@class='DayPicker-Month'][1]//*[@class='DayPicker-Week']["+i+"]//*[@class='dateInnerCell']/p"));
			
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

public void selectFromLocation() {

		
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	js.executeScript("arguments[0].click();", fromLocation);
		 
	      List<WebElement> options =driver.findElements(By.xpath("//*[@role='listbox']//*[@role='option']//p"));
			 
			 for(WebElement option: options)
			 {
				 if("Delhi, India".equalsIgnoreCase(option.getText()))
				 {
					 js.executeScript("arguments[0].click();", option);
					 break;
				 }
			 }
		
	}

public void selectToLocation() throws InterruptedException
{
	
	
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	js.executeScript("arguments[0].click();", toLocation);
	
	try {
		
	 List<WebElement> options =driver.findElements(By.xpath("//*[@role='listbox']//*[@role='option']//p"));
	 
	 for(WebElement option: options)
	 {
		 if("Mumbai, India".equalsIgnoreCase(option.getText()))
		 {
		
			 js.executeScript("arguments[0].click();", option);
			 break;
			 
		 }
	 }
	}
	 catch(org.openqa.selenium.StaleElementReferenceException ex)
	 {
		 List<WebElement> options =driver.findElements(By.xpath("//*[@role='listbox']//*[@role='option']//p"));
		 
		 for(WebElement option: options)
		 {
			 if("Mumbai, India".equalsIgnoreCase(option.getText()))
			 {
			
				 js.executeScript("arguments[0].click();", option);
				 break;
				 
			 }
		 }
	 }

}

}
