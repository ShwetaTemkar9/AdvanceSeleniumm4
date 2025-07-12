package PageObjectModel_Implementation;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import PageObjectModel.Campaign;
import PageObjectModel.LoginPage;
import WebDriverUtility.WebDriverUtility;
import net.bytebuddy.implementation.ToStringMethod;

public class CreateCampaign {

	
	public static void main (String[] args) throws IOException, InterruptedException {
		//PropertyFileUtility
	PropertyFileUtility putil= new PropertyFileUtility();
	
	String BROWSER= putil.getDataFromPropertiesFile("browser");
	String URL=putil.getDataFromPropertiesFile("url");
    String USERNAME= putil.getDataFromPropertiesFile("username");
	String PASSWORD= putil.getDataFromPropertiesFile("password");
	
	//WebDriver driver = new ChromeDriver();
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
     
     Campaign cg = new Campaign(driver);
	 	cg.createCam();
	 	Thread.sleep(4000);

	 	
	 	JavaUtility jutil = new JavaUtility();
	 	int randomnumder=jutil.getRandomNumber();
	    String date=jutil.getRequireDateddMMYYY(15);
		
		ExcelUtility excel = new ExcelUtility();
		String CAMname=excel.getdataFromExcel("Sheet1", 1, 0);
		
		String Targetsize=excel.getdataFromExcel("Sheet1", 1, 1);

		
		cg.CreateACampaign(CAMname,Targetsize,randomnumder,date);
  

	//validation 
		String msg=cg.validation();
		Boolean status = msg.contains(CAMname);
		
		
		//Hard Assert//pass case
		
		//Assert.assertEquals(true, status);
	// Reporter.log("suceessfully created campaign"+CAMname,true);

	 //hard assert //fail case

	//	Assert.assertEquals(false, status);
	// Reporter.log("suceessfully created campaign"+CAMname,true);

		
		//soft assert 
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(status, false ,"failed to create campaign");
		soft.assertAll();
	}
	
	
}
