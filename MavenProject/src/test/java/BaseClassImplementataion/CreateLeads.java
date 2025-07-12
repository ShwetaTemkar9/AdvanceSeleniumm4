package BaseClassImplementataion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLeads {

	
	public void CreateLeads() {
		
		WebDriver driver = new ChromeDriver();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		driver.findElement(By.name("name=\"contactName\"")).sendKeys("CONTACT");
		driver.findElement(By.name("organizationName")).sendKeys("NAME");
		driver.findElement(By.name("title")).sendKeys("ABC");
		
	}
}
