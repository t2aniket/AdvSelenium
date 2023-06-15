package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	
	public VendorsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Vendor...']")
	private WebElement AddVendorsLookupImg;

	/**
	 * @return the addVendorsLookupImg
	 */
	public WebElement getAddVendorsLookupImg() {
		return AddVendorsLookupImg;
	}
	
	
	public void clickaddvendorslookupimg()
	{
		AddVendorsLookupImg.click();
	}
	
	

}
