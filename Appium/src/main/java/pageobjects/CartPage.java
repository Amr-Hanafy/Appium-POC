package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {

	public CartPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productpriceList;

	// Calculate the amount of the selected items in the cart
	public double Calculate_items_amount() {
		var productList = productpriceList;
		double sum = 0;
		for (WebElement productPrice: productList) {
			String Samount = productPrice.getText();
			double Famount = getamount(Samount);
			sum = sum + Famount;
		}
		return sum;

	}

	// This Method is used to Get the amount from string text and convert it to double (ex. $120 to 120)
	private static double getamount(String amount) {
		int beginIndex = 1;
		amount = amount.substring(beginIndex);
		double Namount = Double.parseDouble(amount);
		return Namount;

	}

}
