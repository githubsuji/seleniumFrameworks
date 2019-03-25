package com.calibroz.driver;

import static com.calibroz.driver.DriverConstants.CHROME;
import static com.calibroz.driver.DriverConstants.EDGE;
import static com.calibroz.driver.DriverConstants.FIREFOX;
import static com.calibroz.driver.DriverConstants.IE;
import static com.calibroz.driver.DriverConstants.SAFARI;

import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.calibroz.driver.listener.CalibrozWebDriverEventListener;
import com.calibroz.screenshot.ScreenshotManager;

import io.github.bonigarcia.wdm.WebDriverManager;
public abstract class BaseTest {
	public final static Logger logger = Logger.getLogger(BaseTest.class);
	public long startTime = 0;
	protected WebDriver driver;
	protected CalibrozWebDriverEventListener swdeListener = null;
	private EventFiringWebDriver eventFiredriver;
	protected String testCaseMethodName;
	
	@BeforeTest
	@Parameters({"browser"})
	public static void setupTest(String browser) {
		System.err.println("################"+browser);
		logger.info("BROWSER TYPE - "+ browser);
		switch (browser) {
		case CHROME:
			System.err.println("######################");
			WebDriverManager.chromedriver().clearPreferences();
			//WebDriverManager.chromedriver().setup();
			//https://github.com/bonigarcia/webdrivermanager/issues/318
			WebDriverManager.chromedriver().version("73").setup();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			break;
		case IE:
			WebDriverManager.iedriver().setup();
			break;
		case SAFARI:
			
			break;
		default:
			WebDriverManager.chromedriver().clearPreferences();
			WebDriverManager.chromedriver().setup();
			break;
		}
		
	}
	
	@BeforeClass
	@Parameters({"browser"})
	public void setupClass(String browser) {
		switch (browser) {
		case CHROME:
			driver = DriverManager.getchromeDriver();
			break;
		case FIREFOX:
			driver = DriverManager.getGeckoDriver();
			break;
		case EDGE:
			driver = DriverManager.getEdgeDriver();
			break;
		case IE:
			driver = DriverManager.getIEDriver();
			break;			
		case SAFARI:
			break;
		default:
			driver = DriverManager.getchromeDriver();
			break;
		}
		swdeListener = new  CalibrozWebDriverEventListener(); //Created Webdriver Listener
		// Initializing EventFiringWebDriver using  WebDriver instance
		eventFiredriver = new EventFiringWebDriver(driver);
		eventFiredriver.register(swdeListener); //Registering  Webdriver Listener

		// driver.manage().timeouts().pageLoadTimeout(80000, TimeUnit.MILLISECONDS);
		// driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
	
	@AfterMethod
	public void afterEachTestCase(ITestResult result) {
		logger.error("after test method execution - ");
		logger.error("Total time taken for execution : "+(new Date().getTime() - startTime));
		if(null != testCaseMethodName) {
			result.setAttribute("testCaseName", testCaseMethodName);
		}else {
			result.setAttribute("testCaseName", result.getName());
		}
		ScreenshotManager.triggerScreenshot(driver, result);
	}
	@AfterTest
	public void teardown() {
		logger.info("test teardown - "+ driver);
		if (driver != null) {
			  driver.quit();
		}
	}
	
	protected abstract void setTestCaseMethodName(String testMethodName) ;
	
	 
	

	

}
