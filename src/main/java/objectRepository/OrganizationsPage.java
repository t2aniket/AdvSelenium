package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrg;
	
	@FindBy(xpath="//img[@alt='Search in Organizations...']")
	private WebElement SearchOrgBtn;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement SearchOrgEditField;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement SearchNowBtn;
	
	@FindBy(xpath="//input[@id='selectCurrentPageRec']")
	private WebElement SelectAllCheckBox;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement DeleteOrgBtn;

	/**
	 * @return the createOrg
	 */
	public WebElement getCreateOrg() {
		return CreateOrg;
	}

	/**
	 * @return the searchOrgBtn
	 */
	public WebElement getSearchOrgBtn() {
		return SearchOrgBtn;
	}

	/**
	 * @return the searchOrgEditField
	 */
	public WebElement getSearchOrgEditField() {
		return SearchOrgEditField;
	}

	/**
	 * @return the searchNowBtn
	 */
	public WebElement getSearchNowBtn() {
		return SearchNowBtn;
	}

	/**
	 * @return the selectAllCheckBox
	 */
	public WebElement getSelectAllCheckBox() {
		return SelectAllCheckBox;
	}

	/**
	 * @return the deleteOrgBtn
	 */
	public WebElement getDeleteOrgBtn() {
		return DeleteOrgBtn;
	}
	
	/**
	 * This method will click org lookup image so that u can create new org
	 */
	public void CickonOrgLookupImg()
	{
		
		CreateOrg.click();
	}

}
