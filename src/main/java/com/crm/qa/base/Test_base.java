package com.crm.qa.base;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;  
import com.crm.qa.utility.Utility;

public class Test_base {
	public static WebDriver driver;
	@BeforeClass
	public static void setupdriver() throws IOException
	{
		//System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		 //driver=new ChromeDriver();
		 if(Utility.fetchproperties("Browsername").equalsIgnoreCase("chrome"))
		 {
				ChromeOptions options=new ChromeOptions();
				options.addArguments("enable-automation");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-extensions");
				options.addArguments("--dns-prefetch-disable");
				options.addArguments("--disable-gpu");
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
				System.setProperty("webdriver.chrome.silentOutput","true");
			 System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			 driver=new ChromeDriver(options); 
		 }
	
		 else if(Utility.fetchproperties("Browsername").equalsIgnoreCase("firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", "Drivers\\chromedriver.exe");
			 driver=new FirefoxDriver();
			 
		 }
		 else if(Utility.fetchproperties("Browsername").equalsIgnoreCase("IE"))
		 {
			 System.setProperty("webdriver.IE.driver", "Drivers\\chromedriver.exe");
			 driver=new InternetExplorerDriver();
			 
		 }
		 else {	
				 System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
				 driver=new ChromeDriver();
				 
			 }
		 driver.get(Utility.fetchproperties("ApplicationUrl"));
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	 
	}
	@AfterClass
	public static void closedriver()
	{
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.quit();
	}

}
