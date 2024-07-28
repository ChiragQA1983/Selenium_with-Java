package Practice_Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class ExtentReportDemo_Part4 {

	public HTMLReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@Test
	public void extentreport() throws IOException
	{
	
	 

	}
	 
@Test
     public void ReportExperiment() throws IOException, InterruptedException
      {
	
	 ExtentReports extent =new ExtentReports();
	 // We are customizing ExtentReport view as per Our Requirements and Remove some tag also
	 ExtentSparkReporter spark = new ExtentSparkReporter("index.html").viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.TEST,ViewName.CATEGORY}).apply();
	 ExtentSparkReporter failedspark=new ExtentSparkReporter("failed-tests-index.html").filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
	 failedspark.config().setDocumentTitle("Failed Tests");
	 
	 final File CONF=new File("extentconfig.json"); 
	 spark.loadJSONConfig(CONF);

	 	extent.attachReporter(spark, failedspark);
	 
	 	ExtentTest test=extent.createTest("IFrameSwitching and Alert Handling").assignAuthor("Chirag Bhatt").assignCategory("Smoke Test").assignDevice("Firefox"); //Create a Test Node In the Report

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();
     
		//Step 1 :- locate child element ById, ByName, By Index
		WebElement iframe2=driver.findElement(By.id("iframeResult"));
		
		//Step 2 :- Switch to child window iframe and passing argument of webelement
		driver.switchTo().frame(iframe2);
		
		//Step 3:- Perform required operation 
		driver.findElement(By.xpath("/html/body/button")).click();
		
		//Step 4:- Get the alert text if we want and print it
	    String alerttext= driver.switchTo().alert().getText();
	    System.out.println(alerttext);
	    
	    //Step 5 :-Accept or dismiss the alert 
	    Thread.sleep(2000);
	    driver.switchTo().alert().accept();
		
	    //Step 6 :- Switchback to parentwindow and gettitle of parentwindow
		Thread.sleep(2000);
	    driver.switchTo().defaultContent().getTitle();
	    
	    //Step7:- Print the title
	    System.out.println(driver.getTitle());

	 
	 extent.flush(); //Unless you call this method, your report will not be written with logs
	 Desktop.getDesktop().browse(new File("index.html").toURI()); //open the file in the Desktop default browser 
	 Desktop.getDesktop().browse(new File("failed-tests-index.html").toURI());	

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
