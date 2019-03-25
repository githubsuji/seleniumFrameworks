package com.logistics.qrpproject.listners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public final class WebDriverEventListner extends AbstractWebDriverEventListener {
	public final static Logger logger = Logger.getLogger(WebDriverEventListner.class);
	@Override
	public void afterClickOn(WebElement webElement, WebDriver driver) {
		//System.out.println("afterClickOn trigger, " + this.getWebElementInfo(webElement));
	}

	@Override
	public void afterFindBy(By by, WebElement webElement, WebDriver driver) {
		//System.out.println("afterFindBy trigger, Condition : " + by.toString() + this.getWebElementInfo(webElement));
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		//System.out.println("afterNavigateBack trigger.");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		//System.out.println("afterNavigateTo trigger, navigate to : " + url);
	}

	@Override
	public void beforeClickOn(WebElement webElement, WebDriver driver) {
		//System.out.println("beforeClickOn trigger, " + this.getWebElementInfo(webElement));
	}

	@Override
	public void beforeFindBy(By by, WebElement webElement, WebDriver driver) {
		
		//System.out.println("beforeFindBy trigger, Condition : " + by.toString() + this.getWebElementInfo(webElement));
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		//System.out.println("beforeNavigateTo trigger , navigate to : " + url);
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		logger.error(throwable.getMessage(), throwable);
		
//		try
//		{
//			/* Take screenshot when exception happened. */
//			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			/* save screenshot to file. */
//			FileUtils.copyFile(scrFile, new File("C:\\Workspace\\webdriverEventListenerScreenshot.png"));
//		}catch(IOException ex)
//		{
//			ex.printStackTrace();
//		}
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		//System.out.println("beforeNavigateBack trigger. ");
	}

	
	
	/* This is a util method that can print webelement's information in console. */
	private String getWebElementInfo(WebElement element)
	{
		String ret = "";
		if(element!=null)
		{
			ret = "element name: " + element.getAttribute("name") + " , element value: " + element.getAttribute("value") + " , tag name : " + element.getTagName();
		}
		return ret;
	}
}