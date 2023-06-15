package genericProperties;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
	 * This class conains all the genric methods related to propery file
	 * @author Aniket
	 */

public class PropertyFile {
	/**
	 * This method will read the data from property file and return the value to called
	 * @author Aniket
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\demo.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}

}
