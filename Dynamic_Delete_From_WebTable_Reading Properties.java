package Practice_Tutorial;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Delete {

	 static WebDriver driver;
	    public static FileReader fr;
	    public static Properties configProperties;  // Declare configProperties at the class level

    public void loadConfigProperties() throws IOException {
        Properties configProperties = new Properties();
        fr = new FileReader("D:\\AUTOMATION ALL\\FrameWorkBasics\\com.sauce.practice\\config.properties");
        configProperties.load(fr);

        // Assign the loaded properties to the global variable
        this.configProperties = configProperties;
    }


    @Test
    public void setupForDelete() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
     //   driver.get("http://pos.arityinfoway.com/transfers");
        
        loadConfigProperties();
        
        driver.get(configProperties.getProperty("Browser"));
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Login...
        driver.findElement(By.id("login-username")).sendKeys("admin");
        driver.findElement(By.id("login-password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);

        // Navigate to Sale and Gift Card List...
        driver.findElement(By.xpath("//span[normalize-space()='Sale']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Gift Card List']")).click();

        Thread.sleep(3000);

        // Get the customer name from config.properties
        loadConfigProperties();
        String customerName = configProperties.getProperty("Customer");

        System.out.println("Customer Name from config.properties: " + customerName);

        // Click on the element using the dynamic customer name
        String xpathExpression = "//td[text()='" + customerName + "']/following::td[6]";
        System.out.println("XPath Expression: " + xpathExpression);

        driver.findElement(By.xpath(xpathExpression)).click();
        
        Thread.sleep(5000);
        // Rest of your code...
    }
}