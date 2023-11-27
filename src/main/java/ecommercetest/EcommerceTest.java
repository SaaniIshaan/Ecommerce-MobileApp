package ecommercetest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.WaitConstants;
import ecommercepages.CheckoutPage;
import ecommercepages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import listeners.CommonListeners;


@Listeners(CommonListeners.class)
public class EcommerceTest extends BaseTest{
	
	@BeforeClass
	public void Launch() throws MalformedURLException {
		
		launchApp();
		BaseTest.logger.info("App is launched");
	}
	

//	@Test(priority = 3)
	public void selectProfileTC_01() {
		
		AppiumDriver driver = BaseTest.getDriver();
		HomePage homepage = new HomePage(driver);
		WaitConstants.waitForElement(driver);
		homepage.selectProfile();
		logger.info("select profile successful");
		
	}	
	
	// @Test(priority = 1)
	public void searchItemTC_02() {

		AppiumDriver driver = BaseTest.getDriver();
		HomePage homepage = new HomePage(driver);
		WaitConstants.waitForElement(driver);
		homepage.searchItem();
		logger.info("Item is selected");
	}
	 
//	 @Test(priority = 2)
	public void rotateScreenTC_04() {
		
		AppiumDriver driver = BaseTest.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.rotateScreen();
	}
	 @Test(priority = 0)
	 public void selectproduct() {
		 AppiumDriver driver = BaseTest.getDriver();
		 CheckoutPage checkoutpage = new CheckoutPage(driver);
		 checkoutpage.clickonCategory();
		 logger.info("category is clicked");
		 checkoutpage.selectElectronicsandGadgets();
		 logger.info("product is displayed");
		 checkoutpage.selectSamsungPhone();
		 logger.info("Samsung phone is selected");
		 checkoutpage.clickAddToCart();
		 logger.info("add to cartbtn is clicked ");
		 checkoutpage.sendNoOfOrders("1");
		 logger.info("1 item");
		 checkoutpage.setAddtoCart();
		 logger.info("one phone added to the cart");
		 checkoutpage.clickOnCart();
		 logger.info("clicked on cart");
		 Assert.assertEquals(checkoutpage.getCartText(),"Samsung Galaxy S10 - Black");
		 logger.info("added product in cart is verified");
		 checkoutpage.checkOut();
		 logger.info("checkout is clicked");
		 checkoutpage.enterName("Monika Gupta");
		 logger.info("entered name");
		 checkoutpage.enterEmailId("mansi@hon.com");
		 logger.info("entered email");
		 checkoutpage.enterPhoneNumber("3109363288");
		 logger.info("entered phoneNumber");
		 checkoutpage.enterValidAddress("3649,garnet st,apt 254");
		 logger.info("entered valid email");
		 HomePage.hideKeyBoard(driver);
		 logger.info("keyboard is hidden");
		 checkoutpage.clickDropDown(); 
		 logger.info("dropdown is displayed");
		 checkoutpage.selectShippingOption("FedEx");
		 logger.info("option is selected");
	//	 HomePage.hideKeyBoard(driver);
	//	 checkoutpage.giveComment("good");
		 checkoutpage.clickOnCheckout();
		 logger.info("checkout process started");
		 checkoutpage.clickCofirmCheckout();
		 logger.info("checkout confirmed");
		 Assert.assertEquals(checkoutpage.getCongratsMsg(),"Please wait");
		 logger.info("Assertion msg is successful");
		 checkoutpage.clickOnCongrats();
		 logger.info("congrats msg is accepted");
		 HomePage.hideKeyBoard(driver);
		 logger.info("keyboard is hidden");
	 
	 }
	 
	 
}	
	
