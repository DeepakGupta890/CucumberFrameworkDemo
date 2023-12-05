package framework.MavenStructuredFrameworkDesign.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.MavenStructuredFrameworkDesign.AbstractPackage.AbstractComponents;

public class ConfirmmationPage extends AbstractComponents {
	WebDriver driver;
	public ConfirmmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement confirmationTextActual;
	
	public String getConfirmationMessage()
	{
		return confirmationTextActual.getText();
	}

}
