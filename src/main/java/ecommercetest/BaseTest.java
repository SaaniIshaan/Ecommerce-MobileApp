package ecommercetest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FileConstants;
import constants.VootConstants;
import io.appium.java_client.AppiumDriver;

public class BaseTest {

	public static AppiumDriver driver;

	static ExtentReports extent = new ExtentReports();
	static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;

	public static Logger logger = LogManager.getLogger(BaseTest.class.getName());

	DesiredCapabilities capabilities = new DesiredCapabilities();

	public  static void launchApp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appPackage", VootConstants.APP_PACKAGE);
		capabilities.setCapability("appActivity", VootConstants.APP_ACTIVITY);
		capabilities.setCapability("deviceName", VootConstants.DEVICE_NAME);
		capabilities.setCapability("platformName", VootConstants.PLATFORM_NAME);
		capabilities.setCapability("platformVersion", VootConstants.PLATFORM_VERSION);
	
		driver = new AppiumDriver(new URL(VootConstants.URL_HUB), capabilities);

		logger.info("App Launched");

	}

	@BeforeTest
	public static void setDriver() {
		spark = new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
		extent.attachReporter(spark);
		logger.info("BaseTest : setDriver : Spark report configured");
	}

	@BeforeMethod
	public static void setup(java.lang.reflect.Method name) {
		BaseTest.test = extent.createTest(name.getName());
		logger.info("BaseTest : setup :" + name.getName() + " Test Object for reporting is created");
	}

	@AfterMethod
	public static void tearDown(java.lang.reflect.Method name) {
		logger.info("BaseTest : tearDown :" + name.getName() + " Tear down called");
	}

	public static AppiumDriver getDriver() {
		return driver;
	}

	@AfterTest
	public static void removeDriver() {

		extent.flush();
		logger.info("BaseTest : remove Driver : removed driver");

	}

}
