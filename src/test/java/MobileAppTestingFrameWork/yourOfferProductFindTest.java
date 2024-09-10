package MobileAppTestingFrameWork;

import org.testng.annotations.Test;

import MobileAppTestingFrameWorkAndroid.AppDashBoard;
import MobileAppTestingFrameWorkAndroid.LoginPage;
import MobileAppTestingFrameWorkAndroid.WelcomePage;
import MobileAppTestingFrameWorkAndroid.YourOfferSectionPage;

public class yourOfferProductFindTest extends BaseTest {
	@Test(priority=1)
	public void WelcomeMsgPageTransitionTest() {
		
		WelcomePage welcomePage = new WelcomePage(driver);
		
		welcomePage.ClickNext();
		welcomePage.ClickNext();
		welcomePage.ClickEnter();
	
		
	}
	
	
	@Test(priority = 2)
	public void ProperLogin() throws InterruptedException {
			
			
			LoginPage loginPage = new LoginPage(driver);
			
			loginPage.clickNumberField();
			loginPage.setNumber("01521327657");
			loginPage.clickPasswordField();
			loginPage.setPassword("123456");
			loginPage.clickLoginButton();
			System.out.println("Login Button pressed");
			Thread.sleep(1000);
			loginPage.clickNotificationAllow();
			loginPage.clickBannerImageCrossButton();
			
			
		}
	
	@Test(priority = 3)
	public void yourOfferTest() throws InterruptedException {
		AppDashBoard AD = new AppDashBoard(driver);
		YourOfferSectionPage YP = new YourOfferSectionPage(driver);
		AD.ClickYourOffer();
		//YP.FastScrolling();
//		System.out.println("discovered product element is yourOffer section +++++++++++++"+YP.discoveredProducts.size());
//		
//		YP.NormalScroll();
		
		//YP.findProductandClick("SAMSUNG Galaxy A04 (4GB/64GB)");
		YP.scrollAndFindProduct("REALME C55 (6GB/128GB)");
		
		
		Thread.sleep(5000);
		
		
		
	}


	

}



