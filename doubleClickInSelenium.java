package Practice_Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class doubleClickInSelenium {

	public static void main(String[] args) {
	
		
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("http://omayo.blogspot.com/");	
	
	WebElement button=driver.findElement(By.xpath("//button[@ondblclick='dblclickAlert()']"));
		
	Actions action=new Actions(driver);	
	action.doubleClick(button).build().perform();	

	}

}
