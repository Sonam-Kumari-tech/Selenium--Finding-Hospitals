package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.HospitalFiltersPage;
import testBase.BaseClass;
import utilities.ExcelUtility;
import utilities.Screenshots;
import utilities.ScrollToElement;

public class TC_001_SearchDoctorsTest extends BaseClass{
	
	public static String path;
	HospitalFiltersPage hfp= new HospitalFiltersPage(driver);
	
	
		
	@Test(priority=1)
	 public void searchDoctors() throws InterruptedException, IOException {	
	
		HomePage homepage= new HomePage(driver);
		logger.info("Starting TC_001_SearchDoctors");
		homepage.setCity();
		homepage.setDoctorType();
		path= Screenshots.takeScreenshot(driver, "HomePage");
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.practo.com/search/doctors?results_type=doctor&q=%5B%7B%22word%22%3A%22dentist%22%2C%22autocompleted%22%3Atrue%2C%22category%22%3A%22subspeciality%22%7D%5D&city=Bangalore");

		Thread.sleep(3000);
		
		HospitalFiltersPage hf= new HospitalFiltersPage(driver);
		String text=hf.bookAppointmentSection();
		Assert.assertEquals(text,"Book appointments with minimum wait-time & verified doctor details");	  
	 }
	
	@Test(priority=2, dependsOnMethods= {"searchDoctors"})

  public void seachDoctorsWithFilters() throws InterruptedException, IOException {
		

		HospitalFiltersPage hfp= new HospitalFiltersPage(driver);

		Thread.sleep(5000);
		hfp.clickPatientStiories();

		Thread.sleep(5000);
		hfp.clickExperience();
		Thread.sleep(5000);

		hfp.clickSortBy();
		Thread.sleep(5000);

		hfp.clickAllFilters();
		Thread.sleep(5000);
		
		path= Screenshots.takeScreenshot(driver, "Applied Filters");
		
		
  }
	
	
	@Test(priority=3)
	public void printDoctors() {
//		ScrollToElement sr= new ScrollToElement(driver);
//		sr.scroll(hfp.availableDoctors);
		

		List<String> doctorNameList= new ArrayList<String> ();
		System.out.println("**********List of top 5 doctors ************");
		for(int i=3; i<9;i++) {
			if(i==7) {
				continue;
			}
			String doctor= driver.findElement(By.xpath("//div[@class='uv2-spacer--jumbo-xl-hz']/div["+i+"]/div/div/div/div[2]/a/div")).getText();	
			doctorNameList.add(doctor);
		}
		for(String name : doctorNameList) {
			System.out.println(name);
		}
	}
	
	
	
	@Test(priority=4)
	public void printDetails() throws IOException {
		List<String> doctorDetails= new ArrayList<String> ();
		ExcelUtility et = new ExcelUtility(System.getProperty("user.dir") + "\\testData\\DoctorDetails.xlsx");
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
			
			et.setCellData("Doctor", i-3, 0, name);
			et.setCellData("Doctor", i-3, 1, specilist);
			et.setCellData("Doctor", i-3, 2, experience);
			et.setCellData("Doctor", i-3, 3, address);
		}
		for(String details : doctorDetails) {
			System.out.println(details);	
		}
		System.out.println("------------------------------------");
		doctorDetails.clear();
		logger.info("Finished TC_001_SearchDoctors");
	}
	
	
}
