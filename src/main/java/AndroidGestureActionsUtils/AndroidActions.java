package AndroidGestureActionsUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;
		
	}
	
	
	public void longPressAction(WebElement element) {
			
			((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
					"elementId",((RemoteWebElement)element).getId()),
					"duration",2000);
		}
	
	public void scrollViewByText(String element) throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+element+"\"));"));
		Thread.sleep(2000);
	}
	
	
	public void swipeElement(WebElement ele,String direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.1
			));
	}
	
	
	public void dragNdropByElementNCordinate(WebElement elem,int endX,int endY) {
		
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) elem).getId(),
		    "endX", endX,
		    "endY", endY
		));
	}
	
	public void dragNdropByCordinate(int startX,int startY,int endX,int endY) {
		// Java
				((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
					"startX",startX,
					"startY",startY,
				    "endX", endX,
				    "endY", endY
				));
			
		}

}
