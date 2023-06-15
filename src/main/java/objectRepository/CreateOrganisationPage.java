package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericProperties.WebDriverUtility;

public class CreateOrganisationPage extends WebDriverUtility {
	
	public CreateOrganisationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrgNameEditTextField;
	
	@FindBy(id="phone")
	private WebElement PhoneEditTextField ;
	
	@FindBy(id="email1")
	private WebElement EmailEditTextField ;
	
	@FindBy(name="button")
	private WebElement SaveOrgBtn ;
	
	@FindBy(name="industry")
	private WebElement Industry;
	
	@FindBy(xpath="//input[@name='button'])[4]")
	private WebElement  CancelOrgBtn;

	/**
	 * @return the orgNameEditTextField
	 */
	public WebElement getOrgNameEditTextField() {
		return OrgNameEditTextField;
	}

	/**
	 * @return the phoneEditTextField
	 */
	public WebElement getPhoneEditTextField() {
		return PhoneEditTextField;
	}

	/**
	 * @return the emailEditTextField
	 */
	public WebElement getEmailEditTextField() {
		return EmailEditTextField;
	}

	/**
	 * @return the saveOrgBtn
	 */
	public WebElement getSaveOrgBtn() {
		return SaveOrgBtn;
	}

	/**
	 * @return the cancelOrgBtn
	 */
	public WebElement getCancelOrgBtn() {
		return CancelOrgBtn;
	}
	
	//business library
	
	/**
	 * This method will create new org you have to pass the org name 
	 * @param OrgName
	 */
	
	public void CreateNewOrg(String OrgName)
	
	
	{
		OrgNameEditTextField.sendKeys(OrgName);
		
		SaveOrgBtn.click();
		
	}
	
	/**
	 * This method will create Orgname with Industry you have to pass orgname and industry
	 * @param OrgName
	 * @param Industry
	 */
	
	public void CreateNewOrg(String OrgName,WebElement Industry)
	{
		OrgNameEditTextField.sendKeys(OrgName);
		handleDropDown(OrgName, Industry);
		SaveOrgBtn.click();
	}
	
	

}
