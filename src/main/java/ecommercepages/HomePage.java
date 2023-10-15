package ecommercepages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.WaitConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	AppiumDriver driver;
	
	public HomePage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		this.driver = driver;
	}
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/nav_profile")
	public MobileElement profileBtn;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/txt_user_name")
	public MobileElement yourName;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/btn_edit_user")
	public MobileElement editBtn;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/search")
	public MobileElement searchBtn;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/search_src_text")
	public WebElement searchText;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/category_image")
	public WebElement appleWatch;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/btn_add_cart")
	public WebElement addTocartBtn;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/dialogTitle")
	public MobileElement numberOfOrder;
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement addBtn;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/cart")
	public MobileElement addTocartBox;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/product_name")
	public MobileElement addedProduct;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/btn_checkout")
	public MobileElement checkout;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/edt_name")
	public MobileElement yourname;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/edt_email")
	public MobileElement yourEmail;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/edt_phone")
	public MobileElement phone;
	
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
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/nav_category")
	public MobileElement categoryBtn;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/nav_recent")
	public MobileElement recentBtn;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/recycler_view")
	public MobileElement recentPage;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/toolbar")
	public MobileElement categoryPage;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/category_name")
	public MobileElement homeAndfurnitureTab;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/toolbar")
	public MobileElement homeandfurniturePage;
	
	
	
	public void selectProfile() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		profileBtn.click();
		WaitConstants.waitForElement(driver);
		if(yourName.isDisplayed()) {
			editBtn.click();
		}
	 }

	public void searchItem() {
		if(searchBtn.isDisplayed()) {
			searchBtn.click();
			WaitConstants.waitForElement(driver);
			searchText.sendKeys("Watch");
			driver.hideKeyboard();
	}
		
	}	
	public void rotateScreen() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
		WaitConstants.waitForElement(driver);
		driver.rotate(ScreenOrientation.PORTRAIT);
	}
	
	/* public void itemAddedintheCart() {
		   WaitConstants.waitForElement(driver);
		   if(appleWatch.isDisplayed()) {
		   addTocartBtn.click();
		   }
		   numberOfOrder.sendKeys("1");
		   addBtn.click();
		   WaitConstants.waitForElement(driver);
		   addTocartBox.click();
		   
	  }*/
	   
	
	
	
	public void clickAddToCart() {
		addTocartBtn.click();
	}
	public void sendOrders(String count) {
		numberOfOrder.sendKeys(count);
	}
	public void addToCart() {
		addBtn.click();
	}
	public void clickOnCart() {
		addTocartBox.click();
	}
	public String getCartText() {
		return addedProduct.getText();
	}
	public void checkOut() {
		checkout.click();
	}
	
	
	
	
/*	public boolean verifyproductintheCart() {
		boolean isproductVerified = false;
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		if(addTocartBox.isDisplayed()) {
			addTocartBox.click();
		}
		if(addedProduct.isDisplayed()) {
			isproductVerified = true;
		}
		
		return isproductVerified;
		
		
		}*/
	
	
	}
