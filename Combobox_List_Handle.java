package Practice_Tutorial;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Combobox_List_Handle {
    WebDriver driver;   
	
	@BeforeClass
	public void Window_Switch()
	{
		//
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://www.globalsqa.com/demo-site/auto-complete/#ComboBox");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	}
	@Test
	public void Combo_Box() throws InterruptedException
	{
		
	WebElement iframe=driver.findElement(By.xpath("//*[@id=\"post-2656\"]/div[2]/div/div/div[2]/p/iframe"));	
		
	driver.switchTo().frame(iframe);	
		
	WebElement Comobobox=driver.findElement(By.xpath("//span[@class='ui-button-icon ui-icon ui-icon-triangle-1-s']"));
	Comobobox.click();
	
	List<WebElement>list=driver.findElements(By.xpath("//li[@class='ui-menu-item']//div[@class='ui-menu-item-wrapper']"));
	
	System.out.println(" List of WebElement: " + list);
	
	for(WebElement listitem:list)
	{
		if(listitem.getText().equals("ColdFusion"))
		{
			listitem.click();
			Thread.sleep(1000);
			 WebElement Showselectundbtn=driver.findElement(By.xpath("//button[@id='toggle']"));
			   Showselectundbtn.click();

			   WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
			   WebElement Combosecond=wait.until(ExpectedConditions.elementToBeClickable(By.id("combobox")));
			   Combosecond.click();
			   
			   Select select=new Select(Combosecond);
			   select.selectByVisibleText("Groovy");	
			   Showselectundbtn.click();
			
		}
	
  
   
	}
	
	  
	}
	
	  
	
@AfterClass	
public void teardown()
{
	if(driver!=null)
	{
		driver.quit();
	}
}

}
