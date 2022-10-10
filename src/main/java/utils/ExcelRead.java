package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	protected static FileInputStream fileInputStream;
	private static String filePath = "src/main/resources/TestData.xlsx";

	private static FileInputStream inStream;

	static {
		try {
			inStream = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Workbook workbook;

	static {
		try {
			workbook = new XSSFWorkbook(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ExcelRead() throws IOException {}

//	public static void main(String[] args) throws Exception {
//		String filePath = "src/main/resources/TestData.xlsx";
//
//		FileInputStream inStream = new FileInputStream(filePath);
//		Workbook workbook = new XSSFWorkbook(inStream);
//		Sheet worksheet = workbook.getSheetAt(0);
//		Row row = worksheet.getRow(0);
//		Sheet sheet = workbook.getSheet("Account_data");
//
//		Cell cell = row.getCell(0);
//		System.out.println(worksheet.getRow(1).getCell(5));
//
//		workbook.close();
//		inStream.close();
//	}

	public static String getMainURL(){
		Sheet sheet = workbook.getSheet("URLs");
		return sheet.getRow(1).getCell(1).getStringCellValue();
	}
}












