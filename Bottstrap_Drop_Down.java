package Practice_Tutorial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Bottstrap_Drop_Down {

	public static void main(String[] args) {
		
		//https://www.youtube.com/watch?v=jBVtlGTOWu0
	
	// Below program will select single option from dropdown 	
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_1");
	
	
	driver.findElement(By.id("btnDropdownDemo")).click(); // <- it will select entire dropdown 
	
	//Than -> //div[contains(@class, 'dropdown-menu')]/a  <- it will select first Anchor tag option from menu
	
	List <WebElement> options=driver.findElements(By.xpath("//div[contains(@class, 'dropdown-menu')]/a"));	
   
	
	// Through below for loop we will get the text and iterate and any option from dropdown
	for (WebElement option : options) {
	
		String optionText=option.getText();
		  if(optionText.equals("CSS")) {
			  option.click();
			  break;
		  }
		
	}
		System.out.println(driver.getTitle());
	
	
	}

}












//https://www.youtube.com/watch?v=Fpd60HxXJhA