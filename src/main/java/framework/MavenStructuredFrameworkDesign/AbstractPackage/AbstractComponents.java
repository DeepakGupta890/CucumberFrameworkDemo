package framework.MavenStructuredFrameworkDesign.AbstractPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.MavenStructuredFrameworkDesign.pageObjects.CartPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.CheckOutPage;
import framework.MavenStructuredFrameworkDesign.pageObjects.OrdersPage;

public class AbstractComponents {
	WebDriver driver;
	
	
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); // it is used to address web elements written bellow.
	}
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cartbutton;
	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement ordersButton;
	
	@FindBy(css=".totalRow .btn-primary")
	WebElement checkOutele;
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	
	public CartPage goTOCartPage()
	{
		cartbutton.click();
		CartPage cartPage= new CartPage(driver);
		return cartPage;
	}
	public CheckOutPage goTOcheckOut()
	{
		checkOutele.click();
		CheckOutPage checkOutPage= new CheckOutPage(driver);
		return checkOutPage;
	}
	public OrdersPage goToOrderPage()
	{
		ordersButton.click();
		OrdersPage orderPage= new OrdersPage(driver);
		return orderPage;
	}
	public void goTO()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	

}
