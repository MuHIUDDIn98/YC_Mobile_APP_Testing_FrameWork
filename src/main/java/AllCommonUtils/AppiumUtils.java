package AllCommonUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {
	AppiumDriver driver;
	
//	AppiumUtils(AppiumDriver driver){
//		this.driver = driver;
//	}
//	
	
	
//	public void waitForElementToAppear(WebElement ele) {
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains(ele, null, null));
//	}
	
	
	public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException{
		//System.getProperty("user.dir")+""
		//convert json file content to json string
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath ),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> data = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
		
	}

}
