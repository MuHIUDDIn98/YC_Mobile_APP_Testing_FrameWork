package AllTestClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import AndroidPageObjects.LoginPage;
import AndroidPageObjects.NewAppDashboard;
import AndroidPageObjects.ProfileInfoUpdate;

public class NewAppDashBoardTest extends BaseTest {
	
	
	@Test(priority=1)
	public void ProperLogin() throws InterruptedException {
			
		LoginPage loginPage = new LoginPage(driver);
			loginPage.ClickSkip();
			loginPage.clickNumberField();
			loginPage.clearNumberField();
			loginPage.setNumber("01521327657");
			loginPage.clickPasswordField();
			loginPage.clearPasswordField();
			loginPage.setPassword("123456");
			loginPage.clickLoginButton();
			System.out.println("Login Button pressed");
			Thread.sleep(1000);
	
	}
	@Test(priority=2)
	public void yourCreditScoreCheck() throws InterruptedException {
		
		NewAppDashboard NAD = new NewAppDashboard(driver);
		ProfileInfoUpdate PIU = new ProfileInfoUpdate(driver);
		
		NAD.ClickBurgerMenu();
		NAD.ClickBurgerMenuDissmiss();
		
		
		Assert.assertTrue(NAD.WelcomeMsgStringFormatValidator());
		NAD.ClickProfile();
		String currentUserName = PIU.getUserName();
		PIU.ClickBack();
		//Assert.assertEquals(NAD.getWelcomeMsgUser(),currentUserName );
		
		double DashboardCredtScore = NAD.getCurrentCreditScore();
	
		NAD.ClickViewMore();
		double CreditSectionCreditScore = NAD.getCurrentCredit();
		//Assert.assertEquals(DashboardCredtScore, CreditSectionCreditScore);
		double currentPenalty = NAD.getCurrentPenalty();
		System.out.println(currentPenalty);
		NAD.ClickCrossButton();
			
		
	}
	
	
	@Test(priority=3)
	public void ScrollToEndTest() {
		NewAppDashboard NAD = new NewAppDashboard(driver);
		NAD.ScrollingTo("down");
		NAD.ScrollingTo("up");
		NAD.ScrollingTo("down");
	}
	
	
	
	@Test(priority=4)
	public void LaundryServicesSectionCheck() {
		NewAppDashboard NAD = new NewAppDashboard(driver);
		NAD.ClickWashNow();
		if(NAD.HowtoWashCheck()) {
			System.out.println("How to wash is availabe");
			Assert.assertTrue(NAD.HowtoWashCheck());
			
		}
		else {
			System.out.println("How to wash is not available");
		}
		
		
		
		
		
	}
	

}
