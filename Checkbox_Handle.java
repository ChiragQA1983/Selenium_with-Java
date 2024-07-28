package Testcase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox_Handle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.manage().window().maximize();

        Thread.sleep(4000);
        WebElement radio = driver.findElement(By.id("radio1"));
        Actions actions = new Actions(driver);
        actions.moveToElement(radio).click().build().perform();

        Thread.sleep(2000);
        driver.findElement(By.name("color")).click();

        // Close the browser
        driver.quit();
        
    }
    
}
