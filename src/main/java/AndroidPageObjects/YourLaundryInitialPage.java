package AndroidPageObjects;

import org.openqa.selenium.support.PageFactory;

import AllCommonUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class YourLaundryInitialPage extends AndroidActions {

	public YourLaundryInitialPage(AndroidDriver driver) {
		super(driver);
		
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

}
