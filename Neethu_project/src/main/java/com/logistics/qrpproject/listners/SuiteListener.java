package com.logistics.qrpproject.listners;

import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;



public abstract class SuiteListener implements ISuiteListener {
	private static final Logger logger = Logger.getLogger(SuiteListener.class);
	@Override
	public void onFinish(ISuite arg0) {
		logger.info(new Date());
		logger.info("my test suite have started the execution");
	}

	@Override
	public void onStart(ISuite arg0) {
		logger.info(new Date());
		logger.info("my test suite have started the execution");
	}

}