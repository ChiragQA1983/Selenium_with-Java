package Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration2 {

    WebDriver driver;
    Registration_Page registrationPage; // Updated variable name

    @BeforeClass
    public void Beforeclass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().window().maximize();

        // Initializing Registration_Page object
        registrationPage = new Registration_Page(driver);
    }

    @Test
    public void rgpage() {
        registrationPage.SelectGender();
        registrationPage.FirstName("Chirag");
        registrationPage.LastName("Bhatt");
        registrationPage.selectDay("10");
        registrationPage.selectMonth("May");
        registrationPage.selectYear("1983");
        registrationPage.email("Chirag.Bhatt1983@yahoo");
        registrationPage.company("Tata");
        registrationPage.password("TestPassword");
        registrationPage.confirmpasword("TestPassword");
        registrationPage.regstbut();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
