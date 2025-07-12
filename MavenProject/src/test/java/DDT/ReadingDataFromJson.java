package DDT;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadingDataFromJson {

	public static void main(String[] args) throws IOException, ParseException {

		//use fileReader to access json file in java
	
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
    
      
       
    
    
    
     
     
	}

}
