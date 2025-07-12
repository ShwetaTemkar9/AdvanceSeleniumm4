package PageObjectModel_Implementation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import PageObjectModel.LoginPage;
import WebDriverUtility.WebDriverUtility;

public class createProduct {

	public static void main (String[] args) throws IOException, InterruptedException {
		//PropertyFileUtility
	PropertyFileUtility putil= new PropertyFileUtility();
	
	String BROWSER= putil.getDataFromPropertiesFile("browser");
	String URL=putil.getDataFromPropertiesFile("url");
    String USERNAME= putil.getDataFromPropertiesFile("username");
	String PASSWORD= putil.getDataFromPropertiesFile("password");
	
	WebDriver driver = new EdgeDriver();
	
	WebDriverUtility wb = new WebDriverUtility();
	wb.waitForPageToLoad(driver);//implicitly wait
	wb.maximizepage(driver);//maximize
	driver.get(URL);
	//pom
	LoginPage lg = new LoginPage(driver);
	
	Thread.sleep(4000);
	lg.LoginAction(USERNAME, PASSWORD);
	
     Thread.sleep(100);
     
     JavaUtility jutil= new JavaUtility();
     int num =jutil.getRandomNumber();
     driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		  driver.findElement(By.name("productName")).sendKeys("IM_PROD_212+"+num);
		
		WebElement quantity=driver.findElement(By.name("quantity"));
		quantity.clear();
		quantity.sendKeys("12");
		
		driver.findElement(By.name("productCategory")).click();
		
		driver.findElement(By.xpath("//option[@value='Electronics']")).click();
		driver.findElement(By.name("price")).clear();
		driver.findElement(By.name("price")).sendKeys("100");
		 WebElement vendor = driver.findElement(By.name("vendorId"));
		 Select s = new Select(vendor);
		 s.selectByValue("VID_001");
		 
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 
     
	}
}
