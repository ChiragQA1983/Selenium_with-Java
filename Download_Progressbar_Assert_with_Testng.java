package Practice_Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Download_Progressbar_Assert_with_Testng {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/progress-bar/");
        driver.manage().window().maximize();
    }
// https://www.youtube.com/watch?v=OAyUyJHx3Wg
    @Test
    public void Progressbar_Handle() throws InterruptedException {
        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"post-2671\"]/div[2]/div/div/div[1]/p/iframe"));
        driver.switchTo().frame(iframe);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement Download = wait.until(ExpectedConditions.elementToBeClickable(By.id("downloadButton")));
        Download.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement progressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='progressbar']")));

        boolean progressStatus = wait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "100"));

        if (progressStatus) {
            WebElement completed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='progress-label']")));
            String actualText = completed.getText();
            String expectedText = "Complete!";
            
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(actualText, expectedText, "The 'Complete!' text does not match the expected text");
            softAssert.assertAll(); // This line will help to assert all conditions and collect failures
	    driver.findElement(By.xpath("//button[@class='ui-button ui-corner-all ui-widget']")).click();	

        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

    
    
    
