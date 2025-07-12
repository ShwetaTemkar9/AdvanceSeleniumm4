package TestNg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//Invocation count

public class HelperAttribute_InvocationCount {

	@Test(invocationCount = 3)
	public void login() throws InterruptedException{
		
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
	driver.get("https://www.instagram.com/accounts/login/?hl=en");
	Thread.sleep(200);
	driver.quit();
	}
}
