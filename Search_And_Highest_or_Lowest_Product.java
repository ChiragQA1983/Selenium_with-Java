package Practice_Tutorial;

import java.time.Duration;
import java.util.List;
import java.util.Map.Entry;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search_And_Highest_or_Lowest_Product {

	@Test
	public void Search_And_Highes_or_Lowest_Product() {
	
		// Youtube - Selenium | Real Time Scenario | Selecting highest or lowest priced product from the search
		// https://www.youtube.com/watch?v=1neYl3_DNIo
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Inspect and Locate the WebElement Searchbox and SendKeys 
		WebElement searchbox =driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("Mobile phones");
		
		//Click on the Search Button
		WebElement searchButton=driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		
		//Find All the Price WebElements and Store into Variable priceElements
		List<WebElement>priceElements=driver.findElements(By.cssSelector("[class='a-price-whole']"));
		Map<WebElement, Integer> map=new HashMap<WebElement, Integer>();
		
	
		//ForLoop Fetch and will print the Price of All WebElements using .get and getText
		// and using replaceAll we will , comma which will come with prices with null value as below
		
		for(int i=0; i<priceElements.size();i++)
		{
			if(priceElements.get(i).getText() !="")
			map.put(priceElements.get(i), Integer.parseInt(priceElements.get(i).getText().replaceAll(",","")));
				
			//System.out.println(Integer.parseInt(priceElements.get(i).getText().replaceAll(",","")));
			//Now Value Will Converted into the Integer and	 All the Commas Will Got Removed
		}
		
	   List<Entry<WebElement, Integer>>le=new ArrayList<Map.Entry<WebElement, Integer>>(map.entrySet());
	   le.sort(Entry.comparingByValue());
	   
	   for(Entry e : le) {
		   System.out.println(e.getValue());
	   }
		
	}

}
