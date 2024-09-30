package AllTestClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AndroidPageObjects.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import testUtils.BaseTest;

public class LoginDataDrivenTestingV1 extends BaseTest{
	
	
//	@BeforeMethod
//	public void resetAPP() {
//		
//		
//	}
	
	
	
	@Test(priority = 1)
	public  void skip() {
		LoginPage loginPage = new LoginPage(driver);
		
		//System.out.println(driver.isAppInstalled("com.mnt.your_campus"));
		loginPage.ClickSkip();
		
	}
	
	
	@Test(dataProvider="getData" ,priority=2)
	public void incorrectPasswordTest(String number,String password) throws InterruptedException {
		
		
		LoginPage loginPage = new LoginPage(driver);
		
		System.out.println(driver.isAppInstalled("com.mnt.your_campus"));
		//loginPage.ClickSkip();
		loginPage.clickNumberField();
		loginPage.clearNumberField();
		loginPage.setNumber(number);
		loginPage.clickPasswordField();
		loginPage.clearPasswordField();
		loginPage.setPassword(password);
		loginPage.clickLoginButton();
		System.out.println("Login Button pressed");
//		String incorrectMsg = loginPage.getToastIncorrectPinOrNumberMsg();
//		System.out.println(incorrectMsg);
//		Assert.assertEquals(incorrectMsg, "Incorrect Mobile Number OR PIN");
		
		Thread.sleep(3000);
	}
	
	
//	@BeforeMethod
//	public void driverReset() {
//		
//	}
	
	
	
	@DataProvider	
	public Object [][] getData(){
		
		return new Object[][] {
				{"01521327657" , ""},
				{"" , "123456"},
				{"01521327657" , "123456"}
			};
	}
	
	
	
	
	
	
	
}
