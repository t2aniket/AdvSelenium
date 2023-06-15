package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericProperties.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility {
	
	public CreateContactsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	private WebElement FirstNameEditTxtField ;
	
	@FindBy(name="search_text")
	private WebElement SearchOrgEditTextField;
	
	@FindBy (name="search")
	private WebElement SearchOrgBtn;
	
	@FindBy(xpath="xpath=//img[@alt='Select']")
	private WebElement SelectOrgLookupImg;
	
	/**
	 * @return the searchOrg
	 */
	public WebElement getSearchOrgEditTextField() {
		return SearchOrgEditTextField;
	}

	/**
	 * @return the searchOrgBtn
	 */
	public WebElement getSearchOrgBtn() {
		return SearchOrgBtn;
	}

	@FindBy(name="lastname")
	private WebElement LastNameEditTxtField ;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement SelectOrgNameBtn ;
	
	@FindBy(name="button")
	private WebElement SaveContactBtn ;
	
	@FindBy(xpath="(//input[@name='button'])[2]")
	private WebElement CancelContactBtn ;

	/**
	 * @return the firstNameEditTxtField
	 */
	public WebElement getFirstNameEditTxtField() {
		return FirstNameEditTxtField;
	}

	/**
	 * @return the lastNameEditTxtField
	 */
	public WebElement getLastNameEditTxtField() {
		return LastNameEditTxtField;
	}

	/**
	 * @return the selectOrgNameBtn
	 */
	public WebElement getSelectOrgNameBtn() {
		return SelectOrgNameBtn;
	}

	/**
	 * @return the saveContactBtn
	 */
	public WebElement getSaveContactBtn() {
		return SaveContactBtn;
	}

	/**
	 * @return the cancelContactBtn
	 */
	public WebElement getCancelContactBtn() {
		return CancelContactBtn;
	}
	
	
	//business lib
	
	public void CreateNewContact(String lastname)
	{
		LastNameEditTxtField.sendKeys(lastname);
		SaveContactBtn.click();
		
	}
	
	public void CreateNewContact(WebDriver driver,String lastname,String orgname)
	{
		LastNameEditTxtField.sendKeys(lastname);
		SelectOrgLookupImg.click();
		switchTowindow(driver, "Accounts");
		SearchOrgEditTextField.sendKeys(orgname);
		SearchOrgBtn.click();
		driver.findElement(By.id("1")).click();
		switchTowindow(driver, "Contacts");
		SaveContactBtn.click();
		
		
		
	
	}
	

	


}
