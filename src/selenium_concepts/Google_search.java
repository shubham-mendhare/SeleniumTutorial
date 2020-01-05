package selenium_concepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_search {

	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver", "/home/developers/My recording/2019/Learn Yourself/Jar/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@maxlength=\"2048\"]")).sendKeys("testing");
		List <WebElement> element = driver.findElements(By.xpath("//ul[@role=\"listbox\"]//li/descendant::div[@class=\"sbl1\"]"));
		
		for(int i=0; i<element.size();i++) {
			
			System.out.println("Searched text is:-"+element.get(i).getText());
			
			if(element.get(i).getText().equals("interview questions")) {
				
				System.out.println("Text found!");
				
				element.get(i).click();
				
				break;
			}
		}

	}

}
