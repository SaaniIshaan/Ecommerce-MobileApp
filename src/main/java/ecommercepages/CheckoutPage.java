package ecommercepages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import constants.WaitConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {
AppiumDriver driver;
	
	public CheckoutPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		this.driver = driver;
	}
	@AndroidFindBy(id="com.solodroid.solomerce:id/nav_category")
	public MobileElement categoryBtn;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/category_name")
	public MobileElement electronicsTab;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/category_image")
	public WebElement samsungMobile;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/btn_add_cart")
	public WebElement addTocartBtn;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/userInputDialog")
	public MobileElement numberOfOrders;
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement addBtn;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/cart")
	public MobileElement addedCart;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/product_name")
	public MobileElement addedProduct;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/btn_checkout")
	public MobileElement checkout;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/edt_name")
	public MobileElement yourname;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/edt_email")
	public MobileElement yourEmail;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/edt_phone")
	public MobileElement yourphone;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/edt_address")
	public MobileElement yourAddress;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/spinner")
	public MobileElement shipping;
	
	@AndroidFindBy(id="android:id/text1")
	public List<MobileElement> shippingOptions;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/btn_submit_order")
	public MobileElement processCheckout;
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement confirmCheckout;
	
	@AndroidFindBy(id="android:id/alertTitle")
	public MobileElement congratsPopup;
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement okCongrats;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/edt_comment")
	public MobileElement comment;
	
	
	public void clickonCategory() {
		categoryBtn.click();
	}
	public void selectElectronicsandGadgets() {
		WaitConstants.waitForElement(driver);
		electronicsTab.click();
	}
	public void selectSamsungPhone() {
		if(samsungMobile.isDisplayed());
			samsungMobile.click();
	}
	public void clickAddToCart() {
		addTocartBtn.click();
	}
	public void sendNoOfOrders(String count) {
		numberOfOrders.sendKeys(count);
	}
	public void setAddtoCart() {
		addBtn.click();
	}
	public void clickOnCart(){
		WaitConstants.waitForElement(driver);
		addedCart.click();
	}
	public String getCartText() {
		return addedProduct.getText();
	}
	String expected = "Samsung Galaxy S10 - Black";
	
	public void checkOut() {
		WaitConstants.waitForElement(driver);
		checkout.click();
	}
	public void enterName(String name) {
		yourname.click();
		yourname.sendKeys("Monika Gupta");
	}
	public void enterEmailId(String email) {
		yourEmail.click();
		yourEmail.clear();
		yourEmail.sendKeys("mansi@hon.com");
	}
	public void enterPhoneNumber(String number) {
		yourphone.click();
		yourphone.clear();
		yourphone.sendKeys("3109363288");
	}
	public void enterValidAddress(String address) {
		yourAddress.click();
		yourAddress.clear();
		yourAddress.sendKeys("3649,garnet st,apt 254");
	}
	public void clickDropDown() {
		shipping.click();
	}
	public void selectShippingOption(String paymentChoice) {
		for(MobileElement shippingOpt : shippingOptions) {
			if(shippingOpt.getText().equals(paymentChoice)) {
				shippingOpt.click();
				break;
			}
		}
	}
	public void giveComment(String commentMsg) {
		comment.click();
		comment.sendKeys(commentMsg);
	}
	public void clickOnCheckout() {
		processCheckout.click();
	}
	public void clickCofirmCheckout() {
		confirmCheckout.click();
	}
	public String getCongratsMsg() {
		return congratsPopup.getText();
	}
	 String Expected = "Please wait";
	 
	public void clickOnCongrats() {
		WaitConstants.waitForElement(driver);
		okCongrats.click();
	}
	
}