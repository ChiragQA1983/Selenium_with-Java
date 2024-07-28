package Practice_Tutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.JavascriptExecutor;

public class Spinner_InCrease_Decrease {
     
	WebDriver driver;
	
@BeforeTest	
public void Setup() {

WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.get("https://www.globalsqa.com/demo-site/spinner/#Currency");
driver.manage().window().maximize();
	
}
@Test
public void Spinner_handling() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-2677\"]/div[2]/div/div/div[1]/p/iframe")));
    driver.switchTo().frame(iframe);

    WebElement selectcurrency = wait.until(ExpectedConditions.elementToBeClickable(By.id("currency")));

    Select select = new Select(selectcurrency);
    select.selectByVisibleText("US $");

    WebElement spinnertext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spinner")));
    spinnertext.click();

    // JavaScript executor to set the spinner value directly to $55.00
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].value='$480.00';", spinnertext);

    // Verify if the value has been set
    String currentValue = spinnertext.getText();
    if (currentValue.equals("$480.00")) {
        System.out.println("Desired spinner value reached: " + currentValue);
    } else {
        System.out.println("Unable to reach the desired value.");
    }
}
}