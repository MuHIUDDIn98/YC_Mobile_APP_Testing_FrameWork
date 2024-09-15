package AndroidPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AllCommonUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class WelcomePage extends AndroidActions{
	
	AndroidDriver driver;
	public WelcomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//WebElement SkipButton = driver.findElement(AppiumBy.accessibilityId("Skip"));
	@AndroidFindBy(accessibility ="Skip")
	private WebElement SkipButton;
	
	@AndroidFindBy(accessibility  ="Next")
	private WebElement NextButton;
	//WebElement NextButton = driver.findElement(AppiumBy.accessibilityId("Next"));
	
	@AndroidFindBy(accessibility ="Enter")
	private WebElement EnterButton;
	//WebElement EnterButton = driver.findElement(AppiumBy.accessibilityId("Enter"));
	
	
	
	public void ClickNext() {
		
		NextButton.click();
	}
	public void ClickEnter() {
		
		EnterButton.click();
	}
	
	public void ClickSkip() {
		
		SkipButton.click();
	}

}
