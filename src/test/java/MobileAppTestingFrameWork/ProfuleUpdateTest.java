package MobileAppTestingFrameWork;

import org.testng.annotations.Test;

import MobileAppTestingFrameWorkAndroid.LoginPage;
import MobileAppTestingFrameWorkAndroid.ProfileInfoUpdate;
import MobileAppTestingFrameWorkAndroid.WelcomePage;

public class ProfuleUpdateTest extends BaseTest {

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
	
	@Test(priority=3)
	public void ProfuleUpdatest() throws InterruptedException {
		
		ProfileInfoUpdate pi = new ProfileInfoUpdate(driver);
		pi.ClickBurgerMenu();
		pi.ClickProfile();
		pi.ClickEditProfile();
		pi.ClickfirstName();
		pi.ClearFirstName();
		pi.SetFirstName("Muhiuddin");
		pi.ClickLastName();
		pi.ClearLastName();
		pi.SetLastName("ahmed");
		pi.ClickGenderDropdown();
		pi.SetGender("Female");
		pi.ClickGenderDropdown();
		pi.SetGender("Male");
		
		pi.SetMail("muhiuddinanik98@gmail.com");
		pi.ClickOccupationDropDown();
		pi.SetOccupation("Student");
		pi.SetStudentIDorAlternativeNumber("123432");
		pi.SetRoomMateNumber("01521327657");
		pi.ClickChangeAddressOption();
		pi.SetInstitute("BUET");
		pi.SetHall("Sher-a-balnga");
		Thread.sleep(2000);
//		pi.SetRoomNumber("420");
		pi.clickSubmitOkButton();
		driver.hideKeyboard();
		pi.ClickUpdateButton();
		System.out.println(pi.GetUpdateSussecsmsg());
		
		Thread.sleep(2000);
		
		
	}
	
	
}
