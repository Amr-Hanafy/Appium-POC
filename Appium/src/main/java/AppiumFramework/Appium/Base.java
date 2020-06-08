package AppiumFramework.Appium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static AndroidDriver<AndroidElement> setup() throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\AppiumFramework\\Appium\\Global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String device = prop.getProperty("Device");
		System.out.println(device);
		String App = prop.getProperty("Application");
		System.out.println(App);

		File APP_Location = new File("src", App);
		URL Appium_Server = new URL("http://127.0.0.1:4723/wd/hub");

		DesiredCapabilities cap = new DesiredCapabilities();
		if (device.contains("AmrE")) {
			System.out.println(device + "Invocking the Emulator");
			startEmulator();
		}
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.APP, APP_Location.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(Appium_Server, cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public static void startEmulator() throws IOException, InterruptedException {
		System.out.println(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\startEmulator.bat");
		// Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}

}
