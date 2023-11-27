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
	
	public static void hideKeyBoard(AppiumDriver driver) {
		driver.hideKeyboard();
		
		}
	
	}
