package ExtentReport;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionValidation {
	
	//Note- if validation fails perticular complete method execution stop and error appears but next method with run.
	
	@Test
	public void assertTest()
	{
		Assert.assertTrue(1+2==3);
		System.out.println("Passing 1");
		//Assert.assertFalse(2==2);
		Assert.assertTrue(1+2==4);
		System.out.println("Passing 2");
	}
	
	@Test
	public void otherMethods() {
		System.out.println("Other method executed");
	}

}
