package Page_Object_Model;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.*;
import java.io.File;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class AdBlockerProgram {

	public WebDriver driver;

@BeforeTest	
public void beforetest()
{
	ChromeOptions opt=new ChromeOptions();
	opt.addExtensions(new File("D:\\AUTOMATION ALL\\FrameWorkBasics\\PageObjectModel\\Extensions\\AdBlocker Ultimate 3.8.14.0.crx"));
	driver=new ChromeDriver(opt);
	driver.get("https://www.globalsqa.com/angularjs-protractor-practice-site/");
	driver.manage().window().maximize();
	
    // Perform window handling to close the ad blocker installation window
    handleAdBlockerWindow();
}

// Method to handle the ad blocker window
private void handleAdBlockerWindow() {
    // Get all window handles
    Set<String> windowHandles = driver.getWindowHandles();

    // If more than one window is open, handle the ad blocker window
    if (windowHandles.size() > 1) {
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        // Switch to the child window (ad blocker window)
        driver.switchTo().window(childWindow);

        // Perform actions on the ad blocker window
        // For example, close the ad blocker window by closing the driver or perform specific actions

        // In this example, let's close the ad blocker window
        driver.close();

        // Switch back to the parent window
        driver.switchTo().window(parentWindow);
    }
}
	

@Test	
public void practicemultiform() throws InterruptedException
{
   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
   WebElement multiformclk=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Multiform")));
   multiformclk.click();
   
   
   WebElement name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
   name.sendKeys("Chirag Bhatt");
   
   WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
   email.sendKeys("Chirag.bhatt105@gmail.com");
   
   WebElement nextselection=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Next Section" )));
   nextselection.click();
   
   try {
	    WebElement chkboxXBOX = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='I like XBOX']")));
	    chkboxXBOX.click();

	    WebElement nextSelection = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Next Section")));
	    nextSelection.click();

	    int maxRetry = 6;

	    for (int retry = 0; retry <= maxRetry; retry++) {
	        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='form-views']/div/button")));
	        submit.click();
	        
	        // Wait for the alert to be present and handle it
	        WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Adjust the timeout as needed
	        if (alertWait.until(ExpectedConditions.alertIsPresent()) != null) {
	            driver.switchTo().alert().accept();
	            break; // Break out of the loop after handling the alert
	        }
	    }
	} catch (TimeoutException e) {
	    // Handle timeout exception if the alert doesn't appear within the specified time
	    System.out.println("Alert did not appear within the specified time.");
	} catch (Exception e) {
	    // Handle any other exceptions that might occur
	    e.printStackTrace();
	}

   
}

@AfterTest
public void teardown()
{

  driver.quit();

}
}