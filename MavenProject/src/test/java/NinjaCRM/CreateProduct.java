package NinjaCRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateProduct {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        Thread.sleep(3000);

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		  driver.findElement(By.name("productName")).sendKeys("IM_PROD_212");
		
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