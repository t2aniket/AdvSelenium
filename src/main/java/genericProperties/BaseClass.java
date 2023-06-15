package genericProperties;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of all basic configuration annotations of TestNG
 * @author Aniket
 *
 */
public class BaseClass {
	
	public PropertyFile pUtil = new PropertyFile();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public ExcelFile eUtil = new ExcelFile();
	public JavaUtility jUtil = new JavaUtility();
	
	public WebDriver driver = null;
	
	public static WebDriver sdriver;
	
	@BeforeSuite(groups="smokesuite")
	public void bsConfig()
	{
		System.out.println("====== DB Connection SuccessFull ======");
	}
	
	//@Parameters("browser")
	@BeforeClass(groups="smokesuite")
	public void bcConfig() throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + "====== Browser Launched ======");
		} 
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + "====== Browser Launched ======");
		} 
		else 
		{
			System.out.println("====== Invalid Browser Name ======");
		}
		sdriver=driver;
		wUtil.maximize(driver);
		wUtil.startingwait(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups="smokesuite")
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("====== Login to App Successful ======");
	}
	
	@AfterMethod(groups="smokesuite")
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.Signout(driver);
		
		System.out.println("====== Logout of App Successful ======");
		
	}
	
	
	@AfterClass(groups="smokesuite")
	public void acConfig()
	{
		driver.quit();
		System.out.println("====== Browser Closed ======");
	}
	
	
	@AfterSuite(groups="smokesuite")
	public void asConfig()
	{
		System.out.println("====== DB Connection Closed ======");
	}

}
