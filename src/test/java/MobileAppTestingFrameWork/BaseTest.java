package MobileAppTestingFrameWork;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
