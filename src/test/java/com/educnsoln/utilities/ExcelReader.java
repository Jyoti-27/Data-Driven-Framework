package com.educnsoln.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static String homepath = System.getProperty("user.dir");
	static File file = new File(homepath + "\\src\\test\\resources\\TestData\\TestData.xlsx");
	static XSSFSheet sheet;



	public static Object[][] excelReader() throws IOException {
		Map<Object , Object > data;
		FileInputStream fis = new FileInputStream(file); // inputstream excel file
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // get hold of excelfile
		sheet = workbook.getSheet("sheet1"); // get hold of Sheet

		int rowcount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] finaldata=new Object[rowcount-1][1];   //2*2
		for (int i = 1; i < rowcount; i++) {
			data=new HashMap<Object, Object>();
			for (int j = 0; j < cellcount; j++) {
				Object value=getvalue(i,j);
				System.out.println(value);				
				data.put(getvalue(0,j), value);
				finaldata[i-1][0]=data;

			}

		}
		return finaldata;

	}

	public static Object getvalue(int rownum, int colnum) {
		Object value = null;
		Cell cell = sheet.getRow(rownum).getCell(colnum);
		if (cell.getCellType() == CellType.NUMERIC) {
			int k = (int) cell.getNumericCellValue();
			value = k;

		} else if (cell.getCellType() == CellType.STRING) {
			value = cell.getStringCellValue();

		}
		return value;
	}

}

/*package com.educnsoln.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static String homepath = System.getProperty("user.dir");
	static File file = new File(homepath + "\\src\\test\\resources\\TestData\\TestData.xlsx");
	static XSSFSheet sheet;

	public static Object[][] excelReader() throws IOException {
		Map<Object, Object> data;
		FileInputStream fis = new FileInputStream(file); // inputstream excel file
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // get hold of excelfile
		sheet = workbook.getSheet("sheet1"); // get hold of Sheet

		int rowcount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] finaldata = new Object[rowcount - 1][1]; // 2*2
		for (int i = 1; i < rowcount; i++) {
			data = new HashMap<Object, Object>();
			for (int j = 0; j < cellcount; j++) {
				Object value = getvalue(i, j);
				System.out.println(value);
				data.put(getvalue(0, j), value);
				finaldata[i - 1][0] = data;

			}

		}
		return finaldata;

	}

	public static Object getvalue(int rownum, int colnum) {
		Object value = null;
		Cell cell = sheet.getRow(rownum).getCell(colnum);
		if (cell.getCellType() == CellType.NUMERIC) {
			int k = (int) cell.getNumericCellValue();
			value = k;

		} else if (cell.getCellType() == CellType.STRING) {
			value = cell.getStringCellValue();

		}
		return value;
	}
}*/
