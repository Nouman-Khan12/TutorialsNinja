package com.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	//objects
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passWord;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement button;
	
	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void username(String email)
	{
		userName.sendKeys(email);
	}
	
	public void password(String pass)
	{
		passWord.sendKeys(pass);
	}
	
	public void clickBtn()
	{
		button.click();
	}
	
	
	
	
	

}
