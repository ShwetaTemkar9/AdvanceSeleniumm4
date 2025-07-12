package TestNg;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderusingExcel {
	

@Test(dataProvider = "getDataFromExcel")
public void getPriceofProd(String bName,String pName) throws InterruptedException {
	WebDriver driver= new EdgeDriver();
	//WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	driver.get("https://www.amazon.in/");
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys(bName,Keys.ENTER);
      
//capture product price
    //span[contains(text(),'iPhone 16 Pro 128 GB: 5G Mobile Phone with Camera Control')]/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span[1]
      
    String dyanmicXpath="//span[contains(text(),'"+pName+"')]/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span[1]";

    String price= driver.findElement(By.xpath(dyanmicXpath)).getText();
    System.out.println(price);

    
   Thread.sleep(4000);

   driver.quit();
}

@DataProvider
public Object[][]getDataFromExcel() throws EncryptedDocumentException, IOException{
	
	FileInputStream fis = new FileInputStream("C:\\Users\\siddh\\Desktop\\DDT\\iphoneName.xlsx");
	Workbook wb =WorkbookFactory.create(fis);
	   Sheet sh = wb.getSheet("Sheet1") ;
	   int rowcount = sh.getLastRowNum();
	   Object[][]objArray=new Object[rowcount][2];
	   for (int i = 0; i < rowcount; i++) {
		   objArray[i][0]=sh.getRow(i+1).getCell(0).getStringCellValue();
			objArray[i][1]=sh.getRow(i+1).getCell(1).getStringCellValue();
	   }
		return objArray;
	   }
}
