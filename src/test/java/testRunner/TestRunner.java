package testRunner;


import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class) 
@CucumberOptions(
		features = {"C:\\Users\\2320195\\eclipse-workspace\\FindingHospitals\\features\\ScheduleDemo.feature",
		"C:\\Users\\2320195\\eclipse-workspace\\FindingHospitals\\features\\SearchDoctors.feature",
		"C:\\Users\\2320195\\eclipse-workspace\\FindingHospitals\\features\\ListOfSurgeries.feature" },
		//features = {"C:\\Users\\2320195\\eclipse-workspace\\FindingHospitals\\features\\SearchDoctors.feature"},
		
		dryRun = true,
		glue = {"stepDefinitions"},
		monochrome = true,
		plugin = {"pretty","html:reports/cucumberReports.html",
				  "rerun:target/rerun.txt",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	
		)
 
@Test(priority = 1000)
public class TestRunner {
}

