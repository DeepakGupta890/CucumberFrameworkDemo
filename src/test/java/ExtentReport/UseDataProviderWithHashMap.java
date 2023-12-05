package ExtentReport;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UseDataProviderWithHashMap {
	
	@Test(dataProvider="getData")
	public void TestCase(HashMap<String, String> input)
	{
		System.out.println(input.get("username") + ": "+input.get("pwd"));
	 
	}
	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<String,String> map= new HashMap<String,String>();
		map.put("username", "Test1");
		map.put("pwd", "Shubhi");
		HashMap<String,String> map1= new HashMap<String,String>();
		map1.put("username", "Test2");
		map1.put("pwd", "rubhi");
		return  new Object[][] {{map},{map1}};
		
	}

}
