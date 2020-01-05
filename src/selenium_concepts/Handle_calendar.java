package selenium_concepts;

import java.util.concurrent.TimeUnit;

import javax.swing.event.TreeWillExpandListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handle_calendar {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/developers/My recording/2019/Learn Yourself/Jar/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		try {
			
			page(driver);
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		Thread.sleep(3000);
		
		try{
			
			calendar(driver);
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public static void calendar(WebDriver driver ) {

		String date = "09-february-1995";
		String []dateArr = date.split("-");
		
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		driver.switchTo().frame("mainpanel");
		
		Select select = new Select(driver.findElement(By.name("name=\"slctMonth\"")));
		select.selectByVisibleText(month);
		
		Select select1 = new Select(driver.findElement(By.className("name=\"slctYear\"")));
		select1.selectByVisibleText(year);
		
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		
		String before_xpath = "//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
		String after_xpath = "]/td[";
		
		final int totalWeekDays = 7;
		
		for(int rowNum = 2; rowNum<=7; rowNum++) {
			for(int colnum =1; colnum<=totalWeekDays; colnum++) {
				
				String dayvalue = driver.findElement(By.xpath(before_xpath+rowNum+after_xpath+colnum+"]")).getText();
				System.out.println(dayvalue);
				
				if(dayvalue.equals(day)) {
					driver.findElement(By.xpath(before_xpath+rowNum+after_xpath+colnum+"]")).click();
				}
				
			}
			
		}	
		
	}
	
	public static void page(WebDriver driver) throws InterruptedException {
		
		driver.get("https://www.crmpro.com/");
		driver.findElement(By.name("username")).sendKeys("shubham090295");
		driver.findElement(By.name("password")).sendKeys("bitu321");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		
	}
	

}
