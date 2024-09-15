package AllTestClasses;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import AndroidPageObjects.AddCreditPaymentPage;
import AndroidPageObjects.AppDashBoard;
import AndroidPageObjects.CreditStatementPage;
import AndroidPageObjects.LoginPage;
import AndroidPageObjects.WelcomePage;

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
		
		//Object creation for Application Dashbords page
		AppDashBoard AD = new AppDashBoard(driver);
		//object creation for AddCreditPayment page
		AddCreditPaymentPage ACPP = new AddCreditPaymentPage(driver);
		//Object creation Credit statement page 
		CreditStatementPage CS = new CreditStatementPage(driver);
		
		
		
		double DashboardCredit = 0;
		//get currect dashboard user credit	
		DashboardCredit = AD.getCurrentCredit();
		System.out.println("Your DashBoard Credit is :"+ DashboardCredit );
		
		//get current dashboard user Penalty
		double DashBoardPenalty = AD.getCurrentPenalty();
		System.out.println("Your DashBoard  Penalty is :"+ DashBoardPenalty);
		
		//switch to add credit section
		AD.clickAddCredit();
		
		
		//amount of taka you want to enter
		double EnteredAmount = 100;
		
		//Desired entered amount converst to string
		String amountAsString = String.valueOf((int)EnteredAmount);
		System.out.println("your entered amount is :"+amountAsString);
		
		///Add credit payment page set ammount
		ACPP.setAmount(amountAsString);
		System.out.println("Your Get displayed Amount :"+ACPP.getDisplayedEnteredAmount());
		
		///Ensuring Entered amount and Displayed amount are same
		Assert.assertTrue(EnteredAmount == ACPP.getDisplayedEnteredAmount());
		
		System.out.println("Dashboard penalty :+++++"+DashBoardPenalty);
		System.out.println("Payement  penalty :+++++"+ACPP.getDisplayedPanelty());
		
		//Enshuring app dashboard penelty credit and displayed penalty credit is same ACP page 
		Assert.assertTrue(DashBoardPenalty == ACPP.getDisplayedPanelty());
		
		// totalPayment = displayedPenalty + displayedEnterd 
		double actualTotalPayment = ACPP.getDisplayedPanelty() + ACPP.getDisplayedEnteredAmount();
		
		//Total displayed amount = actualAmount 
		Assert.assertTrue(ACPP.getTotalDisplayedAmount()==actualTotalPayment);
		
		
		//Others payment way
		ACPP.clickOthers();
		
		
		//Payment activity
		ACPP.clickAmarPay();
		
		Set<String> contexts = driver.getContextHandles();
		for(String contextName : contexts) {
			System.out.println("ContextName" + contextName);
		}
		
		ACPP.clickAddCreditButton();
		ACPP.clickMasterCard();
		
		ACPP.ScrollToEnd();
		ACPP.clickSuccess();
		ACPP.clickOkSuccess();
		
		//Previous credit  statement
		System.out.print("Dashboard previous Credit was :"+DashboardCredit);
		
		//New credit predicted calculation
		DashboardCredit = DashboardCredit+EnteredAmount;
		
		//newCredit on credit section , your credit
		double newCredit = AD.getAfterPaymentCurrentCredit();
		System.out.println("calculated dashboard credit :"+DashboardCredit);
		System.out.println("DashBoard updated credit    :"+newCredit);
		
		//calculated predicted credit and new credit validation
		Assert.assertTrue(DashboardCredit == newCredit );
		
		AD.clickCreditStatement();
		CS.clickInStatement();
		System.out.println("Last credited amount "+CS.GetLastCreditAmount());
		System.out.println("Last TXID :"+CS.GetLastCreditTxid());
		System.out.println("Last Date of Credit" +CS.GetLastDateOfTx());
	
		
		
		
		
		
		
		
		
		
		
		Thread.sleep(2000);

		
	}
}
