package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class LaunchApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

	// 	com.solodroid.solomerce
	//	.activities.ActivitySplash or .activities.MainActivity
		
	//  Desired capabilities	
		
		DesiredCapabilities  dc = new DesiredCapabilities();
		
		dc.setCapability("appPackage", "com.solodroid.solomerce");
		dc.setCapability("appActivity", ".activities.ActivitySplash");
		dc.setCapability("deviceName", "Samsung");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "13");
		dc.setCapability("unlockType", "pin");		
		dc.setCapability("unlockKey", "17293");
		
		
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("com.solodroid.solomerce:id/nav_profile")).click();
		
	//	driver.findElement(By.id("com.solodroid.solomerce:id/search")).click();
	//	driver.findElement(By.id("com.solodroid.solomerce:id/search_src_text")).sendKeys("watch");
	//	driver.hideKeyboard();
	//	Thread.sleep(3000);
	//	driver.rotate(ScreenOrientation.LANDSCAPE);
	//	driver.runAppInBackground(Duration.ofSeconds(10));
	//	driver.rotate(ScreenOrientation.PORTRAIT);
		
	//	if(driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)) {
			//		driver.rotate(ScreenOrientation.PORTRAIT);
			//	}
		
		
	//	WebElement category = driver.findElement(By.id("com.solodroid.solomerce:id/nav_category"));
	//	Point categorysize =  category.getLocation();
	//	System.out.println(categorysize.x);
	//	System.out.println(categorysize.y); 
		
	//	TouchAction action = new TouchAction<>(driver);
	//	action.tap(PointOption.point(categorysize.x,categorysize.y)).perform();
		
		
	//	Activity calci = new Activity("com.sec.android.app.popupcalculator",".Calculator");
	//	driver.startActivity(calci);
	//	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		System.out.println("Finished");
		driver.lockDevice();
		Thread.sleep(5000);
		driver.unlockDevice();
		Thread.sleep(3000);
		
	
	
	MultiTouchAction  action = new MultiTouchAction(driver) ;
		
	TouchAction touch1 = new TouchAction<>(driver);
	TouchAction touch2 = new TouchAction<>(driver);
	touch1.press(PointOption.point(0,0)).waitAction().moveTo(PointOption.point(0,0)).perform();
	touch2.press(PointOption.point(0,0)).waitAction().moveTo(PointOption.point(0,0)).perform();
	
	action.add(touch1).add(touch2).perform();
	}
}
