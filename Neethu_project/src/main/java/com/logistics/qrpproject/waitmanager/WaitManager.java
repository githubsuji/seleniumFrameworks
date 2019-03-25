package com.logistics.qrpproject.waitmanager;

import java.time.Duration;
import java.util.Arrays;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public final class WaitManager {
	public final static Logger logger = Logger.getLogger(WaitManager.class);
	public static Wait<WebDriver> getFluentWait(WebDriver driver, long timeOutSeconds, long pollingTimeMillis) {
		logger.info("ENTERED INTO FLUENTWAIT INITIALIZATION - timeOutSeconds:" + timeOutSeconds + " -" + pollingTimeMillis);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(Duration.ofMillis(timeOutSeconds)) 			
				.pollingEvery(Duration.ofMillis(pollingTimeMillis)) 			
				.ignoreAll(Arrays.asList(Exception.class)).withMessage("This message happens because of the timeout reached");
		return wait;
	}
	
	public static void applyJavaWait(long mSeconds) {
		try {
			Thread.sleep(mSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}