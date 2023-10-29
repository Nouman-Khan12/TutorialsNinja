package com.tutorialninja.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	WebDriver driver;
	public Properties property;
	
	public BaseClass()
	{
		property = new Properties();
		File file = new File("C:\\Users\\PUNJAB\\eclipse-workspace\\TutorialNinjaAutomation\\src\\main\\java\\com\\tutorianlNinja\\configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			property.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public WebDriver initializeWebbrowserandOpeiningURL(String browserName)
	{
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.get(property.getProperty("url"));
		return driver;
	}

}
