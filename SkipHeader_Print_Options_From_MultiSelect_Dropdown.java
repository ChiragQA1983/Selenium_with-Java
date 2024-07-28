package Practice_Tutorial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SkipHeader_Print_Options_From_MultiSelect_Dropdown {

	public static void main(String[] args) {
		
		//https://www.youtube.com/watch?v=jBVtlGTOWu0
	
	// below program will select single option from dropdown 	
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	
	// It will have ul tag (UnOrdered List Options)
	
	driver.findElement(By.xpath("//button[contains(@class, 'multiselect')]")).click();

  // it will print all the Options from multiselect dropdown	
  //List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container')]/li"));
  ////ul[contains(@class, 'multiselect-container')]/li[not(@class, 'multiselect-item multiselect-group')]
	
 // We will skip the headers by modifying xpath as below	
	List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container')]/li[not(@class='multiselect-item multiselect-group')]/a/label"));
	
	for(WebElement option:options) {
		
		String optiontext=option.getText();
		System.out.println(optiontext);

	}

	}

}












