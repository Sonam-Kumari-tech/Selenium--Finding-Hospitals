package testCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SurgeriesPage;
import testBase.BaseClass;

public class TC_002_ListOfSurgeries extends BaseClass {
  @Test(priority=1)
  public void findSurgeries() throws InterruptedException {
	  Thread.sleep(3000);
	  logger.info("Started TC_002_ListOfSurgeries");

	  
	  HomePage hp= new HomePage(driver);
	  hp.clickSurgeries();
	  
	  SurgeriesPage sp= new SurgeriesPage(driver);
	  List<WebElement> surgeryList= sp.surgeryList();
	  System.out.println("*******List of surgeries*******");
	  for(int i=0; i< surgeryList.size(); i++) {
		  String surgeryName= surgeryList.get(i).getText();
		  System.out.println(surgeryName);
	  }  
	  System.out.println("-----------------------------------------------------S");
	  
	  logger.info("Finished TC_002_ListOfSurgeries");
  }
  
  
}
