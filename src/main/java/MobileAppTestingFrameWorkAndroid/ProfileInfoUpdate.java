package MobileAppTestingFrameWorkAndroid;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AndroidGestureActionsUtils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfileInfoUpdate extends AndroidActions {
	AndroidDriver driver;
	public ProfileInfoUpdate(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.widget.Button\").instance(0)")
	private WebElement BurgureMenu;
	
	public void ClickBurgerMenu() {
		BurgureMenu.click();
	}
	
	
	
	@AndroidFindBy(accessibility="Profile")
	private WebElement profile;
	
	public void ClickProfile() {
		profile.click();
	}
	
	@AndroidFindBy(accessibility="Edit Profile")
	private WebElement Editprofile;
	
	public void ClickEditProfile() {
		Editprofile.click();
	}
	
	
	@AndroidFindBy(accessibility ="Edit")
	private WebElement photoAdd;
	
	public void ClickPhotoAdd() {
		photoAdd.click();
	}
	
	
	
	@AndroidFindBy(xpath="(//android.widget.EditText)[1]")
	private WebElement firstName;
	
	public void ClickfirstName() {
		firstName.click();
	}
	
	public void ClearFirstName() {
		firstName.clear();
	}
	
	public void SetFirstName(String Fname) {
		firstName.sendKeys(Fname);
		driver.hideKeyboard();
	}
	
	
	
	
	@AndroidFindBy(xpath="(//android.widget.EditText)[2]")
	private WebElement LastName;
	
	public void ClickLastName() {
		LastName.click();
	}
	
	public void ClearLastName() {
		LastName.clear();
	}
	
	public void SetLastName(String Lname) {
		LastName.sendKeys(Lname);
		driver.hideKeyboard();
	}
	
	
	
	
	
	@AndroidFindBy(xpath="(//android.widget.Button)[2]")
	private WebElement GenderDropDown;
	
	@AndroidFindBy(accessibility="Male")
	private WebElement Male;
	@AndroidFindBy(accessibility="Female")
	private WebElement Female;
	
	public void ClickGenderDropdown() {
		GenderDropDown.click();
	}
	
	public void SetGender(String Gender) {
		if(Gender.contains("Female")) {
			Female.click();
		}
		else {
			Male.click();
		}
	}
	
	
	
	@AndroidFindBy(xpath="(//android.widget.ScrollView/android.widget.EditText[3]")
	private WebElement DateOfBirth;
	
	@AndroidFindBy(xpath="(//android.widget.Button)[1]")
	private WebElement BackButtonArrowButton ;
	
	
	
	
	@AndroidFindBy(xpath="(//android.widget.EditText)[4]")
	private WebElement email;
	
	public void SetMail(String mail) {
		
		email.click();
		email.clear();
		email.sendKeys(mail);
	}
	
	
	
	
	
	
	
	@AndroidFindBy(xpath="(//android.widget.Button)[4]")
	private WebElement OccupationDropDown;
	
	public void ClickOccupationDropDown() {
		
		OccupationDropDown.click();
		System.out.println("Occupation dropdown button clicked");
	}
	
	@AndroidFindBy(accessibility="Student")
	private WebElement Student;
	
	@AndroidFindBy(accessibility="Alumni")
	private WebElement Alumni;
	
	@AndroidFindBy(accessibility="Teacher")
	private WebElement Teacher;
	
	@AndroidFindBy(accessibility="Staff")
	private WebElement Staff;
	
	@AndroidFindBy(accessibility="Other")
	private WebElement Other;
	
	
	public void SetOccupation(String occupation) {
		
		if(occupation.contains("Student")) {
			Student.click();
		}
		else if(occupation.contains("Alumni")) {
			
			Alumni.click();
		}
		else if(occupation.contains("Teacher")) {
			Teacher.click();
		}
		else if(occupation.contains("Staff")) {
			Staff.click();
		}
		else {
			Other.click();
		}
		
	}
	
	
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.EditText\").instance(4)")
	private WebElement StudentIdNoOrAlternativeNumber;
	
	public void SetStudentIDorAlternativeNumber(String ID){
		StudentIdNoOrAlternativeNumber.click();
		StudentIdNoOrAlternativeNumber.sendKeys(ID);
		System.out.println("StudentIdNo clicked and set ");
		driver.hideKeyboard();
	}
	
	
	
	
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.EditText\").instance(5)")
	private WebElement RoomMateNumber;
	public void SetRoomMateNumber(String Number){
		RoomMateNumber.click();
		RoomMateNumber.sendKeys(Number);
		System.out.println("Roommate number clicked and seted ");
		driver.hideKeyboard();
	}
	
	
	
	
	
	
	
	
	@AndroidFindBy(accessibility="Change Your Address")
	private WebElement changeAddressDropdown;
	
	public void ClickChangeAddressOption() {
		changeAddressDropdown.click();
	}
	
	
	
	
	
	
	
	
	@AndroidFindBy(accessibility="Select Your Institution")
	private WebElement instituteOption;
	
	public void ClickInstituteOption() {
		instituteOption.click();
	}
	
	@AndroidFindBy(xpath="(//android.widget.EditText)[1]")
	private WebElement SearchForinstitute;
	
	
	
	
	
	@AndroidFindBy(xpath="//android.widget.Button")
	private WebElement SearchResultinstitute;
	
	public void SetInstitute(String institute) throws InterruptedException {
		instituteOption.click();
		SearchForinstitute.click();
		SearchForinstitute.sendKeys(institute);
		SearchResultinstitute.click();
		
		
		
	}
	
	
	
	
	
	
	@AndroidFindBy(accessibility="Select Your Hall")
	private WebElement HallOption;
	
	
	@AndroidFindBy(xpath="//android.widget.EditText")
	private WebElement SearchInHallOptions;
	
	
	
	
	 @AndroidFindBy(xpath="//android.widget.Button")
	private WebElement SearchResultHallOption;
	
	
	@AndroidFindBy(xpath="//android.widget.Button")
	private WebElement SearchResultHallOpt;
	public void SetHall(String HallName) {
		HallOption.click();
		SearchInHallOptions.click();
		SearchInHallOptions.sendKeys(HallName);
		SearchResultHallOption.click();
		driver.hideKeyboard();
		
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText")
	private WebElement RoomNumber;
	
	public void SetRoomNumber(String Number) {
		
		RoomNumber.click();
		RoomNumber.clear();
		RoomNumber.sendKeys(Number);
		driver.hideKeyboard();
	}
	
	
	@AndroidFindBy(accessibility="Ok")
	private WebElement submitOkButton;
	
	public void clickSubmitOkButton() {
		
		submitOkButton.click();
	}
	
	
	@AndroidFindBy(accessibility="Cancel")
	private WebElement submitCancelButton;
	
	public void clickSubmitCancelButton() {
		
		submitCancelButton.click();
	}
	
	
	
	
	
	
	
	
	
	@AndroidFindBy(accessibility="Update")
	private WebElement updateButton;
	public void ClickUpdateButton() {
		updateButton.click();
	}
	
	
	
	
	@AndroidFindBy(accessibility="Profile Updated Successfully.")
	private WebElement ProfileUpdateSussessfullmsg;
	
	public String GetUpdateSussecsmsg() {

		return ProfileUpdateSussessfullmsg.getAttribute("contentDescription");
		
	}
	
	
	@AndroidFindBy(accessibility="Delete Account")
	private WebElement deleteAccountButton;
	
	public void ClickDeleteAccount() {
		deleteAccountButton.click();
	}
	
	
	
	
	
	
	
	

}
