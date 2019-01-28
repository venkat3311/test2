package abcpack;

import org.testng.annotations.Test;

public class EnabledTest {
	
	@Test
	public void meth1()
	{
		System.out.println("@Test1");
	}
	@Test
	public void meth2()
	{
		System.out.println("@Test2");
	}
	@Test(enabled=false)
	public void meth3()
	{
		System.out.println("@Test3");
	}
	@Test
	public void meth4()
	{
		System.out.println("@Test4");
	}

}
