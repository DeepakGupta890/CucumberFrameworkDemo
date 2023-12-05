package framework.MavenStructuredFrameworkDesign.ExcelDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadHeader {
	static String  vlue;
	DataFormatter formatter= new DataFormatter();
	@Test
	public void getData() throws IOException
	{
		File f= new File("C:\\Users\\hp\\OneDrive\\Desktop\\TestRecord.xlsx");
	    FileInputStream fis= new FileInputStream(f);
	   
	    XSSFWorkbook wb= new XSSFWorkbook(fis);
	    XSSFSheet sheet=wb.getSheetAt(0);
	    XSSFRow firstRow = sheet.getRow(0);
	    int Coumn = firstRow.getLastCellNum();
	    int rowCount = sheet.getPhysicalNumberOfRows();
	    for(int i=0;i<=rowCount-1;i++)
	    {
	    	 XSSFRow row = sheet.getRow(i);
	    	for(int j=0;j<=Coumn-1;j++)
	    	{
	    		XSSFCell colm = row.getCell(j);
	    		//XSSFCell valueCol=colm;
	    		vlue=colm.getStringCellValue();
	    	    ArrayList<String> a= new ArrayList<String>();
	    	    
	    		//a.add(colm.getStringCellValue());	
	    			for(int k=0; k<Coumn;k++){
	    				a.add(vlue);
						
	    		System.out.println(a.get(0).toString());
	    	}
	    }
	    
	}
	}}
	   
