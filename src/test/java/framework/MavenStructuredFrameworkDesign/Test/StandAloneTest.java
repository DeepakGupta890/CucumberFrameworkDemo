package framework.MavenStructuredFrameworkDesign.Test;

import java.time.Duration;
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

import framework.MavenStructuredFrameworkDesign.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	
	

	public static void main(String args[]){  
		String productName="ADIDAS ORIGINAL";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage= new LandingPage(driver);
		
		WebElement email= driver.findElement(By.cssSelector("#userEmail"));
		email.clear();
		email.sendKeys("deepaktest+2@gmail.com");
		WebElement pwd= driver.findElement(By.cssSelector("#userPassword"));
		pwd.clear();
		pwd.sendKeys("Test@123");
		WebElement login= driver.findElement(By.cssSelector("#login"));
				login.click();
				WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
				String titleDash =driver.getTitle();
				
		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		List<WebElement>cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match= cartProducts.stream().anyMatch(cartProduct->
		cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow .btn-primary")).click();
		Actions action=new Actions(driver);
		action.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:last-of-type")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmationTextActual=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmationTextActual.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
			

}

	
	}
