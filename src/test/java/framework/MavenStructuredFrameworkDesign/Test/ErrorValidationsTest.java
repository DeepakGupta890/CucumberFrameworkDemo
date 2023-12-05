package framework.MavenStructuredFrameworkDesign.Test;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.MavenStructuredFrameworkDesign.TestComponents.BaseTest;
import framework.MavenStructuredFrameworkDesign.TestComponents.Retry;
import framework.MavenStructuredFrameworkDesign.pageObjects.CartPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.CheckOutPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.ConfirmmationPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {
	String productName="ADIDAS ORIGINAL";
	String CountryName="India";
	

	@Test (retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException
	{
	
		
		landingPage.loginApplication("deepaktest+2@gmail.com", "Test@1234");
		
		//.ng-tns-c4-13.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage() );
		
	}
	@Test
	public void productErrorValidation() throws IOException
	{
	
		
		String CountryName="India";
		ProductCatalogue productCatalogue=landingPage.loginApplication("deepaktest+2@gmail.com", "Test@123");
		List <WebElement> product=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goTOCartPage();
		boolean match =cartPage.verifyProductDisplay(productName)	;	
		Assert.assertTrue(match);
	
      
	}
	
			

}

	
	
