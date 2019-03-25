package com.logistics.qrpproject.genericcomponents;

import org.openqa.selenium.WebDriver;

import com.logistics.qrpproject.threadlocal.QrpAppContext;
import com.logistics.qrpproject.threadlocal.QrpThreadLocal;

public class Browser {

	static WebDriver driver= null;
	static {
		QrpAppContext context = QrpThreadLocal.get();
		driver=(WebDriver) context.getContextData().get("driver");
	
	}
	
	public static void launchWebsite(String url) {
		driver.get(url);

	}
	
	
}
