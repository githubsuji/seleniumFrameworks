package com.logistics.qrpproject.listners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public abstract class TestListener extends SuiteListener implements ITestListener {
	private static final Logger logger = Logger.getLogger(TestListener.class);
	@Override
	public void onFinish(ITestContext arg0) {
		logger.info(arg0.getName() + "Test  finished");

		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		logger.info(arg0.getName() + "test on start");
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

		logger.info(arg0.getName() + " test on failed");
		logger.info(arg0.getTestName());
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info(result.getName() + "failure");
		logger.info(result.getTestName());
		if (result.getStatus() == ITestResult.FAILURE) {
			// Do something here
			logger.info("Failed ***********");
			String testcasename = result.getName();
			logger.info(testcasename);
		}

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		logger.info(arg0.getName() + "on testskipped");
		// TODO Auto-generated method stub
		logger.info(arg0.getTestName());
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		logger.info(arg0.getName() + "onstarted");
		// TODO Auto-generated method stub
		logger.info(arg0.getTestName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getName() + "on test success");
		// TODO Auto-generated method stub
		logger.info(result.getTestName());

		try {
			if (result.getStatus() == ITestResult.SUCCESS) {

				// Do something here
				logger.info("passed **********");
				String testcasename = result.getName();
				logger.info(testcasename);

			}

		} catch (Exception e) {

		}

	}
}