package Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//PageFactory Approach
public class LoginPage2 {

    WebDriver driver;

    // Constructor
    public LoginPage2(WebDriver d) {
        this.driver = d;
        // this method will create web elements
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public void enterUsername(String uname) {
        username.sendKeys(uname);
    }

    public void enterPassword(String Pwd) {
        password.sendKeys(Pwd);
    }

    public void clickOnLoginButton() {
        loginBtn.click();
    }
}
