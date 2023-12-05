package framework.MavenStructuredFrameworkDesign.stepDefinations;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import framework.MavenStructuredFrameworkDesign.TestComponents.BaseTest;
import framework.MavenStructuredFrameworkDesign.pageObjects.CartPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.CheckOutPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.ConfirmmationPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.LandingPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.ProductCatalogue;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmmationPage confirmmationPage;
	
	@Given("I landded on Ecommerce page")
	public void I_landded_on_Ecommerce_page() throws IOException
	{
		landingPage=launchApplication();
	}
	
	@Given ("^Logged in with username (.+) and password  (.+)$")
	public void logged_In_with_username_and_password(String username , String password)
	{
		 productCatalogue=landingPage.loginApplication(username,password);
	}
	
	@When ("^I add the product (.+) to cart$")
	public void I_add_the_product_to_Cart(String productName)
	{
		List <WebElement> product=productCatalogue.getProductList();
				productCatalogue.addProductToCart(productName);
	}
	
	@When ("^Checkout (.+) and Submit the order$")
	
		public void checkout_and_Submit_the_order(String productName)
		{
		CartPage cartPage = productCatalogue.goTOCartPage();
		boolean match =cartPage.verifyProductDisplay(productName)	;	
		Assert.assertTrue(match);
		
		CheckOutPage checkOut=cartPage.goTOcheckOut();
		checkOut.selectCountry("India");
		 confirmmationPage=checkOut.submitOrder();
		}
	@Then ("{string} message is displaying on ConfirmationPage")
	public void message_displaying_on_confirmationPage(String string)
	{
		String confirmMessage=confirmmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
        driver.close();
	}
	@Then ("^\"([^\"]*)\")\" message is displayed")
	public void something_message_is_displayed(String strArg1) throws Throwable{
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage() );
		driver.close();
	}
	
	
	

}
