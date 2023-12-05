package framework.MavenStructuredFrameworkDesign.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.MavenStructuredFrameworkDesign.TestComponents.BaseTest;
import framework.MavenStructuredFrameworkDesign.pageObjects.CartPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.CheckOutPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.ConfirmmationPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.LandingPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.OrdersPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	//String productName="ADIDAS ORIGINAL";
	
     @Test(dataProvider="getData", groups= {"Purchage"})
     // groups is used to run only particular kind of test cases
	 
	public void submitOrderTest(HashMap<String, String> input) throws IOException
	{
	
		
		String CountryName="India";
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password"));
		//List <WebElement> product=productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goTOCartPage();
		boolean match =cartPage.verifyProductDisplay(input.get("product"))	;	
		Assert.assertTrue(match);
		
		CheckOutPage checkOut=cartPage.goTOcheckOut();
		checkOut.selectCountry(CountryName);
		ConfirmmationPage confirmmationPage=checkOut.submitOrder();
		String confirmMessage=confirmmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
      
	}
//     @Test(dependsOnMethods= {"submitOrderTest"})
//     public void orderHistroyTest(String productName)
//     {
//    	 ProductCatalogue productCatalogue=landingPage.loginApplication("deepaktest+2@gmail.com", "Test@123");
//    	  OrdersPage orderPage=productCatalogue.goToOrderPage(); 
//    	  Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
//     }
//     
     //shivkr@gmail.com
     
     @DataProvider
     public Object[][] getData() throws IOException
     {
    	 
    	 
    	 
    	List<HashMap<String, String>> data= getjsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\framework\\MavenStructuredFrameworkDesign\\Data\\PurchageOrder.json");
    	return new Object [] [] {{data.get(0)},{data.get(1)}};
    	 
    	 
//    	 HashMap <String,String> map= new HashMap<String,String>();
//    	 map.put("email", "deepaktest+2@gmail.com");
//    	 map.put("password", "Test@123");
//    	 map.put("product", "ADIDAS ORIGINAL");
//    	 
//    	 HashMap<String,String> map1= new HashMap<String,String>();
//    	 map1.put("email", "shivkr@gmail.com");
//    	 map1.put("password", "Test@1234");
//    	 map1.put("product", "ADIDAS ORIGINAL");
//		return new Object[][] {{map},{map1}} ;
    	// By creating the Hashmap we can get the data set in perticular method by returning it into that method like - public void submitOrderTest(HashMap<String, String> input)
    	 // and- ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password"));
    	 
    	 
    	 //return new Object[][] {{"deepaktest+2@gmail.com","Test@123","ADIDAS ORIGINAL" },{"shivkr@gmail.com", "Test@1234", "ADIDAS ORIGINAL"}};
		// with above line we can also set the multiple data set and call it in respective method like- public void submitOrderTest(String email,String password)
     }
}

	
	
