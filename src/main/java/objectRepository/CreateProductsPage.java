package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericProperties.WebDriverUtility;

public class CreateProductsPage extends WebDriverUtility {
	
	public CreateProductsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement ProductNameEdittextField;
	
	@FindBy(name="search_text")
	private WebElement VendorNameSearchBox;
	
	@FindBy(xpath="//input[@name='vendor_id']/following-sibling::img")
	private WebElement SelectVendorLookUpImg;
	
	@FindBy(name="glacct")
	private WebElement GlAccountDropDown;
	
	
	@FindBy(name="button")
	private WebElement SaveProductBtn;
	
	@FindBy(name="search")
	private WebElement VendorSearchBtn;


	/**
	 * @return the productNameEdittextField
	 */
	public WebElement getProductNameEdittextField() {
		return ProductNameEdittextField;
	}


	/**
	 * @return the selectVendorLookUpImg
	 */
	public WebElement getSelectVendorLookUpImg() {
		return SelectVendorLookUpImg;
	}


	/**
	 * @return the glAccountDropDown
	 */
	public WebElement getGlAccountDropDown() {
		return GlAccountDropDown;
	}


	/**
	 * @return the saveProductBtn
	 */
	public WebElement getSaveProductBtn() {
		return SaveProductBtn;
	}
	
	
	
	//business lib
	/**
	 * this method will enter the product name
	 * @param Prdname
	 */
	public void EnterProductName(String Prdname)
	{
		ProductNameEdittextField.sendKeys(Prdname);
		
	}
	
	/**
	 * This method will create product with vendor
	 * @param driver
	 * @param VendorName
	 */
	
	public void CreateProduct(WebDriver driver,String Prdname,String VendorName)
	{
		
		ProductNameEdittextField.sendKeys(Prdname);
		SelectVendorLookUpImg.click();
		switchTowindow(driver, "Vendors");
		VendorNameSearchBox.sendKeys(VendorName);
		VendorSearchBtn.click();
		driver.findElement(By.xpath("\"//a[.='\" + VendorName + \"']\";")).click();
		switchTowindow(driver, "Products");
		SaveProductBtn.click();
		
	}
	
	/**
	 * This method will create product with just product name
	 * @param driver
	 * @param Prdname
	 */
	public void CreateProduct(WebDriver driver,String Prdname)
	
	{
		
		ProductNameEdittextField.sendKeys(Prdname);
		SaveProductBtn.click();
	}
	
		
		
public void CreateProduct(WebDriver driver,String Prdname,String VendorName,String GlAccName)
	
	{
		
	ProductNameEdittextField.sendKeys(Prdname);
	SelectVendorLookUpImg.click();
	switchTowindow(driver, "Vendors");
	VendorNameSearchBox.sendKeys(VendorName);
	VendorSearchBtn.click();
	driver.findElement(By.xpath("//a[.='" + VendorName + "']")).click();
	switchTowindow(driver, "Products");
	handleDropDown(GlAccName, GlAccountDropDown);
	SaveProductBtn.click();
	
	
	}
	
	

}
