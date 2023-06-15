package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Aniket
 *
 */
public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="user_name")
	private WebElement usernameEdt;
	
	@FindBy (name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	/**
	 * @return the usernameEdt
	 */
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	/**
	 * @return the passwordEdt
	 */
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	/**
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * This method can be used to login to vtiger app
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
	loginBtn.click();
	}

}
