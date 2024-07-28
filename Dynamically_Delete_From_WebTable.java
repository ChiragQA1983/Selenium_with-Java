package Practice_Tutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
public class Dynamically_Delete_From_WebTable {
		
	static WebDriver driver;
	
	public void Delete(String department, WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='"+department+"']//following::td[3]//descendant::i[@title='Delete']"))).click();
		System.out.println(department);
	}
	
	
	
	
	
	@Test
	public void Delete_TableData_Dynamically() throws InterruptedException {
		
		
		//https://demo.openmrs.org/openmrs/login.htm
		
		//Writing dynamic xpath to delete any row in the table using selenium Java
		
		//https://www.youtube.com/watch?v=zONBbCMbndY
		
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.openmrs.org/openmrs/appointmentschedulingui/manageAppointmentTypes.page");
	
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("Admin");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Admin123");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='Inpatient Ward']"))).click();
		
		////input[@id='loginButton']
		
		////i[@class='icon-tasks']
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginButton']"))).click();
		
		
		/*wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon-tasks']"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Manage Privileges"))).click();*/
		
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='Gynecology']//following::td[3]//descendant::i[@title='Delete']"))).click();
		
		Thread.sleep(4000);
		
		Dynamically_Delete_From_WebTable delete=new Dynamically_Delete_From_WebTable();
		delete.Delete("Infectious Disease (New Patient)", driver);
		
		
		
		
		
		
	////td[text()='Gynecology']/following::td[3]/descendant::i[@title="Delete"]	
		
		
	}

	
}
