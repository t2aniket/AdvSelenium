package testNg;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericProperties.ExcelFile;

public class DataProviderExcelMultipledata {
	
	ExcelFile eutil=new ExcelFile();	
	@Test(dataProvider = "getData")
	public void TestExample(String OrgName, String Industrty)
	
	{
	System.out.println(OrgName+"****"+Industrty);	
	}
	
	@DataProvider
	public Object [] [] getData() throws IOException
	{
	
		return eutil.getmultipledatafromexcel("DataSubmittor");
		
	}

}
