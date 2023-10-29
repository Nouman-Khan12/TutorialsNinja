package com.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialninja.utilities.UtilitiesDate;

public class RegisterPage {
	WebDriver driver;
	UtilitiesDate u = new UtilitiesDate();

	//object
	@FindBy(xpath="//span[text()='My Account']")
	WebElement account;
	
	//verifyRegisterFunctionalitywithManadteryFields
	@FindBy(id="input-firstname")
	WebElement firstName;
	@FindBy(id="input-lastname")
	WebElement lastName;
	@FindBy(id="input-email")
	WebElement email;
	@FindBy(id="input-telephone")
	WebElement telephone;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(id="input-confirm")
	WebElement confirmPassword;
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	WebElement newsLater;
	@FindBy(xpath="//input[@name='agree']")
	WebElement agree;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement cont;
	//constructor
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public void account()
	{
		account.click();
	}
	
	//verifyRegisterFunctionalitywithManadteryFields actions
	public void firstName()
	{
		firstName.sendKeys("Nouman");
	}
	public void lastName()
	{
		lastName.sendKeys("Khan");
	}
	public void email()
	{
		email.sendKeys("nouman"+ u.dateStamp()+"@gmail.com");
	}
	public void telephone()
	{
		telephone.sendKeys("03456756");
	}
	public void password()
	{
		password.sendKeys("123456");
	}
	public void confirmPassword()
	{
		confirmPassword.sendKeys("123456");
	}
	public void newsLater()
	{
		newsLater.click();
	}
	public void agree()
	{
		agree.click();
	}
	public void cont()
	{
		cont.click();
	}
	
	
}
