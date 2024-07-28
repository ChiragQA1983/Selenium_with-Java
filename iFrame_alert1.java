package Practice_Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class iFrame_alert {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();
        
		//Step 1 :- locate child element ById, ByName, By Index
		WebElement iframe2=driver.findElement(By.id("iframeResult"));
		
		//Step 2 :- Switch to child window iframe and passing argument of webelement
		driver.switchTo().frame(iframe2);
		
		//Step 3:- Perform required operation 
		driver.findElement(By.xpath("/html/body/button")).click();
		
		//Step 4:- Get the alert text if we want and print it
	    String alerttext= driver.switchTo().alert().getText();
	    System.out.println(alerttext);
	    
	    //Step 5 :-Accept or dismiss the alert 
	    Thread.sleep(2000);
	    driver.switchTo().alert().accept();
		
	    //Step 6 :- Switchback to parentwindow and gettitle of parentwindow
		Thread.sleep(2000);
	    driver.switchTo().defaultContent().getTitle();
	    
	    //Step7:- Print the title
	    System.out.println(driver.getTitle());
		
	}

}
