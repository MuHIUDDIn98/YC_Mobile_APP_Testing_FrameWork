package MobileAppTestingFrameWorkAndroid;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AndroidGestureActionsUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppDashBoard extends AndroidActions {
	
		AndroidDriver driver;
		
	public AppDashBoard(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.ImageView[1]")
	private WebElement profileEdit;
	
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(1)")
	private WebElement yourOffer;
	
	public void ClickYourOffer() {
		yourOffer.click();
	}
	
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(2)")
	private WebElement yourShop;
	
	public void ClickYourShop() {
		yourShop.click();
	}
	
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(3)")
	private WebElement yourLaundry;
	public void ClickYourLaundry() {
		yourLaundry.click();
	}
	
	
	@AndroidFindBy(accessibility="Your Credit")
	private WebElement yourCredit;
	
	
	@AndroidFindBy(xpath="//android.view.View[contains(@content-desc, 'Your current credit')]")
	private WebElement yourCurrentCredit;
	
	public double getCurrentCredit() throws InterruptedException {
		yourCredit.click();
		yourCurrentCredit.click();
		String contentDes = yourCurrentCredit.getAttribute("contentDescription");
		String[] parts = contentDes.split("\n");
		String decimalPart = parts[1];
		double decimalNumber = Double.parseDouble(decimalPart);
//		System.out.println(contentDes);
		
		
		return decimalNumber;
		
	}
	
	
	public double getAfterPaymentCurrentCredit() throws InterruptedException {
		yourCurrentCredit.click();
		String contentDes = yourCurrentCredit.getAttribute("contentDescription");
		String[] parts = contentDes.split("\n");
		String decimalPart = parts[1];
		double decimalNumber = Double.parseDouble(decimalPart);
//		System.out.println(contentDes);
		
		
		return decimalNumber;
		
	}
	
	
	@AndroidFindBy(accessibility="Penalty")
	private WebElement penalty;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@content-desc, 'Penalty')]")
	private WebElement yourCurrentPenalty;
	
	public double getCurrentPenalty() {
		penalty.click();
		yourCurrentPenalty.click();
		String contentDes = yourCurrentPenalty.getAttribute("contentDescription");
		String[] parts = contentDes.split("\n");
		String decimalPart = parts[1];
		double decimalNumber = Double.parseDouble(decimalPart);
//		System.out.println(contentDes);
		
		
		return decimalNumber;
		
	}
	
	
	@AndroidFindBy(accessibility="Credit Statement")
	private WebElement creditStatement;
	
	
	
	@AndroidFindBy(accessibility="Add Credit")
	private WebElement addCredit;
	
	
	public void clickAddCredit() {
		
		addCredit.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
