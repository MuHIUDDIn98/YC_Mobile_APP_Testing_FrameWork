package MobileAppTestingFrameWorkAndroid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AndroidGestureActionsUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreditStatementPage extends AndroidActions {

	public CreditStatementPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility="Credit Statement")
	public  WebElement CreditStatement;
	
	
	@AndroidFindBy(xpath="//android.view.View[contains(@content-desc, \"Tab 1\")]")
	public WebElement AllStatement;
	public void clickAllStatement() {
		AllStatement.click();
	}
	
	@AndroidFindBy(xpath="//android.view.View[contains(@content-desc, \"Tab 2\")]")
	public WebElement InStatement;
	public void clickInStatement() {
		InStatement.click();
			
		}
	
	
	@AndroidFindBy(xpath="//android.view.View[contains(@content-desc, \"Tab 3\")]")
	public WebElement OutStatement;
	public void clickOutStatement() {
		
		OutStatement.click();
			
		}


	@AndroidFindBy(xpath="//android.view.View[contains(@content-desc, \"1.\")]")
	public WebElement LastStatement;


	public String GetLastCreditAmount() {
		String contentDes = LastStatement.getAttribute("contentDescription");
		// Regular expression to match the number followed by "Cr."
        String regex = "\\+\\d+\\.\\d{2} Cr\\.";
        
        // Compile the regular expression
        Pattern pattern = Pattern.compile(regex);
        
        // Create a matcher object
        Matcher matcher = pattern.matcher(contentDes);
        String matched = null;
        if (matcher.find()) {
            // Extract the matched part
            matched = matcher.group();
            //System.out.println("Extracted value: " + matched);
        } else {
            System.out.println("No Credit match found");
        }
		
		return matched;
		
	}
	
	
	
	public String GetLastCreditTxid() {
		String contentDes = LastStatement.getAttribute("contentDescription");
		// Regular expression to match the transaction ID
        String regex = "Trans ID: (\\d+)";
        
        // Compile the regular expression
        Pattern pattern = Pattern.compile(regex);
        
        // Create a matcher object
        Matcher matcher = pattern.matcher(contentDes);
        
        String transactionID = null;
        
        if (matcher.find()) {
            // Extract the matched part (the Transaction ID)
            transactionID = matcher.group(1);
            //System.out.println("Extracted Transaction ID: " + transactionID);
        } else {
            System.out.println("No transactionID match found");
        }
        
        return transactionID;
		
		
	}
	
	public String GetLastDateOfTx() {
		String contentDes = LastStatement.getAttribute("contentDescription");
		
		// Regular expression to match the date and time in the format "08 Sep, 2024. 10:51 PM"
        String regex = "\\d{2} \\w{3}, \\d{4}\\. \\d{2}:\\d{2} [APM]{2}";
        String dateTime = null;
        // Compile the regular expression
        Pattern pattern = Pattern.compile(regex);
        
        // Create a matcher object
        Matcher matcher = pattern.matcher(contentDes);
        
        if (matcher.find()) {
            // Extract the matched date and time
            dateTime = matcher.group();
            //System.out.println("Extracted Date and Time: " + dateTime);
        } else {
            System.out.println("No TxID match found");
        }
		return dateTime;
		
		
	}


}
