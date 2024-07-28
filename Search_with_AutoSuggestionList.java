package Practice_Tutorial;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.firefox.*;


public class Search_with_AutoSuggestionList {

	public static void main(String[] args) throws InterruptedException {
	
    
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
			
	//driver.get("https://www.globalsqa.com/demo-site/auto-complete/#Categories");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.get("https://www.bing.com/");
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	//driver.manage().deleteAllCookies();
	
	
	
	driver.findElement(By.id("APjFqb")).sendKeys("java tutorial");
	
	Thread.sleep(3000);
	//driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
	
//	List<WebElement>list=driver.findElements(By.xpath("//li[@class='sa_sg as_extra_pad']//span"));
	
	List<WebElement>list=driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]//span"));
	
	System.out.println("Size of Auto Suggestion :" + list.size());

	for(WebElement listitem:list)
	{	
		
	  if(listitem.getText().contains("beginners"))
	  {	  
		 Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		  break;
	   }
		
	 } 
	
	//driver.quit();
	}
}
