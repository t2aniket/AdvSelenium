package personal;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import genericProperties.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MorningAutomate {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		WebDriverUtility wutility=new WebDriverUtility();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get("https://online.qspiders.com/");
		
	}

}
