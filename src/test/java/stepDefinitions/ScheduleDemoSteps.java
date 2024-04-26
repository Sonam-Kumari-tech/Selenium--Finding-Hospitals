package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utilities.Screenshots;

public class ScheduleDemoSteps {
	
	WebDriver driver= new ChromeDriver();;
	HomePage hp=new HomePage(driver);
	WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	SoftAssert softAssert = new SoftAssert();


	@Given("user Open Practo Home page")
	public void user_open_practo_home_page() throws IOException {
		//driver= new ChromeDriver();
		driver.get("https://www.practo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//hooks.setup();
	}

	@Given("user click on For corparates dropdown select Health & Wellness Plans")
	public void user_click_on_for_corparates_dropdown_select_health_wellness_plans() throws InterruptedException, IOException {
		//hp= new HomePage(driver);
		hp.clickForCorporate();
	}

	@Given("Enter the name")
	public void enter_the_name() {
		WebElement name=myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"name\"]")));
		name.clear();
        name.sendKeys("Sonam");	    
	}

	@Given("Enter the Organization name")
	public void enter_the_organization_name() {
		WebElement organizationName = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"organizationName\"]")));
        organizationName.clear();
        organizationName.sendKeys("Cognizant");
	    
	}

	@Given("Enter the contact number")
	public void enter_the_contact_number() {
		WebElement contactNumber = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'contactNumber']")));
        contactNumber.clear();
        contactNumber.sendKeys("9798716500");
	    
	}

	@Given("Enter the invalid email id")
	public void enter_the_invalid_email_id() {
		WebElement emailId = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'officialEmailId']")));
        emailId.clear();
        emailId.sendKeys("abc123gmail.com");
	   
	}
	
	@Given("Enter the valid email id")
	public void enter_the_valid_email_id() {
		WebElement emailId = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'officialEmailId']")));
        emailId.clear();
        emailId.sendKeys("abc123@gmail.com");
	    
	}
	

	@Given("select the organization size")
	public void select_the_organization_size() {
		WebElement organizationSize = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='organizationSize']")));
        Select organization = new Select(organizationSize);
        organization.selectByVisibleText("501-1000");
	    
	}

	@Given("select the Interested in option")
	public void select_the_interested_in_option() {
		WebElement interestedIn = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = \"interestedIn\"]")));
        Select interest = new Select(interestedIn);
        interest.selectByVisibleText("Referring someone");
	    
	}
	
	@Then("schedule a demo button should be disabled")
	public void schedule_a_demo_button_should_be_disabled() throws InterruptedException {
		Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();
        WebElement submitButton = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Schedule a demo')]")));
        softAssert.assertEquals(submitButton.isEnabled(), false);
        softAssert.assertAll();
        System.out.println("after entering invalid emailId---> Schedule a demo btn is disabled");       
        driver.close();       	    
	}

	@Then("schedule a demo button should be enabled")
	public void schedule_a_demo_button_should_be_enabled() throws InterruptedException {
		Thread.sleep(3000);
        WebElement submitButton = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Schedule a demo')]")));
        softAssert.assertEquals(submitButton.isEnabled(), true);
        softAssert.assertAll();
        System.out.println("after entering invalid emailId---> Schedule a demo btn is enabled"); 
        
        //driver.close(); 
        //hooks.tearDown();
	}
	
	@Then("click schedule a demo button")
	public void click_sehedule_a_demo_button() throws InterruptedException {
		Thread.sleep(3000);
        WebElement clickSubmitButton = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Schedule a demo')]")));
        softAssert.assertEquals(clickSubmitButton.isEnabled(), true);
        clickSubmitButton.click();
	}
	
	@Then("validate thank you message")
	public void validate_thank_you_message() {
		WebElement thanx = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div[1]")));
        softAssert.assertEquals(thanx.getText(), "THANK YOU"); 
        softAssert.assertAll();
        System.out.println("after clicking Schedule a demo btn ---> THANK YOU msg is displayed");
	}
	
	
	
	@Given("Enter email as {string}")
	public void enter_email_as(String email) {
		WebElement emailId = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'officialEmailId']")));
        emailId.clear();
        emailId.sendKeys(email);
	    
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
