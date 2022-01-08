package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginpage {
	WebDriver driver;
	String login="//span[text()='Log In']";
	String email_xpath="//input[@type='text']";
	String password_xpath="//input[@name='password']";
	String loginbutton="//div[text()='Login']";
	String contacts="//span[text()='Contacts']";
	String create="//button[@class='ui linkedin button']//i[@class='edit icon']";
	public Loginpage(WebDriver driver) {
		this.driver=driver;
	} 
	
	public void clicklogin()
	{
	WebElement login_xpath=	driver.findElement(By.xpath(login));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",login_xpath);
		
	}
	public void enteremail(String email)
	{
		driver.findElement(By.xpath(email_xpath)).sendKeys(email);
	}
	public void enterpassword(String password)
{
	driver.findElement(By.xpath(password_xpath)).sendKeys(password);
	}
	public Homepage login()
	{
		driver.findElement(By.xpath(loginbutton)).click();
		return new Homepage(driver);
	}
	
}

