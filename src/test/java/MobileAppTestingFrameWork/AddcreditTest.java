package MobileAppTestingFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

import MobileAppTestingFrameWorkAndroid.AddCreditPaymentPage;
import MobileAppTestingFrameWorkAndroid.AppDashBoard;
import MobileAppTestingFrameWorkAndroid.LoginPage;
import MobileAppTestingFrameWorkAndroid.WelcomePage;

public class AddcreditTest extends BaseTest{
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
	public void AddCreditTest() throws InterruptedException {
		
		AppDashBoard AD = new AppDashBoard(driver);
		AddCreditPaymentPage ACPP = new AddCreditPaymentPage(driver);
		
		double DashboardCredit = 0;
				
		DashboardCredit = AD.getCurrentCredit();
		System.out.println("Your DashBoard Credit is :"+ DashboardCredit );
		double DashBoardPenalty = AD.getCurrentPenalty();
		System.out.println("Your DashBoard  Penalty is :"+ DashBoardPenalty);
		AD.clickAddCredit();
		
		
		double EnteredAmount = 100;
		String amountAsString = String.valueOf((int)EnteredAmount);
		System.out.println("your entered amount is :"+amountAsString);
		ACPP.setAmount(amountAsString);
		
		System.out.println("Your Get displayed Amount :"+ACPP.getDisplayedEnteredAmount());
		
		Assert.assertTrue(EnteredAmount == ACPP.getDisplayedEnteredAmount());
		
		System.out.println("Dashboard penalty :+++++"+DashBoardPenalty);
		System.out.println("Payement  penalty :+++++"+ACPP.getDisplayedPanelty());
		Assert.assertTrue(DashBoardPenalty == ACPP.getDisplayedPanelty());
//		
//		
		double actualTotalPayment = ACPP.getDisplayedPanelty() + ACPP.getDisplayedEnteredAmount();
		Assert.assertTrue(ACPP.getTotalDisplayedAmount()==actualTotalPayment);
		
		
		
		ACPP.clickAmarPay();
		ACPP.clickAddCreditButton();
		ACPP.clickMasterCard();
		
		scrollViewByText("Success");
		ACPP.clickSuccess();
		ACPP.clickOkSuccess();
		
		System.out.print("Dashboard previous Credit was :"+DashboardCredit);
		DashboardCredit = DashboardCredit+EnteredAmount;
		double newCredit = AD.getAfterPaymentCurrentCredit();
		System.out.println("calculated dashboard credit :"+DashboardCredit);
		System.out.println("DashBoard updated credit    :"+newCredit);
		Assert.assertTrue(DashboardCredit == newCredit );
		
		
		
		
		
		
		
		Thread.sleep(2000);

		
	}
}
