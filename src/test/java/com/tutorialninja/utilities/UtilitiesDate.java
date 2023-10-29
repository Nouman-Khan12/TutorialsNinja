package com.tutorialninja.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class UtilitiesDate {
	public static String dateStamp()
	{
		Date date = new Date();
		String formatedDate = date.toString().replace(" ", "_").replace(":", "_");
		System.out.println(formatedDate);
		return formatedDate;
	}
	
	public static Object[][] getTestDatafromExcel(String sheetName)
	{
		File file = new File("./src/test/java/com/tutorialsninja/testData/TutorialsNinjaData.xlsx");
		XSSFWorkbook workbook = null;
		try {
			
			FileInputStream ips = new FileInputStream(file);
			workbook = new XSSFWorkbook(ips);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][columns];
		
		for(int i=0; i<rows; i++)
		{
			XSSFRow row = sheet.getRow(i);
			
			for(int j=0; j<columns; j++) 
			{
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				
				switch(celltype)
				{
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
				}
			}
				
		}
		return data;
	}

}
