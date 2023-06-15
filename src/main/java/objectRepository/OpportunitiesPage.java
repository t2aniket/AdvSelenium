package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	
	public OpportunitiesPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Opportunity...']")
	private WebElement CreateOpportunitylookupimage;

	/**
	 * @return the createOpportunitylookupimage
	 */
	public WebElement getCreateOpportunitylookupimage() {
		return CreateOpportunitylookupimage;
	}
	
	//businesslogic
	/**
	 * This method will clcik on the + button on the opp page
	 */
	
	public void createnewopplookuping()
	{
		CreateOpportunitylookupimage.click();
	}

}
