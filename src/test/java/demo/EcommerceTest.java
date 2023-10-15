package demo;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class EcommerceTest {
	
  AndroidDriver driver;

  @BeforeClass
  public void LaunchAppTC_001() throws MalformedURLException {
	  
	  DesiredCapabilities  dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.solodroid.solomerce");
		dc.setCapability("appActivity", ".activities.ActivitySplash");
		dc.setCapability("deviceName", "Samsung");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "13");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
	  
  	}
  
  @Test(priority = 1)
  public void SelectProfileTC_002() {
  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.findElement(By.id("com.solodroid.solomerce:id/nav_profile")).click();
	 // driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='Profile']")).click();
	  driver.runAppInBackground(Duration.ofSeconds(10));
	  driver.lockDevice();
  	}
  
  
 // @Test(priority = 2)
  public void SearchProductTC_003() {
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  driver.findElement(By.id("com.solodroid.solomerce:id/search")).click();
	  driver.findElement(By.id("com.solodroid.solomerce:id/search_src_text")).sendKeys("watch");
	  driver.hideKeyboard();
	  driver.rotate(ScreenOrientation.LANDSCAPE);
	  driver.rotate(ScreenOrientation.PORTRAIT);
	  
//	  driver.lockDevice();

	 }

  
 // @Test 
  public void SelectCategoryTC_004() throws InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  WebElement category =  driver.findElement(By.id("com.solodroid.solomerce:id/nav_category"));
	  Point categotysize = category.getLocation();
	  
		System.out.println(categotysize.x);
		System.out.println(categotysize.y); 
		
		TouchAction action = new TouchAction<>(driver);
		action.tap(PointOption.point(categotysize.x, categotysize.y)).perform();
	//	driver.lockDevice();
	//	Thread.sleep(5000);
	  
	}
   @Test (priority = 4)
   public void UnlockDeviceTC_005() {
	   
	   DesiredCapabilities  dc = new DesiredCapabilities();
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   dc.setCapability("unlockType", "pin");		
	   dc.setCapability("unlockKey", "17293");
   }
   
 // @Test 
  public void SwipeActionTC_006() throws InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  WebElement search = driver.findElement(By.id("com.solodroid.solomerce:id/search"));
	  
	  TouchAction  swipeAction = new TouchAction<>(driver);
	  swipeAction.press(PointOption.point( 900, 1800)).waitAction().moveTo(PointOption.point(70, 1800)).release().perform();
	  Thread.sleep(5000);
	  swipeAction.press(PointOption.point(70, 1800)).waitAction().moveTo(PointOption.point( 900, 1800)).release().perform();
	  
	/*  while(true) {
		 swipeAction.press(PointOption.point( 655, 1100)).waitAction().moveTo(PointOption.point(655, 200)).release().perform();
		   if(driver.findElement(By.id("Money Counter")).isDisplayed()) {
			   break;
		   }
		  }*/
	  }
	  
//	@Test
	public void ScrollActionTC_007() {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	  		driver.findElementByAndroidUIAutomator(
	  				
	  		"new UiScrollable(new UiSelector()"
			 + ".resourceId(\"com.solodroid.solomerce:id/viewpager\"))"
			 + ".scrollForward().scrollIntoView(new UiSelector()"
			 + ".textContains(\"Money Counter Kozure MC-101\"))");
	  		
	  	WebElement moneyCounter = driver.findElementByAndroidUIAutomator("new UiSelector()"
	 	+ ".textContains(\"Money Counter Kozure MC-101\")");
	  	moneyCounter.click();
			 
	 //  com.solodroid.solomerce:id/viewpager
	//  Money Counter Kozure MC-101
	  
  
	  
  }
	  
  }
   
   
   
   
   
//	@AfterTest
//	public void removeDriver() {
	//	driver.close();
		
//	}
  
  
