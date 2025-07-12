package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readingDataFromPoperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	

		FileInputStream file = new FileInputStream("C:\\Users\\siddh\\Desktop\\DDT\\commondata.properties");
		// create an object of properties
		Properties prop = new Properties();
		// load the properties files through object into eclipse
		prop.load(file);
		// read the data with the key name

		String browser = prop.getProperty("browser");
		System.out.println(browser);

		String url = prop.getProperty("url");
		System.out.println(url);
		String username = prop.getProperty("username");
		System.out.println(username);
		String password = prop.getProperty("password");
		System.out.println(password);

	}

}
