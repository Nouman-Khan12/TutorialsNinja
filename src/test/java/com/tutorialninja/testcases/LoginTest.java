package com.tutorialninja.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.base.BaseClass;
import com.tutorialninja.utilities.UtilitiesDate;
import com.tutorialsninja.Pages.AccountPage;
import com.tutorialsninja.Pages.HomePage;
import com.tutorialsninja.Pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginTest extends BaseClass{
	public WebDriver driver ;
	
	UtilitiesDate u = new UtilitiesDate();
	
	public LoginTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		driver = initializeWebbrowserandOpeiningURL(property.getProperty("browser"));
		
		HomePage login = new HomePage(driver);
		login.accountDropDown();
		login.LoginClick();
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1, dataProvider="dataSupplier")
	public void verifyLoginWithValidCreditionals(String userName, String password)
	{
		LoginPage login = new LoginPage(driver);
		
		login.username(userName);
		login.password(password);
		login.clickBtn();

		
		System.out.println("yes");
		
		AccountPage acc = new AccountPage(driver);
		
		Assert.assertTrue(acc.accountInfo());
	}
	
	@DataProvider(name="dataSupplier")
	public Object[][] supplyValidData()
	{
		Object[][] data = UtilitiesDate.getTestDatafromExcel("Login");
				return data;
	}
	
	@Test(priority=2)
	public void verifyLoginWithWrongCreditionals()
	{
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("noumankhan@gmail"+u.dateStamp()+".com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Noum@n");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		
		String actualText = driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedResult = "Warning: No match for E-Mail Address and/or Password.";
		
		Assert.assertTrue(actualText.contains(expectedResult));
	}
	
	

}
