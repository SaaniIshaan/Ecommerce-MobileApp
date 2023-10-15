package ecommercetest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.WaitConstants;
import ecommercepages.HomePage;
import io.appium.java_client.AppiumDriver;
import listeners.CommonListeners;


@Listeners(CommonListeners.class)
public class EcommerceTest extends BaseTest{
	
	@BeforeClass
	public void Launch() throws MalformedURLException {
		
		launchApp();
		BaseTest.logger.info("App is launched");
	}
	

	@Test(priority = 3)
	public void selectProfileTC_01() {
		
		AppiumDriver driver = BaseTest.getDriver();
		HomePage homepage = new HomePage(driver);
		WaitConstants.waitForElement(driver);
		homepage.selectProfile();
		logger.info("select profile successful");
		
	}		
	 
	
	@Test(priority = 1)
	public void searchItemTC_02() {

		AppiumDriver driver = BaseTest.getDriver();
		HomePage homepage = new HomePage(driver);
		WaitConstants.waitForElement(driver);
		homepage.searchItem();
		logger.info("Item is selected");
	}

		
	@Test(priority = 3)
	public void rotateScreenTC_04() {
		
		AppiumDriver driver = BaseTest.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.rotateScreen();
	}
	
	
}
