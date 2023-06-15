package genericProperties;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	public void startingwait(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 secs to load 
	 * @param driver
	 * 
	 * 
	 */
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();
		
	}
	/**
	 * This method will maximize the window of the browser
	 * @param driver
	 */
	
	public void maximize(WebDriver driver)
	{
		
		driver.manage().window().maximize();
	}
	/**
	 * This method waits for an element to load for 10secs
	 * @param element
	 * @param driver
	 * @author Aniket
	 */
	public void ExplictWait(WebElement element, WebDriver driver)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will handel dropdownbyindex
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index)
	{
		Select sc= new Select(element);
		sc.selectByIndex(index);
				
	}
	/**
	 * This method will handel dropdownbyvalue
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,String value)
	{
		Select sc= new Select(element);
		sc.selectByValue(value);		
		
	}
	
	/**
	 * This method will handel dropdownbyvisible text
	 * @param element
	 * @param index
	 * @author Aniket
	 */
	
	public void handleDropDown(String value,WebElement element)
	{
		Select sc= new Select(element);
		sc.selectByValue(value);		
		
	}
	/**
	 * This method will perform hover action
	 * @param element
	 * @param driver
	 */
	public void mouseHoverAction(WebElement element,WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	/**
	 * this method will clcick anywhere in the page
	 * @param driver
	 */
	public  void rightclick(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.contextClick().perform();
		
	}
	/**
	 * this will right click on the given element this is an examlple of overloading
	 * @param driver
	 * @param element
	 */
	public  void rightclick(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
		
	}
	/**
	 * This will double click any where on the page
	 * @param driver
	 */
	public void doubleclick(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.doubleClick();
		
	}
	
	/**
	 * This will double click on the passed element 
	 */
	public void doubleclick(WebDriver driver,WebElement element)
	{
		
		Actions act=new Actions(driver);
		act.doubleClick(element);
	}
	/**
	 * This method will drag and drop to the target element
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement src,WebElement target)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, target);
	}
	
	/**
	 * This method will drag and drop to the target element offset 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement src,int x,int y)
	{
		Actions act=new Actions(driver);
		act.dragAndDropBy(src, x, y);
	}
	
	/**
	 * This method will handel frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handel frame by string or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}	
	
	/**
	 * This method will handel frame by element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * this method will capture parent window
	 */
	public String window(WebDriver driver)
	{
		return driver.getWindowHandle();
	}
	
	/**
	 * this method will capture all the opened windows
	 */
	public Set<String> windows(WebDriver driver)
	{
		return driver.getWindowHandles();
	}
	
	/**
	 * This method will switch from child to immediate parent 
	 * @param driver
	 */
	public void swithcToParent(WebDriver driver)
	{
		
		driver.switchTo().parentFrame();
	}
	/**
	 * this method will switch to default frame
	 */
	public void switchtodefault(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert popup
	 * @param driver
	 */
	public void dismissalert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method wil return the alert text
	 * @param driver
	 * @return
	 */
	
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * method used for taking screenshot and will return absoulte path
	 * @param driver
	 * @param String screenshot name
	 * @throws IOException 
	 */
	public String takeScreenshot(WebDriver driver, String screenShotname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("C:\\Users\\Aniket\\eclipse-workspace\\AdvMaven\\Screenshot\\"+screenShotname+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath(); // used for extent reports
	}
	/**
	 * this method will scroll down randomly for 500 pixels
	 * @param driver
	 */
	public void ScrollAction(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("windows.scrollBy(0,500)", null);
		
	}
	/**
	 * This method will switch the windows based on windowtitle
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchTowindow(WebDriver driver, String partialWindowTitle)
	{//steps 1 capture all window ids
		Set<String> winIds = driver.getWindowHandles();
		
		
		//step 2 navigate to each window
		for(String winId:winIds)
		{	//steps 3: capture the title of each window
			String title = driver.switchTo().window(winId).getTitle();
			//step 4 compare the title
			if(title.contains(partialWindowTitle))
			{
				break;
			}
			
			
		}
		
	
		
		
	
		
		
	}
	
	public void MovetoElement(WebDriver driver,WebElement element) {
		
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
		
		
	}
	
}
