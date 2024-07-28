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


public class Select_Search_AutoSuggestion_Click_the_Desire_Option {

	public static void main(String[] args) throws InterruptedException {
	
    
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
			
	driver.get("https://www.globalsqa.com/demo-site/auto-complete/#Categories");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.get("https://www.bing.com/");
	//driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	//driver.manage().deleteAllCookies();
	

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement iframe = driver.findElement(By.xpath("//*[@id=\"post-2656\"]/div[2]/div[1]/div/div[1]/p/iframe"));
driver.switchTo().frame(iframe);

Thread.sleep(2000);

WebElement searchBox = driver.findElement(By.id("search"));
searchBox.click();

Thread.sleep(3000);
	
	try {
	driver.findElement(By.id("search")).sendKeys("a");
	}catch(StaleElementReferenceException e)
	{
		System.out.println("Stalement Element Exception Handle successfully");
		e.printStackTrace();
	}
	List<WebElement> list = driver.findElements(By.xpath("//li[@class='ui-menu-item']//div[@class='ui-menu-item-wrapper']"));

	System.out.println("Size of Auto Suggestion: " + list.size());

	Actions action = new Actions(driver);

	for (WebElement listItem : list) {
	    if (listItem.getText().equals("anders andersson")) {
	       listItem.click(); // Click the desired option
	        Thread.sleep(1000); // Add a small delay if needed before pressing Enter
	        //action.sendKeys(Keys.ENTER).perform(); // Press Enter after clicking the option
	        break;
	    }
	    //action.sendKeys(Keys.ARROW_DOWN).perform();
	    Thread.sleep(1000); // Adjust this wait time as needed
	}
	}
}