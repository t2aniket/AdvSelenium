package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	public ProductsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement AddProductLookupImg;
	
	/**
	 * @return the addProductLookupImg
	 */
	public WebElement getAddProductLookupImg() {
		return AddProductLookupImg;
	}

	
	
	/**
	 * This method will click on Addproductlookup img
	 */
	public void ClickAddProductloopupImg()
	{
		AddProductLookupImg.click();
	}
	

}
