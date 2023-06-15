package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	public ContactsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement ContactSearchEditTextField ; 
	
	@FindBy(name="submit")
	private WebElement ContactSearchNowBtn ; 
	
	@FindBy(id="selectCurrentPageRec")
	private WebElement SelectAllContactsCheckBox ; 
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement DeleteContactBtn ; 
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement CreateContactBtn ;

	/**
	 * @return the contactSearchEditTextField
	 */
	public WebElement getContactSearchEditTextField() {
		return ContactSearchEditTextField;
	}

	/**
	 * @return the contactSearchNowBtn
	 */
	public WebElement getContactSearchNowBtn() {
		return ContactSearchNowBtn;
	}

	/**
	 * @return the selectAllContactsCheckBox
	 */
	public WebElement getSelectAllContactsCheckBox() {
		return SelectAllContactsCheckBox;
	}

	/**
	 * @return the deleteContactBtn
	 */
	public WebElement getDeleteContactBtn() {
		return DeleteContactBtn;
	}

	/**
	 * 
	 * @return the createContactBtn
	 */
	public WebElement getCreateContactBtn() {
		return CreateContactBtn;
	} 
	
	
	//business lib
	
	/**
	 * this method will click on add contact button so that u can add new contact
	 */
	public void ClickonConLoopUpImage()
	{
		CreateContactBtn.click();
		
	}
	


}
