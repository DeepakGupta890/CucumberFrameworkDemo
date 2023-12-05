package framework.MavenStructuredFrameworkDesign.ExcelDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteNewCellInExistingRow {
	
	@Test
	public void WritingNewCellInExistingRow() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
	File file=new File("./Excel\\TestRecord.xlsx");
	FileInputStream fis= new FileInputStream(file);
	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheet("Dept");
	DataFormatter formatter= new DataFormatter();
	//get all rows in the sheet
    int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
    driver.get("https://demoqa.com/automation-practice-form");
    driver.manage().window().maximize();
    WebElement firstName=driver.findElement(By.id("firstName"));
    WebElement lastName=driver.findElement(By.id("lastName"));
    WebElement email=driver.findElement(By.id("userEmail"));
    WebElement genderMale=driver.findElement(By.id("gender-radio-1"));
    WebElement mobile=driver.findElement(By.id("userNumber"));
    WebElement address=driver.findElement(By.id("currentAddress"));
    WebElement submitBtn=driver.findElement(By.id("currentAddress"));
    

    //iterate over all the rows in Excel and put data in the form.
    for(int i=1;i<=rowCount;i++) {
        //Enter the values read from Excel in firstname,lastname,mobile,email,address
        firstName.sendKeys(formatter.formatCellValue(sheet.getRow(i).getCell(0)));
        lastName.sendKeys(formatter.formatCellValue(sheet.getRow(i).getCell(1)));
        email.sendKeys(formatter.formatCellValue(sheet.getRow(i).getCell(2)));
        mobile.sendKeys(formatter.formatCellValue(sheet.getRow(i).getCell(4)));
        address.sendKeys(formatter.formatCellValue(sheet.getRow(i).getCell(5)));
        
        //Click on the gender radio button using javascript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", genderMale);
        
        
        XSSFCell cell = sheet.getRow(i).createCell(7);
        cell.setCellValue("Pass");
        FileOutputStream outputStream = new FileOutputStream("./Excel\\\\TestRecord.xlsx");
        wb.write(outputStream);
        //Click on submit button
      /*  submitBtn.click();
        
        //Verify the confirmation message
       WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));
        
        //create a new cell in the row at index 6
        
        
        //check if confirmation message is displayed
        if (confirmationMessage.isDisplayed()) {
            // if the message is displayed , write PASS in the excel sheet
            cell.setCellValue("PASS");
            
        } else {
            //if the message is not displayed , write FAIL in the excel sheet
            cell.setCellValue("FAIL");
        }
        
        // Write the data back in the Excel file
        FileOutputStream outputStream = new FileOutputStream("./Excel\\\\TestRecord.xlsx");
        wb.write(outputStream);

        //close the confirmation popup
        WebElement closebtn = driver.findElement(By.id("closeLargeModal"));
        closebtn.click();
        
        //wait for page to come back to registration page after close button is clicked
        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    }*/
    
    //Close the workbook
    wb.close();
    
    //Quit the driver
    //driver.quit();
    }
    
	}}


