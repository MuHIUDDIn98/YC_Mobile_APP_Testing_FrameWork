package AllTestClasses;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AndroidPageObjects.LoginPage;
import testUtils.BaseTest;

public class loginDataDriverTestV3 extends BaseTest {
	
	@Test(priority = 1)
	public  void skip() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.ClickSkip();
		
	}
	
	
	@Test(dataProvider="getData" ,priority=2)
	public void incorrectPasswordTest(List<HashMap<String, String>> data) throws InterruptedException {
		
	for (HashMap<String, String> map : data) {
        String number = map.get("number");
        String password = map.get("pass");
            
            
		LoginPage loginPage = new LoginPage(driver);
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
		
		Thread.sleep(1000);
		}
	}
	
	
//	@BeforeMethod
//	public void driverReset() {
//		
//	}
	
	
	
	@DataProvider	
	public Object [][] getData() throws IOException{
		
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
	            + File.separator+"java" + File.separator + "TestData"+File.separator+"UserCredList.json");
		
		Object[][] objectArray = new Object[1][];
        objectArray[0] = new Object[]{data};

        return objectArray;
	}

}