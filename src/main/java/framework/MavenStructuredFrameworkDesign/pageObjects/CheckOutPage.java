package framework.MavenStructuredFrameworkDesign.pageObjects;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import framework.MavenStructuredFrameworkDesign.AbstractPackage.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) // creates constructor to initialize webdriver and in LoginTest page it is cast. 
	                              //and driver is also cst there so refer that driver in loginTest
	
	{
		super(driver);            // this super keyword is used for give life to abstract components driver which is parent class
                                  //so need to create constructor this this super keyword user
		this.driver=driver;
		PageFactory.initElements(driver, this); // it is used to address web elements written bellow.
	}
	
	//WebElement email= driver.findElement(By.cssSelector("#userEmail"));
	//PageFactory

	
	@FindBy(css=".totalRow .btn-primary")
	WebElement checkOutButton;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css=".ta-item:last-of-type")
	WebElement selectCountry;
	
	By results=By.cssSelector(".ta-results");
	
	public void clickOnCheckOut()
	{
		checkOutButton.click();
	}
	public void selectCountry(String countryName)
	{
		Actions action=new Actions(driver);
		action.sendKeys(country, countryName).build().perform();
		
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
		
	}
	public ConfirmmationPage submitOrder()
	{
		submit.click();
		ConfirmmationPage confirmationPagenew= new ConfirmmationPage(driver);
		return confirmationPagenew;
	}
}
