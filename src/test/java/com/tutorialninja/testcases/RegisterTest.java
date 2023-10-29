package com.tutorialninja.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.base.BaseClass;
import com.tutorialninja.utilities.UtilitiesDate;
import com.tutorialsninja.Pages.RegisterPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RegisterTest extends BaseClass{
	public WebDriver driver;
	
	
	public RegisterTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{	
		driver = initializeWebbrowserandOpeiningURL(property.getProperty("browser"));	
		
		RegisterPage register = new RegisterPage(driver);
		register.account();
		driver.findElement(By.xpath("//div[@id='top-links']//a[text()='Register']")).click();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	UtilitiesDate u = new UtilitiesDate();
	
	@Test(priority=1)
	public void verifyRegisterFunctionalitywithManadteryFields()
	{
		RegisterPage register = new RegisterPage(driver);
		
		register.firstName();
		register.lastName();
		register.email();
		register.telephone();
		register.password();
		register.confirmPassword();
		register.newsLater();
		register.agree();
		register.cont();
		
		String actualHeaddingText = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualHeaddingText, "Your Account Has Been Created!");
		
		driver.quit();
		System.out.println("1st");
	}
	
	@Test(priority=2)
	public void verifyRegisterFunctionalitywithAllFields()
	{
		driver.findElement(By.id("input-firstname")).sendKeys("Nouman");
		driver.findElement(By.id("input-lastname")).sendKeys("Khan");
		driver.findElement(By.id("input-email")).sendKeys("nouman"+ u.dateStamp()+"@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("03456756");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.quit();
		System.out.println("2nd");
	}
		
}
