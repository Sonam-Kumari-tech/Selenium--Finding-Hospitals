package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SurgeriesPage {

	WebDriver driver;
//	public SurgeriesPage(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}
	
	//constructor
	   public SurgeriesPage(WebDriver driver){
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   }
	

	By surgeries = By.xpath("//*[@data-qa-id='surgical-solution-ailment-name']");
	public List<WebElement> surgeryList(){
		return driver.findElements(surgeries);
	}
	   


}
