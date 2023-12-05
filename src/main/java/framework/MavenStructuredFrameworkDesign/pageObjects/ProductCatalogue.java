package framework.MavenStructuredFrameworkDesign.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.MavenStructuredFrameworkDesign.AbstractPackage.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) // creates constructor to initialize webdriver and in LoginTest page it is cast. 
	                                //and driver is also cst there so refer that driver in loginTest
	 
	{
		super(driver);    // this super keyword is used for give life to abstract components driver which is parent class
		                  //so need to create constructor this this super keyword user
		this.driver=driver;
		PageFactory.initElements(driver, this); // it is used to address web elements written bellow.
	}
	
	//List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
	//PageFactory
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	  // this is more generic means used many places so make it accessibly for any other 
	                           //page with reusable code an abstract class is created and inherit that class into this class
	@FindBy(css=".ng-animating")
	WebElement spinner; 
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart= By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	


	public void goTO()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	public WebElement getProductByName(String productName)
	{
		WebElement prod=getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String productName)
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
		
	}
	

}
