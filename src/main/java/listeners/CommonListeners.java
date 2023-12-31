package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import ecommercetest.BaseTest;
import utils.CommonUtils;

	public class CommonListeners extends BaseTest implements ITestListener {
	@Override
	public void onTestSuccess(ITestResult result) {
	BaseTest.test.pass(result.getName()+"Test Passed");
	}
	public void onTestFailure(ITestResult result) {
		BaseTest.test.fail(result.getName()+"Test Failed");
		try {
			BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(BaseTest.getDriver()));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
