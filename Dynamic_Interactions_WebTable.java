package Practice_Tutorial;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Interactions_WebTable {

	 public static WebDriver driver;
	 static Properties testinfo=new Properties();
	 static FileReader fr;
	
	public void loadconfigproperties() throws IOException
	{
	 
		fr=new FileReader("D:\\AUTOMATION ALL\\FrameWorkBasics\\com.sauce.practice\\config.properties");
		testinfo.load(fr);
    }
	@Test
	public void ReadConfig() throws InterruptedException, IOException
	{
		
		  WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	     //   driver.get("http://pos.arityinfoway.com/transfers");
	        
	        loadconfigproperties();
	        driver.get(testinfo.getProperty("Browser"));
	        
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	       // driver.manage().deleteAllCookies(); 
	        // Login...
	        driver.findElement(By.id("login-username")).sendKeys("admin");
	        driver.findElement(By.id("login-password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@type='submit']")).click();

	        Thread.sleep(3000);

	        // Navigate to Sale and Gift Card List...
	        driver.findElement(By.xpath("//span[normalize-space()='Sale']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[normalize-space()='Gift Card List']")).click();

	        Thread.sleep(3000);
	        
	        String customer=testinfo.getProperty("Customer");
	
	        String xpathdeclaration="//td[text()='"+ customer +"']//following::td[6]";
	        
	        driver.findElement(By.xpath(xpathdeclaration)).click();
	        
	        Thread.sleep(3000);
	        
	        driver.quit();
	}

}
