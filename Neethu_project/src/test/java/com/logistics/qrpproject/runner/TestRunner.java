package com.logistics.qrpproject.runner;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.TestNG;


public class TestRunner {

	
public static final Logger logger = Logger.getLogger(TestRunner.class);	

public static void main(String[] args) {
		
        logger.info("TestRunner Main- Execution Begins");
		List<String> list = new ArrayList<String>();
		list.add("D:\\Selenium\\seleniumFrameworks\\Neethu_project\\src\\test\\resources\\testsuites\\testng.xml");
		System.out.println("number of test suite files executed: " + list.size());
		TestNG tng = new TestNG();
		tng.setTestSuites(list);
		tng.run();
		logger.info("TestRunner Main- Execution Ends");
	

}
}
