package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;

import testBase.BaseClass;
import utilities.Screenshots;

public class TC_003_HealthAndWellness extends BaseClass{
	
	public static String path;
	
	@Test(priority=1)
	public void validateForCorporate() throws InterruptedException, IOException {
		Thread.sleep(3000);
		logger.info("Started TC_003_HealthAndWellness");
		HomePage hp= new HomePage(driver);
		hp.clickForCorporate();
		Assert.assertEquals(driver.getTitle().contains("Health & Wellness Plans"),true);
		
	}

	
	@Test(priority = 2)
    public void invalidEmailId() throws InterruptedException, IOException {
 
        // Fill in the form with valid details
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement name=myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"name\"]")));
        //driver.findElement(By.xpath("//*[@id=\"name\"]"));
        name.clear();
        name.sendKeys("Sonam");
 
        WebElement organizationName = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"organizationName\"]")));
        organizationName.clear();
        organizationName.sendKeys("Cognizant");
 
        WebElement contactNumber = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'contactNumber']")));
        contactNumber.clear();
        contactNumber.sendKeys("9798716500");
 
        WebElement emailId = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'officialEmailId']")));
        emailId.clear();
        emailId.sendKeys("abc123gmail.com");
 
        WebElement organizationSize = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='organizationSize']")));
        Select organization = new Select(organizationSize);
        organization.selectByVisibleText("501-1000");
 
        WebElement interestedIn = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = \"interestedIn\"]")));
        Select interest = new Select(interestedIn);
        interest.selectByVisibleText("Referring someone");
 
        Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();
        WebElement submitButton = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Schedule a demo')]")));
        softAssert.assertEquals(submitButton.isEnabled(), false);
        softAssert.assertAll();
        System.out.println("after entering invalid emailId---> Schedule a demo btn is disabled");
        path= Screenshots.takeScreenshot(driver, "Schedule a demo Form with invalid emailId");
    }
	
	@Test(priority = 3)
    public void validateThankYou() throws InterruptedException, IOException {
 
        // Fill in the form with valid details
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement name=myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"name\"]")));
        driver.findElement(By.xpath("//*[@id=\"name\"]"));
        name.clear();
        name.sendKeys("Sonam");
 
        WebElement organizationName = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"organizationName\"]")));
        organizationName.clear();
        organizationName.sendKeys("Cognizant");
 
        WebElement contactNumber = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'contactNumber']")));
        contactNumber.clear();
        contactNumber.sendKeys("9798716500");
 
        WebElement emailId = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'officialEmailId']")));
        emailId.clear();
        emailId.sendKeys("abc123@gmail.com");
 
        WebElement organizationSize = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='organizationSize']")));
        Select organization = new Select(organizationSize);
        organization.selectByVisibleText("501-1000");
 
        WebElement interestedIn = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = \"interestedIn\"]")));
        Select interest = new Select(interestedIn);
        interest.selectByVisibleText("Referring someone");
 
        Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();
        WebElement submitButton = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Schedule a demo')]")));
        softAssert.assertEquals(submitButton.isEnabled(), true);
        path= Screenshots.takeScreenshot(driver, "Schedule a demo Form with valid details");
        submitButton.click();
        
        
        WebElement thanx = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div[1]")));
        softAssert.assertEquals(thanx.getText(), "THANK YOU"); 
        softAssert.assertAll();
        path= Screenshots.takeScreenshot(driver, "Thankyou page");
        System.out.println("after clicking Schedule a demo btn ---> THANK YOU msg is displayed");
  	    logger.info("Finished TC_003_HealthAndWellness");

    }
	

	

}
