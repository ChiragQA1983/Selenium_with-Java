package Practice_Tutorial;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_with_SendKeys {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();	
		
	  WebElement childframe=driver.findElement(By.id("iframeResult"));
	  
	  driver.switchTo().frame(childframe);
	  
	  driver.findElement(By.xpath("/html/body/button")).click();
	  
	  
	  Alert alert=driver.switchTo().alert();
	  alert.sendKeys("Chirag Bhatt");
	  alert.accept();
	  
	  

	}

}
