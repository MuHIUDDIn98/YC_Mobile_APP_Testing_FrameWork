package AllTestClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import AndroidPageObjects.LoginPage;
import testUtils.BaseTest;

public class LoginPageTest extends BaseTest{
	@Test(priority=1)
	public void incorrectPasswordTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		
		System.out.println(driver.isAppInstalled("com.mnt.your_campus"));
		loginPage.ClickSkip();
		loginPage.clickNumberField();
		loginPage.setNumber("01521327657");
		loginPage.clickPasswordField();
		loginPage.setPassword("116549");
		loginPage.clickLoginButton();
		System.out.println("Login Button pressed");
		String incorrectMsg = loginPage.getToastIncorrectPinOrNumberMsg();
		System.out.println(incorrectMsg);
		Assert.assertEquals(incorrectMsg, "Incorrect Mobile Number OR PIN");
		System.out.println("--------------------"+System.getProperty("user.dir"));
		
		Thread.sleep(3000);
	}
	
	
	@Test(priority=2)
	public void BlankNumberFieldTest() throws InterruptedException{
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickNumberField();
		loginPage.clearNumberField();
		loginPage.clearPasswordField();
		loginPage.setPassword("234567");
		loginPage.clickLoginButton();
		System.out.println("Login Button pressed");
		String incorrectNumberMsg = loginPage.getToastIncorrectNumberMsg();
		System.out.println(incorrectNumberMsg);
		Assert.assertEquals(incorrectNumberMsg, "Please enter mobile number");
		
		Thread.sleep(3000);
		
		
		
	}
	
	
	
	@Test(priority=3)
	public void BlankPsswordFieldTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickNumberField();
		loginPage.clearNumberField();
		loginPage.setNumber("01896189259");
		loginPage.clickPasswordField();
		loginPage.clearPasswordField();
		loginPage.clickLoginButton();
		System.out.println("Login Button pressed");
		String incorrectPinMsg = loginPage.getToastIncorrectPinMsg();
		System.out.println(incorrectPinMsg);
		Assert.assertEquals(incorrectPinMsg, "Please enter PIN numbesr");
		
		
	}
	
	
	@Test(priority = 4)
	public void ProperLogin() throws InterruptedException {
		
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickNumberField();
		loginPage.clearNumberField();
		loginPage.setNumber("01521327657");
		loginPage.clickPasswordField();
		loginPage.clearPasswordField();
		loginPage.setPassword("123456");
		loginPage.clickLoginButton();
		System.out.println("Login Button pressed");
		Thread.sleep(1000);
//		loginPage.clickNotificationAllow();
//		loginPage.clickBannerImageCrossButton();
		
		
	}
	
	
	
}
