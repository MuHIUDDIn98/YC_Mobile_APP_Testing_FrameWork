package AndroidPageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import AllCommonUtils.AndroidActions;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class LoginPage extends AndroidActions {
	
	AndroidDriver driver;
	public LoginPage(AndroidDriver driver) {
		
		//pass driver to the action class
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//WebElement SkipButton = driver.findElement(AppiumBy.accessibilityId("Skip"));
	@AndroidFindBy(accessibility ="Skip")
	private WebElement SkipButton;
	
	
	@AndroidFindBy(xpath ="//android.widget.EditText[1]")
	private WebElement UserNumberField;
	
	
	@AndroidFindBy(xpath ="//android.widget.EditText[2]")
	private WebElement UserPasswordField;
	
	@AndroidFindBy(xpath ="//android.widget.Button[@content-desc=\"LOG IN\"]")
	private WebElement LoginButton;
	
	
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Incorrect Mobile Number OR PIN\"]")
	private WebElement IncorrectPinOrPasswordtoast;
	
	@AndroidFindBy(accessibility="Please enter mobile number")
	private WebElement NumberCorrectionMsg;
	
	
	@AndroidFindBy(accessibility="Please enter PIN number")
	private WebElement PasswordCorrectionMsg;
	
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"Allow\"]")
	private WebElement NotificationAllow;
	
	
	@AndroidFindBy(xpath="//android.widget.Button")
	private WebElement bannerImageCrossButton;
	
	
	
	public void setActiivity() {
	startActivity("com.mnt.your_campus/com.mnt.your_campus.MainActivity");
	}
	//"com.mnt.your_campus/com.mnt.your_campus.MainActivity"
	
	
	
	
	
	
	
	public void ClickSkip() {
			
			SkipButton.click();
		}
	
	
	public void clickNumberField() {
		UserNumberField.click();
	}
	
	public void clearNumberField() {
		
		UserNumberField.clear();
	}
	
	
	
	
	
	public void clickPasswordField() {
		UserPasswordField.click();
	}
	public void clearPasswordField() {
		UserPasswordField.clear();
	}
	
	
	
	public void clickLoginButton() {
		LoginButton.click();
	}
	
	
	public void clickNotificationAllow() {
		NotificationAllow.click();
	}
	
	
	public void clickBannerImageCrossButton() {
		
		bannerImageCrossButton.click();
		
	}
	
	
	
	public void setNumber(String number) {
		
		UserNumberField.sendKeys(number);
		driver.hideKeyboard();
	}
	
	public void setPassword(String number) {
			
			UserPasswordField.sendKeys(number);
			driver.hideKeyboard();
		}


	public String  getToastIncorrectPinOrNumberMsg() {
		String contentDescription = IncorrectPinOrPasswordtoast.getAttribute("contentDescription");
		//System.out.println(contentDescription);
		
		return contentDescription;
		
	}
	
	
	public String  getToastIncorrectNumberMsg() {
		String contentDescription = NumberCorrectionMsg.getAttribute("contentDescription");
		//System.out.println(contentDescription);
		
		return contentDescription;
		
	}
	
	
	public String  getToastIncorrectPinMsg() {
		String contentDescription = PasswordCorrectionMsg.getAttribute("contentDescription");
		//System.out.println(contentDescription);
		
		return contentDescription;
		
	}
	
	
	



}
