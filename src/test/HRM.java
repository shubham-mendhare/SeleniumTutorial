package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HRM {
	
	
public static void main(String[] args) {
		WebDriver driver;
			System.setProperty("webdriver.chrome.driver", "/home/developers/My recording/"+
			"2019/Learn Yourself/Jar/chromedriver");		
				driver= new ChromeDriver();		
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.get("https://orangehrm-demo-6x.orangehrmlive.com/client/#/noncore/directory/viewDirectory/reset/1");
	
	
}

}
