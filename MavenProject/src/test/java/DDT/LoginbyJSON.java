package DDT;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginbyJSON {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
      
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		ReadingDataFromJson json= new ReadingDataFromJson();
		FileReader fr = new FileReader("C:\\Users\\siddh\\Desktop\\DDT\\Jsondata.json");
	     
	     
		   //parse the json file into java files using JSONparcel 
		    //convert json to java 
		     JSONParser parse = new JSONParser();
		    Object object = parse.parse(fr);
		    
		   
		    //convert java to json 
		    //downcasting to json
		   
		      JSONObject jsonobj= (JSONObject)object;
		     
		      String brow=   jsonobj.get("browser").toString(); System.out.println(brow);
		      String url=   jsonobj.get("url").toString();
		      String un =jsonobj.get("username").toString();
		     String pw=  jsonobj.get("password").toString();
		
	     driver.get(url);

		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
	    driver.findElement(By.xpath("//button[text()='Sign In']")).click();

		
	}

}
