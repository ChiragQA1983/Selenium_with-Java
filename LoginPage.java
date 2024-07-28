package Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.setup();
    }

    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        LoginPage2 loginPage2 = new LoginPage2(driver);
        driver.get("https://www.saucedemo.com");
        loginPage2.enterUsername("standard_user");
        loginPage2.enterPassword("secret_sauce");
        loginPage2.clickOnLoginButton();
        
    }
}
