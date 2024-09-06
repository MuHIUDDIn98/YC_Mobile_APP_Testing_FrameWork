package MobileAppTestingFrameWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BaseTestServices {
	
	
	String emulatorPath = "C:\\Users\\Onick\\AppData\\Local\\Android\\Sdk\\emulator\\emulator.exe";
	String avdName = "Pixel_7_Pro_API_34";
	String mainJsPath ="C:\\Users\\Onick\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
	String AppiumServerIP = "127.0.0.1";
	static String EMULATOR_PATH = "C:\\Users\\Onick\\AppData\\Local\\Android\\Sdk\\emulator\\emulator.exe"; // Update this path
    static String AVD_NAME = "Pixel_7_Pro_API_34"; // Update this to your AVD name
	int AppiumPort = 4723;
	String appPath =System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
            + File.separator+"java" + File.separator + "ApkResource"+File.separator+"TEST_Cashin_V2_20240904_v1.apk";
	
	public AndroidDriver driver;
	
	AppiumDriverLocalService service;
	
	
	public  void startServer() {
		 service = new AppiumServiceBuilder().withAppiumJS(new File(mainJsPath)).withIPAddress(AppiumServerIP).usingPort(AppiumPort).build();
		 
		 service.start();
		 System.out.println("Appium server started");
			
	}
	
	public void UiAutomator2SetOptionsDriver() throws MalformedURLException {
		
		//UiAutomation options selection
				UiAutomator2Options options = new UiAutomator2Options();
				//setting uiautomator capabilities options
				options.setDeviceName(avdName);
//				String appPath =System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//		                + File.separator+"java" + File.separator + "ResouscesApk"+File.separator+"YourCampus_2024_08_28_V1.apk";
				
				//String appPath = "E:\\java_web_automation_scripts\\Mobile_Automation_Basics_with_java\\src\\test\\java\\ResouscesApk\\YourCampus_2024_08_28_V1.apk";
				
				
				options.setApp(appPath);
				
				System.out.println("++++++++++++++++"+appPath+"++++++++++++++++++++++++");
				
				
				//AndroidDriver
			
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
				//driver element get timeout
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	public void SetDesiredCapabilitiesDriver() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:automationName","UiAutomator2");
        desiredCapabilities.setCapability("appium:deviceName","Pixel_7_Pro_API_34");
        desiredCapabilities.setCapability("appium:udid","emulator-5554");
        desiredCapabilities.setCapability("appium:app", appPath);
        //for emulator launch through appium
        desiredCapabilities.setCapability("appium:avd", "Pixel_7_Pro_API_34");
        desiredCapabilities.setCapability("appium:avdLaunchTimeout", 24000);
        desiredCapabilities.setCapability("appium:appPackage","com.mnt.your_campus");
        desiredCapabilities.setCapability("appium:appActivity","com.mnt.your_campus.MainActivity");
        
        URL remoteUrl = new URL("http://127.0.0.1:4723");
        
        driver = new AndroidDriver(remoteUrl,desiredCapabilities);
	}
	
	
	
	//Gestures function
	
	public void longPressAction(WebElement element) {
		
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)element).getId()),
				"duration",2000);
	}
	
	public void scrollViewByText(String element) throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+element+"\"));"));
		Thread.sleep(2000);
	}
	
	
	public void swipeElement(WebElement ele,String direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.1
			));
	}
	
	
	public void dragNdropByElementNCordinate(WebElement elem,int endX,int endY) {
		
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) elem).getId(),
		    "endX", endX,
		    "endY", endY
		));
	}
	
	public void dragNdropByCordinate(int startX,int startY,int endX,int endY) {
		// Java
				((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
					"startX",startX,
					"startY",startY,
				    "endX", endX,
				    "endY", endY
				));
			
		}
		
	
	
	
	
	
	
	public void StopServer() {
		
		driver.quit();
		System.out.println("android driver Quit");
		service.stop();
		System.out.println("Appium server stop");
	}
	
	
	
	
	
	public static void setEmuPath(String path) {
	    	
	    	EMULATOR_PATH = path;
	    }
	    
	    public static void setAvdName(String name) {
	    	
	    	AVD_NAME = name;
	    }
	
	
	
	public static void startEmulator() throws IOException, InterruptedException {
        // Build the command to start the emulator
        ProcessBuilder processBuilder = new ProcessBuilder(EMULATOR_PATH, "-avd", AVD_NAME);
        processBuilder.redirectErrorStream(true);

        // Start the emulator
        Process process = processBuilder.start();
        System.out.println("Emulator started ..........");
        
        // Optional: Read the emulator's output
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        
        // Wait for the emulator to fully start (this might need adjustment based on your setup)
        Thread.sleep(10000); // Wait 20 seconds or adjust as needed
    }
	
	
	/**
     * Stops the AVD emulator.
     */
    public static void stopEmulator() throws IOException, InterruptedException {
        // Use adb to list running emulator instances
        ProcessBuilder processBuilder = new ProcessBuilder("adb", "devices");
        Process process = processBuilder.start();
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("emulator")) {
                    String[] parts = line.split("\t");
                    String emulatorId = parts[0];
                    
                    // Use adb to stop the emulator by ID
                    Process stopProcess = new ProcessBuilder("adb", "-s", emulatorId, "emu", "kill").start();
                    stopProcess.waitFor();
                    
                    System.out.println("Emulator " + emulatorId + " stopped successfully .");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	
	
	
	

}
