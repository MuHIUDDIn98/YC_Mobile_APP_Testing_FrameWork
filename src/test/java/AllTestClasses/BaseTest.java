package AllTestClasses;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;

public class BaseTest extends BaseTestServices {
	

	@BeforeClass
	public void StartAppiumServerAndOptionClass() throws IOException, InterruptedException {
		startEmulator();
		startServer();
		UiAutomator2SetOptionsDriver();
		
	}
	
	@AfterClass
	public void StopServerAndDriver() throws IOException, InterruptedException {
		
		StopServer();
	}

}
