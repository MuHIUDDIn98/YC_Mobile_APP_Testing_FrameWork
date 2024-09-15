package AllCommonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	AppiumDriver driver;
	AppiumDriverLocalService service;
//	String mainJsPath =System.getProperty("user.home")+"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
	String mainJsSystemPath;
//	AppiumUtils(AppiumDriver driver){
//		this.driver = driver;
//	}
//	
	
	public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException{
		//System.getProperty("user.dir")+""
		//convert json file content to json string
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath ),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> data = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
	
	}
	
	
	public AppiumDriverLocalService  startServer(String AppiumServerIP,int AppiumPort) throws IOException {
		Properties prop = new Properties();
		FileInputStream fism = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(fism);
		
		String mp = prop.getProperty("mainJsPath");
		System.out.println(mp);
		mainJsSystemPath = System.getProperty("user.home")+mp;
		 service = new AppiumServiceBuilder().withAppiumJS(new File(mainJsSystemPath)).withIPAddress(AppiumServerIP).usingPort(AppiumPort).build();
		 
		 service.start();
		 System.out.println("++++++++++++++++++++++Appium server started+++++++++++++++++");
		 
		 
		 return service;
			
	}

}
