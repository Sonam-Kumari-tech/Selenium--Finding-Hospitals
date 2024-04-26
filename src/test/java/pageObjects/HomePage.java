package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Screenshots;

public class HomePage {

	WebDriver driver;
	
//	public HomePage(WebDriver driver) {
//		super(driver);
//	}
	
	public static String path;
	//constructor
	   public HomePage(WebDriver driver){
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   }

	@FindBy(xpath= "//input[@data-input-box-id='omni-searchbox-locality']")
	public WebElement city;
	public void setCity() {
		city.clear();
		city.sendKeys("Bangalore");
	}
	

	@FindBy(xpath= "//input[@data-input-box-id='omni-searchbox-keyword']")
	public WebElement findDoctors;
	public void setDoctorType() {
		findDoctors.clear();
		findDoctors.sendKeys("Dentist");
		//findDoctors.sendKeys(Keys.ENTER);
		
//		Actions act= new Actions(driver);
//		act.sendKeys(Keys.ENTER).perform();
		//act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}
	

	
	//surgeries 
	@FindBy(xpath="//div[@class='product-tab__title'][normalize-space()='Surgeries']")
	WebElement surgeries;
	public void clickSurgeries() {
		surgeries.click();
	}
	
	//for corporate
	@FindBy(xpath="//span[@class='nav-interact']")
	WebElement forCorporate;
	public void clickForCorporate() throws InterruptedException, IOException {
		forCorporate.click();
		Thread.sleep(3000);
		//dropDown
		List<WebElement> corporateOptions =driver.findElements(By.xpath("//div[@class='nav-right text-right']/div/span/div/div/a"));
		
		//select an specific option
		for(int i=0; i< corporateOptions.size(); i++) {
			if(corporateOptions.get(i).getText().equalsIgnoreCase("Health & Wellness Plans")) {   
				path= Screenshots.takeScreenshot(driver, "For Corporate dropdown");
				corporateOptions.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
		
	}
	

}
