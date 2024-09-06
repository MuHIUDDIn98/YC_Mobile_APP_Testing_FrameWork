package MobileAppTestingFrameWork;

import org.testng.annotations.Test;

import MobileAppTestingFrameWorkAndroid.LoginPage;
import MobileAppTestingFrameWorkAndroid.WelcomePage;

public class welcomeMsgTest extends BaseTest{
	
	
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
		
		
	
	}
