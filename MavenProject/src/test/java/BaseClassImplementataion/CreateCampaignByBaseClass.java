package BaseClassImplementataion;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import ListnerUtility.ListernerImplementationClass;
import PageObjectModel.Campaign;

//listerner tag mandatory
// listerener is used to capture ss when anthing is failed
@Listeners(ListernerImplementationClass.class)


public class CreateCampaignByBaseClass extends baseClass {

	@Test (groups="smoke")
	public void CreateCampaignBC() throws InterruptedException, EncryptedDocumentException, IOException{
		
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
		
	    driver.quit();
	}

}
