package Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration_Page {

	WebDriver driver;
	
	public Registration_Page(WebDriver d) {
		
		this.driver=d;
		
		PageFactory.initElements(driver, this);
		}


@FindBy(id="gender-male")
WebElement Gender;

@FindBy(id="gender-female")
WebElement GenderFemale;
	
@FindBy(id="FirstName")
WebElement FirstName;

@FindBy(id="LastName")
WebElement LastName;

@FindBy(xpath="//select[@name='DateOfBirthDay']")
WebElement Day;

@FindBy(name="DateOfBirthMonth")
WebElement Month;

@FindBy(name="DateOfBirthYear")
WebElement Year;

@FindBy(id="Email")
WebElement mail;

@FindBy(id="Company")
WebElement company;

@FindBy(id="Password")
WebElement password;

@FindBy(id="ConfirmPassword")
WebElement confirmpassword;

@FindBy(id="register-button")
WebElement registrationbutton;



public void SelectGender()
{
	GenderFemale.click();
}

public void FirstName(String fname)
{
   FirstName.sendKeys(fname);
}

public void LastName(String lname)
{
	LastName.sendKeys(lname);
}

public void selectDay(String dayValue) {
    Select daySelect = new Select(Day);
    daySelect.selectByVisibleText(dayValue);
}

public void selectMonth(String monthValue) {
    Select monthSelect = new Select(Month);
    monthSelect.selectByVisibleText(monthValue);
}

public void selectYear(String yearValue) {
    Select yearSelect = new Select(Year);
    yearSelect.selectByVisibleText(yearValue);
}

public void email(String Email)
{
	mail.sendKeys(Email);
}

public void company(String compan)
{
	company.sendKeys(compan);
}


public void password(String pasword)
{
	password.sendKeys(pasword);
}

public void confirmpasword(String confirmpasword)
{
	confirmpassword.sendKeys(confirmpasword);
}

public void regstbut()
{
	registrationbutton.click();
}


}

