package Practice_Tutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo_Part1 {

	public HTMLReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	//This is Extend Report V5 (Version 5)
	
	@Test
	public void extentreport()
	{
	
	 ExtentReports extent =new ExtentReports();
	 ExtentSparkReporter spark = new ExtentSparkReporter("index.html");		 
	 extent.attachReporter(spark);
	 spark.config().setTheme(Theme.DARK);
	 spark.config().setDocumentTitle("Automation Report");
	 spark.config().setReportName("Extent Reports Demo");
	 extent.attachReporter(spark);
	 
	 ExtentTest test=extent.createTest("Login Test").assignAuthor("Chirag Bhatt").assignCategory("Smoke Test").assignCategory("Regression").assignDevice("Chrome"); //Create a Test Node In the Report
	 test.pass("Login Test started successfully"); //Create a Test Step Node in the Report
	 test.info("URL is Loaded");
	 test.info("Values Entered");
	 test.pass("Login Test Completed Successfully");
	 
	 // Need to press 'L' from keyboard for change the theme into standard theme
	 
	 ExtentTest test1=extent.createTest("HomePage Test").assignAuthor("Sachin").assignCategory("Smoke").assignDevice("Firefox"); //Create a Test Node In the Report
	 test1.pass("HomePage Test Started successfully"); //Create a Test Step Node in the Report
	 test1.info("URL is Loaded");
	 test1.info("Values Entered");
	 test1.fail("HomePage Test Fail");
	 
	 extent.flush(); //Unless you call this method, your report will not be written with logs
	 
		
		
/*	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
    driver.get("http://seleniumpractise.blogspot.com/");
    driver.manage().window().maximize(); */
	
	 
//https://www.youtube.com/watch?v=MHgSAmDXIWs&list=PL9ok7C7Yn9A-yUEnE62gOQ2B4pL3gsC28	 
	 
//Extent Reports Latest - 5.0.5 - How to create a simple extent report - Part I	 
	}
	
}
