package Practice_Tutorial;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggested_Search {


	
private ChromeDriver driver;

@BeforeTest
public void setup()
{
WebDriverManager.chromedriver().setup();	
driver=new ChromeDriver();	
driver.get("https://www.globalsqa.com/demo-site/auto-complete/#Categories");	
driver.manage().window().maximize();	
}

@Test
public void AutoSuggestion_Test()
{

WebElement iframe=driver.findElement(By.xpath("//*[@id=\"post-2656\"]/div[2]/div/div/div[1]/p/iframe"));

driver.switchTo().frame(iframe);

WebElement search=driver.findElement(By.id("search"));
search.click();

search.sendKeys("a");

List<WebElement>allelement=driver.findElements(By.xpath("//li[@class='ui-menu-item']//div[contains(@id, 'ui-id')]"));

boolean status=false;

for(WebElement ele:allelement)
{
	String value=ele.getText();
	System.out.println(value);
	
	if(value.contains("anders"))
	{
		ele.click();
		status=true;
	}
	
}

Assert.assertTrue(status, " Records did not found ");

}
}