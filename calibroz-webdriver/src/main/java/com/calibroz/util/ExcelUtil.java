package com.calibroz.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.calibroz.page.landing.registration.RegistrationData;

public final class ExcelUtil {
	public static InputStream getExcelTemplateStream(String filePath) {
		InputStream is = null;
		
		try {
			is = new FileInputStream(new File(filePath));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is;
	}
	
	
	public static List<RegistrationData> parseRegistrationDataExcel(InputStream excelIStream)
			throws IOException, EncryptedDocumentException, InvalidFormatException {

		Workbook workbook = WorkbookFactory.create(excelIStream);
        workbook.setMissingCellPolicy(MissingCellPolicy.RETURN_BLANK_AS_NULL);
        Sheet sheet = workbook.getSheetAt(0);//array of rows
        DataFormatter df = new DataFormatter();
        List<RegistrationData> list = new ArrayList<RegistrationData>();
        RegistrationData registrationData = null;
        for (Row row : sheet) {
        	registrationData = new RegistrationData();
        	for (int columnNumber = 0; columnNumber < row.getLastCellNum(); columnNumber++) {
				Cell cell = row.getCell(columnNumber);
				String cellValue = df.formatCellValue(cell);
				//int columnIndex  = cell.getColumnIndex();
				switch(columnNumber) {
				case 0:
					//System.out.println(""+cellValue);
					registrationData.setPhoneormobile(cellValue);
					break;
				case 1:
					//System.out.println(""+cellValue);
					registrationData.setEmailid(cellValue);
					break;
				case 2:
					//System.out.println(""+cellValue);
					registrationData.setFullName(cellValue);
					break;
				case 3:
				//	System.out.println(""+cellValue);
					registrationData.setPassword(cellValue);
					break;	
				case 4:
					//System.out.println(""+cellValue);
					registrationData.setConfirmpassword(cellValue);
					break;
				case 5:
				//	System.out.println("5  "+cellValue);
					registrationData.setCaseType(cellValue);
					break;
				case 6:
				//	System.out.println("6 "+cellValue);
					registrationData.setCaseSubType(cellValue);
					break;
				case 7:
				//	System.out.println("7 "+cellValue);
					registrationData.setExpectedResult(cellValue);
					break;
				default:
					break;
				}
			}//end of cell iteration
        	//System.out.println("-----------ADDING THE" +registrationData+" OBJECT-----------");
        	if(registrationData.getEmailid() != null && !registrationData.getEmailid().isEmpty()) {
        		list.add(registrationData);
        	}
        	
		
        }// end of rows
       // workbook.close();
       // inputStream.close();
        System.out.println("-----------RETURNING THE QUESTION LIST-----------");
        return list;
        
	}
	
	


}
