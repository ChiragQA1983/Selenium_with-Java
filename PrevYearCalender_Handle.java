package Practice_Tutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrevYearCalender_Handle {

	public static void main(String[] args) {
		
	WebDriver driver=new ChromeDriver();	
	driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
	driver.manage().window().maximize();
	
	driver.findElement(By.id("datepicker")).click();
	
	
	// We declare the wait for entire calender by finding the xpath of entire calender
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='ui-datepicker-calendar']")));
	
	String currentmonth=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-month"))).getText();
	String currentyear=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-year"))).getText();
	
	//Logic
	while(!(currentmonth.endsWith("June") && currentyear.equals("2022")))
	{
		driver.findElement(By.xpath("//a[@data-handler='prev']")).click();
		currentmonth=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-month"))).getText();
		currentyear=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-year"))).getText();
		
	}
	
	driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='6']")).click();

	}

}
//Youtube Link ->How to select a date in a Calendar on a web page using Selenium (Selenium Interview Question #236)
//https://www.youtube.com/watch?v=vu9Sm1EszEQ