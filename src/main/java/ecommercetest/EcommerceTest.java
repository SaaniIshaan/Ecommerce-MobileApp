package ecommercetest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.WaitConstants;
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
	
	@Test 
	  public void SelectCategoryTC_05() throws InterruptedException {
		  
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		  WebElement category =  driver.findElement(By.id("com.solodroid.solomerce:id/nav_category"));
		  Point categotysize = category.getLocation();
		  
			System.out.println(categotysize.x);
			System.out.println(categotysize.y); 
			
			TouchAction action = new TouchAction<>(driver);
			action.tap(PointOption.point(categotysize.x, categotysize.y)).perform();
	}
	
	 @Test 
	  public void SwipeActionTC_06() throws InterruptedException {
		  
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  WebElement search = driver.findElement(By.id("com.solodroid.solomerce:id/search"));
		  
		  TouchAction  swipeAction = new TouchAction<>(driver);
		  swipeAction.press(PointOption.point( 900, 1800)).waitAction().moveTo(PointOption.point(70, 1800)).release().perform();
		  Thread.sleep(5000);
		  swipeAction.press(PointOption.point(70, 1800)).waitAction().moveTo(PointOption.point( 900, 1800)).release().perform();
		  
	 }
}	
	
