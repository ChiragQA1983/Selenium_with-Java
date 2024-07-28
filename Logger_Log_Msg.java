package Practice_Tutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.*;


public class Logger_Log_Msg {

	public static void main(String[] args) {
		
		
  // We would be able to Log our message through XML file and Log4j2.properties file below way		
  // We Configure Log4j2.properties file as below mentioned in comment section at end of this program		
		
	Logger log=LogManager.getLogger("Calender_Hanlding");	
		
	log.info("This is for Log info");
	log.debug("For Debug");
	log.error("For error Only");
	log.warn("Warning Message");
	WebDriver driver=new ChromeDriver();	

	driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
	driver.findElement(By.id("datepicker")).click();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));

	String aMonth=driver.findElement(By.className("ui-datepicker-month")).getText();
	String aYear=driver.findElement(By.className("ui-datepicker-year")).getText();
	
	while(!(aMonth.equals("July") && aYear.equals("2024")))
	{
		 driver.findElement(By.xpath("//a[@data-handler='next']")).click();
		 aMonth=driver.findElement(By.className("ui-datepicker-month")).getText();
		 aYear=driver.findElement(By.className("ui-datepicker-year")).getText();
	}
	
	driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='23']")).click();
	
	}

}

//https://www.youtube.com/watch?v=ThVgu0dmhNY
//Selenium Webdriver with Java in Hindi #38- Log4j2 Logging Framework | Practical Demonstration

/*log4j2.properties file which is located in our project path
 * D:\AUTOMATION ALL\FrameWorkBasics\com.sauce.practice\src\main\resource\log4j2.properties 
 * ------------------------------log4j2.properties-------------------------------------------
 * # PropertiesConfig
name=PropertiesConfig

property.filename=logs

# Define appenders
appenders=console, file

# Console Appender Configuration
appender.console.type=Console
appender.console.name=STDOUT
appender.console.layout.type=PatternLayout
appender.console.layout.pattern=[%-5level]%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %logger{36} - %msg%n

# File Appender Configuration (Replace 'FileName' and 'FilePattern' with your desired values)
appender.file.type=File
appender.file.name=LogFile
appender.file.fileName=${filename}/application.log
appender.file.layout.type=PatternLayout
appender.file.layout.pattern=%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %logger{36} - %msg%n

# Root logger
rootLogger.level = debug
rootLogger.appenderRefs = console, file
rootLogger.appenderRef.console.ref = STDOUT
rootLogger.appenderRef.file.ref = LogFile  */


