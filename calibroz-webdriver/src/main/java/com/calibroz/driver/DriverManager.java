package com.calibroz.driver;

import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public final class DriverManager {

	public static WebDriver getchromeDriver() {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.chrome.driver",
		// "H:\\selenium\\driver\\3.13\\latest\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments(Arrays.asList("--test-type", "test-type=browser", "--disable-default-apps",
				"--enable-precise-memory-info", "--js-flags=--expose-gc", "--disable-infobars", "--start-maximized",
				"--ignore-certificate-errors", "--disable-popup-blocking", "--allow-running-insecure-content",
				"--disable-notifications", "--disable-save-password", "--disable-translate",
				"--always-authorize-plugins"));
		
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.resizeTo(1366, 768);");

//		driver.manage().window().maximize();
		
		driver.manage().window().fullscreen();
		return driver;

	}

	public static WebDriver getGeckoDriver() { // firefox driver

		// System.setProperty("webdriver.gecko.driver","H:\\selenium\\driver\\3.13\\geckodriver.exe");
		// FirefoxOptions options = new FirefoxOptions();
		// options.setCapability("marionette", false);
		// driver = new FirefoxDriver(options);
		// driver.get("http://seleniumhq.com");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	public static WebDriver getIEDriver() { // firefox driver
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}
	public static WebDriver getEdgeDriver() { // firefox driver
		//WebDriver driver = new MicrosoftWebDriver();
		 
		return null;
	}
	

}
