package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericProperties.WebDriverUtility;

public class CreateOpportunityPage extends WebDriverUtility {
	
	public CreateOpportunityPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement SearchOrgorCon;
	
	@FindBy(name = "potentialname")
	private WebElement Opportunityname;
	
	@FindBy(id="related_to_display")
	private WebElement RelatedTo;
	
	@FindBy(id="related_to_type")
	private WebElement RelatedToDropDown;
	
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img")
	private WebElement RelatedToDisplayLookUpImg;
	
	@FindBy(name="button")
	private WebElement SaveOppBtn;

	/**
	 * @return the opportunityname
	 */
	public WebElement getOpportunityname() {
		return Opportunityname;
	}

	/**
	 * @return the relatedTo
	 */
	public WebElement getRelatedTo() {
		return RelatedTo;
	}

	/**
	 * @return the relatedToDropDown
	 */
	public WebElement getRelatedToDropDown() {
		return RelatedToDropDown;
	}

	/**
	 * @return the relatedToDisplayLookUpImg
	 */
	public WebElement getRelatedToDisplayLookUpImg() {
		return RelatedToDisplayLookUpImg;
	}

	/**
	 * @return the saveOppBtn
	 */
	public WebElement getSaveOppBtn() {
		return SaveOppBtn;
	}
	
	
	//business library
	/**
	 * this will save you created opportunity
	 */
	
	public void SaveOpportunity()
	{
		SaveOppBtn.click();
	}
	
	/**
	 * this method will select the related to that you are passing
	 * contacs or organisation
	 * @param relatedto
	 * @param driver
	 */
	
	public void SelectRelatedtoDropdown(String relatedto,WebDriver driver)
	{
		handleDropDown(relatedto, RelatedToDropDown);
	}
	
	public void SelectConfromrelatedto(WebDriver driver,String Lastname)
	{
		RelatedToDisplayLookUpImg.click();
		switchTowindow(driver, "Accounts");
		SearchOrgorCon.sendKeys(Lastname);
		
		
	}
	
	public void SelectOrgfromrelatedto(WebDriver driver)
	{
		
	}
	
	

}
