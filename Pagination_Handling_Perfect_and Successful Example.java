package Practice_Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import java.util.List;
public class Pagination_Handling
{

	@Test
	public void Pagination_Handle() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		driver.manage().window().maximize();

		//Capture all the NameElement from WebTable
		List<WebElement> namesElements=driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
		
		//What Name Data We Capture We will Store in ArrayList
		List<String>names=new ArrayList<String>();
		
		
		
		//How to Handle Pagination in Selenium Webdriver | How to Handle Dynamic WebTable|Webtable Pagination
		//https://www.youtube.com/watch?v=jD5eWhNsaRk
		
		for(WebElement namesElement:namesElements)
		{
			names.add(namesElement.getText());
		}
		
		String nextButtonClassName=driver.findElement(By.id("example_next")).getAttribute("class");
		
		while(!nextButtonClassName.contains("disabled"))
		{
			driver.findElement(By.id("example_next")).click();
			namesElements=driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
			
			for(WebElement namesElement:namesElements)
			{
				names.add(namesElement.getText());
			}
			
			nextButtonClassName=driver.findElement(By.id("example_next")).getAttribute("class");
		}
		
		for(String name : names)
		{
			System.out.println(name);
		}
		
		int totalNames=names.size();
		System.out.println("Total Numbers of Names :" +totalNames);
		
		String displayedCount=driver.findElement(By.id("example_info")).getText().split(" ")[5];
		
		System.out.println("Total number of Displayed Names count:" + displayedCount);
		
		Assert.assertEquals(displayedCount, String.valueOf(totalNames));
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
		
		
	}
}
		
		
		//How to Handle Pagination in Selenium Webdriver | How to Handle Dynamic WebTable|Webtable Pagination
		//https://www.youtube.com/watch?v=jD5eWhNsaRk
		
			



