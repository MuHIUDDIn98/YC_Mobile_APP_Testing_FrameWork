package AllTestClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;

public class BaseTest extends BaseTestServices {
	

	@BeforeClass
	public void StartAppiumServerAndSetOptionClass() throws IOException, InterruptedException {
		startEmulator();
		Properties prop = new Properties();
		FileInputStream fism = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
	            + File.separator+"java" + File.separator + "Resources"+File.separator+"data.properties");
		prop.load(fism);
		
		String AppiumServerIPAddress = prop.getProperty("AppiumServerIP");
		int AppiumServerPort = Integer.parseInt(prop.getProperty("AppiumPort"));
		
		service = startServer(AppiumServerIPAddress,AppiumServerPort);
		UiAutomator2SetOptionsDriver();
		
	}
	
	@AfterClass
	public void StopServerAndDriver() throws IOException, InterruptedException {
		
		StopServer();
	}

}
