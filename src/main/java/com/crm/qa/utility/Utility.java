package com.crm.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {
      public static String fetchproperties(String key) throws IOException
      {
    	  FileInputStream f=new FileInputStream("config\\config.properties");
    	  Properties prop=new Properties();
    	  prop.load(f);
    	  return prop.get(key).toString();
    	  
      }
}
