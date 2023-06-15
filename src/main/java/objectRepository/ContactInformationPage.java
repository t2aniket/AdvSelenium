package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	public ContactInformationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ConInfo;

	/**
	 * @return the conInfo
	 */
	public WebElement getConInfo() {
		return ConInfo;
	}
	
	public String ContactInformation()
	{
		return ConInfo.getText();
	}

}
