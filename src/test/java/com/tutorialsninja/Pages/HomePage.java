package com.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropDownMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	//constructor
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void accountDropDown()
	{
		myAccountDropDownMenu.click();
	}
	public void LoginClick()
	{
		loginOption.click();
	}

}
