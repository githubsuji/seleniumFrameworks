package com.calibroz.app.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.TestNG;

public class CalibrozTestRunner {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("D:\\Selenium\\seleniumFrameworks\\calibroz-webdriver\\src\\test\\resources\\development-suite.xml");
		TestNG testRunner =  new TestNG();
		testRunner.setTestSuites(list);
		testRunner.run();

	}
	public static File[] getXMLFiles(File folder) {
	    List<File> aList = new ArrayList<File>();

	    File[] files = folder.listFiles();
	    for (File pf : files) {

	      if (pf.isFile() && getFileExtensionName(pf).indexOf("xml") != -1) {
	        aList.add(pf);
	      }
	    }
	    return aList.toArray(new File[aList.size()]);
	  }

	  public static String getFileExtensionName(File f) {
	    if (f.getName().indexOf(".") == -1) {
	      return "";
	    } else {
	      return f.getName().substring(f.getName().length() - 3, f.getName().length());
	    }
	  }
	  public void loadConfigProperties() throws IOException {
		    Properties prop = new Properties();
		    InputStream input = null;
		 
		    try {
		        input = new FileInputStream("src/main/resources/config.properties");
		         
		        // load the properties file
		        prop.load(input);
		 
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    } finally {
		        if (input != null) {
		            try {
		                input.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		    System.setProperties(prop);
		}
}
