package abcpack;

import org.junit.jupiter.api.*;

public class JUnit5Annotations {
	
	@BeforeEach
	public void setUp()
	{
		System.out.println("@BeforeEach");
	}
	@AfterEach
	public void tearDown()
	{
		System.out.println("@AfterEach");
	}
	@BeforeAll
	public static void oneTimeSetUp()
	{
		System.out.println("@BeforeAll");
	}
	@AfterAll
	public static void oneTimeTearDown()
	{
		System.out.println("@AfterAll");
	}
	@DisplayName("Verify A test")
	@Test
	public void testA()
	{
		System.out.println("@Test1");
	}
	//@DisplayName("Verify B test")
	@Disabled
	@Test
	public void testB()
	{
		System.out.println("@Test2");
	}

}
