package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericProperties.ExcelFile;
import genericProperties.JavaUtility;
import genericProperties.PropertyFile;
import genericProperties.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateOrganisationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OpportunitiesPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationsPage;

public class CreateOrganizationWithIndustry {
	
	public static void main(String[] args) throws IOException, Throwable {
		
		//create objects witl all the utilities
		JavaUtility jutil=new JavaUtility();
		PropertyFile putil=new PropertyFile();
		ExcelFile eutil = new ExcelFile();
		WebDriverUtility wutil = new WebDriverUtility();
	
		
		Random ran = new Random();
		int random = ran.nextInt(1000);
		WebDriver driver=null;
		
		/*Read all the required Data*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\demo.properties");
		Properties p = new Properties();
		p.load(fisp);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Row rw = wb.getSheet("Organization").getRow(4);
		String ORGNAME = rw.getCell(2).getStringCellValue()+random;
		String INDUSTRY = rw.getCell(3).getStringCellValue();
		
	
		//Step 1: launch the browser
		
		//this is the example of runtime polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		wutil.maximize(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		//Step 2: Login to Application
		LoginPage lp1 = new LoginPage(driver);
		lp1.loginToApp(putil.readDataFromPropertyFile("username"), putil.readDataFromPropertyFile("password"));
		System.out.println("Login successful");
		
		//Step 3: Click on Organizations link
		HomePage hp1=new HomePage(driver);
		hp1.clickOnOrganization();
		System.out.println("in org page");
		
		//Step 4: Click on Create Org Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.CickonOrgLookupImg();
		
	
		
		//Step 5: Create Organization with mandatory fields
		CreateOrganisationPage CreateOrgP=new CreateOrganisationPage(driver);
		CreateOrgP.CreateNewOrg(ORGNAME);
		
		//Step 8: Validate
		OrganizationInformationPage OrgInfoP = new OrganizationInformationPage(driver);
		String orgHeader = OrgInfoP.OrgHeader();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
			System.out.println("Test Script Passeddddddddddddddd");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step 9: Logout of App
		hp1.Signout(driver);
		lp1.loginToApp(putil.readDataFromPropertyFile("username"),putil.readDataFromPropertyFile("password"));
		hp1.getOpportunities().click();
		OpportunitiesPage Oppg=new OpportunitiesPage(driver);
		Oppg.createnewopplookuping();
		
		
	}

}
