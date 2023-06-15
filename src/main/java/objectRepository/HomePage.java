package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericProperties.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	public HomePage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[.='Vendors']")
	private WebElement Vendors;
	
	/**
	 * @return the vendors
	 */
	public WebElement getVendors() {
		return Vendors;
	}

	@FindBy(linkText="Calendar")
	private WebElement Calender;
	
	@FindBy(linkText="Leads")
	private WebElement Leads;
	
	@FindBy(linkText="Organizations")
	private WebElement Organizations;
	
	@FindBy(linkText="Contacts")
	private WebElement Contacts;
	
	@FindBy(linkText="Opportunities")
	private WebElement Opportunities;
	
	@FindBy(xpath="//a[.='More']")
	private WebElement more;
	
	@FindBy(linkText="Products")
	private WebElement Products;
	
	@FindBy(linkText="Documents")
	private WebElement Documents;
	
	@FindBy(linkText="Email")
	private WebElement Email;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement TroubleTickets;
	
	@FindBy(linkText="Dashboard")
	private WebElement Dashboard;
	
	@FindBy(linkText="More")
	private WebElement More;
	
	@FindBy(xpath="xpath=//table[3]/tbody/tr/td[3]/img")
	private WebElement Home;

	@FindBy(xpath="//td[2]/img")
	private WebElement Profile;
	
	@FindBy(linkText="Sign Out")
	private WebElement Signout;

	/**
	 * @return the calender
	 */
	public WebElement getCalender() {
		return Calender;
	}

	/**
	 * @return the leads
	 */
	public WebElement getLeads() {
		return Leads;
	}

	/**
	 * @return the organizations
	 */
	public WebElement getOrganizations() {
		return Organizations;
	}

	/**
	 * @return the contacts
	 */
	public WebElement getContacts() {
		return Contacts;
	}

	/**
	 * @return the opportunities
	 */
	public WebElement getOpportunities() {
		return Opportunities;
	}

	/**
	 * @return the products
	 */
	public WebElement getProducts() {
		return Products;
	}

	/**
	 * @return the documents
	 */
	public WebElement getDocuments() {
		return Documents;
	}

	/**
	 * @return the email
	 */
	public WebElement getEmail() {
		return Email;
	}

	/**
	 * @return the troubleTickets
	 */
	public WebElement getTroubleTickets() {
		return TroubleTickets;
	}

	/**
	 * @return the dashboard
	 */
	public WebElement getDashboard() {
		return Dashboard;
	}

	/**
	 * @return the more
	 */
	public WebElement getMore() {
		return More;
	}

	/**
	 * @return the home
	 */
	public WebElement getHome() {
		return Home;
	}

	/**
	 * @return the profile
	 */
	public WebElement getProfile() {
		return Profile;
	}

	/**
	 * @return the signout
	 */
	public WebElement getSignout() {
		return Signout;
	}
	
	/**
	 * This method will logout from the application
	 * @param driver
	 */
	
	public void Signout(WebDriver driver)
	

	{ mouseHoverAction(Profile, driver);
	Signout.click();
		
	}
	
	/**
	 * This method will clic on Organazition
	 */
	
	public void clickOnOrganization()
	{
		Organizations.click();
		
	}
	/**
	 * This method will click on contants tab
	 */
	
	public void clickOnContacts()
	{
		Contacts.click();
	}
	
	
	
	public void clickonVendors(WebDriver driver)
	{
	 MovetoElement(driver, more);
	 Vendors.click();
	}
}
