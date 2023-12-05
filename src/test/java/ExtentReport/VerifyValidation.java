package ExtentReport;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyValidation {
	
	@Test
	public void verifyValidationTest()
	{
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertTrue(1==2);
		System.out.println("Failing 0");
		softAssert.fail("Failing first assertion");
		System.out.println("Failing 1");
		softAssert.fail("Failing second assertion");
		   System.out.println("Failing 2");
		   //Collates the assertion results and marks test as pass or fail
		   softAssert.assertAll();
	}
	
	@Test
	public void wotherMethods() {
		System.out.println("Other method executed");
	}


}
