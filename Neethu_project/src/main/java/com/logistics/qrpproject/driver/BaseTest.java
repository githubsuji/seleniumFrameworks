package com.logistics.qrpproject.driver;

import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.logistics.qrpproject.listners.WebDriverEventListner;
import com.logistics.qrpproject.screenshots.ScreenshotManager;
import com.logistics.qrpproject.threadlocal.QrpAppContext;
import com.logistics.qrpproject.threadlocal.QrpThreadLocal;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {

	public static final Logger logger = Logger.getLogger(BaseTest.class);

	protected WebDriver driver = null;
	
	protected WebDriverEventListner swdeListener = null;
	private EventFiringWebDriver eventFiredriver;
	protected String testCaseMethodName;
	public long startTime= 0;


	
	@BeforeTest
	@Parameters({ "browserType" })
	public void initDriverLocation(String browser) {
		logger.info("BaseTest initDriverLocation - Entered , browserType=" +  browser);
		switch (browser) {
		case DriverConstants.CHROME:
			WebDriverManager.chromedriver().clearPreferences();
			//https://github.com/bonigarcia/webdrivermanager/issues/318
			//https://github.com/bonigarcia/webdrivermanager
			//https://bonigarcia.github.io/selenium-jupiter/selenium-jupiter.pdf
			WebDriverManager.chromedriver().version("73").setup();
//			WebDriverManager.chromedriver().setup();
			break;

		case DriverConstants.FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			break;
		case DriverConstants.EDGE:
			WebDriverManager.edgedriver().setup();
			break;
		case DriverConstants.IE:
			WebDriverManager.iedriver().setup();
			break;

		default:
			WebDriverManager.chromedriver().setup();

			break;
		}
		logger.info("BaseTest initDriverLocation - END , browserType=" +  browser);
	}
	
	@BeforeClass
	@Parameters({ "browserType" })
	public void initWebDriver(String browser) {
		
		logger.info("BaseTest initWebDriver - Entered , browserType=" +  browser);
		switch (browser) {
		case DriverConstants.CHROME:
			driver= DriverManager.getchromeDriver();
			break;

		case DriverConstants.FIREFOX:
			driver= DriverManager.getGeckoDriver();
			break;
		case DriverConstants.EDGE:
			driver= DriverManager.getEdgeDriver();
			break;
		case DriverConstants.IE:
			driver= DriverManager.getIEDriver();
			break;

		default:			
			driver= DriverManager.getchromeDriver();
			break;
		}
		this.registerWebdriverListener();
		this.initThreadLocal();
		
		logger.info("BaseTest initWebDriver - Entered , browserType=" +  browser);
	}
	
	@AfterClass
	public void destroyDriver() {
		if(this.driver!=null) {
			//this.driver.quit();
		}
		QrpThreadLocal.unset();
	}
	
	private void registerWebdriverListener() {
		swdeListener = new  WebDriverEventListner(); //Created Webdriver Listener
		// Initializing EventFiringWebDriver using  WebDriver instance
		eventFiredriver = new EventFiringWebDriver(this.driver);
		eventFiredriver.register(swdeListener); //Registering  Webdriver Listener
	}
	
	private void initThreadLocal() {
		logger.info("BaseTest initThreadLocal - Entered , driver=" +  this.driver);
		QrpAppContext context= new QrpAppContext();
		context.getContextData().put("driver",this.driver);
		QrpThreadLocal.set(context);
		logger.info("BaseTest initThreadLocal - END , QrpAppContext=" +  context);
	}
	
	@AfterMethod
	public void afterTestCaseMethod(ITestResult result) {
		logger.error("after test method execution - ");
		logger.error("Total time taken for execution : "+(new Date().getTime() - startTime));
				if(null != testCaseMethodName) {
					result.setAttribute("testCaseName", testCaseMethodName);
				}else {
					result.setAttribute("testCaseName", result.getName());
				}
				ScreenshotManager.triggerScreenshot(driver, result);
		
	}
	
	protected abstract void setTestCaseMethodName(String testMethodName) ;
	
	
}
