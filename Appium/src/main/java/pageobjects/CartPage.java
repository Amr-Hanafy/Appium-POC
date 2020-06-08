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

	public double Calculate_items_amount() {
		int cartElement = productpriceList.size();
		double sum = 0;
		for (int i = 0; i < cartElement; i++) {
			String Samount = productpriceList.get(i).getText();
			double Famount = getamount(Samount);
			sum = sum + Famount;
		}
		return sum;

	}

	public static double getamount(String amount) {
		amount = amount.substring(1);
		double Namount = Double.parseDouble(amount);
		return Namount;

	}

}
