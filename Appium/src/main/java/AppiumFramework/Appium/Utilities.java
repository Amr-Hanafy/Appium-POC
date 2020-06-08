package AppiumFramework.Appium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {

	 static AndroidDriver<AndroidElement> driver;
	
	public Utilities (AndroidDriver<AndroidElement> driver)
	
	{
		Utilities.driver = driver;
	}
	
	public void scrolltoText(String text)
	
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}
	
    public void hideKeyboard()
	
	{
		driver.hideKeyboard();
	}
    
    

	public static void getScreenShot(String testName) throws IOException {
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File (System.getProperty("user.dir")+"\\src\\main\\java\\screenShots\\"+testName+".png"));
    }
}

