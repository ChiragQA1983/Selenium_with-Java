package Practice_Tutorial;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class Search_AutoSuggested_Text {

	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.globalsqa.com/demo-site/auto-complete/#Categories");
	driver.manage().window().maximize();
	WebElement iframe=driver.findElement(By.xpath("//*[@id=\"post-2656\"]/div[2]/div[1]/div/div[1]/p/iframe"));
	
	driver.switchTo().frame(iframe);
	
	WebElement Searchtxt=driver.findElement(By.id("search"));
	Searchtxt.click();
	
	Searchtxt.sendKeys("n");
	
	List<WebElement>list=driver.findElements(By.xpath("//li[@class='ui-menu-item']//div[@class='ui-menu-item-wrapper']"));
	
	for(WebElement listitem:list)
	{
	
	  if(listitem.getText().equals("andreas johnson"))	
	  {
		  listitem.click();
	 }

	}
	}
}
