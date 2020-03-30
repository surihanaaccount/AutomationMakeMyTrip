package com.make.trip.base;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TripBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TripBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/make/trip/config/config.properties");
			prop.load(ip);
			 
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization(String browser)
	{
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\parveen\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equals("IE"))
		{
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			dc.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			dc.setCapability("nativeEvents", false);    
			dc.setCapability("unexpectedAlertBehaviour", "accept");
			dc.setCapability("ignoreProtectedModeSettings", true);
			dc.setCapability("disable-popup-blocking", true);
			dc.setCapability("enablePersistentHover", true);
			System.setProperty("webdriver.ie.driver", "D:\\Softwares\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver=new InternetExplorerDriver(dc);
			
			Toolkit toolkit=Toolkit.getDefaultToolkit();
			int width=(int)toolkit.getScreenSize().getWidth();
			int height=(int)toolkit.getScreenSize().getHeight();
			
			//For Dimension class, Import following library "org.openqa.selenum.Dimension"
			
			driver.manage().window().setSize(new Dimension(width,height));
			
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

}
