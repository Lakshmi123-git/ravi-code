package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class contactspage {
	
	WebDriver driver;
	String contactscreate="//div[text()='Create New Contact']";

	public contactspage(WebDriver driver) {
		this.driver=driver;
	}
	public boolean contactsdisplay()
	{
		return driver.findElement(By.xpath(contactscreate)).isDisplayed();
	}
	public void clickcontactscreate()
	{
		driver.findElement(By.xpath(contactscreate)).click();
	}
	
}
