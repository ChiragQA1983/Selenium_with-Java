package pop_handle;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class alert_handle {
	public static String Browser="chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		
	
		
		driver.get("https://infisquare.com/");
		//WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"paoc-popup-5262-1\"]/button/svg/path']"));
		//closeButton.click();
	    driver.manage().window().maximize();
	    
	   
	    
	    driver.findElement(By.cssSelector("#paoc-popup-5262-1 > button > svg > path")).click();
	    
	    Thread.sleep(10000);
	    
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).build().perform();
	    
        //Verify that top side links are clickable and working properly
	   
        driver.findElement(By.xpath("//*[@id=\"menu-item-3409\"]/a")).click();
        
        driver.findElement(By.linkText("Home")).click();
	   
	    driver.findElement(By.linkText("Category")).click();
	   
	    driver.findElement(By.linkText("Products")).click();
	    
	    driver.findElement(By.partialLinkText("Request")).click();
	    
	    driver.findElement(By.partialLinkText("Contact")).click();
	    
	  
	    
	    //Actions action = new Actions(driver);
		//action.moveToElement(element).perform();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Who"))).click();
		
		
	    
	   // WebDriverWait wait = new WebDriverWait(driver, 10);
	   // wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Who"))).click();
	   
	    
	    
	    
	 
	    
	    
	
	    
	
	   
				
		
	    


	    
	    
	    
	 
	    
	}

}
