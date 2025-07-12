package GenericiUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;

public class GU_PropertyUtility_implemetataion {
	public static void main(String[] args) throws IOException, InterruptedException {

		PropertyFileUtility putility = new PropertyFileUtility();
		String browser = putility.getDataFromPropertiesFile("browser");
		System.out.println(browser);
		String url = putility.getDataFromPropertiesFile("url");
		System.out.println(url);
		String username = putility.getDataFromPropertiesFile("username");
		System.out.println(username);
		String password = putility.getDataFromPropertiesFile("password");
		System.out.println(password);
		
		//calling JavaUtility
		JavaUtility jutil= new JavaUtility();
		String sysdate=jutil.getSystemDate();
		System.out.println(sysdate);

		int randomInt=jutil.getRandomNumber();
		
		String reqdate=jutil.getRequireDateddMMYYY(5);
		System.out.println(reqdate);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
       //WEB login
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        Thread.sleep(3000);
          //calling Excel Utility
        
          
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		
		   ExcelUtility exceldata= new ExcelUtility();
	        String CampaignName = exceldata.getdataFromExcel("Sheet1", 1, 0);
	          String TargetSize = exceldata.getdataFromExcel("Sheet1", 1, 1);
	      
	    driver.findElement(By.name("campaignName")).sendKeys(CampaignName+randomInt);


	    WebElement targettextfield = driver.findElement(By.name("targetSize"));
	    targettextfield.clear();
	    targettextfield.sendKeys(TargetSize);
	    
	    driver.findElement(By.name("expectedCloseDate")).click();
		
		
		
	
	}
}
