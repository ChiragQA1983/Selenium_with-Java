package Practice_Tutorial;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.*;
public class Price_Filter_High_to_Low {


//Verify Sort Functionality in Selenium Java | Ascending Order | Krishna Sakinala | Real Time Example5	
//https://www.youtube.com/watch?v=6XcdaSL_pZc	
	@Test
	public void Filter() throws InterruptedException
	{
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");	
	driver.findElement(By.id("login-button")).click();
	
	//1. before filter capture the prices and make the ascending order 
	List<WebElement>beforeFilterPrice=driver.findElements(By.className("inventory_item_price"));

	//1.1 Remove the $ Symbol from the price and convert it into the string into double
	List<Double>beforeFilterPriceList=new ArrayList<>();
	
	for (WebElement p: beforeFilterPrice)
			{
		
		beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		
			}
	//2. Filter the price from DropDown
	Select dropdown=new Select(driver.findElement(By.className("product_sort_container")));
	dropdown.selectByVisibleText("Price (low to high)");
	
	//3. After filter capture the prices
	List<WebElement>afterFilterPrice=driver.findElements(By.className("inventory_item_price"));
	
	//3.1 Remove $ symbol from the price and convert the string into double
	List<Double>afterFilterPriceList=new ArrayList<>();
	
	for(WebElement p: afterFilterPrice) {
		
		afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		
	}
	
	//4. Compare the values/Assert the values (first we need to sort the values of beforeFilterPrice)
	Collections.sort(beforeFilterPriceList);
	
	//4. Compare the values/Assert the values
	Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
				
				Thread.sleep(5000);
				
				driver.quit();
	}
	
		
	}
	
	//https://www.youtube.com/watch?v=6XcdaSL_pZc
	//Verify Sort Functionality in Selenium Java | Ascending Order | Krishna Sakinala | Real Time Example5

