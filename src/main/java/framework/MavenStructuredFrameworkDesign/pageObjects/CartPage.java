package framework.MavenStructuredFrameworkDesign.pageObjects;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.MavenStructuredFrameworkDesign.AbstractPackage.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	
	public CartPage(WebDriver driver) // creates constructor to initialize webdriver and in LoginTest page it is cast. 
	                              //and driver is also cst there so refer that driver in loginTest
	
	{
		super(driver);            // this super keyword is used for give life to abstract components driver which is parent class
                                  //so need to create constructor this this super keyword user
		this.driver=driver;
		PageFactory.initElements(driver, this); // it is used to address web elements written bellow.
	}
	
	//WebElement email= driver.findElement(By.cssSelector("#userEmail"));
	//PageFactory

	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	
	public boolean verifyProductDisplay(String productName)
	{
		Boolean match= cartProducts.stream().anyMatch(cartProduct->
		cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

}
