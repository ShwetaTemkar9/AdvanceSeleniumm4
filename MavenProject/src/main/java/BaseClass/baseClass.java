package BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import GenericUtility.PropertyFileUtility;
import PageObjectModel.LoginPage;

public class baseClass {


	public PropertyFileUtility putil= new PropertyFileUtility();
	public WebDriver driver;
	public static WebDriver sDriver=null;//for listeners
	
	@BeforeSuite (groups={"smoke","regression"})
	public void configBS() {
		Reporter.log("EstablisH DB connectvity",true);
	}
	@BeforeTest (groups={"smoke","regression"})
	     public void configBT(){
		Reporter.log("Pre conditions",true);
	}
	@BeforeClass(groups={"smoke","regression"})
	public void configBC() throws IOException {
		
		String BROWSER= putil.getDataFromPropertiesFile("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (BROWSER.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (BROWSER.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new ChromeDriver();
        }
		
		//listrener
		sDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    	
		Reporter.log("before class",true);

	   
	}
	
	@BeforeMethod(groups={"smoke","regression"})
	public void configBM() throws IOException, InterruptedException {
		  String url= putil.getDataFromPropertiesFile("url");
		  String USERNAME= putil.getDataFromPropertiesFile("username");
		  String PASSWORD= putil.getDataFromPropertiesFile("password");
			driver.get(url);
			LoginPage lg = new LoginPage(driver);
			
			Thread.sleep(100);
			lg.LoginAction(USERNAME, PASSWORD);
			
		
	}
	
	@AfterMethod(groups="smoke")
	public void configAM() {
		Reporter.log("in after method",true);
	}
	@AfterClass(groups="smoke")
	public void configAC() {
		Reporter.log("in after class",true);
	}
	
	
	@AfterTest(groups="smoke")
    public void configAT(){
	Reporter.log("Post-conditions",true);
     }
	@AfterSuite
	public void configAS() {
	Reporter.log("disconnect DB connectvity",true);
     }
	
	
	}

