package testNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {


	@Test(dataProvider = "getData")
	public void TestExample(String Name, String Model, int Price)
	
	{
	System.out.println(Name+"---"+Model+"---"+Price);	
	}
	
	@DataProvider
	public Object [] [] getData()
	{
		Object [] [] data = new Object[3][3];
		data[0][0] = "Samsung";
		data[0][1] = "A80";
		data[0][2] = 14000;
		
		data[1][0] = "Nokia";
		data[1][1] = "Lumia";
		data[1][2] = 80000;
		
		data[2][0] = "Apple";
		data[2][1] = "Iphone 14";
		data[2][2] = 1000000;
		return data;
		
	}
}
