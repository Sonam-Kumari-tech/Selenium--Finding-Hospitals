package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HospitalFiltersPage {


	WebDriver driver;
//	public HospitalFiltersPage(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}
	
	public HospitalFiltersPage(WebDriver driver){
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   }

	
	
	//@FindBy(xpath="//p[@class='u-x-large-font']")
	@FindBy(xpath="//div[@class='u-color--grey5 uv2-cushion--md-top uv2-cushion--8x-bottom u-border-general--bottom']/div[2]/p")
	   public WebElement availableDoctors;
	   public String bookAppointmentSection()
	   {
		   return availableDoctors.getText();
	   }
	
	@FindBy(xpath= "//*[@data-qa-id='doctor_review_count_selected']")
	public WebElement patientStiories;
	
	
	@FindBy(xpath= "//*[@data-qa-id='years_of_experience_selected']")
	public WebElement experience;
	
	
	@FindBy(xpath= "//span[contains(text(),'All Filters')]")
	public WebElement allFilters;
	
	
	
	@FindBy(xpath= "//span[@data-qa-id='Available Today_label']")
	public WebElement avalibility;
		
	
	public void clickPatientStiories() {
		patientStiories.click();
		//dropDown option
		List<WebElement> stroies =driver.findElements(By.xpath("//ul[@data-qa-id='doctor_review_count_list']/li/span"));
		
		//select an specific option
		for(int i=0; i< stroies.size(); i++) {
			if(stroies.get(i).getText().equalsIgnoreCase("30+ Patient Stories")) {      
				stroies.get(i).click();
				break;
			}
		}
		
	}
	
	public void clickExperience() {
		experience.click();
		//dropDown option
		List<WebElement> experienceOpt =driver.findElements(By.xpath("//ul[@data-qa-id='years_of_experience_list']/li/span"));
		
		//select an specific option
		for(int i=0; i< experienceOpt.size(); i++) {
			if(experienceOpt.get(i).getText().equalsIgnoreCase("5+ Years of experience")) {      
				experienceOpt.get(i).click();
				break;
			}
		}	
	}
	
	public void clickAllFilters() throws InterruptedException {
		allFilters.click();
		
		WebDriverWait mywait= new WebDriverWait(driver,Duration.ofSeconds(50));
		//select fees
		WebElement selFees= mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='Fees1']")));
		selFees.click();
		System.out.println("fees selected");
		Thread.sleep(10000);
		//select availibility
		//WebElement selAval=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-qa-id='Available Today_label']/span[contains(text(),'Available Today')]")));

		WebElement selAval=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-qa-id='Available Today_label']/span")));
		selAval.click();
		System.out.println("availibity selected");
		Thread.sleep(5000);		
	}
	
//	public void clickAllFilters() throws InterruptedException {
//		allFilters.click();
//		
//		Thread.sleep(5000);
//		//*****************select fees*******************
//		
//		List<WebElement> feesRadioBtn=driver.findElements(By.xpath("//*[@class='c-filter__bottom expanded']/div[@class='o-page-container u-cushion--vertical pure-g']/div[2]/div[1]/label/input"));
//		Thread.sleep(5000);
//		//select an specific option
//		for(int i=0; i< feesRadioBtn.size(); i++) { 
//			System.out.println("fees ***********");
//			if(feesRadioBtn.get(i).getCssValue("id") == "Fees1") {
//			//if(feesRadioBtn.get(i).getCssValue("value") == "Above ₹500") {
//			//if(feesRadioBtn.get(i).getText().equalsIgnoreCase("Experience - High to Low")) {      
//				feesRadioBtn.get(i).click();
//				System.out.println("fees selected");
//				break;
//			}
//		}
//				
//		Thread.sleep(5000);		
//		
//		//**********************************Select availability*************************
//		
//		List<WebElement> avalRadioBtn=driver.findElements(By.xpath("//*[@class='c-filter__bottom expanded']/div[@class='o-page-container u-cushion--vertical pure-g']/div[3]/div[1]/label/input"));
//		Thread.sleep(5000);
//		//select an specific option
//		for(int i=0; i< avalRadioBtn.size(); i++) { 
//			System.out.println("availibity ********");
//			if(avalRadioBtn.get(i).getCssValue("id") == "Availability1") {
//			//if(avalRadioBtn.get(i).getCssValue("value") == "Above ₹500") {
//			//if(avalRadioBtn.get(i).getText().equalsIgnoreCase("Experience - High to Low")) {      
//				avalRadioBtn.get(i).click();
//				System.out.println("availibity selected");
//
//				break;
//			}
//		}
//		Thread.sleep(5000);
//		
//	}
	
	
	@FindBy(xpath= "//label[@for='Fees1']")
	public WebElement fees;
	public void clickFees() {
		fees.click();
	}
	
	public void clickAvalibility() {
		avalibility.click();	
	}
	
	

	@FindBy(xpath= "//*[@data-qa-id='sort_by_selected']")
	public WebElement sortBy;
	public void clickSortBy() {
		sortBy.click();
		//dropDown
		List<WebElement> sortByOptions =driver.findElements(By.xpath("//*[@data-qa-id='sort_by_list']/li/span"));
		
		//select an specific option
		for(int i=0; i< sortByOptions.size(); i++) {
			if(sortByOptions.get(i).getText().contains("High to Low")) { 
			//if(sortByOptions.get(i).getText().equalsIgnoreCase("Experience - High to Low")) {      
				sortByOptions.get(i).click();
				break;
			}
		}
		
	}


	
	
	
	
	
	
	
	
	
	
	
	

}
