package framework.MavenStructuredFrameworkDesign.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.MavenStructuredFrameworkDesign.AbstractPackage.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) // creates constructor to initialize webdriver and in LoginTest page it is cast. 
	                              //and driver is also cst there so refer that driver in loginTest
	
	{
		super(driver);       // this super keyword is used for give life to abstract components driver which is parent class
                             //so need to create constructor for super keyword user
		this.driver=driver;
		PageFactory.initElements(driver, this); // it is used to address web elements written bellow.
	}
	
	//WebElement email= driver.findElement(By.cssSelector("#userEmail"));
	//PageFactory
	@FindBy(css="#userEmail")
	WebElement emailID;
	
	@FindBy(css="#userPassword")
	WebElement pwdID;
	
	@FindBy(css="#login")
	WebElement submit;
	//div[aria-label='Incorrect email or password.']
	
//ng-tns-c4-13.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	//@FindBy(css="ng-tns-c4-13.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error")
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email,String pwd)
	{
		emailID.clear();
		emailID.sendKeys(email);
		pwdID.clear();
		pwdID.sendKeys(pwd);
		submit.click();
		ProductCatalogue productCatalogue= new ProductCatalogue(driver);
		return productCatalogue;
	}
	public void goTO()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}

}
