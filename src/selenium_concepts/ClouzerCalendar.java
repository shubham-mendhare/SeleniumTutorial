package selenium_concepts;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClouzerCalendar {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/home/developers/My recording/2019/Learn Yourself/Jar/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://dev.clouzer.com");		
		
		driver.findElement(By.id("userID")).sendKeys("jo.wood");
		driver.findElement(By.id("password")).sendKeys("jw");
		driver.findElement(By.id("logIn")).click();
		JsWait("//div[@title=\"CALENDAR\"]", driver, 20);
		
		//driver.findElement(By.cssSelector("#routerMain > div > app-overview > div.h.lrp.ng-star-inserted > div.vh > div.v > app-date-picker > div > svg")).click();
	
		
		driver.findElement(By.id("AddEvent")).click();
		
		driver.findElement(By.id("titleName")).sendKeys("abcd");
		driver.findElement(By.id("locationId")).sendKeys("uk");
		LocationDropDown("//div[@id=\"showDropDown\"]//child::div//h5",4,driver);
	//	Js_Select("//div[@id=\\\"showDropDown\\\"]//child::div//h5", 2, driver);
		
		select_duration(1, driver);
		
		driver.findElement(By.xpath("//div[@id=\"endDate\"]")).click();
		
		setDate("February 9, 1995", driver);
		
		//driver.findElement(By.id("actionBtn")).click();
		JsWait("//h5[text()=\"Add\"]", driver, 10);
		
				
	}
	
	
	public static void JsWait(String path, WebDriver driver, int Wait_time) {
		
		WebDriverWait wait = new WebDriverWait (driver, Wait_time);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""+path+"")));
		element.click();
	}
	
	public static void setDate(String date, WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement element = driver.findElement(By.xpath("//td[@aria-label=\"September 1, 2019\"]"));
		js.executeScript("arguments[0].setAttribute('aria-label', '"+date+"')",element);

		
	}
	
	
	public static void LocationDropDown(String xpath,int loc_no,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver, 20);
		//div[@id="showDropDown"]//child::div//h5
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""+xpath+"")));
		
		List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(""+xpath+"")));		
		for(int i=0; i<element.size();i++) {
			System.out.println(i+")"+element.get(i).getText());
		}
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element.get(loc_no));
			
	}
	
	
	public static void select_duration(int index,WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//select[@name=\"duration\"]"));
		Select select = new Select(element);
		select.selectByIndex(index);
		
	}
			
		
}


