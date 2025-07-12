package may24;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;

public class CampaignloginandValidation {

	public static void main(String[] args) throws IOException, InterruptedException {
		 WebDriver driver = new EdgeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		  
		 PropertyFileUtility p= new PropertyFileUtility();
		String url= p.getDataFromPropertiesFile("url");
		String username= p.getDataFromPropertiesFile("username");
		String password = p.getDataFromPropertiesFile("password");
		

		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        Thread.sleep(3000);
		//Excelutility
		ExcelUtility excel = new ExcelUtility();
		String name=excel.getdataFromExcel("Sheet1", 1, 0);
		String size=excel.getdataFromExcel("Sheet1", 1, 1);
		
		//java utility
		JavaUtility jutil = new JavaUtility();
		int number=jutil.getRandomNumber();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(name);
		

		WebElement targettextfield = driver.findElement(By.name("targetSize"));

		targettextfield.clear();
		targettextfield.sendKeys(size+number);
		
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		WebElement toastmsg= driver.findElement(By.xpath("//div[@role='alert']")); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg= toastmsg.getText();
		System.out.println(msg);
		
		if (msg.contains(name+number)) {
			System.out.println("Campaign created");
			
		} else {
			
            System.out.println("Campaign not created");
            driver.findElement(By.xpath("//button[area-label='close']")).click();
		}
		
	
		
		/*if (msg.contains(name+number)) {
		System.out.println("Campaign created");
		
	} else {
		
        System.out.println("Campaign not created");
        driver.findElement(By.xpath("//button[area-label='close']")).click();
	}*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//validation
		 
	}
}
