package utilities;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	public static String takeScreenshot(WebDriver driver, String Name) throws IOException{
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target= new File("C:\\Users\\2320195\\eclipse-workspace\\FindingHospitals\\screenshots\\" +Name+".png");
		FileUtils.copyFile(source, target);
		return target.getAbsolutePath();
	}	

}
