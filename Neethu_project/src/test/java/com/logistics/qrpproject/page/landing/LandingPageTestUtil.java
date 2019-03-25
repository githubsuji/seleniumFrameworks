package com.logistics.qrpproject.page.landing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.logistics.qrpproject.genericcomponents.WebElementManager;

public class LandingPageTestUtil {

	public static String getHeader(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement headerEle = WebElementManager.getElementByXpathAfterFWait(driver, 220, 3, "/html/body/qr-root/section/qr-lets-go/div/div/p[1]");
		return headerEle.getText();
	}

}
