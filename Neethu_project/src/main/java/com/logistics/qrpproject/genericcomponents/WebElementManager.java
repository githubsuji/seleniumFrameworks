package com.logistics.qrpproject.genericcomponents;


	
	import java.util.List;
	import java.util.function.Function;

	import org.apache.log4j.Logger;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Wait;

import com.logistics.qrpproject.waitmanager.WaitManager;


	public final class WebElementManager {
		public final static Logger logger = Logger.getLogger(WebElementManager.class);
		public static void clickByJSExecutor(WebElement element, WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
		public static void inputValue(WebElement element, WebDriver driver,String input) {
			logger.info("Password is: "+input);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].value='"+input+"';", element);
		}
		public static WebElement getElementByXpathAfterFWait(WebDriver driver, long timeOutSeconds, long pollingTimeMillis, String xpath) {
			logger.info("ENTERED INTO GET ELEMENT AFTER WAIT - XPATH:" + xpath );
			Wait<WebDriver> wait = WaitManager.getFluentWait(driver,timeOutSeconds,pollingTimeMillis);
			 WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.xpath(xpath));
			     }
			   });
				
			return webElement;
			
		}
		public static List<WebElement> getElementsByXpathAfterFWait(WebDriver driver, long timeOutSeconds, long pollingTimeMillis, String xpath) {
			logger.info("ENTERED INTO GET ELEMENT AFTER WAIT - XPATH:" + xpath );
			Wait<WebDriver> wait = WaitManager.getFluentWait(driver,timeOutSeconds,pollingTimeMillis);
			List<WebElement> webElement = wait.until(new Function<WebDriver, List<WebElement>>() {
			     public List<WebElement> apply(WebDriver driver) {
			       return driver.findElements(By.xpath(xpath));
			     }
			   });
				
			return webElement;
			
		}
		public static WebElement getElementByIdAfterFWait(WebDriver driver, long timeOutSeconds, long pollingTimeMillis, String id) {
			Wait<WebDriver> wait = WaitManager.getFluentWait(driver,timeOutSeconds,pollingTimeMillis);
			WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.id(id));
			     }
			   });
			return webElement;
			
		}
		public static WebElement getElementByClassNameAfterFWait(WebDriver driver, long timeOutSeconds, long pollingTimeMillis, String className) {
			Wait<WebDriver> wait = WaitManager.getFluentWait(driver,timeOutSeconds,pollingTimeMillis);
			WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.className(className));
			     }
			   });
			return webElement;
			
		}
		public static WebElement getElementByCssSelectorAfterFWait(WebDriver driver, long timeOutSeconds, long pollingTimeMillis, String cssSelector) {
			Wait<WebDriver> wait = WaitManager.getFluentWait(driver,timeOutSeconds,pollingTimeMillis);
			WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.cssSelector(cssSelector));
			     }
			   });
			return webElement;
			
		}
		public static WebElement getElementByLinkTextAfterFWait(WebDriver driver, long timeOutSeconds, long pollingTimeMillis, String linkText) {
			Wait<WebDriver> wait = WaitManager.getFluentWait(driver,timeOutSeconds,pollingTimeMillis);
			WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.linkText(linkText));
			     }
			   });
			return webElement;
			
		}
		public static WebElement getElementByPartialLinkTextAfterFWait(WebDriver driver, long timeOutSeconds, long pollingTimeMillis, String partialLinkText) {
			Wait<WebDriver> wait = WaitManager.getFluentWait(driver,timeOutSeconds,pollingTimeMillis);
			WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.partialLinkText(partialLinkText));
			     }
			   });
			return webElement;
			
		}

	}


