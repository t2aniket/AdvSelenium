package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelsheetpractise {

	public static void main(String[] args) throws Throwable {
		//file streead loading excel file
		FileInputStream PropertyFile = new FileInputStream("C:\\Users\\Aniket\\eclipse-workspace\\AdvMaven\\src\\test\\resources\\Test.xlsx");
		
		//createa workbook factork
		Workbook wb=WorkbookFactory.create(PropertyFile);
		//get the sheet 
		Sheet sheet = wb.getSheet("Organization");
		//go to the row
		Row row = sheet.getRow(1);
		//go to the cell get tcontrol of cell	
		Cell cell = row.getCell(0);
		//get cell data
		String data = cell.getStringCellValue();
		System.out.println(data);
		
		//create data inexcel
		
	 sheet.createRow(6).createCell(0).setCellValue("Aniket");
	 
	 FileOutputStream output = new FileOutputStream("C:\\Users\\Aniket\\eclipse-workspace\\AdvMaven\\src\\test\\resources\\Test.xlsx");
	 wb.write(output);
	}
	
	

}
