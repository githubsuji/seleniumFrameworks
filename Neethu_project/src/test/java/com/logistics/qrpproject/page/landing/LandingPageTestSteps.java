package com.logistics.qrpproject.page.landing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

public class LandingPageTestSteps{

	public static void verifyHeader(WebDriver driver) {
		// TODO Auto-generated method stub
		String actualHeader = LandingPageTestUtil.getHeader(driver);
		String expectedHeaderPart = "Finished with it? Let's get started";
		assertEquals(actualHeader.concat(expectedHeaderPart), true,"Successful for the header");
		
		
	}

}
