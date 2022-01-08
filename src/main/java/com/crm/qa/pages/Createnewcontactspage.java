package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Createnewcontactspage {
	WebDriver driver;
	
public Createnewcontactspage(WebDriver driver)
{
	this.driver=driver; 
}
	String firstname="//input[@name='first_name']";
	String lastname="//input[@name='last_name']";
	String middlename= "//input[@name='middle_name']"; 
	String company="//div[@name='company']//input[@class='search']";
	String Email="//input[@placeholder='Email address']";
	String address="//input[@name='address']";
	String city="//input[@name='city']";
	String state="//input[@name='state']";
	String save="//button[@class='ui linkedin button']";
	String userlabelcontact="//div[@class='ui header item mb5 light-black']";
	
	public void createnewcontacts()
	{
		WebElement firstname_xpath=driver.findElement(By.xpath(firstname));
		firstname_xpath.sendKeys("lakshmi");
		WebElement lastname_xpath=driver.findElement(By.xpath(lastname));
		lastname_xpath.sendKeys("veldi");
		WebElement middlename_xpath=driver.findElement(By.xpath(middlename));
		middlename_xpath.sendKeys("chowdary");
		WebElement company_xpath=driver.findElement(By.xpath(company));
		company_xpath.sendKeys("Quadrant");
		WebElement Email_xpath=driver.findElement(By.xpath(Email));
		Email_xpath.sendKeys("veldilakshmi1234@gmail.com");
		WebElement address_xpath=driver.findElement(By.xpath(address));
		address_xpath.sendKeys("kodad");
		WebElement city_xpath=driver.findElement(By.xpath(city));
		city_xpath.sendKeys("hyderabad");
		WebElement state_xpath=driver.findElement(By.xpath(state));
		state_xpath.sendKeys("telangana");
	}
		public usercontactlabel contact()
		{
			driver.findElement(By.xpath(save)).click();
			return new usercontactlabel(driver);

		}
		
		
			
		

}
