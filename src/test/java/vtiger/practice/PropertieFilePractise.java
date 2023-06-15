package vtiger.practice;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertieFilePractise {

	public static void main(String[] args) throws Throwable {
		
		//open the file in java readable format
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\demo.properties");
		
		//create object for propertis file 
		Properties pro = new Properties();
		
		//load the file into properties
		pro.load(fis);
				
		//give the key and read the value
		String value = pro.getProperty("url");
		
		System.out.println(value);

	}

}
