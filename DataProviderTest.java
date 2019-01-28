package abcpack;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	static ExcelUtils excel;
	/*@DataProvider(name="Data")
	public static Object[] testParameterData(Method method) throws Exception
	{
		excel=new ExcelUtils("E:\\Selenium_Scripts_Aug18\\Test Data\\Login.xlsx","Sheet1"); 
		Object[] data=excel.getCellData(1, 0);
	    return data;
	}*/
	@Test(dataProvider ="Data")
	public void testLogin(String username,String password)throws Exception
	{
		System.out.println("User Name:"+username);
		System.out.println("Password:"+password);
		
	}

}
