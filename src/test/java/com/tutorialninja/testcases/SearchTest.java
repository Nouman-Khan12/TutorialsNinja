package com.tutorialninja.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.base.BaseClass;

public class SearchTest extends BaseClass{
	public WebDriver driver;
	
	public SearchTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driver = initializeWebbrowserandOpeiningURL(property.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void serachWithValidProduct()
	{
		driver.findElement(By.xpath("//div[@id='search']/input")).sendKeys("hp");
		driver.findElement(By.xpath("//div[@id='search']/span/button")).click();
				
	}
	
	@Test(priority=2)
	public void serachWithoutEntring()
	{
		driver.findElement(By.xpath("//div[@id='search']/input")).sendKeys("");
		driver.findElement(By.xpath("//div[@id='search']/span/button")).click();
				
	}

}
