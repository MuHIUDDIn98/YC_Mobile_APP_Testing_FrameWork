package AllTestClasses;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AndroidPageObjects.LoginPage;
import testUtils.BaseTest;

public class LoginDataDriverTestingWithJsonFileV2 extends BaseTest {
	
	@Test(priority = 1)
	public  void skip() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.ClickSkip();
		
	}
	
	
	@Test(dataProvider="getData" ,priority=2)
	public void incorrectPasswordTest(String number, String password) throws InterruptedException {
		
		
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
		
		Thread.sleep(3000);
	}
	
	
//	@BeforeMethod
//	public void driverReset() {
//		
//	}
	
	
	
	@DataProvider	
	public Object [][] getData() throws IOException{
		
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
	            + File.separator+"java" + File.separator + "TestData"+File.separator+"UserCredList.json");
		
		Object[][] objectArray = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            objectArray[i] = new Object[]{data.get(i).get("number"), data.get(i).get("pass")};
        }

        return objectArray;
	}

}
