package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Features/customer.feature"},
	
		glue = {"stepDefinations"},
		dryRun = false,
		monochrome = true
		
	
		//{"pretty","html:target/HtmlReports.html"}
	    //plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)


public class TestRun   {

}
/*
@RunWith(Cucumber.class)
@CucumberOptions(
	    
		features= {"./src/test/resources/Features/Orders.feature"}, // path of the feature file
		tags= "@OrdersN",
		glue= {"applicationHooks","stepDefination"},                //provide step definition package name
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} // using for  Reporting purpose 
	)
public class TestRunner {
	//extends AbstractTestNGCucumberTests
	
	

}*/