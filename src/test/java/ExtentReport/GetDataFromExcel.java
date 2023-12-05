package ExtentReport;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetDataFromExcel {
	@DataProvider
	public Object[] getData() throws IOException
	{
		FileInputStream fs= new FileInputStream("C:\\Users\\hp\\OneDrive\\Desktop\\TestRecord.xlsx");
		ArrayList<String> al= new ArrayList();
		DataFormatter formatter= new DataFormatter();
		XSSFWorkbook workbook= new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFRow firstRow = sheet.getRow(0);
		Iterator<Cell> ce = firstRow.cellIterator();
		int cellCount=firstRow.getLastCellNum();
		while(ce.hasNext())
			
		{
			Cell cellValue=ce.next();
			
			al.add(formatter.formatCellValue(cellValue));
			
		}
		
		return new Object[] {al};
		
		
		
	}
	@Test(dataProvider="getData")
	public void TestCase( ArrayList<String> input)
	{
		System.out.println(input);
	}
	@Test
	public void getData1() throws IOException
	{
		FileInputStream fs= new FileInputStream("C:\\Users\\hp\\OneDrive\\Desktop\\TestRecord.xlsx");
		
		DataFormatter formatter= new DataFormatter();
		XSSFWorkbook workbook= new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFRow thirdRow = sheet.getRow(2);
		Iterator<Cell> ce = thirdRow.cellIterator();
		int cellCount=thirdRow.getLastCellNum();
		System.out.println(formatter.formatCellValue(thirdRow.getCell(0)));
		System.out.println(formatter.formatCellValue(thirdRow.getCell(1)));
		System.out.println(formatter.formatCellValue(thirdRow.getCell(2)));
		System.out.println(formatter.formatCellValue(thirdRow.getCell(3)));
		System.out.println(formatter.formatCellValue(thirdRow.getCell(4)));
		System.out.println(formatter.formatCellValue(thirdRow.getCell(5)));
		
		
	}
}
