package framework.MavenStructuredFrameworkDesign.ExcelDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel {
	
	
	DataFormatter formatter= new DataFormatter(); // anytype data will convert into string from line no-48
	
	
	@Test(dataProvider="getData")
	public void testCaseData(Object[][] data1 )
	{
		System.out.println(data1 );
	} 
	
	
	@DataProvider 
	public Object[][] getData() throws IOException
	{
		 File f= new File("./Excel\\TestRecord.xlsx");
		    FileInputStream fis= new FileInputStream(f);
		  //  ArrayList<String> a= new ArrayList<String>();
		 
		    XSSFWorkbook wb =new XSSFWorkbook(fis);
		    XSSFSheet sheet = wb.getSheetAt(2);
		    int rowsCount = sheet.getPhysicalNumberOfRows();
		   XSSFRow row = sheet.getRow(0);
		   int columnCount = row.getLastCellNum();
		   Object data[][]=new Object[rowsCount-1][columnCount];
		   for(int i=0;i<rowsCount-1;i++)
		   {
			   row=sheet.getRow(i+1);
			   for(int j=0;j<columnCount;j++)
			   {
				   XSSFCell cell = row.getCell(j);
				  data[i][j] =formatter.formatCellValue(cell);
			   }
		   }
		   return data;
	}

}
