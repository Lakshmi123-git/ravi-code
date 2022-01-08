package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class usercontactlabel {
	WebDriver driver;
	String userlabelcontact="//div[@class='ui header item mb5 light-black']";
	


public usercontactlabel(WebDriver driver)
{
	this.driver=driver;
}

public boolean usercontactdisplay()
{
return	driver.findElement(By.xpath(userlabelcontact)).isDisplayed();
}
}
