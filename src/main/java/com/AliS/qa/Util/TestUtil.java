package com.AliS.qa.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import com.AliS.qa.Base.TestBase;

public class TestUtil extends TestBase{
	
  public static long PageLoadTimeOut=100;
  public static long ImplicitWait=100;
  static Workbook book;
  static Sheet sheet;

  
  public static String AlisNjdohTestDataSheetPath="C:\\Users\\abhardwaj\\eclipse-workspace\\ALiSNJDOH_Framework\\src\\main\\java\\com\\AliS\\qa\\TestData\\LoginAlis.xlsx";
 
  
  public static Object[][] getTestData(String sheetName ){
	
	  FileInputStream file=null;
	  try {
		file =new FileInputStream(AlisNjdohTestDataSheetPath);
	} catch (FileNotFoundException e) {
			e.printStackTrace();
	}
	  
	 try {
			book =WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  
	 sheet=book.getSheet(sheetName);
  Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
  
  for(int i=1; i<sheet.getLastRowNum();i++) {
	  
	  for (int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
		  data[i][k]=sheet.getRow(i+1).getCell(k).toString();
	  }
  }
  
	return data;
  }
}
