package AndroidPageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AllCommonUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class YourOfferSectionPage extends AndroidActions {

	public YourOfferSectionPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility="All")
	public WebElement AllCategory;
	
//	@AndroidFindBy()
//	public List<WebElement> categories;
//	
//	public int  categoryCount() {
//		return categories.size();
//		}

	@AndroidFindBy(accessibility="Phone")
	public WebElement Phone;
	
	public boolean isExistPhone() {
		return Phone.isDisplayed();
	}
	
	
//	public void clickPhone() {
//		
//		while(!Phone.isDisplayed()) {
//			swipeCategory();
//		}
//		Phone.click();
//		
//	}
	
	
	
	public void swipeCategory() {
		swipeElementBycords(1,355,955,200,200,"left");
	}
	 
	
	
	@AndroidFindBy(xpath="//android.view.View[contains(@content-desc, \"save\")]")
	public List<WebElement> discoveredProducts;
	
	public int GetdiscoveredProductCount(){
		discoveredProducts.size();
		
		return discoveredProducts.size();
		
	}
	
	
	public boolean findProductandClick(String productName) {
		String contentDescription;
		for(int i=0; i<GetdiscoveredProductCount(); i++) {
			contentDescription = discoveredProducts.get(i).getAttribute("contentDescription");
			
			if(contentDescription.contains(productName)) {
				discoveredProducts.get(i).click();
				return true;
			}
			
			contentDescription = null;
			
		}
		
		return false;
		
		
	}
	
	
	public void scrollAndFindProduct(String productName) {
	
		while(!findProductandClick(productName)) {
			
			boolean scrollable = scrollTo(1,2000,900,"down");
		}
		
		
	}
	
	
	

	
	public void ScrollToTex(String txt) throws InterruptedException {
		
		scrollViewByText(txt);
	}
	
	
	public void NormalScroll() {
		boolean scrollable = true;
		while(scrollable) {
			
			scrollable = scrollTo(1,1500,900,"down");
			//scrollTo(percentage,speedpx,Height,direction)
			System.out.println("scrolling........900px. 1500px/s......... ");
			
		}
		
	}
	
	public void FastScrolling() {
		boolean scrollable = true;
		
		while(scrollable) {
			
			scrollable = scrollTo(1,10000,2000,"down");
			//scrollTo(percentage,speedpx,Height,"down")
			System.out.println("scrolling........2000px 10000px/s.......... ");
//			scrollable = scrollTo(1,10000,2000,"up");
			
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
