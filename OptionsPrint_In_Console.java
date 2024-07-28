package Practice_Tutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptionsPrint_In_Console {

	public static void main(String[] args) {
		
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_1");
	
	driver.findElement(By.id("btnDropdownDemo")).click();
	

    List<WebElement>option=driver.findElements(By.xpath("//div[contains(@class, 'dropdown')]/a"));
	
    for (WebElement options : option)
	
    {	
	  
	  String optiontext=options.getText();
	  
//	 if (optiontext.equals("HTML"))
//	 {
//		 options.click();
//	 }
	  System.out.println(optiontext);
	}
}
}