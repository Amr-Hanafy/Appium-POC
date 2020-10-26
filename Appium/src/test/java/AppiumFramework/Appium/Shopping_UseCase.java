package AppiumFramework.Appium;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageobjects.CartPage;
import pageobjects.FormPage;
import pageobjects.ShoppingPage;
import resources.Utilities;

public class Shopping_UseCase extends Base {

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {

		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(6000);

	}

	@Test(dataProvider = "InputData", dataProviderClass = TestData.class)
	public void TotalAmountValidation(String iName) throws IOException, InterruptedException {
		// Define the inputs
		String name = iName;
		String country = "Argentina";
		double expectedAmount = 280.97;
		//
		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {

			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}


		AndroidDriver<AndroidElement> driver = setup();

		// Initializing page objects
		Utilities utilities = new Utilities(driver);
		FormPage formPage = new FormPage(driver);
		ShoppingPage shoppingPage = new ShoppingPage(driver);
		CartPage cartPage = new CartPage(driver);

		/// The Test Case

		// 1- Enter the username value
		formPage.Enter_userName(name);
		utilities.hideKeyboard();

		// 2- Select a gender
		formPage.Select_Femalegender();

		// 3- Select a country
		formPage.Click_countryddown();
		utilities.scrolltoText(country);
		formPage.Select_country();

		// 4- Click on shopping button
		formPage.Click_shoppingbtn();

		// 5- Select Items
		shoppingPage.selectItems();

		// 6- Navigate to Cart
		shoppingPage.click_go_cart();

		Thread.sleep(4000);

		// 7- calculate the amount of items in the cart page
		double sum = cartPage.Calculate_items_amount();

		System.out.println("The Total amount is " + sum);

		// Finally validate the amount sum

		Assert.assertEquals(sum, expectedAmount);

		service.stop();

	}

}
