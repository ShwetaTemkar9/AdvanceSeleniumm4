package WebDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {/*

	public void moveToElement(WebDriver driver,WebDriver element) {
		Actions act = new Actions(driver);
		
		
	}
	
	public void selectbyVisbletext(WebElement element,String text) {
		Select sel = new Select(element);
	      sel.selectByVisibleText(text);
	}
		

	public void selectbyValue(WebElement element,String value) {
		Select sel = new Select(element);
	      sel.selectByValue(value);
	      
	}
		
	

	public void selectbyindex(WebElement element,int index) {
		Select sel = new Select(element);
	      sel.selectByIndex(index);
	}
		
	}public void moveToElement(WebDriver driver,WebDriver element) {
		Actions act = new Actions(driver);
		
		
	}public void moveToElement(WebDriver driver,WebDriver element) {
		Actions act = new Actions(driver);
		
		
	}public void moveToElement(WebDriver driver,WebDriver element) {
		Actions act = new Actions(driver);
		
		
	}public void moveToElement(WebDriver driver,WebDriver element) {
		Actions act = new Actions(driver);
		
		
	}public void moveToElement(WebDriver driver,WebDriver element) {
		Actions act = new Actions(driver);
		
		
	}public void moveToElement(WebDriver driver,WebDriver element) {
		Actions act = new Actions(driver);
		
		
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		public void waitForVisibilityOfWebelement(WebDriver driver, WebElement 
		element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		}
		public void switchToFrame(WebDriver driver, String nameorID) {
		driver.switchTo().frame(nameorID);
		}
		public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
		}
		public void switchToFrame(WebDriver driver, WebElement element ) {
		driver.switchTo().frame(element);
		}
		public void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		}
		public void switchToAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss(););
		}
		public void moveToElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		}
		public void doubleClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
		}
		public void selectByIndex(WebElement element, int index) {
		Select sel= new Select(element);
		sel.selectByIndex(index);
		}
		public void selectByValue(WebElement element, String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
		}
		public void selectByVisibleText(WebElement element, String visibletext) {
		Select sel=new Select(element);
		sel.selectByContainsVisibleText(visibletext);
		}public void toSwitchToWindow(WebDriver driver) {
		String parentid = driver.getWindowHandle();
		Set<String> allids = driver.getWindowHandles();
		allids.remove(parentid);
		for(String window:allids ) {
		driver.switchTo().window(window);
		}
		}
		public void toSwitchToParent(WebDriver driver) {
		String parentid = driver.getWindowHandle();
		Set<String> allids = driver.getWindowHandles();
		allids.remove(parentid);
		for(String window:allids ) {
		driver.switchTo().window(window);
		}
		}
		public void takeScreenshotOfWebPage(WebDriver driver, String ssName) 
		throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Advance_Selenium/ErrorShots/"+ssName+".png");
		FileHandler.copy(src, dest);*/
		
	public void waitForPageToLoad(WebDriver driver) { 
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	
		} 
	
	public void maximizepage(WebDriver driver) {
		driver.manage().window().maximize();
	}
		public void waitForVisibilityOfWebelement(WebDriver driver, WebElement 
		element) { //EXPLICIT wait
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOf(element)); 
		} 
		public void switchToFrame(WebDriver driver, String nameorID) { 
		driver.switchTo().frame(nameorID); 
		} 
		
		public void switchToFrame(WebDriver driver, int index) { 
		driver.switchTo().frame(index); 
		} 
		
		public void switchToFrame(WebDriver driver, WebElement element ) { 
		driver.switchTo().frame(element); 
		} 
		
		public void switchToAlertAccept(WebDriver driver) { 
		driver.switchTo().alert().accept(); 
		} 
		public void switchToAlertDismiss(WebDriver driver) { 
		driver.switchTo().alert().dismiss(); 
		 } 
		  
		 public void moveToElement(WebDriver driver, WebElement element) { 
		  Actions act=new Actions(driver); 
		  act.moveToElement(element).perform(); 
		 } 
		  
		 public void doubleClick(WebDriver driver, WebElement element) { 
		  Actions act=new Actions(driver); 
		  act.doubleClick().perform(); 
		 } 
		  
		 public void selectByIndex(WebElement element, int index) { 
		  Select sel= new Select(element); 
		  sel.selectByIndex(index); 
		 } 
		  
		 public void selectByValue(WebElement element, String value) { 
		  Select sel=new Select(element); 
		  sel.selectByValue(value); 
		 } 
		  
		 public void selectByVisibleText(WebElement element, String visibletext) { 
		  Select sel=new Select(element); 
		  sel.selectByContainsVisibleText(visibletext); 
		 } 
		  
		 public void toSwitchToWindow(WebDriver driver) { 
		  String parentid = driver.getWindowHandle(); 
		Set<String> allids = driver.getWindowHandles(); 
		allids.remove(parentid); 
		for(String window:allids ) { 
		driver.switchTo().window(window); 
		} 
		} 
		public void toSwitchToParent(WebDriver driver) { 
		String parentid = driver.getWindowHandle(); 
		Set<String> allids = driver.getWindowHandles(); 
		allids.remove(parentid); 
		for(String window:allids ) { 
		driver.switchTo().window(window); 
		} 
		} 
		public void takeScreenshotOfWebPage(WebDriver driver, String ssName) 
		throws IOException { 
		TakesScreenshot ts=(TakesScreenshot)driver; 
		File src = ts.getScreenshotAs(OutputType.FILE); 
		File dest=new File("./Advance_Selenium/ErrorShots/"+ssName+".png"); 
		FileHandler.copy(src, dest); 
		}

	}

	