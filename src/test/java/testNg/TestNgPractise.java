package testNg;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNgPractise {
	
	@Test (priority =1,invocationCount=3)
	public void m1()
	{
		System.out.println("Excueted m1");
	}

	@Test (priority =2)
	public void m2()
	{
		Assert.fail();
		System.out.println("Excueted m2 ");
	}

	@Test (dependsOnMethods = "m2")
	public void m3()
	{
		System.out.println("Excueted m3");
	}

}
