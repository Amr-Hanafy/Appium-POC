package AppiumFramework.Appium;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="InputData")
	public Object[][] getDataforformPage()
	{
		Object[][] obj = new Object[][]
				{
			{"Test1"} , {"Test2"}
				};
				
				return obj;
		
	}

}