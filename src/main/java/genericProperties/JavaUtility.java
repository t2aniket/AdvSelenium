package genericProperties;

import java.util.Date;
import java.util.Random;

/**
 * This class consiti of generic methods related to java
 * @author Aniket
 *
 */
public class JavaUtility {
	
	/**
	 * this method will genetre randome number and return to caller
	 * @return
	 */
	public int getRandomumbers()
	{
		
		Random r = new Random();
		return r.nextInt(10000);
	}
	/**
	 * This method will get system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d= new Date();
		return d.toString();
	}
	
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String [] dArr=d.toString().split(" ");
		String date = dArr[2];
		String month= dArr[1];
		String year= dArr[5];
		String time=dArr[3].replace(":", "-");
		
		return date +" "+ month+ " "+ year+" "+ time;
		
	}

}
