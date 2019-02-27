package com.calibroz.page.landing;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.calibroz.page.landing.registration.RegistrationData;
import com.calibroz.util.ExcelUtil;

public class CalibrozDataProvider {
	
	
	
	@DataProvider(name="registrationDataProvider")
	public static Iterator<RegistrationData> registrationDataProvider() throws EncryptedDocumentException, InvalidFormatException, IOException{
		InputStream excel = ExcelUtil.getExcelTemplateStream("/Users/gayathri.r.nair/Downloads/sapaadtestapp/src/test/resources/registration.xlsx");
		List<RegistrationData> list = ExcelUtil.parseRegistrationDataExcel(excel);
		list.remove(0);
		return list.iterator();
		
	}

	
}
