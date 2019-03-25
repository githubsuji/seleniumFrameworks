package com.logistics.qrpproject.page.landing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.logistics.qrpproject.driver.BaseTest;
import com.logistics.qrpproject.genericcomponents.Browser;

public class LandingPageTest extends BaseTest {

	@Override
	protected void setTestCaseMethodName(String testMethodName) {
		super.testCaseMethodName=testMethodName;
		
	}
	
	@Test
	public void landingPageTestcase() {
		//this.setTestCaseMethodName("landingpagetestcas");
		LandingPageTestSteps.verifyHeader(driver);
     
	}

	@BeforeMethod
	public void setupTestcaseMethod() {
		Browser.launchWebsite("http://104.196.238.29/quickrecycleclientappqc/lets-go/Ecoactiv");

	}
}
