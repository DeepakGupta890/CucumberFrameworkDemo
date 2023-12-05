package framework.MavenStructuredFrameworkDesign.ExcelDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadEntireDataOfExcel {
	
	
	@Test
	public void ReadEntireDataOfExcelTest() throws IOException
	{
	File file=new File("./Excel\\TestRecord.xlsx");
	FileInputStream fis= new FileInputStream(file);
	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheet("Dept");
	//get all rows in the sheet
    int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
    
 

    
    //iterate over all the row to print the data present in each cell.
    for(int i=0;i<=rowCount;i++){
        
        //get cell count in a row
    	   int cellcount=sheet.getRow(i).getLastCellNum();     
        //iterate over each cell to print its value
        System.out.println("Row "+ i+" data is :");
        
        for(int j=0;j<cellcount;j++){
        	XSSFCell cell = sheet.getRow(i).getCell(j);
        	if(cell.getCellType()==CellType.STRING)
        	{
        		System.out.print(cell.getStringCellValue() +",");
        	}
        	else
        	{
        		System.out.print(NumberToTextConverter.toText(cell.getNumericCellValue()) +",");
        	}
        	   
        }
        System.out.println();
    }}
	

}
