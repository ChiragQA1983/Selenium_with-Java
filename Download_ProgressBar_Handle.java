package Practice_Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Download_Process_Handle {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/progress-bar/");
		driver.manage().window().maximize();	


	
	WebElement iframe=driver.findElement(By.xpath("//*[@id=\"post-2671\"]/div[2]/div/div/div[1]/p/iframe"));
	
	driver.switchTo().frame(iframe);	
	WebElement Download=driver.findElement(By.id("downloadButton"));
	Download.click();	
	
	// Wait for the progress bar to appear
    WebElement progressBar = new WebDriverWait(driver, Duration.ofSeconds(10))
    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='progressbar']")));

	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    
	boolean progressStatus=wait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "100"));
	if(progressStatus==true) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='ui-button ui-corner-all ui-widget']"))).click();
	}

}
}
