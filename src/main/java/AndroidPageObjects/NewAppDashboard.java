package AndroidPageObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AllCommonUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewAppDashboard extends AndroidActions {

	public NewAppDashboard(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(0)")
	private WebElement BurgerMenu;
	
	
	
	@AndroidFindBy(accessibility="Dismiss")
	private WebElement BurgerMenuDissmiss;
	
	public void ClickBurgerMenu(){
		BurgerMenu.click();
	}
	
	
	public void ClickBurgerMenuDissmiss() {
		
		BurgerMenuDissmiss.click();
	}
	
	public void ScrollingTo(String action) {
		ScrollTo(action);
		
		
	}
		
		
	
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.View\").instance(5)")
	public WebElement Profile;
	public void ClickProfile() {
		Profile.click();
	}
	
	
	@AndroidFindBy(xpath="//android.view.View[contains(@content-desc,\"Hi,\")]")
	public WebElement WelcomeMsg;
	
	public String getWelcomeMsgUser() {
		String userName=null;
		
		String contentDes = WelcomeMsg.getAttribute("contentDescription");
		// Define a pattern to match the username part after "Hi,"
        Pattern pattern = Pattern.compile("Hi,\\s([A-Za-z]+\\s[A-Za-z]+)!");
        Matcher matcher = pattern.matcher(contentDes);

        if (matcher.find()) {
            // Extract the name (group 1)
            userName = matcher.group(1);
            System.out.println("Extracted user name: " + userName);
        } else {
            System.out.println("No user name found.");
        }
		
		return userName;
	}
	
	
	public boolean WelcomeMsgStringFormatValidator() {
		String contentDes = WelcomeMsg.getAttribute("contentDescription");
		 Pattern pattern = Pattern.compile("^Hi,\\s[A-Za-z]+\\s[A-Za-z]+!$");
	        Matcher matcher = pattern.matcher(contentDes);

	        if (matcher.matches()) {
	            System.out.println("Welcome msg String matches the required format!");
	            return true;
	        } else {
	            System.out.println("WelcomdeString does not match the format.");
	            return false;
	        }
		
	}
	
	
	@AndroidFindBy(xpath="//android.view.View[contains(@content-desc,\"Your credit score is\")]")
	public WebElement creditScoreSection;
	
	
	public void ClickViewMore() {
		creditScoreSection.click();
	}
	
	
	public double getCurrentCreditScore() {
		String scoreStr = null;
		double score = 0;
		String contentDes = creditScoreSection.getAttribute("contentDescription");
		Pattern pattern = Pattern.compile("\\b\\d+\\b");  // \b ensures we match whole numbers
        Matcher matcher = pattern.matcher(contentDes);
        
        if (matcher.find()) {
             scoreStr = matcher.group();
             score = Double.parseDouble(scoreStr);
            System.out.println("Your Dashboard credit score is: " + scoreStr);
        } else {
            System.out.println("Score not found.");
        }
        
        
        return score;	
	}
	
	
	@AndroidFindBy(accessibility="View All")
	public WebElement ViewAllService;
	
	
	
	
	
	@AndroidFindBy(accessibility="Your Credit")
	private WebElement yourCredit;
	
	
	@AndroidFindBy(xpath="//android.widget.ImageView[contains(@content-desc,\"Your Credit\")]")
	private WebElement yourCurrentCredit;
	
	public double getCurrentCredit() throws InterruptedException {
		String decimalValueStr = null;
		double decimalValue = 0;
		
		yourCredit.click();
		yourCurrentCredit.click();
		
		String contentDes = yourCurrentCredit.getAttribute("contentDescription");
		Pattern pattern = Pattern.compile("\\((\\d+\\.\\d+)");  // Pattern for number with decimal
        Matcher matcher = pattern.matcher(contentDes);
        
        if (matcher.find()) {
            // Extract the decimal number as a string
            decimalValueStr = matcher.group(1);  // Group 1 contains the decimal number
            
            // Convert the extracted string to a double
            decimalValue = Double.parseDouble(decimalValueStr);
            
            // Output the extracted decimal value
            System.out.println("CreditSection creditScore: " + decimalValue);
        } else {
            System.out.println("No decimal value found.");
        }
		
//		System.out.println(contentDes);
		
		
		return decimalValue;
		
	}
	
	
	
	
	@AndroidFindBy(accessibility="Penalty")
	private WebElement penalty;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[contains(@content-desc,\"Penalty\")]")
	private WebElement yourCurrentPenalty;
	
	public double getCurrentPenalty() {
		
		String DecimalValueStr=null;
		double DecimalValue = 0;
		penalty.click();
		yourCurrentPenalty.click();
		String contentDes = yourCurrentPenalty.getAttribute("contentDescription");
		// Define a pattern to match the decimal number inside parentheses
        Pattern pattern = Pattern.compile("\\((\\d+\\.(\\d+))");  // Captures both whole and fractional parts
        Matcher matcher = pattern.matcher(contentDes);

        if (matcher.find()) {
            // Extract the decimal part (fractional part) using group 2
             DecimalValueStr = matcher.group(1);  // 
             DecimalValue = Double.parseDouble(DecimalValueStr);
            // Output the extracted decimal part
            System.out.println("Extracted decimal part Penalty : " + DecimalValue);
        } else {
            System.out.println("No Penalty found value found.");
        }
		

		
//		System.out.println(contentDes);
		
		
		return DecimalValue;
		
	}
	
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(0)")
	private WebElement CrossButton;
	
	
	
	public void ClickCrossButton() {
		
		CrossButton.click();
	}
	
	
	
	
	
	
	@AndroidFindBy(accessibility="YOUR Laundry\\nPickup and delivery")
	private WebElement YourLaundrySection;
	
	
	@AndroidFindBy(accessibility="Wash Now")
	private WebElement LaundryWashNow;
	public void ClickWashNow() {
		LaundryWashNow.click();
	}
	
	@AndroidFindBy(uiAutomator="new UiSelector().description(\"How To Wash\").instance(1)")
	private WebElement HowToWash;
	public boolean HowtoWashCheck() {
		return HowToWash.isDisplayed();
	}
	
	
	@AndroidFindBy(accessibility="YOUR Offer\\nPickup and delivery")
	public WebElement YourOfferSeciton;
	@AndroidFindBy(accessibility="Grab Now")
	public WebElement OfferGrabNow;
	
	
	@AndroidFindBy(accessibility="YOUR Locker\\nPickup and delivery")
	public WebElement YourLockerSection;
	@AndroidFindBy(accessibility="Open Now")
	public WebElement LockerOpenNow;
	

	
	@AndroidFindBy(accessibility="YOUR Shop\\nPickup and delivery")
	public WebElement YourShopSection;
	@AndroidFindBy(accessibility="Shop Now")
	public WebElement ShopNow;
	
	
	
	
	@AndroidFindBy(accessibility="Explore Now")
	public WebElement YourCareerSection;
	@AndroidFindBy(accessibility="Explore Now")
	public WebElement ExploreNow;
	
	

}
