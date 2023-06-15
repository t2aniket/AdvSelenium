package vtiger.practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericProperties.BaseClass;
import genericProperties.ExcelFile;

import genericProperties.PropertyFile;
import genericProperties.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateProductsPage;
import objectRepository.CreateVendorsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProductInformationPage;
import objectRepository.ProductsPage;
import objectRepository.VendorInformationPage;
import objectRepository.VendorsPage;

@Listeners(genericProperties.ListnerImplementation.class)
public class CreateProductWithVendor extends BaseClass{
	@Test(groups = "smokesuite", retryAnalyzer =genericProperties.IRetryAnalyzerm.class)
	public  void createProductWithVendor() throws IOException {
		
		
		String PrdName = eUtil.getdata("Organization", 7, 3)+jUtil.getRandomumbers();
		String vendorName=eUtil.getdata("Organization", 7, 2)+jUtil.getRandomumbers();
		String GiaccName=eUtil.getdata("Organization", 7, 4);
		
		HomePage hp=new HomePage(driver);
		Reporter.log("Home Page");
		hp.clickonVendors(driver);
		
		//Go to  Vendor page
		VendorsPage vp = new VendorsPage(driver);
		Reporter.log("Vendor Page");
		vp.clickaddvendorslookupimg();
		
		// create vendor
		
		CreateVendorsPage cvp= new CreateVendorsPage(driver);
		cvp.CreateVendor(vendorName);
		
		//verify vendor
		VendorInformationPage vip=new VendorInformationPage(driver);
		String VenHeader=vip.getvendorheader();
		
		Assert.assertTrue(VenHeader.contains(vendorName));
	
		//assuming it is passed lets go to product page
		
		
		hp.getProducts().click();
		
		//go to create product with vendor
		
		ProductsPage pp= new ProductsPage(driver);
		pp.ClickAddProductloopupImg();
		
		//create product with vendor
	
		CreateProductsPage cpp=new CreateProductsPage(driver);
		
		cpp.CreateProduct(driver, PrdName, vendorName, GiaccName);
		
		//verify the info
		
		ProductInformationPage pip= new ProductInformationPage(driver);
		String ProductInfoHeader= pip.getProductHeader().getText();
		
		Assert.assertTrue(ProductInfoHeader.contains(PrdName));

		}

	}



