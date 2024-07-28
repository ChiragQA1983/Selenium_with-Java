package Practice_Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo_Part3 {

	public HTMLReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	//This is Extend Report V5 (Version 5)
	// Report To have only failed test cases
	 //https://www.youtube.com/watch?v=mkJz37boFyU&list=PL9ok7C7Yn9A-yUEnE62gOQ2B4pL3gsC28&index=3
	 //Extent Reports Latest - 5.0.5 - Creating a report with only failed tests - Part III
	
	@Test
	public void extentreport() throws IOException
	{
	
	 ExtentReports extent =new ExtentReports();
	 ExtentSparkReporter spark = new ExtentSparkReporter("index.html");	
	 
	 
	 ExtentSparkReporter failedspark=new ExtentSparkReporter("failed-tests-index.html").filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
	 failedspark.config().setDocumentTitle("Failed Tests");
	 
	 final File CONF=new File("extentconfig.json"); 
	 spark.loadJSONConfig(CONF);

	 extent.attachReporter(spark, failedspark);
	 
	 ExtentTest test=extent.createTest("Login Test").assignAuthor("Chirag Bhatt").assignCategory("Smoke Test").assignCategory("Regression").assignDevice("Chrome"); //Create a Test Node In the Report
	  //Create a Test Step Node in the Report
	
	 
	}
	
	@Test
	 
	    public void instanstiation()
	    {
	    	
	    test.pass("Login Test started successfully");
	    WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		 test.info("URL is Loaded");
		driver.manage().window().maximize();
		
		test.pass("Login Test Completed Successfully");

		WebElement frame1 = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame1);

		driver.findElement(By.xpath("/html/body/button")).click();

		//Note :- If Browser is not updated or having any issue in that case some functionality like in this program
		// Will not be handle like chrome browser having an issue so, not working in chrome but working in other
		//browsers
		
		//Handle the alert
		
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		test.info("Values Entered");

		// We are accepting the alert or it we want we can dismiss the alert using .dismiss() method
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		// Switch back to the parent window (default content)
		//driver.switchTo().defaultContent();
		
		// For Switch Back to MainFrame we can use either parentFrame() as below or defaultContent() as above
		driver.switchTo().parentFrame();

		// Get the title of the parent window
		System.out.println(driver.getTitle());

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 // Need to press 'L' from keyboard for change the theme into standard theme
	 
	 ExtentTest test1=extent.createTest("HomePage Test").assignAuthor("Sachin").assignCategory("Smoke").assignDevice("Firefox"); //Create a Test Node In the Report
	 test1.pass("HomePage Test Started successfully"); //Create a Test Step Node in the Report
	 test1.info("URL is Loaded");
	 test1.info("Values Entered");
	 test1.fail("HomePage Test Fail");
	 
	 extent.flush(); //Unless you call this method, your report will not be written with logs
	 Desktop.getDesktop().browse(new File("index.html").toURI()); //open the file in the Desktop default browser 
	 Desktop.getDesktop().browse(new File("failed-tests-index.html").toURI());	
		
/*	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
    driver.get("http://seleniumpractise.blogspot.com/");
    driver.manage().window().maximize(); */
	
	 

	}
	
}
