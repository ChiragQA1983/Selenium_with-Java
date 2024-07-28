package Practice_Tutorial;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class iFrame_Tutorial {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();

		WebElement frame1 = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame1);

		driver.findElement(By.xpath("/html/body/button")).click();

		//Note :- If Browser is not updated or having any issue in that case some functionality like in this program
		// Will not be handle like chrome browser having an issue so, not working in chrome but working in other
		//browsers
		
		//Handle the alert
		
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);

		// We are accepting the alert or it we want we can dismiss the alert using .dismiss() method
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		// Switch back to the parent window (default content)
		//driver.switchTo().defaultContent();
		
		// For Switch Back to MainFrame we can use either parentFrame() as below or defaultContent() as above
		driver.switchTo().parentFrame();

		// Get the title of the parent window
		System.out.println(driver.getTitle());

		
	}

}
