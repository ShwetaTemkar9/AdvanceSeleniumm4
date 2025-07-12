package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	// generate random number
	public int getRandomNumber() {
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}

//get system date
	public String getSystemDate() {
		Date dateobj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(dateobj);
		return date;

	}

	// get future date
	public String getRequireDateddMMYYY(int days) {
		Date dateobj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(dateobj);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;

	}
	
	//get current sys date and time for screenshot
	public String getSysdateandTimeForScreenshot() {
		String dateNtime = new Date().toString();
		String dateforSS= dateNtime.replace(" ","_").replace(":", "_");
		return dateforSS;
		
	}
}
