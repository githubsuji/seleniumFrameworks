package com.logistics.qrpproject.screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class ScreenshotManager {
	public final static Logger logger = Logger.getLogger(ScreenshotManager.class);
	public static void triggerScreenshot(WebDriver driver,ITestResult result) {
		logger.info("from teardown method " + result.getName());
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {

				// Do something here
				logger.info(result.getName() +"passed **********");
			}

			else if (result.getStatus() == ITestResult.FAILURE) {
				// Do something here
				logger.info(result.getName() +"failed **********");
				logger.error(result.getName() +"failed **********");
				String testCaseName = (String) result.getAttribute("testCaseName");
				captureScreenShot(testCaseName,"F:\\Selenium\\screenshots",driver);
			}

			else if (result.getStatus() == ITestResult.SKIP) {
				logger.info(result.getName() +"skipped **********");
				logger.warn(result.getName() +"skipped **********");
				

			}
		} catch (Exception e) {
			logger.error("Exception happened in Teardown method (@AfterMethod)  of base Test", e);
		}
	}
	public static void captureScreenShot(String filename, String filepath, WebDriver driver) {

		logger.info("Screenshot is captured in the folder");
		File directory = new File(filepath);
		logger.info("Checking for directory" + filepath);
		if (!directory.exists()) {
			directory.mkdir();
			logger.info("directory created succussfully");
		}

		logger.info("Directory available for writing screenshot");
		File screenshotTargetFile = new File(directory + "/" + filename

				+ ".png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotsrcfile = ts.getScreenshotAs

		(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotsrcfile,

					screenshotTargetFile);
			logger.info("Screenshot is succussfully copied into corresponding target location");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
