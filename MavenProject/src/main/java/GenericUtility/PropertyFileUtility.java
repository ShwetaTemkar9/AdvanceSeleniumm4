package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./ConfigFiles/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.get(key).toString();
		return data;

	}

}
