package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo2 {
	
	public static void main(String[] args) throws Throwable {
		
		//input necessary files
		FileInputStream common = new FileInputStream("\\src\\test\\resources\\demo.properties");
		FileInputStream excelread = new FileInputStream("\\src\\test\\resources\\Test.xlsx");
		FileOutputStream excelwrite = new FileOutputStream("\\src\\test\\resources\\Test.xlsx");
		Properties Commonp = new Properties();
		Workbook testdata = WorkbookFactory.create(excelread);
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver chrome = new ChromeDriver();
		chrome.manage().window().maximize();
		
		//load the files
		Commonp.load(common);
		Sheet Organization = testdata.getSheet("Organization");
		Organization.getRow(1);
		String url = Commonp.getProperty("url");
		chrome.get(url);
		
	
		
		
				
		
	}
	

}
