package Practice_Tutorial;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
public class Handle_Pagination_Selenium {

	@Test
	public void Handle_Paginate_Selenium() throws InterruptedException 
	{
		
		//How to Handle Pagination in Selenium Webdriver | How to Handle Dynamic WebTable |Webtable Pagination
		//https://www.youtube.com/watch?v=p3q_Wy4AjHs&t=1627s
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		
		driver.manage().window().maximize();
		
		int paginationSize=driver.findElements(By.cssSelector("#example_paginate >span >a")).size();
		
		List<String>names=new ArrayList<String>();
		
		for(int i=1; i<paginationSize; i++)
		{
			String paginationSelector="#example_paginate>span>a:nth-child("+i+")";
			driver.findElement(By.cssSelector(paginationSelector)).click();
			List<WebElement>namesElements=driver.findElements(By.cssSelector("#example >tbody >tr >td:nth-child(1)"));
			
			for(WebElement namesElement:namesElements)
			{
				names.add(namesElement.getText());
			}
			}
		for (String name:names) {
			
			System.out.println(name);
		}
		
		int totalNames=names.size();
		System.out.println("Total numbers of Names : " + totalNames);
		
		String displaycount=driver.findElement(By.id("example_info")).getText().split(" ")[6];
		
		System.out.println("Total number of Displayed Names count:" + displaycount);
		
		Assert.assertEquals(displaycount, String.valueOf(totalNames));
		
		Thread.sleep(9000);
		
		driver.quit();
	}

	

}
