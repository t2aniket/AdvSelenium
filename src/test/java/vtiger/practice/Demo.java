package vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	
		
		WebDriver chrome =new ChromeDriver();
		chrome.manage().window().maximize();
		chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		chrome.get("http://localhost:8888");
		
		
		
		//using action class
		Actions act=new Actions(chrome);
		WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

			WebElement loginusername = chrome.findElement(By.name("user_name"));
		
		WebElement loginpassword = chrome.findElement(By.name("user_password"));
		act.sendKeys(loginusername,"admin").sendKeys(loginpassword, "admin",Keys.ENTER).build().perform();
		
		
		//scenario 1
		chrome.findElement(By.xpath("//a[.='Contacts']")).click();
		chrome.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement lstname= chrome.findElement(By.name("lastname"));
		WebElement savebtn=chrome.findElement(By.xpath("//input[@class='crmbutton small save']"));
		act.sendKeys(lstname,"Naik").sendKeys(savebtn).click().build().perform();
		WebElement verifysc1=chrome.findElement(By.id("dtlview_Last Name"));
		
		String expectedTextsc1 = "Naik";
		String actualTextsc1 = verifysc1.getText();
		if (actualTextsc1.equals(expectedTextsc1))
		{	
			System.out.println("Test Case 1 Passed");
		}
		else
		{System.out.println(verifysc1.getText());
			System.out.println("Test Case 1 Failed");
		}
		WebElement adminlogo= chrome.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebElement signout=chrome.findElement(By.xpath("//a[.='Sign Out']"));
		act.sendKeys(adminlogo).click().sendKeys(signout).click().build().perform();
		System.out.println("Sc1 complete");
		
		
		
		
		//scenario 2
		WebElement loginusername1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_name")));
		WebElement loginpassword1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_password")));
		act.sendKeys(loginusername1,"admin").sendKeys(loginpassword1, "admin",Keys.ENTER).build().perform();
		chrome.findElement(By.xpath("//tr/td[6]/a")).click();
		chrome.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		chrome.findElement(By.name("accountname")).sendKeys("Demo Org scwwww2");
		chrome.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		WebElement verifysc2=chrome.findElement(By.id("dtlview_Organization Name"));
		
		String expectedTextsc2 = "Demo Org scwwww2";
		String actualTextsc2 = verifysc2.getText();
		if(expectedTextsc2.equals(actualTextsc2))
		{
			System.out.println("Test Case 2 Passed");
			
		}
		else
		{
			System.out.println("Test Case 2 Failed");
		}
		chrome.navigate().refresh(); // Refresh the page or navigate to a new page

		// Re-find the element
		chrome.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//WebElement elementToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		//elementToClick.click();
		chrome.findElement(By.xpath("//a[.='Sign Out']")).click();
		System.out.println("Sc2 complete");
		//scenario 3
		
		
		WebElement loginusername2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_name")));
		WebElement loginpassword2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_password")));
		act.sendKeys(loginusername2,"admin").sendKeys(loginpassword2, "admin",Keys.ENTER).build().perform();
		chrome.findElement(By.xpath("//tr/td[6]/a")).click();
		chrome.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		chrome.findElement(By.name("accountname")).sendKeys("Demo org sen 3");
		WebElement industry = chrome.findElement(By.name("industry"));
		Select sel= new Select(industry);
		sel.selectByValue("Chemicals");
		chrome.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		WebElement verifysc3=chrome.findElement(By.id("dtlview_Organization Name"));
		WebElement verifysc31 =chrome.findElement(By.id("dtlview_Industry"));
		
		
		String expectedTextsc3 = "Demo org sen 3";
		String actualTextsc3 = verifysc3.getText();
		String expectedTextsc31 = "Chemicals";
		String actualTextsc31 = verifysc31.getText();
		if(expectedTextsc3.equals(actualTextsc3)& expectedTextsc31.equals(actualTextsc31))
		{
			System.out.println("Test Case 3 Passed");
			
		}
		else
		{
			System.out.println("Test Case 3 Failed");
		}
		chrome.navigate().refresh();
		chrome.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		chrome.findElement(By.xpath("//a[.='Sign Out']")).click();
		System.out.println("Sc3 complete");
		
		//scenario 4
		WebElement loginusername3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_name")));
		WebElement loginpassword3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_password")));
		act.sendKeys(loginusername3,"admin").sendKeys(loginpassword3, "admin",Keys.ENTER).build().perform();
		chrome.findElement(By.xpath("//tr/td[6]/a")).click();
		chrome.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		chrome.findElement(By.name("accountname")).sendKeys("Demo org sen 4");
		WebElement industry1 = chrome.findElement(By.name("industry"));
		Select sel1= new Select(industry1);
		sel1.selectByValue("Energy");
		WebElement typeDown = chrome.findElement(By.name("accounttype"));
		Select sel2 = new Select(typeDown);
		sel2.selectByValue("Customer");
		chrome.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		WebElement verifysc4=chrome.findElement(By.id("dtlview_Organization Name"));
		WebElement verifysc41 =chrome.findElement(By.id("dtlview_Industry"));
		WebElement verifysc42 = chrome.findElement(By.id("dtlview_Type"));
		
		String expectedTextsc4 = "Demo org sen 4";
		String actualTextsc4 = verifysc4.getText();
		String expectedTextsc41 = "Energy";
		String actualTextsc41 = verifysc41.getText();
		String expectedTextsc43 = "Customer";
		String actualTextsc43 = verifysc42.getText();
		if(expectedTextsc4.equals(actualTextsc4)& expectedTextsc41.equals(actualTextsc41) & expectedTextsc43.equals(actualTextsc43))
		{
			System.out.println("Test Case 3 Passed");
			
		}
		else
		{
			System.out.println("Test Case 3 Failed");
		}
		chrome.navigate().refresh();
		chrome.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		chrome.findElement(By.xpath("//a[.='Sign Out']")).click();
		System.out.println("Sc4 complete");
		
		//scenarios5
		
		WebElement loginusername4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_name")));
		WebElement loginpassword4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_password")));
		act.sendKeys(loginusername4,"admin").sendKeys(loginpassword4, "admin",Keys.ENTER).build().perform();
		chrome.findElement(By.xpath("//a[.='Contacts']")).click();
		chrome.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		chrome.findElement(By.name("lastname")).sendKeys("Scenario 5");
		
		chrome.findElement(By.xpath("//td[2]/img[@title='Select']")).click();
		String parentWindowHandle = chrome.getWindowHandle();
		
		for (String windowHandle : chrome.getWindowHandles()) {
		    if (!windowHandle.equals(parentWindowHandle)) {
		        chrome.switchTo().window(windowHandle);
		        break;
		    }
		}
		
		chrome.findElement(By.xpath("//a[.='Demo org sen 3']")).click();
		chrome.switchTo().window(parentWindowHandle);
		chrome.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		WebElement verifysc5=chrome.findElement(By.id("dtlview_Last Name"));
		WebElement verify51=	chrome.findElement(By.linkText("Demo org sen 3"));
		
		String expectedTextsc5 = "Scenario 5";
		String actualTextsc5 = verifysc5.getText();
		String expectedTextsc51 = "Demo org sen 3";
		String actualTextsc51 = verify51.getText();
		if(expectedTextsc5.equals(actualTextsc5)& expectedTextsc51.equals(actualTextsc51))
		{
			System.out.println("Test Case 5 Passed");
		}
		else
		{	//getting spcae in the org name that why its failing
			System.out.println("Test Case 5 Failed");
		}
		
		chrome.navigate().refresh();
		chrome.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		chrome.findElement(By.xpath("//a[.='Sign Out']")).click();
		System.out.println("Sc5 complete");

		
	}

}
