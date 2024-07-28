package Practice_Tutorial;				 //https://www.youtube.com/watch?v=X3LHHhoIwyk
							 //Selenium Webdriver : Arraylist and Linked list with Selenium Web driver: Tutorial 11

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ArrayLinkText_PrintAll_Link {

WebDriver driver;

public void setup()
{
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}

	//import java.util.List;  <- Import will required
	public void TestarrayList()
	{    
	List<WebElement> list = driver.findElements(By.tagName("a")); // Use findElements here
    System.out.println("Size of the links list: " + list.size());
    
    ArrayList<String> linkText = new ArrayList<String>();
    
    for (WebElement ele : list) {
        try {
            linkText.add(ele.getText());
        } catch (Exception e) {
            // Handle any exceptions here
        }
    }
    
    System.out.println("****************************************");
    System.out.println("Size of the ArrayList: " + linkText.size());
    
    int i = 1;
    
    for (String s : linkText) {
        System.out.println(i + ". ArrayList Text: " + s);
        i++;
    }
}

	
public static void main(String[] args) {
	
	 ArrayLinkText_PrintAll_Link obj=new ArrayLinkText_PrintAll_Link();
	 		  obj.setup();
			  obj.TestarrayList();
}

}


//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;  <- Such kind of unneccessary import will affect the program and give the error
 // so we will remove unncessary imports
