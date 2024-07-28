package Practice_Tutorial;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Label_Popup_Tooltip_Text {

	public static void main(String[] args) {
		
	
  WebDriverManager.chromedriver().setup();	
	
  ChromeDriver driver=new ChromeDriver();
  
  driver.manage().window().maximize();
		
  driver.get("http://www.omayo.blogspot.com");
  
  //Step 1 - We will provide Locator or xpath of main element where Alert will displayed and will use .getAttribute method
  //as below example and we will use String instead of WebElement
  // it will very useful for applying assertions
		
  String tooltip=driver.findElement(By.xpath("//p[@title='Free Selenium tutorials']")).getAttribute("title");
  
  System.out.println("Tool tip " +tooltip);

	}

}
