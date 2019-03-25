package com.logistics.qrpproject.listners;

import org.apache.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public abstract class TestCaseMethodListener extends TestListener implements IInvokedMethodListener {
	private static final Logger logger = Logger.getLogger(TestCaseMethodListener.class);

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		ITestNGMethod method =arg0.getTestMethod();
		
		logger.info(method.getMethodName()+ " has been started");
		logger.info(method.getDescription());
		

	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		ITestNGMethod method =arg0.getTestMethod();
		System.err.println("before TestMethod Invocation");
		logger.info(method.getMethodName()+ " has been started");
		logger.info(method.getDescription());

	}

}
