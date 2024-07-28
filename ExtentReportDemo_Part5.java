package Practice_Tutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo_Part5 {

	public HTMLReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@Test
	public void extentreport() throws IOException
	{
	
	 ExtentReports extent =new ExtentReports();
	 
	 // We are customizing ExtentReport view as per Our Requirements and Remove some tag also
	 ExtentSparkReporter spark = new ExtentSparkReporter("index.html").viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.TEST,ViewName.CATEGORY}).apply();
	 ExtentSparkReporter failedspark=new ExtentSparkReporter("failed-tests-index.html").filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
	 failedspark.config().setDocumentTitle("Failed Tests");
	 
	 final File CONF=new File("extentconfig.json"); 
	 spark.loadJSONConfig(CONF);

	 extent.attachReporter(spark, failedspark);
	 
	 ExtentTest test=extent.createTest("Login Test").assignAuthor("Chirag Bhatt").assignCategory("Smoke Test").assignCategory("Regression").assignDevice("Chrome"); //Create a Test Node In the Report
	 test.pass("Login Test started successfully"); //Create a Test Step Node in the Report
	 test.info("URL is Loaded");
	 test.info("Values Entered");
	 test.pass("Login Test Completed Successfully");
	 
	 //to print log line in different line in extentreport use below
	// Arrays.asList(new String[] {"Selenium", "Appium", "Rest Assured"}).forEach(test::pass);
	 
	 //to print log line in single tab in extentreport use below
	// test.pass(MarkupHelper.createOrderedList(Arrays.asList(new String[] {"Selenium", "Appium", "Rest Assured"})).getMarkup());
	 
	 //if we don't won't to print number with list than use unorder as below
	 test.pass(MarkupHelper.createUnorderedList(Arrays.asList(new String[] {"Selenium", "Appium", "Rest Assured"})).getMarkup());
	 
	 //print keyvalue pair in single line in report
	 Map<String, String> map=new HashMap<>();
	 map.put("fname", "Amuthan");
	 map.put("lname", "Saktivel");
	 map.put("channellname", "Testmanial");
	 
	 map.forEach((k, v)->test.pass(k+":"+v));
	 
	// test.pass(MarkupHelper.createOrderedList(map).getMarkup());
	 test.pass(MarkupHelper.createUnorderedList(map).getMarkup());
	 test.pass(MarkupHelper.createLabel("Login Test Completed Successfully", ExtentColor.GREEN));
	 
	 // Need to press 'L' from keyboard for change the theme into standard theme
	 
	 ExtentTest test1=extent.createTest("HomePage Test").assignAuthor("Sachin").assignCategory("Smoke").assignDevice("Firefox"); //Create a Test Node In the Report
	 test1.fail("HomePage Test Failed"); //Create a Test Step Node in the Report
	 test1.info("URL is Loaded");
	 test1.info("Values Entered");
	 test1.fail("HomePage Test Fail");
	 test1.fail(MarkupHelper.createLabel("Login Test got failed", ExtentColor.RED));
	 
	 extent.flush(); //Unless you call this method, your report will not be written with logs
	 Desktop.getDesktop().browse(new File("index.html").toURI()); //open the file in the Desktop default browser 
	 Desktop.getDesktop().browse(new File("failed-tests-index.html").toURI());	
		
/*	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
    driver.get("http://seleniumpractise.blogspot.com/");
    driver.manage().window().maximize(); */
	
	 

	}
	
}
	
	 // Change the viewing Order
	  // Remove some tag from report
	  //Extent Report Latest - 5.0.5 - Customized Extent Report - Part V
	  //https://www.youtube.com/watch?v=sYxVLK23WqY&list=PL9ok7C7Yn9A-yUEnE62gOQ2B4pL3gsC28&index=5
	   // Highlight Particular Logline
	   // List of string -> How can highlight  
	 // Map<String>, String --> How can we print
	//Extent Report Latest - 5.0.5 - Customized Extent Report - Part V
