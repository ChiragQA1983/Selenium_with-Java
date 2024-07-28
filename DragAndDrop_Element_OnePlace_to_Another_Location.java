package Practice_Tutorial;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop_Element_OnePlace_to_Another_Location {

	public static void main(String[] args) throws InterruptedException {
		
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");	
	
	driver.manage().deleteAllCookies();
	
	driver.manage().window().maximize();
	
	
	WebElement washington = driver.findElement(By.id("box3"));
	
	WebElement UnitedStates = driver.findElement(By.id("box103"));
	
	System.out.println("First Action Done - Washington -> UnitedStates");
	
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
	
	Actions action=new Actions(driver); 
	action.dragAndDrop(washington, UnitedStates).build().perform();
	
	try {
	
	WebElement Rome=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box6")));
	
	WebElement Denmark=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box104")));
	
	action.dragAndDrop(Rome, Denmark).build().perform();
	
	System.out.println("Second Action Done - Rome - Denmark");
	
	
		
	WebElement Copenhagen=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box4")));
	
	WebElement Spain=wait.until(ExpectedConditions.elementToBeClickable(By.id("box107")));

	action.dragAndDrop(Copenhagen, Spain).build().perform();
	
	System.out.println("Third Action Done - Copenhagen - Spain");
	

	
	WebElement Stockholm=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box2")));
	
	WebElement SouthKorea=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box105")));
	
	action.dragAndDrop(Stockholm, SouthKorea).build().perform();
	
	System.out.println("Fourth Action Done - Stockholm - SouthKorea");
	

	
	WebElement Seoul=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box5")));
	
	WebElement Norway=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box101")));
	
	action.dragAndDrop(Seoul, Norway).build().perform();
	
	System.out.println("Fifth Action Done - Seoul - Norway");
	
	
	
	WebElement Madrid=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box7")));
	
	WebElement Italy=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box106")));
	
	action.dragAndDrop(Madrid, Italy).build().perform();
	
	System.out.println("Sixth Action Done - Madrid - Italy");
	
	
	
	WebElement Oslo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box1")));
	
	WebElement Sweden=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box102")));

	action.dragAndDrop(Oslo, Sweden).build().perform();
	
	System.out.println("All Seven Action Done - Oslo - Sweden");
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}

	
	driver.quit();
	
	}

}
