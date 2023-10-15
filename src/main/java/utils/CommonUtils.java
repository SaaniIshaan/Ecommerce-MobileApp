package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import constants.FileConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CommonUtils {
	
	public static String getStringDateAndTimeStamp() {
		String value = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		return value;
	}
	
	public static String getScreenshot(AppiumDriver driver) throws IOException {
		
		String path = FileConstants.SCREEN_SHOT_PATH;
		TakesScreenshot screen = (TakesScreenshot)driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(src, destination);
		
		return path;
	}
	
	

		
		
	
	
}