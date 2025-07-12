package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDT_Campaignlogin {
//private static Object ;

public static void main(String[] args, Object date1) throws IOException   {

	FileInputStream file = new FileInputStream("C:\\Users\\siddh\\Desktop\\DDT\\commondata.properties");
	//create an object of properties
	Properties prop = new Properties();
	//load the properties files through object into eclipse
  prop.load(file);
  //read the data with the key name
 
String browser=prop.getProperty("browser");
System.out.println(browser);
    
 String url= prop.getProperty("url");
 System.out.println(url);
  String username=  prop.getProperty("username");
  System.out.println(username);
  String password=  prop.getProperty("password");
  System.out.println(password);
  
    WebDriver driver = null;
    
    //cross browser testing
    
   if (browser.equalsIgnoreCase("chrome")) {
	   driver=new ChromeDriver(); 
	   
   }else if(browser.equalsIgnoreCase("edge")) {
	   driver= new EdgeDriver();
	   
   }else if (browser.equalsIgnoreCase("FiReFox")) {
	   driver= new FirefoxDriver();}

   driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

     driver.get(url);

	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.xpath("//button[text()='Sign In']")).click();

    Random random = new Random();
    
    // Generate a random integer
    int randomInt = random.nextInt(100);
    System.out.println("Random Integer: " + randomInt);

	driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
    driver.findElement(By.name("campaignName")).sendKeys("Save Water "+randomInt);
    
	
    WebElement targettextfield = driver.findElement(By.name("targetSize"));
    targettextfield.clear();
    targettextfield.sendKeys("500");
    
    driver.findElement(By.name("expectedCloseDate")).click();

//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
   //capture current system date
	   Date date = new Date();
	   System.out.println(date);
	   SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");//use to set the date format
	 // System.out.println(currentdate);
	   
	   
	   //capture the current system date 30 days after
	   Calendar cal = sdf.getCalendar();
	   /System.out.println(cal);
	   cal.add(Calendar.DAY_OF_MONTH,40);
	   String expecteddate=sdf.format(cal.getTime());
	   System.out.println(expecteddate);
	   

       Calendar c = Calendar.getInstance(); 
  
       System.out.println("The Current Date is:" + c.getTime()); 
    
	
}
}
