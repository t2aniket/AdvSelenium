package genericProperties;


	



	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
	import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

	/**
		 * This class conains all the genric methods related to excel file
		 * @author Aniket
		 */

	public class ExcelFile {
		/**
		 * This method will read the data from excel file and return the value to called
		 * @author Aniket
		 * @param cell no for now the row number is by default 1
		 * @return value
		 * @throws IOException
		 */
		public String readDataFromExcelFile(int cell) throws IOException
		{
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("Organization");
			Row row = sheet.getRow(1);	
			Cell celll = row.getCell(cell);
			String value = celll.getStringCellValue();
			return value;
			
		}
		
		/**
		 * The Method will write the data to excel file 
		 * @author Aniket
		 * @param Data to write
		 * @throws Throwable 
		 * @throws IOException 
		 * 
		 */

		public void writeDataToExcelFile(String data) throws IOException
		
		{
			FileInputStream excelinput = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
			
			Workbook wb=WorkbookFactory.create(excelinput);
			Sheet sheet = wb.getSheet("Organization");
		
			sheet.createRow(6).createCell(0).setCellValue(data);
			FileOutputStream excelwrite= new FileOutputStream(".\\src\\test\\resources\\Test.xlsx");
			wb.write(excelwrite);
			
		}
		
		public String getdata(String SheetName, int rowno,int cellno) throws IOException
		{
			
			FileInputStream excelinput = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
			
			Workbook wb=WorkbookFactory.create(excelinput);
			Sheet sheet = wb.getSheet(SheetName);
			Row row = sheet.getRow(rowno);	
			Cell celll = row.getCell(cellno);
			String value = celll.getStringCellValue();
			return value;
			
			
			
		}
		
		public Object[][] getmultipledatafromexcel(String SheetName) throws IOException
		{
			
			FileInputStream excelinput = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
			Workbook wb=WorkbookFactory.create(excelinput);
			Sheet sh = wb.getSheet(SheetName);
			int lastrow=sh.getLastRowNum();
			System.out.println(lastrow);
			int cell=sh.getRow(0).getLastCellNum();
			System.out.println(cell);
			//to return object
			Object[] []data =new Object[lastrow][cell];
					for (int i=0;i<lastrow;i++)
					{
						
						for (int j=0;j<cell;j++)
						{
							data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
						}
						
					}
			return data;
			
		}
	}
