package vtiger.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
		List<WebElement> a = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		//first scenario
		for(WebElement b:a)
		{
			
			b.click();
			
			
		}
		driver.navigate().refresh();
		
		//second scenario
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[1]/input")).click();
		
		driver.navigate().refresh();
		
		//third
		List<WebElement> c = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
		
		for (WebElement d:c)
		{
			System.out.println(d.getText());
		}
		
		
		//fourth
		
 List<WebElement> e = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
 WebElement lastCheckbox = e.get(e.size() - 1);
 lastCheckbox.click();
 
 driver.navigate().refresh();
 
 //fifth
 
 
 
 WebElement l = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[@class='lvtColData'][8]"));

List<WebElement> tdElements = l.findElements(By.tagName("td"));

 System.out.println(tdElements);
 for(WebElement ll:tdElements)
 {
	 System.out.println("a");
	 System.out.println(ll.getText());
	 
	 
 }
 /*List<WebElement> k = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
 int count=0;
 for (WebElement kk:k)
 {
	 count++;
	 if (count==8)
	 {
		 System.out.println(kk.getText());
		 
	 }
	 
 }
 //List<WebElement> e = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
 
		Actions act= new Actions(driver);
		WebElement seting =driver.findElement(By.xpath("//img[@src='themes/softed/images/layerPopupBg.gif']"));
		WebElement signout=driver.findElement(By.linkText("Sign Out"));
		act.moveToElement(seting);
		act.moveToElement(signout).click().build().perform();*/
		

		
		
		

	}

}
