package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	WebDriver driver;
	String contact_xpath="//span[text()='Contacts']";
	public Homepage(WebDriver driver)
	{
	this.driver=driver;	
	}
	public boolean verifycontactslink()
	{
		return driver.findElement(By.xpath(contact_xpath)).isDisplayed();
		
	}
    public void clickcontactslink()
    {
    	driver.findElement(By.xpath(contact_xpath)).click();
    }
}
