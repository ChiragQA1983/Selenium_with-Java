package Practice_Tutorial;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrame_Tutorial {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();

		// iFrame index will always start from 0 zero so if we interact with first frame than we will provide index 0
		
		// If our element reside inside the Frame than first of all we need to find the path of iframe
		// than we will interact with our webelement from iframe 
		// we can't interact with our webelement if it is reside inside the iframe
		// that's why it is it is neccessary to know locators technique of iframe
		
		//driver.switchTo().frame(0);    <- we can provide index of framework when only one or two iframe
		// but if there are multiple iframe and we have to interactwith them than we can provide
		// id, name, etc. like as below
		
		// here we are find the Iframe by.id and store it in webelement and pass webelement as an argument
		
		WebElement frame1=driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("/html/body/button")).click();
		
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
	
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		
		
	}

}
