package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddCampaignbyExcel {
	public static void main(String[] args) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream("C:\\Users\\siddh\\Desktop\\DDT\\CampaignDetails.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet("Sheet1");
		Row r = s1.getRow(1);
		Cell cell1 = r.getCell(0);
		Cell cell2 = r.getCell(1);

		String CampaignName = cell1.getStringCellValue();
		String TargetSize = cell2.getStringCellValue();
		System.out.println(CampaignName);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		// Get data from properties file
		FileInputStream file = new FileInputStream("C:\\Users\\siddh\\Desktop\\DDT\\commondata.properties");
		// create an object of properties
		Properties prop = new Properties();
		// load the properties files through object into eclipse
		prop.load(file);
		// read the data with the key name
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		Random number = new Random();
		int num = number.nextInt(500);

		// Utilize property details
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(CampaignName + num);

		WebElement targettextfield = driver.findElement(By.name(TargetSize));
		targettextfield.clear();
		targettextfield.sendKeys("500");
	}
}
