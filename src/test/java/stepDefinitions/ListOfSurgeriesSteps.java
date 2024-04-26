package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import pageObjects.SurgeriesPage;

public class ListOfSurgeriesSteps {
	
	WebDriver driver= new ChromeDriver();;
	HomePage hp=new HomePage(driver);
//	WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
//	SoftAssert softAssert = new SoftAssert();


	@Given("user Opens Practo Home page")
	public void user_open_practo_home_page() throws IOException {
		//driver= new ChromeDriver();
		driver.get("https://www.practo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//hooks.setup();
	}
	
	@Given("user click on Surgery")
	public void user_click_on_surgery() {
		hp.clickSurgeries();    
	}

	@Then("fetch the list of surgies")
	public void fetch_the_list_of_surgies() {
		SurgeriesPage sp= new SurgeriesPage(driver);
		  List<WebElement> surgeryList= sp.surgeryList();
		  System.out.println("*******List of surgeries*******");
		  for(int i=0; i< surgeryList.size(); i++) {
			  String surgeryName= surgeryList.get(i).getText();
			  System.out.println(surgeryName);
		  }  
		  System.out.println("-----------------------------------------------------S");
	    
	}
	
	@AfterStep
    public void addScreenshot(Scenario scenario) {
        
    	// this is for cucumber junit report
        if(scenario.isFailed()) {
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }
      
    }

}
