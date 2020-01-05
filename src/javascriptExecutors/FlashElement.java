package javascriptExecutors;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import javascript_utility.*;
public class FlashElement {
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "/home/developers/My recording/2019/Learn Yourself/Jar/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
		WebElement element = driver.findElement(By.id("wp-submit"));
		JavaScript_Utility.flash(element, driver);
		JavaScript_Utility.drawborder(element, driver);
		try{
		JavaScript_Utility.takeScreenshot(driver);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		JavaScript_Utility.generateAlert("Script executed", driver);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		JavaScript_Utility.refresh(driver);
		
	//	driver.quit();
		
	}
}
	

