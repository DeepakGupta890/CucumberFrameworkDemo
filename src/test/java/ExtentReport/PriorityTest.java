package ExtentReport;

import org.testng.annotations.Test;

public class PriorityTest {

	// first non priorities methods will executes and then priorities and priority 0 equivalent to non prioritized
	// if there is methods with same priority then execution will happen based on alphabetic order of method name.
	
	@Test
	public void m1()
	{
		System.out.println("m1 method executed");
	}
	
	@Test (priority=3)
	public void m2()
	{
		System.out.println("m2 method executed");
	}
	
	@Test(priority=0)
	public void m3()
	{
		System.out.println("m3 method executed");
	}
	
	@Test(priority=2)
	public void m4()
	{
		System.out.println("m4 method executed");
	}
	
	@Test
	public void m5()
	{
		System.out.println("m5 method executed");
	}
	
	@Test(priority=3)
	public void m6()
	{
		System.out.println("m6 method executed");
	}

}
