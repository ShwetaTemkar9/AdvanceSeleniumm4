package NinjaCRM;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Campaignlogin {

	/**
	 * @param args 
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("http://49.249.28.218:8098/create-campaign");
		driver.findElement(By.id("username")).sendKeys("rmgyantra ");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");

		driver.findElement(By.xpath("//button[text()='Sign In']")).click();

		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Save Water");

		WebElement targettextfield = driver.findElement(By.name("targetSize"));
		targettextfield.clear();
		targettextfield.sendKeys("500");

//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();

		Random r = new Random();
		r.nextInt(500);

		/*
		 * 
		 * driver.findElement(By.linkText("Products")).click();
		 * driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		 * driver.findElement(By.name("productName")).sendKeys("IM_PROD_212"+r.nextInt()
		 * );
		 * 
		 * WebElement quantity=driver.findElement(By.name("quantity"));
		 * quantity.clear(); quantity.sendKeys("12");
		 * 
		 * WebElement Category = driver.findElement(By.name("productCategory"));
		 * 
		 * Select dropdown = new Select(Category);
		 * dropdown.selectByContainsVisibleText("Electronics"); // Thread.sleep(1000);
		 * 
		 * driver.findElement(By.xpath("//input[@name='price']")).clear();
		 * driver.findElement(By.xpath("//input[@name='price']")).sendKeys("0.8");
		 * 
		 * WebElement vendordropdown= driver.findElement(By.name("vendorId")); Select
		 * dropdown2= new Select(vendordropdown); boolean ismultiple =
		 * dropdown2.isMultiple(); System.out.println(ismultiple);
		 * 
		 * dropdown2.selectByValue("VID_002"); //
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 * 
		 */
	}
}
