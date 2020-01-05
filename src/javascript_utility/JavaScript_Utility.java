package javascript_utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScript_Utility {
	
	
public static void flash(WebElement element,WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		String bgcolor = element.getCssValue("backgroundColor");
		
		for(int i=0; i<10; i++) {
			
			changecolor("rgb(0,200,0)",element,driver);
			changecolor(bgcolor,element,driver);
			
		}
		
	}


		public static void changecolor(String color, WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
		try {
			Thread.sleep(20);
		}
		catch(InterruptedException e) {
			
			System.out.println(e);
		}
			
		}
		
		
		
		public static void drawborder (WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}
		
		
		
		public static void takeScreenshot(WebDriver driver) throws IOException {
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			FileUtils.copyFile(scrFile, new File("/home/developers/My recording/2019/Learn Yourself/SeleniumTutorial/src/javascriptExecutors/abcd.jpeg"));
			
		}
		
		
		public static void generateAlert(String message, WebDriver driver) {
			
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("alert('"+message+"');");
		}
		
public static void clickelement(WebElement element, WebDriver driver) {
			
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();", element);
		}

public static void refresh(WebDriver driver) {
	
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("history.go(0)");
}

public static String gettitle(WebDriver driver) {
	
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	String title = js.executeScript("return document.title;").toString();
	return title;
	
}


	
	
}
