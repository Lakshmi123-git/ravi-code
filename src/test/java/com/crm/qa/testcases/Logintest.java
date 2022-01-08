package com.crm.qa.testcases;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Test_base;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.utility.xlsx_reader;

public class Logintest extends Test_base
{

	Loginpage lpage=new Loginpage(driver);
	Homepage hpage;
    @Test(dataProvider="excel")
	public void loginfunctionality(String email,String password)
	{
		lpage.clicklogin();
		lpage.enteremail(email);
		lpage.enterpassword(password);
		hpage=lpage.login();
		boolean result=hpage.verifycontactslink();
		
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
