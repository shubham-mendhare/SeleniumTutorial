package selenium_concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/developers/My recording/2019/Learn Yourself/Jar/chromedriver");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

		driver.get("https://www.crmpro.com/");
		driver.findElement(By.name("username")).sendKeys("shubham090295");
		driver.findElement(By.name("password")).sendKeys("bitu321");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

	}

}
