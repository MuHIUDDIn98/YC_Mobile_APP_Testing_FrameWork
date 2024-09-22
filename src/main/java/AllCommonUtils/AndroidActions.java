package AllCommonUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils{
	
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
	
	public boolean scrollTo(double parcent,int speedpx, int Height,String direction) {
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 683, 
			    "top", 560, 
			    "width", 200, 
			    "height", Height,
			    "direction", direction, //up , down
			    "percent", parcent, //Scrolls 300% of the visible area, making it faster
			    "speed", speedpx //Speed in pixels per second (optional if supported)
			));
		return canScrollMore;
	}
	
	public void startActivity(String activity) {
			
			((JavascriptExecutor)driver).executeScript(
					"mobile: startActivity",
					ImmutableMap.of("intent",activity));
		}
	
	
	
	public void ScrollTo(String action) {
		boolean scrollable = true;
		
		while(scrollable) {
			
			scrollable = scrollTo(1,1000,900,action);
			//scrollTo(percentage,speedpx,Height,"down")
			System.out.println("scrolling........900px 1000px/s.......... ");
//			scrollable = scrollTo(1,10000,2000,"up");
			
		}
		
	}
	
	public void ScrollToEnd() {
		boolean scrollable = true;
		
		while(scrollable) {
			
			scrollable = scrollTo(1,1000,900,"down");
			//scrollTo(percentage,speedpx,Height,"down")
			System.out.println("scrolling........900px 1000px/s.......... ");
//			scrollable = scrollTo(1,10000,2000,"up");
			
		}
		
	}
	
	
	
	
	
	
	public void swipeElement(WebElement ele,String direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.1
			));
	}
	
	
	public void swipeElementBycords(int parcent,int startX, int startY,int speed,int height,String direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		    "left", startX, 
		    "top", startY, 
		    "width", 200, 
		    "height", height,
		    "speed",speed,
		    "direction", direction,
		    "percent", parcent
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
