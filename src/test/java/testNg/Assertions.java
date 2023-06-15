package testNg;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {

	@Test
public void m1()
{
		Assert.assertEquals(true, true);
		Assert.assertSame(getClass(), getClass());
		Assert.fail("Hah hah hah failed");
		SoftAssert sf= new SoftAssert();
		sf.assertEquals(false, true);
System.out.println("hello");	

sf.assertAll();
}
	

}
