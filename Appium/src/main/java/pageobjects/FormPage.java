package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.Log;

public class FormPage {

	public FormPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(xpath = "//*[@text='Female']")
	private WebElement genderOption;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryDropdown;

	@AndroidFindBy(xpath = "//*[@text='Argentina']")
	private WebElement countrySelect;

	// driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopBtn;
	

	public void Enter_userName(String name) 
	{
		Log.info("Enter User Name " + name);
		nameField.sendKeys(name);
	}

	public void Select_Femalegender() {
		Log.info("Select a female gender");
		genderOption.click();
	}

	public void Click_countryddown() {
		countryDropdown.click();
	}

	public void Select_country() {
		countrySelect.click();
	}

	public void Click_shoppingbtn() {
		shopBtn.click();
	}
}
