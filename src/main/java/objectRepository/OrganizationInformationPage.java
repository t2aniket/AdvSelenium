package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	public OrganizationInformationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeader;

	/**
	 * @return the orgHeader
	 */
	public WebElement getOrgHeader() {
		return OrgHeader;
	}
	
	//business libraries
	
	public String OrgHeader()
	{
		return OrgHeader.getText();
	}
}
