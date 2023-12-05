package ExtentReport;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UseDataProvider {

	@DataProvider
	 public Object[][] getData()
	{
		return new Object[][] {{"test1", "ravi"},{"test2", "subhi"}};
	}
	
	
	@Test(dataProvider="getData")
	public void TestCase(String username, String pwd)
	{
		System.out.println(username + pwd);
	}
}
