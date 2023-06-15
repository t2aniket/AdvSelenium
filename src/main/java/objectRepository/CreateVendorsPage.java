package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorsPage {
	
	public CreateVendorsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="vendorname")
	private WebElement VendorNameEditTxtField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveVendorBtn;

	/**
	 * @return the vendorNameEditTxtField
	 */
	public WebElement getVendorNameEditTxtField() {
		return VendorNameEditTxtField;
	}

	/**
	 * @return the saveVendorBtn
	 */
	public WebElement getSaveVendorBtn() {
		return SaveVendorBtn;
	}
	
	public void CreateVendor(String Vendorname)
	{
		
		VendorNameEditTxtField.sendKeys(Vendorname);
		SaveVendorBtn.click();
	}
	
	

}
