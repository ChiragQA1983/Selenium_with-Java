package Page_Object_Model;

import java.io.File;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetSeleniumTestWithExtension {

	public static void main(String[] args) {
		
		
	ChromeOptions opt=new ChromeOptions();
	opt.addExtensions(new File("D:\\AUTOMATION ALL\\FrameWorkBasics\\PageObjectModel\\Extensions\\SelectorsHub 5.1.8.0.crx"));
	WebDriver driver=new ChromeDriver(opt);
	//driver.get("https://www.globalsqa.com/angularjs-protractor-practice-site/");
	driver.get("http://www.google.com");
	driver.manage().window().maximize();
		
		
	}

}
