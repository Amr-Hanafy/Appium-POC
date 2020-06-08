package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ShoppingPage {

	@AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
	private List<WebElement> items;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement addtocartbtn;

	public ShoppingPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void click_go_cart() {
		addtocartbtn.click();
	}

	public void selectItems() {
		items.get(0).click();
		items.get(0).click();

	}

}
