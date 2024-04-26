package testBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	
public WebDriver driver;
public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		
		logger = LogManager.getLogger(this.getClass());
		
	}

	
//	@BeforeClass
//	@Parameters({"browser","url"})
//	public void setup(String br,String appurl) throws InterruptedException
//	{
//		if(br.equals("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else if(br.equals("edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//		}
//		else
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		driver.get(appurl);
//		driver.manage().window().maximize();
//		Thread.sleep(5000);
//	}	
	

	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
