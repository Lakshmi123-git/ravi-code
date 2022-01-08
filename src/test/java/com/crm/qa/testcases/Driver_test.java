package com.crm.qa.testcases;

import java.io.IOException;

import org.junit.Test;

import com.crm.qa.base.Test_base;

public class Driver_test {
	
	@Test
	public void initialisation() throws IOException
	{
		Test_base.setupdriver();
		Test_base.closedriver();
	}

}
