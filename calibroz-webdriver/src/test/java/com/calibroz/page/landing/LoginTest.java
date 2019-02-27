package com.calibroz.page.landing;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.calibroz.driver.BaseTest;
import com.calibroz.driver.WebElementManager;


public class LoginTest extends BaseTest {
	public final static Logger logger = Logger.getLogger(LoginTest.class);

	@BeforeMethod
	public void beforeEachTestCase() {
		driver.get("http://automationpractice.com/index.php");

	}

	@Test
	public void testCase() {
		setTestCaseMethodName("testcaseOne");
		// WebElement ele = WebElementManager.getElementByXpathAfterFWait(driver, 5000, 3, "xpath");
	}
	@Override
	public void setTestCaseMethodName(String testMethodName) {
		super.testCaseMethodName = testMethodName;
	}
}
