package framework.MavenStructuredFrameworkDesign.ExcelDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDriven {
	
    @DataProvider
	public Object[] ExcelDriveData() throws IOException
	{
    File f= new File("./Excel\\TestRecord.xlsx");
    FileInputStream fis= new FileInputStream(f);
    
    ArrayList<String> a= new ArrayList<String>();
 
    XSSFWorkbook wb =new XSSFWorkbook(fis);
   // int sheets = wb.getNumberOfSheets();
    
    int seet = wb.getNumberOfSheets();
    for(int i=0;i<seet;i++)
    {
    	if(wb.getSheetName(i).equalsIgnoreCase("Dept"))
    	{
    		XSSFSheet sheet = wb.getSheetAt(i);
    		Iterator<Row> rows=sheet.iterator();
			Row firstRow=rows.next();
			Iterator<Cell> ce=firstRow.cellIterator();//row is collection of cells
			int k=0;
			int column=0;
			while(ce.hasNext())
			{
			
				Cell  value=ce.next();
				if(value.getStringCellValue().equalsIgnoreCase("LOC"))
				{
					
					column=k;
			    }
				k++;
			
		}
			System.out.println(column);
			
			while(rows.hasNext())
			{
				 Row r = rows.next();
				 if(r.getCell(column).getStringCellValue().equalsIgnoreCase("LOC"))
				 {
					Iterator<Cell> cv = r.cellIterator();
					 while(cv.hasNext())
					 {
						 Cell c = cv.next();
						
						 if(c.getCellType()==CellType.STRING)
						 {
						 a.add(cv.next().getStringCellValue());
						 }
						 else
						 {
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							
						 }
					 }
				 }
			}
    	}
    	
    	
    	
    }
	return  new Object[] {a};
	}
    
	
    
	@Test(dataProvider= "ExcelDriveData")
	public void getDataFromExcel(ArrayList<String> input1)
	{
		System.out.println(input1 );
	}
}
    
			


