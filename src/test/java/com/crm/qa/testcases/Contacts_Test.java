package com.crm.qa.testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Test_base;
import com.crm.qa.pages.Createnewcontactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.contactspage;
import com.crm.qa.utility.xlsx_reader;

public class Contacts_Test extends Test_base{

	Loginpage lpage=new Loginpage(driver);
	Homepage hpage;
	contactspage cpage=new contactspage(driver);
	Createnewcontactspage newpage=new Createnewcontactspage(driver);
	//WebDriver driver;
	@Test (dataProvider="excel")
	public void loginfunctionality(String email,String password)
	{
		lpage.clicklogin();
		lpage.enteremail(email);
		lpage.enterpassword(password);
		hpage=lpage.login();
		cpage.contactsdisplay();
		cpage.clickcontactscreate();
		newpage.contact();
		newpage.createnewcontacts();
		Assert.assertTrue(cpage.contactsdisplay());
		
		Assert.assertTrue(hpage.verifycontactslink());

		
	}
	
	@Test(dependsOnMethods="loginfunctionality")
	public void verifycontactslabel()throws Exception
	{
		contactspage cpage=new contactspage(driver);
		boolean result=	cpage.contactsdisplay();
		Assert.assertTrue(result);
		
	}
	
	
	@DataProvider(name="excel")
	public Object[][] testdatagenerator()
	{
		xlsx_reader xl=new xlsx_reader("Testdata\\testdata.xlsx");
		int rowcount=xl.rowcount("Sheet1");
		
		Object [][]testdata =new Object[rowcount-1][2];
		for(int i=2;i<=rowcount;i++) {
			String email=xl.getcelldata("Sheet1", i, "email");
			String password=xl.getcelldata("Sheet1", i, "password");
			testdata[i-2][0]=email;
			testdata[i-2][1]=password;
			
		}
		return testdata;
		
	}

	

}
