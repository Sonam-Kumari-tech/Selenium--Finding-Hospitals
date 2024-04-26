package stepDefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.HospitalFiltersPage;
import utilities.ExcelUtility;

public class SearchDoctorsSteps {
	
	WebDriver driver= new ChromeDriver();;
	HomePage homepage=new HomePage(driver);
	HospitalFiltersPage hfp= new HospitalFiltersPage(driver);
	
	@Given("user navigates to Practo Home page")
	public void user_navigates_to_practo_home_page() {
		driver.get("https://www.practo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	    
	}

	@Given("user Enters city as {string}")
	public void user_enters_city_as(String string) {
		homepage.setCity();
	}

	@Given("user enters doctor specialist as {string}")
	public void user_enters_doctor_specialist_as(String string) {
		homepage.setDoctorType();
	    
	}

	@When("user navigates to applied filter page")
	public void user_navigates_to_applied_filter_page() {
		driver.navigate().to("https://www.practo.com/search/doctors?results_type=doctor&q=%5B%7B%22word%22%3A%22dentist%22%2C%22autocompleted%22%3Atrue%2C%22category%22%3A%22subspeciality%22%7D%5D&city=Bangalore");
		
		String text=hfp.bookAppointmentSection();
		Assert.assertEquals(text,"Book appointments with minimum wait-time & verified doctor details");	
	}

	@When("applies filters")
	public void applies_filters() throws InterruptedException {
		hfp.clickPatientStiories();

		Thread.sleep(5000);
		hfp.clickExperience();
		Thread.sleep(5000);

		hfp.clickSortBy();
		Thread.sleep(5000);

		hfp.clickAllFilters();
		Thread.sleep(5000);
	   
	}

	@Then("print details of Doctors")
	public void print_details_of_doctors() {
		List<String> doctorDetails= new ArrayList<String> ();
		System.out.println("**********List of top 5 doctors Details ************");
		for(int i=3; i<9;i++) {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView()", doctorDetails.get(i));
			if(i==7) {
				continue;
			}
			String name= driver.findElement(By.xpath("//div[@class='uv2-spacer--jumbo-xl-hz']/div["+i+"]/div/div/div/div[2]/a/div")).getText();	
			doctorDetails.add(name);
			String specilist= driver.findElement(By.xpath("//div[@class='uv2-spacer--jumbo-xl-hz']/div[3]/div/div/div/div[2]/div/div")).getText();
			doctorDetails.add(specilist);
			String experience= driver.findElement(By.xpath("//div[@class='uv2-spacer--jumbo-xl-hz']/div[3]/div/div/div/div[2]/div/div[2]")).getText();
			doctorDetails.add(experience);
			String address= driver.findElement(By.xpath("//div[@class='uv2-spacer--jumbo-xl-hz']/div[3]/div/div/div/div[2]/div[2]/div/a")).getText();
			doctorDetails.add(address);
			
		}
		for(String details : doctorDetails) {
			System.out.println(details);	
		}
		System.out.println("------------------------------------");
		doctorDetails.clear();
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



