package vtiger.practice;

import java.io.IOException;

import genericProperties.ExcelFile;
import genericProperties.PropertyFile;

public class GenericPractise {
public static void main(String[] args) throws IOException
{

	PropertyFile pro = new PropertyFile();
	
	String value= pro.readDataFromPropertyFile("username");
	System.out.println(value);
	
	ExcelFile exe= new ExcelFile();
	String Data = exe.readDataFromExcelFile(0);
	System.out.println(Data);
	
	String a="Aniekt Naik";
	
	exe.writeDataToExcelFile(a);
	
	
	
	

}
}
