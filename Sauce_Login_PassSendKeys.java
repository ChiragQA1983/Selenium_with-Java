package Testcase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sauce_Login_PassSendKeys {
	
public static String Browser="edge";
public static WebDriver driver;
public static void main(String [] args) {
	
// This program successfully open Targeted URL and Enter Value through SendKeys in Username and Password and Click Login button
	
	if(Browser.equals("Firefox")){
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	} else if(Browser.equals("chrome")){ 
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	} else if(Browser.equals("edge")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new EdgeDriver();
		
	}
	 
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		driver.close();
	}
	
}
