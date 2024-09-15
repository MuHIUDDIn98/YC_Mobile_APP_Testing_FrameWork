package AndroidPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AllCommonUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddCreditPaymentPage extends AndroidActions{

	public AddCreditPaymentPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.EditText[1]")
	private WebElement EnterAmount;
	public void setAmount(String Amount) {
		EnterAmount.click();
		EnterAmount.sendKeys(Amount);
	}
	
	@AndroidFindBy(xpath="//android.view.View[9]")
	private WebElement displayEnterdAmount;
	
	public double getDisplayedEnteredAmount() {
		String DEA = displayEnterdAmount.getAttribute("contentDescription");
		String[] parts = DEA.split(" ");
		String numberPart = parts[0];
		double doubleValue = Double.parseDouble(numberPart);
		
		return doubleValue;
	}
	
	@AndroidFindBy(xpath="//android.view.View[10]")
	private WebElement displayPenalty;
	
	public double getDisplayedPanelty() {
		String DP = displayPenalty.getAttribute("contentDescription");
		String[] parts = DP.split(" ");
		String numberPart = parts[0];
		double doubleValue = Double.parseDouble(numberPart);
		
		return doubleValue;
		
	}
	
	@AndroidFindBy(xpath="//android.view.View[11]")
	private WebElement TotalDisplayedAmount;
	
	public double getTotalDisplayedAmount() {
		String DT = TotalDisplayedAmount.getAttribute("contentDescription");
		String[] parts = DT.split(" ");
		String numberPart = parts[0];
		double doubleValue = Double.parseDouble(numberPart);
		
		return doubleValue;
		
	}
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Others\"]")
	public WebElement Others;
	
	public void clickOthers() {
		
		Others.click();
	}
	
	
	@AndroidFindBy(accessibility="Amar Pay")
	private WebElement amarPay;
	public void clickAmarPay() {
		
		amarPay.click();
	}
	
	
	@AndroidFindBy(accessibility="bKash")
	private WebElement bKash;
	
	
	@AndroidFindBy(accessibility="Nagad")
	private WebElement Nagad;
	
	@AndroidFindBy(accessibility="Add Credit")
	private WebElement addCredit;
	
	public void clickAddCreditButton() {
			
			addCredit.click();
	}
	
	
	@AndroidFindBy(xpath="//android.widget.Image[@text=\"mastercard\"]")
	private WebElement masterCard;
	
	public void clickMasterCard() {
		
		masterCard.click();
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Success']")
	private WebElement successButton;
	
	public void clickSuccess() {
		successButton.click();
	}
	
	
	@AndroidFindBy(accessibility="Ok")
	private WebElement successOkButton;
	
	public void clickOkSuccess() {
		successOkButton.click();
	}
	
	

}
